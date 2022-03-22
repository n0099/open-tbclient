package c.a.y0.h.a;

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
/* loaded from: classes3.dex */
public class b extends Logger {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f22108b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile int f22109c;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f22110d;

    /* renamed from: e  reason: collision with root package name */
    public static Object f22111e;

    /* renamed from: f  reason: collision with root package name */
    public static ExecutorService f22112f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f22113b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f22114c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f22115d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22117f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f22118g;

        public a(b bVar, String str, int i, String str2, String str3, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22118g = bVar;
            this.a = str;
            this.f22113b = i;
            this.f22114c = str2;
            this.f22115d = str3;
            this.f22116e = i2;
            this.f22117f = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22118g.u(this.a, this.f22113b, this.f22114c, this.f22115d, this.f22116e, this.f22117f);
            }
        }
    }

    /* renamed from: c.a.y0.h.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class CallableC1634b implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f22119b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f22120c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f22121d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22123f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f22124g;

        public CallableC1634b(b bVar, String str, int i, String str2, String str3, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22124g = bVar;
            this.a = str;
            this.f22119b = i;
            this.f22120c = str2;
            this.f22121d = str3;
            this.f22122e = i2;
            this.f22123f = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.f22124g.u(this.a, this.f22119b, this.f22120c, this.f22121d, this.f22122e, this.f22123f);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t(false);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes3.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (b.f22111e) {
                    String s = b.s();
                    boolean x = b.x(s);
                    c.a.y0.f.a c2 = c.a.y0.f.a.c();
                    if (!c2.m()) {
                        if (x && c2.l()) {
                            b.p();
                        }
                        int unused = b.f22109c = 2;
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
                    List<c.a.y0.g.c> e2 = c2.e();
                    if (e2 != null && e2.size() > 0) {
                        for (c.a.y0.g.c cVar : e2) {
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
                    Map<String, c.a.y0.g.b> a2 = c2.a();
                    if (a2 != null && a2.size() > 0) {
                        for (String str : a2.keySet()) {
                            if (!TextUtils.isEmpty(str) && a2.get(str) != null) {
                                c.a.y0.g.b bVar = a2.get(str);
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
                    int unused2 = b.f22109c = 1;
                    b.f22111e.notifyAll();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-246078624, "Lc/a/y0/h/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-246078624, "Lc/a/y0/h/a/b;");
                return;
            }
        }
        f22108b = AppConfig.isDebug();
        f22109c = 0;
        f22110d = new String[]{"L0", "L1", "V", "D", "I", "W", "E", "A"};
        f22111e = new Object();
        f22112f = Executors.newSingleThreadExecutor();
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && f22109c == 0) {
            new Thread(new e()).start();
        }
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f22109c == 0) {
                synchronized (f22111e) {
                    while (f22109c == 0) {
                        try {
                            f22111e.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
            return f22109c == 1;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [c.a.y0.h.a.b.e.run():void] */
    public static /* synthetic */ boolean m() {
        return f22108b;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, ".yalog").getAbsolutePath() : (String) invokeV.objValue;
    }

    public static List<String> o(long j, long j2, String str, String str2, boolean z, boolean z2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3})) == null) {
            ArrayList arrayList = new ArrayList();
            if (C()) {
                try {
                    YaNativeLogger.createLogSnapShot(j, j2, str, str2, z, z2, str3, arrayList);
                } catch (Throwable th) {
                    if (f22108b) {
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

    public static List<String> y(long j, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2})) == null) {
            ArrayList arrayList = new ArrayList();
            if (C()) {
                try {
                    YaNativeLogger.queryLogFiles(j, j2, str, str2, arrayList);
                } catch (Throwable th) {
                    if (f22108b) {
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
                if (f22108b) {
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
            f22112f.execute(runnable);
        }
    }

    @Override // com.baidu.yalog.Logger
    public void flush(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                t(true);
            } else {
                f22112f.execute(new c(this));
            }
        }
    }

    @Override // com.baidu.yalog.Logger
    public void log(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, str, i, str2, str3) == null) {
            f22112f.execute(new a(this, str, i, str2, str3, Process.myTid(), System.currentTimeMillis()));
        }
    }

    @Override // com.baidu.yalog.Logger
    public void logSync(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, str, i, str2, str3) == null) {
            try {
                f22112f.submit(new CallableC1634b(this, str, i, str2, str3, Process.myTid(), System.currentTimeMillis())).get();
            } catch (Exception e2) {
                if (f22108b) {
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
                if (f22108b) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void u(String str, int i, String str2, String str3, int i2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Long.valueOf(j)}) == null) && C()) {
            int myPid = Process.myPid();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("pid").value(myPid);
                jsonWriter.name("tid").value(i2);
                jsonWriter.name("time").value(simpleDateFormat.format(Long.valueOf(j)));
                if (!TextUtils.isEmpty(str)) {
                    jsonWriter.name("logid").value(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jsonWriter.name("tag").value(str2);
                }
                if (i >= 0 && i < f22110d.length) {
                    jsonWriter.name("level").value(f22110d[i]);
                } else {
                    JsonWriter name = jsonWriter.name("level");
                    name.value("L" + i);
                }
                jsonWriter.endObject();
            } catch (IOException unused) {
            }
            YaNativeLogger.b(this.a, "main", str, stringWriter.toString(), str3);
        }
    }
}
