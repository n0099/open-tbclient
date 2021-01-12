package com.baidu.android.imrtc.request;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.utils.LogUtils;
import java.io.IOException;
import java.net.SocketException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes5.dex */
public class HttpExecutor {
    private static final String TAG = "HttpExecutor";

    /* loaded from: classes5.dex */
    public interface HttpRequest {
        Map<String, String> getHeaders();

        String getHost();

        String getMediaType();

        String getMethod();

        byte[] getRequestParameter();

        boolean shouldAbort();
    }

    /* loaded from: classes5.dex */
    public interface ResponseHandler {
        void onFailure(int i, String str);

        void onSuccess(byte[] bArr);
    }

    public static void requestExecute(@NonNull HttpRequest httpRequest, @NonNull final ResponseHandler responseHandler) {
        try {
            byte[] requestParameter = httpRequest.getRequestParameter();
            if (requestParameter == null || requestParameter.length <= 0) {
                failedResponse(responseHandler, 10000, "request args exception");
            } else {
                OkHttpClient build = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).build();
                Request build2 = new Request.Builder().url(httpRequest.getHost()).post(RequestBody.create(MediaType.parse(httpRequest.getMediaType()), requestParameter)).build();
                LogUtils.d(TAG, "request url :" + httpRequest.getHost() + " , body :" + new String(httpRequest.getRequestParameter()));
                build.newCall(build2).enqueue(new Callback() { // from class: com.baidu.android.imrtc.request.HttpExecutor.1
                    @Override // okhttp3.Callback
                    public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
                        String str = "HttpRequest error :" + iOException.toString();
                        if (iOException instanceof SocketException) {
                            str = "HttpRequest SocketException :" + iOException.toString();
                        }
                        HttpExecutor.failedResponse(ResponseHandler.this, 10003, str);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(@NonNull Call call, @NonNull Response response) {
                        try {
                            if (response.code() != 200) {
                                HttpExecutor.failedResponse(ResponseHandler.this, response.code(), response.message());
                            } else if (response.body() == null) {
                                HttpExecutor.failedResponse(ResponseHandler.this, 10004, "response body empty");
                            } else {
                                byte[] bytes = response.body().bytes();
                                LogUtils.e(HttpExecutor.TAG, "onSuccess errorCode ：" + response.code() + ", errorMsg :" + new String(bytes));
                                ResponseHandler.this.onSuccess(bytes);
                            }
                        } catch (IOException e) {
                            HttpExecutor.failedResponse(ResponseHandler.this, 10001, "parse response exception ：" + e);
                        }
                    }
                });
            }
        } catch (Exception e) {
            failedResponse(responseHandler, 10004, "request exception :" + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void failedResponse(@NonNull ResponseHandler responseHandler, int i, String str) {
        responseHandler.onFailure(i, str);
        LogUtils.e(TAG, "failedResponse errorCode ：" + i + ", errorMsg :" + str);
    }
}
