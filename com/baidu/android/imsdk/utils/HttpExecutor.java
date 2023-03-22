package com.baidu.android.imsdk.utils;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class HttpExecutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CONNECTION_TIMEOUT = 15;
    public static final long READ_TIMEOUT = 15;
    public static final String TAG = "HttpExecutor";
    public static volatile HttpExecutor mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient okHttpClient;

    /* renamed from: com.baidu.android.imsdk.utils.HttpExecutor$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = httpExecutor;
        }

        public /* synthetic */ HttpExecutorLogger(HttpExecutor httpExecutor, AnonymousClass1 anonymousClass1) {
            this(httpExecutor);
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
                    if (Constants.isDebugMode()) {
                        LogUtils.d("HttpExecutor", ">>>>>request time=" + (currentTimeMillis2 - currentTimeMillis) + ", url=" + request.url().toString());
                        return proceed;
                    }
                    return proceed;
                } catch (Exception e) {
                    e.printStackTrace();
                    return chain.proceed(chain.request());
                }
            }
            return (Response) invokeL.objValue;
        }
    }

    public HttpExecutor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpExecutorLogger(this, null)).connectTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).build();
    }

    private Headers getHeaders(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, map)) == null) {
            try {
                Headers.Builder builder = new Headers.Builder();
                if (map != null && map.size() > 0) {
                    for (String str : map.keySet()) {
                        String str2 = str.toString();
                        builder.add(str2, map.get(str2));
                    }
                }
                return builder.build();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Headers) invokeL.objValue;
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

    private void responseAddEventList(HttpHelper.ResponseHandler responseHandler, int i, byte[] bArr, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65539, this, responseHandler, i, bArr, jSONArray) != null) || !(responseHandler instanceof HttpHelper.LogoutResponseHandler)) {
            return;
        }
        Utility.addEventListMs(jSONArray, "CNetResEnd");
        ((HttpHelper.LogoutResponseHandler) responseHandler).onResult(i, bArr, jSONArray);
    }

    public void execute(int i, String str, byte[] bArr, Map<String, String> map, String str2, HttpHelper.ResponseHandler responseHandler) {
        Request build;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, bArr, map, str2, responseHandler}) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (i == 16) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "application/x-www-form-urlencoded";
                    }
                    build = new Request.Builder().url(str).headers(getHeaders(map)).post(RequestBody.create(MediaType.parse(str2), bArr)).build();
                } else {
                    if (bArr != null && bArr.length > 0) {
                        str = str + "?" + new String(bArr);
                    }
                    build = new Request.Builder().url(str).headers(getHeaders(map)).build();
                }
                if (str.contains("logout")) {
                    Utility.addEventListMs(jSONArray, "CNetReqBegin");
                }
                try {
                    Response execute = this.okHttpClient.newCall(build).execute();
                    byte[] bytes = execute.body().bytes();
                    LogUtils.i("HttpExecutor", "requestUrl:" + str + "\nrequest method: " + i + "\nrequest contentType: " + str2 + "\nrequest param: " + new String(bArr) + "\n response : " + new String(bytes));
                    responseHandler.onSuccess(execute.code(), bytes);
                    responseAddEventList(responseHandler, execute.code(), bytes, jSONArray);
                } catch (IOException e) {
                    LogUtils.e("HttpExecutor", "exception :", e);
                    responseHandler.onSuccess(1011, e.getMessage().getBytes());
                    responseAddEventList(responseHandler, 1011, e.getMessage().getBytes(), jSONArray);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (responseHandler != null) {
                    responseHandler.onFailure(-1003, "Http Unknown exception".getBytes(), e2);
                    responseAddEventList(responseHandler, -1003, "Http Unknown exception".getBytes(), jSONArray);
                }
            }
        }
    }
}
