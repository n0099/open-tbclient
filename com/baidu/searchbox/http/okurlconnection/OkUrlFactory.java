package com.baidu.searchbox.http.okurlconnection;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import okhttp3.OkHttpClient;
import okhttp3.internal.annotations.EverythingIsNonNull;
@EverythingIsNonNull
/* loaded from: classes2.dex */
public final class OkUrlFactory implements URLStreamHandlerFactory, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient client;
    public URLFilter urlFilter;

    public OkUrlFactory(OkHttpClient okHttpClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.client = okHttpClient;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!"http".equals(str) && !"https".equals(str)) {
                return null;
            }
            return new URLStreamHandler(this, str) { // from class: com.baidu.searchbox.http.okurlconnection.OkUrlFactory.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OkUrlFactory this$0;
                public final /* synthetic */ String val$protocol;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$protocol = str;
                }

                @Override // java.net.URLStreamHandler
                public int getDefaultPort() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if ("https".equals(this.val$protocol)) {
                            return 80;
                        }
                        if ("https".equals(this.val$protocol)) {
                            return 443;
                        }
                        throw new AssertionError();
                    }
                    return invokeV.intValue;
                }

                @Override // java.net.URLStreamHandler
                public URLConnection openConnection(URL url) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url)) == null) {
                        return this.this$0.open(url);
                    }
                    return (URLConnection) invokeL2.objValue;
                }

                @Override // java.net.URLStreamHandler
                public URLConnection openConnection(URL url, Proxy proxy) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, url, proxy)) == null) {
                        return this.this$0.open(url, proxy);
                    }
                    return (URLConnection) invokeLL.objValue;
                }
            };
        }
        return (URLStreamHandler) invokeL.objValue;
    }

    public HttpURLConnection open(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, url)) == null) {
            return open(url, this.client.proxy());
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public OkUrlFactory setClient(OkHttpClient okHttpClient) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, okHttpClient)) == null) {
            this.client = okHttpClient;
            return this;
        }
        return (OkUrlFactory) invokeL.objValue;
    }

    public void setUrlFilter(URLFilter uRLFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, uRLFilter) == null) {
            this.urlFilter = uRLFilter;
        }
    }

    public OkHttpClient client() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.client;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public OkUrlFactory m42clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new OkUrlFactory(this.client);
        }
        return (OkUrlFactory) invokeV.objValue;
    }

    public HttpURLConnection open(URL url, Proxy proxy) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, url, proxy)) == null) {
            String protocol = url.getProtocol();
            OkHttpClient build = this.client.newBuilder().proxy(proxy).build();
            if ("http".equals(protocol)) {
                return new OkHttpURLConnection(url, build, this.urlFilter);
            }
            if ("https".equals(protocol)) {
                return new OkHttpsURLConnection(url, build, this.urlFilter);
            }
            throw new IllegalArgumentException("Unexpected protocol: " + protocol);
        }
        return (HttpURLConnection) invokeLL.objValue;
    }
}
