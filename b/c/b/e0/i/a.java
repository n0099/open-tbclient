package b.c.b.e0.i;

import b.c.b.a0;
import b.c.b.b0;
import b.c.b.m;
import b.c.b.r;
import b.c.b.t;
import b.c.b.v;
import b.c.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
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
/* loaded from: classes6.dex */
public final class a implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final m f31122a;

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
        this.f31122a = mVar;
    }

    @Override // b.c.b.t
    public b0 a(t.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            z request = aVar.request();
            z.a g2 = request.g();
            a0 a2 = request.a();
            if (a2 != null) {
                v b2 = a2.b();
                if (b2 != null) {
                    g2.c("Content-Type", b2.toString());
                }
                long a3 = a2.a();
                if (a3 != -1) {
                    g2.c("Content-Length", Long.toString(a3));
                    g2.f("Transfer-Encoding");
                } else {
                    g2.c("Transfer-Encoding", "chunked");
                    g2.f("Content-Length");
                }
            }
            boolean z = false;
            if (request.c("Host") == null) {
                g2.c("Host", b.c.b.e0.e.r(request.h(), false));
            }
            if (request.c(HTTP.CONN_DIRECTIVE) == null) {
                g2.c(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            }
            if (request.c("Accept-Encoding") == null && request.c("Range") == null) {
                z = true;
                g2.c("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            }
            List<b.c.b.l> a4 = this.f31122a.a(request.h());
            if (!a4.isEmpty()) {
                g2.c("Cookie", b(a4));
            }
            if (request.c("User-Agent") == null) {
                g2.c("User-Agent", b.c.b.e0.f.a());
            }
            b0 a5 = aVar.a(g2.b());
            e.e(this.f31122a, request.h(), a5.j());
            b0.a n = a5.n();
            n.p(request);
            if (z && AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(a5.g("Content-Encoding")) && e.c(a5)) {
                GzipSource gzipSource = new GzipSource(a5.a().f());
                r.a f2 = a5.j().f();
                f2.f("Content-Encoding");
                f2.f("Content-Length");
                n.j(f2.d());
                n.b(new h(a5.g("Content-Type"), -1L, Okio.buffer(gzipSource)));
            }
            return n.c();
        }
        return (b0) invokeL.objValue;
    }

    public final String b(List<b.c.b.l> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    sb.append("; ");
                }
                b.c.b.l lVar = list.get(i2);
                sb.append(lVar.c());
                sb.append(com.alipay.sdk.encrypt.a.f34958h);
                sb.append(lVar.k());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
