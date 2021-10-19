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
/* loaded from: classes4.dex */
public final class x implements URLStreamHandlerFactory, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public w f32192e;

    /* renamed from: f  reason: collision with root package name */
    public c.d.b.e0.d f32193f;

    /* loaded from: classes4.dex */
    public class a extends URLStreamHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f32194a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f32195b;

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
            this.f32195b = xVar;
            this.f32194a = str;
        }

        @Override // java.net.URLStreamHandler
        public int getDefaultPort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f32194a.equals("http")) {
                    return 80;
                }
                if (this.f32194a.equals("https")) {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url)) == null) ? this.f32195b.f(url) : (URLConnection) invokeL.objValue;
        }

        @Override // java.net.URLStreamHandler
        public URLConnection openConnection(URL url, Proxy proxy) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, url, proxy)) == null) ? this.f32195b.g(url, proxy) : (URLConnection) invokeLL.objValue;
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
        this.f32192e = wVar;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str.equals("http") || str.equals("https")) {
                return new a(this, str);
            }
            return null;
        }
        return (URLStreamHandler) invokeL.objValue;
    }

    public w d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32192e : (w) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public x clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new x(this.f32192e) : (x) invokeV.objValue;
    }

    public HttpURLConnection f(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, url)) == null) ? g(url, this.f32192e.A()) : (HttpURLConnection) invokeL.objValue;
    }

    public HttpURLConnection g(URL url, Proxy proxy) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, url, proxy)) == null) {
            String protocol = url.getProtocol();
            w.b v = this.f32192e.v();
            v.m(proxy);
            w a2 = v.a();
            if (protocol.equals("http")) {
                return new OkHttpURLConnection(url, a2, this.f32193f);
            }
            if (protocol.equals("https")) {
                return new c.d.b.e0.l.c(url, a2, this.f32193f);
            }
            throw new IllegalArgumentException("Unexpected protocol: " + protocol);
        }
        return (HttpURLConnection) invokeLL.objValue;
    }

    public x h(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wVar)) == null) {
            this.f32192e = wVar;
            return this;
        }
        return (x) invokeL.objValue;
    }
}
