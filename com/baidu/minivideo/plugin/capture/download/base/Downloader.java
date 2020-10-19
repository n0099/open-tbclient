package com.baidu.minivideo.plugin.capture.download.base;
/* loaded from: classes17.dex */
public interface Downloader {

    /* loaded from: classes17.dex */
    public interface OnDownloaderDestroyedListener {
        void onDestroyed(String str, Downloader downloader);
    }

    void cancel();

    boolean isRunning();

    void onDestroy();

    void pause();

    void start();
}
