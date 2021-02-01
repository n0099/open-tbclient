package com.baidu.android.imrtc.request;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcManager;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.TaskManager;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class HttpExecutor {
    private static final String TAG = "HttpExecutor";
    private static volatile HttpExecutor mInstance;
    private OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpExecutorLogger()).connectTimeout(5, TimeUnit.SECONDS).readTimeout(5, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS).build();

    /* loaded from: classes4.dex */
    public interface HttpRequest {
        Map<String, String> getHeaders();

        String getHost();

        String getMediaType();

        String getMethod();

        byte[] getRequestParameter();

        boolean shouldAbort();
    }

    /* loaded from: classes4.dex */
    public interface ResponseHandler {
        void onFailure(int i, String str);

        void onSuccess(byte[] bArr);
    }

    public static HttpExecutor getInstance() {
        if (mInstance == null) {
            synchronized (HttpExecutor.class) {
                if (mInstance == null) {
                    mInstance = new HttpExecutor();
                }
            }
        }
        return mInstance;
    }

    public void execute(@NonNull final HttpRequest httpRequest, @NonNull final ResponseHandler responseHandler) {
        TaskManager.getInstance().submitForNetWork(new Runnable() { // from class: com.baidu.android.imrtc.request.HttpExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                HttpExecutor.this.requestExecute(httpRequest, responseHandler);
            }
        });
    }

    public void requestExecute(@NonNull HttpRequest httpRequest, @NonNull ResponseHandler responseHandler) {
        try {
            byte[] requestParameter = httpRequest.getRequestParameter();
            if (requestParameter == null || requestParameter.length <= 0) {
                failedResponse(responseHandler, 10000, "request args exception");
            } else {
                Request build = new Request.Builder().url(httpRequest.getHost()).post(RequestBody.create(MediaType.parse(httpRequest.getMediaType()), requestParameter)).build();
                LogUtils.d(TAG, ">>>>>request url :" + httpRequest.getHost() + " , body :" + new String(httpRequest.getRequestParameter()));
                Call newCall = this.okHttpClient.newCall(build);
                try {
                    BIMRtcManager.mBIMRtcEvent.ext = "call.exe";
                    Response execute = newCall.execute();
                    if (execute.code() != 200) {
                        failedResponse(responseHandler, execute.code(), execute.message());
                    } else if (execute.body() == null) {
                        failedResponse(responseHandler, 10001, "response body empty");
                    } else {
                        byte[] bytes = execute.body().bytes();
                        LogUtils.e(TAG, ">>>>>onSuccess errorCode ：" + execute.code() + ", errorMsg :" + new String(bytes));
                        responseHandler.onSuccess(bytes);
                    }
                } catch (IOException e) {
                    failedResponse(responseHandler, 10003, e.getMessage());
                    LogUtils.e(TAG, "exception :" + e.getMessage());
                }
            }
        } catch (Exception e2) {
            failedResponse(responseHandler, 10004, "request exception :" + e2);
        }
    }

    private static void failedResponse(@NonNull ResponseHandler responseHandler, int i, String str) {
        responseHandler.onFailure(i, str);
        BIMRtcManager.mBIMRtcEvent.ext = "fail_err=" + i;
        LogUtils.e(TAG, "failedResponse errorCode ：" + i + ", errorMsg :" + str);
    }

    /* loaded from: classes4.dex */
    private class HttpExecutorLogger implements Interceptor {
        private HttpExecutorLogger() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            try {
                Request request = chain.request();
                long currentTimeMillis = System.currentTimeMillis();
                Response proceed = chain.proceed(request);
                long currentTimeMillis2 = System.currentTimeMillis();
                BIMRtcManager.mBIMRtcEvent.ext = "req_time=" + (currentTimeMillis2 - currentTimeMillis);
                LogUtils.d(HttpExecutor.TAG, ">>>>>request time=" + (currentTimeMillis2 - currentTimeMillis) + ", url=" + request.url().toString());
                return proceed;
            } catch (Exception e) {
                e.printStackTrace();
                return chain.proceed(chain.request());
            }
        }
    }
}
