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
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f31870a;

    /* renamed from: b  reason: collision with root package name */
    public long f31871b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31872c;

    /* renamed from: d  reason: collision with root package name */
    public final e f31873d;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<r> f31874e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1455a f31875f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31876g;

    /* renamed from: h  reason: collision with root package name */
    public final b f31877h;

    /* renamed from: i  reason: collision with root package name */
    public final a f31878i;

    /* renamed from: j  reason: collision with root package name */
    public final c f31879j;
    public final c k;
    public ErrorCode l;

    /* loaded from: classes4.dex */
    public final class a implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Buffer f31880e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31881f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f31882g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f31883h;

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
            this.f31883h = gVar;
            this.f31880e = new Buffer();
        }

        public final void a(boolean z) throws IOException {
            long min;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                synchronized (this.f31883h) {
                    this.f31883h.k.enter();
                    while (this.f31883h.f31871b <= 0 && !this.f31882g && !this.f31881f && this.f31883h.l == null) {
                        this.f31883h.t();
                    }
                    this.f31883h.k.exitAndThrowIfTimedOut();
                    this.f31883h.e();
                    min = Math.min(this.f31883h.f31871b, this.f31880e.size());
                    this.f31883h.f31871b -= min;
                }
                this.f31883h.k.enter();
                try {
                    this.f31883h.f31873d.K(this.f31883h.f31872c, z && min == this.f31880e.size(), this.f31880e, min);
                } finally {
                    this.f31883h.k.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f31883h) {
                    if (this.f31881f) {
                        return;
                    }
                    if (!this.f31883h.f31878i.f31882g) {
                        if (this.f31880e.size() > 0) {
                            while (this.f31880e.size() > 0) {
                                a(true);
                            }
                        } else {
                            g gVar = this.f31883h;
                            gVar.f31873d.K(gVar.f31872c, true, null, 0L);
                        }
                    }
                    synchronized (this.f31883h) {
                        this.f31881f = true;
                    }
                    this.f31883h.f31873d.flush();
                    this.f31883h.d();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f31883h) {
                    this.f31883h.e();
                }
                while (this.f31880e.size() > 0) {
                    a(false);
                    this.f31883h.f31873d.flush();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31883h.k : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048580, this, buffer, j2) == null) {
                this.f31880e.write(buffer, j2);
                while (this.f31880e.size() >= 16384) {
                    a(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class b implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Buffer f31884e;

        /* renamed from: f  reason: collision with root package name */
        public final Buffer f31885f;

        /* renamed from: g  reason: collision with root package name */
        public final long f31886g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f31887h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f31888i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ g f31889j;

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
            this.f31889j = gVar;
            this.f31884e = new Buffer();
            this.f31885f = new Buffer();
            this.f31886g = j2;
        }

        public void a(BufferedSource bufferedSource, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, bufferedSource, j2) == null) {
                while (j2 > 0) {
                    synchronized (this.f31889j) {
                        z = this.f31888i;
                        z2 = true;
                        z3 = this.f31885f.size() + j2 > this.f31886g;
                    }
                    if (z3) {
                        bufferedSource.skip(j2);
                        this.f31889j.h(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.skip(j2);
                        return;
                    } else {
                        long read = bufferedSource.read(this.f31884e, j2);
                        if (read != -1) {
                            j2 -= read;
                            synchronized (this.f31889j) {
                                if (this.f31887h) {
                                    j3 = this.f31884e.size();
                                    this.f31884e.clear();
                                } else {
                                    if (this.f31885f.size() != 0) {
                                        z2 = false;
                                    }
                                    this.f31885f.writeAll(this.f31884e);
                                    if (z2) {
                                        this.f31889j.notifyAll();
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
                this.f31889j.f31873d.J(j2);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            a.InterfaceC1455a interfaceC1455a;
            ArrayList<r> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f31889j) {
                    this.f31887h = true;
                    size = this.f31885f.size();
                    this.f31885f.clear();
                    interfaceC1455a = null;
                    if (this.f31889j.f31874e.isEmpty() || this.f31889j.f31875f == null) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList(this.f31889j.f31874e);
                        this.f31889j.f31874e.clear();
                        interfaceC1455a = this.f31889j.f31875f;
                        arrayList = arrayList2;
                    }
                    this.f31889j.notifyAll();
                }
                if (size > 0) {
                    b(size);
                }
                this.f31889j.d();
                if (interfaceC1455a != null) {
                    for (r rVar : arrayList) {
                        interfaceC1455a.a(rVar);
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
            a.InterfaceC1455a interfaceC1455a;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048579, this, buffer, j2)) != null) {
                return invokeLJ.longValue;
            }
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            while (true) {
                synchronized (this.f31889j) {
                    this.f31889j.f31879j.enter();
                    ErrorCode errorCode = this.f31889j.l != null ? this.f31889j.l : null;
                    if (this.f31887h) {
                        break;
                    }
                    if (!this.f31889j.f31874e.isEmpty() && this.f31889j.f31875f != null) {
                        rVar = (r) this.f31889j.f31874e.removeFirst();
                        interfaceC1455a = this.f31889j.f31875f;
                        read = -1;
                    } else {
                        if (this.f31885f.size() > 0) {
                            read = this.f31885f.read(buffer, Math.min(j2, this.f31885f.size()));
                            this.f31889j.f31870a += read;
                            if (errorCode == null && this.f31889j.f31870a >= this.f31889j.f31873d.w.d() / 2) {
                                this.f31889j.f31873d.O(this.f31889j.f31872c, this.f31889j.f31870a);
                                this.f31889j.f31870a = 0L;
                            }
                        } else if (this.f31888i || errorCode != null) {
                            read = -1;
                        } else {
                            this.f31889j.t();
                            this.f31889j.f31879j.exitAndThrowIfTimedOut();
                        }
                        rVar = null;
                        interfaceC1455a = null;
                    }
                    this.f31889j.f31879j.exitAndThrowIfTimedOut();
                    if (rVar == null || interfaceC1455a == null) {
                        break;
                    }
                    interfaceC1455a.a(rVar);
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31889j.f31879j : (Timeout) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends AsyncTimeout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f31890a;

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
            this.f31890a = gVar;
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
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
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
                this.f31890a.h(ErrorCode.CANCEL);
                this.f31890a.f31873d.F();
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
        this.f31870a = 0L;
        this.f31874e = new ArrayDeque();
        this.f31879j = new c(this);
        this.k = new c(this);
        this.l = null;
        if (eVar != null) {
            this.f31872c = i2;
            this.f31873d = eVar;
            this.f31871b = eVar.x.d();
            this.f31877h = new b(this, eVar.w.d());
            a aVar = new a(this);
            this.f31878i = aVar;
            this.f31877h.f31888i = z2;
            aVar.f31882g = z;
            if (rVar != null) {
                this.f31874e.add(rVar);
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
            this.f31871b += j2;
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
                z = !this.f31877h.f31888i && this.f31877h.f31887h && (this.f31878i.f31882g || this.f31878i.f31881f);
                m = m();
            }
            if (z) {
                f(ErrorCode.CANCEL);
            } else if (m) {
            } else {
                this.f31873d.E(this.f31872c);
            }
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = this.f31878i;
            if (!aVar.f31881f) {
                if (!aVar.f31882g) {
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
            this.f31873d.M(this.f31872c, errorCode);
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
                if (this.f31877h.f31888i && this.f31878i.f31882g) {
                    return false;
                }
                this.l = errorCode;
                notifyAll();
                this.f31873d.E(this.f31872c);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void h(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, errorCode) == null) && g(errorCode)) {
            this.f31873d.N(this.f31872c, errorCode);
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31872c : invokeV.intValue;
    }

    public Sink j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (!this.f31876g && !l()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
            return this.f31878i;
        }
        return (Sink) invokeV.objValue;
    }

    public Source k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31877h : (Source) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f31873d.f31809e == ((this.f31872c & 1) == 1);
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
                if ((this.f31877h.f31888i || this.f31877h.f31887h) && (this.f31878i.f31882g || this.f31878i.f31881f)) {
                    if (this.f31876g) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f31879j : (Timeout) invokeV.objValue;
    }

    public void o(BufferedSource bufferedSource, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, bufferedSource, i2) == null) {
            this.f31877h.a(bufferedSource, i2);
        }
    }

    public void p() {
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                this.f31877h.f31888i = true;
                m = m();
                notifyAll();
            }
            if (m) {
                return;
            }
            this.f31873d.E(this.f31872c);
        }
    }

    public void q(List<c.d.b.e0.k.a> list) {
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            synchronized (this) {
                this.f31876g = true;
                this.f31874e.add(c.d.b.e0.e.G(list));
                m = m();
                notifyAll();
            }
            if (m) {
                return;
            }
            this.f31873d.E(this.f31872c);
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
                this.f31879j.enter();
                while (this.f31874e.isEmpty() && this.l == null) {
                    t();
                }
                this.f31879j.exitAndThrowIfTimedOut();
                if (!this.f31874e.isEmpty()) {
                    removeFirst = this.f31874e.removeFirst();
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
