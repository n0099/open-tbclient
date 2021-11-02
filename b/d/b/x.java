package b.d.b;

import b.d.b.w;
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
/* loaded from: classes6.dex */
public final class x implements URLStreamHandlerFactory, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public w f30589e;

    /* renamed from: f  reason: collision with root package name */
    public b.d.b.e0.d f30590f;

    /* loaded from: classes6.dex */
    public class a extends URLStreamHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f30591a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f30592b;

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
            this.f30592b = xVar;
            this.f30591a = str;
        }

        @Override // java.net.URLStreamHandler
        public int getDefaultPort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f30591a.equals("http")) {
                    return 80;
                }
                if (this.f30591a.equals("https")) {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url)) == null) ? this.f30592b.c(url) : (URLConnection) invokeL.objValue;
        }

        @Override // java.net.URLStreamHandler
        public URLConnection openConnection(URL url, Proxy proxy) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, url, proxy)) == null) ? this.f30592b.e(url, proxy) : (URLConnection) invokeLL.objValue;
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
        this.f30589e = wVar;
    }

    public w a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30589e : (w) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public x clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new x(this.f30589e) : (x) invokeV.objValue;
    }

    public HttpURLConnection c(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, url)) == null) ? e(url, this.f30589e.y()) : (HttpURLConnection) invokeL.objValue;
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
            w.b t = this.f30589e.t();
            t.m(proxy);
            w a2 = t.a();
            if (protocol.equals("http")) {
                return new OkHttpURLConnection(url, a2, this.f30590f);
            }
            if (protocol.equals("https")) {
                return new b.d.b.e0.l.c(url, a2, this.f30590f);
            }
            throw new IllegalArgumentException("Unexpected protocol: " + protocol);
        }
        return (HttpURLConnection) invokeLL.objValue;
    }

    public x f(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wVar)) == null) {
            this.f30589e = wVar;
            return this;
        }
        return (x) invokeL.objValue;
    }
}
