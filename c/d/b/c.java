package c.d.b;

import c.d.b.e0.g.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
/* loaded from: classes9.dex */
public final class c implements Closeable, Flushable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.d.b.e0.g.e f27658e;

    /* renamed from: f  reason: collision with root package name */
    public final c.d.b.e0.g.d f27659f;

    /* loaded from: classes9.dex */
    public static class a extends c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d.c f27660e;

        /* renamed from: f  reason: collision with root package name */
        public final BufferedSource f27661f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public final String f27662g;

        @Override // c.d.b.c0
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    if (this.f27662g != null) {
                        return Long.parseLong(this.f27662g);
                    }
                    return -1L;
                } catch (NumberFormatException unused) {
                    return -1L;
                }
            }
            return invokeV.longValue;
        }

        @Override // c.d.b.c0
        public BufferedSource f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27661f : (BufferedSource) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final String k;
        public static final String l;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final r f27663b;

        /* renamed from: c  reason: collision with root package name */
        public final String f27664c;

        /* renamed from: d  reason: collision with root package name */
        public final Protocol f27665d;

        /* renamed from: e  reason: collision with root package name */
        public final int f27666e;

        /* renamed from: f  reason: collision with root package name */
        public final String f27667f;

        /* renamed from: g  reason: collision with root package name */
        public final r f27668g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public final q f27669h;

        /* renamed from: i  reason: collision with root package name */
        public final long f27670i;

        /* renamed from: j  reason: collision with root package name */
        public final long f27671j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-652907766, "Lc/d/b/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-652907766, "Lc/d/b/c$b;");
                    return;
                }
            }
            k = c.d.b.e0.n.g.m().n() + "-Sent-Millis";
            l = c.d.b.e0.n.g.m().n() + "-Received-Millis";
        }

        public b(b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0Var};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = b0Var.r().h().toString();
            this.f27663b = c.d.b.e0.i.e.k(b0Var);
            this.f27664c = b0Var.r().f();
            this.f27665d = b0Var.p();
            this.f27666e = b0Var.code();
            this.f27667f = b0Var.l();
            this.f27668g = b0Var.j();
            this.f27669h = b0Var.f();
            this.f27670i = b0Var.s();
            this.f27671j = b0Var.q();
        }

        public final boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.startsWith("https://") : invokeV.booleanValue;
        }

        public final void b(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bufferedSink, list) == null) {
                try {
                    bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        bufferedSink.writeUtf8(ByteString.of(list.get(i2).getEncoded()).base64()).writeByte(10);
                    }
                } catch (CertificateEncodingException e2) {
                    throw new IOException(e2.getMessage());
                }
            }
        }

        public void c(d.a aVar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                BufferedSink buffer = Okio.buffer(aVar.d(0));
                buffer.writeUtf8(this.a).writeByte(10);
                buffer.writeUtf8(this.f27664c).writeByte(10);
                buffer.writeDecimalLong(this.f27663b.g()).writeByte(10);
                int g2 = this.f27663b.g();
                for (int i2 = 0; i2 < g2; i2++) {
                    buffer.writeUtf8(this.f27663b.e(i2)).writeUtf8(": ").writeUtf8(this.f27663b.h(i2)).writeByte(10);
                }
                buffer.writeUtf8(new c.d.b.e0.i.k(this.f27665d, this.f27666e, this.f27667f).toString()).writeByte(10);
                buffer.writeDecimalLong(this.f27668g.g() + 2).writeByte(10);
                int g3 = this.f27668g.g();
                for (int i3 = 0; i3 < g3; i3++) {
                    buffer.writeUtf8(this.f27668g.e(i3)).writeUtf8(": ").writeUtf8(this.f27668g.h(i3)).writeByte(10);
                }
                buffer.writeUtf8(k).writeUtf8(": ").writeDecimalLong(this.f27670i).writeByte(10);
                buffer.writeUtf8(l).writeUtf8(": ").writeDecimalLong(this.f27671j).writeByte(10);
                if (a()) {
                    buffer.writeByte(10);
                    buffer.writeUtf8(this.f27669h.a().d()).writeByte(10);
                    b(buffer, this.f27669h.e());
                    b(buffer, this.f27669h.c());
                    buffer.writeUtf8(this.f27669h.g().javaName()).writeByte(10);
                }
                buffer.close();
            }
        }
    }

    public final void a(@Nullable d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        try {
            aVar.a();
        } catch (IOException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f27659f.close();
        }
    }

    public void delete() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27659f.delete();
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f27659f.flush();
        }
    }

    public void update(b0 b0Var, b0 b0Var2) {
        d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048580, this, b0Var, b0Var2) != null) {
            return;
        }
        b bVar = new b(b0Var2);
        try {
            aVar = ((a) b0Var.a()).f27660e.a();
            if (aVar != null) {
                try {
                    bVar.c(aVar);
                    aVar.b();
                } catch (IOException unused) {
                    a(aVar);
                }
            }
        } catch (IOException unused2) {
            aVar = null;
        }
    }
}
