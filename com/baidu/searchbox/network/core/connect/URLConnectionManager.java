package com.baidu.searchbox.network.core.connect;

import android.text.TextUtils;
import com.baidu.searchbox.network.core.Headers;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestClient;
import com.baidu.searchbox.network.core.http.HttpMethod;
import com.baidu.searchbox.network.core.internal.Util;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProxySelector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okio.BufferedSink;
import okio.Okio;
/* loaded from: classes12.dex */
public class URLConnectionManager implements IConnect {
    private static final String TAG = URLConnectionManager.class.getSimpleName();
    private Connection connection;
    private RequestClient requestClient;

    public Connection getConnection() {
        return this.connection;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private URLConnectionManager(Builder builder) {
        this.requestClient = builder.requestClient;
        if (this.requestClient == null) {
            throw new NullPointerException("URLConnectionManager constructor can't be null!");
        }
        ProxySelector.setDefault(this.requestClient.proxySelector());
    }

    @Override // com.baidu.searchbox.network.core.connect.IConnect
    public Connection connect(Request request) throws IOException {
        HttpURLConnection openHttpURLConnection = this.requestClient.httpDelegator().openHttpURLConnection(request.url().url());
        boolean equals = TextUtils.equals(openHttpURLConnection.getClass().getSimpleName(), "CronetHttpURLConnection");
        int i = !equals ? 1 : 3;
        openHttpURLConnection.setConnectTimeout(request.httpRequest().getConnectionTimeout());
        openHttpURLConnection.setReadTimeout(request.httpRequest().getReadTimeout());
        openHttpURLConnection.setInstanceFollowRedirects(request.httpRequest().isFollowRedirects());
        if ("https".equalsIgnoreCase(request.url().scheme()) && !equals) {
            SSLSocketFactory sslSocketFactory = this.requestClient.sslSocketFactory();
            if (sslSocketFactory != null) {
                ((HttpsURLConnection) openHttpURLConnection).setSSLSocketFactory(sslSocketFactory);
            }
            HostnameVerifier hostnameVerifier = this.requestClient.hostnameVerifier();
            if (hostnameVerifier != null) {
                ((HttpsURLConnection) openHttpURLConnection).setHostnameVerifier(hostnameVerifier);
            }
        }
        String method = request.method();
        openHttpURLConnection.setRequestMethod(method);
        openHttpURLConnection.setDoInput(true);
        boolean permitsRequestBody = HttpMethod.permitsRequestBody(method);
        openHttpURLConnection.setDoOutput(permitsRequestBody);
        Headers headers = request.headers();
        if (permitsRequestBody) {
            openHttpURLConnection.setFixedLengthStreamingMode((int) request.body().contentLength());
        }
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            openHttpURLConnection.setRequestProperty(headers.name(i2), headers.value(i2));
        }
        if (permitsRequestBody) {
            writeBody(request, openHttpURLConnection);
        }
        openHttpURLConnection.connect();
        this.connection = new URLConnection(openHttpURLConnection);
        this.connection.setNetEngine(i);
        return this.connection;
    }

    private void writeBody(Request request, HttpURLConnection httpURLConnection) throws IOException {
        BufferedSink bufferedSink = null;
        try {
            try {
                bufferedSink = Okio.buffer(Okio.sink(httpURLConnection.getOutputStream()));
                request.body().writeTo(bufferedSink);
                bufferedSink.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        } finally {
            Util.closeQuietly(bufferedSink);
        }
    }

    /* loaded from: classes12.dex */
    public static class Builder {
        private RequestClient requestClient;

        private Builder() {
        }

        public Builder requestClient(RequestClient requestClient) {
            this.requestClient = requestClient;
            return this;
        }

        public URLConnectionManager build() {
            return new URLConnectionManager(this);
        }
    }
}
