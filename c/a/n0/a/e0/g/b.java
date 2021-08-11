package c.a.n0.a.e0.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.Choreographer;
import c.a.n0.a.k;
import c.a.n0.a.q2.e;
import c.a.n0.a.v2.q;
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
    public static final boolean f5045i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f5046j;
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
    public e f5047a;

    /* renamed from: b  reason: collision with root package name */
    public f f5048b;

    /* renamed from: c  reason: collision with root package name */
    public c f5049c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0146b f5050d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f5051e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5052f;

    /* renamed from: g  reason: collision with root package name */
    public int f5053g;

    /* renamed from: h  reason: collision with root package name */
    public int f5054h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.n0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0146b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5055e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5056f;

        public RunnableC0146b(b bVar) {
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
            this.f5056f = bVar;
        }

        public synchronized String b() {
            InterceptResult invokeV;
            BufferedReader bufferedReader;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    boolean unused = b.f5045i;
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
                        if (b.f5045i) {
                            String str = "stop cpu monitor thread , cpu rate is : " + c2;
                        }
                        c.a.n0.t.d.d(bufferedReader);
                        return c2;
                    } catch (IOException unused3) {
                        bufferedReader2 = bufferedReader;
                        boolean unused4 = b.f5045i;
                        c.a.n0.t.d.d(bufferedReader2);
                        return "";
                    } catch (Throwable th3) {
                        th = th3;
                        c.a.n0.t.d.d(bufferedReader);
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
            if (c.a.n0.a.e0.g.b.f5045i != false) goto L25;
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
                this.f5055e = true;
                String b2 = b();
                if (!TextUtils.isEmpty(b2)) {
                    this.f5056f.f5051e.put("cpu", b2);
                }
                this.f5055e = false;
            }
        }

        public /* synthetic */ RunnableC0146b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f5060a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1352715696, "Lc/a/n0/a/e0/g/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1352715696, "Lc/a/n0/a/e0/g/b$d;");
                    return;
                }
            }
            f5060a = new b(null);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f5061a;

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
            this.f5061a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f5061a.f5051e == null) {
                return;
            }
            this.f5061a.g();
            this.f5061a.f5051e.put("mem", Long.valueOf(((ActivityManager) c.a.n0.a.c1.a.b().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.f5061a.f5047a != null) {
                this.f5061a.f5047a.sendEmptyMessageDelayed(0, this.f5061a.f5053g);
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
        public final /* synthetic */ b f5062e;

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
            this.f5062e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Set<c.a.n0.a.q2.c<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (c.a.n0.a.q2.c<?> cVar : set) {
                this.f5062e.f5051e.put(cVar.f7848a, cVar.a());
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1833807792, "Lc/a/n0/a/e0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1833807792, "Lc/a/n0/a/e0/g/b;");
                return;
            }
        }
        f5045i = k.f6803a;
        f5046j = c.a.n0.a.q2.d.f7853d.f7848a;
        k = c.a.n0.a.q2.d.f7851b.f7848a;
        l = c.a.n0.a.q2.d.f7852c.f7848a;
        String str = c.a.n0.a.q2.d.f7856g.f7848a;
        m = c.a.n0.a.q2.d.f7858i.f7848a;
        n = c.a.n0.a.q2.d.f7854e.f7848a;
        o = c.a.n0.a.q2.d.f7855f.f7848a;
        p = c.a.n0.a.q2.d.f7857h.f7848a;
        q = c.a.n0.a.q2.d.f7859j.f7848a;
        r = c.a.n0.a.q2.d.k.f7848a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.f5060a : (b) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5050d.f5055e) {
            return;
        }
        q.j(this.f5050d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f5054h++;
            k();
            return this.f5051e;
        }
        return (Map) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f5054h - 1;
            this.f5054h = i2;
            if (i2 <= 0) {
                l();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f5052f) {
                boolean z = f5045i;
                return;
            }
            this.f5052f = true;
            this.f5049c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f5049c);
            this.f5050d = new RunnableC0146b(this, null);
            this.f5048b = new f(this, null);
            c.a.n0.a.q2.e.a().g(this.f5048b, c.a.n0.a.q2.d.f7853d, c.a.n0.a.q2.d.f7851b, c.a.n0.a.q2.d.f7852c, c.a.n0.a.q2.d.f7858i, c.a.n0.a.q2.d.f7854e, c.a.n0.a.q2.d.f7855f, c.a.n0.a.q2.d.f7856g, c.a.n0.a.q2.d.f7857h, c.a.n0.a.q2.d.f7859j, c.a.n0.a.q2.d.k);
            e eVar = new e(this, null);
            this.f5047a = eVar;
            eVar.sendEmptyMessage(0);
            boolean z2 = f5045i;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f5052f) {
                boolean z = f5045i;
                return;
            }
            this.f5052f = false;
            e eVar = this.f5047a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.f5047a = null;
            }
            if (this.f5048b != null) {
                c.a.n0.a.q2.e.a().j(this.f5048b, new c.a.n0.a.q2.c[0]);
                this.f5048b = null;
            }
            this.f5049c = null;
            this.f5050d = null;
            boolean z2 = f5045i;
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
        this.f5051e = new ConcurrentHashMap();
        this.f5053g = 1000;
    }

    /* loaded from: classes.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f5057e;

        /* renamed from: f  reason: collision with root package name */
        public int f5058f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f5059g;

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
            this.f5059g = bVar;
            this.f5057e = -1L;
            this.f5058f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && this.f5059g.f5052f) {
                long j3 = this.f5057e;
                if (j3 > 0 && this.f5058f != (i2 = (int) ((1.0d / (j2 - j3)) * 1.0E9d))) {
                    this.f5058f = i2;
                    this.f5059g.f5051e.put("frame", Integer.valueOf(i2));
                }
                this.f5057e = j2;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
