package b.d.b.e0.k;

import androidx.core.view.InputDeviceCompat;
import b.d.b.e0.k.a;
import b.d.b.r;
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
    public long f30408a;

    /* renamed from: b  reason: collision with root package name */
    public long f30409b;

    /* renamed from: c  reason: collision with root package name */
    public final int f30410c;

    /* renamed from: d  reason: collision with root package name */
    public final e f30411d;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<r> f30412e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1448a f30413f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30414g;

    /* renamed from: h  reason: collision with root package name */
    public final b f30415h;

    /* renamed from: i  reason: collision with root package name */
    public final a f30416i;
    public final c j;
    public final c k;
    public ErrorCode l;

    /* loaded from: classes6.dex */
    public final class a implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Buffer f30417e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f30418f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f30419g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f30420h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1414398130, "Lb/d/b/e0/k/g$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1414398130, "Lb/d/b/e0/k/g$a;");
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
            this.f30420h = gVar;
            this.f30417e = new Buffer();
        }

        public final void a(boolean z) throws IOException {
            long min;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                synchronized (this.f30420h) {
                    this.f30420h.k.enter();
                    while (this.f30420h.f30409b <= 0 && !this.f30419g && !this.f30418f && this.f30420h.l == null) {
                        this.f30420h.t();
                    }
                    this.f30420h.k.exitAndThrowIfTimedOut();
                    this.f30420h.e();
                    min = Math.min(this.f30420h.f30409b, this.f30417e.size());
                    this.f30420h.f30409b -= min;
                }
                this.f30420h.k.enter();
                try {
                    this.f30420h.f30411d.G(this.f30420h.f30410c, z && min == this.f30417e.size(), this.f30417e, min);
                } finally {
                    this.f30420h.k.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f30420h) {
                    if (this.f30418f) {
                        return;
                    }
                    if (!this.f30420h.f30416i.f30419g) {
                        if (this.f30417e.size() > 0) {
                            while (this.f30417e.size() > 0) {
                                a(true);
                            }
                        } else {
                            g gVar = this.f30420h;
                            gVar.f30411d.G(gVar.f30410c, true, null, 0L);
                        }
                    }
                    synchronized (this.f30420h) {
                        this.f30418f = true;
                    }
                    this.f30420h.f30411d.flush();
                    this.f30420h.d();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f30420h) {
                    this.f30420h.e();
                }
                while (this.f30417e.size() > 0) {
                    a(false);
                    this.f30420h.f30411d.flush();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30420h.k : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048580, this, buffer, j) == null) {
                this.f30417e.write(buffer, j);
                while (this.f30417e.size() >= 16384) {
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
        public final Buffer f30421e;

        /* renamed from: f  reason: collision with root package name */
        public final Buffer f30422f;

        /* renamed from: g  reason: collision with root package name */
        public final long f30423g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f30424h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f30425i;
        public final /* synthetic */ g j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1414398099, "Lb/d/b/e0/k/g$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1414398099, "Lb/d/b/e0/k/g$b;");
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
            this.f30421e = new Buffer();
            this.f30422f = new Buffer();
            this.f30423g = j;
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
                        z = this.f30425i;
                        z2 = true;
                        z3 = this.f30422f.size() + j > this.f30423g;
                    }
                    if (z3) {
                        bufferedSource.skip(j);
                        this.j.h(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.skip(j);
                        return;
                    } else {
                        long read = bufferedSource.read(this.f30421e, j);
                        if (read != -1) {
                            j -= read;
                            synchronized (this.j) {
                                if (this.f30424h) {
                                    j2 = this.f30421e.size();
                                    this.f30421e.clear();
                                } else {
                                    if (this.f30422f.size() != 0) {
                                        z2 = false;
                                    }
                                    this.f30422f.writeAll(this.f30421e);
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
                this.j.f30411d.F(j);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            a.InterfaceC1448a interfaceC1448a;
            ArrayList<r> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.j) {
                    this.f30424h = true;
                    size = this.f30422f.size();
                    this.f30422f.clear();
                    interfaceC1448a = null;
                    if (this.j.f30412e.isEmpty() || this.j.f30413f == null) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList(this.j.f30412e);
                        this.j.f30412e.clear();
                        interfaceC1448a = this.j.f30413f;
                        arrayList = arrayList2;
                    }
                    this.j.notifyAll();
                }
                if (size > 0) {
                    b(size);
                }
                this.j.d();
                if (interfaceC1448a != null) {
                    for (r rVar : arrayList) {
                        interfaceC1448a.a(rVar);
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
            a.InterfaceC1448a interfaceC1448a;
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
                    if (this.f30424h) {
                        break;
                    }
                    if (!this.j.f30412e.isEmpty() && this.j.f30413f != null) {
                        rVar = (r) this.j.f30412e.removeFirst();
                        interfaceC1448a = this.j.f30413f;
                        read = -1;
                    } else {
                        if (this.f30422f.size() > 0) {
                            read = this.f30422f.read(buffer, Math.min(j, this.f30422f.size()));
                            this.j.f30408a += read;
                            if (errorCode == null && this.j.f30408a >= this.j.f30411d.w.d() / 2) {
                                this.j.f30411d.K(this.j.f30410c, this.j.f30408a);
                                this.j.f30408a = 0L;
                            }
                        } else if (this.f30425i || errorCode != null) {
                            read = -1;
                        } else {
                            this.j.t();
                            this.j.j.exitAndThrowIfTimedOut();
                        }
                        rVar = null;
                        interfaceC1448a = null;
                    }
                    this.j.j.exitAndThrowIfTimedOut();
                    if (rVar == null || interfaceC1448a == null) {
                        break;
                    }
                    interfaceC1448a.a(rVar);
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
        public final /* synthetic */ g f30426a;

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
            this.f30426a = gVar;
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
                this.f30426a.h(ErrorCode.CANCEL);
                this.f30426a.f30411d.B();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-797001621, "Lb/d/b/e0/k/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-797001621, "Lb/d/b/e0/k/g;");
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
        this.f30408a = 0L;
        this.f30412e = new ArrayDeque();
        this.j = new c(this);
        this.k = new c(this);
        this.l = null;
        if (eVar != null) {
            this.f30410c = i2;
            this.f30411d = eVar;
            this.f30409b = eVar.x.d();
            this.f30415h = new b(this, eVar.w.d());
            a aVar = new a(this);
            this.f30416i = aVar;
            this.f30415h.f30425i = z2;
            aVar.f30419g = z;
            if (rVar != null) {
                this.f30412e.add(rVar);
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
            this.f30409b += j;
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
                z = !this.f30415h.f30425i && this.f30415h.f30424h && (this.f30416i.f30419g || this.f30416i.f30418f);
                m = m();
            }
            if (z) {
                f(ErrorCode.CANCEL);
            } else if (m) {
            } else {
                this.f30411d.A(this.f30410c);
            }
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = this.f30416i;
            if (!aVar.f30418f) {
                if (!aVar.f30419g) {
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
            this.f30411d.I(this.f30410c, errorCode);
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
                if (this.f30415h.f30425i && this.f30416i.f30419g) {
                    return false;
                }
                this.l = errorCode;
                notifyAll();
                this.f30411d.A(this.f30410c);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void h(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, errorCode) == null) && g(errorCode)) {
            this.f30411d.J(this.f30410c, errorCode);
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30410c : invokeV.intValue;
    }

    public Sink j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (!this.f30414g && !l()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
            return this.f30416i;
        }
        return (Sink) invokeV.objValue;
    }

    public Source k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f30415h : (Source) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f30411d.f30350e == ((this.f30410c & 1) == 1);
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
                if ((this.f30415h.f30425i || this.f30415h.f30424h) && (this.f30416i.f30419g || this.f30416i.f30418f)) {
                    if (this.f30414g) {
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
            this.f30415h.a(bufferedSource, i2);
        }
    }

    public void p() {
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                this.f30415h.f30425i = true;
                m = m();
                notifyAll();
            }
            if (m) {
                return;
            }
            this.f30411d.A(this.f30410c);
        }
    }

    public void q(List<b.d.b.e0.k.a> list) {
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            synchronized (this) {
                this.f30414g = true;
                this.f30412e.add(b.d.b.e0.e.G(list));
                m = m();
                notifyAll();
            }
            if (m) {
                return;
            }
            this.f30411d.A(this.f30410c);
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
                while (this.f30412e.isEmpty() && this.l == null) {
                    t();
                }
                this.j.exitAndThrowIfTimedOut();
                if (!this.f30412e.isEmpty()) {
                    removeFirst = this.f30412e.removeFirst();
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
