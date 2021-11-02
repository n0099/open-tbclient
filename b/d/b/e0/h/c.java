package b.d.b.e0.h;

import androidx.core.view.InputDeviceCompat;
import b.d.b.b0;
import b.d.b.d0;
import b.d.b.e0.k.e;
import b.d.b.e0.k.g;
import b.d.b.i;
import b.d.b.j;
import b.d.b.k;
import b.d.b.p;
import b.d.b.q;
import b.d.b.s;
import b.d.b.t;
import b.d.b.w;
import b.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import com.duxiaoman.okhttp3.internal.connection.RouteException;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.connection.RealConnection;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class c extends e.j implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final j f30230b;

    /* renamed from: c  reason: collision with root package name */
    public final d0 f30231c;

    /* renamed from: d  reason: collision with root package name */
    public Socket f30232d;

    /* renamed from: e  reason: collision with root package name */
    public Socket f30233e;

    /* renamed from: f  reason: collision with root package name */
    public q f30234f;

    /* renamed from: g  reason: collision with root package name */
    public Protocol f30235g;

    /* renamed from: h  reason: collision with root package name */
    public b.d.b.e0.k.e f30236h;

    /* renamed from: i  reason: collision with root package name */
    public BufferedSource f30237i;
    public BufferedSink j;
    public boolean k;
    public int l;
    public int m;
    public final List<Reference<f>> n;
    public long o;

    public c(j jVar, d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, d0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 1;
        this.n = new ArrayList();
        this.o = Long.MAX_VALUE;
        this.f30230b = jVar;
        this.f30231c = d0Var;
    }

    @Override // b.d.b.e0.k.e.j
    public void a(b.d.b.e0.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            synchronized (this.f30230b) {
                this.m = eVar.r();
            }
        }
    }

    @Override // b.d.b.e0.k.e.j
    public void b(g gVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            gVar.f(ErrorCode.REFUSED_STREAM);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.d.b.e0.e.g(this.f30232d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0094 A[Catch: IOException -> 0x00fd, TRY_LEAVE, TryCatch #2 {IOException -> 0x00fd, blocks: (B:20:0x008c, B:22:0x0094), top: B:75:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0146 A[EDGE_INSN: B:82:0x0146->B:63:0x0146 ?: BREAK  ] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i2, int i3, int i4, int i5, boolean z, b.d.b.e eVar, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), eVar, pVar}) == null) {
            if (this.f30235g == null) {
                List<k> b2 = this.f30231c.a().b();
                b bVar = new b(b2);
                if (this.f30231c.a().k() == null) {
                    if (b2.contains(k.f30514h)) {
                        String l = this.f30231c.a().l().l();
                        if (!b.d.b.e0.n.g.m().s(l)) {
                            throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + l + " not permitted by network security policy"));
                        }
                    } else {
                        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                    }
                } else if (this.f30231c.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                    throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
                }
                RouteException routeException = null;
                do {
                    try {
                        try {
                            if (this.f30231c.c()) {
                                g(i2, i3, i4, eVar, pVar);
                                if (this.f30232d == null) {
                                    if (!this.f30231c.c() && this.f30232d == null) {
                                        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                                    }
                                    if (this.f30236h == null) {
                                        synchronized (this.f30230b) {
                                            this.m = this.f30236h.r();
                                        }
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                try {
                                    e(i2, i3, eVar, pVar);
                                } catch (IOException e2) {
                                    e = e2;
                                    b.d.b.e0.e.g(this.f30233e);
                                    b.d.b.e0.e.g(this.f30232d);
                                    this.f30233e = null;
                                    this.f30232d = null;
                                    this.f30237i = null;
                                    this.j = null;
                                    this.f30234f = null;
                                    this.f30235g = null;
                                    this.f30236h = null;
                                    pVar.connectFailed(eVar, this.f30231c.d(), this.f30231c.b(), null, e);
                                    if (routeException != null) {
                                    }
                                    if (!z || bVar.b(e)) {
                                    }
                                    do {
                                        if (this.f30231c.c()) {
                                        }
                                        j(bVar, i5, eVar, pVar);
                                        pVar.connectEnd(eVar, this.f30231c.d(), this.f30231c.b(), this.f30235g);
                                        if (!this.f30231c.c()) {
                                        }
                                        if (this.f30236h == null) {
                                        }
                                    } while (bVar.b(e));
                                    throw routeException;
                                }
                            }
                            j(bVar, i5, eVar, pVar);
                            pVar.connectEnd(eVar, this.f30231c.d(), this.f30231c.b(), this.f30235g);
                            if (!this.f30231c.c()) {
                            }
                            if (this.f30236h == null) {
                            }
                        } catch (IOException e3) {
                            e = e3;
                            b.d.b.e0.e.g(this.f30233e);
                            b.d.b.e0.e.g(this.f30232d);
                            this.f30233e = null;
                            this.f30232d = null;
                            this.f30237i = null;
                            this.j = null;
                            this.f30234f = null;
                            this.f30235g = null;
                            this.f30236h = null;
                            pVar.connectFailed(eVar, this.f30231c.d(), this.f30231c.b(), null, e);
                            if (routeException != null) {
                                routeException = new RouteException(e);
                            } else {
                                routeException.addConnectException(e);
                            }
                            if (!z || bVar.b(e)) {
                                throw routeException;
                            }
                            do {
                                if (this.f30231c.c()) {
                                }
                                j(bVar, i5, eVar, pVar);
                                pVar.connectEnd(eVar, this.f30231c.d(), this.f30231c.b(), this.f30235g);
                                if (!this.f30231c.c()) {
                                }
                                if (this.f30236h == null) {
                                }
                            } while (bVar.b(e));
                            throw routeException;
                        }
                    } catch (IOException e4) {
                        e = e4;
                    }
                } while (bVar.b(e));
                throw routeException;
            }
            throw new IllegalStateException("already connected");
        }
    }

    public final void e(int i2, int i3, b.d.b.e eVar, p pVar) throws IOException {
        Socket createSocket;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), eVar, pVar}) == null) {
            Proxy b2 = this.f30231c.b();
            b.d.b.a a2 = this.f30231c.a();
            if (b2.type() != Proxy.Type.DIRECT && b2.type() != Proxy.Type.HTTP) {
                createSocket = new Socket(b2);
            } else {
                createSocket = a2.j().createSocket();
            }
            this.f30232d = createSocket;
            pVar.connectStart(eVar, this.f30231c.d(), b2);
            this.f30232d.setSoTimeout(i3);
            try {
                b.d.b.e0.n.g.m().i(this.f30232d, this.f30231c.d(), i2);
                try {
                    this.f30237i = Okio.buffer(Okio.source(this.f30232d));
                    this.j = Okio.buffer(Okio.sink(this.f30232d));
                } catch (NullPointerException e2) {
                    if (RealConnection.NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                        throw new IOException(e2);
                    }
                }
            } catch (ConnectException e3) {
                ConnectException connectException = new ConnectException("Failed to connect to " + this.f30231c.d());
                connectException.initCause(e3);
                throw connectException;
            }
        }
    }

    public final void f(b bVar) throws IOException {
        SSLSocket sSLSocket;
        Protocol protocol;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            b.d.b.a a2 = this.f30231c.a();
            SSLSocket sSLSocket2 = null;
            try {
                try {
                    sSLSocket = (SSLSocket) a2.k().createSocket(this.f30232d, a2.l().l(), a2.l().w(), true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (AssertionError e2) {
                e = e2;
            }
            try {
                k a3 = bVar.a(sSLSocket);
                if (a3.f()) {
                    b.d.b.e0.n.g.m().h(sSLSocket, a2.l().l(), a2.f());
                }
                sSLSocket.startHandshake();
                SSLSession session = sSLSocket.getSession();
                q b2 = q.b(session);
                if (!a2.e().verify(a2.l().l(), session)) {
                    List<Certificate> e3 = b2.e();
                    if (!e3.isEmpty()) {
                        X509Certificate x509Certificate = (X509Certificate) e3.get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + a2.l().l() + " not verified:\n    certificate: " + b.d.b.g.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + b.d.b.e0.p.d.a(x509Certificate));
                    }
                    throw new SSLPeerUnverifiedException("Hostname " + a2.l().l() + " not verified (no certificates)");
                }
                a2.a().a(a2.l().l(), b2.e());
                String p = a3.f() ? b.d.b.e0.n.g.m().p(sSLSocket) : null;
                this.f30233e = sSLSocket;
                this.f30237i = Okio.buffer(Okio.source(sSLSocket));
                this.j = Okio.buffer(Okio.sink(this.f30233e));
                this.f30234f = b2;
                if (p != null) {
                    protocol = Protocol.get(p);
                } else {
                    protocol = Protocol.HTTP_1_1;
                }
                this.f30235g = protocol;
                if (sSLSocket != null) {
                    b.d.b.e0.n.g.m().a(sSLSocket);
                }
            } catch (AssertionError e4) {
                e = e4;
                if (!b.d.b.e0.e.z(e)) {
                    throw e;
                }
                throw new IOException(e);
            } catch (Throwable th2) {
                th = th2;
                sSLSocket2 = sSLSocket;
                if (sSLSocket2 != null) {
                    b.d.b.e0.n.g.m().a(sSLSocket2);
                }
                b.d.b.e0.e.g(sSLSocket2);
                throw th;
            }
        }
    }

    public final void g(int i2, int i3, int i4, b.d.b.e eVar, p pVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, pVar}) == null) {
            z i5 = i();
            s h2 = i5.h();
            for (int i6 = 0; i6 < 21; i6++) {
                e(i2, i3, eVar, pVar);
                i5 = h(i3, i4, i5, h2);
                if (i5 == null) {
                    return;
                }
                b.d.b.e0.e.g(this.f30232d);
                this.f30232d = null;
                this.j = null;
                this.f30237i = null;
                pVar.connectEnd(eVar, this.f30231c.d(), this.f30231c.b(), null);
            }
        }
    }

    public final z h(int i2, int i3, z zVar, s sVar) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), zVar, sVar})) != null) {
            return (z) invokeCommon.objValue;
        }
        String str = "CONNECT " + b.d.b.e0.e.r(sVar, true) + " HTTP/1.1";
        while (true) {
            b.d.b.e0.j.a aVar = new b.d.b.e0.j.a(null, null, this.f30237i, this.j);
            this.f30237i.timeout().timeout(i2, TimeUnit.MILLISECONDS);
            this.j.timeout().timeout(i3, TimeUnit.MILLISECONDS);
            aVar.l(zVar.d(), str);
            aVar.finishRequest();
            b0.a readResponseHeaders = aVar.readResponseHeaders(false);
            readResponseHeaders.p(zVar);
            b0 c2 = readResponseHeaders.c();
            long b2 = b.d.b.e0.i.e.b(c2);
            if (b2 == -1) {
                b2 = 0;
            }
            Source h2 = aVar.h(b2);
            b.d.b.e0.e.C(h2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            h2.close();
            int code = c2.code();
            if (code == 200) {
                if (this.f30237i.buffer().exhausted() && this.j.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (code == 407) {
                z a2 = this.f30231c.a().h().a(this.f30231c, c2);
                if (a2 != null) {
                    if (IntentConfig.CLOSE.equalsIgnoreCase(c2.g(HTTP.CONN_DIRECTIVE))) {
                        return a2;
                    }
                    zVar = a2;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + c2.code());
            }
        }
    }

    @Override // b.d.b.i
    public q handshake() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f30234f : (q) invokeV.objValue;
    }

    public final z i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            z.a aVar = new z.a();
            aVar.g(this.f30231c.a().l());
            aVar.e("CONNECT", null);
            aVar.c("Host", b.d.b.e0.e.r(this.f30231c.a().l(), true));
            aVar.c("Proxy-Connection", HTTP.CONN_KEEP_ALIVE);
            aVar.c("User-Agent", b.d.b.e0.f.a());
            z b2 = aVar.b();
            b0.a aVar2 = new b0.a();
            aVar2.p(b2);
            aVar2.n(Protocol.HTTP_1_1);
            aVar2.g(407);
            aVar2.k("Preemptive Authenticate");
            aVar2.b(b.d.b.e0.e.f30191c);
            aVar2.q(-1L);
            aVar2.o(-1L);
            aVar2.i(AUTH.PROXY_AUTH, "OkHttp-Preemptive");
            z a2 = this.f30231c.a().h().a(this.f30231c, aVar2.c());
            return a2 != null ? a2 : b2;
        }
        return (z) invokeV.objValue;
    }

    public final void j(b bVar, int i2, b.d.b.e eVar, p pVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048586, this, bVar, i2, eVar, pVar) == null) {
            if (this.f30231c.a().k() == null) {
                if (this.f30231c.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                    this.f30233e = this.f30232d;
                    this.f30235g = Protocol.H2_PRIOR_KNOWLEDGE;
                    p(i2);
                    return;
                }
                this.f30233e = this.f30232d;
                this.f30235g = Protocol.HTTP_1_1;
                return;
            }
            pVar.secureConnectStart(eVar);
            f(bVar);
            pVar.secureConnectEnd(eVar, this.f30234f);
            if (this.f30235g == Protocol.HTTP_2) {
                p(i2);
            }
        }
    }

    public boolean k(b.d.b.a aVar, @Nullable d0 d0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, aVar, d0Var)) == null) {
            if (this.n.size() >= this.m || this.k || !b.d.b.e0.a.f30186a.g(this.f30231c.a(), aVar)) {
                return false;
            }
            if (aVar.l().l().equals(route().a().l().l())) {
                return true;
            }
            if (this.f30236h != null && d0Var != null && d0Var.b().type() == Proxy.Type.DIRECT && this.f30231c.b().type() == Proxy.Type.DIRECT && this.f30231c.d().equals(d0Var.d()) && d0Var.a().e() == b.d.b.e0.p.d.f30485a && q(aVar.l())) {
                try {
                    aVar.a().a(aVar.l().l(), handshake().e());
                    return true;
                } catch (SSLPeerUnverifiedException unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            if (this.f30233e.isClosed() || this.f30233e.isInputShutdown() || this.f30233e.isOutputShutdown()) {
                return false;
            }
            b.d.b.e0.k.e eVar = this.f30236h;
            if (eVar != null) {
                return eVar.q(System.nanoTime());
            }
            if (z) {
                try {
                    int soTimeout = this.f30233e.getSoTimeout();
                    this.f30233e.setSoTimeout(1);
                    if (this.f30237i.exhausted()) {
                        this.f30233e.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.f30233e.setSoTimeout(soTimeout);
                    return true;
                } catch (SocketTimeoutException unused) {
                } catch (IOException unused2) {
                    return false;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f30236h != null : invokeV.booleanValue;
    }

    public b.d.b.e0.i.c n(w wVar, t.a aVar, f fVar) throws SocketException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, wVar, aVar, fVar)) == null) {
            if (this.f30236h != null) {
                return new b.d.b.e0.k.d(wVar, aVar, fVar, this.f30236h);
            }
            this.f30233e.setSoTimeout(aVar.readTimeoutMillis());
            this.f30237i.timeout().timeout(aVar.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.j.timeout().timeout(aVar.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
            return new b.d.b.e0.j.a(wVar, fVar, this.f30237i, this.j);
        }
        return (b.d.b.e0.i.c) invokeLLL.objValue;
    }

    public Socket o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f30233e : (Socket) invokeV.objValue;
    }

    public final void p(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f30233e.setSoTimeout(0);
            e.h hVar = new e.h(true);
            hVar.d(this.f30233e, this.f30231c.a().l().l(), this.f30237i, this.j);
            hVar.b(this);
            hVar.c(i2);
            b.d.b.e0.k.e a2 = hVar.a();
            this.f30236h = a2;
            a2.D();
        }
    }

    @Override // b.d.b.i
    public Protocol protocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f30235g : (Protocol) invokeV.objValue;
    }

    public boolean q(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, sVar)) == null) {
            if (sVar.w() != this.f30231c.a().l().w()) {
                return false;
            }
            if (sVar.l().equals(this.f30231c.a().l().l())) {
                return true;
            }
            return this.f30234f != null && b.d.b.e0.p.d.f30485a.c(sVar.l(), (X509Certificate) this.f30234f.e().get(0));
        }
        return invokeL.booleanValue;
    }

    @Override // b.d.b.i
    public d0 route() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f30231c : (d0) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Connection{");
            sb.append(this.f30231c.a().l().l());
            sb.append(":");
            sb.append(this.f30231c.a().l().w());
            sb.append(", proxy=");
            sb.append(this.f30231c.b());
            sb.append(" hostAddress=");
            sb.append(this.f30231c.d());
            sb.append(" cipherSuite=");
            q qVar = this.f30234f;
            sb.append(qVar != null ? qVar.a() : "none");
            sb.append(" protocol=");
            sb.append(this.f30235g);
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
