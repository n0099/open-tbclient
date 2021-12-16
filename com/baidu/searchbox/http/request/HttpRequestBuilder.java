package com.baidu.searchbox.http.request;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class HttpRequestBuilder<T extends HttpRequestBuilder> {
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

    public HttpRequestBuilder(AbstractHttpManager abstractHttpManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {abstractHttpManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public T addHeader(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            this.headersBuilder.add(str, str2);
            return this;
        }
        return (T) invokeLL.objValue;
    }

    public T addHeaders(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.headersBuilder.add(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T addUrlParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
            newBuilder.addQueryParameter(str, str2);
            this.httpUrl = newBuilder.build();
            return this;
        }
        return (T) invokeLL.objValue;
    }

    public T addUrlParams(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
            if (map != null && map.size() > 0) {
                HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    newBuilder.addQueryParameter(entry.getKey(), entry.getValue());
                }
                this.httpUrl = newBuilder.build();
            }
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T autoRetry(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.enableRetry = z;
            return this;
        }
        return (T) invokeZ.objValue;
    }

    public abstract HttpRequest build();

    public T connectionTimeout(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.connectionTimeout = i2;
            return this;
        }
        return (T) invokeI.objValue;
    }

    public T cookieManager(CookieManager cookieManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cookieManager)) == null) {
            this.cookieManager = cookieManager;
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T enableStat(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.isReqNetStatEnable = z;
            return this;
        }
        return (T) invokeZ.objValue;
    }

    public T extraUserLog(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
            this.extraUserLog = jSONObject;
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T followRedirects(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.followRedirects = z;
            return this;
        }
        return (T) invokeZ.objValue;
    }

    public T followSslRedirects(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.followSslRedirects = z;
            return this;
        }
        return (T) invokeZ.objValue;
    }

    public T headers(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, map)) == null) {
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.headersBuilder.set(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T log(String str, LogInterceptor.Level level) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, level)) == null) {
            this.logTag = str;
            this.logLevel = level;
            return this;
        }
        return (T) invokeLL.objValue;
    }

    public RequestCall makeRequestCall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? build().makeRequestCall() : (RequestCall) invokeV.objValue;
    }

    public T proxy(Proxy proxy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, proxy)) == null) {
            this.proxy = proxy;
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T readTimeout(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.readTimeout = i2;
            return this;
        }
        return (T) invokeI.objValue;
    }

    public T removeHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.headersBuilder.removeAll(str);
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T removeHeaders(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (String str : list) {
                    this.headersBuilder.removeAll(str);
                }
            }
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T removeUrlParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
            newBuilder.removeAllQueryParameters(str);
            this.httpUrl = newBuilder.build();
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T removeUrlParams(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, list)) == null) {
            if (list != null && list.size() > 0) {
                HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
                for (String str : list) {
                    newBuilder.removeAllQueryParameters(str);
                }
                this.httpUrl = newBuilder.build();
            }
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T requestFrom(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            this.requestFrom = i2;
            return this;
        }
        return (T) invokeI.objValue;
    }

    public T requestSubFrom(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            this.requestSubFrom = i2;
            return this;
        }
        return (T) invokeI.objValue;
    }

    public T setHeader(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, str2)) == null) {
            this.headersBuilder.set(str, str2);
            return this;
        }
        return (T) invokeLL.objValue;
    }

    public T setRequestParamsHandler(IAsyncRequestParamsHandler iAsyncRequestParamsHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, iAsyncRequestParamsHandler)) == null) {
            this.paramsHandler = iAsyncRequestParamsHandler;
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T setUrlParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) == null) {
            HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
            newBuilder.setQueryParameter(str, str2);
            this.httpUrl = newBuilder.build();
            return this;
        }
        return (T) invokeLL.objValue;
    }

    public T setUrlParams(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, map)) == null) {
            if (map != null && map.size() > 0) {
                HttpUrl.Builder newBuilder = this.httpUrl.newBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    newBuilder.setQueryParameter(entry.getKey(), entry.getValue());
                }
                this.httpUrl = newBuilder.build();
            }
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T tag(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, obj)) == null) {
            this.tag = obj;
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T url(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.httpUrl = HttpUrl.parse(str);
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T userAgent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.headersBuilder.set("User-Agent", str);
            }
            return this;
        }
        return (T) invokeL.objValue;
    }

    public T wifiOnly(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
            this.isWifiOnly = z;
            return this;
        }
        return (T) invokeZ.objValue;
    }

    public T writeTimeout(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            this.writeTimeout = i2;
            return this;
        }
        return (T) invokeI.objValue;
    }

    public HttpRequestBuilder(HttpRequest httpRequest, AbstractHttpManager abstractHttpManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpRequest, abstractHttpManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
