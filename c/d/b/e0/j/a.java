package c.d.b.e0.j;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import c.d.b.b0;
import c.d.b.c0;
import c.d.b.e0.i.h;
import c.d.b.e0.i.i;
import c.d.b.e0.i.k;
import c.d.b.r;
import c.d.b.s;
import c.d.b.w;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
/* loaded from: classes9.dex */
public final class a implements c.d.b.e0.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.b.e0.h.f f28631b;

    /* renamed from: c  reason: collision with root package name */
    public final BufferedSource f28632c;

    /* renamed from: d  reason: collision with root package name */
    public final BufferedSink f28633d;

    /* renamed from: e  reason: collision with root package name */
    public int f28634e;

    /* renamed from: f  reason: collision with root package name */
    public long f28635f;

    /* renamed from: c.d.b.e0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1608a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class c implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ForwardingTimeout f28640e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28641f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f28642g;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28642g = aVar;
            this.f28640e = new ForwardingTimeout(this.f28642g.f28633d.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (this.f28641f) {
                        return;
                    }
                    this.f28641f = true;
                    this.f28642g.f28633d.writeUtf8("0\r\n\r\n");
                    this.f28642g.d(this.f28640e);
                    this.f28642g.f28634e = 3;
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    if (this.f28641f) {
                        return;
                    }
                    this.f28642g.f28633d.flush();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28640e : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j2) == null) {
                if (this.f28641f) {
                    throw new IllegalStateException("closed");
                }
                if (j2 == 0) {
                    return;
                }
                this.f28642g.f28633d.writeHexadecimalUnsignedLong(j2);
                this.f28642g.f28633d.writeUtf8("\r\n");
                this.f28642g.f28633d.write(buffer, j2);
                this.f28642g.f28633d.writeUtf8("\r\n");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final s f28643i;

        /* renamed from: j  reason: collision with root package name */
        public long f28644j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f28645k;
        public final /* synthetic */ a l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, s sVar) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (C1608a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = aVar;
            this.f28644j = -1L;
            this.f28645k = true;
            this.f28643i = sVar;
        }

        public final void c() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f28644j != -1) {
                    this.l.f28632c.readUtf8LineStrict();
                }
                try {
                    this.f28644j = this.l.f28632c.readHexadecimalUnsignedLong();
                    String trim = this.l.f28632c.readUtf8LineStrict().trim();
                    if (this.f28644j >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                        if (this.f28644j == 0) {
                            this.f28645k = false;
                            c.d.b.e0.i.e.e(this.l.a.h(), this.f28643i, this.l.k());
                            a(true, null);
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f28644j + trim + "\"");
                } catch (NumberFormatException e2) {
                    throw new ProtocolException(e2.getMessage());
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28637f) {
                return;
            }
            if (this.f28645k && !c.d.b.e0.e.o(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f28637f = true;
        }

        @Override // c.d.b.e0.j.a.b, okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, buffer, j2)) == null) {
                if (j2 >= 0) {
                    if (!this.f28637f) {
                        if (this.f28645k) {
                            long j3 = this.f28644j;
                            if (j3 == 0 || j3 == -1) {
                                c();
                                if (!this.f28645k) {
                                    return -1L;
                                }
                            }
                            long read = super.read(buffer, Math.min(j2, this.f28644j));
                            if (read != -1) {
                                this.f28644j -= read;
                                return read;
                            }
                            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                            a(false, protocolException);
                            throw protocolException;
                        }
                        return -1L;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            return invokeLJ.longValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class e implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ForwardingTimeout f28646e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28647f;

        /* renamed from: g  reason: collision with root package name */
        public long f28648g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f28649h;

        public e(a aVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28649h = aVar;
            this.f28646e = new ForwardingTimeout(this.f28649h.f28633d.timeout());
            this.f28648g = j2;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28647f) {
                return;
            }
            this.f28647f = true;
            if (this.f28648g <= 0) {
                this.f28649h.d(this.f28646e);
                this.f28649h.f28634e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28647f) {
                return;
            }
            this.f28649h.f28633d.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28646e : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j2) == null) {
                if (!this.f28647f) {
                    c.d.b.e0.e.e(buffer.size(), 0L, j2);
                    if (j2 <= this.f28648g) {
                        this.f28649h.f28633d.write(buffer, j2);
                        this.f28648g -= j2;
                        return;
                    }
                    throw new ProtocolException("expected " + this.f28648g + " bytes but received " + j2);
                }
                throw new IllegalStateException("closed");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public long f28650i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, long j2) throws IOException {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (C1608a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28650i = j2;
            if (j2 == 0) {
                a(true, null);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28637f) {
                return;
            }
            if (this.f28650i != 0 && !c.d.b.e0.e.o(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f28637f = true;
        }

        @Override // c.d.b.e0.j.a.b, okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j2)) == null) {
                if (j2 >= 0) {
                    if (!this.f28637f) {
                        long j3 = this.f28650i;
                        if (j3 == 0) {
                            return -1L;
                        }
                        long read = super.read(buffer, Math.min(j3, j2));
                        if (read != -1) {
                            long j4 = this.f28650i - read;
                            this.f28650i = j4;
                            if (j4 == 0) {
                                a(true, null);
                            }
                            return read;
                        }
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        a(false, protocolException);
                        throw protocolException;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            return invokeLJ.longValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public boolean f28651i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (C1608a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28637f) {
                return;
            }
            if (!this.f28651i) {
                a(false, null);
            }
            this.f28637f = true;
        }

        @Override // c.d.b.e0.j.a.b, okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j2)) == null) {
                if (j2 >= 0) {
                    if (!this.f28637f) {
                        if (this.f28651i) {
                            return -1L;
                        }
                        long read = super.read(buffer, j2);
                        if (read == -1) {
                            this.f28651i = true;
                            a(true, null);
                            return -1L;
                        }
                        return read;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            return invokeLJ.longValue;
        }
    }

    public a(w wVar, c.d.b.e0.h.f fVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, fVar, bufferedSource, bufferedSink};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28634e = 0;
        this.f28635f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.a = wVar;
        this.f28631b = fVar;
        this.f28632c = bufferedSource;
        this.f28633d = bufferedSink;
    }

    @Override // c.d.b.e0.i.c
    public c0 a(b0 b0Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b0Var)) == null) {
            c.d.b.e0.h.f fVar = this.f28631b;
            fVar.f28598f.responseBodyStart(fVar.f28597e);
            String g2 = b0Var.g("Content-Type");
            if (!c.d.b.e0.i.e.c(b0Var)) {
                return new h(g2, 0L, Okio.buffer(h(0L)));
            }
            if ("chunked".equalsIgnoreCase(b0Var.g("Transfer-Encoding"))) {
                return new h(g2, -1L, Okio.buffer(f(b0Var.r().h())));
            }
            long b2 = c.d.b.e0.i.e.b(b0Var);
            if (b2 != -1) {
                return new h(g2, b2, Okio.buffer(h(b2)));
            }
            return new h(g2, -1L, Okio.buffer(i()));
        }
        return (c0) invokeL.objValue;
    }

    @Override // c.d.b.e0.i.c
    public void b(z zVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar) == null) {
            l(zVar.d(), i.a(zVar, this.f28631b.d().route().b().type()));
        }
    }

    @Override // c.d.b.e0.i.c
    public Sink c(z zVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, zVar, j2)) == null) {
            if ("chunked".equalsIgnoreCase(zVar.c("Transfer-Encoding"))) {
                return e();
            }
            if (j2 != -1) {
                return g(j2);
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        return (Sink) invokeLJ.objValue;
    }

    @Override // c.d.b.e0.i.c
    public void cancel() {
        c.d.b.e0.h.c d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (d2 = this.f28631b.d()) == null) {
            return;
        }
        d2.c();
    }

    public void d(ForwardingTimeout forwardingTimeout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forwardingTimeout) == null) {
            Timeout delegate = forwardingTimeout.delegate();
            forwardingTimeout.setDelegate(Timeout.NONE);
            delegate.clearDeadline();
            delegate.clearTimeout();
        }
    }

    public Sink e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f28634e == 1) {
                this.f28634e = 2;
                return new c(this);
            }
            throw new IllegalStateException("state: " + this.f28634e);
        }
        return (Sink) invokeV.objValue;
    }

    public Source f(s sVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sVar)) == null) {
            if (this.f28634e == 4) {
                this.f28634e = 5;
                return new d(this, sVar);
            }
            throw new IllegalStateException("state: " + this.f28634e);
        }
        return (Source) invokeL.objValue;
    }

    @Override // c.d.b.e0.i.c
    public void finishRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f28633d.flush();
        }
    }

    @Override // c.d.b.e0.i.c
    public void flushRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f28633d.flush();
        }
    }

    public Sink g(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
            if (this.f28634e == 1) {
                this.f28634e = 2;
                return new e(this, j2);
            }
            throw new IllegalStateException("state: " + this.f28634e);
        }
        return (Sink) invokeJ.objValue;
    }

    public Source h(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
            if (this.f28634e == 4) {
                this.f28634e = 5;
                return new f(this, j2);
            }
            throw new IllegalStateException("state: " + this.f28634e);
        }
        return (Source) invokeJ.objValue;
    }

    public Source i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f28634e == 4) {
                c.d.b.e0.h.f fVar = this.f28631b;
                if (fVar != null) {
                    this.f28634e = 5;
                    fVar.o();
                    return new g(this);
                }
                throw new IllegalStateException("streamAllocation == null");
            }
            throw new IllegalStateException("state: " + this.f28634e);
        }
        return (Source) invokeV.objValue;
    }

    public final String j() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String readUtf8LineStrict = this.f28632c.readUtf8LineStrict(this.f28635f);
            this.f28635f -= readUtf8LineStrict.length();
            return readUtf8LineStrict;
        }
        return (String) invokeV.objValue;
    }

    public r k() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048589, this)) != null) {
            return (r) invokeV.objValue;
        }
        r.a aVar = new r.a();
        while (true) {
            String j2 = j();
            if (j2.length() != 0) {
                c.d.b.e0.a.a.a(aVar, j2);
            } else {
                return aVar.d();
            }
        }
    }

    public void l(r rVar, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, rVar, str) == null) {
            if (this.f28634e == 0) {
                this.f28633d.writeUtf8(str).writeUtf8("\r\n");
                int g2 = rVar.g();
                for (int i2 = 0; i2 < g2; i2++) {
                    this.f28633d.writeUtf8(rVar.e(i2)).writeUtf8(": ").writeUtf8(rVar.h(i2)).writeUtf8("\r\n");
                }
                this.f28633d.writeUtf8("\r\n");
                this.f28634e = 1;
                return;
            }
            throw new IllegalStateException("state: " + this.f28634e);
        }
    }

    @Override // c.d.b.e0.i.c
    public b0.a readResponseHeaders(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            int i2 = this.f28634e;
            if (i2 != 1 && i2 != 3) {
                throw new IllegalStateException("state: " + this.f28634e);
            }
            try {
                k b2 = k.b(j());
                b0.a aVar = new b0.a();
                aVar.n(b2.a);
                aVar.g(b2.f28629b);
                aVar.k(b2.f28630c);
                aVar.j(k());
                if (z && b2.f28629b == 100) {
                    return null;
                }
                if (b2.f28629b == 100) {
                    this.f28634e = 3;
                    return aVar;
                }
                this.f28634e = 4;
                return aVar;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f28631b);
                iOException.initCause(e2);
                throw iOException;
            }
        }
        return (b0.a) invokeZ.objValue;
    }

    /* loaded from: classes9.dex */
    public abstract class b implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ForwardingTimeout f28636e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28637f;

        /* renamed from: g  reason: collision with root package name */
        public long f28638g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f28639h;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28639h = aVar;
            this.f28636e = new ForwardingTimeout(this.f28639h.f28632c.timeout());
            this.f28638g = 0L;
        }

        public final void a(boolean z, IOException iOException) throws IOException {
            a aVar;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, iOException) == null) || (i2 = (aVar = this.f28639h).f28634e) == 6) {
                return;
            }
            if (i2 == 5) {
                aVar.d(this.f28636e);
                a aVar2 = this.f28639h;
                aVar2.f28634e = 6;
                c.d.b.e0.h.f fVar = aVar2.f28631b;
                if (fVar != null) {
                    fVar.w(!z, aVar2, this.f28638g, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + this.f28639h.f28634e);
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j2)) == null) {
                try {
                    long read = this.f28639h.f28632c.read(buffer, j2);
                    if (read > 0) {
                        this.f28638g += read;
                    }
                    return read;
                } catch (IOException e2) {
                    a(false, e2);
                    throw e2;
                }
            }
            return invokeLJ.longValue;
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28636e : (Timeout) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C1608a c1608a) {
            this(aVar);
        }
    }
}
