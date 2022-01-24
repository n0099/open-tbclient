package c.d.b.e0.i;

import c.d.b.a0;
import c.d.b.b0;
import c.d.b.m;
import c.d.b.r;
import c.d.b.t;
import c.d.b.v;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import okio.GzipSource;
import okio.Okio;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public final class a implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final m a;

    public a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mVar;
    }

    @Override // c.d.b.t
    public b0 a(t.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            z request = aVar.request();
            z.a g2 = request.g();
            a0 a = request.a();
            if (a != null) {
                v b2 = a.b();
                if (b2 != null) {
                    g2.c("Content-Type", b2.toString());
                }
                long a2 = a.a();
                if (a2 != -1) {
                    g2.c("Content-Length", Long.toString(a2));
                    g2.f("Transfer-Encoding");
                } else {
                    g2.c("Transfer-Encoding", "chunked");
                    g2.f("Content-Length");
                }
            }
            boolean z = false;
            if (request.c("Host") == null) {
                g2.c("Host", c.d.b.e0.e.r(request.h(), false));
            }
            if (request.c(HTTP.CONN_DIRECTIVE) == null) {
                g2.c(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            }
            if (request.c("Accept-Encoding") == null && request.c("Range") == null) {
                z = true;
                g2.c("Accept-Encoding", "gzip");
            }
            List<c.d.b.l> a3 = this.a.a(request.h());
            if (!a3.isEmpty()) {
                g2.c("Cookie", b(a3));
            }
            if (request.c("User-Agent") == null) {
                g2.c("User-Agent", c.d.b.e0.f.a());
            }
            b0 a4 = aVar.a(g2.b());
            e.e(this.a, request.h(), a4.j());
            b0.a n = a4.n();
            n.p(request);
            if (z && "gzip".equalsIgnoreCase(a4.g("Content-Encoding")) && e.c(a4)) {
                GzipSource gzipSource = new GzipSource(a4.a().f());
                r.a f2 = a4.j().f();
                f2.f("Content-Encoding");
                f2.f("Content-Length");
                n.j(f2.d());
                n.b(new h(a4.g("Content-Type"), -1L, Okio.buffer(gzipSource)));
            }
            return n.c();
        }
        return (b0) invokeL.objValue;
    }

    public final String b(List<c.d.b.l> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    sb.append("; ");
                }
                c.d.b.l lVar = list.get(i2);
                sb.append(lVar.c());
                sb.append(com.alipay.sdk.encrypt.a.f30893h);
                sb.append(lVar.k());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
