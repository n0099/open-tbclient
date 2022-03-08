package c.a.p0.a.a2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e2.g.h;
import c.a.p0.a.p2.q0;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f4554b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f4555c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f4556d;

    /* renamed from: e  reason: collision with root package name */
    public static String f4557e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.p0.a.a2.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class RunnableC0227a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0227a() {
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
                    e.a();
                }
            }
        }

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                ExecutorUtilsExt.postOnElastic(new RunnableC0227a(), "V8SoCleaner", 3);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(812602045, "Lc/a/p0/a/a2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(812602045, "Lc/a/p0/a/a2/e;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f4554b = c.a.p0.a.q0.d.g() + "/v8_so/";
        f4555c = c.a.p0.a.s0.a.e0().b();
        f4556d = c.a.p0.a.s0.a.e0().a();
        f4557e = null;
    }

    public static void a() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            File file = new File(f4554b);
            if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
                return;
            }
            String D = q0.D();
            for (File file2 : listFiles) {
                if (!TextUtils.equals(file2.getName(), D)) {
                    c.a.p0.w.d.L(file2);
                }
            }
        }
    }

    @NonNull
    public static ArrayList<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("v8.engine");
            arrayList.add("zeusv8");
            if (f4555c) {
                arrayList.add("com.baidu.zeus");
            }
            String[] strArr = f4556d;
            if (strArr != null && strArr.length != 0) {
                arrayList.addAll(Arrays.asList(strArr));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "v8.engine" : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f4555c) {
                return f4557e;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"BDSoLoader"})
    public static boolean e(@Nullable String str, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, soLoader)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                System.loadLibrary(str);
                return true;
            } catch (Throwable th) {
                soLoader.appendErrorLog("loadLibsSo: " + th.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode", "BDSoLoader"})
    public static boolean f(@Nullable String str, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, soLoader)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                System.load(str);
                return true;
            } catch (Throwable th) {
                soLoader.appendErrorLog("loadSoByPath: " + th.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(@NonNull Context context, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, soLoader)) == null) {
            if (f4555c) {
                File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, "com.baidu.zeus");
                if (findSoFilesInLibrary == null || findSoFilesInLibrary.length() == 0) {
                    return false;
                }
                f4557e = findSoFilesInLibrary.getAbsolutePath();
                m("loadV8EngineSo: v8 dependentFile:" + f4557e);
            }
            return l(null, soLoader) && e("v8.engine", soLoader);
        }
        return invokeLL.booleanValue;
    }

    public static f h(@NonNull Context context, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, soLoader)) == null) {
            if (g(context, soLoader)) {
                m("loadV8EngineBySystemMethod:success.");
                return f.e();
            }
            f k = k(context, soLoader);
            if (k.b()) {
                m("loadV8EngineSoWithSystemPath:success.");
                return k;
            }
            f j2 = j(context, soLoader);
            if (!j2.b()) {
                SoUtils.onEvent("26", soLoader.getErrorLog());
            } else {
                m("loadV8EngineSoWithCustomPath:success.");
            }
            return j2;
        }
        return (f) invokeLL.objValue;
    }

    public static f i(@NonNull HashMap<String, String> hashMap, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, hashMap, soLoader)) == null) {
            m("loadV8EngineSoByMap:" + hashMap);
            String str = hashMap.get("com.baidu.zeus");
            boolean z = false;
            if (f4555c && str == null) {
                return f.d(false, false);
            }
            boolean f2 = f(hashMap.get("zeusv8"), soLoader);
            boolean l = l(hashMap, soLoader);
            boolean f3 = f(hashMap.get("v8.engine"), soLoader);
            if (f3) {
                f4557e = str;
            }
            if (l && f3) {
                z = true;
            }
            return f.d(f2, z);
        }
        return (f) invokeLL.objValue;
    }

    public static f j(@NonNull Context context, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, soLoader)) == null) {
            f4557e = null;
            HashMap hashMap = new HashMap();
            String D = q0.D();
            File file = new File(f4554b, D);
            Iterator<String> it = b().iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                File file2 = new File(file, SoUtils.getFullName(next));
                hashMap.put(next, (!file2.exists() || file2.length() == 0) ? false : false ? file2.getAbsolutePath() : null);
            }
            if (!hashMap.containsValue(null)) {
                return i(hashMap, soLoader);
            }
            String str = "swan_v8so_unzip_times_" + D;
            int i2 = h.a().getInt(str, 0);
            if (i2 >= 3) {
                soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:reach max unzip times.");
                return k(context, soLoader);
            }
            h.a().putInt(str, i2 + 1);
            String str2 = "lib" + File.separator + SoUtils.getCurrentCpuAbi();
            ZipFile apkZipFile = soLoader.getApkZipFile(context);
            try {
                if (apkZipFile == null) {
                    soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:zipFile is null.");
                    return k(context, soLoader);
                }
                try {
                    for (String str3 : hashMap.keySet()) {
                        if (hashMap.get(str3) == null) {
                            String fullName = SoUtils.getFullName(str3);
                            File file3 = new File(file, fullName);
                            if (soLoader.executeRelease(apkZipFile, fullName, str2, file3)) {
                                hashMap.put(str3, file3.getAbsolutePath());
                            }
                        }
                    }
                } catch (Exception e2) {
                    soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:" + e2.getMessage());
                    if (a) {
                        String str4 = "loadV8EngineSoWithCustomPath:" + e2;
                    }
                }
                return i(hashMap, soLoader);
            } finally {
                c.a.p0.w.d.d(apkZipFile);
            }
        }
        return (f) invokeLL.objValue;
    }

    public static f k(@NonNull Context context, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, soLoader)) == null) {
            f4557e = null;
            HashMap hashMap = new HashMap();
            Iterator<String> it = b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, next);
                hashMap.put(next, findSoFilesInLibrary != null && findSoFilesInLibrary.exists() && (findSoFilesInLibrary.length() > 0L ? 1 : (findSoFilesInLibrary.length() == 0L ? 0 : -1)) != 0 ? findSoFilesInLibrary.getAbsolutePath() : null);
            }
            return i(hashMap, soLoader);
        }
        return (f) invokeLL.objValue;
    }

    public static boolean l(@Nullable HashMap<String, String> hashMap, @NonNull SoLoader soLoader) {
        InterceptResult invokeLL;
        boolean f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, hashMap, soLoader)) == null) {
            String[] strArr = f4556d;
            boolean z = true;
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    if (hashMap == null) {
                        f2 = e(str, soLoader);
                    } else {
                        f2 = f(hashMap.get(str), soLoader);
                    }
                    if (!f2) {
                        z = false;
                    }
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            boolean z = a;
        }
    }
}
