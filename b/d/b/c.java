package b.d.b;

import b.d.b.e0.g.d;
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
/* loaded from: classes6.dex */
public final class c implements Closeable, Flushable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final b.d.b.e0.g.e f30150e;

    /* renamed from: f  reason: collision with root package name */
    public final b.d.b.e0.g.d f30151f;

    /* loaded from: classes6.dex */
    public static class a extends c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d.c f30152e;

        /* renamed from: f  reason: collision with root package name */
        public final BufferedSource f30153f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public final String f30154g;

        @Override // b.d.b.c0
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    if (this.f30154g != null) {
                        return Long.parseLong(this.f30154g);
                    }
                    return -1L;
                } catch (NumberFormatException unused) {
                    return -1L;
                }
            }
            return invokeV.longValue;
        }

        @Override // b.d.b.c0
        public BufferedSource f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30153f : (BufferedSource) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final String k;
        public static final String l;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f30155a;

        /* renamed from: b  reason: collision with root package name */
        public final r f30156b;

        /* renamed from: c  reason: collision with root package name */
        public final String f30157c;

        /* renamed from: d  reason: collision with root package name */
        public final Protocol f30158d;

        /* renamed from: e  reason: collision with root package name */
        public final int f30159e;

        /* renamed from: f  reason: collision with root package name */
        public final String f30160f;

        /* renamed from: g  reason: collision with root package name */
        public final r f30161g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public final q f30162h;

        /* renamed from: i  reason: collision with root package name */
        public final long f30163i;
        public final long j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-456394261, "Lb/d/b/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-456394261, "Lb/d/b/c$b;");
                    return;
                }
            }
            k = b.d.b.e0.n.g.m().n() + "-Sent-Millis";
            l = b.d.b.e0.n.g.m().n() + "-Received-Millis";
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
            this.f30155a = b0Var.r().h().toString();
            this.f30156b = b.d.b.e0.i.e.k(b0Var);
            this.f30157c = b0Var.r().f();
            this.f30158d = b0Var.p();
            this.f30159e = b0Var.code();
            this.f30160f = b0Var.l();
            this.f30161g = b0Var.j();
            this.f30162h = b0Var.f();
            this.f30163i = b0Var.s();
            this.j = b0Var.q();
        }

        public final boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30155a.startsWith("https://") : invokeV.booleanValue;
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
                buffer.writeUtf8(this.f30155a).writeByte(10);
                buffer.writeUtf8(this.f30157c).writeByte(10);
                buffer.writeDecimalLong(this.f30156b.g()).writeByte(10);
                int g2 = this.f30156b.g();
                for (int i2 = 0; i2 < g2; i2++) {
                    buffer.writeUtf8(this.f30156b.e(i2)).writeUtf8(": ").writeUtf8(this.f30156b.h(i2)).writeByte(10);
                }
                buffer.writeUtf8(new b.d.b.e0.i.k(this.f30158d, this.f30159e, this.f30160f).toString()).writeByte(10);
                buffer.writeDecimalLong(this.f30161g.g() + 2).writeByte(10);
                int g3 = this.f30161g.g();
                for (int i3 = 0; i3 < g3; i3++) {
                    buffer.writeUtf8(this.f30161g.e(i3)).writeUtf8(": ").writeUtf8(this.f30161g.h(i3)).writeByte(10);
                }
                buffer.writeUtf8(k).writeUtf8(": ").writeDecimalLong(this.f30163i).writeByte(10);
                buffer.writeUtf8(l).writeUtf8(": ").writeDecimalLong(this.j).writeByte(10);
                if (a()) {
                    buffer.writeByte(10);
                    buffer.writeUtf8(this.f30162h.a().d()).writeByte(10);
                    b(buffer, this.f30162h.e());
                    b(buffer, this.f30162h.c());
                    buffer.writeUtf8(this.f30162h.g().javaName()).writeByte(10);
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
            this.f30151f.close();
        }
    }

    public void delete() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f30151f.delete();
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f30151f.flush();
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
            aVar = ((a) b0Var.a()).f30152e.a();
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
