package com.baidu.sumeru.universalimageloader.core.download;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
/* loaded from: classes12.dex */
public class HttpClientImageDownloader extends BaseImageDownloader {
    private HttpClient httpClient;

    public HttpClientImageDownloader(Context context, HttpClient httpClient) {
        super(context);
        this.httpClient = httpClient;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.download.BaseImageDownloader
    protected InputStream getStreamFromNetwork(String str, Object obj) throws IOException {
        return new BufferedHttpEntity(this.httpClient.execute(new HttpGet(str)).getEntity()).getContent();
    }
}
