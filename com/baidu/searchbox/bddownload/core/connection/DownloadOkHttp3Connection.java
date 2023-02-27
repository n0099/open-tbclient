package com.baidu.searchbox.bddownload.core.connection;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.RedirectUtil;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class DownloadOkHttp3Connection implements DownloadConnection, DownloadConnection.Connected {
    public static final String TAG = "DownloadOkHttp3Connection";
    @NonNull
    public final OkHttpClient client;
    public Request request;
    @NonNull
    public final Request.Builder requestBuilder;
    public Response response;

    /* loaded from: classes2.dex */
    public static class Factory implements DownloadConnection.Factory {
        public volatile OkHttpClient client;
        public OkHttpClient.Builder clientBuilder;

        @NonNull
        public OkHttpClient.Builder builder() {
            if (this.clientBuilder == null) {
                this.clientBuilder = new OkHttpClient.Builder();
            }
            return this.clientBuilder;
        }

        @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Factory
        public DownloadConnection create(String str) throws IOException {
            OkHttpClient okHttpClient;
            if (this.client == null) {
                synchronized (Factory.class) {
                    if (this.client == null) {
                        if (this.clientBuilder != null) {
                            okHttpClient = this.clientBuilder.build();
                        } else {
                            okHttpClient = new OkHttpClient();
                        }
                        this.client = okHttpClient;
                        this.clientBuilder = null;
                    }
                }
            }
            Util.d(DownloadOkHttp3Connection.TAG, " create url = " + str);
            return new DownloadOkHttp3Connection(this.client, str);
        }

        public Factory setBuilder(@NonNull OkHttpClient.Builder builder) {
            this.clientBuilder = builder;
            return this;
        }
    }

    public DownloadOkHttp3Connection(@NonNull OkHttpClient okHttpClient, @NonNull String str) {
        this(okHttpClient, new Request.Builder().url(str));
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public void addHeader(String str, String str2) {
        Util.d(TAG, " addHeader name = " + str + "  value = " + str2);
        this.requestBuilder.addHeader(str, str2);
    }

    public DownloadOkHttp3Connection(@NonNull OkHttpClient okHttpClient, @NonNull Request.Builder builder) {
        this.client = okHttpClient;
        this.requestBuilder = builder;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public DownloadConnection.Connected execute() throws IOException {
        Request build = this.requestBuilder.build();
        this.request = build;
        this.response = this.client.newCall(build).execute();
        Util.d(TAG, "execute ");
        return this;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public InputStream getInputStream() throws IOException {
        Response response = this.response;
        if (response != null) {
            ResponseBody body = response.body();
            if (body != null) {
                return body.byteStream();
            }
            throw new IOException("no body found on response!");
        }
        throw new IOException("Please invoke execute first!");
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public String getRedirectLocation() {
        Response priorResponse = this.response.priorResponse();
        if (priorResponse != null && this.response.isSuccessful() && RedirectUtil.isRedirect(priorResponse.code())) {
            return this.response.request().url().toString();
        }
        return null;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public Map<String, List<String>> getRequestProperties() {
        Request request = this.request;
        if (request != null) {
            return request.headers().toMultimap();
        }
        return this.requestBuilder.build().headers().toMultimap();
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public int getResponseCode() throws IOException {
        if (this.response != null) {
            Util.d(TAG, "getResponseCode " + this.response.code());
            return this.response.code();
        }
        throw new IOException("Please invoke execute first!");
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public Map<String, List<String>> getResponseHeaderFields() {
        Response response = this.response;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public void release() {
        this.request = null;
        Response response = this.response;
        if (response != null) {
            try {
                response.close();
            } catch (Throwable th) {
                Util.d(TAG, "DownloadOkHttp3Connection connection release exception " + th.toString());
            }
        }
        this.response = null;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public String getRequestProperty(String str) {
        Request request = this.request;
        if (request != null) {
            return request.header(str);
        }
        return this.requestBuilder.build().header(str);
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public String getResponseHeaderField(String str) {
        Response response = this.response;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public boolean setRequestMethod(@NonNull String str) throws ProtocolException {
        this.requestBuilder.method(str, null);
        return true;
    }
}
