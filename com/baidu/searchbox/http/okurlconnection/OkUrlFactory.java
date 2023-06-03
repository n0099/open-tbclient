package com.baidu.searchbox.http.okurlconnection;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import okhttp3.OkHttpClient;
import okhttp3.internal.annotations.EverythingIsNonNull;
@EverythingIsNonNull
/* loaded from: classes3.dex */
public final class OkUrlFactory implements URLStreamHandlerFactory, Cloneable {
    public OkHttpClient client;
    public URLFilter urlFilter;

    public OkUrlFactory(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(final String str) {
        if (!"http".equals(str) && !"https".equals(str)) {
            return null;
        }
        return new URLStreamHandler() { // from class: com.baidu.searchbox.http.okurlconnection.OkUrlFactory.1
            @Override // java.net.URLStreamHandler
            public URLConnection openConnection(URL url, Proxy proxy) {
                return OkUrlFactory.this.open(url, proxy);
            }

            @Override // java.net.URLStreamHandler
            public int getDefaultPort() {
                if ("https".equals(str)) {
                    return 80;
                }
                if ("https".equals(str)) {
                    return 443;
                }
                throw new AssertionError();
            }

            @Override // java.net.URLStreamHandler
            public URLConnection openConnection(URL url) {
                return OkUrlFactory.this.open(url);
            }
        };
    }

    public HttpURLConnection open(URL url) {
        return open(url, this.client.proxy());
    }

    public OkUrlFactory setClient(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
        return this;
    }

    public void setUrlFilter(URLFilter uRLFilter) {
        this.urlFilter = uRLFilter;
    }

    public OkHttpClient client() {
        return this.client;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public OkUrlFactory m93clone() {
        return new OkUrlFactory(this.client);
    }

    public HttpURLConnection open(URL url, Proxy proxy) {
        String protocol = url.getProtocol();
        OkHttpClient build = this.client.newBuilder().proxy(proxy).build();
        if ("http".equals(protocol)) {
            return new OkHttpURLConnection(url, build, this.urlFilter);
        }
        if ("https".equals(protocol)) {
            return new OkHttpsURLConnection(url, build, this.urlFilter);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }
}
