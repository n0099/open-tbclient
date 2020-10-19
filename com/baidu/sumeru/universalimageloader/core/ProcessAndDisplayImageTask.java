package com.baidu.sumeru.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.baidu.sumeru.universalimageloader.core.assist.LoadedFrom;
import com.baidu.sumeru.universalimageloader.utils.L;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class ProcessAndDisplayImageTask implements Runnable {
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private final Bitmap bitmap;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    private final ImageLoadingInfo imageLoadingInfo;

    public ProcessAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, Bitmap bitmap, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = imageLoaderEngine;
        this.bitmap = bitmap;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.engine.configuration.writeLogs) {
            L.d(LOG_POSTPROCESS_IMAGE, this.imageLoadingInfo.memoryCacheKey);
        }
        DisplayBitmapTask displayBitmapTask = new DisplayBitmapTask(this.imageLoadingInfo.options.getPostProcessor().process(this.bitmap), this.imageLoadingInfo, this.engine, LoadedFrom.MEMORY_CACHE);
        displayBitmapTask.setLoggingEnabled(this.engine.configuration.writeLogs);
        if (this.imageLoadingInfo.options.isSyncLoading()) {
            displayBitmapTask.run();
        } else {
            this.handler.post(displayBitmapTask);
        }
    }
}
