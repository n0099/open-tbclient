package c.b.c.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.loader.content.ModernAsyncTask;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.bytedance.tea.crash.upload.CrashUploadService;
import com.bytedance.tea.crash.upload.b;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f31607a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f31608e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f31609f;

        public a(Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31608e = context;
            this.f31609f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.b.c.b.c.b.a().b(this.f31608e);
                c.b.c.b.n.c.a(this.f31608e);
                if (this.f31609f) {
                    c.b.c.b.a.f.a(this.f31608e).b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static String f31610a;

        /* renamed from: b  reason: collision with root package name */
        public static String f31611b;

        /* renamed from: c  reason: collision with root package name */
        public static Class<?> f31612c;

        /* renamed from: d  reason: collision with root package name */
        public static Field f31613d;

        /* renamed from: e  reason: collision with root package name */
        public static Field f31614e;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f31615f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1738507919, "Lc/b/c/b/l$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1738507919, "Lc/b/c/b/l$b;");
            }
        }

        public static long a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
                if (i2 < 0) {
                    return 0L;
                }
                return i2 * 1024;
            }
            return invokeI.longValue;
        }

        @Nullable
        public static ActivityManager.ProcessErrorStateInfo b(Context context, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i2)) == null) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager == null) {
                    return null;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    SystemClock.sleep(200L);
                    List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                    if (processesInErrorState != null) {
                        for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                            if (processErrorStateInfo.condition == 2) {
                                return processErrorStateInfo;
                            }
                        }
                        continue;
                    }
                }
                return null;
            }
            return (ActivityManager.ProcessErrorStateInfo) invokeLI.objValue;
        }

        @Nullable
        public static String c() {
            InterceptResult invokeV;
            BufferedReader bufferedReader;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(65539, null)) != null) {
                return (String) invokeV.objValue;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read > 0) {
                        sb.append((char) read);
                    } else {
                        String sb2 = sb.toString();
                        g.a(bufferedReader);
                        return sb2;
                    }
                }
            } catch (Throwable unused2) {
                g.a(bufferedReader);
                return null;
            }
        }

        public static void d(@NonNull Context context, @NonNull JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, jSONObject) == null) {
                try {
                    e(jSONObject);
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager != null) {
                        h(jSONObject, activityManager);
                    }
                    f(jSONObject, activityManager);
                } catch (Throwable unused) {
                }
            }
        }

        public static void e(@NonNull JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject) == null) {
                Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("dalvikPrivateDirty", a(memoryInfo.dalvikPrivateDirty));
                jSONObject2.put("dalvikPss", a(memoryInfo.dalvikPss));
                jSONObject2.put("dalvikSharedDirty", a(memoryInfo.dalvikSharedDirty));
                jSONObject2.put("nativePrivateDirty", a(memoryInfo.nativePrivateDirty));
                jSONObject2.put("nativePss", a(memoryInfo.nativePss));
                jSONObject2.put("nativeSharedDirty", a(memoryInfo.nativeSharedDirty));
                jSONObject2.put("otherPrivateDirty", a(memoryInfo.otherPrivateDirty));
                jSONObject2.put("otherPss", a(memoryInfo.otherPss));
                jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
                jSONObject2.put("totalPrivateClean", c.a(memoryInfo));
                jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
                jSONObject2.put("totalPss", a(memoryInfo.getTotalPss()));
                jSONObject2.put("totalSharedClean", c.b(memoryInfo));
                jSONObject2.put("totalSharedDirty", a(memoryInfo.getTotalSharedDirty()));
                jSONObject2.put("totalSwappablePss", a(c.c(memoryInfo)));
                jSONObject.put("memory_info", jSONObject2);
            }
        }

        public static void f(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, activityManager) == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
                jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
                jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
                Runtime runtime = Runtime.getRuntime();
                jSONObject2.put("max_memory", runtime.maxMemory());
                jSONObject2.put("free_memory", runtime.freeMemory());
                jSONObject2.put("total_memory", runtime.totalMemory());
                if (activityManager != null) {
                    jSONObject2.put("memory_class", activityManager.getMemoryClass());
                    jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
                }
                jSONObject.put("app_memory_info", jSONObject2);
            }
        }

        public static boolean g(Context context) {
            InterceptResult invokeL;
            ActivityManager activityManager;
            ComponentName componentName;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
                if (context == null) {
                    return false;
                }
                String packageName = context.getPackageName();
                try {
                    activityManager = (ActivityManager) context.getSystemService("activity");
                } catch (Throwable unused) {
                }
                if (activityManager == null) {
                    return false;
                }
                if (Build.VERSION.SDK_INT < 21) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                    if (runningTasks != null && !runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null && packageName.equals(componentName.getPackageName())) {
                        return true;
                    }
                } else {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.importance == 100) {
                                return packageName.equals(runningAppProcessInfo.pkgList[0]);
                            }
                        }
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public static void h(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65544, null, jSONObject, activityManager) == null) {
                JSONObject jSONObject2 = new JSONObject();
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                jSONObject2.put("availMem", memoryInfo.availMem);
                jSONObject2.put("lowMemory", memoryInfo.lowMemory);
                jSONObject2.put("threshold", memoryInfo.threshold);
                jSONObject2.put("totalMem", h.a(memoryInfo));
                jSONObject.put("sys_memory_info", jSONObject2);
            }
        }

        public static boolean i(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
                String k = k(context);
                if (k == null || !k.contains(":")) {
                    if (k == null || !k.equals(context.getPackageName())) {
                        return k != null && k.equals(context.getApplicationInfo().processName);
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public static boolean j(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
                String k = k(context);
                if (f31611b == null) {
                    try {
                        String str = context.getPackageManager().getServiceInfo(new ComponentName(context, CrashUploadService.class), 65536).processName;
                        f31611b = str;
                        f31611b = str.substring(str.lastIndexOf(":"));
                    } catch (Throwable th) {
                        th.printStackTrace();
                        f31611b = ":npth";
                    }
                }
                return k != null && k.endsWith(f31611b);
            }
            return invokeL.booleanValue;
        }

        @Nullable
        public static String k(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
                String str = f31610a;
                if (TextUtils.isEmpty(str)) {
                    try {
                        int myPid = Process.myPid();
                        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                        if (activityManager != null) {
                            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                                if (runningAppProcessInfo.pid == myPid) {
                                    String str2 = runningAppProcessInfo.processName;
                                    f31610a = str2;
                                    return str2;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        k.c(th);
                    }
                    String c2 = c();
                    f31610a = c2;
                    return c2 == null ? "" : c2;
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        @NonNull
        public static String l(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
                Class<?> n = n(context);
                if (f31613d == null && n != null) {
                    try {
                        f31613d = n.getDeclaredField("VERSION_NAME");
                    } catch (NoSuchFieldException unused) {
                    }
                }
                Field field = f31613d;
                if (field != null) {
                    try {
                        return (String) field.get(null);
                    } catch (Throwable unused2) {
                        return "";
                    }
                }
                return "";
            }
            return (String) invokeL.objValue;
        }

        public static int m(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
                Class<?> n = n(context);
                if (f31614e == null && n != null) {
                    try {
                        f31614e = n.getDeclaredField("VERSION_CODE");
                    } catch (NoSuchFieldException unused) {
                    }
                }
                Field field = f31614e;
                if (field != null) {
                    try {
                        return ((Integer) field.get(null)).intValue();
                    } catch (Throwable unused2) {
                        return -1;
                    }
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Nullable
        public static Class<?> n(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
                if (f31612c == null && !f31615f) {
                    try {
                        f31612c = Class.forName(context.getPackageName() + ".BuildConfig");
                    } catch (ClassNotFoundException unused) {
                    }
                    f31615f = true;
                }
                return f31612c;
            }
            return (Class) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f31616a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static /* synthetic */ class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
        }

        /* loaded from: classes4.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
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

            public int a(Debug.MemoryInfo memoryInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, memoryInfo)) == null) {
                    return -1;
                }
                return invokeL.intValue;
            }

            public int b(Debug.MemoryInfo memoryInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memoryInfo)) == null) {
                    return -1;
                }
                return invokeL.intValue;
            }

            public int c(Debug.MemoryInfo memoryInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, memoryInfo)) == null) {
                    return -1;
                }
                return invokeL.intValue;
            }

            public /* synthetic */ b(a aVar) {
                this();
            }
        }

        @TargetApi(19)
        /* renamed from: c.b.c.b.l$c$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C1447c extends b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1447c() {
                super(null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // c.b.c.b.l.c.b
            public int a(Debug.MemoryInfo memoryInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, memoryInfo)) == null) ? memoryInfo.getTotalPrivateClean() : invokeL.intValue;
            }

            @Override // c.b.c.b.l.c.b
            public int b(Debug.MemoryInfo memoryInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memoryInfo)) == null) ? memoryInfo.getTotalSharedClean() : invokeL.intValue;
            }

            @Override // c.b.c.b.l.c.b
            public int c(Debug.MemoryInfo memoryInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, memoryInfo)) == null) ? memoryInfo.getTotalSwappablePss() : invokeL.intValue;
            }

            public /* synthetic */ C1447c(a aVar) {
                this();
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738507950, "Lc/b/c/b/l$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1738507950, "Lc/b/c/b/l$c;");
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                f31616a = new C1447c(null);
            } else {
                f31616a = new b(null);
            }
        }

        public static int a(Debug.MemoryInfo memoryInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, memoryInfo)) == null) ? f31616a.a(memoryInfo) : invokeL.intValue;
        }

        public static int b(Debug.MemoryInfo memoryInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, memoryInfo)) == null) ? f31616a.b(memoryInfo) : invokeL.intValue;
        }

        public static int c(Debug.MemoryInfo memoryInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, memoryInfo)) == null) ? f31616a.c(memoryInfo) : invokeL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static boolean f31617a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1738507981, "Lc/b/c/b/l$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1738507981, "Lc/b/c/b/l$d;");
            }
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c("ro.build.version.emui") : (String) invokeV.objValue;
        }

        public static boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = a();
                }
                if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
                    return d();
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public static String c(String str) {
            InterceptResult invokeL;
            BufferedReader bufferedReader;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                String str2 = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                } catch (Throwable unused) {
                    bufferedReader = null;
                }
                try {
                    str2 = bufferedReader.readLine();
                    bufferedReader.close();
                    g.a(bufferedReader);
                    return str2;
                } catch (Throwable unused2) {
                    g.a(bufferedReader);
                    return str2;
                }
            }
            return (String) invokeL.objValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                try {
                    if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith(RomUtils.MANUFACTURER_HUAWEI)) {
                        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                            return false;
                        }
                        if (!Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith(RomUtils.MANUFACTURER_HUAWEI)) {
                            return false;
                        }
                    }
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public static boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                if (!f31617a) {
                    try {
                        if (Class.forName("miui.os.Build") != null) {
                            com.bytedance.tea.crash.upload.b.f69228a = true;
                            f31617a = true;
                            return true;
                        }
                    } catch (Exception unused) {
                    }
                    f31617a = true;
                }
                return com.bytedance.tea.crash.upload.b.f69228a;
            }
            return invokeV.booleanValue;
        }

        public static boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme") : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{file, str, str2, jSONObject, str3, Boolean.valueOf(z)})) == null) {
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, str);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("url", str2);
                    jSONObject2.put("body", jSONObject);
                    if (str3 == null) {
                        str3 = "";
                    }
                    jSONObject2.put("dump_file", str3);
                    jSONObject2.put(LightappBusinessClient.MTD_ENCRYPT, z);
                    e(file2, jSONObject2.toString(), false);
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                return file2.getAbsolutePath();
            }
            return (String) invokeCommon.objValue;
        }

        public static String b(File file, String str, String str2, JSONObject jSONObject, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{file, str, str2, jSONObject, Boolean.valueOf(z)})) == null) ? a(file, str, str2, jSONObject, null, z) : (String) invokeCommon.objValue;
        }

        public static String c(String str, String str2) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, null, str, str2)) != null) {
                return (String) invokeLL.objValue;
            }
            BufferedReader bufferedReader = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                            if (str2 != null) {
                                sb.append(str2);
                            }
                        } else {
                            g.a(bufferedReader2);
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        g.a(bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public static void d(Context context, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    sb.append(" ");
                    if (str == null) {
                        str = StringUtil.NULL_STRING;
                    }
                    sb.append(str);
                    sb.append(" ");
                    if (str2 == null) {
                        str2 = StringUtil.NULL_STRING;
                    }
                    sb.append(str2);
                    sb.append(StringUtils.LF);
                    e(i.c(context), sb.toString(), true);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public static void e(@NonNull File file, @NonNull String str, boolean z) throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, file, str, z) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            file.getParentFile().mkdirs();
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    fileOutputStream2.write(str.getBytes());
                    fileOutputStream2.flush();
                    g.a(fileOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    g.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public static boolean f(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) ? file.exists() && file.delete() : invokeL.booleanValue;
        }

        public static boolean g(@NonNull File file, boolean z) {
            InterceptResult invokeLZ;
            boolean g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, file, z)) == null) {
                if (z && !file.isFile()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        boolean z2 = true;
                        for (int i2 = 0; listFiles != null && i2 < listFiles.length; i2++) {
                            if (listFiles[i2].isFile()) {
                                g2 = f(listFiles[i2]);
                            } else {
                                g2 = g(listFiles[i2], true);
                            }
                            z2 &= g2;
                        }
                        return z2 & f(file);
                    }
                    return true;
                }
                return f(file);
            }
            return invokeLZ.booleanValue;
        }

        public static boolean h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                File file = new File(str);
                return file.exists() && file.delete();
            }
            return invokeL.booleanValue;
        }

        public static String i(String str) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? c(str, null) : (String) invokeL.objValue;
        }

        public static c.b.c.b.e.c j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(i(str));
                    c.b.c.b.e.c cVar = new c.b.c.b.e.c();
                    cVar.b(jSONObject.optString("url"));
                    cVar.c(jSONObject.optJSONObject("body"));
                    cVar.f(jSONObject.optString("dump_file"));
                    cVar.d(jSONObject.optBoolean(LightappBusinessClient.MTD_ENCRYPT, false));
                    return cVar;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return (c.b.c.b.e.c) invokeL.objValue;
        }

        @Nullable
        public static String[] k(String str) {
            InterceptResult invokeL;
            BufferedReader bufferedReader;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(65546, null, str)) != null) {
                return (String[]) invokeL.objValue;
            }
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), 1000);
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        int indexOf = readLine.indexOf(SmallTailInfo.EMOTION_SUFFIX);
                        if (indexOf > 0) {
                            readLine = readLine.substring(indexOf + 2);
                        }
                        String[] split = readLine.split(" ");
                        g.a(bufferedReader);
                        return split;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        g.a(bufferedReader);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    g.a(bufferedReader2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                g.a(bufferedReader2);
                throw th;
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Set<String> f31618a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738508043, "Lc/b/c/b/l$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1738508043, "Lc/b/c/b/l$f;");
                    return;
                }
            }
            HashSet hashSet = new HashSet();
            f31618a = hashSet;
            hashSet.add("HeapTaskDaemon");
            f31618a.add("ThreadPlus");
            f31618a.add("ApiDispatcher");
            f31618a.add("ApiLocalDispatcher");
            f31618a.add("AsyncLoader");
            f31618a.add(ModernAsyncTask.LOG_TAG);
            f31618a.add("Binder");
            f31618a.add("PackageProcessor");
            f31618a.add("SettingsObserver");
            f31618a.add("WifiManager");
            f31618a.add("JavaBridge");
            f31618a.add("Compiler");
            f31618a.add("Signal Catcher");
            f31618a.add("GC");
            f31618a.add("ReferenceQueueDaemon");
            f31618a.add("FinalizerDaemon");
            f31618a.add("FinalizerWatchdogDaemon");
            f31618a.add("CookieSyncManager");
            f31618a.add("RefQueueWorker");
            f31618a.add("CleanupReference");
            f31618a.add("VideoManager");
            f31618a.add("DBHelper-AsyncOp");
            f31618a.add("InstalledAppTracker2");
            f31618a.add("AppData-AsyncOp");
            f31618a.add("IdleConnectionMonitor");
            f31618a.add("LogReaper");
            f31618a.add("ActionReaper");
            f31618a.add("Okio Watchdog");
            f31618a.add("CheckWaitingQueue");
            f31618a.add("NPTH-CrashTimer");
            f31618a.add("NPTH-JavaCallback");
            f31618a.add("NPTH-LocalParser");
            f31618a.add("ANR_FILE_MODIFY");
        }

        public static Set<String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f31618a : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public final class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(Closeable closeable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65536, null, closeable) == null) || closeable == null) {
                return;
            }
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f31619a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static /* synthetic */ class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
        }

        /* loaded from: classes4.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
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

            public long a(ActivityManager.MemoryInfo memoryInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, memoryInfo)) == null) {
                    return 0L;
                }
                return invokeL.longValue;
            }

            public /* synthetic */ b(a aVar) {
                this();
            }
        }

        @TargetApi(16)
        /* loaded from: classes4.dex */
        public static class c extends b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c() {
                super(null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // c.b.c.b.l.h.b
            public long a(ActivityManager.MemoryInfo memoryInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, memoryInfo)) == null) ? memoryInfo.totalMem : invokeL.longValue;
            }

            public /* synthetic */ c(a aVar) {
                this();
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738508105, "Lc/b/c/b/l$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1738508105, "Lc/b/c/b/l$h;");
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                f31619a = new c(null);
            } else {
                f31619a = new b(null);
            }
        }

        public static long a(ActivityManager.MemoryInfo memoryInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, memoryInfo)) == null) ? f31619a.a(memoryInfo) : invokeL.longValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static File a(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? new File(e(context), "CrashLogJava") : (File) invokeL.objValue;
        }

        public static String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? String.format("java_%s.npth", String.valueOf(System.nanoTime())) : (String) invokeV.objValue;
        }

        public static File c(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new File(e(context), "crash_history") : (File) invokeL.objValue;
        }

        public static String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? String.format("anr_%s.npth", String.valueOf(System.nanoTime())) : (String) invokeV.objValue;
        }

        @SuppressLint({"SdCardPath"})
        public static String e(@NonNull Context context) {
            String path;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
                try {
                    if (context.getFilesDir() != null) {
                        path = context.getFilesDir().getPath();
                    } else {
                        File dir = context.getDir("/data/data/" + context.getPackageName() + "/files/", 0);
                        path = dir != null ? dir.getPath() : null;
                    }
                    return path != null ? path : "/sdcard/";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "/sdcard/";
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public final class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static /* synthetic */ class a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f31620a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-35948694, "Lc/b/c/b/l$j$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-35948694, "Lc/b/c/b/l$j$a;");
                        return;
                    }
                }
                int[] iArr = new int[b.EnumC1939b.values().length];
                f31620a = iArr;
                try {
                    iArr[b.EnumC1939b.f69239e.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    f31620a[b.EnumC1939b.f69237c.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    f31620a[b.EnumC1939b.f69238d.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    f31620a[b.EnumC1939b.f69240f.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    f31620a[b.EnumC1939b.f69236b.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
            }
        }

        public static String a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? b(d(context)) : (String) invokeL.objValue;
        }

        public static String b(b.EnumC1939b enumC1939b) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, enumC1939b)) == null) {
                try {
                    int i2 = a.f31620a[enumC1939b.ordinal()];
                    if (i2 == 1) {
                        str = "wifi";
                    } else if (i2 == 2) {
                        str = "2g";
                    } else if (i2 == 3) {
                        str = "3g";
                    } else if (i2 == 4) {
                        str = "4g";
                    } else if (i2 != 5) {
                        return "";
                    } else {
                        str = "mobile";
                    }
                    return str;
                } catch (Exception unused) {
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }

        public static boolean c(Context context) {
            InterceptResult invokeL;
            NetworkInfo activeNetworkInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return false;
                    }
                    return activeNetworkInfo.isAvailable();
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public static b.EnumC1939b d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        return b.EnumC1939b.f69235a;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        int type = activeNetworkInfo.getType();
                        if (1 == type) {
                            return b.EnumC1939b.f69239e;
                        }
                        if (type == 0) {
                            switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    return b.EnumC1939b.f69238d;
                                case 4:
                                case 7:
                                case 11:
                                default:
                                    return b.EnumC1939b.f69236b;
                                case 13:
                                    return b.EnumC1939b.f69240f;
                            }
                        }
                        return b.EnumC1939b.f69236b;
                    }
                    return b.EnumC1939b.f69235a;
                } catch (Throwable unused) {
                    return b.EnumC1939b.f69236b;
                }
            }
            return (b.EnumC1939b) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public final class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
                c.b.c.b.m.f().d();
            }
        }

        public static void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, th) == null) {
                c.b.c.b.m.f().d();
            }
        }

        public static void c(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, th) == null) {
                c.b.c.b.m.f().d();
            }
        }
    }

    /* renamed from: c.b.c.b.l$l  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public final class C1448l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(String str) {
            InterceptResult invokeL;
            Map<String, Object> a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
                if (c.b.c.b.m.a() == null || (a2 = c.b.c.b.m.a().a()) == null) {
                    return null;
                }
                Object obj = a2.get(str);
                if (obj instanceof String) {
                    return (String) obj;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public static void b(c.b.c.b.e.a aVar, c.b.c.b.e.b bVar, com.bytedance.tea.crash.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65537, null, aVar, bVar, cVar) == null) || aVar == null || aVar.j() == null || cVar == null) {
                return;
            }
            JSONObject j2 = aVar.j();
            long optLong = j2.optLong("crash_time");
            int c2 = c(a("aid"));
            String a2 = c.b.c.b.m.d().a();
            if (optLong <= 0 || c2 <= 0 || TextUtils.isEmpty(a2) || "0".equals(a2) || TextUtils.isEmpty(cVar.a())) {
                return;
            }
            try {
                String str = "android_" + c2 + "_" + a2 + "_" + optLong + "_" + cVar;
                if (bVar != null) {
                    JSONObject b2 = bVar.b();
                    if (b2 != null) {
                        b2.put("unique_key", str);
                    }
                } else {
                    j2.put("unique_key", str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        public static int c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return 0;
                }
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e2) {
                    k.c(e2);
                    return 0;
                }
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final CharSequence f31621a;

        /* renamed from: b  reason: collision with root package name */
        public static final CharSequence f31622b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738508260, "Lc/b/c/b/l$m;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1738508260, "Lc/b/c/b/l$m;");
                    return;
                }
            }
            f31621a = "amigo";
            f31622b = "funtouch";
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (d.e()) {
                    return k();
                }
                if (d.f()) {
                    return m();
                }
                if (n()) {
                    return o();
                }
                String l = l();
                if (TextUtils.isEmpty(l)) {
                    if (f()) {
                        return e();
                    }
                    if (g()) {
                        return h();
                    }
                    if (d()) {
                        return c();
                    }
                    String i2 = i();
                    return !TextUtils.isEmpty(i2) ? i2 : Build.DISPLAY;
                }
                return l;
            }
            return (String) invokeV.objValue;
        }

        public static String b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, str)) != null) {
                return (String) invokeL.objValue;
            }
            String str2 = "";
            BufferedReader bufferedReader = null;
            try {
                Runtime runtime = Runtime.getRuntime();
                Process exec = runtime.exec("getprop " + str);
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
                try {
                    str2 = bufferedReader2.readLine();
                    exec.destroy();
                    g.a(bufferedReader2);
                    return str2;
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    g.a(bufferedReader);
                    return str2;
                }
            } catch (Throwable unused2) {
            }
        }

        public static String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return b("ro.build.uiversion") + "_" + Build.DISPLAY;
            }
            return (String) invokeV.objValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                String str = Build.MANUFACTURER + Build.BRAND;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String lowerCase = str.toLowerCase(Locale.getDefault());
                return lowerCase.contains("360") || lowerCase.contains("qiku");
            }
            return invokeV.booleanValue;
        }

        public static String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                return b("ro.vivo.os.build.display.id") + "_" + b("ro.vivo.product.version");
            }
            return (String) invokeV.objValue;
        }

        public static boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
                String b2 = b("ro.vivo.os.build.display.id");
                return !TextUtils.isEmpty(b2) && b2.toLowerCase(Locale.getDefault()).contains(f31622b);
            }
            return invokeV.booleanValue;
        }

        public static boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(f31621a) : invokeV.booleanValue;
        }

        public static String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
                return Build.DISPLAY + "_" + b(RomUtils.KEY_VERSION_GIONEE);
            }
            return (String) invokeV.objValue;
        }

        public static String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
                if (j()) {
                    return "eui_" + b("ro.letv.release.version") + "_" + Build.DISPLAY;
                }
                return "";
            }
            return (String) invokeV.objValue;
        }

        public static boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? !TextUtils.isEmpty(b("ro.letv.release.version")) : invokeV.booleanValue;
        }

        public static String k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
                if (d.e()) {
                    return "miui_" + b("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
                }
                return "";
            }
            return (String) invokeV.objValue;
        }

        public static String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
                String a2 = d.a();
                if (a2 == null || !a2.toLowerCase(Locale.getDefault()).contains("emotionui")) {
                    return "";
                }
                return a2 + "_" + Build.DISPLAY;
            }
            return (String) invokeV.objValue;
        }

        public static String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
                String str = Build.DISPLAY;
                return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
            }
            return (String) invokeV.objValue;
        }

        public static boolean n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
                String str = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return str.toLowerCase(Locale.getDefault()).contains(RomUtils.MANUFACTURER_OPPO);
            }
            return invokeV.booleanValue;
        }

        public static String o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
                if (n()) {
                    return "coloros_" + b("ro.build.version.opporom") + "_" + Build.DISPLAY;
                }
                return "";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public final class n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final PrintWriter f31623a;

            public a(PrintWriter printWriter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {printWriter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31623a = printWriter;
            }

            public Object a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31623a : invokeV.objValue;
            }

            public void b(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                    this.f31623a.println(obj);
                }
            }
        }

        @NonNull
        public static String a(@NonNull Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, th)) == null) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                try {
                    if (i(th)) {
                        f(th, printWriter);
                    } else {
                        th.printStackTrace(printWriter);
                    }
                    return stringWriter.toString();
                } catch (Exception unused) {
                    return "";
                } finally {
                    printWriter.close();
                }
            }
            return (String) invokeL.objValue;
        }

        public static String b(StackTraceElement[] stackTraceElementArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, stackTraceElementArr)) == null) {
                StringBuilder sb = new StringBuilder();
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    c(stackTraceElement, sb);
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        public static StringBuilder c(StackTraceElement stackTraceElement, StringBuilder sb) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, stackTraceElement, sb)) == null) {
                String className = stackTraceElement.getClassName();
                sb.append("  at ");
                sb.append(className);
                sb.append(".");
                sb.append(stackTraceElement.getMethodName());
                sb.append("(");
                sb.append(stackTraceElement.getFileName());
                sb.append(":");
                sb.append(stackTraceElement.getLineNumber());
                sb.append(")\n");
                return sb;
            }
            return (StringBuilder) invokeLL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x00d9 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x002d A[SYNTHETIC] */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static JSONObject d(String str) {
            InterceptResult invokeL;
            Thread key;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                try {
                    Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
                    JSONObject jSONObject = new JSONObject();
                    if (allStackTraces == null) {
                        return null;
                    }
                    jSONObject.put("thread_all_count", allStackTraces.size());
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        String name = entry.getKey().getName();
                        if (!g(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                            jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + SmallTailInfo.EMOTION_SUFFIX);
                            StackTraceElement[] value = entry.getValue();
                            if (value != null) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (StackTraceElement stackTraceElement : value) {
                                    jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + SmallTailInfo.EMOTION_SUFFIX);
                                }
                                jSONObject2.put("thread_stack", jSONArray2);
                                if (jSONArray2.length() <= 0) {
                                    z = false;
                                    if (!z) {
                                        jSONArray.put(jSONObject2);
                                    }
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                        }
                    }
                    jSONObject.put("thread_stacks", jSONArray);
                    return jSONObject;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return (JSONObject) invokeL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: java.lang.Object[] */
        /* JADX WARN: Multi-variable type inference failed */
        public static void e(Throwable th, a aVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{th, aVar, stackTraceElementArr, str, str2, set}) == null) {
                if (set.contains(th)) {
                    aVar.b("\t[CIRCULAR REFERENCE:" + th + PreferencesUtil.RIGHT_MOUNT);
                    return;
                }
                set.add(th);
                StackTraceElement[] stackTrace = th.getStackTrace();
                int min = Math.min(stackTrace.length, 256);
                int i2 = min - 1;
                int i3 = i2;
                for (int min2 = Math.min(stackTraceElementArr.length, 256) - 1; i3 >= 0 && min2 >= 0 && stackTrace[i3].equals(stackTraceElementArr[min2]); min2--) {
                    i3--;
                }
                int i4 = i2 - i3;
                aVar.b(str2 + str + th);
                for (int i5 = 0; i5 <= i3; i5++) {
                    aVar.b(str2 + "\tat " + stackTrace[i5]);
                }
                if (min < stackTrace.length) {
                    aVar.b("\t... skip " + (stackTrace.length - min) + " lines");
                }
                if (i4 != 0) {
                    aVar.b(str2 + "\t... " + i4 + " more");
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    for (Throwable th2 : th.getSuppressed()) {
                        e(th2, aVar, stackTrace, "Suppressed: ", str2 + TrackUI.SEPERATOR, set);
                    }
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    e(cause, aVar, stackTrace, "Caused by: ", str2, set);
                }
            }
        }

        public static void f(Throwable th, PrintWriter printWriter) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, th, printWriter) == null) || th == null || printWriter == null) {
                return;
            }
            a aVar = new a(printWriter);
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            synchronized (aVar.a()) {
                aVar.b(th);
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (i3 > 256) {
                        aVar.b("\t... skip " + (stackTrace.length - i3) + " lines");
                        break;
                    }
                    aVar.b("\tat " + stackTraceElement);
                    i3++;
                    i2++;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    for (Throwable th2 : th.getSuppressed()) {
                        e(th2, aVar, stackTrace, "Suppressed: ", TrackUI.SEPERATOR, newSetFromMap);
                    }
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    e(cause, aVar, stackTrace, "Caused by: ", "", newSetFromMap);
                }
            }
        }

        public static boolean g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
                Set<String> a2 = f.a();
                if (a2.contains(str)) {
                    return true;
                }
                for (String str2 : a2) {
                    if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public static boolean h(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, th)) == null) {
                if (th == null) {
                    return false;
                }
                int i2 = 0;
                while (th != null) {
                    try {
                        if (th instanceof OutOfMemoryError) {
                            return true;
                        }
                        if (i2 > 20) {
                            return false;
                        }
                        i2++;
                        th = th.getCause();
                    } catch (Throwable unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public static boolean i(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, th)) == null) {
                int i2 = 0;
                while (th != null) {
                    if (th instanceof StackOverflowError) {
                        return true;
                    }
                    if (i2 > 20) {
                        return false;
                    }
                    th = th.getCause();
                    i2++;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static long a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
                try {
                    StatFs statFs = new StatFs(file.getPath());
                    if (Build.VERSION.SDK_INT >= 18) {
                        return statFs.getTotalBytes();
                    }
                    return statFs.getBlockCount() * statFs.getBlockSize();
                } catch (Throwable unused) {
                    return 0L;
                }
            }
            return invokeL.longValue;
        }

        public static JSONObject b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("inner_app_used", e(context));
                    jSONObject.put("inner_free", d());
                    jSONObject.put("inner_total", g());
                    jSONObject.put("sdcard_app_used", h(context));
                    jSONObject.put("sdcard_free", j());
                    jSONObject.put("sdcard_total", k());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "mounted".equals(Environment.getExternalStorageState()) : invokeV.booleanValue;
        }

        public static long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                try {
                    return f(Environment.getRootDirectory());
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return invokeV.longValue;
        }

        public static long e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
                try {
                    return i(context.getFilesDir().getParentFile());
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return invokeL.longValue;
        }

        public static long f(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) {
                try {
                    StatFs statFs = new StatFs(file.getPath());
                    if (Build.VERSION.SDK_INT >= 18) {
                        return statFs.getFreeBytes();
                    }
                    return statFs.getAvailableBlocks() * statFs.getBlockSize();
                } catch (Throwable unused) {
                    return 0L;
                }
            }
            return invokeL.longValue;
        }

        public static long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
                try {
                    return a(Environment.getRootDirectory());
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return invokeV.longValue;
        }

        public static long h(Context context) {
            File externalFilesDir;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
                try {
                    if (!c() || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
                        return 0L;
                    }
                    return i(externalFilesDir.getParentFile());
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return invokeL.longValue;
        }

        public static long i(File file) {
            InterceptResult invokeL;
            long length;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, file)) == null) {
                File[] listFiles = file.listFiles();
                long j2 = 0;
                if (listFiles == null) {
                    return 0L;
                }
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        length = i(file2);
                    } else {
                        length = file2.length();
                    }
                    j2 += length;
                }
                return j2;
            }
            return invokeL.longValue;
        }

        public static long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
                try {
                    if (c()) {
                        return Environment.getExternalStorageDirectory().getFreeSpace();
                    }
                    return 0L;
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return invokeV.longValue;
        }

        public static long k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
                try {
                    if (c()) {
                        return Environment.getExternalStorageDirectory().getTotalSpace();
                    }
                    return 0L;
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return invokeV.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(185049101, "Lc/b/c/b/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(185049101, "Lc/b/c/b/l;");
        }
    }

    public static synchronized void a(@NonNull Context context, @NonNull c.b.c.b.g gVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, gVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (l.class) {
                b(context, gVar, z, false, z2);
            }
        }
    }

    public static synchronized void b(@NonNull Context context, @NonNull c.b.c.b.g gVar, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, gVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            synchronized (l.class) {
                c(context, gVar, z, z, z2, z3);
            }
        }
    }

    public static synchronized void c(@NonNull Context context, @NonNull c.b.c.b.g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, gVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            synchronized (l.class) {
                if (f31607a) {
                    return;
                }
                if (context == null) {
                    throw new IllegalArgumentException("context must be not null.");
                }
                if (gVar != null) {
                    if (!(context instanceof Application)) {
                        context = context.getApplicationContext();
                    }
                    if (b.j(context)) {
                        return;
                    }
                    c.b.c.b.m.b(context, gVar);
                    c.b.c.b.h.a.e.d(context);
                    if (z || z2) {
                        c.b.c.b.f.a a2 = c.b.c.b.f.a.a();
                        if (z) {
                            a2.c(new c.b.c.b.f.c(context));
                        }
                    }
                    f31607a = true;
                    c.b.c.b.h.i.b().post(new a(context, z4));
                    return;
                }
                throw new IllegalArgumentException("params must be not null.");
            }
        }
    }

    public static void d(c.b.c.b.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, kVar) == null) {
            c.b.c.b.m.c().c(kVar);
        }
    }

    public static void e(Map<? extends String, ? extends String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        c.b.c.b.m.c().d(map);
    }
}
