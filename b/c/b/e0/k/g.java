package b.c.b.e0.k;

import androidx.core.view.InputDeviceCompat;
import b.c.b.e0.k.a;
import b.c.b.r;
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
/* loaded from: classes6.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f31266a;

    /* renamed from: b  reason: collision with root package name */
    public long f31267b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31268c;

    /* renamed from: d  reason: collision with root package name */
    public final e f31269d;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<r> f31270e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1490a f31271f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31272g;

    /* renamed from: h  reason: collision with root package name */
    public final b f31273h;

    /* renamed from: i  reason: collision with root package name */
    public final a f31274i;
    public final c j;
    public final c k;
    public ErrorCode l;

    /* loaded from: classes6.dex */
    public final class a implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Buffer f31275e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31276f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f31277g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f31278h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1120995123, "Lb/c/b/e0/k/g$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1120995123, "Lb/c/b/e0/k/g$a;");
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
            this.f31278h = gVar;
            this.f31275e = new Buffer();
        }

        public final void a(boolean z) throws IOException {
            long min;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                synchronized (this.f31278h) {
                    this.f31278h.k.enter();
                    while (this.f31278h.f31267b <= 0 && !this.f31277g && !this.f31276f && this.f31278h.l == null) {
                        this.f31278h.t();
                    }
                    this.f31278h.k.exitAndThrowIfTimedOut();
                    this.f31278h.e();
                    min = Math.min(this.f31278h.f31267b, this.f31275e.size());
                    this.f31278h.f31267b -= min;
                }
                this.f31278h.k.enter();
                try {
                    this.f31278h.f31269d.G(this.f31278h.f31268c, z && min == this.f31275e.size(), this.f31275e, min);
                } finally {
                    this.f31278h.k.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f31278h) {
                    if (this.f31276f) {
                        return;
                    }
                    if (!this.f31278h.f31274i.f31277g) {
                        if (this.f31275e.size() > 0) {
                            while (this.f31275e.size() > 0) {
                                a(true);
                            }
                        } else {
                            g gVar = this.f31278h;
                            gVar.f31269d.G(gVar.f31268c, true, null, 0L);
                        }
                    }
                    synchronized (this.f31278h) {
                        this.f31276f = true;
                    }
                    this.f31278h.f31269d.flush();
                    this.f31278h.d();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f31278h) {
                    this.f31278h.e();
                }
                while (this.f31275e.size() > 0) {
                    a(false);
                    this.f31278h.f31269d.flush();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31278h.k : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048580, this, buffer, j) == null) {
                this.f31275e.write(buffer, j);
                while (this.f31275e.size() >= 16384) {
                    a(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class b implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Buffer f31279e;

        /* renamed from: f  reason: collision with root package name */
        public final Buffer f31280f;

        /* renamed from: g  reason: collision with root package name */
        public final long f31281g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f31282h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f31283i;
        public final /* synthetic */ g j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1120995092, "Lb/c/b/e0/k/g$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1120995092, "Lb/c/b/e0/k/g$b;");
            }
        }

        public b(g gVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.j = gVar;
            this.f31279e = new Buffer();
            this.f31280f = new Buffer();
            this.f31281g = j;
        }

        public void a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, bufferedSource, j) == null) {
                while (j > 0) {
                    synchronized (this.j) {
                        z = this.f31283i;
                        z2 = true;
                        z3 = this.f31280f.size() + j > this.f31281g;
                    }
                    if (z3) {
                        bufferedSource.skip(j);
                        this.j.h(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.skip(j);
                        return;
                    } else {
                        long read = bufferedSource.read(this.f31279e, j);
                        if (read != -1) {
                            j -= read;
                            synchronized (this.j) {
                                if (this.f31282h) {
                                    j2 = this.f31279e.size();
                                    this.f31279e.clear();
                                } else {
                                    if (this.f31280f.size() != 0) {
                                        z2 = false;
                                    }
                                    this.f31280f.writeAll(this.f31279e);
                                    if (z2) {
                                        this.j.notifyAll();
                                    }
                                    j2 = 0;
                                }
                            }
                            if (j2 > 0) {
                                b(j2);
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
            }
        }

        public final void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.j.f31269d.F(j);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            a.InterfaceC1490a interfaceC1490a;
            ArrayList<r> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.j) {
                    this.f31282h = true;
                    size = this.f31280f.size();
                    this.f31280f.clear();
                    interfaceC1490a = null;
                    if (this.j.f31270e.isEmpty() || this.j.f31271f == null) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList(this.j.f31270e);
                        this.j.f31270e.clear();
                        interfaceC1490a = this.j.f31271f;
                        arrayList = arrayList2;
                    }
                    this.j.notifyAll();
                }
                if (size > 0) {
                    b(size);
                }
                this.j.d();
                if (interfaceC1490a != null) {
                    for (r rVar : arrayList) {
                        interfaceC1490a.a(rVar);
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
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            long read;
            r rVar;
            a.InterfaceC1490a interfaceC1490a;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048579, this, buffer, j)) != null) {
                return invokeLJ.longValue;
            }
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            while (true) {
                synchronized (this.j) {
                    this.j.j.enter();
                    ErrorCode errorCode = this.j.l != null ? this.j.l : null;
                    if (this.f31282h) {
                        break;
                    }
                    if (!this.j.f31270e.isEmpty() && this.j.f31271f != null) {
                        rVar = (r) this.j.f31270e.removeFirst();
                        interfaceC1490a = this.j.f31271f;
                        read = -1;
                    } else {
                        if (this.f31280f.size() > 0) {
                            read = this.f31280f.read(buffer, Math.min(j, this.f31280f.size()));
                            this.j.f31266a += read;
                            if (errorCode == null && this.j.f31266a >= this.j.f31269d.w.d() / 2) {
                                this.j.f31269d.K(this.j.f31268c, this.j.f31266a);
                                this.j.f31266a = 0L;
                            }
                        } else if (this.f31283i || errorCode != null) {
                            read = -1;
                        } else {
                            this.j.t();
                            this.j.j.exitAndThrowIfTimedOut();
                        }
                        rVar = null;
                        interfaceC1490a = null;
                    }
                    this.j.j.exitAndThrowIfTimedOut();
                    if (rVar == null || interfaceC1490a == null) {
                        break;
                    }
                    interfaceC1490a.a(rVar);
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j.j : (Timeout) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends AsyncTimeout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f31284a;

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
            this.f31284a = gVar;
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
                this.f31284a.h(ErrorCode.CANCEL);
                this.f31284a.f31269d.B();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(999949738, "Lb/c/b/e0/k/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(999949738, "Lb/c/b/e0/k/g;");
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
        this.f31266a = 0L;
        this.f31270e = new ArrayDeque();
        this.j = new c(this);
        this.k = new c(this);
        this.l = null;
        if (eVar != null) {
            this.f31268c = i2;
            this.f31269d = eVar;
            this.f31267b = eVar.x.d();
            this.f31273h = new b(this, eVar.w.d());
            a aVar = new a(this);
            this.f31274i = aVar;
            this.f31273h.f31283i = z2;
            aVar.f31277g = z;
            if (rVar != null) {
                this.f31270e.add(rVar);
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

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.f31267b += j;
            if (j > 0) {
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
                z = !this.f31273h.f31283i && this.f31273h.f31282h && (this.f31274i.f31277g || this.f31274i.f31276f);
                m = m();
            }
            if (z) {
                f(ErrorCode.CANCEL);
            } else if (m) {
            } else {
                this.f31269d.A(this.f31268c);
            }
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = this.f31274i;
            if (!aVar.f31276f) {
                if (!aVar.f31277g) {
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
            this.f31269d.I(this.f31268c, errorCode);
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
                if (this.f31273h.f31283i && this.f31274i.f31277g) {
                    return false;
                }
                this.l = errorCode;
                notifyAll();
                this.f31269d.A(this.f31268c);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void h(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, errorCode) == null) && g(errorCode)) {
            this.f31269d.J(this.f31268c, errorCode);
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31268c : invokeV.intValue;
    }

    public Sink j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (!this.f31272g && !l()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
            return this.f31274i;
        }
        return (Sink) invokeV.objValue;
    }

    public Source k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31273h : (Source) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f31269d.f31208e == ((this.f31268c & 1) == 1);
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
                if ((this.f31273h.f31283i || this.f31273h.f31282h) && (this.f31274i.f31277g || this.f31274i.f31276f)) {
                    if (this.f31272g) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : (Timeout) invokeV.objValue;
    }

    public void o(BufferedSource bufferedSource, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, bufferedSource, i2) == null) {
            this.f31273h.a(bufferedSource, i2);
        }
    }

    public void p() {
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                this.f31273h.f31283i = true;
                m = m();
                notifyAll();
            }
            if (m) {
                return;
            }
            this.f31269d.A(this.f31268c);
        }
    }

    public void q(List<b.c.b.e0.k.a> list) {
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            synchronized (this) {
                this.f31272g = true;
                this.f31270e.add(b.c.b.e0.e.G(list));
                m = m();
                notifyAll();
            }
            if (m) {
                return;
            }
            this.f31269d.A(this.f31268c);
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
                this.j.enter();
                while (this.f31270e.isEmpty() && this.l == null) {
                    t();
                }
                this.j.exitAndThrowIfTimedOut();
                if (!this.f31270e.isEmpty()) {
                    removeFirst = this.f31270e.removeFirst();
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
