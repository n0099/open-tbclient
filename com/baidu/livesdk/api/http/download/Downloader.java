package com.baidu.livesdk.api.http.download;
/* loaded from: classes7.dex */
public interface Downloader {
    void cancel();

    void download(DownloadCallback downloadCallback);
}
