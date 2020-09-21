package com.baidu.sumeru.universalimageloader.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.sumeru.universalimageloader.cache.disc.DiscCacheAware;
import com.baidu.sumeru.universalimageloader.cache.disc.impl.FileCountLimitedDiscCache;
import com.baidu.sumeru.universalimageloader.cache.disc.impl.TotalSizeLimitedDiscCache;
import com.baidu.sumeru.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.baidu.sumeru.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.baidu.sumeru.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware;
import com.baidu.sumeru.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.baidu.sumeru.universalimageloader.core.assist.QueueProcessingType;
import com.baidu.sumeru.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.baidu.sumeru.universalimageloader.core.decode.BaseImageDecoder;
import com.baidu.sumeru.universalimageloader.core.decode.ImageDecoder;
import com.baidu.sumeru.universalimageloader.core.display.BitmapDisplayer;
import com.baidu.sumeru.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.baidu.sumeru.universalimageloader.core.download.BaseImageDownloader;
import com.baidu.sumeru.universalimageloader.core.download.ImageDownloader;
import com.baidu.sumeru.universalimageloader.utils.StorageUtils;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class DefaultConfigurationFactory {
    public static Executor createExecutor(int i, int i2, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue(), createThreadFactory(i2));
    }

    public static FileNameGenerator createFileNameGenerator() {
        return new HashCodeFileNameGenerator();
    }

    public static DiscCacheAware createDiscCache(Context context, FileNameGenerator fileNameGenerator, int i, int i2) {
        if (i > 0) {
            return new TotalSizeLimitedDiscCache(StorageUtils.getIndividualCacheDirectory(context), fileNameGenerator, i);
        }
        if (i2 > 0) {
            return new FileCountLimitedDiscCache(StorageUtils.getIndividualCacheDirectory(context), fileNameGenerator, i2);
        }
        return new UnlimitedDiscCache(StorageUtils.getCacheDirectory(context), fileNameGenerator);
    }

    public static DiscCacheAware createReserveDiscCache(File file) {
        File file2 = new File(file, "uil-images");
        if (file2.exists() || file2.mkdir()) {
            file = file2;
        }
        return new TotalSizeLimitedDiscCache(file, 2097152);
    }

    public static MemoryCacheAware<String, Bitmap> createMemoryCache(int i) {
        if (i == 0) {
            i = (int) (Runtime.getRuntime().maxMemory() / 8);
        }
        return new LruMemoryCache(i);
    }

    public static ImageDownloader createImageDownloader(Context context) {
        return new BaseImageDownloader(context);
    }

    public static ImageDecoder createImageDecoder(boolean z) {
        return new BaseImageDecoder(z);
    }

    public static BitmapDisplayer createBitmapDisplayer() {
        return new SimpleBitmapDisplayer();
    }

    private static ThreadFactory createThreadFactory(int i) {
        return new DefaultThreadFactory(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final int threadPriority;

        DefaultThreadFactory(int i) {
            this.threadPriority = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "uil-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }
}
