package com.baidu.sumeru.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.baidu.sumeru.universalimageloader.core.DisplayImageOptions;
import com.baidu.sumeru.universalimageloader.core.assist.FailReason;
import com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener;
import com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingProgressListener;
import com.baidu.sumeru.universalimageloader.core.assist.ImageScaleType;
import com.baidu.sumeru.universalimageloader.core.assist.ImageSize;
import com.baidu.sumeru.universalimageloader.core.assist.LoadedFrom;
import com.baidu.sumeru.universalimageloader.core.assist.ViewScaleType;
import com.baidu.sumeru.universalimageloader.core.decode.ImageDecoder;
import com.baidu.sumeru.universalimageloader.core.decode.ImageDecodingInfo;
import com.baidu.sumeru.universalimageloader.core.download.ImageDownloader;
import com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware;
import com.baidu.sumeru.universalimageloader.utils.IoUtils;
import com.baidu.sumeru.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class LoadAndDisplayImageTask implements IoUtils.CopyListener, Runnable {
    private static final int BUFFER_SIZE = 32768;
    private static final String ERROR_POST_PROCESSOR_NULL = "Post-processor returned null [%s]";
    private static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final String ERROR_PROCESSOR_FOR_DISC_CACHE_NULL = "Bitmap processor for disc cache returned null [%s]";
    private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    private static final String LOG_CACHE_IMAGE_ON_DISC = "Cache image on disc [%s]";
    private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_DISC_CACHE = "Load image from disc cache [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    private static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISC = "Process image before cache on disc [%s]";
    private static final String LOG_RESIZE_CACHED_IMAGE_FILE = "Resize image in disc cache [%s]";
    private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    private final ImageLoaderConfiguration configuration;
    private final ImageDecoder decoder;
    private final ImageDownloader downloader;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    final ImageAware imageAware;
    private final ImageLoadingInfo imageLoadingInfo;
    final ImageLoadingListener listener;
    private LoadedFrom loadedFrom = LoadedFrom.NETWORK;
    private final String memoryCacheKey;
    private final ImageDownloader networkDeniedDownloader;
    final DisplayImageOptions options;
    final ImageLoadingProgressListener progressListener;
    private final ImageDownloader slowNetworkDownloader;
    private final ImageSize targetSize;
    final String uri;
    private final boolean writeLogs;

    public LoadAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = imageLoaderEngine;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
        this.configuration = imageLoaderEngine.configuration;
        this.downloader = this.configuration.downloader;
        this.networkDeniedDownloader = this.configuration.networkDeniedDownloader;
        this.slowNetworkDownloader = this.configuration.slowNetworkDownloader;
        this.decoder = this.configuration.decoder;
        this.writeLogs = this.configuration.writeLogs;
        this.uri = imageLoadingInfo.uri;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.imageAware = imageLoadingInfo.imageAware;
        this.targetSize = imageLoadingInfo.targetSize;
        this.options = imageLoadingInfo.options;
        this.listener = imageLoadingInfo.listener;
        this.progressListener = imageLoadingInfo.progressListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!waitIfPaused() && !delayIfNeed()) {
            ReentrantLock reentrantLock = this.imageLoadingInfo.loadFromUriLock;
            log(LOG_START_DISPLAY_IMAGE_TASK);
            if (reentrantLock.isLocked()) {
                log(LOG_WAITING_FOR_IMAGE_LOADED);
            }
            reentrantLock.lock();
            try {
                checkTaskNotActual();
                Bitmap bitmap = this.configuration.memoryCache.get(this.memoryCacheKey);
                if (bitmap == null) {
                    bitmap = tryLoadBitmap();
                    if (bitmap != null) {
                        checkTaskNotActual();
                        checkTaskInterrupted();
                        if (this.options.shouldPreProcess()) {
                            log(LOG_PREPROCESS_IMAGE);
                            bitmap = this.options.getPreProcessor().process(bitmap);
                            if (bitmap == null) {
                                L.e(ERROR_PRE_PROCESSOR_NULL, this.memoryCacheKey);
                            }
                        }
                        if (bitmap != null && this.options.isCacheInMemory()) {
                            log(LOG_CACHE_IMAGE_IN_MEMORY);
                            this.configuration.memoryCache.put(this.memoryCacheKey, bitmap);
                        }
                    } else {
                        return;
                    }
                } else {
                    this.loadedFrom = LoadedFrom.MEMORY_CACHE;
                    log(LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING);
                }
                if (bitmap != null && this.options.shouldPostProcess()) {
                    log(LOG_POSTPROCESS_IMAGE);
                    bitmap = this.options.getPostProcessor().process(bitmap);
                    if (bitmap == null) {
                        L.e(ERROR_POST_PROCESSOR_NULL, this.memoryCacheKey);
                    }
                }
                checkTaskNotActual();
                checkTaskInterrupted();
                reentrantLock.unlock();
                DisplayBitmapTask displayBitmapTask = new DisplayBitmapTask(bitmap, this.imageLoadingInfo, this.engine, this.loadedFrom);
                displayBitmapTask.setLoggingEnabled(this.writeLogs);
                if (this.options.isSyncLoading()) {
                    displayBitmapTask.run();
                } else {
                    this.handler.post(displayBitmapTask);
                }
            } catch (TaskCancelledException e) {
                fireCancelEvent();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private boolean waitIfPaused() {
        AtomicBoolean pause = this.engine.getPause();
        if (pause.get()) {
            synchronized (this.engine.getPauseLock()) {
                if (pause.get()) {
                    log(LOG_WAITING_FOR_RESUME);
                    try {
                        this.engine.getPauseLock().wait();
                        log(LOG_RESUME_AFTER_PAUSE);
                    } catch (InterruptedException e) {
                        L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                        return true;
                    }
                }
            }
        }
        return isTaskNotActual();
    }

    private boolean delayIfNeed() {
        if (this.options.shouldDelayBeforeLoading()) {
            log(LOG_DELAY_BEFORE_LOADING, Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey);
            try {
                Thread.sleep(this.options.getDelayBeforeLoading());
                return isTaskNotActual();
            } catch (InterruptedException e) {
                L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
        if (r0.getHeight() > 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap tryLoadBitmap() throws TaskCancelledException {
        Bitmap bitmap;
        File imageFileInDiscCache = getImageFileInDiscCache();
        try {
            try {
                String wrap = ImageDownloader.Scheme.FILE.wrap(imageFileInDiscCache.getAbsolutePath());
                if (imageFileInDiscCache.exists()) {
                    log(LOG_LOAD_IMAGE_FROM_DISC_CACHE);
                    this.loadedFrom = LoadedFrom.DISC_CACHE;
                    checkTaskNotActual();
                    bitmap = decodeImage(wrap);
                } else {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        if (bitmap.getWidth() > 0) {
                        }
                    } catch (IOException e) {
                        e = e;
                        L.e(e);
                        fireFailEvent(FailReason.FailType.IO_ERROR, e);
                        if (imageFileInDiscCache.exists()) {
                            imageFileInDiscCache.delete();
                        }
                        return bitmap;
                    } catch (IllegalStateException e2) {
                        fireFailEvent(FailReason.FailType.NETWORK_DENIED, null);
                        return bitmap;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        L.e(e);
                        fireFailEvent(FailReason.FailType.OUT_OF_MEMORY, e);
                        return bitmap;
                    } catch (Throwable th) {
                        th = th;
                        L.e(th);
                        fireFailEvent(FailReason.FailType.UNKNOWN, th);
                        return bitmap;
                    }
                }
                log(LOG_LOAD_IMAGE_FROM_NETWORK);
                this.loadedFrom = LoadedFrom.NETWORK;
                if (!this.options.isCacheOnDisc() || !tryCacheImageOnDisc(imageFileInDiscCache)) {
                    wrap = this.uri;
                }
                checkTaskNotActual();
                bitmap = decodeImage(wrap);
                if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                    fireFailEvent(FailReason.FailType.DECODING_ERROR, null);
                }
            } catch (TaskCancelledException e4) {
                throw e4;
            }
        } catch (IOException e5) {
            e = e5;
            bitmap = null;
        } catch (IllegalStateException e6) {
            bitmap = null;
        } catch (OutOfMemoryError e7) {
            e = e7;
            bitmap = null;
        } catch (Throwable th2) {
            th = th2;
            bitmap = null;
        }
        return bitmap;
    }

    private File getImageFileInDiscCache() {
        File parentFile;
        File file = this.configuration.discCache.get(this.uri);
        File parentFile2 = file.getParentFile();
        if ((parentFile2 == null || (!parentFile2.exists() && !parentFile2.mkdirs())) && (parentFile = (file = this.configuration.reserveDiscCache.get(this.uri)).getParentFile()) != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        return file;
    }

    private Bitmap decodeImage(String str) throws IOException {
        return this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, str, this.targetSize, this.imageAware.getScaleType(), getDownloader(), this.options));
    }

    private boolean tryCacheImageOnDisc(File file) throws TaskCancelledException {
        log(LOG_CACHE_IMAGE_ON_DISC);
        boolean z = false;
        try {
            z = downloadImage(file);
            if (z) {
                int i = this.configuration.maxImageWidthForDiscCache;
                int i2 = this.configuration.maxImageHeightForDiscCache;
                if (i > 0 || i2 > 0) {
                    log(LOG_RESIZE_CACHED_IMAGE_FILE);
                    z = resizeAndSaveImage(file, i, i2);
                }
                this.configuration.discCache.put(this.uri, file);
            }
        } catch (IOException e) {
            L.e(e);
            if (file.exists()) {
                file.delete();
            }
        }
        return z;
    }

    private boolean downloadImage(File file) throws IOException {
        InputStream stream = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 32768);
            boolean copyStream = IoUtils.copyStream(stream, bufferedOutputStream, this);
            IoUtils.closeSilently(bufferedOutputStream);
            return copyStream;
        } finally {
            IoUtils.closeSilently(stream);
        }
    }

    private boolean resizeAndSaveImage(File file, int i, int i2) throws IOException {
        Bitmap decode = this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), new ImageSize(i, i2), ViewScaleType.FIT_INSIDE, getDownloader(), new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build()));
        if (decode != null && this.configuration.processorForDiscCache != null) {
            log(LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISC);
            decode = this.configuration.processorForDiscCache.process(decode);
            if (decode == null) {
                L.e(ERROR_PROCESSOR_FOR_DISC_CACHE_NULL, this.memoryCacheKey);
            }
        }
        if (decode != null) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 32768);
            try {
                decode.compress(this.configuration.imageCompressFormatForDiscCache, this.configuration.imageQualityForDiscCache, bufferedOutputStream);
                IoUtils.closeSilently(bufferedOutputStream);
                decode.recycle();
            } catch (Throwable th) {
                IoUtils.closeSilently(bufferedOutputStream);
                throw th;
            }
        }
        return true;
    }

    @Override // com.baidu.sumeru.universalimageloader.utils.IoUtils.CopyListener
    public boolean onBytesCopied(int i, int i2) {
        return this.progressListener == null || fireProgressEvent(i, i2);
    }

    private boolean fireProgressEvent(final int i, final int i2) {
        if (this.options.isSyncLoading() || isTaskInterrupted() || isTaskNotActual()) {
            return false;
        }
        this.handler.post(new Runnable() { // from class: com.baidu.sumeru.universalimageloader.core.LoadAndDisplayImageTask.1
            @Override // java.lang.Runnable
            public void run() {
                LoadAndDisplayImageTask.this.progressListener.onProgressUpdate(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView(), i, i2);
            }
        });
        return true;
    }

    private void fireFailEvent(final FailReason.FailType failType, final Throwable th) {
        if (!this.options.isSyncLoading() && !isTaskInterrupted() && !isTaskNotActual()) {
            this.handler.post(new Runnable() { // from class: com.baidu.sumeru.universalimageloader.core.LoadAndDisplayImageTask.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LoadAndDisplayImageTask.this.options.shouldShowImageOnFail()) {
                        LoadAndDisplayImageTask.this.imageAware.setImageDrawable(LoadAndDisplayImageTask.this.options.getImageOnFail(LoadAndDisplayImageTask.this.configuration.resources));
                    }
                    LoadAndDisplayImageTask.this.listener.onLoadingFailed(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView(), new FailReason(failType, th));
                }
            });
        }
    }

    private void fireCancelEvent() {
        if (!this.options.isSyncLoading() && !isTaskInterrupted()) {
            this.handler.post(new Runnable() { // from class: com.baidu.sumeru.universalimageloader.core.LoadAndDisplayImageTask.3
                @Override // java.lang.Runnable
                public void run() {
                    LoadAndDisplayImageTask.this.listener.onLoadingCancelled(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView());
                }
            });
        }
    }

    private ImageDownloader getDownloader() {
        if (this.engine.isNetworkDenied()) {
            return this.networkDeniedDownloader;
        }
        if (this.engine.isSlowNetwork()) {
            return this.slowNetworkDownloader;
        }
        return this.downloader;
    }

    private void checkTaskNotActual() throws TaskCancelledException {
        checkViewCollected();
        checkViewReused();
    }

    private boolean isTaskNotActual() {
        return isViewCollected() || isViewReused();
    }

    private void checkViewCollected() throws TaskCancelledException {
        if (isViewCollected()) {
            throw new TaskCancelledException();
        }
    }

    private boolean isViewCollected() {
        if (this.imageAware.isCollected()) {
            log(LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED);
            return true;
        }
        return false;
    }

    private void checkViewReused() throws TaskCancelledException {
        if (isViewReused()) {
            throw new TaskCancelledException();
        }
    }

    private boolean isViewReused() {
        if (!this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware))) {
            log(LOG_TASK_CANCELLED_IMAGEAWARE_REUSED);
            return true;
        }
        return false;
    }

    private void checkTaskInterrupted() throws TaskCancelledException {
        if (isTaskInterrupted()) {
            throw new TaskCancelledException();
        }
    }

    private boolean isTaskInterrupted() {
        if (Thread.interrupted()) {
            log(LOG_TASK_INTERRUPTED);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLoadingUri() {
        return this.uri;
    }

    private void log(String str) {
        if (this.writeLogs) {
            L.d(str, this.memoryCacheKey);
        }
    }

    private void log(String str, Object... objArr) {
        if (this.writeLogs) {
            L.d(str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class TaskCancelledException extends Exception {
        TaskCancelledException() {
        }
    }
}
