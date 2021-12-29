package c.d.b;

import c.d.b.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.internal.huc.OkHttpURLConnection;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
/* loaded from: classes9.dex */
public final class x implements URLStreamHandlerFactory, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public w f28907e;

    /* renamed from: f  reason: collision with root package name */
    public c.d.b.e0.d f28908f;

    /* loaded from: classes9.dex */
    public class a extends URLStreamHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f28909b;

        public a(x xVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28909b = xVar;
            this.a = str;
        }

        @Override // java.net.URLStreamHandler
        public int getDefaultPort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.equals("http")) {
                    return 80;
                }
                if (this.a.equals("https")) {
                    return Constants.SOCKET_PORT_SSL;
                }
                throw new AssertionError();
            }
            return invokeV.intValue;
        }

        @Override // java.net.URLStreamHandler
        public URLConnection openConnection(URL url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url)) == null) ? this.f28909b.c(url) : (URLConnection) invokeL.objValue;
        }

        @Override // java.net.URLStreamHandler
        public URLConnection openConnection(URL url, Proxy proxy) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, url, proxy)) == null) ? this.f28909b.e(url, proxy) : (URLConnection) invokeLL.objValue;
        }
    }

    public x(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28907e = wVar;
    }

    public w a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28907e : (w) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public x clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new x(this.f28907e) : (x) invokeV.objValue;
    }

    public HttpURLConnection c(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, url)) == null) ? e(url, this.f28907e.y()) : (HttpURLConnection) invokeL.objValue;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str.equals("http") || str.equals("https")) {
                return new a(this, str);
            }
            return null;
        }
        return (URLStreamHandler) invokeL.objValue;
    }

    public HttpURLConnection e(URL url, Proxy proxy) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, url, proxy)) == null) {
            String protocol = url.getProtocol();
            w.b t = this.f28907e.t();
            t.m(proxy);
            w a2 = t.a();
            if (protocol.equals("http")) {
                return new OkHttpURLConnection(url, a2, this.f28908f);
            }
            if (protocol.equals("https")) {
                return new c.d.b.e0.l.c(url, a2, this.f28908f);
            }
            throw new IllegalArgumentException("Unexpected protocol: " + protocol);
        }
        return (HttpURLConnection) invokeLL.objValue;
    }

    public x f(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wVar)) == null) {
            this.f28907e = wVar;
            return this;
        }
        return (x) invokeL.objValue;
    }
}
