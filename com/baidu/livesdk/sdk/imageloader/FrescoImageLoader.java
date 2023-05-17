package com.baidu.livesdk.sdk.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.livesdk.api.imageloader.ImageCache;
import com.baidu.livesdk.api.imageloader.ImageLoadListener;
import com.baidu.livesdk.api.imageloader.ImageLoader;
import com.baidu.livesdk.api.imageloader.ImageProcessor;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class FrescoImageLoader implements ImageLoader {
    public static final boolean DEBUG = false;
    public static final String TAG = "FrescoImageLoader";
    public ExecutorService mExecutors = Executors.newFixedThreadPool(5);
    public boolean mRelease = false;

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public void release() {
        this.mRelease = true;
        ExecutorService executorService = this.mExecutors;
        if (executorService != null) {
            executorService.shutdown();
            this.mExecutors = null;
        }
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public void loadImage(String str, ImageView imageView, ImageLoadListener imageLoadListener) {
        loadImage(str, imageView, 0, 0, imageLoadListener, null);
    }

    private CacheKey getCacheKey(String str) {
        return DefaultCacheKeyFactory.getInstance().getBitmapCacheKey(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH).build(), null);
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public Bitmap getBitmapFromCache(String str) {
        FileBinaryResource fileBinaryResource = (FileBinaryResource) Fresco.getImagePipelineFactory().getMainFileCache().getResource(getCacheKey(str));
        if (fileBinaryResource != null && fileBinaryResource.getFile() != null) {
            return BitmapFactory.decodeFile(fileBinaryResource.getFile().getAbsolutePath());
        }
        return null;
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public boolean hasCache(String str) {
        FileBinaryResource fileBinaryResource = (FileBinaryResource) Fresco.getImagePipelineFactory().getMainFileCache().getResource(getCacheKey(str));
        if (fileBinaryResource != null && fileBinaryResource.getFile() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void process(Bitmap bitmap, ImageProcessor imageProcessor) throws IOException {
        final ImageCache process = imageProcessor.process(bitmap);
        Fresco.getImagePipelineFactory().getMainFileCache().insert(getCacheKey(process.key), new WriterCallback() { // from class: com.baidu.livesdk.sdk.imageloader.FrescoImageLoader.2
            @Override // com.facebook.cache.common.WriterCallback
            public void write(OutputStream outputStream) throws IOException {
                process.bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                outputStream.flush();
            }
        });
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public void loadImage(String str, ImageView imageView) {
        loadImage(str, imageView, 0, 0, null, null);
    }

    @Override // com.baidu.livesdk.api.imageloader.ImageLoader
    public void loadImage(final String str, final ImageView imageView, int i, final int i2, final ImageLoadListener imageLoadListener, final ImageProcessor imageProcessor) {
        if (this.mRelease) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (imageLoadListener != null) {
                imageLoadListener.onLoadingFail(str);
            }
            if (imageView != null && i2 > 0) {
                imageView.setImageResource(i2);
            }
        } else if (imageView instanceof SimpleDraweeView) {
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) imageView;
            GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
            hierarchy.setFailureImage(i2);
            hierarchy.setPlaceholderImage(i);
            simpleDraweeView.setImageURI(Uri.parse(str));
        } else {
            if (imageView != null && i > 0) {
                imageView.setImageResource(i);
            }
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH).build(), this).subscribe(new BaseBitmapDataSubscriber() { // from class: com.baidu.livesdk.sdk.imageloader.FrescoImageLoader.1
                @Override // com.facebook.datasource.BaseDataSubscriber
                public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    ImageLoadListener imageLoadListener2 = imageLoadListener;
                    if (imageLoadListener2 != null) {
                        imageLoadListener2.onLoadingFail(str);
                    }
                    ImageView imageView2 = imageView;
                    if (imageView2 != null && i2 > 0) {
                        imageView2.post(new Runnable() { // from class: com.baidu.livesdk.sdk.imageloader.FrescoImageLoader.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                imageView.setImageResource(i2);
                            }
                        });
                    }
                }

                @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
                public void onNewResultImpl(final Bitmap bitmap) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        ImageProcessor imageProcessor2 = imageProcessor;
                        if (imageProcessor2 != null) {
                            try {
                                FrescoImageLoader.this.process(bitmap, imageProcessor2);
                            } catch (IOException unused) {
                            }
                        }
                        ImageLoadListener imageLoadListener2 = imageLoadListener;
                        if (imageLoadListener2 != null) {
                            imageLoadListener2.onLoadingComplete(str, bitmap);
                        }
                        ImageView imageView2 = imageView;
                        if (imageView2 != null) {
                            imageView2.post(new Runnable() { // from class: com.baidu.livesdk.sdk.imageloader.FrescoImageLoader.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    imageView.setImageBitmap(bitmap);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    ImageLoadListener imageLoadListener3 = imageLoadListener;
                    if (imageLoadListener3 != null) {
                        imageLoadListener3.onLoadingFail(str);
                    }
                    ImageView imageView3 = imageView;
                    if (imageView3 != null && i2 > 0) {
                        imageView3.post(new Runnable() { // from class: com.baidu.livesdk.sdk.imageloader.FrescoImageLoader.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                imageView.setImageResource(i2);
                            }
                        });
                    }
                }
            }, this.mExecutors);
        }
    }
}
