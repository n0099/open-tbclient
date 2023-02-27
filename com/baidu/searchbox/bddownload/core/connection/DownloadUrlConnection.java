package com.baidu.searchbox.bddownload.core.connection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.IRedirectHandler;
import com.baidu.searchbox.bddownload.RedirectUtil;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class DownloadUrlConnection implements DownloadConnection, DownloadConnection.Connected {
    public static final String TAG = "DownloadUrlConnection";
    public Configuration configuration;
    public URLConnection connection;
    public IRedirectHandler redirectHandler;
    public URL url;

    /* loaded from: classes2.dex */
    public static class Factory implements DownloadConnection.Factory {
        public final Configuration configuration;

        public Factory() {
            this(null);
        }

        public Factory(Configuration configuration) {
            Util.d(DownloadUrlConnection.TAG, "Factory ");
            this.configuration = configuration;
        }

        @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Factory
        public DownloadConnection create(String str) throws IOException {
            return new DownloadUrlConnection(str, this.configuration);
        }

        public DownloadConnection create(URL url) throws IOException {
            return new DownloadUrlConnection(url, this.configuration);
        }
    }

    /* loaded from: classes2.dex */
    public static final class RedirectHandler implements IRedirectHandler {
        public String redirectLocation;

        @Override // com.baidu.searchbox.bddownload.IRedirectHandler
        @Nullable
        public String getRedirectLocation() {
            return this.redirectLocation;
        }

        @Override // com.baidu.searchbox.bddownload.IRedirectHandler
        public void handleRedirect(DownloadConnection downloadConnection, DownloadConnection.Connected connected, Map<String, List<String>> map) throws IOException {
            DownloadUrlConnection downloadUrlConnection = (DownloadUrlConnection) downloadConnection;
            int i = 0;
            for (int responseCode = connected.getResponseCode(); RedirectUtil.isRedirect(responseCode); responseCode = downloadUrlConnection.getResponseCode()) {
                downloadUrlConnection.release();
                i++;
                if (i <= 10) {
                    this.redirectLocation = RedirectUtil.getRedirectedUrl(connected, responseCode);
                    downloadUrlConnection.url = new URL(this.redirectLocation);
                    downloadUrlConnection.configUrlConnection();
                    Util.addRequestHeaderFields(map, downloadUrlConnection);
                    downloadUrlConnection.connection.connect();
                } else {
                    throw new ProtocolException("Too many redirect requests: " + i);
                }
            }
        }
    }

    public DownloadUrlConnection(String str) throws IOException {
        this(str, (Configuration) null);
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public String getRequestProperty(String str) {
        return this.connection.getRequestProperty(str);
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public String getResponseHeaderField(String str) {
        return this.connection.getHeaderField(str);
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public boolean setRequestMethod(@NonNull String str) throws ProtocolException {
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setRequestMethod(str);
            return true;
        }
        return false;
    }

    /* loaded from: classes2.dex */
    public static class Configuration {
        public Integer connectTimeout;
        public Proxy proxy;
        public Integer readTimeout;

        public Configuration connectTimeout(int i) {
            this.connectTimeout = Integer.valueOf(i);
            return this;
        }

        public Configuration proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Configuration readTimeout(int i) {
            this.readTimeout = Integer.valueOf(i);
            return this;
        }
    }

    public DownloadUrlConnection(String str, Configuration configuration) throws IOException {
        this(new URL(str), configuration);
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public void addHeader(String str, String str2) {
        this.connection.addRequestProperty(str, str2);
    }

    public DownloadUrlConnection(URL url, Configuration configuration) throws IOException {
        this(url, configuration, new RedirectHandler());
    }

    public DownloadUrlConnection(URL url, Configuration configuration, IRedirectHandler iRedirectHandler) throws IOException {
        this.configuration = configuration;
        this.url = url;
        this.redirectHandler = iRedirectHandler;
        configUrlConnection();
    }

    public DownloadUrlConnection(URLConnection uRLConnection) {
        this(uRLConnection, new RedirectHandler());
    }

    public DownloadUrlConnection(URLConnection uRLConnection, IRedirectHandler iRedirectHandler) {
        this.connection = uRLConnection;
        this.url = uRLConnection.getURL();
        this.redirectHandler = iRedirectHandler;
    }

    public void configUrlConnection() throws IOException {
        Util.d(TAG, "config connection for " + this.url);
        Configuration configuration = this.configuration;
        if (configuration != null && configuration.proxy != null) {
            this.connection = this.url.openConnection(this.configuration.proxy);
        } else {
            this.connection = this.url.openConnection();
        }
        Configuration configuration2 = this.configuration;
        if (configuration2 != null) {
            if (configuration2.readTimeout != null) {
                this.connection.setReadTimeout(this.configuration.readTimeout.intValue());
            }
            if (this.configuration.connectTimeout != null) {
                this.connection.setConnectTimeout(this.configuration.connectTimeout.intValue());
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public DownloadConnection.Connected execute() throws IOException {
        Map<String, List<String>> requestProperties = getRequestProperties();
        this.connection.connect();
        this.redirectHandler.handleRedirect(this, this, requestProperties);
        return this;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public InputStream getInputStream() throws IOException {
        return this.connection.getInputStream();
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public String getRedirectLocation() {
        return this.redirectHandler.getRedirectLocation();
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.connection.getRequestProperties();
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.connection;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        Util.d(TAG, "getResponseCode " + this.url);
        return 0;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public Map<String, List<String>> getResponseHeaderFields() {
        return this.connection.getHeaderFields();
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public void release() {
        try {
            InputStream inputStream = this.connection.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
    }
}
