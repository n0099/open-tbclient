package b.d.b.e0.j;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import b.d.b.b0;
import b.d.b.c0;
import b.d.b.e0.i.h;
import b.d.b.e0.i.i;
import b.d.b.e0.i.k;
import b.d.b.r;
import b.d.b.s;
import b.d.b.w;
import b.d.b.z;
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
public final class a implements b.d.b.e0.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f30288a;

    /* renamed from: b  reason: collision with root package name */
    public final b.d.b.e0.h.f f30289b;

    /* renamed from: c  reason: collision with root package name */
    public final BufferedSource f30290c;

    /* renamed from: d  reason: collision with root package name */
    public final BufferedSink f30291d;

    /* renamed from: e  reason: collision with root package name */
    public int f30292e;

    /* renamed from: f  reason: collision with root package name */
    public long f30293f;

    /* renamed from: b.d.b.e0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C1447a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public final class c implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ForwardingTimeout f30298e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f30299f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f30300g;

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
            this.f30300g = aVar;
            this.f30298e = new ForwardingTimeout(this.f30300g.f30291d.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (this.f30299f) {
                        return;
                    }
                    this.f30299f = true;
                    this.f30300g.f30291d.writeUtf8("0\r\n\r\n");
                    this.f30300g.d(this.f30298e);
                    this.f30300g.f30292e = 3;
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    if (this.f30299f) {
                        return;
                    }
                    this.f30300g.f30291d.flush();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30298e : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j) == null) {
                if (this.f30299f) {
                    throw new IllegalStateException("closed");
                }
                if (j == 0) {
                    return;
                }
                this.f30300g.f30291d.writeHexadecimalUnsignedLong(j);
                this.f30300g.f30291d.writeUtf8(Part.CRLF);
                this.f30300g.f30291d.write(buffer, j);
                this.f30300g.f30291d.writeUtf8(Part.CRLF);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final s f30301i;
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
                    super((a) objArr2[0], (C1447a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = aVar;
            this.j = -1L;
            this.k = true;
            this.f30301i = sVar;
        }

        public final void c() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j != -1) {
                    this.l.f30290c.readUtf8LineStrict();
                }
                try {
                    this.j = this.l.f30290c.readHexadecimalUnsignedLong();
                    String trim = this.l.f30290c.readUtf8LineStrict().trim();
                    if (this.j >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                        if (this.j == 0) {
                            this.k = false;
                            b.d.b.e0.i.e.e(this.l.f30288a.h(), this.f30301i, this.l.k());
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f30295f) {
                return;
            }
            if (this.k && !b.d.b.e0.e.o(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f30295f = true;
        }

        @Override // b.d.b.e0.j.a.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, buffer, j)) == null) {
                if (j >= 0) {
                    if (!this.f30295f) {
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
        public final ForwardingTimeout f30302e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f30303f;

        /* renamed from: g  reason: collision with root package name */
        public long f30304g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f30305h;

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
            this.f30305h = aVar;
            this.f30302e = new ForwardingTimeout(this.f30305h.f30291d.timeout());
            this.f30304g = j;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f30303f) {
                return;
            }
            this.f30303f = true;
            if (this.f30304g <= 0) {
                this.f30305h.d(this.f30302e);
                this.f30305h.f30292e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f30303f) {
                return;
            }
            this.f30305h.f30291d.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30302e : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j) == null) {
                if (!this.f30303f) {
                    b.d.b.e0.e.e(buffer.size(), 0L, j);
                    if (j <= this.f30304g) {
                        this.f30305h.f30291d.write(buffer, j);
                        this.f30304g -= j;
                        return;
                    }
                    throw new ProtocolException("expected " + this.f30304g + " bytes but received " + j);
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
        public long f30306i;

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
                    super((a) objArr2[0], (C1447a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30306i = j;
            if (j == 0) {
                a(true, null);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f30295f) {
                return;
            }
            if (this.f30306i != 0 && !b.d.b.e0.e.o(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f30295f = true;
        }

        @Override // b.d.b.e0.j.a.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                if (j >= 0) {
                    if (!this.f30295f) {
                        long j2 = this.f30306i;
                        if (j2 == 0) {
                            return -1L;
                        }
                        long read = super.read(buffer, Math.min(j2, j));
                        if (read != -1) {
                            long j3 = this.f30306i - read;
                            this.f30306i = j3;
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
        public boolean f30307i;

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
                    super((a) objArr2[0], (C1447a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f30295f) {
                return;
            }
            if (!this.f30307i) {
                a(false, null);
            }
            this.f30295f = true;
        }

        @Override // b.d.b.e0.j.a.b, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                if (j >= 0) {
                    if (!this.f30295f) {
                        if (this.f30307i) {
                            return -1L;
                        }
                        long read = super.read(buffer, j);
                        if (read == -1) {
                            this.f30307i = true;
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

    public a(w wVar, b.d.b.e0.h.f fVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
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
        this.f30292e = 0;
        this.f30293f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.f30288a = wVar;
        this.f30289b = fVar;
        this.f30290c = bufferedSource;
        this.f30291d = bufferedSink;
    }

    @Override // b.d.b.e0.i.c
    public c0 a(b0 b0Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b0Var)) == null) {
            b.d.b.e0.h.f fVar = this.f30289b;
            fVar.f30254f.responseBodyStart(fVar.f30253e);
            String g2 = b0Var.g("Content-Type");
            if (!b.d.b.e0.i.e.c(b0Var)) {
                return new h(g2, 0L, Okio.buffer(h(0L)));
            }
            if ("chunked".equalsIgnoreCase(b0Var.g("Transfer-Encoding"))) {
                return new h(g2, -1L, Okio.buffer(f(b0Var.r().h())));
            }
            long b2 = b.d.b.e0.i.e.b(b0Var);
            if (b2 != -1) {
                return new h(g2, b2, Okio.buffer(h(b2)));
            }
            return new h(g2, -1L, Okio.buffer(i()));
        }
        return (c0) invokeL.objValue;
    }

    @Override // b.d.b.e0.i.c
    public void b(z zVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar) == null) {
            l(zVar.d(), i.a(zVar, this.f30289b.d().route().b().type()));
        }
    }

    @Override // b.d.b.e0.i.c
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

    @Override // b.d.b.e0.i.c
    public void cancel() {
        b.d.b.e0.h.c d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (d2 = this.f30289b.d()) == null) {
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
            if (this.f30292e == 1) {
                this.f30292e = 2;
                return new c(this);
            }
            throw new IllegalStateException("state: " + this.f30292e);
        }
        return (Sink) invokeV.objValue;
    }

    public Source f(s sVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sVar)) == null) {
            if (this.f30292e == 4) {
                this.f30292e = 5;
                return new d(this, sVar);
            }
            throw new IllegalStateException("state: " + this.f30292e);
        }
        return (Source) invokeL.objValue;
    }

    @Override // b.d.b.e0.i.c
    public void finishRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f30291d.flush();
        }
    }

    @Override // b.d.b.e0.i.c
    public void flushRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f30291d.flush();
        }
    }

    public Sink g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            if (this.f30292e == 1) {
                this.f30292e = 2;
                return new e(this, j);
            }
            throw new IllegalStateException("state: " + this.f30292e);
        }
        return (Sink) invokeJ.objValue;
    }

    public Source h(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            if (this.f30292e == 4) {
                this.f30292e = 5;
                return new f(this, j);
            }
            throw new IllegalStateException("state: " + this.f30292e);
        }
        return (Source) invokeJ.objValue;
    }

    public Source i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f30292e == 4) {
                b.d.b.e0.h.f fVar = this.f30289b;
                if (fVar != null) {
                    this.f30292e = 5;
                    fVar.o();
                    return new g(this);
                }
                throw new IllegalStateException("streamAllocation == null");
            }
            throw new IllegalStateException("state: " + this.f30292e);
        }
        return (Source) invokeV.objValue;
    }

    public final String j() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String readUtf8LineStrict = this.f30290c.readUtf8LineStrict(this.f30293f);
            this.f30293f -= readUtf8LineStrict.length();
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
                b.d.b.e0.a.f30186a.a(aVar, j);
            } else {
                return aVar.d();
            }
        }
    }

    public void l(r rVar, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, rVar, str) == null) {
            if (this.f30292e == 0) {
                this.f30291d.writeUtf8(str).writeUtf8(Part.CRLF);
                int g2 = rVar.g();
                for (int i2 = 0; i2 < g2; i2++) {
                    this.f30291d.writeUtf8(rVar.e(i2)).writeUtf8(": ").writeUtf8(rVar.h(i2)).writeUtf8(Part.CRLF);
                }
                this.f30291d.writeUtf8(Part.CRLF);
                this.f30292e = 1;
                return;
            }
            throw new IllegalStateException("state: " + this.f30292e);
        }
    }

    @Override // b.d.b.e0.i.c
    public b0.a readResponseHeaders(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            int i2 = this.f30292e;
            if (i2 != 1 && i2 != 3) {
                throw new IllegalStateException("state: " + this.f30292e);
            }
            try {
                k b2 = k.b(j());
                b0.a aVar = new b0.a();
                aVar.n(b2.f30285a);
                aVar.g(b2.f30286b);
                aVar.k(b2.f30287c);
                aVar.j(k());
                if (z && b2.f30286b == 100) {
                    return null;
                }
                if (b2.f30286b == 100) {
                    this.f30292e = 3;
                    return aVar;
                }
                this.f30292e = 4;
                return aVar;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f30289b);
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
        public final ForwardingTimeout f30294e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f30295f;

        /* renamed from: g  reason: collision with root package name */
        public long f30296g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f30297h;

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
            this.f30297h = aVar;
            this.f30294e = new ForwardingTimeout(this.f30297h.f30290c.timeout());
            this.f30296g = 0L;
        }

        public final void a(boolean z, IOException iOException) throws IOException {
            a aVar;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, iOException) == null) || (i2 = (aVar = this.f30297h).f30292e) == 6) {
                return;
            }
            if (i2 == 5) {
                aVar.d(this.f30294e);
                a aVar2 = this.f30297h;
                aVar2.f30292e = 6;
                b.d.b.e0.h.f fVar = aVar2.f30289b;
                if (fVar != null) {
                    fVar.w(!z, aVar2, this.f30296g, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + this.f30297h.f30292e);
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                try {
                    long read = this.f30297h.f30290c.read(buffer, j);
                    if (read > 0) {
                        this.f30296g += read;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30294e : (Timeout) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar, C1447a c1447a) {
            this(aVar);
        }
    }
}
