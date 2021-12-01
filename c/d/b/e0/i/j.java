package c.d.b.e0.i;

import androidx.core.view.InputDeviceCompat;
import c.d.b.b0;
import c.d.b.d0;
import c.d.b.p;
import c.d.b.s;
import c.d.b.t;
import c.d.b.w;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.internal.connection.RouteException;
import com.duxiaoman.okhttp3.internal.http2.ConnectionShutdownException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes7.dex */
public final class j implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c.d.b.e0.h.f f28177b;

    /* renamed from: c  reason: collision with root package name */
    public Object f28178c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f28179d;

    public j(w wVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wVar;
    }

    @Override // c.d.b.t
    public b0 a(t.a aVar) throws IOException {
        InterceptResult invokeL;
        b0 d2;
        z d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            z request = aVar.request();
            g gVar = (g) aVar;
            c.d.b.e call = gVar.call();
            p b2 = gVar.b();
            c.d.b.e0.h.f fVar = new c.d.b.e0.h.f(this.a.f(), c(request.h()), call, b2, this.f28178c);
            this.f28177b = fVar;
            b0 b0Var = null;
            int i2 = 0;
            while (!this.f28179d) {
                try {
                    try {
                        d2 = gVar.d(request, fVar, null, null);
                        if (b0Var != null) {
                            b0.a n = d2.n();
                            b0.a n2 = b0Var.n();
                            n2.b(null);
                            n.m(n2.c());
                            d2 = n.c();
                        }
                        try {
                            d3 = d(d2, fVar.t());
                        } catch (IOException e2) {
                            fVar.p();
                            throw e2;
                        }
                    } catch (RouteException e3) {
                        if (!g(e3.getLastConnectException(), fVar, false, request)) {
                            throw e3.getFirstConnectException();
                        }
                    } catch (IOException e4) {
                        if (!g(e4, fVar, !(e4 instanceof ConnectionShutdownException), request)) {
                            throw e4;
                        }
                    }
                    if (d3 == null) {
                        fVar.p();
                        return d2;
                    }
                    c.d.b.e0.e.f(d2.a());
                    int i3 = i2 + 1;
                    if (i3 <= 20) {
                        if (!(d3.a() instanceof l)) {
                            if (!j(d2, d3.h())) {
                                fVar.p();
                                fVar = new c.d.b.e0.h.f(this.a.f(), c(d3.h()), call, b2, this.f28178c);
                                this.f28177b = fVar;
                            } else if (fVar.c() != null) {
                                throw new IllegalStateException("Closing the body of " + d2 + " didn't close its backing stream. Bad interceptor?");
                            }
                            b0Var = d2;
                            request = d3;
                            i2 = i3;
                        } else {
                            fVar.p();
                            throw new HttpRetryException("Cannot retry streamed HTTP body", d2.code());
                        }
                    } else {
                        fVar.p();
                        throw new ProtocolException("Too many follow-up requests: " + i3);
                    }
                } catch (Throwable th) {
                    fVar.v(null);
                    fVar.p();
                    throw th;
                }
            }
            fVar.p();
            throw new IOException(ResponseException.CANCELED);
        }
        return (b0) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f28179d = true;
            c.d.b.e0.h.f fVar = this.f28177b;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    public final c.d.b.a c(s sVar) {
        InterceptResult invokeL;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        c.d.b.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sVar)) == null) {
            if (sVar.m()) {
                SSLSocketFactory E = this.a.E();
                hostnameVerifier = this.a.o();
                sSLSocketFactory = E;
                gVar = this.a.c();
            } else {
                sSLSocketFactory = null;
                hostnameVerifier = null;
                gVar = null;
            }
            return new c.d.b.a(sVar.l(), sVar.w(), this.a.j(), this.a.D(), sSLSocketFactory, hostnameVerifier, gVar, this.a.z(), this.a.y(), this.a.x(), this.a.g(), this.a.A());
        }
        return (c.d.b.a) invokeL.objValue;
    }

    public final z d(b0 b0Var, d0 d0Var) throws IOException {
        InterceptResult invokeLL;
        String g2;
        s z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, b0Var, d0Var)) == null) {
            if (b0Var != null) {
                int code = b0Var.code();
                String f2 = b0Var.r().f();
                if (code == 307 || code == 308) {
                    if (!f2.equals("GET") && !f2.equals("HEAD")) {
                        return null;
                    }
                } else if (code != 401) {
                    if (code == 503) {
                        if ((b0Var.o() == null || b0Var.o().code() != 503) && i(b0Var, Integer.MAX_VALUE) == 0) {
                            return b0Var.r();
                        }
                        return null;
                    } else if (code == 407) {
                        if (d0Var.b().type() == Proxy.Type.HTTP) {
                            return this.a.z().a(d0Var, b0Var);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (code == 408) {
                        if (this.a.C() && !(b0Var.r().a() instanceof l)) {
                            if ((b0Var.o() == null || b0Var.o().code() != 408) && i(b0Var, 0) <= 0) {
                                return b0Var.r();
                            }
                            return null;
                        }
                        return null;
                    } else {
                        switch (code) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    }
                } else {
                    return this.a.a().a(d0Var, b0Var);
                }
                if (!this.a.l() || (g2 = b0Var.g("Location")) == null || (z = b0Var.r().h().z(g2)) == null) {
                    return null;
                }
                if (z.A().equals(b0Var.r().h().A()) || this.a.m()) {
                    z.a g3 = b0Var.r().g();
                    if (f.b(f2)) {
                        boolean d2 = f.d(f2);
                        if (f.c(f2)) {
                            g3.e("GET", null);
                        } else {
                            g3.e(f2, d2 ? b0Var.r().a() : null);
                        }
                        if (!d2) {
                            g3.f("Transfer-Encoding");
                            g3.f("Content-Length");
                            g3.f("Content-Type");
                        }
                    }
                    if (!j(b0Var, z)) {
                        g3.f("Authorization");
                    }
                    g3.g(z);
                    return g3.b();
                }
                return null;
            }
            throw new IllegalStateException();
        }
        return (z) invokeLL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28179d : invokeV.booleanValue;
    }

    public final boolean f(IOException iOException, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, iOException, z)) == null) {
            if (iOException instanceof ProtocolException) {
                return false;
            }
            return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
        }
        return invokeLZ.booleanValue;
    }

    public final boolean g(IOException iOException, c.d.b.e0.h.f fVar, boolean z, z zVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{iOException, fVar, Boolean.valueOf(z), zVar})) == null) {
            fVar.v(iOException);
            if (this.a.C()) {
                return !(z && h(iOException, zVar)) && f(iOException, z) && fVar.j();
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean h(IOException iOException, z zVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, iOException, zVar)) == null) ? (zVar.a() instanceof l) || (iOException instanceof FileNotFoundException) : invokeLL.booleanValue;
    }

    public final int i(b0 b0Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, b0Var, i2)) == null) {
            String g2 = b0Var.g("Retry-After");
            if (g2 == null) {
                return i2;
            }
            if (g2.matches("\\d+")) {
                return Integer.valueOf(g2).intValue();
            }
            return Integer.MAX_VALUE;
        }
        return invokeLI.intValue;
    }

    public final boolean j(b0 b0Var, s sVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, b0Var, sVar)) == null) {
            s h2 = b0Var.r().h();
            return h2.l().equals(sVar.l()) && h2.w() == sVar.w() && h2.A().equals(sVar.A());
        }
        return invokeLL.booleanValue;
    }

    public void k(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, obj) == null) {
            this.f28178c = obj;
        }
    }
}
