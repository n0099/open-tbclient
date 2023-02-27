package com.baidu.searchbox.bddownload.core.connection;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.RedirectUtil;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class DownloadHttpManagerConnection implements DownloadConnection, DownloadConnection.Connected {
    public static final String TAG = "DownloadHttpManagerConnection";
    public Request request;
    @NonNull
    public final GetRequest.GetRequestBuilder requestBuilder;
    public Response response;

    public DownloadHttpManagerConnection(@NonNull GetRequest.GetRequestBuilder getRequestBuilder) {
        this.requestBuilder = getRequestBuilder;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public String getRequestProperty(String str) {
        Request request = this.request;
        if (request != null) {
            return request.header(str);
        }
        return this.requestBuilder.build().getOkRequest().header(str);
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
        Request request = this.request;
        if (request != null) {
            request.newBuilder().method(str, null);
            return true;
        }
        this.requestBuilder.build().getOkRequest().newBuilder().method(str, null);
        return true;
    }

    /* loaded from: classes2.dex */
    public static class Factory implements DownloadConnection.Factory {
        @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Factory
        public DownloadConnection create(String str) throws IOException {
            Util.d(DownloadHttpManagerConnection.TAG, " create url = " + str);
            return new DownloadHttpManagerConnection(HttpManager.getDefault(BdDownload.with().context()).getRequest().url(str));
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public void addHeader(String str, String str2) {
        Util.d(TAG, " addHeader name = " + str + "  value = " + str2);
        this.requestBuilder.addHeader(str, str2);
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public DownloadConnection.Connected execute() throws IOException {
        GetRequest build = this.requestBuilder.build();
        this.request = build.getOkRequest();
        this.response = build.executeSync();
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
        return this.requestBuilder.build().getOkRequest().headers().toMultimap();
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
            response.close();
        }
        this.response = null;
    }
}
