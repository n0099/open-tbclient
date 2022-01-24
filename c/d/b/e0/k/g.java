package c.d.b.e0.k;

import androidx.core.view.InputDeviceCompat;
import c.d.b.e0.k.a;
import c.d.b.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import com.duxiaoman.okhttp3.internal.http2.StreamResetException;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
/* loaded from: classes9.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f27895b;

    /* renamed from: c  reason: collision with root package name */
    public final int f27896c;

    /* renamed from: d  reason: collision with root package name */
    public final e f27897d;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<r> f27898e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1626a f27899f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27900g;

    /* renamed from: h  reason: collision with root package name */
    public final b f27901h;

    /* renamed from: i  reason: collision with root package name */
    public final a f27902i;

    /* renamed from: j  reason: collision with root package name */
    public final c f27903j;
    public final c k;
    public ErrorCode l;

    /* loaded from: classes9.dex */
    public final class a implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Buffer f27904e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f27905f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f27906g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f27907h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(93153679, "Lc/d/b/e0/k/g$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(93153679, "Lc/d/b/e0/k/g$a;");
            }
        }

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f27907h = gVar;
            this.f27904e = new Buffer();
        }

        public final void a(boolean z) throws IOException {
            long min;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                synchronized (this.f27907h) {
                    this.f27907h.k.enter();
                    while (this.f27907h.f27895b <= 0 && !this.f27906g && !this.f27905f && this.f27907h.l == null) {
                        this.f27907h.t();
                    }
                    this.f27907h.k.exitAndThrowIfTimedOut();
                    this.f27907h.e();
                    min = Math.min(this.f27907h.f27895b, this.f27904e.size());
                    this.f27907h.f27895b -= min;
                }
                this.f27907h.k.enter();
                try {
                    this.f27907h.f27897d.G(this.f27907h.f27896c, z && min == this.f27904e.size(), this.f27904e, min);
                } finally {
                    this.f27907h.k.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f27907h) {
                    if (this.f27905f) {
                        return;
                    }
                    if (!this.f27907h.f27902i.f27906g) {
                        if (this.f27904e.size() > 0) {
                            while (this.f27904e.size() > 0) {
                                a(true);
                            }
                        } else {
                            g gVar = this.f27907h;
                            gVar.f27897d.G(gVar.f27896c, true, null, 0L);
                        }
                    }
                    synchronized (this.f27907h) {
                        this.f27905f = true;
                    }
                    this.f27907h.f27897d.flush();
                    this.f27907h.d();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f27907h) {
                    this.f27907h.e();
                }
                while (this.f27904e.size() > 0) {
                    a(false);
                    this.f27907h.f27897d.flush();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27907h.k : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048580, this, buffer, j2) == null) {
                this.f27904e.write(buffer, j2);
                while (this.f27904e.size() >= 16384) {
                    a(false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class b implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Buffer f27908e;

        /* renamed from: f  reason: collision with root package name */
        public final Buffer f27909f;

        /* renamed from: g  reason: collision with root package name */
        public final long f27910g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f27911h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f27912i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ g f27913j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(93153710, "Lc/d/b/e0/k/g$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(93153710, "Lc/d/b/e0/k/g$b;");
            }
        }

        public b(g gVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f27913j = gVar;
            this.f27908e = new Buffer();
            this.f27909f = new Buffer();
            this.f27910g = j2;
        }

        public void a(BufferedSource bufferedSource, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, bufferedSource, j2) == null) {
                while (j2 > 0) {
                    synchronized (this.f27913j) {
                        z = this.f27912i;
                        z2 = true;
                        z3 = this.f27909f.size() + j2 > this.f27910g;
                    }
                    if (z3) {
                        bufferedSource.skip(j2);
                        this.f27913j.h(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.skip(j2);
                        return;
                    } else {
                        long read = bufferedSource.read(this.f27908e, j2);
                        if (read != -1) {
                            j2 -= read;
                            synchronized (this.f27913j) {
                                if (this.f27911h) {
                                    j3 = this.f27908e.size();
                                    this.f27908e.clear();
                                } else {
                                    if (this.f27909f.size() != 0) {
                                        z2 = false;
                                    }
                                    this.f27909f.writeAll(this.f27908e);
                                    if (z2) {
                                        this.f27913j.notifyAll();
                                    }
                                    j3 = 0;
                                }
                            }
                            if (j3 > 0) {
                                b(j3);
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
            }
        }

        public final void b(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f27913j.f27897d.F(j2);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            a.InterfaceC1626a interfaceC1626a;
            ArrayList<r> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f27913j) {
                    this.f27911h = true;
                    size = this.f27909f.size();
                    this.f27909f.clear();
                    interfaceC1626a = null;
                    if (this.f27913j.f27898e.isEmpty() || this.f27913j.f27899f == null) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList(this.f27913j.f27898e);
                        this.f27913j.f27898e.clear();
                        interfaceC1626a = this.f27913j.f27899f;
                        arrayList = arrayList2;
                    }
                    this.f27913j.notifyAll();
                }
                if (size > 0) {
                    b(size);
                }
                this.f27913j.d();
                if (interfaceC1626a != null) {
                    for (r rVar : arrayList) {
                        interfaceC1626a.a(rVar);
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x00cf, code lost:
            if (r11 == (-1)) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00d1, code lost:
            b(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d4, code lost:
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00d5, code lost:
            if (r0 != null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00d7, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00dd, code lost:
            throw new com.duxiaoman.okhttp3.internal.http2.StreamResetException(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00e5, code lost:
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(Buffer buffer, long j2) throws IOException {
            InterceptResult invokeLJ;
            long read;
            r rVar;
            a.InterfaceC1626a interfaceC1626a;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048579, this, buffer, j2)) != null) {
                return invokeLJ.longValue;
            }
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            while (true) {
                synchronized (this.f27913j) {
                    this.f27913j.f27903j.enter();
                    ErrorCode errorCode = this.f27913j.l != null ? this.f27913j.l : null;
                    if (this.f27911h) {
                        break;
                    }
                    if (!this.f27913j.f27898e.isEmpty() && this.f27913j.f27899f != null) {
                        rVar = (r) this.f27913j.f27898e.removeFirst();
                        interfaceC1626a = this.f27913j.f27899f;
                        read = -1;
                    } else {
                        if (this.f27909f.size() > 0) {
                            read = this.f27909f.read(buffer, Math.min(j2, this.f27909f.size()));
                            this.f27913j.a += read;
                            if (errorCode == null && this.f27913j.a >= this.f27913j.f27897d.w.d() / 2) {
                                this.f27913j.f27897d.K(this.f27913j.f27896c, this.f27913j.a);
                                this.f27913j.a = 0L;
                            }
                        } else if (this.f27912i || errorCode != null) {
                            read = -1;
                        } else {
                            this.f27913j.t();
                            this.f27913j.f27903j.exitAndThrowIfTimedOut();
                        }
                        rVar = null;
                        interfaceC1626a = null;
                    }
                    this.f27913j.f27903j.exitAndThrowIfTimedOut();
                    if (rVar == null || interfaceC1626a == null) {
                        break;
                    }
                    interfaceC1626a.a(rVar);
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27913j.f27903j : (Timeout) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends AsyncTimeout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException)) == null) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException(com.alipay.sdk.data.a.O);
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }
            return (IOException) invokeL.objValue;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.h(ErrorCode.CANCEL);
                this.a.f27897d.B();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1090404628, "Lc/d/b/e0/k/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1090404628, "Lc/d/b/e0/k/g;");
        }
    }

    public g(int i2, e eVar, boolean z, boolean z2, @Nullable r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), eVar, Boolean.valueOf(z), Boolean.valueOf(z2), rVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f27898e = new ArrayDeque();
        this.f27903j = new c(this);
        this.k = new c(this);
        this.l = null;
        if (eVar != null) {
            this.f27896c = i2;
            this.f27897d = eVar;
            this.f27895b = eVar.x.d();
            this.f27901h = new b(this, eVar.w.d());
            a aVar = new a(this);
            this.f27902i = aVar;
            this.f27901h.f27912i = z2;
            aVar.f27906g = z;
            if (rVar != null) {
                this.f27898e.add(rVar);
            }
            if (l() && rVar != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            if (!l() && rVar == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
            return;
        }
        throw new NullPointerException("connection == null");
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f27895b += j2;
            if (j2 > 0) {
                notifyAll();
            }
        }
    }

    public void d() throws IOException {
        boolean z;
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                z = !this.f27901h.f27912i && this.f27901h.f27911h && (this.f27902i.f27906g || this.f27902i.f27905f);
                m = m();
            }
            if (z) {
                f(ErrorCode.CANCEL);
            } else if (m) {
            } else {
                this.f27897d.A(this.f27896c);
            }
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = this.f27902i;
            if (!aVar.f27905f) {
                if (!aVar.f27906g) {
                    if (this.l != null) {
                        throw new StreamResetException(this.l);
                    }
                    return;
                }
                throw new IOException("stream finished");
            }
            throw new IOException("stream closed");
        }
    }

    public void f(ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, errorCode) == null) && g(errorCode)) {
            this.f27897d.I(this.f27896c, errorCode);
        }
    }

    public final boolean g(ErrorCode errorCode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, errorCode)) == null) {
            synchronized (this) {
                if (this.l != null) {
                    return false;
                }
                if (this.f27901h.f27912i && this.f27902i.f27906g) {
                    return false;
                }
                this.l = errorCode;
                notifyAll();
                this.f27897d.A(this.f27896c);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void h(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, errorCode) == null) && g(errorCode)) {
            this.f27897d.J(this.f27896c, errorCode);
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27896c : invokeV.intValue;
    }

    public Sink j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (!this.f27900g && !l()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
            return this.f27902i;
        }
        return (Sink) invokeV.objValue;
    }

    public Source k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27901h : (Source) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f27897d.f27836e == ((this.f27896c & 1) == 1);
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                if (this.l != null) {
                    return false;
                }
                if ((this.f27901h.f27912i || this.f27901h.f27911h) && (this.f27902i.f27906g || this.f27902i.f27905f)) {
                    if (this.f27900g) {
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public Timeout n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f27903j : (Timeout) invokeV.objValue;
    }

    public void o(BufferedSource bufferedSource, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, bufferedSource, i2) == null) {
            this.f27901h.a(bufferedSource, i2);
        }
    }

    public void p() {
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                this.f27901h.f27912i = true;
                m = m();
                notifyAll();
            }
            if (m) {
                return;
            }
            this.f27897d.A(this.f27896c);
        }
    }

    public void q(List<c.d.b.e0.k.a> list) {
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            synchronized (this) {
                this.f27900g = true;
                this.f27898e.add(c.d.b.e0.e.G(list));
                m = m();
                notifyAll();
            }
            if (m) {
                return;
            }
            this.f27897d.A(this.f27896c);
        }
    }

    public synchronized void r(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, errorCode) == null) {
            synchronized (this) {
                if (this.l == null) {
                    this.l = errorCode;
                    notifyAll();
                }
            }
        }
    }

    public synchronized r s() throws IOException {
        InterceptResult invokeV;
        r removeFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                this.f27903j.enter();
                while (this.f27898e.isEmpty() && this.l == null) {
                    t();
                }
                this.f27903j.exitAndThrowIfTimedOut();
                if (!this.f27898e.isEmpty()) {
                    removeFirst = this.f27898e.removeFirst();
                } else {
                    throw new StreamResetException(this.l);
                }
            }
            return removeFirst;
        }
        return (r) invokeV.objValue;
    }

    public void t() throws InterruptedIOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        }
    }

    public Timeout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k : (Timeout) invokeV.objValue;
    }
}
