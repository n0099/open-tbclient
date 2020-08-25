package com.baidu.minivideo.plugin.capture.download;
/* loaded from: classes19.dex */
public class DownloadConfig {
    public static final int DEFAULT_MAX_THREAD_NUMBER = 10;
    public static final int DEFAULT_THREAD_NUMBER = 2;
    private int maxThreadNum = 10;
    private int threadNum = 2;

    public int getMaxThreadNum() {
        return this.maxThreadNum;
    }

    public void setMaxThreadNum(int i) {
        this.maxThreadNum = i;
    }

    public int getThreadNum() {
        return this.threadNum;
    }

    public void setThreadNum(int i) {
        this.threadNum = i;
    }
}
