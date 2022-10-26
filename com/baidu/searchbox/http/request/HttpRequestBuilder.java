package com.baidu.searchbox.http.request;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class HttpRequestBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int connectionTimeout;
    public CookieManager cookieManager;
    public boolean enableRetry;
    public JSONObject extraUserLog;
    public boolean followRedirects;
    public boolean followSslRedirects;
    public Headers.Builder headersBuilder;
    public AbstractHttpManager httpManager;
    public HttpUrl httpUrl;
    public boolean isReqNetStatEnable;
    public boolean isWifiOnly;
    public LogInterceptor.Level logLevel;
    public String logTag;
    public IAsyncRequestParamsHandler paramsHandler;
    public Proxy proxy;
    public int readTimeout;
    public int requestFrom;
    public int requestSubFrom;
    public Object tag;
    public int writeTimeout;

    public abstract HttpRequest build();

    public HttpRequestBuilder(AbstractHttpManager abstractHttpManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {abstractHttpManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.enableRetry = true;
        this.logTag = null;
        this.logLevel = null;
        this.isWifiOnly = false;
        this.requestFrom = 0;
        this.requestSubFrom = 0;
        this.followSslRedirects = true;
        this.followRedirects = true;
        this.httpManager = abstractHttpManager;
        this.headersBuilder = new Headers.Builder();
    }

    public HttpRequestBuilder addUrlParams(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
            if (map != null && map.size() > 0) {
                HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
                for (Map.Entry entry : map.entrySet()) {
                    newBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
                }
                this.httpUrl = newBuilder.build();
            }
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder setUrlParams(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, map)) == null) {
            if (map != null && map.size() > 0) {
                HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
                for (Map.Entry entry : map.entrySet()) {
                    newBuilder.setQueryParameter((String) entry.getKey(), (String) entry.getValue());
                }
                this.httpUrl = newBuilder.build();
            }
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder(HttpRequest httpRequest, AbstractHttpManager abstractHttpManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpRequest, abstractHttpManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.enableRetry = true;
        this.logTag = null;
        this.logLevel = null;
        this.isWifiOnly = false;
        this.requestFrom = 0;
        this.requestSubFrom = 0;
        this.followSslRedirects = true;
        this.followRedirects = true;
        if (abstractHttpManager != null) {
            this.httpManager = abstractHttpManager;
        } else {
            this.httpManager = httpRequest.httpManager;
        }
        this.httpUrl = httpRequest.httpUrl;
        this.tag = httpRequest.tag;
        Headers headers = httpRequest.headers;
        if (headers != null) {
            this.headersBuilder = headers.newBuilder();
        } else {
            this.headersBuilder = new Headers.Builder();
        }
        this.connectionTimeout = httpRequest.connectionTimeout;
        this.readTimeout = httpRequest.readTimeout;
        this.writeTimeout = httpRequest.writeTimeout;
        this.enableRetry = httpRequest.enableRetry;
        this.isWifiOnly = httpRequest.isWifiOnly;
        this.logLevel = httpRequest.logLevel;
        this.logTag = httpRequest.logTag;
        this.cookieManager = httpRequest.cookieManager;
        this.paramsHandler = httpRequest.paramsHandler;
        this.isReqNetStatEnable = httpRequest.isReqNetStatEnable;
        this.requestFrom = httpRequest.requestFrom;
        this.requestSubFrom = httpRequest.requestSubFrom;
        this.extraUserLog = httpRequest.extraUserLog;
        this.proxy = httpRequest.proxy;
        this.followRedirects = httpRequest.followRedirects;
        this.followSslRedirects = httpRequest.followSslRedirects;
    }

    public HttpRequestBuilder addHeader(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            this.headersBuilder.add(str, str2);
            return this;
        }
        return (HttpRequestBuilder) invokeLL.objValue;
    }

    public HttpRequestBuilder addUrlParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
            newBuilder.addQueryParameter(str, str2);
            this.httpUrl = newBuilder.build();
            return this;
        }
        return (HttpRequestBuilder) invokeLL.objValue;
    }

    public HttpRequestBuilder log(String str, LogInterceptor.Level level) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, level)) == null) {
            this.logTag = str;
            this.logLevel = level;
            return this;
        }
        return (HttpRequestBuilder) invokeLL.objValue;
    }

    public HttpRequestBuilder setHeader(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, str2)) == null) {
            this.headersBuilder.set(str, str2);
            return this;
        }
        return (HttpRequestBuilder) invokeLL.objValue;
    }

    public HttpRequestBuilder setUrlParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) == null) {
            HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
            newBuilder.setQueryParameter(str, str2);
            this.httpUrl = newBuilder.build();
            return this;
        }
        return (HttpRequestBuilder) invokeLL.objValue;
    }

    public HttpRequestBuilder addHeaders(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    this.headersBuilder.add((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder headers(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, map)) == null) {
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    this.headersBuilder.set((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder removeUrlParams(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, list)) == null) {
            if (list != null && list.size() > 0) {
                HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    newBuilder.removeAllQueryParameters((String) it.next());
                }
                this.httpUrl = newBuilder.build();
            }
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder autoRetry(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.enableRetry = z;
            return this;
        }
        return (HttpRequestBuilder) invokeZ.objValue;
    }

    public HttpRequestBuilder connectionTimeout(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.connectionTimeout = i;
            return this;
        }
        return (HttpRequestBuilder) invokeI.objValue;
    }

    public HttpRequestBuilder cookieManager(CookieManager cookieManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cookieManager)) == null) {
            this.cookieManager = cookieManager;
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder enableStat(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.isReqNetStatEnable = z;
            return this;
        }
        return (HttpRequestBuilder) invokeZ.objValue;
    }

    public HttpRequestBuilder extraUserLog(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
            this.extraUserLog = jSONObject;
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder followRedirects(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.followRedirects = z;
            return this;
        }
        return (HttpRequestBuilder) invokeZ.objValue;
    }

    public HttpRequestBuilder followSslRedirects(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.followSslRedirects = z;
            return this;
        }
        return (HttpRequestBuilder) invokeZ.objValue;
    }

    public HttpRequestBuilder proxy(Proxy proxy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, proxy)) == null) {
            this.proxy = proxy;
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder readTimeout(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            this.readTimeout = i;
            return this;
        }
        return (HttpRequestBuilder) invokeI.objValue;
    }

    public HttpRequestBuilder removeHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.headersBuilder.removeAll(str);
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder removeHeaders(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, list)) == null) {
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    this.headersBuilder.removeAll((String) it.next());
                }
            }
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder removeUrlParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
            newBuilder.removeAllQueryParameters(str);
            this.httpUrl = newBuilder.build();
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder requestFrom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            this.requestFrom = i;
            return this;
        }
        return (HttpRequestBuilder) invokeI.objValue;
    }

    public HttpRequestBuilder requestSubFrom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            this.requestSubFrom = i;
            return this;
        }
        return (HttpRequestBuilder) invokeI.objValue;
    }

    public HttpRequestBuilder setRequestParamsHandler(IAsyncRequestParamsHandler iAsyncRequestParamsHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, iAsyncRequestParamsHandler)) == null) {
            this.paramsHandler = iAsyncRequestParamsHandler;
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder tag(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, obj)) == null) {
            this.tag = obj;
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder url(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.httpUrl = HttpUrl.parse(str);
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder userAgent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.headersBuilder.set("User-Agent", str);
            }
            return this;
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    public HttpRequestBuilder wifiOnly(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
            this.isWifiOnly = z;
            return this;
        }
        return (HttpRequestBuilder) invokeZ.objValue;
    }

    public HttpRequestBuilder writeTimeout(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            this.writeTimeout = i;
            return this;
        }
        return (HttpRequestBuilder) invokeI.objValue;
    }

    public RequestCall makeRequestCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return build().makeRequestCall();
        }
        return (RequestCall) invokeV.objValue;
    }
}
