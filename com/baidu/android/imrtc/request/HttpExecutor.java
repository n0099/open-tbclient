package com.baidu.android.imrtc.request;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcManager;
import com.baidu.android.imrtc.utils.BIMRtcEvent;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.TaskManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public class HttpExecutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HttpExecutor";
    public static volatile HttpExecutor mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient okHttpClient;

    /* loaded from: classes3.dex */
    public class HttpExecutorLogger implements Interceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpExecutor this$0;

        public HttpExecutorLogger(HttpExecutor httpExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpExecutor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = httpExecutor;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
                try {
                    Request request = chain.request();
                    long currentTimeMillis = System.currentTimeMillis();
                    Response proceed = chain.proceed(request);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    BIMRtcEvent bIMRtcEvent = BIMRtcManager.mBIMRtcEvent;
                    StringBuilder sb = new StringBuilder();
                    sb.append("req_time=");
                    long j2 = currentTimeMillis2 - currentTimeMillis;
                    sb.append(j2);
                    bIMRtcEvent.ext = sb.toString();
                    LogUtils.d("HttpExecutor", ">>>>>request time=" + j2 + ", url=" + request.url().toString());
                    return proceed;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return chain.proceed(chain.request());
                }
            }
            return (Response) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface HttpRequest {
        Map<String, String> getHeaders();

        String getHost();

        String getMediaType();

        String getMethod();

        byte[] getRequestParameter();

        boolean shouldAbort();
    }

    /* loaded from: classes3.dex */
    public interface ResponseHandler {
        void onFailure(int i2, String str);

        void onSuccess(byte[] bArr);
    }

    public HttpExecutor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpExecutorLogger()).connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).writeTimeout(5L, TimeUnit.SECONDS).build();
    }

    public static void failedResponse(@NonNull ResponseHandler responseHandler, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, responseHandler, i2, str) == null) {
            responseHandler.onFailure(i2, str);
            BIMRtcEvent bIMRtcEvent = BIMRtcManager.mBIMRtcEvent;
            bIMRtcEvent.ext = "fail_err=" + i2;
            LogUtils.e("HttpExecutor", "failedResponse errorCode ：" + i2 + ", errorMsg :" + str);
        }
    }

    public static HttpExecutor getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                synchronized (HttpExecutor.class) {
                    if (mInstance == null) {
                        mInstance = new HttpExecutor();
                    }
                }
            }
            return mInstance;
        }
        return (HttpExecutor) invokeV.objValue;
    }

    public void execute(@NonNull HttpRequest httpRequest, @NonNull ResponseHandler responseHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, httpRequest, responseHandler) == null) {
            TaskManager.getInstance().submitForNetWork(new Runnable(this, httpRequest, responseHandler) { // from class: com.baidu.android.imrtc.request.HttpExecutor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpExecutor this$0;
                public final /* synthetic */ HttpRequest val$httpRequest;
                public final /* synthetic */ ResponseHandler val$responseHandler;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, httpRequest, responseHandler};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$httpRequest = httpRequest;
                    this.val$responseHandler = responseHandler;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.requestExecute(this.val$httpRequest, this.val$responseHandler);
                    }
                }
            });
        }
    }

    public void requestExecute(@NonNull HttpRequest httpRequest, @NonNull ResponseHandler responseHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpRequest, responseHandler) == null) {
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
}
