package com.baidu.searchbox.http.request;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.http.util.HttpUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.Proxy;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class HttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXT_HEADER_TRACE_ID = "X-Bd-Traceid";
    public static final int REQUESTFROM_FEED = 1;
    public static final int REQUESTFROM_FRESCO = 2;
    public static final int REQUESTFROM_NONE = 0;
    public static final int REQUESTFROM_UBC = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String bdTraceId;
    public OkHttpClient client;
    public int connectionTimeout;
    public CookieManager cookieManager;
    public Handler deliver;
    public boolean enableRetry;
    public JSONObject extraUserLog;
    public boolean followRedirects;
    public boolean followSslRedirects;
    public Headers headers;
    public AbstractHttpManager httpManager;
    public HttpUrl httpUrl;
    public boolean isConnReused;
    public boolean isReqNetStatEnable;
    public boolean isWifiOnly;
    public LogInterceptor.Level logLevel;
    public String logTag;
    public NetworkStat networkStat;
    public Request okRequest;
    public Request.Builder okRequestBuilder;
    public Object originTag;
    public IAsyncRequestParamsHandler paramsHandler;
    public Proxy proxy;
    public int readTimeout;
    public int requestFrom;
    public RequestHandler requestHandler;
    public NetworkStatRecord requestNetStat;
    public int requestSubFrom;
    public Object tag;
    public int writeTimeout;

    public abstract Request buildOkRequest(RequestBody requestBody);

    public abstract RequestBody buildOkRequestBody();

    public abstract void initExtraHttpRequest(HttpRequestBuilder httpRequestBuilder);

    public abstract HttpRequestBuilder newBuilder();

    public abstract HttpRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager);

    public HttpRequest(HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpRequestBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.connectionTimeout = 0;
        this.readTimeout = 0;
        this.writeTimeout = 0;
        this.enableRetry = true;
        this.paramsHandler = null;
        this.requestNetStat = null;
        this.requestFrom = 0;
        this.requestSubFrom = 0;
        AbstractHttpManager abstractHttpManager = httpRequestBuilder.httpManager;
        this.httpManager = abstractHttpManager;
        this.client = abstractHttpManager.getOkHttpClient();
        this.requestHandler = this.httpManager.getRequestHandler();
        this.networkStat = this.httpManager.getNetworkStat();
        this.deliver = this.httpManager.getDeliver();
        HttpUrl httpUrl = httpRequestBuilder.httpUrl;
        this.httpUrl = httpUrl;
        this.tag = httpRequestBuilder.tag;
        this.connectionTimeout = httpRequestBuilder.connectionTimeout;
        this.readTimeout = httpRequestBuilder.readTimeout;
        this.writeTimeout = httpRequestBuilder.writeTimeout;
        this.enableRetry = httpRequestBuilder.enableRetry;
        this.logTag = httpRequestBuilder.logTag;
        this.logLevel = httpRequestBuilder.logLevel;
        this.isWifiOnly = httpRequestBuilder.isWifiOnly;
        this.cookieManager = httpRequestBuilder.cookieManager;
        this.paramsHandler = httpRequestBuilder.paramsHandler;
        this.isReqNetStatEnable = httpRequestBuilder.isReqNetStatEnable;
        this.requestFrom = httpRequestBuilder.requestFrom;
        this.requestSubFrom = httpRequestBuilder.requestSubFrom;
        this.extraUserLog = httpRequestBuilder.extraUserLog;
        this.proxy = httpRequestBuilder.proxy;
        this.followRedirects = httpRequestBuilder.followRedirects;
        this.followSslRedirects = httpRequestBuilder.followSslRedirects;
        if (httpUrl != null) {
            String generateBdTraceId = HttpUtils.generateBdTraceId();
            this.bdTraceId = generateBdTraceId;
            httpRequestBuilder.headersBuilder.add(EXT_HEADER_TRACE_ID, generateBdTraceId);
            this.headers = httpRequestBuilder.headersBuilder.build();
            if (this.isReqNetStatEnable) {
                NetworkStatRecord networkStatRecord = new NetworkStatRecord();
                this.requestNetStat = networkStatRecord;
                networkStatRecord.url = this.httpUrl.toString();
                NetworkStatRecord networkStatRecord2 = this.requestNetStat;
                networkStatRecord2.from = httpRequestBuilder.requestFrom;
                networkStatRecord2.subFrom = httpRequestBuilder.requestSubFrom;
            }
            initOkRequest(httpRequestBuilder);
            return;
        }
        throw new IllegalArgumentException(" url not set, please check");
    }

    private void initOkRequest(HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, httpRequestBuilder) == null) {
            Request.Builder builder = new Request.Builder();
            this.okRequestBuilder = builder;
            builder.url(this.httpUrl);
            Object obj = this.tag;
            this.originTag = obj;
            if (obj != null) {
                this.okRequestBuilder.tag(obj);
            }
            if (this.networkStat != null || this.isReqNetStatEnable) {
                this.okRequestBuilder.tag(this);
            }
            Headers headers = this.headers;
            if (headers != null && headers.size() > 0) {
                this.okRequestBuilder.headers(this.headers);
            }
            initExtraHttpRequest(httpRequestBuilder);
            this.okRequest = buildOkRequest(buildOkRequestBody());
        }
    }

    public Cancelable executeAsync(ResponseCallback responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback)) == null) {
            return new RequestCall(this).executeAsync(responseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    public Cancelable executeAsyncOnUIBack(ResponseCallback responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, responseCallback)) == null) {
            return new RequestCall(this).executeAsyncOnUIBack(responseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    public Cancelable executeStat(StatResponseCallback statResponseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, statResponseCallback)) == null) {
            return new RequestCall(this).executeStat(statResponseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    public Cancelable executeStatUIBack(StatResponseCallback statResponseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, statResponseCallback)) == null) {
            return new RequestCall(this).executeStatUIBack(statResponseCallback);
        }
        return (Cancelable) invokeL.objValue;
    }

    public Cancelable executeAsyncWithHandler(Handler handler, ResponseCallback responseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, handler, responseCallback)) == null) {
            return new RequestCall(this).executeAsyncWithHandler(handler, responseCallback);
        }
        return (Cancelable) invokeLL.objValue;
    }

    public Cancelable executeStatWithHandler(Handler handler, StatResponseCallback statResponseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, handler, statResponseCallback)) == null) {
            return new RequestCall(this).executeStatWithHandler(handler, statResponseCallback);
        }
        return (Cancelable) invokeLL.objValue;
    }

    public StatResponse executeStat() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new RequestCall(this).executeStat();
        }
        return (StatResponse) invokeV.objValue;
    }

    public Response executeSync() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return new RequestCall(this).executeSync();
        }
        return (Response) invokeV.objValue;
    }

    public String getBdTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.bdTraceId;
        }
        return (String) invokeV.objValue;
    }

    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                return this.okRequest.body().contentLength();
            } catch (IOException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public JSONObject getExtraUserLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.extraUserLog;
        }
        return (JSONObject) invokeV.objValue;
    }

    public NetworkStat getNetworkStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.networkStat;
        }
        return (NetworkStat) invokeV.objValue;
    }

    public Request getOkRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.okRequest;
        }
        return (Request) invokeV.objValue;
    }

    public int getRequestFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.requestFrom;
        }
        return invokeV.intValue;
    }

    public NetworkStatRecord getRequestNetStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.requestNetStat;
        }
        return (NetworkStatRecord) invokeV.objValue;
    }

    public int getRequestSubFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.requestSubFrom;
        }
        return invokeV.intValue;
    }

    public RequestCall makeRequestCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return new RequestCall(this);
        }
        return (RequestCall) invokeV.objValue;
    }

    public Object tag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.originTag;
        }
        return invokeV.objValue;
    }
}
