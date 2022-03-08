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
import com.google.android.exoplayer2.C;
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
/* loaded from: classes3.dex */
public final class e implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService C;
    public transient /* synthetic */ FieldHolder $fh;
    public final l A;
    public final Set<Integer> B;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f27946e;

    /* renamed from: f  reason: collision with root package name */
    public final j f27947f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<Integer, c.d.b.e0.k.g> f27948g;

    /* renamed from: h  reason: collision with root package name */
    public final String f27949h;

    /* renamed from: i  reason: collision with root package name */
    public int f27950i;

    /* renamed from: j  reason: collision with root package name */
    public int f27951j;
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

    /* loaded from: classes3.dex */
    public class a extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27952f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ErrorCode f27953g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f27954h;

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
            this.f27954h = eVar;
            this.f27952f = i2;
            this.f27953g = errorCode;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f27954h.I(this.f27952f, this.f27953g);
                } catch (IOException unused) {
                    this.f27954h.o();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27955f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f27956g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f27957h;

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
            this.f27957h = eVar;
            this.f27955f = i2;
            this.f27956g = j2;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f27957h.z.p(this.f27955f, this.f27956g);
                } catch (IOException unused) {
                    this.f27957h.o();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f27958f;

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
            this.f27958f = eVar;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27958f.H(false, 2, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27959f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f27960g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f27961h;

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
            this.f27961h = eVar;
            this.f27959f = i2;
            this.f27960g = list;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f27961h.n.onRequest(this.f27959f, this.f27960g)) {
                try {
                    this.f27961h.z.m(this.f27959f, ErrorCode.CANCEL);
                    synchronized (this.f27961h) {
                        this.f27961h.B.remove(Integer.valueOf(this.f27959f));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: c.d.b.e0.k.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1649e extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27962f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f27963g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f27964h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f27965i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1649e(e eVar, String str, Object[] objArr, int i2, List list, boolean z) {
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
            this.f27965i = eVar;
            this.f27962f = i2;
            this.f27963g = list;
            this.f27964h = z;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean onHeaders = this.f27965i.n.onHeaders(this.f27962f, this.f27963g, this.f27964h);
                if (onHeaders) {
                    try {
                        this.f27965i.z.m(this.f27962f, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (onHeaders || this.f27964h) {
                    synchronized (this.f27965i) {
                        this.f27965i.B.remove(Integer.valueOf(this.f27962f));
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27966f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Buffer f27967g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f27968h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f27969i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f27970j;

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
            this.f27970j = eVar;
            this.f27966f = i2;
            this.f27967g = buffer;
            this.f27968h = i3;
            this.f27969i = z;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    boolean onData = this.f27970j.n.onData(this.f27966f, this.f27967g, this.f27968h, this.f27969i);
                    if (onData) {
                        this.f27970j.z.m(this.f27966f, ErrorCode.CANCEL);
                    }
                    if (onData || this.f27969i) {
                        synchronized (this.f27970j) {
                            this.f27970j.B.remove(Integer.valueOf(this.f27966f));
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27971f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ErrorCode f27972g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f27973h;

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
            this.f27973h = eVar;
            this.f27971f = i2;
            this.f27972g = errorCode;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27973h.n.a(this.f27971f, this.f27972g);
                synchronized (this.f27973h) {
                    this.f27973h.B.remove(Integer.valueOf(this.f27971f));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Socket a;

        /* renamed from: b  reason: collision with root package name */
        public String f27974b;

        /* renamed from: c  reason: collision with root package name */
        public BufferedSource f27975c;

        /* renamed from: d  reason: collision with root package name */
        public BufferedSink f27976d;

        /* renamed from: e  reason: collision with root package name */
        public j f27977e;

        /* renamed from: f  reason: collision with root package name */
        public c.d.b.e0.k.j f27978f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f27979g;

        /* renamed from: h  reason: collision with root package name */
        public int f27980h;

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
            this.f27977e = j.a;
            this.f27978f = c.d.b.e0.k.j.a;
            this.f27979g = z;
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
                this.f27977e = jVar;
                return this;
            }
            return (h) invokeL.objValue;
        }

        public h c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f27980h = i2;
                return this;
            }
            return (h) invokeI.objValue;
        }

        public h d(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, socket, str, bufferedSource, bufferedSink)) == null) {
                this.a = socket;
                this.f27974b = str;
                this.f27975c = bufferedSource;
                this.f27976d = bufferedSink;
                return this;
            }
            return (h) invokeLLLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class i extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f27981f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(e eVar) {
            super("OkHttp %s ping", eVar.f27949h);
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
            this.f27981f = eVar;
        }

        @Override // c.d.b.e0.c
        public void d() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f27981f) {
                    if (this.f27981f.p < this.f27981f.o) {
                        z = true;
                    } else {
                        e.e(this.f27981f);
                        z = false;
                    }
                }
                if (z) {
                    this.f27981f.o();
                } else {
                    this.f27981f.H(false, 1, 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class j {
        public static /* synthetic */ Interceptable $ic;
        public static final j a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public final class k extends c.d.b.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f27982f;

        /* renamed from: g  reason: collision with root package name */
        public final int f27983g;

        /* renamed from: h  reason: collision with root package name */
        public final int f27984h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f27985i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(e eVar, boolean z, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", eVar.f27949h, Integer.valueOf(i2), Integer.valueOf(i3));
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
            this.f27985i = eVar;
            this.f27982f = z;
            this.f27983g = i2;
            this.f27984h = i3;
        }

        @Override // c.d.b.e0.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27985i.H(this.f27982f, this.f27983g, this.f27984h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends c.d.b.e0.c implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final c.d.b.e0.k.f f27986f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f27987g;

        /* loaded from: classes3.dex */
        public class a extends c.d.b.e0.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.d.b.e0.k.g f27988f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ l f27989g;

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
                this.f27989g = lVar;
                this.f27988f = gVar;
            }

            @Override // c.d.b.e0.c
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f27989g.f27987g.f27947f.b(this.f27988f);
                    } catch (IOException e2) {
                        c.d.b.e0.n.g m = c.d.b.e0.n.g.m();
                        m.u(4, "Http2Connection.Listener failure for " + this.f27989g.f27987g.f27949h, e2);
                        try {
                            this.f27988f.f(ErrorCode.PROTOCOL_ERROR);
                        } catch (IOException unused) {
                        }
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b extends c.d.b.e0.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f27990f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c.d.b.e0.k.k f27991g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ l f27992h;

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
                this.f27992h = lVar;
                this.f27990f = z;
                this.f27991g = kVar;
            }

            @Override // c.d.b.e0.c
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f27992h.e(this.f27990f, this.f27991g);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c extends c.d.b.e0.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f27993f;

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
                this.f27993f = lVar;
            }

            @Override // c.d.b.e0.c
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f27993f.f27987g;
                    eVar.f27947f.a(eVar);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(e eVar, c.d.b.e0.k.f fVar) {
            super("OkHttp %s", eVar.f27949h);
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
            this.f27987g = eVar;
            this.f27986f = fVar;
        }

        @Override // c.d.b.e0.k.f.b
        public void a(int i2, ErrorCode errorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, errorCode) == null) {
                if (this.f27987g.z(i2)) {
                    this.f27987g.y(i2, errorCode);
                    return;
                }
                c.d.b.e0.k.g A = this.f27987g.A(i2);
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
                synchronized (this.f27987g) {
                    gVarArr = (c.d.b.e0.k.g[]) this.f27987g.f27948g.values().toArray(new c.d.b.e0.k.g[this.f27987g.f27948g.size()]);
                    this.f27987g.k = true;
                }
                for (c.d.b.e0.k.g gVar : gVarArr) {
                    if (gVar.i() > i2 && gVar.l()) {
                        gVar.r(ErrorCode.REFUSED_STREAM);
                        this.f27987g.A(gVar.i());
                    }
                }
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void c(boolean z, c.d.b.e0.k.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048579, this, z, kVar) == null) {
                try {
                    this.f27987g.l.execute(new b(this, "OkHttp %s ACK Settings", new Object[]{this.f27987g.f27949h}, z, kVar));
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
                        this.f27986f.c(this);
                        while (this.f27986f.b(false, this)) {
                        }
                        errorCode = ErrorCode.NO_ERROR;
                        try {
                            try {
                                errorCode2 = ErrorCode.CANCEL;
                                eVar = this.f27987g;
                            } catch (IOException unused) {
                                errorCode = ErrorCode.PROTOCOL_ERROR;
                                errorCode2 = ErrorCode.PROTOCOL_ERROR;
                                eVar = this.f27987g;
                                eVar.n(errorCode, errorCode2);
                                c.d.b.e0.e.f(this.f27986f);
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                this.f27987g.n(errorCode, errorCode3);
                            } catch (IOException unused2) {
                            }
                            c.d.b.e0.e.f(this.f27986f);
                            throw th;
                        }
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                } catch (Throwable th2) {
                    th = th2;
                    errorCode = errorCode3;
                    this.f27987g.n(errorCode, errorCode3);
                    c.d.b.e0.e.f(this.f27986f);
                    throw th;
                }
                eVar.n(errorCode, errorCode2);
                c.d.b.e0.e.f(this.f27986f);
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void data(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), bufferedSource, Integer.valueOf(i3)}) == null) {
                if (this.f27987g.z(i2)) {
                    this.f27987g.u(i2, bufferedSource, i3, z);
                    return;
                }
                c.d.b.e0.k.g p = this.f27987g.p(i2);
                if (p == null) {
                    this.f27987g.J(i2, ErrorCode.PROTOCOL_ERROR);
                    long j2 = i3;
                    this.f27987g.F(j2);
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
                synchronized (this.f27987g.z) {
                    synchronized (this.f27987g) {
                        int d2 = this.f27987g.x.d();
                        if (z) {
                            this.f27987g.x.a();
                        }
                        this.f27987g.x.h(kVar);
                        int d3 = this.f27987g.x.d();
                        gVarArr = null;
                        if (d3 == -1 || d3 == d2) {
                            j2 = 0;
                        } else {
                            j2 = d3 - d2;
                            if (!this.f27987g.f27948g.isEmpty()) {
                                gVarArr = (c.d.b.e0.k.g[]) this.f27987g.f27948g.values().toArray(new c.d.b.e0.k.g[this.f27987g.f27948g.size()]);
                            }
                        }
                    }
                    try {
                        this.f27987g.z.a(this.f27987g.x);
                    } catch (IOException unused) {
                        this.f27987g.o();
                    }
                }
                if (gVarArr != null) {
                    for (c.d.b.e0.k.g gVar : gVarArr) {
                        synchronized (gVar) {
                            gVar.c(j2);
                        }
                    }
                }
                e.C.execute(new c(this, "OkHttp %s settings", this.f27987g.f27949h));
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void headers(boolean z, int i2, int i3, List<c.d.b.e0.k.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), list}) == null) {
                if (this.f27987g.z(i2)) {
                    this.f27987g.w(i2, list, z);
                    return;
                }
                synchronized (this.f27987g) {
                    c.d.b.e0.k.g p = this.f27987g.p(i2);
                    if (p == null) {
                        if (this.f27987g.k) {
                            return;
                        }
                        if (i2 <= this.f27987g.f27950i) {
                            return;
                        }
                        if (i2 % 2 == this.f27987g.f27951j % 2) {
                            return;
                        }
                        c.d.b.e0.k.g gVar = new c.d.b.e0.k.g(i2, this.f27987g, false, z, c.d.b.e0.e.G(list));
                        this.f27987g.f27950i = i2;
                        this.f27987g.f27948g.put(Integer.valueOf(i2), gVar);
                        e.C.execute(new a(this, "OkHttp %s stream %d", new Object[]{this.f27987g.f27949h, Integer.valueOf(i2)}, gVar));
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
                    synchronized (this.f27987g) {
                        try {
                            if (i2 == 1) {
                                e.c(this.f27987g);
                            } else if (i2 == 2) {
                                e.l(this.f27987g);
                            } else if (i2 == 3) {
                                e.m(this.f27987g);
                                this.f27987g.notifyAll();
                            }
                        } finally {
                        }
                    }
                    return;
                }
                try {
                    this.f27987g.l.execute(new k(this.f27987g, true, i2, i3));
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
                this.f27987g.x(i3, list);
            }
        }

        @Override // c.d.b.e0.k.f.b
        public void windowUpdate(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (i2 == 0) {
                    synchronized (this.f27987g) {
                        this.f27987g.v += j2;
                        this.f27987g.notifyAll();
                    }
                    return;
                }
                c.d.b.e0.k.g p = this.f27987g.p(i2);
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
        this.f27948g = new LinkedHashMap();
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
        this.n = hVar.f27978f;
        boolean z = hVar.f27979g;
        this.f27946e = z;
        this.f27947f = hVar.f27977e;
        int i4 = z ? 1 : 2;
        this.f27951j = i4;
        if (hVar.f27979g) {
            this.f27951j = i4 + 2;
        }
        if (hVar.f27979g) {
            this.w.i(7, 16777216);
        }
        this.f27949h = hVar.f27974b;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, c.d.b.e0.e.F(c.d.b.e0.e.q("OkHttp %s Writer", this.f27949h), false));
        this.l = scheduledThreadPoolExecutor;
        if (hVar.f27980h != 0) {
            i iVar = new i(this);
            int i5 = hVar.f27980h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, i5, i5, TimeUnit.MILLISECONDS);
        }
        this.m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), c.d.b.e0.e.F(c.d.b.e0.e.q("OkHttp %s Push Observer", this.f27949h), true));
        this.x.i(7, 65535);
        this.x.i(5, 16384);
        this.v = this.x.d();
        this.y = hVar.a;
        this.z = new c.d.b.e0.k.h(hVar.f27976d, this.f27946e);
        this.A = new l(this, new c.d.b.e0.k.f(hVar.f27975c, this.f27946e));
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
                remove = this.f27948g.remove(Integer.valueOf(i2));
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
                this.t = System.nanoTime() + C.NANOS_PER_SECOND;
                try {
                    this.l.execute(new c(this, "OkHttp %s ping", this.f27949h));
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
                    if (this.k) {
                        return;
                    }
                    this.k = true;
                    this.z.g(this.f27950i, errorCode, c.d.b.e0.e.a);
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
                            if (this.f27948g.containsKey(Integer.valueOf(i2))) {
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
                this.l.execute(new a(this, "OkHttp %s stream %d", new Object[]{this.f27949h, Integer.valueOf(i2)}, i2, errorCode));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void K(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            try {
                this.l.execute(new b(this, "OkHttp Window Update %s stream %d", new Object[]{this.f27949h, Integer.valueOf(i2)}, i2, j2));
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
                if (!this.f27948g.isEmpty()) {
                    gVarArr = (c.d.b.e0.k.g[]) this.f27948g.values().toArray(new c.d.b.e0.k.g[this.f27948g.size()]);
                    this.f27948g.clear();
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
                gVar = this.f27948g.get(Integer.valueOf(i2));
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
                    if (this.f27951j > 1073741823) {
                        C(ErrorCode.REFUSED_STREAM);
                    }
                    if (!this.k) {
                        i3 = this.f27951j;
                        this.f27951j += 2;
                        gVar = new c.d.b.e0.k.g(i3, this, z3, false, null);
                        if (z && this.v != 0 && gVar.f28005b != 0) {
                            z2 = false;
                            if (gVar.m()) {
                                this.f27948g.put(Integer.valueOf(i3), gVar);
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
                } else if (!this.f27946e) {
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
                v(new f(this, "OkHttp %s Push Data[%s]", new Object[]{this.f27949h, Integer.valueOf(i2)}, i2, buffer, i3, z));
                return;
            }
            throw new IOException(buffer.size() + " != " + i3);
        }
    }

    public final synchronized void v(c.d.b.e0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            synchronized (this) {
                if (!this.k) {
                    this.m.execute(cVar);
                }
            }
        }
    }

    public void w(int i2, List<c.d.b.e0.k.a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), list, Boolean.valueOf(z)}) == null) {
            try {
                v(new C1649e(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f27949h, Integer.valueOf(i2)}, i2, list, z));
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
                    v(new d(this, "OkHttp %s Push Request[%s]", new Object[]{this.f27949h, Integer.valueOf(i2)}, i2, list));
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public void y(int i2, ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i2, errorCode) == null) {
            v(new g(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f27949h, Integer.valueOf(i2)}, i2, errorCode));
        }
    }

    public boolean z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? i2 != 0 && (i2 & 1) == 0 : invokeI.booleanValue;
    }
}
