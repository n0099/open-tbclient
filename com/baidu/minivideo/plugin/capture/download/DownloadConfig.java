package com.baidu.minivideo.plugin.capture.download;
/* loaded from: classes2.dex */
public class DownloadConfig {
    public static final int DEFAULT_MAX_THREAD_NUMBER = 10;
    public static final int DEFAULT_THREAD_NUMBER = 2;
    public int maxThreadNum = 10;
    public int threadNum = 2;

    public int getMaxThreadNum() {
        return this.maxThreadNum;
    }

    public int getThreadNum() {
        return this.threadNum;
    }

    public void setMaxThreadNum(int i) {
        this.maxThreadNum = i;
    }

    public void setThreadNum(int i) {
        this.threadNum = i;
    }
}
