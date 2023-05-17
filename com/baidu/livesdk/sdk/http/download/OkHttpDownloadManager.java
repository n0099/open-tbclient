package com.baidu.livesdk.sdk.http.download;

import com.baidu.livesdk.api.http.HttpRequestEntity;
import com.baidu.livesdk.api.http.download.DownloadEntity;
import com.baidu.livesdk.api.http.download.DownloadManager;
import com.baidu.livesdk.api.http.download.Downloader;
import com.baidu.livesdk.sdk.http.OkHttpRequestManager;
/* loaded from: classes3.dex */
public class OkHttpDownloadManager extends OkHttpRequestManager implements DownloadManager {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.livesdk.sdk.http.OkHttpRequestManager
    public OkHttpDownloader createRequest() {
        return new OkHttpDownloader();
    }

    @Override // com.baidu.livesdk.api.http.download.DownloadManager
    public Downloader getLoader(DownloadEntity downloadEntity) {
        return getRequest((HttpRequestEntity) downloadEntity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.livesdk.sdk.http.OkHttpRequestManager, com.baidu.livesdk.api.http.HttpRequestManager
    public OkHttpDownloader getRequest(HttpRequestEntity httpRequestEntity) {
        return (OkHttpDownloader) super.getRequest(httpRequestEntity);
    }
}
