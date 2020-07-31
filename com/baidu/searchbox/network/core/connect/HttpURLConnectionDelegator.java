package com.baidu.searchbox.network.core.connect;

import com.baidu.searchbox.network.core.RequestClient;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes5.dex */
public class HttpURLConnectionDelegator implements IHttpDelegator {
    @Override // com.baidu.searchbox.network.core.connect.IHttpDelegator
    public HttpURLConnection openHttpURLConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    @Override // com.baidu.searchbox.network.core.connect.IHttpDelegator
    public void setRequestClient(RequestClient requestClient) {
    }
}
