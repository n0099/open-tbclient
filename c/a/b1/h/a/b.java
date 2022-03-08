package c.a.b1.h.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.Logger;
import com.baidu.yalog.impl.mmap.YaNativeLogger;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.webrtc.RtcCertificatePem;
/* loaded from: classes.dex */
public class b extends Logger {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f2302b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile int f2303c;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f2304d;

    /* renamed from: e  reason: collision with root package name */
    public static Object f2305e;

    /* renamed from: f  reason: collision with root package name */
    public static ExecutorService f2306f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f2307e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f2308f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f2309g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f2310h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f2311i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ long f2312j;
        public final /* synthetic */ b k;

        public a(b bVar, String str, int i2, String str2, String str3, int i3, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, Integer.valueOf(i2), str2, str3, Integer.valueOf(i3), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bVar;
            this.f2307e = str;
            this.f2308f = i2;
            this.f2309g = str2;
            this.f2310h = str3;
            this.f2311i = i3;
            this.f2312j = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.u(this.f2307e, this.f2308f, this.f2309g, this.f2310h, this.f2311i, this.f2312j);
            }
        }
    }

    /* renamed from: c.a.b1.h.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0094b implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f2313e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f2314f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f2315g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f2316h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f2317i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ long f2318j;
        public final /* synthetic */ b k;

        public CallableC0094b(b bVar, String str, int i2, String str2, String str3, int i3, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, Integer.valueOf(i2), str2, str3, Integer.valueOf(i3), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bVar;
            this.f2313e = str;
            this.f2314f = i2;
            this.f2315g = str2;
            this.f2316h = str3;
            this.f2317i = i3;
            this.f2318j = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.k.u(this.f2313e, this.f2314f, this.f2315g, this.f2316h, this.f2317i, this.f2318j);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f2319e;

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
            this.f2319e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2319e.t(false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(b bVar) {
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
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.z();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (b.f2305e) {
                    String s = b.s();
                    boolean x = b.x(s);
                    c.a.b1.f.a c2 = c.a.b1.f.a.c();
                    if (!c2.m()) {
                        if (x && c2.l()) {
                            b.p();
                        }
                        int unused = b.f2303c = 2;
                        return;
                    }
                    YaNativeLogger.a();
                    YaNativeLogger.setBaseDir(b.n());
                    YaNativeLogger.setProcessName(b.r(s));
                    if (x) {
                        YaNativeLogger.setMainController(true);
                    } else {
                        YaNativeLogger.setMainController(false);
                    }
                    long h2 = c2.h() * 1024 * 1024;
                    long min = h2 <= 0 ? 104857600L : Math.min(h2, 1073741824L);
                    YaNativeLogger.setMaxSizeAllLogFile(min);
                    long d2 = c2.d() * 1024 * 1024;
                    YaNativeLogger.setMaxSizePerLogFile(d2 <= 0 ? 1048576L : Math.min(d2, min));
                    YaNativeLogger.setDefaultSpaceEnable(true);
                    YaNativeLogger.setDefaultLogIdEnable(true);
                    long f2 = c2.f() * 1024 * 1024;
                    if (f2 <= 0) {
                        f2 = DownloadManager.MIN_LEFT_SIZE;
                    }
                    YaNativeLogger.setDefaultSpaceMaxSize(f2);
                    List<c.a.b1.g.c> e2 = c2.e();
                    if (e2 != null && e2.size() > 0) {
                        for (c.a.b1.g.c cVar : e2) {
                            if (cVar != null && !TextUtils.isEmpty(cVar.b())) {
                                String b2 = cVar.b();
                                YaNativeLogger.setSpaceEnable(b2, cVar.c());
                                long a = cVar.a() * 1024 * 1024;
                                if (a <= 0) {
                                    a = DownloadManager.MIN_LEFT_SIZE;
                                }
                                YaNativeLogger.setSpaceMaxSize(b2, a);
                                long d3 = cVar.d() * 60 * 60 * 24;
                                if (d3 <= 0) {
                                    d3 = IMConstants.FANS_GROUP_INFO_EXPIRED_TIME;
                                }
                                YaNativeLogger.setMaxAliveTimeForSpace(b2, d3);
                            }
                        }
                    }
                    long b3 = c2.b() * 1024 * 1024;
                    if (b3 <= 0) {
                        b3 = DownloadManager.MIN_LEFT_SIZE;
                    }
                    YaNativeLogger.setDefaultLogIdMaxSize(b3);
                    Map<String, c.a.b1.g.b> a2 = c2.a();
                    if (a2 != null && a2.size() > 0) {
                        for (String str : a2.keySet()) {
                            if (!TextUtils.isEmpty(str) && a2.get(str) != null) {
                                c.a.b1.g.b bVar = a2.get(str);
                                YaNativeLogger.setLogIdEnable(str, bVar.b());
                                long a3 = bVar.a() * 1024 * 1024;
                                if (a3 <= 0) {
                                    a3 = DownloadManager.MIN_LEFT_SIZE;
                                }
                                YaNativeLogger.setLogIdMaxSize(str, a3);
                            }
                        }
                    }
                    long g2 = c2.g() * 24 * 60 * 60;
                    YaNativeLogger.setDefaultMaxAliveTimeForSpace(g2 <= 0 ? IMConstants.FANS_GROUP_INFO_EXPIRED_TIME : Math.min(g2, (long) RtcCertificatePem.DEFAULT_EXPIRY));
                    YaNativeLogger.start();
                    int unused2 = b.f2303c = 1;
                    b.f2305e.notifyAll();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(118511400, "Lc/a/b1/h/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(118511400, "Lc/a/b1/h/a/b;");
                return;
            }
        }
        f2302b = AppConfig.isDebug();
        f2303c = 0;
        f2304d = new String[]{"L0", "L1", "V", "D", "I", "W", "E", "A"};
        f2305e = new Object();
        f2306f = Executors.newSingleThreadExecutor();
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        A();
        B();
    }

    public static void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && f2303c == 0) {
            new Thread(new e()).start();
        }
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f2303c == 0) {
                synchronized (f2305e) {
                    while (f2303c == 0) {
                        try {
                            f2305e.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
            return f2303c == 1;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [c.a.b1.h.a.b.e.run():void] */
    public static /* synthetic */ boolean m() {
        return f2302b;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, ".yalog").getAbsolutePath() : (String) invokeV.objValue;
    }

    public static List<String> o(long j2, long j3, String str, String str2, boolean z, boolean z2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3})) == null) {
            ArrayList arrayList = new ArrayList();
            if (C()) {
                try {
                    YaNativeLogger.createLogSnapShot(j2, j3, str, str2, z, z2, str3, arrayList);
                } catch (Throwable th) {
                    if (f2302b) {
                        th.printStackTrace();
                    }
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            q(new File(n()));
        }
    }

    public static void q(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, file) == null) && file != null && file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        q(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static String r(String str) {
        InterceptResult invokeL;
        String replaceAll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "unknown";
            }
            if (x(str)) {
                return "main";
            }
            Context appContext = AppRuntime.getAppContext();
            String str2 = appContext.getApplicationInfo().packageName;
            if (TextUtils.isEmpty(str2)) {
                str2 = appContext.getPackageName();
            }
            String str3 = str2 + ":";
            if (str.startsWith(str3)) {
                String substring = str.substring(str3.length());
                if (TextUtils.equals("main", substring)) {
                    return "_main";
                }
                replaceAll = !TextUtils.isEmpty(substring) ? substring.replaceAll("[:/]", "_") : "";
            } else {
                replaceAll = str.replaceAll("[:/]", "_");
            }
            return !TextUtils.isEmpty(replaceAll) ? replaceAll : "unknown";
        }
        return (String) invokeL.objValue;
    }

    public static String s() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) appContext.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == Process.myPid()) {
                    str = next.processName;
                    break;
                }
            }
            return !TextUtils.isEmpty(str) ? str : appContext.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    public static boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            if (str == null) {
                return true;
            }
            Context appContext = AppRuntime.getAppContext();
            String str2 = appContext.getApplicationInfo().processName;
            if (TextUtils.isEmpty(str2)) {
                str2 = appContext.getPackageName();
            }
            if (str.startsWith(str2)) {
                return str.length() == str2.length() || str.charAt(str2.length()) != ':';
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<String> y(long j2, long j3, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2})) == null) {
            ArrayList arrayList = new ArrayList();
            if (C()) {
                try {
                    YaNativeLogger.queryLogFiles(j2, j3, str, str2, arrayList);
                } catch (Throwable th) {
                    if (f2302b) {
                        th.printStackTrace();
                    }
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, null) == null) && C()) {
            try {
                YaNativeLogger.requestCleanOverQuotaLog();
            } catch (Throwable th) {
                if (f2302b) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new d(this), 30000L);
        }
    }

    @Override // com.baidu.yalog.Logger
    public void executeRunnable(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            f2306f.execute(runnable);
        }
    }

    @Override // com.baidu.yalog.Logger
    public void flush(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                t(true);
            } else {
                f2306f.execute(new c(this));
            }
        }
    }

    @Override // com.baidu.yalog.Logger
    public void log(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, str, i2, str2, str3) == null) {
            f2306f.execute(new a(this, str, i2, str2, str3, Process.myTid(), System.currentTimeMillis()));
        }
    }

    @Override // com.baidu.yalog.Logger
    public void logSync(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, str, i2, str2, str3) == null) {
            try {
                f2306f.submit(new CallableC0094b(this, str, i2, str2, str3, Process.myTid(), System.currentTimeMillis())).get();
            } catch (Exception e2) {
                if (f2302b) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && C()) {
            try {
                YaNativeLogger.flush(this.a, z);
            } catch (Throwable th) {
                if (f2302b) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void u(String str, int i2, String str2, String str3, int i3, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Integer.valueOf(i3), Long.valueOf(j2)}) == null) && C()) {
            int myPid = Process.myPid();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("pid").value(myPid);
                jsonWriter.name("tid").value(i3);
                jsonWriter.name("time").value(simpleDateFormat.format(Long.valueOf(j2)));
                if (!TextUtils.isEmpty(str)) {
                    jsonWriter.name("logid").value(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jsonWriter.name("tag").value(str2);
                }
                if (i2 >= 0 && i2 < f2304d.length) {
                    jsonWriter.name("level").value(f2304d[i2]);
                } else {
                    JsonWriter name = jsonWriter.name("level");
                    name.value("L" + i2);
                }
                jsonWriter.endObject();
            } catch (IOException unused) {
            }
            YaNativeLogger.b(this.a, "main", str, stringWriter.toString(), str3);
        }
    }
}
