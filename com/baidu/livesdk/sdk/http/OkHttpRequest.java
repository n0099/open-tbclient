package com.baidu.livesdk.sdk.http;

import android.text.TextUtils;
import com.baidu.livesdk.api.http.HttpRequest;
import com.baidu.livesdk.api.http.HttpRequestEntity;
import com.baidu.livesdk.api.http.HttpResponse;
import com.baidu.livesdk.api.http.ResponseCallback;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class OkHttpRequest implements HttpRequest {
    public ResponseCallback mCallback;
    public OkHttpClient mClient;
    public HttpRequestEntity mEntity;
    public Call mRequestCall;

    @Override // com.baidu.livesdk.api.http.HttpRequest
    public void cancel() {
        Call call = this.mRequestCall;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.baidu.livesdk.api.http.HttpRequest
    public HttpRequestEntity getHttpRequestEntity() {
        return this.mEntity;
    }

    @Override // com.baidu.livesdk.api.http.HttpRequest
    public HttpResponse requestSync() throws IOException {
        Call requestBuild = requestBuild();
        this.mRequestCall = requestBuild;
        return getHttpResponse(requestBuild.execute());
    }

    private Call requestBuild() {
        if (this.mClient != null && this.mEntity != null) {
            Request.Builder url = new Request.Builder().url(this.mEntity.getUrl());
            if (this.mEntity.getHeader() != null) {
                for (Map.Entry<String, String> entry : this.mEntity.getHeader().entrySet()) {
                    url.addHeader(entry.getKey(), entry.getValue());
                }
            }
            int method = this.mEntity.getMethod();
            if (method != 0) {
                if (method != 1) {
                    url.get();
                } else {
                    RequestBody requestBody = null;
                    if (this.mEntity.getPostParams() != null) {
                        if (TextUtils.isEmpty(this.mEntity.getMediaType())) {
                            FormBody.Builder builder = new FormBody.Builder();
                            for (Map.Entry<String, String> entry2 : this.mEntity.getPostParams().entrySet()) {
                                builder.add(entry2.getKey(), entry2.getValue());
                            }
                            requestBody = builder.build();
                        } else {
                            String str = "";
                            for (Map.Entry<String, String> entry3 : this.mEntity.getPostParams().entrySet()) {
                                str = (str + entry3.getKey() + "=" + entry3.getValue()) + "&";
                            }
                            requestBody = RequestBody.create(MediaType.parse(this.mEntity.getMediaType()), str.substring(0, str.length() - 1));
                        }
                    }
                    if (requestBody != null) {
                        url.post(requestBody);
                    }
                }
            } else {
                url.get();
            }
            return this.mClient.newCall(url.build());
        }
        throw new NullPointerException("params is null");
    }

    public HttpResponse getHttpResponse(Response response) throws IOException {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setResponseCode(response.code());
        httpResponse.setHeaders(response.headers().toMultimap());
        if (response.body() != null) {
            httpResponse.setContent(response.body().string());
        }
        return httpResponse;
    }

    @Override // com.baidu.livesdk.api.http.HttpRequest
    public HttpRequest request(ResponseCallback responseCallback) {
        this.mCallback = responseCallback;
        Call requestBuild = requestBuild();
        this.mRequestCall = requestBuild;
        requestBuild.enqueue(new Callback() { // from class: com.baidu.livesdk.sdk.http.OkHttpRequest.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                OkHttpRequest.this.onFailureCallback(call, iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                OkHttpRequest.this.onResponseCallback(call, response);
            }
        });
        return this;
    }

    @Override // com.baidu.livesdk.api.http.HttpRequest
    public void setHttpRequestEntity(HttpRequestEntity httpRequestEntity) {
        this.mEntity = httpRequestEntity;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.mClient = okHttpClient;
    }

    public void onFailureCallback(Call call, IOException iOException) {
        int i;
        if (this.mCallback != null) {
            if (iOException instanceof SocketTimeoutException) {
                i = 1;
            } else if (iOException instanceof ConnectException) {
                i = 2;
            } else {
                i = 3;
            }
            this.mCallback.onFail(i, iOException);
        }
    }

    public void onResponseCallback(Call call, Response response) {
        try {
            if (this.mCallback != null) {
                this.mCallback.onSuccess(getHttpResponse(response));
            }
        } catch (Exception e) {
            ResponseCallback responseCallback = this.mCallback;
            if (responseCallback != null) {
                responseCallback.onFail(-1, e);
            }
        }
    }
}
