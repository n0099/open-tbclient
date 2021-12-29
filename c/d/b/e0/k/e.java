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
/* loaded from: classes9.dex */
public final class e implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService C;
    public transient /* synthetic */ FieldHolder $fh;
    public final l A;
    public final Set<Integer> B;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f28688e;

    /* renamed from: f  reason: collision with root package name */
    public final j f28689f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<Integer, c.d.b.e0.k.g> f28690g;

    /* renamed from: h  reason: collision with root package name */
    public final String f28691h;

    /* renamed from: i  reason: collision with root package name */
    public int f28692i;

    /* renamed from: j  reason: collision with root package name */
    public int f28693j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f28694k;
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

    /* loaded from: classes9.dex */
    public class a extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f28695f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ErrorCode f28696g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f28697h;

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
            this.f28697h = eVar;
            this.f28695f = i2;
            this.f28696g = errorCode;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f28697h.I(this.f28695f, this.f28696g);
                } catch (IOException unused) {
                    this.f28697h.o();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f28698f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f28699g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f28700h;

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
            this.f28700h = eVar;
            this.f28698f = i2;
            this.f28699g = j2;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f28700h.z.p(this.f28698f, this.f28699g);
                } catch (IOException unused) {
                    this.f28700h.o();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f28701f;

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
            this.f28701f = eVar;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28701f.H(false, 2, 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f28702f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f28703g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f28704h;

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
            this.f28704h = eVar;
            this.f28702f = i2;
            this.f28703g = list;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f28704h.n.onRequest(this.f28702f, this.f28703g)) {
                try {
                    this.f28704h.z.m(this.f28702f, ErrorCode.CANCEL);
                    synchronized (this.f28704h) {
                        this.f28704h.B.remove(Integer.valueOf(this.f28702f));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: c.d.b.e0.k.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1611e extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f28705f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f28706g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f28707h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f28708i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1611e(e eVar, String str, Object[] objArr, int i2, List list, boolean z) {
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
            this.f28708i = eVar;
            this.f28705f = i2;
            this.f28706g = list;
            this.f28707h = z;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean onHeaders = this.f28708i.n.onHeaders(this.f28705f, this.f28706g, this.f28707h);
                if (onHeaders) {
                    try {
                        this.f28708i.z.m(this.f28705f, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (onHeaders || this.f28707h) {
                    synchronized (this.f28708i) {
                        this.f28708i.B.remove(Integer.valueOf(this.f28705f));
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f28709f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Buffer f28710g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f28711h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f28712i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f28713j;

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
            this.f28713j = eVar;
            this.f28709f = i2;
            this.f28710g = buffer;
            this.f28711h = i3;
            this.f28712i = z;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    boolean onData = this.f28713j.n.onData(this.f28709f, this.f28710g, this.f28711h, this.f28712i);
                    if (onData) {
                        this.f28713j.z.m(this.f28709f, ErrorCode.CANCEL);
                    }
                    if (onData || this.f28712i) {
                        synchronized (this.f28713j) {
                            this.f28713j.B.remove(Integer.valueOf(this.f28709f));
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f28714f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ErrorCode f28715g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f28716h;

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
            this.f28716h = eVar;
            this.f28714f = i2;
            this.f28715g = errorCode;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28716h.n.a(this.f28714f, this.f28715g);
                synchronized (this.f28716h) {
                    this.f28716h.B.remove(Integer.valueOf(this.f28714f));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Socket a;

        /* renamed from: b  reason: collision with root package name */
        public String f28717b;

        /* renamed from: c  reason: collision with root package name */
        public BufferedSource f28718c;

        /* renamed from: d  reason: collision with root package name */
        public BufferedSink f28719d;

        /* renamed from: e  reason: collision with root package name */
        public j f28720e;

        /* renamed from: f  reason: collision with root package name */
        public c.d.b.e0.k.j f28721f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f28722g;

        /* renamed from: h  reason: collision with root package name */
        public int f28723h;

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
            this.f28720e = j.a;
            this.f28721f = c.d.b.e0.k.j.a;
            this.f28722g = z;
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
                this.f28720e = jVar;
                return this;
            }
            return (h) invokeL.objValue;
        }

        public h c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f28723h = i2;
                return this;
            }
            return (h) invokeI.objValue;
        }

        public h d(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, socket, str, bufferedSource, bufferedSink)) == null) {
                this.a = socket;
                this.f28717b = str;
                this.f28718c = bufferedSource;
                this.f28719d = bufferedSink;
                return this;
            }
            return (h) invokeLLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class i extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f28724f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(e eVar) {
            super("OkHttp %s ping", eVar.f28691h);
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
            this.f28724f = eVar;
        }

        @Override // c.d.b.e0.c
        public void d() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f28724f) {
                    if (this.f28724f.p < this.f28724f.o) {
                        z = true;
                    } else {
                        e.e(this.f28724f);
                        z = false;
                    }
                }
                if (z) {
                    this.f28724f.o();
                } else {
                    this.f28724f.H(false, 1, 0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class j {
        public static /* synthetic */ Interceptable $ic;
        public static final j a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
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
            a = new a();
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

    /* loaded from: classes9.dex */
    public final class k extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f28725f;

        /* renamed from: g  reason: collision with root package name */
        public final int f28726g;

        /* renamed from: h  reason: collision with root package name */
        public final int f28727h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f28728i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(e eVar, boolean z, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", eVar.f28691h, Integer.valueOf(i2), Integer.valueOf(i3));
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
            this.f28728i = eVar;
            this.f28725f = z;
            this.f28726g = i2;
            this.f28727h = i3;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28728i.H(this.f28725f, this.f28726g, this.f28727h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends c.d.b.e0.c implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final c.d.b.e0.k.f f28729f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f28730g;

        /* loaded from: classes9.dex */
        public class a extends c.d.b.e0.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.d.b.e0.k.g f28731f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ l f28732g;

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
                this.f28732g = lVar;
                this.f28731f = gVar;
            }

            @Override // c.d.b.e0.c
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f28732g.f28730g.f28689f.b(this.f28731f);
                    } catch (IOException e2) {
                        c.d.b.e0.n.g m = c.d.b.e0.n.g.m();
                        m.u(4, "Http2Connection.Listener failure for " + this.f28732g.f28730g.f28691h, e2);
                        try {
                            this.f28731f.f(ErrorCode.PROTOCOL_ERROR);
                        } catch (IOException unused) {
                        }
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b extends c.d.b.e0.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f28733f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c.d.b.e0.k.k f28734g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ l f28735h;

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
                this.f28735h = lVar;
                this.f28733f = z;
                this.f28734g = kVar;
            }

            @Override // c.d.b.e0.c
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f28735h.e(this.f28733f, this.f28734g);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class c extends c.d.b.e0.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f28736f;

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
                this.f28736f = lVar;
            }

            @Override // c.d.b.e0.c
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f28736f.f28730g;
                    eVar.f28689f.a(eVar);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(e eVar, c.d.b.e0.k.f fVar) {
            super("OkHttp %s", eVar.f28691h);
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
            this.f28730g = eVar;
            this.f28729f = fVar;
        }

        @Override // c.d.b.e0.k.f.b
        public void a(int i2, ErrorCode errorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, errorCode) == null) {
                if (this.f28730g.z(i2)) {
                    this.f28730g.y(i2, errorCode);
                    return;
                }
                c.d.b.e0.k.g A = this.f28730g.A(i2);
                if (A != null) {
                    A.r(errorCode);
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
                synchronized (this.f28730g) {
                    gVarArr = (c.d.b.e0.k.g[]) this.f28730g.f28690g.values().toArray(new c.d.b.e0.k.g[this.f28730g.f28690g.size()]);
                    this.f28730g.f28694k = true;
                }
                for (c.d.b.e0.k.g gVar : gVarArr) {
                    if (gVar.i() > i2 && gVar.l()) {
                        gVar.r(ErrorCode.REFUSED_STREAM);
                        this.f28730g.A(gVar.i());
                    }
                }
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void c(boolean z, c.d.b.e0.k.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048579, this, z, kVar) == null) {
                try {
                    this.f28730g.l.execute(new b(this, "OkHttp %s ACK Settings", new Object[]{this.f28730g.f28691h}, z, kVar));
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
                        this.f28729f.c(this);
                        while (this.f28729f.b(false, this)) {
                        }
                        errorCode = ErrorCode.NO_ERROR;
                        try {
                            try {
                                errorCode2 = ErrorCode.CANCEL;
                                eVar = this.f28730g;
                            } catch (IOException unused) {
                                errorCode = ErrorCode.PROTOCOL_ERROR;
                                errorCode2 = ErrorCode.PROTOCOL_ERROR;
                                eVar = this.f28730g;
                                eVar.n(errorCode, errorCode2);
                                c.d.b.e0.e.f(this.f28729f);
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                this.f28730g.n(errorCode, errorCode3);
                            } catch (IOException unused2) {
                            }
                            c.d.b.e0.e.f(this.f28729f);
                            throw th;
                        }
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                } catch (Throwable th2) {
                    th = th2;
                    errorCode = errorCode3;
                    this.f28730g.n(errorCode, errorCode3);
                    c.d.b.e0.e.f(this.f28729f);
                    throw th;
                }
                eVar.n(errorCode, errorCode2);
                c.d.b.e0.e.f(this.f28729f);
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void data(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), bufferedSource, Integer.valueOf(i3)}) == null) {
                if (this.f28730g.z(i2)) {
                    this.f28730g.u(i2, bufferedSource, i3, z);
                    return;
                }
                c.d.b.e0.k.g p = this.f28730g.p(i2);
                if (p == null) {
                    this.f28730g.J(i2, ErrorCode.PROTOCOL_ERROR);
                    long j2 = i3;
                    this.f28730g.F(j2);
                    bufferedSource.skip(j2);
                    return;
                }
                p.o(bufferedSource, i3);
                if (z) {
                    p.p();
                }
            }
        }

        public void e(boolean z, c.d.b.e0.k.k kVar) {
            c.d.b.e0.k.g[] gVarArr;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048582, this, z, kVar) == null) {
                synchronized (this.f28730g.z) {
                    synchronized (this.f28730g) {
                        int d2 = this.f28730g.x.d();
                        if (z) {
                            this.f28730g.x.a();
                        }
                        this.f28730g.x.h(kVar);
                        int d3 = this.f28730g.x.d();
                        gVarArr = null;
                        if (d3 == -1 || d3 == d2) {
                            j2 = 0;
                        } else {
                            j2 = d3 - d2;
                            if (!this.f28730g.f28690g.isEmpty()) {
                                gVarArr = (c.d.b.e0.k.g[]) this.f28730g.f28690g.values().toArray(new c.d.b.e0.k.g[this.f28730g.f28690g.size()]);
                            }
                        }
                    }
                    try {
                        this.f28730g.z.a(this.f28730g.x);
                    } catch (IOException unused) {
                        this.f28730g.o();
                    }
                }
                if (gVarArr != null) {
                    for (c.d.b.e0.k.g gVar : gVarArr) {
                        synchronized (gVar) {
                            gVar.c(j2);
                        }
                    }
                }
                e.C.execute(new c(this, "OkHttp %s settings", this.f28730g.f28691h));
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void headers(boolean z, int i2, int i3, List<c.d.b.e0.k.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), list}) == null) {
                if (this.f28730g.z(i2)) {
                    this.f28730g.w(i2, list, z);
                    return;
                }
                synchronized (this.f28730g) {
                    c.d.b.e0.k.g p = this.f28730g.p(i2);
                    if (p == null) {
                        if (this.f28730g.f28694k) {
                            return;
                        }
                        if (i2 <= this.f28730g.f28692i) {
                            return;
                        }
                        if (i2 % 2 == this.f28730g.f28693j % 2) {
                            return;
                        }
                        c.d.b.e0.k.g gVar = new c.d.b.e0.k.g(i2, this.f28730g, false, z, c.d.b.e0.e.G(list));
                        this.f28730g.f28692i = i2;
                        this.f28730g.f28690g.put(Integer.valueOf(i2), gVar);
                        e.C.execute(new a(this, "OkHttp %s stream %d", new Object[]{this.f28730g.f28691h, Integer.valueOf(i2)}, gVar));
                        return;
                    }
                    p.q(list);
                    if (z) {
                        p.p();
                    }
                }
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void ping(boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                if (z) {
                    synchronized (this.f28730g) {
                        try {
                            if (i2 == 1) {
                                e.c(this.f28730g);
                            } else if (i2 == 2) {
                                e.l(this.f28730g);
                            } else if (i2 == 3) {
                                e.m(this.f28730g);
                                this.f28730g.notifyAll();
                            }
                        } finally {
                        }
                    }
                    return;
                }
                try {
                    this.f28730g.l.execute(new k(this.f28730g, true, i2, i3));
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
                this.f28730g.x(i3, list);
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void windowUpdate(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (i2 == 0) {
                    synchronized (this.f28730g) {
                        this.f28730g.v += j2;
                        this.f28730g.notifyAll();
                    }
                    return;
                }
                c.d.b.e0.k.g p = this.f28730g.p(i2);
                if (p != null) {
                    synchronized (p) {
                        p.c(j2);
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
        this.f28690g = new LinkedHashMap();
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
        this.n = hVar.f28721f;
        boolean z = hVar.f28722g;
        this.f28688e = z;
        this.f28689f = hVar.f28720e;
        int i4 = z ? 1 : 2;
        this.f28693j = i4;
        if (hVar.f28722g) {
            this.f28693j = i4 + 2;
        }
        if (hVar.f28722g) {
            this.w.i(7, 16777216);
        }
        this.f28691h = hVar.f28717b;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, c.d.b.e0.e.F(c.d.b.e0.e.q("OkHttp %s Writer", this.f28691h), false));
        this.l = scheduledThreadPoolExecutor;
        if (hVar.f28723h != 0) {
            i iVar = new i(this);
            int i5 = hVar.f28723h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, i5, i5, TimeUnit.MILLISECONDS);
        }
        this.m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), c.d.b.e0.e.F(c.d.b.e0.e.q("OkHttp %s Push Observer", this.f28691h), true));
        this.x.i(7, 65535);
        this.x.i(5, 16384);
        this.v = this.x.d();
        this.y = hVar.a;
        this.z = new c.d.b.e0.k.h(hVar.f28719d, this.f28688e);
        this.A = new l(this, new c.d.b.e0.k.f(hVar.f28718c, this.f28688e));
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

    public static /* synthetic */ long l(e eVar) {
        long j2 = eVar.r;
        eVar.r = 1 + j2;
        return j2;
    }

    public static /* synthetic */ long m(e eVar) {
        long j2 = eVar.s;
        eVar.s = 1 + j2;
        return j2;
    }

    public synchronized c.d.b.e0.k.g A(int i2) {
        InterceptResult invokeI;
        c.d.b.e0.k.g remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this) {
                remove = this.f28690g.remove(Integer.valueOf(i2));
                notifyAll();
            }
            return remove;
        }
        return (c.d.b.e0.k.g) invokeI.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.r < this.q) {
                    return;
                }
                this.q++;
                this.t = System.nanoTime() + 1000000000;
                try {
                    this.l.execute(new c(this, "OkHttp %s ping", this.f28691h));
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public void C(ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, errorCode) == null) {
            synchronized (this.z) {
                synchronized (this) {
                    if (this.f28694k) {
                        return;
                    }
                    this.f28694k = true;
                    this.z.g(this.f28692i, errorCode, c.d.b.e0.e.a);
                }
            }
        }
    }

    public void D() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            E(true);
        }
    }

    public void E(boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.z.c();
                this.z.n(this.w);
                int d2 = this.w.d();
                if (d2 != 65535) {
                    this.z.p(0, d2 - 65535);
                }
            }
            new Thread(this.A).start();
        }
    }

    public synchronized void F(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            synchronized (this) {
                long j3 = this.u + j2;
                this.u = j3;
                if (j3 >= this.w.d() / 2) {
                    K(0, this.u);
                    this.u = 0L;
                }
            }
        }
    }

    public void G(int i2, boolean z, Buffer buffer, long j2) throws IOException {
        int min;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), buffer, Long.valueOf(j2)}) == null) {
            if (j2 == 0) {
                this.z.d(z, i2, buffer, 0);
                return;
            }
            while (j2 > 0) {
                synchronized (this) {
                    while (this.v <= 0) {
                        try {
                            if (this.f28690g.containsKey(Integer.valueOf(i2))) {
                                wait();
                            } else {
                                throw new IOException("stream closed");
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                    min = Math.min((int) Math.min(j2, this.v), this.z.j());
                    j3 = min;
                    this.v -= j3;
                }
                j2 -= j3;
                this.z.d(z && j2 == 0, i2, buffer, min);
            }
        }
    }

    public void H(boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            try {
                this.z.k(z, i2, i3);
            } catch (IOException unused) {
                o();
            }
        }
    }

    public void I(int i2, ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, errorCode) == null) {
            this.z.m(i2, errorCode);
        }
    }

    public void J(int i2, ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, errorCode) == null) {
            try {
                this.l.execute(new a(this, "OkHttp %s stream %d", new Object[]{this.f28691h, Integer.valueOf(i2)}, i2, errorCode));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void K(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            try {
                this.l.execute(new b(this, "OkHttp Window Update %s stream %d", new Object[]{this.f28691h, Integer.valueOf(i2)}, i2, j2));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            n(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
        }
    }

    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.z.flush();
        }
    }

    public void n(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, errorCode, errorCode2) == null) {
            c.d.b.e0.k.g[] gVarArr = null;
            try {
                C(errorCode);
                e = null;
            } catch (IOException e2) {
                e = e2;
            }
            synchronized (this) {
                if (!this.f28690g.isEmpty()) {
                    gVarArr = (c.d.b.e0.k.g[]) this.f28690g.values().toArray(new c.d.b.e0.k.g[this.f28690g.size()]);
                    this.f28690g.clear();
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

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                n(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }

    public synchronized c.d.b.e0.k.g p(int i2) {
        InterceptResult invokeI;
        c.d.b.e0.k.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            synchronized (this) {
                gVar = this.f28690g.get(Integer.valueOf(i2));
            }
            return gVar;
        }
        return (c.d.b.e0.k.g) invokeI.objValue;
    }

    public synchronized boolean q(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
            synchronized (this) {
                if (this.f28694k) {
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

    public synchronized int r() {
        InterceptResult invokeV;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
    public final c.d.b.e0.k.g s(int i2, List<c.d.b.e0.k.a> list, boolean z) throws IOException {
        InterceptResult invokeCommon;
        int i3;
        c.d.b.e0.k.g gVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), list, Boolean.valueOf(z)})) == null) {
            boolean z3 = !z;
            synchronized (this.z) {
                synchronized (this) {
                    if (this.f28693j > 1073741823) {
                        C(ErrorCode.REFUSED_STREAM);
                    }
                    if (!this.f28694k) {
                        i3 = this.f28693j;
                        this.f28693j += 2;
                        gVar = new c.d.b.e0.k.g(i3, this, z3, false, null);
                        if (z && this.v != 0 && gVar.f28748b != 0) {
                            z2 = false;
                            if (gVar.m()) {
                                this.f28690g.put(Integer.valueOf(i3), gVar);
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
                    this.z.o(z3, i3, i2, list);
                } else if (!this.f28688e) {
                    this.z.l(i2, i3, list);
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

    public c.d.b.e0.k.g t(List<c.d.b.e0.k.a> list, boolean z) throws IOException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048595, this, list, z)) == null) ? s(0, list, z) : (c.d.b.e0.k.g) invokeLZ.objValue;
    }

    public void u(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), bufferedSource, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            Buffer buffer = new Buffer();
            long j2 = i3;
            bufferedSource.require(j2);
            bufferedSource.read(buffer, j2);
            if (buffer.size() == j2) {
                v(new f(this, "OkHttp %s Push Data[%s]", new Object[]{this.f28691h, Integer.valueOf(i2)}, i2, buffer, i3, z));
                return;
            }
            throw new IOException(buffer.size() + " != " + i3);
        }
    }

    public final synchronized void v(c.d.b.e0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            synchronized (this) {
                if (!this.f28694k) {
                    this.m.execute(cVar);
                }
            }
        }
    }

    public void w(int i2, List<c.d.b.e0.k.a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), list, Boolean.valueOf(z)}) == null) {
            try {
                v(new C1611e(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f28691h, Integer.valueOf(i2)}, i2, list, z));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void x(int i2, List<c.d.b.e0.k.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i2, list) == null) {
            synchronized (this) {
                if (this.B.contains(Integer.valueOf(i2))) {
                    J(i2, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                this.B.add(Integer.valueOf(i2));
                try {
                    v(new d(this, "OkHttp %s Push Request[%s]", new Object[]{this.f28691h, Integer.valueOf(i2)}, i2, list));
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public void y(int i2, ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i2, errorCode) == null) {
            v(new g(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f28691h, Integer.valueOf(i2)}, i2, errorCode));
        }
    }

    public boolean z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? i2 != 0 && (i2 & 1) == 0 : invokeI.booleanValue;
    }
}
