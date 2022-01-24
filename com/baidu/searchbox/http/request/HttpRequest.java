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
import com.baidu.searchbox.http.request.HttpRequestBuilder;
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
/* loaded from: classes11.dex */
public abstract class HttpRequest<T extends HttpRequestBuilder> {
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
    public NetworkStat<Request> networkStat;
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

    public HttpRequest(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        AbstractHttpManager abstractHttpManager = t.httpManager;
        this.httpManager = abstractHttpManager;
        this.client = abstractHttpManager.getOkHttpClient();
        this.requestHandler = this.httpManager.getRequestHandler();
        this.networkStat = this.httpManager.getNetworkStat();
        this.deliver = this.httpManager.getDeliver();
        HttpUrl httpUrl = t.httpUrl;
        this.httpUrl = httpUrl;
        this.tag = t.tag;
        this.connectionTimeout = t.connectionTimeout;
        this.readTimeout = t.readTimeout;
        this.writeTimeout = t.writeTimeout;
        this.enableRetry = t.enableRetry;
        this.logTag = t.logTag;
        this.logLevel = t.logLevel;
        this.isWifiOnly = t.isWifiOnly;
        this.cookieManager = t.cookieManager;
        this.paramsHandler = t.paramsHandler;
        this.isReqNetStatEnable = t.isReqNetStatEnable;
        this.requestFrom = t.requestFrom;
        this.requestSubFrom = t.requestSubFrom;
        this.extraUserLog = t.extraUserLog;
        this.proxy = t.proxy;
        this.followRedirects = t.followRedirects;
        this.followSslRedirects = t.followSslRedirects;
        if (httpUrl != null) {
            String generateBdTraceId = HttpUtils.generateBdTraceId();
            this.bdTraceId = generateBdTraceId;
            t.headersBuilder.add(EXT_HEADER_TRACE_ID, generateBdTraceId);
            this.headers = t.headersBuilder.build();
            if (this.isReqNetStatEnable) {
                NetworkStatRecord networkStatRecord = new NetworkStatRecord();
                this.requestNetStat = networkStatRecord;
                networkStatRecord.url = this.httpUrl.toString();
                NetworkStatRecord networkStatRecord2 = this.requestNetStat;
                networkStatRecord2.from = t.requestFrom;
                networkStatRecord2.subFrom = t.requestSubFrom;
            }
            initOkRequest(t);
            return;
        }
        throw new IllegalArgumentException(" url not set, please check");
    }

    private void initOkRequest(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, t) == null) {
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
            initExtraHttpRequest(t);
            this.okRequest = buildOkRequest(buildOkRequestBody());
        }
    }

    public abstract Request buildOkRequest(RequestBody requestBody);

    public abstract RequestBody buildOkRequestBody();

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback)) == null) ? new RequestCall(this).executeAsync(responseCallback) : (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, responseCallback)) == null) ? new RequestCall(this).executeAsyncOnUIBack(responseCallback) : (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeAsyncWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, handler, responseCallback)) == null) ? new RequestCall(this).executeAsyncWithHandler(handler, responseCallback) : (Cancelable) invokeLL.objValue;
    }

    public StatResponse executeStat() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RequestCall(this).executeStat() : (StatResponse) invokeV.objValue;
    }

    public <T> Cancelable executeStatUIBack(StatResponseCallback<T> statResponseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, statResponseCallback)) == null) ? new RequestCall(this).executeStatUIBack(statResponseCallback) : (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeStatWithHandler(Handler handler, StatResponseCallback<T> statResponseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, handler, statResponseCallback)) == null) ? new RequestCall(this).executeStatWithHandler(handler, statResponseCallback) : (Cancelable) invokeLL.objValue;
    }

    public Response executeSync() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new RequestCall(this).executeSync() : (Response) invokeV.objValue;
    }

    public String getBdTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.bdTraceId : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.extraUserLog : (JSONObject) invokeV.objValue;
    }

    public NetworkStat<Request> getNetworkStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.networkStat : (NetworkStat) invokeV.objValue;
    }

    public Request getOkRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.okRequest : (Request) invokeV.objValue;
    }

    public int getRequestFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.requestFrom : invokeV.intValue;
    }

    public NetworkStatRecord getRequestNetStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.requestNetStat : (NetworkStatRecord) invokeV.objValue;
    }

    public int getRequestSubFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.requestSubFrom : invokeV.intValue;
    }

    public abstract void initExtraHttpRequest(T t);

    public RequestCall makeRequestCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new RequestCall(this) : (RequestCall) invokeV.objValue;
    }

    public abstract T newBuilder();

    public abstract T newBuilder(AbstractHttpManager abstractHttpManager);

    public Object tag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.originTag : invokeV.objValue;
    }

    public <T> Cancelable executeStat(StatResponseCallback<T> statResponseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, statResponseCallback)) == null) ? new RequestCall(this).executeStat(statResponseCallback) : (Cancelable) invokeL.objValue;
    }
}
