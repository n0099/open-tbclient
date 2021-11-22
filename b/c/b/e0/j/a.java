package b.c.b.e0.j;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import b.c.b.b0;
import b.c.b.c0;
import b.c.b.e0.i.h;
import b.c.b.e0.i.i;
import b.c.b.e0.i.k;
import b.c.b.r;
import b.c.b.s;
import b.c.b.w;
import b.c.b.z;
import com.android.internal.http.multipart.Part;
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
/* loaded from: classes6.dex */
public final class a implements b.c.b.e0.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f31146a;

    /* renamed from: b  reason: collision with root package name */
    public final b.c.b.e0.h.f f31147b;

    /* renamed from: c  reason: collision with root package name */
    public final BufferedSource f31148c;

    /* renamed from: d  reason: collision with root package name */
    public final BufferedSink f31149d;

    /* renamed from: e  reason: collision with root package name */
    public int f31150e;

    /* renamed from: f  reason: collision with root package name */
    public long f31151f;

    /* renamed from: b.c.b.e0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C1489a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public final class c implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ForwardingTimeout f31156e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31157f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f31158g;

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
            this.f31158g = aVar;
            this.f31156e = new ForwardingTimeout(this.f31158g.f31149d.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (this.f31157f) {
                        return;
                    }
                    this.f31157f = true;
                    this.f31158g.f31149d.writeUtf8("0\r\n\r\n");
                    this.f31158g.d(this.f31156e);
                    this.f31158g.f31150e = 3;
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    if (this.f31157f) {
                        return;
                    }
                    this.f31158g.f31149d.flush();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31156e : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j) == null) {
                if (this.f31157f) {
                    throw new IllegalStateException("closed");
                }
                if (j == 0) {
                    return;
                }
                this.f31158g.f31149d.writeHexadecimalUnsignedLong(j);
                this.f31158g.f31149d.writeUtf8(Part.CRLF);
                this.f31158g.f31149d.write(buffer, j);
                this.f31158g.f31149d.writeUtf8(Part.CRLF);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final s f31159i;
        public long j;
        public boolean k;
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
                    super((a) objArr2[0], (C1489a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = aVar;
            this.j = -1L;
            this.k = true;
            this.f31159i = sVar;
        }

        public final void c() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j != -1) {
                    this.l.f31148c.readUtf8LineStrict();
                }
                try {
                    this.j = this.l.f31148c.readHexadecimalUnsignedLong();
                    String trim = this.l.f31148c.readUtf8LineStrict().trim();
                    if (this.j >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                        if (this.j == 0) {
                            this.k = false;
                            b.c.b.e0.i.e.e(this.l.f31146a.h(), this.f31159i, this.l.k());
                            a(true, null);
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.j + trim + "\"");
                } catch (NumberFormatException e2) {
                    throw new ProtocolException(e2.getMessage());
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f31153f) {
                return;
            }
            if (this.k && !b.c.b.e0.e.o(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f31153f = true;
        }

        @Override // b.c.b.e0.j.a.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, buffer, j)) == null) {
                if (j >= 0) {
                    if (!this.f31153f) {
                        if (this.k) {
                            long j2 = this.j;
                            if (j2 == 0 || j2 == -1) {
                                c();
                                if (!this.k) {
                                    return -1L;
                                }
                            }
                            long read = super.read(buffer, Math.min(j, this.j));
                            if (read != -1) {
                                this.j -= read;
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
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class e implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ForwardingTimeout f31160e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31161f;

        /* renamed from: g  reason: collision with root package name */
        public long f31162g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f31163h;

        public e(a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31163h = aVar;
            this.f31160e = new ForwardingTimeout(this.f31163h.f31149d.timeout());
            this.f31162g = j;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f31161f) {
                return;
            }
            this.f31161f = true;
            if (this.f31162g <= 0) {
                this.f31163h.d(this.f31160e);
                this.f31163h.f31150e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f31161f) {
                return;
            }
            this.f31163h.f31149d.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31160e : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j) == null) {
                if (!this.f31161f) {
                    b.c.b.e0.e.e(buffer.size(), 0L, j);
                    if (j <= this.f31162g) {
                        this.f31163h.f31149d.write(buffer, j);
                        this.f31162g -= j;
                        return;
                    }
                    throw new ProtocolException("expected " + this.f31162g + " bytes but received " + j);
                }
                throw new IllegalStateException("closed");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public long f31164i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, long j) throws IOException {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (C1489a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31164i = j;
            if (j == 0) {
                a(true, null);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f31153f) {
                return;
            }
            if (this.f31164i != 0 && !b.c.b.e0.e.o(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f31153f = true;
        }

        @Override // b.c.b.e0.j.a.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                if (j >= 0) {
                    if (!this.f31153f) {
                        long j2 = this.f31164i;
                        if (j2 == 0) {
                            return -1L;
                        }
                        long read = super.read(buffer, Math.min(j2, j));
                        if (read != -1) {
                            long j3 = this.f31164i - read;
                            this.f31164i = j3;
                            if (j3 == 0) {
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
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public boolean f31165i;

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
                    super((a) objArr2[0], (C1489a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f31153f) {
                return;
            }
            if (!this.f31165i) {
                a(false, null);
            }
            this.f31153f = true;
        }

        @Override // b.c.b.e0.j.a.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                if (j >= 0) {
                    if (!this.f31153f) {
                        if (this.f31165i) {
                            return -1L;
                        }
                        long read = super.read(buffer, j);
                        if (read == -1) {
                            this.f31165i = true;
                            a(true, null);
                            return -1L;
                        }
                        return read;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }
    }

    public a(w wVar, b.c.b.e0.h.f fVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
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
        this.f31150e = 0;
        this.f31151f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.f31146a = wVar;
        this.f31147b = fVar;
        this.f31148c = bufferedSource;
        this.f31149d = bufferedSink;
    }

    @Override // b.c.b.e0.i.c
    public c0 a(b0 b0Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b0Var)) == null) {
            b.c.b.e0.h.f fVar = this.f31147b;
            fVar.f31112f.responseBodyStart(fVar.f31111e);
            String g2 = b0Var.g("Content-Type");
            if (!b.c.b.e0.i.e.c(b0Var)) {
                return new h(g2, 0L, Okio.buffer(h(0L)));
            }
            if ("chunked".equalsIgnoreCase(b0Var.g("Transfer-Encoding"))) {
                return new h(g2, -1L, Okio.buffer(f(b0Var.r().h())));
            }
            long b2 = b.c.b.e0.i.e.b(b0Var);
            if (b2 != -1) {
                return new h(g2, b2, Okio.buffer(h(b2)));
            }
            return new h(g2, -1L, Okio.buffer(i()));
        }
        return (c0) invokeL.objValue;
    }

    @Override // b.c.b.e0.i.c
    public void b(z zVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar) == null) {
            l(zVar.d(), i.a(zVar, this.f31147b.d().route().b().type()));
        }
    }

    @Override // b.c.b.e0.i.c
    public Sink c(z zVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, zVar, j)) == null) {
            if ("chunked".equalsIgnoreCase(zVar.c("Transfer-Encoding"))) {
                return e();
            }
            if (j != -1) {
                return g(j);
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        return (Sink) invokeLJ.objValue;
    }

    @Override // b.c.b.e0.i.c
    public void cancel() {
        b.c.b.e0.h.c d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (d2 = this.f31147b.d()) == null) {
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
            if (this.f31150e == 1) {
                this.f31150e = 2;
                return new c(this);
            }
            throw new IllegalStateException("state: " + this.f31150e);
        }
        return (Sink) invokeV.objValue;
    }

    public Source f(s sVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sVar)) == null) {
            if (this.f31150e == 4) {
                this.f31150e = 5;
                return new d(this, sVar);
            }
            throw new IllegalStateException("state: " + this.f31150e);
        }
        return (Source) invokeL.objValue;
    }

    @Override // b.c.b.e0.i.c
    public void finishRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f31149d.flush();
        }
    }

    @Override // b.c.b.e0.i.c
    public void flushRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f31149d.flush();
        }
    }

    public Sink g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            if (this.f31150e == 1) {
                this.f31150e = 2;
                return new e(this, j);
            }
            throw new IllegalStateException("state: " + this.f31150e);
        }
        return (Sink) invokeJ.objValue;
    }

    public Source h(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            if (this.f31150e == 4) {
                this.f31150e = 5;
                return new f(this, j);
            }
            throw new IllegalStateException("state: " + this.f31150e);
        }
        return (Source) invokeJ.objValue;
    }

    public Source i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f31150e == 4) {
                b.c.b.e0.h.f fVar = this.f31147b;
                if (fVar != null) {
                    this.f31150e = 5;
                    fVar.o();
                    return new g(this);
                }
                throw new IllegalStateException("streamAllocation == null");
            }
            throw new IllegalStateException("state: " + this.f31150e);
        }
        return (Source) invokeV.objValue;
    }

    public final String j() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String readUtf8LineStrict = this.f31148c.readUtf8LineStrict(this.f31151f);
            this.f31151f -= readUtf8LineStrict.length();
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
            String j = j();
            if (j.length() != 0) {
                b.c.b.e0.a.f31044a.a(aVar, j);
            } else {
                return aVar.d();
            }
        }
    }

    public void l(r rVar, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, rVar, str) == null) {
            if (this.f31150e == 0) {
                this.f31149d.writeUtf8(str).writeUtf8(Part.CRLF);
                int g2 = rVar.g();
                for (int i2 = 0; i2 < g2; i2++) {
                    this.f31149d.writeUtf8(rVar.e(i2)).writeUtf8(": ").writeUtf8(rVar.h(i2)).writeUtf8(Part.CRLF);
                }
                this.f31149d.writeUtf8(Part.CRLF);
                this.f31150e = 1;
                return;
            }
            throw new IllegalStateException("state: " + this.f31150e);
        }
    }

    @Override // b.c.b.e0.i.c
    public b0.a readResponseHeaders(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            int i2 = this.f31150e;
            if (i2 != 1 && i2 != 3) {
                throw new IllegalStateException("state: " + this.f31150e);
            }
            try {
                k b2 = k.b(j());
                b0.a aVar = new b0.a();
                aVar.n(b2.f31143a);
                aVar.g(b2.f31144b);
                aVar.k(b2.f31145c);
                aVar.j(k());
                if (z && b2.f31144b == 100) {
                    return null;
                }
                if (b2.f31144b == 100) {
                    this.f31150e = 3;
                    return aVar;
                }
                this.f31150e = 4;
                return aVar;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f31147b);
                iOException.initCause(e2);
                throw iOException;
            }
        }
        return (b0.a) invokeZ.objValue;
    }

    /* loaded from: classes6.dex */
    public abstract class b implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ForwardingTimeout f31152e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31153f;

        /* renamed from: g  reason: collision with root package name */
        public long f31154g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f31155h;

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
            this.f31155h = aVar;
            this.f31152e = new ForwardingTimeout(this.f31155h.f31148c.timeout());
            this.f31154g = 0L;
        }

        public final void a(boolean z, IOException iOException) throws IOException {
            a aVar;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, iOException) == null) || (i2 = (aVar = this.f31155h).f31150e) == 6) {
                return;
            }
            if (i2 == 5) {
                aVar.d(this.f31152e);
                a aVar2 = this.f31155h;
                aVar2.f31150e = 6;
                b.c.b.e0.h.f fVar = aVar2.f31147b;
                if (fVar != null) {
                    fVar.w(!z, aVar2, this.f31154g, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + this.f31155h.f31150e);
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                try {
                    long read = this.f31155h.f31148c.read(buffer, j);
                    if (read > 0) {
                        this.f31154g += read;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31152e : (Timeout) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C1489a c1489a) {
            this(aVar);
        }
    }
}
