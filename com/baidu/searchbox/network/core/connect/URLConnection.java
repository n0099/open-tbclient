package com.baidu.searchbox.network.core.connect;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes11.dex */
public class URLConnection implements Connection {
    private HttpURLConnection mConnection;
    private int netEngine = 1;

    public URLConnection(HttpURLConnection httpURLConnection) {
        this.mConnection = httpURLConnection;
    }

    @Override // com.baidu.searchbox.network.core.connect.Connection
    public int getNetEngine() {
        return this.netEngine;
    }

    @Override // com.baidu.searchbox.network.core.connect.Connection
    public void setNetEngine(int i) {
        this.netEngine = i;
    }

    @Override // com.baidu.searchbox.network.core.connect.Connection
    public OutputStream getOutputStream() throws IOException {
        return this.mConnection.getOutputStream();
    }

    @Override // com.baidu.searchbox.network.core.connect.Connection
    public int getCode() throws IOException {
        return this.mConnection.getResponseCode();
    }

    @Override // com.baidu.searchbox.network.core.connect.Connection
    public String getMessage() throws IOException {
        return this.mConnection.getResponseMessage();
    }

    @Override // com.baidu.searchbox.network.core.connect.Connection
    public Map<String, List<String>> getHeaders() throws IOException {
        return this.mConnection.getHeaderFields();
    }

    @Override // com.baidu.searchbox.network.core.connect.Connection
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = this.mConnection.getInputStream();
        return (TextUtils.isEmpty(this.mConnection.getContentEncoding()) || !this.mConnection.getContentEncoding().contains("gzip")) ? inputStream : new GZIPInputStream(inputStream);
    }

    @Override // com.baidu.searchbox.network.core.connect.Connection
    public void disconnect() {
        if (this.mConnection != null) {
            try {
                this.mConnection.disconnect();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.mConnection != null) {
            this.mConnection.disconnect();
        }
    }
}
