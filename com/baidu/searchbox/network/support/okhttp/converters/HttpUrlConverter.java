package com.baidu.searchbox.network.support.okhttp.converters;

import com.baidu.searchbox.network.outback.core.UrlWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.HttpUrl;
/* loaded from: classes3.dex */
public class HttpUrlConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpUrlConverter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static HttpUrl.Builder deepCopyBuilder(com.baidu.searchbox.network.outback.core.HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, httpUrl)) == null) {
            HttpUrl.Builder builder = new HttpUrl.Builder();
            builder.scheme(httpUrl.scheme());
            builder.port(httpUrl.port());
            builder.host(httpUrl.host());
            builder.encodedUsername(httpUrl.encodedUsername());
            builder.encodedPassword(httpUrl.encodedPassword());
            builder.encodedFragment(httpUrl.encodedFragment());
            builder.query(httpUrl.encodedQuery());
            for (String str : httpUrl.pathSegments()) {
                builder.addPathSegment(str);
            }
            return builder;
        }
        return (HttpUrl.Builder) invokeL.objValue;
    }

    public static com.baidu.searchbox.network.outback.core.HttpUrl fromOks(HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpUrl)) == null) {
            ConverterUtils.requireNonNull(httpUrl, "ok httpUrl should not be null");
            return com.baidu.searchbox.network.outback.core.HttpUrl.parse(httpUrl.toString());
        }
        return (com.baidu.searchbox.network.outback.core.HttpUrl) invokeL.objValue;
    }

    public static HttpUrl toOks(UrlWrapper urlWrapper) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, urlWrapper)) == null) {
            ConverterUtils.requireNonNull(urlWrapper, "httpUrl should not be null");
            if (urlWrapper.getDefaultHttpUrl() != null) {
                return deepCopyBuilder(urlWrapper.getDefaultHttpUrl()).build();
            }
            return HttpUrl.parse(urlWrapper.toString());
        }
        return (HttpUrl) invokeL.objValue;
    }
}
