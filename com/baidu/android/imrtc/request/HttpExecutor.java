package com.baidu.android.imrtc.request;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcManager;
import com.baidu.android.imrtc.utils.BIMRtcEvent;
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
/* loaded from: classes2.dex */
public class HttpExecutor {
    public static final String TAG = "HttpExecutor";
    public static volatile HttpExecutor mInstance;
    public OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpExecutorLogger()).connectTimeout(5, TimeUnit.SECONDS).readTimeout(5, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS).build();

    /* loaded from: classes2.dex */
    public class HttpExecutorLogger implements Interceptor {
        public HttpExecutorLogger() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            try {
                Request request = chain.request();
                long currentTimeMillis = System.currentTimeMillis();
                Response proceed = chain.proceed(request);
                long currentTimeMillis2 = System.currentTimeMillis();
                BIMRtcEvent bIMRtcEvent = BIMRtcManager.mBIMRtcEvent;
                StringBuilder sb = new StringBuilder();
                sb.append("req_time=");
                long j = currentTimeMillis2 - currentTimeMillis;
                sb.append(j);
                bIMRtcEvent.ext = sb.toString();
                LogUtils.d("HttpExecutor", ">>>>>request time=" + j + ", url=" + request.url().toString());
                return proceed;
            } catch (Exception e2) {
                e2.printStackTrace();
                return chain.proceed(chain.request());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface HttpRequest {
        Map<String, String> getHeaders();

        String getHost();

        String getMediaType();

        String getMethod();

        byte[] getRequestParameter();

        boolean shouldAbort();
    }

    /* loaded from: classes2.dex */
    public interface ResponseHandler {
        void onFailure(int i, String str);

        void onSuccess(byte[] bArr);
    }

    public static void failedResponse(@NonNull ResponseHandler responseHandler, int i, String str) {
        responseHandler.onFailure(i, str);
        BIMRtcEvent bIMRtcEvent = BIMRtcManager.mBIMRtcEvent;
        bIMRtcEvent.ext = "fail_err=" + i;
        LogUtils.e("HttpExecutor", "failedResponse errorCode ：" + i + ", errorMsg :" + str);
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
            if (requestParameter != null && requestParameter.length > 0) {
                Request build = new Request.Builder().url(httpRequest.getHost()).post(RequestBody.create(MediaType.parse(httpRequest.getMediaType()), requestParameter)).build();
                LogUtils.d("HttpExecutor", ">>>>>request url :" + httpRequest.getHost() + " , body :" + new String(httpRequest.getRequestParameter()));
                Call newCall = this.okHttpClient.newCall(build);
                try {
                    BIMRtcManager.mBIMRtcEvent.ext = "call.exe";
                    Response execute = newCall.execute();
                    if (execute.code() != 200) {
                        failedResponse(responseHandler, execute.code(), execute.message());
                        return;
                    } else if (execute.body() == null) {
                        failedResponse(responseHandler, 10001, "response body empty");
                        return;
                    } else {
                        byte[] bytes = execute.body().bytes();
                        LogUtils.e("HttpExecutor", ">>>>>onSuccess errorCode ：" + execute.code() + ", errorMsg :" + new String(bytes));
                        responseHandler.onSuccess(bytes);
                        return;
                    }
                } catch (IOException e2) {
                    failedResponse(responseHandler, 10003, e2.getMessage());
                    LogUtils.e("HttpExecutor", "exception :" + e2.getMessage());
                    return;
                }
            }
            failedResponse(responseHandler, 10000, "request args exception");
        } catch (Exception e3) {
            failedResponse(responseHandler, 10004, "request exception :" + e3);
        }
    }
}
