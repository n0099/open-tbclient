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
/* loaded from: classes4.dex */
public final class j implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f31869a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c.d.b.e0.h.f f31870b;

    /* renamed from: c  reason: collision with root package name */
    public Object f31871c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f31872d;

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
        this.f31869a = wVar;
    }

    @Override // c.d.b.t
    public b0 a(t.a aVar) throws IOException {
        InterceptResult invokeL;
        b0 e2;
        z d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            z request = aVar.request();
            g gVar = (g) aVar;
            c.d.b.e b2 = gVar.b();
            p c2 = gVar.c();
            c.d.b.e0.h.f fVar = new c.d.b.e0.h.f(this.f31869a.h(), c(request.h()), b2, c2, this.f31871c);
            this.f31870b = fVar;
            b0 b0Var = null;
            int i2 = 0;
            while (!this.f31872d) {
                try {
                    try {
                        e2 = gVar.e(request, fVar, null, null);
                        if (b0Var != null) {
                            b0.a z = e2.z();
                            b0.a z2 = b0Var.z();
                            z2.b(null);
                            z.m(z2.c());
                            e2 = z.c();
                        }
                        try {
                            d2 = d(e2, fVar.t());
                        } catch (IOException e3) {
                            fVar.p();
                            throw e3;
                        }
                    } catch (RouteException e4) {
                        if (!g(e4.getLastConnectException(), fVar, false, request)) {
                            throw e4.getFirstConnectException();
                        }
                    } catch (IOException e5) {
                        if (!g(e5, fVar, !(e5 instanceof ConnectionShutdownException), request)) {
                            throw e5;
                        }
                    }
                    if (d2 == null) {
                        fVar.p();
                        return e2;
                    }
                    c.d.b.e0.e.f(e2.g());
                    int i3 = i2 + 1;
                    if (i3 <= 20) {
                        if (!(d2.a() instanceof l)) {
                            if (!j(e2, d2.h())) {
                                fVar.p();
                                fVar = new c.d.b.e0.h.f(this.f31869a.h(), c(d2.h()), b2, c2, this.f31871c);
                                this.f31870b = fVar;
                            } else if (fVar.c() != null) {
                                throw new IllegalStateException("Closing the body of " + e2 + " didn't close its backing stream. Bad interceptor?");
                            }
                            b0Var = e2;
                            request = d2;
                            i2 = i3;
                        } else {
                            fVar.p();
                            throw new HttpRetryException("Cannot retry streamed HTTP body", e2.code());
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
            this.f31872d = true;
            c.d.b.e0.h.f fVar = this.f31870b;
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
                SSLSocketFactory G = this.f31869a.G();
                hostnameVerifier = this.f31869a.q();
                sSLSocketFactory = G;
                gVar = this.f31869a.f();
            } else {
                sSLSocketFactory = null;
                hostnameVerifier = null;
                gVar = null;
            }
            return new c.d.b.a(sVar.l(), sVar.w(), this.f31869a.l(), this.f31869a.F(), sSLSocketFactory, hostnameVerifier, gVar, this.f31869a.B(), this.f31869a.A(), this.f31869a.z(), this.f31869a.i(), this.f31869a.C());
        }
        return (c.d.b.a) invokeL.objValue;
    }

    public final z d(b0 b0Var, d0 d0Var) throws IOException {
        InterceptResult invokeLL;
        String s;
        s A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, b0Var, d0Var)) == null) {
            if (b0Var != null) {
                int code = b0Var.code();
                String f2 = b0Var.D().f();
                if (code == 307 || code == 308) {
                    if (!f2.equals("GET") && !f2.equals("HEAD")) {
                        return null;
                    }
                } else if (code != 401) {
                    if (code == 503) {
                        if ((b0Var.A() == null || b0Var.A().code() != 503) && i(b0Var, Integer.MAX_VALUE) == 0) {
                            return b0Var.D();
                        }
                        return null;
                    } else if (code == 407) {
                        if (d0Var.b().type() == Proxy.Type.HTTP) {
                            return this.f31869a.B().a(d0Var, b0Var);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (code == 408) {
                        if (this.f31869a.E() && !(b0Var.D().a() instanceof l)) {
                            if ((b0Var.A() == null || b0Var.A().code() != 408) && i(b0Var, 0) <= 0) {
                                return b0Var.D();
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
                    return this.f31869a.d().a(d0Var, b0Var);
                }
                if (!this.f31869a.n() || (s = b0Var.s("Location")) == null || (A = b0Var.D().h().A(s)) == null) {
                    return null;
                }
                if (A.B().equals(b0Var.D().h().B()) || this.f31869a.o()) {
                    z.a g2 = b0Var.D().g();
                    if (f.b(f2)) {
                        boolean d2 = f.d(f2);
                        if (f.c(f2)) {
                            g2.e("GET", null);
                        } else {
                            g2.e(f2, d2 ? b0Var.D().a() : null);
                        }
                        if (!d2) {
                            g2.f("Transfer-Encoding");
                            g2.f("Content-Length");
                            g2.f("Content-Type");
                        }
                    }
                    if (!j(b0Var, A)) {
                        g2.f("Authorization");
                    }
                    g2.g(A);
                    return g2.b();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31872d : invokeV.booleanValue;
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
            if (this.f31869a.E()) {
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
            String s = b0Var.s("Retry-After");
            if (s == null) {
                return i2;
            }
            if (s.matches("\\d+")) {
                return Integer.valueOf(s).intValue();
            }
            return Integer.MAX_VALUE;
        }
        return invokeLI.intValue;
    }

    public final boolean j(b0 b0Var, s sVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, b0Var, sVar)) == null) {
            s h2 = b0Var.D().h();
            return h2.l().equals(sVar.l()) && h2.w() == sVar.w() && h2.B().equals(sVar.B());
        }
        return invokeLL.booleanValue;
    }

    public void k(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, obj) == null) {
            this.f31871c = obj;
        }
    }
}
