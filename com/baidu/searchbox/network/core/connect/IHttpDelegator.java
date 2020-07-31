package com.baidu.searchbox.network.core.connect;

import com.baidu.searchbox.network.core.RequestClient;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes5.dex */
public interface IHttpDelegator {
    HttpURLConnection openHttpURLConnection(URL url) throws IOException;

    void setRequestClient(RequestClient requestClient);
}
