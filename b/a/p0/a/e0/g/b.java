package b.a.p0.a.e0.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.Choreographer;
import b.a.p0.a.k;
import b.a.p0.a.q2.e;
import b.a.p0.a.v2.q;
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
    public static final boolean f4694i;
    public static final String j;
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
    public e f4695a;

    /* renamed from: b  reason: collision with root package name */
    public f f4696b;

    /* renamed from: c  reason: collision with root package name */
    public c f4697c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0151b f4698d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f4699e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4700f;

    /* renamed from: g  reason: collision with root package name */
    public int f4701g;

    /* renamed from: h  reason: collision with root package name */
    public int f4702h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.p0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0151b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4703e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f4704f;

        public RunnableC0151b(b bVar) {
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
            this.f4704f = bVar;
        }

        public synchronized String b() {
            InterceptResult invokeV;
            BufferedReader bufferedReader;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    boolean unused = b.f4694i;
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
                        if (b.f4694i) {
                            String str = "stop cpu monitor thread , cpu rate is : " + c2;
                        }
                        b.a.p0.t.d.d(bufferedReader);
                        return c2;
                    } catch (IOException unused3) {
                        bufferedReader2 = bufferedReader;
                        boolean unused4 = b.f4694i;
                        b.a.p0.t.d.d(bufferedReader2);
                        return "";
                    } catch (Throwable th3) {
                        th = th3;
                        b.a.p0.t.d.d(bufferedReader);
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
            if (b.a.p0.a.e0.g.b.f4694i != false) goto L25;
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
                this.f4703e = true;
                String b2 = b();
                if (!TextUtils.isEmpty(b2)) {
                    this.f4704f.f4699e.put("cpu", b2);
                }
                this.f4703e = false;
            }
        }

        public /* synthetic */ RunnableC0151b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f4708a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1366760593, "Lb/a/p0/a/e0/g/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1366760593, "Lb/a/p0/a/e0/g/b$d;");
                    return;
                }
            }
            f4708a = new b(null);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f4709a;

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
            this.f4709a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f4709a.f4699e == null) {
                return;
            }
            this.f4709a.g();
            this.f4709a.f4699e.put("mem", Long.valueOf(((ActivityManager) b.a.p0.a.c1.a.b().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.f4709a.f4695a != null) {
                this.f4709a.f4695a.sendEmptyMessageDelayed(0, this.f4709a.f4701g);
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
        public final /* synthetic */ b f4710e;

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
            this.f4710e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Set<b.a.p0.a.q2.c<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (b.a.p0.a.q2.c<?> cVar : set) {
                this.f4710e.f4699e.put(cVar.f7416a, cVar.a());
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1065108177, "Lb/a/p0/a/e0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1065108177, "Lb/a/p0/a/e0/g/b;");
                return;
            }
        }
        f4694i = k.f6397a;
        j = b.a.p0.a.q2.d.f7421d.f7416a;
        k = b.a.p0.a.q2.d.f7419b.f7416a;
        l = b.a.p0.a.q2.d.f7420c.f7416a;
        String str = b.a.p0.a.q2.d.f7424g.f7416a;
        m = b.a.p0.a.q2.d.f7426i.f7416a;
        n = b.a.p0.a.q2.d.f7422e.f7416a;
        o = b.a.p0.a.q2.d.f7423f.f7416a;
        p = b.a.p0.a.q2.d.f7425h.f7416a;
        q = b.a.p0.a.q2.d.j.f7416a;
        r = b.a.p0.a.q2.d.k.f7416a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.f4708a : (b) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4698d.f4703e) {
            return;
        }
        q.j(this.f4698d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f4702h++;
            k();
            return this.f4699e;
        }
        return (Map) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f4702h - 1;
            this.f4702h = i2;
            if (i2 <= 0) {
                l();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f4700f) {
                boolean z = f4694i;
                return;
            }
            this.f4700f = true;
            this.f4697c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f4697c);
            this.f4698d = new RunnableC0151b(this, null);
            this.f4696b = new f(this, null);
            b.a.p0.a.q2.e.a().g(this.f4696b, b.a.p0.a.q2.d.f7421d, b.a.p0.a.q2.d.f7419b, b.a.p0.a.q2.d.f7420c, b.a.p0.a.q2.d.f7426i, b.a.p0.a.q2.d.f7422e, b.a.p0.a.q2.d.f7423f, b.a.p0.a.q2.d.f7424g, b.a.p0.a.q2.d.f7425h, b.a.p0.a.q2.d.j, b.a.p0.a.q2.d.k);
            e eVar = new e(this, null);
            this.f4695a = eVar;
            eVar.sendEmptyMessage(0);
            boolean z2 = f4694i;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f4700f) {
                boolean z = f4694i;
                return;
            }
            this.f4700f = false;
            e eVar = this.f4695a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.f4695a = null;
            }
            if (this.f4696b != null) {
                b.a.p0.a.q2.e.a().j(this.f4696b, new b.a.p0.a.q2.c[0]);
                this.f4696b = null;
            }
            this.f4697c = null;
            this.f4698d = null;
            boolean z2 = f4694i;
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
        this.f4699e = new ConcurrentHashMap();
        this.f4701g = 1000;
    }

    /* loaded from: classes.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f4705e;

        /* renamed from: f  reason: collision with root package name */
        public int f4706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4707g;

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
            this.f4707g = bVar;
            this.f4705e = -1L;
            this.f4706f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.f4707g.f4700f) {
                long j2 = this.f4705e;
                if (j2 > 0 && this.f4706f != (i2 = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f4706f = i2;
                    this.f4707g.f4699e.put("frame", Integer.valueOf(i2));
                }
                this.f4705e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
