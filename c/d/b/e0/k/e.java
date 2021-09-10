package c.d.b.e0.k;

import androidx.core.view.InputDeviceCompat;
import c.d.b.e0.k.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.internal.http2.ConnectionShutdownException;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
/* loaded from: classes4.dex */
public final class e implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService C;
    public transient /* synthetic */ FieldHolder $fh;
    public final l A;
    public final Set<Integer> B;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f31918e;

    /* renamed from: f  reason: collision with root package name */
    public final j f31919f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<Integer, c.d.b.e0.k.g> f31920g;

    /* renamed from: h  reason: collision with root package name */
    public final String f31921h;

    /* renamed from: i  reason: collision with root package name */
    public int f31922i;

    /* renamed from: j  reason: collision with root package name */
    public int f31923j;
    public boolean k;
    public final ScheduledExecutorService l;
    public final ExecutorService m;
    public final c.d.b.e0.k.j n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public c.d.b.e0.k.k w;
    public final c.d.b.e0.k.k x;
    public final Socket y;
    public final c.d.b.e0.k.h z;

    /* loaded from: classes4.dex */
    public class a extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f31924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ErrorCode f31925g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f31926h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, String str, Object[] objArr, int i2, ErrorCode errorCode) {
            super(str, objArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {eVar, str, objArr, Integer.valueOf(i2), errorCode};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr3 = newInitContext.callArgs;
                    super((String) objArr3[0], (Object[]) objArr3[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31926h = eVar;
            this.f31924f = i2;
            this.f31925g = errorCode;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f31926h.M(this.f31924f, this.f31925g);
                } catch (IOException unused) {
                    this.f31926h.s();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f31927f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f31928g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f31929h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, String str, Object[] objArr, int i2, long j2) {
            super(str, objArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {eVar, str, objArr, Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr3 = newInitContext.callArgs;
                    super((String) objArr3[0], (Object[]) objArr3[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31929h = eVar;
            this.f31927f = i2;
            this.f31928g = j2;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f31929h.z.t(this.f31927f, this.f31928g);
                } catch (IOException unused) {
                    this.f31929h.s();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f31930f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, String str, Object... objArr) {
            super(str, objArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {eVar, str, objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr3 = newInitContext.callArgs;
                    super((String) objArr3[0], (Object[]) objArr3[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31930f = eVar;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31930f.L(false, 2, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f31931f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f31932g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f31933h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, String str, Object[] objArr, int i2, List list) {
            super(str, objArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {eVar, str, objArr, Integer.valueOf(i2), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr3 = newInitContext.callArgs;
                    super((String) objArr3[0], (Object[]) objArr3[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31933h = eVar;
            this.f31931f = i2;
            this.f31932g = list;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f31933h.n.onRequest(this.f31931f, this.f31932g)) {
                try {
                    this.f31933h.z.q(this.f31931f, ErrorCode.CANCEL);
                    synchronized (this.f31933h) {
                        this.f31933h.B.remove(Integer.valueOf(this.f31931f));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: c.d.b.e0.k.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1457e extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f31934f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f31935g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f31936h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f31937i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1457e(e eVar, String str, Object[] objArr, int i2, List list, boolean z) {
            super(str, objArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {eVar, str, objArr, Integer.valueOf(i2), list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr3 = newInitContext.callArgs;
                    super((String) objArr3[0], (Object[]) objArr3[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31937i = eVar;
            this.f31934f = i2;
            this.f31935g = list;
            this.f31936h = z;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean onHeaders = this.f31937i.n.onHeaders(this.f31934f, this.f31935g, this.f31936h);
                if (onHeaders) {
                    try {
                        this.f31937i.z.q(this.f31934f, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (onHeaders || this.f31936h) {
                    synchronized (this.f31937i) {
                        this.f31937i.B.remove(Integer.valueOf(this.f31934f));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f31938f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Buffer f31939g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f31940h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f31941i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f31942j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar, String str, Object[] objArr, int i2, Buffer buffer, int i3, boolean z) {
            super(str, objArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {eVar, str, objArr, Integer.valueOf(i2), buffer, Integer.valueOf(i3), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr3 = newInitContext.callArgs;
                    super((String) objArr3[0], (Object[]) objArr3[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31942j = eVar;
            this.f31938f = i2;
            this.f31939g = buffer;
            this.f31940h = i3;
            this.f31941i = z;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    boolean onData = this.f31942j.n.onData(this.f31938f, this.f31939g, this.f31940h, this.f31941i);
                    if (onData) {
                        this.f31942j.z.q(this.f31938f, ErrorCode.CANCEL);
                    }
                    if (onData || this.f31941i) {
                        synchronized (this.f31942j) {
                            this.f31942j.B.remove(Integer.valueOf(this.f31938f));
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f31943f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ErrorCode f31944g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f31945h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(e eVar, String str, Object[] objArr, int i2, ErrorCode errorCode) {
            super(str, objArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {eVar, str, objArr, Integer.valueOf(i2), errorCode};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr3 = newInitContext.callArgs;
                    super((String) objArr3[0], (Object[]) objArr3[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31945h = eVar;
            this.f31943f = i2;
            this.f31944g = errorCode;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31945h.n.a(this.f31943f, this.f31944g);
                synchronized (this.f31945h) {
                    this.f31945h.B.remove(Integer.valueOf(this.f31943f));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Socket f31946a;

        /* renamed from: b  reason: collision with root package name */
        public String f31947b;

        /* renamed from: c  reason: collision with root package name */
        public BufferedSource f31948c;

        /* renamed from: d  reason: collision with root package name */
        public BufferedSink f31949d;

        /* renamed from: e  reason: collision with root package name */
        public j f31950e;

        /* renamed from: f  reason: collision with root package name */
        public c.d.b.e0.k.j f31951f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f31952g;

        /* renamed from: h  reason: collision with root package name */
        public int f31953h;

        public h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31950e = j.f31955a;
            this.f31951f = c.d.b.e0.k.j.f32013a;
            this.f31952g = z;
        }

        public e a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new e(this) : (e) invokeV.objValue;
        }

        public h b(j jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar)) == null) {
                this.f31950e = jVar;
                return this;
            }
            return (h) invokeL.objValue;
        }

        public h c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f31953h = i2;
                return this;
            }
            return (h) invokeI.objValue;
        }

        public h d(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, socket, str, bufferedSource, bufferedSink)) == null) {
                this.f31946a = socket;
                this.f31947b = str;
                this.f31948c = bufferedSource;
                this.f31949d = bufferedSink;
                return this;
            }
            return (h) invokeLLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public final class i extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f31954f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(e eVar) {
            super("OkHttp %s ping", eVar.f31921h);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31954f = eVar;
        }

        @Override // c.d.b.e0.c
        public void d() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f31954f) {
                    if (this.f31954f.p < this.f31954f.o) {
                        z = true;
                    } else {
                        e.e(this.f31954f);
                        z = false;
                    }
                }
                if (z) {
                    this.f31954f.s();
                } else {
                    this.f31954f.L(false, 1, 0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final j f31955a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a extends j {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.d.b.e0.k.e.j
            public void b(c.d.b.e0.k.g gVar) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                    gVar.f(ErrorCode.REFUSED_STREAM);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(93094376, "Lc/d/b/e0/k/e$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(93094376, "Lc/d/b/e0/k/e$j;");
                    return;
                }
            }
            f31955a = new a();
        }

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public void a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            }
        }

        public abstract void b(c.d.b.e0.k.g gVar) throws IOException;
    }

    /* loaded from: classes4.dex */
    public final class k extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f31956f;

        /* renamed from: g  reason: collision with root package name */
        public final int f31957g;

        /* renamed from: h  reason: collision with root package name */
        public final int f31958h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f31959i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(e eVar, boolean z, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", eVar.f31921h, Integer.valueOf(i2), Integer.valueOf(i3));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31959i = eVar;
            this.f31956f = z;
            this.f31957g = i2;
            this.f31958h = i3;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31959i.L(this.f31956f, this.f31957g, this.f31958h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends c.d.b.e0.c implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final c.d.b.e0.k.f f31960f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f31961g;

        /* loaded from: classes4.dex */
        public class a extends c.d.b.e0.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.d.b.e0.k.g f31962f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ l f31963g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(l lVar, String str, Object[] objArr, c.d.b.e0.k.g gVar) {
                super(str, objArr);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr2 = {lVar, str, objArr, gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr3 = newInitContext.callArgs;
                        super((String) objArr3[0], (Object[]) objArr3[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31963g = lVar;
                this.f31962f = gVar;
            }

            @Override // c.d.b.e0.c
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f31963g.f31961g.f31919f.b(this.f31962f);
                    } catch (IOException e2) {
                        c.d.b.e0.m.g m = c.d.b.e0.m.g.m();
                        m.u(4, "Http2Connection.Listener failure for " + this.f31963g.f31961g.f31921h, e2);
                        try {
                            this.f31962f.f(ErrorCode.PROTOCOL_ERROR);
                        } catch (IOException unused) {
                        }
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b extends c.d.b.e0.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f31964f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c.d.b.e0.k.k f31965g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ l f31966h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(l lVar, String str, Object[] objArr, boolean z, c.d.b.e0.k.k kVar) {
                super(str, objArr);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr2 = {lVar, str, objArr, Boolean.valueOf(z), kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr3 = newInitContext.callArgs;
                        super((String) objArr3[0], (Object[]) objArr3[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31966h = lVar;
                this.f31964f = z;
                this.f31965g = kVar;
            }

            @Override // c.d.b.e0.c
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f31966h.e(this.f31964f, this.f31965g);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c extends c.d.b.e0.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f31967f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(l lVar, String str, Object... objArr) {
                super(str, objArr);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr2 = {lVar, str, objArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr3 = newInitContext.callArgs;
                        super((String) objArr3[0], (Object[]) objArr3[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31967f = lVar;
            }

            @Override // c.d.b.e0.c
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f31967f.f31961g;
                    eVar.f31919f.a(eVar);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(e eVar, c.d.b.e0.k.f fVar) {
            super("OkHttp %s", eVar.f31921h);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31961g = eVar;
            this.f31960f = fVar;
        }

        @Override // c.d.b.e0.k.f.b
        public void a(int i2, ErrorCode errorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, errorCode) == null) {
                if (this.f31961g.D(i2)) {
                    this.f31961g.C(i2, errorCode);
                    return;
                }
                c.d.b.e0.k.g E = this.f31961g.E(i2);
                if (E != null) {
                    E.r(errorCode);
                }
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void ackSettings() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void b(int i2, ErrorCode errorCode, ByteString byteString) {
            c.d.b.e0.k.g[] gVarArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, errorCode, byteString) == null) {
                byteString.size();
                synchronized (this.f31961g) {
                    gVarArr = (c.d.b.e0.k.g[]) this.f31961g.f31920g.values().toArray(new c.d.b.e0.k.g[this.f31961g.f31920g.size()]);
                    this.f31961g.k = true;
                }
                for (c.d.b.e0.k.g gVar : gVarArr) {
                    if (gVar.i() > i2 && gVar.l()) {
                        gVar.r(ErrorCode.REFUSED_STREAM);
                        this.f31961g.E(gVar.i());
                    }
                }
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void c(boolean z, c.d.b.e0.k.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048579, this, z, kVar) == null) {
                try {
                    this.f31961g.l.execute(new b(this, "OkHttp %s ACK Settings", new Object[]{this.f31961g.f31921h}, z, kVar));
                } catch (RejectedExecutionException unused) {
                }
            }
        }

        @Override // c.d.b.e0.c
        public void d() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
                try {
                    try {
                        this.f31960f.c(this);
                        while (this.f31960f.b(false, this)) {
                        }
                        errorCode = ErrorCode.NO_ERROR;
                        try {
                            try {
                                errorCode2 = ErrorCode.CANCEL;
                                eVar = this.f31961g;
                            } catch (IOException unused) {
                                errorCode = ErrorCode.PROTOCOL_ERROR;
                                errorCode2 = ErrorCode.PROTOCOL_ERROR;
                                eVar = this.f31961g;
                                eVar.r(errorCode, errorCode2);
                                c.d.b.e0.e.f(this.f31960f);
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                this.f31961g.r(errorCode, errorCode3);
                            } catch (IOException unused2) {
                            }
                            c.d.b.e0.e.f(this.f31960f);
                            throw th;
                        }
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                } catch (Throwable th2) {
                    th = th2;
                    errorCode = errorCode3;
                    this.f31961g.r(errorCode, errorCode3);
                    c.d.b.e0.e.f(this.f31960f);
                    throw th;
                }
                eVar.r(errorCode, errorCode2);
                c.d.b.e0.e.f(this.f31960f);
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void data(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), bufferedSource, Integer.valueOf(i3)}) == null) {
                if (this.f31961g.D(i2)) {
                    this.f31961g.y(i2, bufferedSource, i3, z);
                    return;
                }
                c.d.b.e0.k.g t = this.f31961g.t(i2);
                if (t == null) {
                    this.f31961g.N(i2, ErrorCode.PROTOCOL_ERROR);
                    long j2 = i3;
                    this.f31961g.J(j2);
                    bufferedSource.skip(j2);
                    return;
                }
                t.o(bufferedSource, i3);
                if (z) {
                    t.p();
                }
            }
        }

        public void e(boolean z, c.d.b.e0.k.k kVar) {
            c.d.b.e0.k.g[] gVarArr;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048582, this, z, kVar) == null) {
                synchronized (this.f31961g.z) {
                    synchronized (this.f31961g) {
                        int d2 = this.f31961g.x.d();
                        if (z) {
                            this.f31961g.x.a();
                        }
                        this.f31961g.x.h(kVar);
                        int d3 = this.f31961g.x.d();
                        gVarArr = null;
                        if (d3 == -1 || d3 == d2) {
                            j2 = 0;
                        } else {
                            j2 = d3 - d2;
                            if (!this.f31961g.f31920g.isEmpty()) {
                                gVarArr = (c.d.b.e0.k.g[]) this.f31961g.f31920g.values().toArray(new c.d.b.e0.k.g[this.f31961g.f31920g.size()]);
                            }
                        }
                    }
                    try {
                        this.f31961g.z.a(this.f31961g.x);
                    } catch (IOException unused) {
                        this.f31961g.s();
                    }
                }
                if (gVarArr != null) {
                    for (c.d.b.e0.k.g gVar : gVarArr) {
                        synchronized (gVar) {
                            gVar.c(j2);
                        }
                    }
                }
                e.C.execute(new c(this, "OkHttp %s settings", this.f31961g.f31921h));
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void headers(boolean z, int i2, int i3, List<c.d.b.e0.k.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), list}) == null) {
                if (this.f31961g.D(i2)) {
                    this.f31961g.A(i2, list, z);
                    return;
                }
                synchronized (this.f31961g) {
                    c.d.b.e0.k.g t = this.f31961g.t(i2);
                    if (t == null) {
                        if (this.f31961g.k) {
                            return;
                        }
                        if (i2 <= this.f31961g.f31922i) {
                            return;
                        }
                        if (i2 % 2 == this.f31961g.f31923j % 2) {
                            return;
                        }
                        c.d.b.e0.k.g gVar = new c.d.b.e0.k.g(i2, this.f31961g, false, z, c.d.b.e0.e.G(list));
                        this.f31961g.f31922i = i2;
                        this.f31961g.f31920g.put(Integer.valueOf(i2), gVar);
                        e.C.execute(new a(this, "OkHttp %s stream %d", new Object[]{this.f31961g.f31921h, Integer.valueOf(i2)}, gVar));
                        return;
                    }
                    t.q(list);
                    if (z) {
                        t.p();
                    }
                }
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void ping(boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                if (z) {
                    synchronized (this.f31961g) {
                        try {
                            if (i2 == 1) {
                                e.c(this.f31961g);
                            } else if (i2 == 2) {
                                e.p(this.f31961g);
                            } else if (i2 == 3) {
                                e.q(this.f31961g);
                                this.f31961g.notifyAll();
                            }
                        } finally {
                        }
                    }
                    return;
                }
                try {
                    this.f31961g.l.execute(new k(this.f31961g, true, i2, i3));
                } catch (RejectedExecutionException unused) {
                }
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void priority(int i2, int i3, int i4, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void pushPromise(int i2, int i3, List<c.d.b.e0.k.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, list) == null) {
                this.f31961g.B(i3, list);
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void windowUpdate(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (i2 == 0) {
                    synchronized (this.f31961g) {
                        this.f31961g.v += j2;
                        this.f31961g.notifyAll();
                    }
                    return;
                }
                c.d.b.e0.k.g t = this.f31961g.t(i2);
                if (t != null) {
                    synchronized (t) {
                        t.c(j2);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1090404690, "Lc/d/b/e0/k/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1090404690, "Lc/d/b/e0/k/e;");
                return;
            }
        }
        C = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.d.b.e0.e.F("OkHttp Http2Connection", true));
    }

    public e(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31920g = new LinkedHashMap();
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.w = new c.d.b.e0.k.k();
        this.x = new c.d.b.e0.k.k();
        this.B = new LinkedHashSet();
        this.n = hVar.f31951f;
        boolean z = hVar.f31952g;
        this.f31918e = z;
        this.f31919f = hVar.f31950e;
        int i4 = z ? 1 : 2;
        this.f31923j = i4;
        if (hVar.f31952g) {
            this.f31923j = i4 + 2;
        }
        if (hVar.f31952g) {
            this.w.i(7, 16777216);
        }
        this.f31921h = hVar.f31947b;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, c.d.b.e0.e.F(c.d.b.e0.e.q("OkHttp %s Writer", this.f31921h), false));
        this.l = scheduledThreadPoolExecutor;
        if (hVar.f31953h != 0) {
            i iVar = new i(this);
            int i5 = hVar.f31953h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, i5, i5, TimeUnit.MILLISECONDS);
        }
        this.m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), c.d.b.e0.e.F(c.d.b.e0.e.q("OkHttp %s Push Observer", this.f31921h), true));
        this.x.i(7, 65535);
        this.x.i(5, 16384);
        this.v = this.x.d();
        this.y = hVar.f31946a;
        this.z = new c.d.b.e0.k.h(hVar.f31949d, this.f31918e);
        this.A = new l(this, new c.d.b.e0.k.f(hVar.f31948c, this.f31918e));
    }

    public static /* synthetic */ long c(e eVar) {
        long j2 = eVar.p;
        eVar.p = 1 + j2;
        return j2;
    }

    public static /* synthetic */ long e(e eVar) {
        long j2 = eVar.o;
        eVar.o = 1 + j2;
        return j2;
    }

    public static /* synthetic */ long p(e eVar) {
        long j2 = eVar.r;
        eVar.r = 1 + j2;
        return j2;
    }

    public static /* synthetic */ long q(e eVar) {
        long j2 = eVar.s;
        eVar.s = 1 + j2;
        return j2;
    }

    public void A(int i2, List<c.d.b.e0.k.a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), list, Boolean.valueOf(z)}) == null) {
            try {
                z(new C1457e(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f31921h, Integer.valueOf(i2)}, i2, list, z));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void B(int i2, List<c.d.b.e0.k.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, list) == null) {
            synchronized (this) {
                if (this.B.contains(Integer.valueOf(i2))) {
                    N(i2, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                this.B.add(Integer.valueOf(i2));
                try {
                    z(new d(this, "OkHttp %s Push Request[%s]", new Object[]{this.f31921h, Integer.valueOf(i2)}, i2, list));
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public void C(int i2, ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, errorCode) == null) {
            z(new g(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f31921h, Integer.valueOf(i2)}, i2, errorCode));
        }
    }

    public boolean D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 != 0 && (i2 & 1) == 0 : invokeI.booleanValue;
    }

    public synchronized c.d.b.e0.k.g E(int i2) {
        InterceptResult invokeI;
        c.d.b.e0.k.g remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            synchronized (this) {
                remove = this.f31920g.remove(Integer.valueOf(i2));
                notifyAll();
            }
            return remove;
        }
        return (c.d.b.e0.k.g) invokeI.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.r < this.q) {
                    return;
                }
                this.q++;
                this.t = System.nanoTime() + 1000000000;
                try {
                    this.l.execute(new c(this, "OkHttp %s ping", this.f31921h));
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public void G(ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, errorCode) == null) {
            synchronized (this.z) {
                synchronized (this) {
                    if (this.k) {
                        return;
                    }
                    this.k = true;
                    this.z.k(this.f31922i, errorCode, c.d.b.e0.e.f31761a);
                }
            }
        }
    }

    public void H() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            I(true);
        }
    }

    public void I(boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.z.g();
                this.z.r(this.w);
                int d2 = this.w.d();
                if (d2 != 65535) {
                    this.z.t(0, d2 - 65535);
                }
            }
            new Thread(this.A).start();
        }
    }

    public synchronized void J(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            synchronized (this) {
                long j3 = this.u + j2;
                this.u = j3;
                if (j3 >= this.w.d() / 2) {
                    O(0, this.u);
                    this.u = 0L;
                }
            }
        }
    }

    public void K(int i2, boolean z, Buffer buffer, long j2) throws IOException {
        int min;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), buffer, Long.valueOf(j2)}) == null) {
            if (j2 == 0) {
                this.z.h(z, i2, buffer, 0);
                return;
            }
            while (j2 > 0) {
                synchronized (this) {
                    while (this.v <= 0) {
                        try {
                            if (this.f31920g.containsKey(Integer.valueOf(i2))) {
                                wait();
                            } else {
                                throw new IOException("stream closed");
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                    min = Math.min((int) Math.min(j2, this.v), this.z.n());
                    j3 = min;
                    this.v -= j3;
                }
                j2 -= j3;
                this.z.h(z && j2 == 0, i2, buffer, min);
            }
        }
    }

    public void L(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            try {
                this.z.o(z, i2, i3);
            } catch (IOException unused) {
                s();
            }
        }
    }

    public void M(int i2, ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, errorCode) == null) {
            this.z.q(i2, errorCode);
        }
    }

    public void N(int i2, ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, errorCode) == null) {
            try {
                this.l.execute(new a(this, "OkHttp %s stream %d", new Object[]{this.f31921h, Integer.valueOf(i2)}, i2, errorCode));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void O(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            try {
                this.l.execute(new b(this, "OkHttp Window Update %s stream %d", new Object[]{this.f31921h, Integer.valueOf(i2)}, i2, j2));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            r(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
        }
    }

    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.z.flush();
        }
    }

    public void r(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, errorCode, errorCode2) == null) {
            c.d.b.e0.k.g[] gVarArr = null;
            try {
                G(errorCode);
                e = null;
            } catch (IOException e2) {
                e = e2;
            }
            synchronized (this) {
                if (!this.f31920g.isEmpty()) {
                    gVarArr = (c.d.b.e0.k.g[]) this.f31920g.values().toArray(new c.d.b.e0.k.g[this.f31920g.size()]);
                    this.f31920g.clear();
                }
            }
            if (gVarArr != null) {
                for (c.d.b.e0.k.g gVar : gVarArr) {
                    try {
                        gVar.f(errorCode2);
                    } catch (IOException e3) {
                        if (e != null) {
                            e = e3;
                        }
                    }
                }
            }
            try {
                this.z.close();
            } catch (IOException e4) {
                if (e == null) {
                    e = e4;
                }
            }
            try {
                this.y.close();
            } catch (IOException e5) {
                e = e5;
            }
            this.l.shutdown();
            this.m.shutdown();
            if (e != null) {
                throw e;
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                r(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }

    public synchronized c.d.b.e0.k.g t(int i2) {
        InterceptResult invokeI;
        c.d.b.e0.k.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            synchronized (this) {
                gVar = this.f31920g.get(Integer.valueOf(i2));
            }
            return gVar;
        }
        return (c.d.b.e0.k.g) invokeI.objValue;
    }

    public synchronized boolean u(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j2)) == null) {
            synchronized (this) {
                if (this.k) {
                    return false;
                }
                if (this.r < this.q) {
                    if (j2 >= this.t) {
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeJ.booleanValue;
    }

    public synchronized int v() {
        InterceptResult invokeV;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this) {
                e2 = this.x.e(Integer.MAX_VALUE);
            }
            return e2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0047 A[Catch: all -> 0x0079, TryCatch #1 {, blocks: (B:6:0x000a, B:26:0x0053, B:30:0x0062, B:27:0x0059, B:29:0x005d, B:34:0x006b, B:35:0x0072, B:7:0x000b, B:9:0x0012, B:10:0x0017, B:12:0x001b, B:14:0x002f, B:16:0x0037, B:21:0x0041, B:23:0x0047, B:24:0x0050, B:36:0x0073, B:37:0x0078), top: B:48:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.d.b.e0.k.g w(int i2, List<c.d.b.e0.k.a> list, boolean z) throws IOException {
        InterceptResult invokeCommon;
        int i3;
        c.d.b.e0.k.g gVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), list, Boolean.valueOf(z)})) == null) {
            boolean z3 = !z;
            synchronized (this.z) {
                synchronized (this) {
                    if (this.f31923j > 1073741823) {
                        G(ErrorCode.REFUSED_STREAM);
                    }
                    if (!this.k) {
                        i3 = this.f31923j;
                        this.f31923j += 2;
                        gVar = new c.d.b.e0.k.g(i3, this, z3, false, null);
                        if (z && this.v != 0 && gVar.f31980b != 0) {
                            z2 = false;
                            if (gVar.m()) {
                                this.f31920g.put(Integer.valueOf(i3), gVar);
                            }
                        }
                        z2 = true;
                        if (gVar.m()) {
                        }
                    } else {
                        throw new ConnectionShutdownException();
                    }
                }
                if (i2 == 0) {
                    this.z.s(z3, i3, i2, list);
                } else if (!this.f31918e) {
                    this.z.p(i2, i3, list);
                } else {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
            }
            if (z2) {
                this.z.flush();
            }
            return gVar;
        }
        return (c.d.b.e0.k.g) invokeCommon.objValue;
    }

    public c.d.b.e0.k.g x(List<c.d.b.e0.k.a> list, boolean z) throws IOException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048599, this, list, z)) == null) ? w(0, list, z) : (c.d.b.e0.k.g) invokeLZ.objValue;
    }

    public void y(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), bufferedSource, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            Buffer buffer = new Buffer();
            long j2 = i3;
            bufferedSource.require(j2);
            bufferedSource.read(buffer, j2);
            if (buffer.size() == j2) {
                z(new f(this, "OkHttp %s Push Data[%s]", new Object[]{this.f31921h, Integer.valueOf(i2)}, i2, buffer, i3, z));
                return;
            }
            throw new IOException(buffer.size() + " != " + i3);
        }
    }

    public final synchronized void z(c.d.b.e0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            synchronized (this) {
                if (!this.k) {
                    this.m.execute(cVar);
                }
            }
        }
    }
}
