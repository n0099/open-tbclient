package c.d.b.e0.g;

import androidx.core.view.InputDeviceCompat;
import c.d.b.b0;
import c.d.b.e0.g.c;
import c.d.b.e0.i.f;
import c.d.b.e0.i.h;
import c.d.b.r;
import c.d.b.t;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class a implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e a;

    /* renamed from: c.d.b.e0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1645a implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27813e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BufferedSource f27814f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f27815g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ BufferedSink f27816h;

        public C1645a(a aVar, BufferedSource bufferedSource, b bVar, BufferedSink bufferedSink) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bufferedSource, bVar, bufferedSink};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27814f = bufferedSource;
            this.f27815g = bVar;
            this.f27816h = bufferedSink;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f27813e && !c.d.b.e0.e.o(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f27813e = true;
                    this.f27815g.abort();
                }
                this.f27814f.close();
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j2)) == null) {
                try {
                    long read = this.f27814f.read(buffer, j2);
                    if (read == -1) {
                        if (!this.f27813e) {
                            this.f27813e = true;
                            this.f27816h.close();
                        }
                        return -1L;
                    }
                    buffer.copyTo(this.f27816h.buffer(), buffer.size() - read, read);
                    this.f27816h.emitCompleteSegments();
                    return read;
                } catch (IOException e2) {
                    if (!this.f27813e) {
                        this.f27813e = true;
                        this.f27815g.abort();
                    }
                    throw e2;
                }
            }
            return invokeLJ.longValue;
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27814f.timeout() : (Timeout) invokeV.objValue;
        }
    }

    public a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eVar;
    }

    public static r c(r rVar, r rVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, rVar, rVar2)) == null) {
            r.a aVar = new r.a();
            int g2 = rVar.g();
            for (int i2 = 0; i2 < g2; i2++) {
                String e2 = rVar.e(i2);
                String h2 = rVar.h(i2);
                if ((!"Warning".equalsIgnoreCase(e2) || !h2.startsWith("1")) && (d(e2) || !e(e2) || rVar2.c(e2) == null)) {
                    c.d.b.e0.a.a.b(aVar, e2, h2);
                }
            }
            int g3 = rVar2.g();
            for (int i3 = 0; i3 < g3; i3++) {
                String e3 = rVar2.e(i3);
                if (!d(e3) && e(e3)) {
                    c.d.b.e0.a.a.b(aVar, e3, rVar2.h(i3));
                }
            }
            return aVar.d();
        }
        return (r) invokeLL.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str) : invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true : invokeL.booleanValue;
    }

    public static b0 f(b0 b0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, b0Var)) == null) {
            if (b0Var == null || b0Var.a() == null) {
                return b0Var;
            }
            b0.a n = b0Var.n();
            n.b(null);
            return n.c();
        }
        return (b0) invokeL.objValue;
    }

    @Override // c.d.b.t
    public b0 a(t.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            e eVar = this.a;
            b0 d2 = eVar != null ? eVar.d(aVar.request()) : null;
            c c2 = new c.a(System.currentTimeMillis(), aVar.request(), d2).c();
            z zVar = c2.a;
            b0 b0Var = c2.f27817b;
            e eVar2 = this.a;
            if (eVar2 != null) {
                eVar2.c(c2);
            }
            if (d2 != null && b0Var == null) {
                c.d.b.e0.e.f(d2.a());
            }
            if (zVar == null && b0Var == null) {
                b0.a aVar2 = new b0.a();
                aVar2.p(aVar.request());
                aVar2.n(Protocol.HTTP_1_1);
                aVar2.g(504);
                aVar2.k("Unsatisfiable Request (only-if-cached)");
                aVar2.b(c.d.b.e0.e.f27804c);
                aVar2.q(-1L);
                aVar2.o(System.currentTimeMillis());
                return aVar2.c();
            } else if (zVar == null) {
                b0.a n = b0Var.n();
                n.d(f(b0Var));
                return n.c();
            } else {
                try {
                    b0 a = aVar.a(zVar);
                    if (a == null && d2 != null) {
                    }
                    if (b0Var != null) {
                        if (a.code() == 304) {
                            b0.a n2 = b0Var.n();
                            n2.j(c(b0Var.j(), a.j()));
                            n2.q(a.s());
                            n2.o(a.q());
                            n2.d(f(b0Var));
                            n2.l(f(a));
                            b0 c3 = n2.c();
                            a.a().close();
                            this.a.trackConditionalCacheHit();
                            this.a.update(b0Var, c3);
                            return c3;
                        }
                        c.d.b.e0.e.f(b0Var.a());
                    }
                    b0.a n3 = a.n();
                    n3.d(f(b0Var));
                    n3.l(f(a));
                    b0 c4 = n3.c();
                    if (this.a != null) {
                        if (c.d.b.e0.i.e.c(c4) && c.a(c4, zVar)) {
                            return b(this.a.a(c4), c4);
                        }
                        if (f.a(zVar.f())) {
                            try {
                                this.a.b(zVar);
                            } catch (IOException unused) {
                            }
                        }
                    }
                    return c4;
                } finally {
                    if (d2 != null) {
                        c.d.b.e0.e.f(d2.a());
                    }
                }
            }
        }
        return (b0) invokeL.objValue;
    }

    public final b0 b(b bVar, b0 b0Var) throws IOException {
        InterceptResult invokeLL;
        Sink body;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, b0Var)) == null) {
            if (bVar == null || (body = bVar.body()) == null) {
                return b0Var;
            }
            C1645a c1645a = new C1645a(this, b0Var.a().f(), bVar, Okio.buffer(body));
            String g2 = b0Var.g("Content-Type");
            long c2 = b0Var.a().c();
            b0.a n = b0Var.n();
            n.b(new h(g2, c2, Okio.buffer(c1645a)));
            return n.c();
        }
        return (b0) invokeLL.objValue;
    }
}
