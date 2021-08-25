package c.a.o0.a.e0.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.Choreographer;
import c.a.o0.a.k;
import c.a.o0.a.q2.e;
import c.a.o0.a.v2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f5291i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f5292j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f5293a;

    /* renamed from: b  reason: collision with root package name */
    public f f5294b;

    /* renamed from: c  reason: collision with root package name */
    public c f5295c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0154b f5296d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f5297e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5298f;

    /* renamed from: g  reason: collision with root package name */
    public int f5299g;

    /* renamed from: h  reason: collision with root package name */
    public int f5300h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.o0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0154b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5301e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5302f;

        public RunnableC0154b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5302f = bVar;
        }

        public synchronized String b() {
            InterceptResult invokeV;
            BufferedReader bufferedReader;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    boolean unused = b.f5291i;
                    BufferedReader bufferedReader2 = null;
                    try {
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{IAdRequestParam.SCREEN_HEIGHT, "-c", "top -n 1 | grep " + Process.myPid()}).getInputStream()));
                        } catch (Throwable th2) {
                            bufferedReader = null;
                            th = th2;
                        }
                    } catch (IOException unused2) {
                    }
                    try {
                        String c2 = c(bufferedReader);
                        if (b.f5291i) {
                            String str = "stop cpu monitor thread , cpu rate is : " + c2;
                        }
                        c.a.o0.t.d.d(bufferedReader);
                        return c2;
                    } catch (IOException unused3) {
                        bufferedReader2 = bufferedReader;
                        boolean unused4 = b.f5291i;
                        c.a.o0.t.d.d(bufferedReader2);
                        return "";
                    } catch (Throwable th3) {
                        th = th3;
                        c.a.o0.t.d.d(bufferedReader);
                        throw th;
                    }
                }
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:6|(1:9)|10|(6:12|(1:15)|16|17|18|19)|(1:27)(1:32)|(1:31)|16|17|18|19) */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
            if (c.a.o0.a.e0.g.b.f5291i != false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
            r0 = "get CPU Fail : " + r12.getMessage();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String c(BufferedReader bufferedReader) throws IOException {
            InterceptResult invokeL;
            char read;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bufferedReader)) == null) {
                char[] cArr = new char[4];
                int i2 = 0;
                if (Build.VERSION.SDK_INT < 26) {
                    int i3 = 0;
                    do {
                        read = (char) bufferedReader.read();
                        if (read == ' ' || i3 == 4) {
                            i3 = 0;
                        } else {
                            cArr[i3] = read;
                            i3++;
                        }
                        if (read == '%') {
                            break;
                        }
                    } while (read != 65535);
                    return String.valueOf(cArr, 0, i3);
                }
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    char read2 = (char) bufferedReader.read();
                    if (z && read2 != ' ') {
                        i4++;
                    }
                    if (i4 == 9) {
                        if (read2 != '.' && read2 != ' ') {
                            cArr[i5] = read2;
                            i5++;
                        }
                        i2 = Integer.parseInt(String.valueOf(cArr, 0, i5)) / Runtime.getRuntime().availableProcessors();
                        return i2 + "%";
                    }
                    z = (i4 <= 9 && read2 != 65535 && i5 < 4) ? read2 == ' ' : true;
                    i2 = Integer.parseInt(String.valueOf(cArr, 0, i5)) / Runtime.getRuntime().availableProcessors();
                    return i2 + "%";
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f5301e = true;
                String b2 = b();
                if (!TextUtils.isEmpty(b2)) {
                    this.f5302f.f5297e.put("cpu", b2);
                }
                this.f5301e = false;
            }
        }

        public /* synthetic */ RunnableC0154b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f5306a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1858274321, "Lc/a/o0/a/e0/g/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1858274321, "Lc/a/o0/a/e0/g/b$d;");
                    return;
                }
            }
            f5306a = new b(null);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f5307a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5307a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f5307a.f5297e == null) {
                return;
            }
            this.f5307a.g();
            this.f5307a.f5297e.put("mem", Long.valueOf(((ActivityManager) c.a.o0.a.c1.a.b().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.f5307a.f5293a != null) {
                this.f5307a.f5293a.sendEmptyMessageDelayed(0, this.f5307a.f5299g);
            }
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public class f implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f5308e;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5308e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Set<c.a.o0.a.q2.c<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (c.a.o0.a.q2.c<?> cVar : set) {
                this.f5308e.f5297e.put(cVar.f8094a, cVar.a());
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1704725073, "Lc/a/o0/a/e0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1704725073, "Lc/a/o0/a/e0/g/b;");
                return;
            }
        }
        f5291i = k.f7049a;
        f5292j = c.a.o0.a.q2.d.f8099d.f8094a;
        k = c.a.o0.a.q2.d.f8097b.f8094a;
        l = c.a.o0.a.q2.d.f8098c.f8094a;
        String str = c.a.o0.a.q2.d.f8102g.f8094a;
        m = c.a.o0.a.q2.d.f8104i.f8094a;
        n = c.a.o0.a.q2.d.f8100e.f8094a;
        o = c.a.o0.a.q2.d.f8101f.f8094a;
        p = c.a.o0.a.q2.d.f8103h.f8094a;
        q = c.a.o0.a.q2.d.f8105j.f8094a;
        r = c.a.o0.a.q2.d.k.f8094a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.f5306a : (b) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5296d.f5301e) {
            return;
        }
        q.j(this.f5296d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f5300h++;
            k();
            return this.f5297e;
        }
        return (Map) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f5300h - 1;
            this.f5300h = i2;
            if (i2 <= 0) {
                l();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f5298f) {
                boolean z = f5291i;
                return;
            }
            this.f5298f = true;
            this.f5295c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f5295c);
            this.f5296d = new RunnableC0154b(this, null);
            this.f5294b = new f(this, null);
            c.a.o0.a.q2.e.a().g(this.f5294b, c.a.o0.a.q2.d.f8099d, c.a.o0.a.q2.d.f8097b, c.a.o0.a.q2.d.f8098c, c.a.o0.a.q2.d.f8104i, c.a.o0.a.q2.d.f8100e, c.a.o0.a.q2.d.f8101f, c.a.o0.a.q2.d.f8102g, c.a.o0.a.q2.d.f8103h, c.a.o0.a.q2.d.f8105j, c.a.o0.a.q2.d.k);
            e eVar = new e(this, null);
            this.f5293a = eVar;
            eVar.sendEmptyMessage(0);
            boolean z2 = f5291i;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f5298f) {
                boolean z = f5291i;
                return;
            }
            this.f5298f = false;
            e eVar = this.f5293a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.f5293a = null;
            }
            if (this.f5294b != null) {
                c.a.o0.a.q2.e.a().j(this.f5294b, new c.a.o0.a.q2.c[0]);
                this.f5294b = null;
            }
            this.f5295c = null;
            this.f5296d = null;
            boolean z2 = f5291i;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5297e = new ConcurrentHashMap();
        this.f5299g = 1000;
    }

    /* loaded from: classes.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f5303e;

        /* renamed from: f  reason: collision with root package name */
        public int f5304f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f5305g;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5305g = bVar;
            this.f5303e = -1L;
            this.f5304f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && this.f5305g.f5298f) {
                long j3 = this.f5303e;
                if (j3 > 0 && this.f5304f != (i2 = (int) ((1.0d / (j2 - j3)) * 1.0E9d))) {
                    this.f5304f = i2;
                    this.f5305g.f5297e.put("frame", Integer.valueOf(i2));
                }
                this.f5303e = j2;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
