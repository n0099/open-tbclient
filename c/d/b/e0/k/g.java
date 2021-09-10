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
    public long f31979a;

    /* renamed from: b  reason: collision with root package name */
    public long f31980b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31981c;

    /* renamed from: d  reason: collision with root package name */
    public final e f31982d;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<r> f31983e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1455a f31984f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31985g;

    /* renamed from: h  reason: collision with root package name */
    public final b f31986h;

    /* renamed from: i  reason: collision with root package name */
    public final a f31987i;

    /* renamed from: j  reason: collision with root package name */
    public final c f31988j;
    public final c k;
    public ErrorCode l;

    /* loaded from: classes4.dex */
    public final class a implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Buffer f31989e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31990f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f31991g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f31992h;

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
            this.f31992h = gVar;
            this.f31989e = new Buffer();
        }

        public final void a(boolean z) throws IOException {
            long min;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                synchronized (this.f31992h) {
                    this.f31992h.k.enter();
                    while (this.f31992h.f31980b <= 0 && !this.f31991g && !this.f31990f && this.f31992h.l == null) {
                        this.f31992h.t();
                    }
                    this.f31992h.k.exitAndThrowIfTimedOut();
                    this.f31992h.e();
                    min = Math.min(this.f31992h.f31980b, this.f31989e.size());
                    this.f31992h.f31980b -= min;
                }
                this.f31992h.k.enter();
                try {
                    this.f31992h.f31982d.K(this.f31992h.f31981c, z && min == this.f31989e.size(), this.f31989e, min);
                } finally {
                    this.f31992h.k.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f31992h) {
                    if (this.f31990f) {
                        return;
                    }
                    if (!this.f31992h.f31987i.f31991g) {
                        if (this.f31989e.size() > 0) {
                            while (this.f31989e.size() > 0) {
                                a(true);
                            }
                        } else {
                            g gVar = this.f31992h;
                            gVar.f31982d.K(gVar.f31981c, true, null, 0L);
                        }
                    }
                    synchronized (this.f31992h) {
                        this.f31990f = true;
                    }
                    this.f31992h.f31982d.flush();
                    this.f31992h.d();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f31992h) {
                    this.f31992h.e();
                }
                while (this.f31989e.size() > 0) {
                    a(false);
                    this.f31992h.f31982d.flush();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31992h.k : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048580, this, buffer, j2) == null) {
                this.f31989e.write(buffer, j2);
                while (this.f31989e.size() >= 16384) {
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
        public final Buffer f31993e;

        /* renamed from: f  reason: collision with root package name */
        public final Buffer f31994f;

        /* renamed from: g  reason: collision with root package name */
        public final long f31995g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f31996h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f31997i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ g f31998j;

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
            this.f31998j = gVar;
            this.f31993e = new Buffer();
            this.f31994f = new Buffer();
            this.f31995g = j2;
        }

        public void a(BufferedSource bufferedSource, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, bufferedSource, j2) == null) {
                while (j2 > 0) {
                    synchronized (this.f31998j) {
                        z = this.f31997i;
                        z2 = true;
                        z3 = this.f31994f.size() + j2 > this.f31995g;
                    }
                    if (z3) {
                        bufferedSource.skip(j2);
                        this.f31998j.h(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.skip(j2);
                        return;
                    } else {
                        long read = bufferedSource.read(this.f31993e, j2);
                        if (read != -1) {
                            j2 -= read;
                            synchronized (this.f31998j) {
                                if (this.f31996h) {
                                    j3 = this.f31993e.size();
                                    this.f31993e.clear();
                                } else {
                                    if (this.f31994f.size() != 0) {
                                        z2 = false;
                                    }
                                    this.f31994f.writeAll(this.f31993e);
                                    if (z2) {
                                        this.f31998j.notifyAll();
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
                this.f31998j.f31982d.J(j2);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            a.InterfaceC1455a interfaceC1455a;
            ArrayList<r> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.f31998j) {
                    this.f31996h = true;
                    size = this.f31994f.size();
                    this.f31994f.clear();
                    interfaceC1455a = null;
                    if (this.f31998j.f31983e.isEmpty() || this.f31998j.f31984f == null) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList(this.f31998j.f31983e);
                        this.f31998j.f31983e.clear();
                        interfaceC1455a = this.f31998j.f31984f;
                        arrayList = arrayList2;
                    }
                    this.f31998j.notifyAll();
                }
                if (size > 0) {
                    b(size);
                }
                this.f31998j.d();
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
                synchronized (this.f31998j) {
                    this.f31998j.f31988j.enter();
                    ErrorCode errorCode = this.f31998j.l != null ? this.f31998j.l : null;
                    if (this.f31996h) {
                        break;
                    }
                    if (!this.f31998j.f31983e.isEmpty() && this.f31998j.f31984f != null) {
                        rVar = (r) this.f31998j.f31983e.removeFirst();
                        interfaceC1455a = this.f31998j.f31984f;
                        read = -1;
                    } else {
                        if (this.f31994f.size() > 0) {
                            read = this.f31994f.read(buffer, Math.min(j2, this.f31994f.size()));
                            this.f31998j.f31979a += read;
                            if (errorCode == null && this.f31998j.f31979a >= this.f31998j.f31982d.w.d() / 2) {
                                this.f31998j.f31982d.O(this.f31998j.f31981c, this.f31998j.f31979a);
                                this.f31998j.f31979a = 0L;
                            }
                        } else if (this.f31997i || errorCode != null) {
                            read = -1;
                        } else {
                            this.f31998j.t();
                            this.f31998j.f31988j.exitAndThrowIfTimedOut();
                        }
                        rVar = null;
                        interfaceC1455a = null;
                    }
                    this.f31998j.f31988j.exitAndThrowIfTimedOut();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31998j.f31988j : (Timeout) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends AsyncTimeout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f31999a;

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
            this.f31999a = gVar;
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
                this.f31999a.h(ErrorCode.CANCEL);
                this.f31999a.f31982d.F();
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
        this.f31979a = 0L;
        this.f31983e = new ArrayDeque();
        this.f31988j = new c(this);
        this.k = new c(this);
        this.l = null;
        if (eVar != null) {
            this.f31981c = i2;
            this.f31982d = eVar;
            this.f31980b = eVar.x.d();
            this.f31986h = new b(this, eVar.w.d());
            a aVar = new a(this);
            this.f31987i = aVar;
            this.f31986h.f31997i = z2;
            aVar.f31991g = z;
            if (rVar != null) {
                this.f31983e.add(rVar);
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
            this.f31980b += j2;
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
                z = !this.f31986h.f31997i && this.f31986h.f31996h && (this.f31987i.f31991g || this.f31987i.f31990f);
                m = m();
            }
            if (z) {
                f(ErrorCode.CANCEL);
            } else if (m) {
            } else {
                this.f31982d.E(this.f31981c);
            }
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a aVar = this.f31987i;
            if (!aVar.f31990f) {
                if (!aVar.f31991g) {
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
            this.f31982d.M(this.f31981c, errorCode);
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
                if (this.f31986h.f31997i && this.f31987i.f31991g) {
                    return false;
                }
                this.l = errorCode;
                notifyAll();
                this.f31982d.E(this.f31981c);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void h(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, errorCode) == null) && g(errorCode)) {
            this.f31982d.N(this.f31981c, errorCode);
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31981c : invokeV.intValue;
    }

    public Sink j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (!this.f31985g && !l()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
            return this.f31987i;
        }
        return (Sink) invokeV.objValue;
    }

    public Source k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31986h : (Source) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f31982d.f31918e == ((this.f31981c & 1) == 1);
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
                if ((this.f31986h.f31997i || this.f31986h.f31996h) && (this.f31987i.f31991g || this.f31987i.f31990f)) {
                    if (this.f31985g) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f31988j : (Timeout) invokeV.objValue;
    }

    public void o(BufferedSource bufferedSource, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, bufferedSource, i2) == null) {
            this.f31986h.a(bufferedSource, i2);
        }
    }

    public void p() {
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                this.f31986h.f31997i = true;
                m = m();
                notifyAll();
            }
            if (m) {
                return;
            }
            this.f31982d.E(this.f31981c);
        }
    }

    public void q(List<c.d.b.e0.k.a> list) {
        boolean m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            synchronized (this) {
                this.f31985g = true;
                this.f31983e.add(c.d.b.e0.e.G(list));
                m = m();
                notifyAll();
            }
            if (m) {
                return;
            }
            this.f31982d.E(this.f31981c);
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
                this.f31988j.enter();
                while (this.f31983e.isEmpty() && this.l == null) {
                    t();
                }
                this.f31988j.exitAndThrowIfTimedOut();
                if (!this.f31983e.isEmpty()) {
                    removeFirst = this.f31983e.removeFirst();
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
