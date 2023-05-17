package com.baidu.searchbox.http.cronet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes3.dex */
public interface ICronet {
    public static final ICronet EMPTY = new ICronet() { // from class: com.baidu.searchbox.http.cronet.ICronet.1
        @Override // com.baidu.searchbox.http.cronet.ICronet
        public void initCronet() {
        }

        @Override // com.baidu.searchbox.http.cronet.ICronet
        public boolean isCronetInited() {
            return false;
        }

        @Override // com.baidu.searchbox.http.cronet.ICronet
        public HttpURLConnection openHttpURLConnection(URL url) throws IOException {
            return null;
        }
    };

    void initCronet();

    boolean isCronetInited();

    HttpURLConnection openHttpURLConnection(URL url) throws IOException;
}
