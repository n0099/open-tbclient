package com.baidu.searchbox.network.outback.core;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.Cancelable;
import com.baidu.searchbox.network.outback.ConnectManager;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.searchbox.network.outback.OutbackComponent;
import com.baidu.searchbox.network.outback.callback.ResponseCallback;
import com.baidu.searchbox.network.outback.cookie.CookieManager;
import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.core.HttpUrl;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.outback.request.RequestCall;
import com.baidu.searchbox.network.outback.statistics.DoRecordManager;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.searchbox.network.outback.statistics.RequestCallException;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Request {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUESTFROM_FEED = 1;
    public static final int REQUESTFROM_FRESCO = 2;
    public static final int REQUESTFROM_NONE = 0;
    public static final int REQUESTFROM_UBC = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String bdTraceId;
    @Nullable
    public final RequestBody body;
    public Map<String, CallFactory> callFactoryMap;
    public int connectionTimeout;
    public CookieManager cookieManager;
    public JSONObject extraUserLog;
    public boolean followRedirects;
    public boolean followSslRedirects;
    public final Headers headers;
    public boolean isWifiOnly;
    public String logTag;
    public final String method;
    public Object originTag;
    public int readTimeout;
    public final NetworkStatRecord record;
    public int requestFrom;
    public int requestSubFrom;
    public final Map<Class<?>, Object> tags;
    public final UrlWrapper url;
    public int writeTimeout;

    /* loaded from: classes2.dex */
    public static class Builder<R extends Builder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bdTraceId;
        @Nullable
        public RequestBody body;
        public Map<String, CallFactory> callFactoryMap;
        public int connectionTimeout;
        public CookieManager cookieManager;
        public boolean enableBrotli;
        public JSONObject extraUserLog;
        public boolean followRedirects;
        public boolean followSslRedirects;
        public Headers.Builder headers;
        public boolean isWifiOnly;
        public String logTag;
        public String method;
        public int readTimeout;
        public NetworkStatRecord record;
        public int requestFrom;
        public int requestSubFrom;
        public Map<Class<?>, Object> tags;
        @Nullable
        public UrlWrapper url;
        public int writeTimeout;

        public Builder(Map<String, CallFactory> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.connectionTimeout = -1;
            this.readTimeout = -1;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.logTag = null;
            this.isWifiOnly = false;
            this.requestFrom = 0;
            this.requestSubFrom = 0;
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
            if (map != null) {
                this.callFactoryMap = map;
                return;
            }
            throw new IllegalArgumentException("callFactory is not set");
        }

        public R addHeader(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.headers.add(str, str2);
                return this;
            }
            return (R) invokeLL.objValue;
        }

        public R addHeaders(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        this.headers.add(entry.getKey(), entry.getValue());
                    }
                }
                return this;
            }
            return (R) invokeL.objValue;
        }

        public R addUrlParam(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                UrlWrapper urlWrapper = this.url;
                if (urlWrapper != null) {
                    HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                    newBuilder.addQueryParameter(str, str2);
                    this.url.setHttpUrl(newBuilder.build());
                }
                return this;
            }
            return (R) invokeLL.objValue;
        }

        public R addUrlParams(Map<String, String> map) {
            InterceptResult invokeL;
            UrlWrapper urlWrapper;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
                if (map != null && map.size() > 0 && (urlWrapper = this.url) != null) {
                    HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        newBuilder.addQueryParameter(entry.getKey(), entry.getValue());
                    }
                    this.url.setHttpUrl(newBuilder.build());
                }
                return this;
            }
            return (R) invokeL.objValue;
        }

        public Request build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new Request(this) : (Request) invokeV.objValue;
        }

        public R connectionTimeout(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.connectionTimeout = Util.checkDuration("timeout", i, TimeUnit.MILLISECONDS);
                return this;
            }
            return (R) invokeI.objValue;
        }

        public R cookieManager(CookieManager cookieManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cookieManager)) == null) {
                this.cookieManager = cookieManager;
                return this;
            }
            return (R) invokeL.objValue;
        }

        public R delete(@Nullable RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, requestBody)) == null) ? method(HttpDelete.METHOD_NAME, requestBody) : (R) invokeL.objValue;
        }

        public R enableBrotli() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                this.enableBrotli = true;
                return this;
            }
            return (R) invokeV.objValue;
        }

        public R extraUserLog(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONObject)) == null) {
                this.extraUserLog = jSONObject;
                return this;
            }
            return (R) invokeL.objValue;
        }

        public R followRedirects(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.followRedirects = z;
                return this;
            }
            return (R) invokeZ.objValue;
        }

        public R followSslRedirects(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.followSslRedirects = z;
                return this;
            }
            return (R) invokeZ.objValue;
        }

        public R get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? method("GET", null) : (R) invokeV.objValue;
        }

        public R head() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? method("HEAD", null) : (R) invokeV.objValue;
        }

        public R header(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, str2)) == null) {
                this.headers.set(str, str2);
                return this;
            }
            return (R) invokeLL.objValue;
        }

        public R headers(Headers headers) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, headers)) == null) {
                this.headers = headers.newBuilder();
                return this;
            }
            return (R) invokeL.objValue;
        }

        public R method(String str, @Nullable RequestBody requestBody) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, requestBody)) == null) {
                if (str != null) {
                    if (str.length() != 0) {
                        if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                            throw new IllegalArgumentException("method " + str + " must not have a request body.");
                        } else if (requestBody == null && HttpMethod.requiresRequestBody(str)) {
                            throw new IllegalArgumentException("method " + str + " must have a request body.");
                        } else {
                            this.method = str;
                            this.body = requestBody;
                            return this;
                        }
                    }
                    throw new IllegalArgumentException("method.length() == 0");
                }
                throw new NullPointerException("method == null");
            }
            return (R) invokeLL.objValue;
        }

        public R patch(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, requestBody)) == null) ? method("PATCH", requestBody) : (R) invokeL.objValue;
        }

        public R post(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, requestBody)) == null) ? method("POST", requestBody) : (R) invokeL.objValue;
        }

        public R put(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, requestBody)) == null) ? method(HttpPut.METHOD_NAME, requestBody) : (R) invokeL.objValue;
        }

        public R readTimeout(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
                this.readTimeout = Util.checkDuration("timeout", i, TimeUnit.MILLISECONDS);
                return this;
            }
            return (R) invokeI.objValue;
        }

        public R removeHeader(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                this.headers.removeAll(str);
                return this;
            }
            return (R) invokeL.objValue;
        }

        public R removeHeaders(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, list)) == null) {
                if (list != null && list.size() > 0) {
                    for (String str : list) {
                        this.headers.removeAll(str);
                    }
                }
                return this;
            }
            return (R) invokeL.objValue;
        }

        public R removeUrlParam(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                UrlWrapper urlWrapper = this.url;
                if (urlWrapper != null) {
                    HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                    newBuilder.removeAllQueryParameters(str);
                    this.url.setHttpUrl(newBuilder.build());
                }
                return this;
            }
            return (R) invokeL.objValue;
        }

        public R removeUrlParams(List<String> list) {
            InterceptResult invokeL;
            UrlWrapper urlWrapper;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, list)) == null) {
                if (list != null && list.size() > 0 && (urlWrapper = this.url) != null) {
                    HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                    for (String str : list) {
                        newBuilder.removeAllQueryParameters(str);
                    }
                    this.url.setHttpUrl(newBuilder.build());
                }
                return this;
            }
            return (R) invokeL.objValue;
        }

        public R requestFrom(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
                this.requestFrom = i;
                return this;
            }
            return (R) invokeI.objValue;
        }

        public R requestSubFrom(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
                this.requestSubFrom = i;
                return this;
            }
            return (R) invokeI.objValue;
        }

        public R setHeader(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, str, str2)) == null) ? header(str, str2) : (R) invokeLL.objValue;
        }

        public R setUrlParam(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, str, str2)) == null) {
                UrlWrapper urlWrapper = this.url;
                if (urlWrapper != null) {
                    HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                    newBuilder.setQueryParameter(str, str2);
                    this.url.setHttpUrl(newBuilder.build());
                }
                return this;
            }
            return (R) invokeLL.objValue;
        }

        public R setUrlParams(Map<String, String> map) {
            InterceptResult invokeL;
            UrlWrapper urlWrapper;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, map)) == null) {
                if (map != null && map.size() > 0 && (urlWrapper = this.url) != null) {
                    HttpUrl.Builder newBuilder = urlWrapper.getHttpUrl().newBuilder();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        newBuilder.setQueryParameter(entry.getKey(), entry.getValue());
                    }
                    this.url.setHttpUrl(newBuilder.build());
                }
                return this;
            }
            return (R) invokeL.objValue;
        }

        public R tag(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, obj)) == null) ? tag(Object.class, obj) : (R) invokeL.objValue;
        }

        public R url(UrlWrapper urlWrapper) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, urlWrapper)) == null) {
                if (urlWrapper != null) {
                    this.url = urlWrapper;
                    return this;
                }
                throw new NullPointerException("url == null");
            }
            return (R) invokeL.objValue;
        }

        public R userAgent(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
                if (!Util.isTextEmpty(str)) {
                    this.headers.set("User-Agent", str);
                }
                return this;
            }
            return (R) invokeL.objValue;
        }

        public R wifiOnly(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048615, this, z)) == null) {
                this.isWifiOnly = z;
                return this;
            }
            return (R) invokeZ.objValue;
        }

        public R writeTimeout(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i)) == null) {
                this.writeTimeout = i;
                return this;
            }
            return (R) invokeI.objValue;
        }

        public R delete() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? delete(Util.EMPTY_REQUEST) : (R) invokeV.objValue;
        }

        public R headers(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, map)) == null) {
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        this.headers.set(entry.getKey(), entry.getValue());
                    }
                }
                return this;
            }
            return (R) invokeL.objValue;
        }

        public <T> R tag(Class<? super T> cls, @Nullable T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, cls, t)) == null) {
                if (cls != null) {
                    if (t == null) {
                        this.tags.remove(cls);
                    } else {
                        if (this.tags.isEmpty()) {
                            this.tags = new LinkedHashMap();
                        }
                        this.tags.put(cls, cls.cast(t));
                    }
                    return this;
                }
                throw new NullPointerException("type == null");
            }
            return (R) invokeLL.objValue;
        }

        public R url(HttpUrl httpUrl) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, httpUrl)) == null) {
                if (httpUrl != null) {
                    this.url = new UrlWrapper(httpUrl);
                    return this;
                }
                throw new NullPointerException("url == null");
            }
            return (R) invokeL.objValue;
        }

        public R url(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
                if (str != null) {
                    if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                        str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
                    } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
                    }
                    UrlWrapper urlWrapper = this.url;
                    try {
                        if (urlWrapper == null) {
                            try {
                                this.url = new UrlWrapper(str);
                            } catch (IllegalArgumentException unused) {
                                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unexpected url: " + str);
                                this.record.exception = illegalArgumentException;
                                throw illegalArgumentException;
                            }
                        } else {
                            urlWrapper.setUrl(str);
                        }
                        return this;
                    } finally {
                        DoRecordManager.getInstance().doRecord(this.record, DoRecordManager.FAILED_MSG);
                    }
                }
                throw new NullPointerException("url == null");
            }
            return (R) invokeL.objValue;
        }

        public Builder(Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.connectionTimeout = -1;
            this.readTimeout = -1;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.logTag = null;
            this.isWifiOnly = false;
            this.requestFrom = 0;
            this.requestSubFrom = 0;
            this.tags = Collections.emptyMap();
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.tags = request.tags.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(request.tags);
            this.headers = request.headers.newBuilder();
            this.connectionTimeout = request.connectionTimeout;
            this.readTimeout = request.readTimeout;
            this.writeTimeout = request.writeTimeout;
            this.followRedirects = request.followRedirects;
            this.logTag = request.logTag;
            this.isWifiOnly = request.isWifiOnly;
            this.cookieManager = request.cookieManager;
            this.requestFrom = request.requestFrom;
            this.requestSubFrom = request.requestSubFrom;
            this.extraUserLog = request.extraUserLog;
            this.callFactoryMap = request.callFactoryMap;
            this.record = request.getNetworkStatRecord();
            this.bdTraceId = request.getBdTraceId();
        }

        public R url(URL url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, url)) == null) {
                if (url != null) {
                    UrlWrapper urlWrapper = this.url;
                    if (urlWrapper == null) {
                        this.url = new UrlWrapper(url.toString());
                    } else {
                        urlWrapper.setHttpUrl(null);
                        this.url.setUrl(url.toString());
                    }
                    return url(this.url);
                }
                throw new NullPointerException("url == null");
            }
            return (R) invokeL.objValue;
        }
    }

    public Request(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
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
        this.requestFrom = 0;
        this.requestSubFrom = 0;
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.connectionTimeout = builder.connectionTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.followRedirects = builder.followRedirects;
        this.followSslRedirects = builder.followSslRedirects;
        this.requestFrom = builder.requestFrom;
        this.requestSubFrom = builder.requestSubFrom;
        this.extraUserLog = builder.extraUserLog;
        this.cookieManager = builder.cookieManager;
        this.isWifiOnly = builder.isWifiOnly;
        this.tags = Util.immutableMap(builder.tags);
        if (Util.isTextEmpty(builder.bdTraceId)) {
            this.bdTraceId = generateBdTraceId();
        } else {
            this.bdTraceId = builder.bdTraceId;
        }
        builder.headers.add("X-BD-TraceId", this.bdTraceId);
        if (builder.enableBrotli) {
            builder.header("bdapp-support-brotli", "1");
        }
        this.headers = builder.headers.build();
        NetworkStatRecord networkStatRecord = builder.record;
        if (networkStatRecord != null) {
            this.record = networkStatRecord;
        } else {
            this.record = new NetworkStatRecord();
        }
        NetworkStatRecord networkStatRecord2 = this.record;
        networkStatRecord2.bdTraceId = this.bdTraceId;
        networkStatRecord2.url = this.url.toString();
        NetworkStatRecord networkStatRecord3 = this.record;
        networkStatRecord3.extraUserInfo = this.extraUserLog;
        networkStatRecord3.from = this.requestFrom;
        networkStatRecord3.subFrom = this.requestSubFrom;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.record.netType = ConnectManager.getNetworkInfo(OutbackComponent.getInstance().getContext());
            this.record.isVPNConnect = ConnectManager.isVPNConnected(OutbackComponent.getInstance().getContext());
            this.record.getNetworkInfoTs = System.currentTimeMillis() - currentTimeMillis;
        } catch (Exception unused) {
        }
        this.callFactoryMap = builder.callFactoryMap;
    }

    private String generateBdTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? UUID.randomUUID().toString().toLowerCase().replace("-", "") : (String) invokeV.objValue;
    }

    @Nullable
    public RequestBody body() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.body : (RequestBody) invokeV.objValue;
    }

    public <T> Cancelable executeAsync(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallback)) == null) ? new RequestCall(this).executeAsync(responseCallback) : (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeAsyncOnUIBack(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback)) == null) ? new RequestCall(this).executeAsyncOnUIBack(responseCallback) : (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeAsyncWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, handler, responseCallback)) == null) ? new RequestCall(this).executeAsyncWithHandler(handler, responseCallback) : (Cancelable) invokeLL.objValue;
    }

    public Response executeStat() throws RequestCallException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new RequestCall(this).executeStat() : (Response) invokeV.objValue;
    }

    public <T> Cancelable executeStatUIBack(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, responseCallback)) == null) ? new RequestCall(this).executeStatUIBack(responseCallback) : (Cancelable) invokeL.objValue;
    }

    public <T> Cancelable executeStatWithHandler(Handler handler, ResponseCallback<T> responseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, handler, responseCallback)) == null) ? new RequestCall(this).executeStatWithHandler(handler, responseCallback) : (Cancelable) invokeLL.objValue;
    }

    public Response executeSync() throws RequestCallException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new RequestCall(this).executeSync() : (Response) invokeV.objValue;
    }

    public String getBdTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.bdTraceId : (String) invokeV.objValue;
    }

    public int getConnectionTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.connectionTimeout : invokeV.intValue;
    }

    public CookieManager getCookieManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.cookieManager : (CookieManager) invokeV.objValue;
    }

    public JSONObject getExtraUserLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.extraUserLog : (JSONObject) invokeV.objValue;
    }

    public Headers getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.headers : (Headers) invokeV.objValue;
    }

    public NetworkStatRecord getNetworkStatRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.record : (NetworkStatRecord) invokeV.objValue;
    }

    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.readTimeout : invokeV.intValue;
    }

    public int getRequestFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.requestFrom : invokeV.intValue;
    }

    public int getRequestSubFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.requestSubFrom : invokeV.intValue;
    }

    public Map<Class<?>, Object> getTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.tags : (Map) invokeV.objValue;
    }

    public int getWriteTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.writeTimeout : invokeV.intValue;
    }

    @Nullable
    public String header(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) ? this.headers.get(str) : (String) invokeL.objValue;
    }

    public Headers headers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.headers : (Headers) invokeV.objValue;
    }

    public HttpUrl httpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.url.getHttpUrl() : (HttpUrl) invokeV.objValue;
    }

    public boolean isFollowRedirects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.followRedirects : invokeV.booleanValue;
    }

    public boolean isFollowSslRedirects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.followSslRedirects : invokeV.booleanValue;
    }

    public boolean isHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.url.isHttps() : invokeV.booleanValue;
    }

    public RequestCall makeRequestCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? new RequestCall(this) : (RequestCall) invokeV.objValue;
    }

    public String method() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.method : (String) invokeV.objValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? new Builder(this) : (Builder) invokeV.objValue;
    }

    public Call newCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            Map<String, CallFactory> map = this.callFactoryMap;
            if (map != null) {
                Call call = null;
                if (map.containsKey(EngineName.CUSTOM_ENGINE)) {
                    call = this.callFactoryMap.get(EngineName.CUSTOM_ENGINE).newCall(this, this.callFactoryMap.size() != 1);
                } else if (this.callFactoryMap.containsKey(EngineName.DEFAULT_ENGINE)) {
                    call = this.callFactoryMap.get(EngineName.DEFAULT_ENGINE).newCall(this, this.callFactoryMap.size() != 1);
                }
                if (call == null) {
                    if (this.callFactoryMap.containsKey(EngineName.BACK_UP_ENGINE)) {
                        return this.callFactoryMap.get(EngineName.BACK_UP_ENGINE).newCall(this, false);
                    }
                    return this.callFactoryMap.containsKey(EngineName.DEFAULT_ENGINE) ? this.callFactoryMap.get(EngineName.DEFAULT_ENGINE).newCall(this, false) : call;
                }
                return call;
            }
            throw new IllegalArgumentException("callFactory is not set");
        }
        return (Call) invokeV.objValue;
    }

    public void onConnect4NetworkStatRecord(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048607, this, j, str) == null) {
            NetworkStatRecord networkStatRecord = this.record;
            networkStatRecord.connTs = j;
            networkStatRecord.protocol = str;
        }
    }

    public void onDnsParse4NetworkStatRecord(long j, long j2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), jSONObject}) == null) {
            NetworkStatRecord networkStatRecord = this.record;
            networkStatRecord.dnsStartTs = j;
            networkStatRecord.dnsEndTs = j2;
            if (jSONObject != null) {
                networkStatRecord.dnsDetail = jSONObject;
            }
        }
    }

    public void onException4NetworkStatRecord(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, exc) == null) {
            NetworkStatRecord networkStatRecord = this.record;
            networkStatRecord.exception = exc;
            networkStatRecord.failTs = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.record.clientIP)) {
                this.record.clientIP = ConnectManager.getClientIP();
            }
        }
    }

    public void onFinishReadContent4NetworkStatRecord(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j) == null) {
            this.record.readOverTs = System.currentTimeMillis();
            this.record.realResponseLength = j;
        }
    }

    public void onReceiveHeader4NetworkStatRecord(long j, Headers headers) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048611, this, j, headers) == null) {
            this.record.receiveHeaderTs = j;
            String str = headers.get("X-Bfe-Svbbrers");
            if (!Util.isTextEmpty(str)) {
                this.record.clientIP = str;
                return;
            }
            this.record.clientIP = ConnectManager.getClientIP();
        }
    }

    @Nullable
    public Object tag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? tag(Object.class) : invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
        }
        return (String) invokeV.objValue;
    }

    public UrlWrapper url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.url : (UrlWrapper) invokeV.objValue;
    }

    public <T> Cancelable executeStat(ResponseCallback<T> responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, responseCallback)) == null) ? new RequestCall(this).executeStat(responseCallback) : (Cancelable) invokeL.objValue;
    }

    public List<String> headers(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? this.headers.values(str) : (List) invokeL.objValue;
    }

    @Nullable
    public <T> T tag(Class<? extends T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, cls)) == null) ? cls.cast(this.tags.get(cls)) : (T) invokeL.objValue;
    }
}
