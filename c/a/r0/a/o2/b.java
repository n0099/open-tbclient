package c.a.r0.a.o2;

import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import c.a.r0.a.d2.e;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.k;
import c.a.r0.w.f;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f8051b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f8052c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-975275953, "Lc/a/r0/a/o2/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-975275953, "Lc/a/r0/a/o2/b$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(432504236, "Lc/a/r0/a/o2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(432504236, "Lc/a/r0/a/o2/b;");
                return;
            }
        }
        a = k.a;
        f8051b = "/aiapp";
        f8052c = new HashSet(Arrays.asList("extension_core", "js_native", "swan_core"));
    }

    public static File A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new File(p(), "swan_plugin_workspace") : (File) invokeV.objValue;
    }

    @NonNull
    public static File B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new File(c.a.r0.a.o2.h.c.e()) : (File) invokeV.objValue;
    }

    @Nullable
    public static String C(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            e L = e.L();
            if (L == null) {
                return null;
            }
            String d2 = L.M() != null ? L.M().d() : "";
            if (!TextUtils.isEmpty(d2)) {
                String d3 = f.d(d2.getBytes(), false);
                if (D(str + f8051b + File.separator + d3)) {
                    boolean z = a;
                    return d3;
                }
            }
            String i2 = c.a.r0.a.c1.a.h0().i(AppRuntime.getAppContext());
            if (!TextUtils.isEmpty(i2)) {
                i2 = i2.replace("|", "");
            }
            return f.d(i2.getBytes(), false);
        }
        return (String) invokeL.objValue;
    }

    public static boolean D(String str) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (TextUtils.isEmpty(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length <= 0) ? false : true : invokeL.booleanValue;
    }

    public static boolean E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            PathType s = s(str);
            return s == PathType.BD_FILE || s == PathType.RELATIVE;
        }
        return invokeL.booleanValue;
    }

    public static boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? !TextUtils.isEmpty(str) && str.startsWith("bdfile://tmp_") : invokeL.booleanValue;
    }

    public static boolean G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !TextUtils.isEmpty(str) && (str.startsWith("bdfile://usr/") || TextUtils.equals(str, c.a.r0.a.r0.a.USER_DATA_PATH)) : invokeL.booleanValue;
    }

    public static String H(String str, @NonNull e eVar) {
        InterceptResult invokeLL;
        String M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, eVar)) == null) {
            int i2 = a.a[s(str).ordinal()];
            if (i2 != 1) {
                M = i2 != 2 ? str : L(str, eVar, eVar.j0());
            } else {
                M = M(str, eVar.f5537f);
            }
            return M == null ? str : M;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static String I(String str, String str2) {
        InterceptResult invokeLL;
        String replace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (a) {
                    String str3 = "——> path2Scheme: path " + str + " swanAppId " + str2;
                }
                String v = v(str2);
                String x = x(str2);
                String z = z(str2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(WebGLImageLoader.BDFILE);
                if (!TextUtils.isEmpty(x) && str.startsWith(x)) {
                    replace = str.replace(x, "");
                    stringBuffer.append("tmp_");
                } else if (!TextUtils.isEmpty(v) && str.startsWith(v)) {
                    replace = str.replace(v, "");
                    stringBuffer.append("store_");
                } else if (!TextUtils.isEmpty(z) && str.startsWith(z)) {
                    return "bdfile://usr/" + str.replace(z + File.separator, "");
                }
                if (a) {
                    String str4 = "——> path2Scheme: relative path " + replace;
                }
                if (TextUtils.isEmpty(replace)) {
                    return null;
                }
                stringBuffer.append(new String(Base64.encode(replace.getBytes(), 10)));
                if (a) {
                    String str5 = "——> path2Scheme: url " + ((Object) stringBuffer);
                }
                return stringBuffer.toString();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static String J(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            String I = I(str, str2);
            String r = c.a.r0.w.d.r(c.a.r0.w.d.s(str));
            if (I != null && !I.contains(".") && r != null) {
                I = I + "." + r;
            }
            if (a) {
                String str3 = "path2SchemeWithExt: url" + I;
            }
            return I;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static String K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (file.exists()) {
                String replace = str.replace("//", "/");
                if (replace.startsWith("/")) {
                    return file.getAbsolutePath() + replace;
                }
                if (replace.startsWith("./")) {
                    replace = replace.replace("./", "");
                }
                return file.getAbsolutePath() + File.separator + replace;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String L(String str, e eVar, String str2) {
        InterceptResult invokeLLL;
        File i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, str, eVar, str2)) == null) {
            if (eVar != null && !c.a.r0.w.d.x(str)) {
                b.a X = eVar.X();
                boolean z = X != null && X.n0();
                if (a && z) {
                    String str3 = "relative path : " + str;
                    i2 = d.b.e();
                } else if (!TextUtils.isEmpty(eVar.f5537f) && !TextUtils.isEmpty(str2) && s(str) == PathType.RELATIVE) {
                    i2 = d.e.i(eVar.f5537f, str2);
                }
                if (i2.exists()) {
                    String replace = str.replace("//", "/");
                    if (replace.startsWith("/")) {
                        return i2.getAbsolutePath() + replace;
                    }
                    if (replace.startsWith("./")) {
                        replace = replace.replace("./", "");
                    }
                    return i2.getAbsolutePath() + File.separator + replace;
                }
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    @Nullable
    public static String M(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (G(str)) {
                    return N(str, str2);
                }
                Uri parse = Uri.parse(str);
                if (parse == null) {
                    return null;
                }
                String host = parse.getHost();
                if (a) {
                    String str4 = "——> getFileStorePathFromScheme: uri " + str + "  host " + host;
                }
                if (TextUtils.isEmpty(host)) {
                    return null;
                }
                StringBuffer stringBuffer = new StringBuffer();
                if (host.startsWith("tmp_")) {
                    str3 = host.replace("tmp_", "");
                    int indexOf = str3.indexOf(".");
                    if (indexOf > 0) {
                        str3 = str3.substring(0, indexOf);
                    }
                    String x = x(str2);
                    if (TextUtils.isEmpty(x)) {
                        return null;
                    }
                    stringBuffer.append(x);
                } else if (host.startsWith("store_")) {
                    str3 = host.replace("store_", "");
                    int indexOf2 = str3.indexOf(".");
                    if (indexOf2 > 0) {
                        str3 = str3.substring(0, indexOf2);
                    }
                    String v = v(str2);
                    if (TextUtils.isEmpty(v)) {
                        return null;
                    }
                    stringBuffer.append(v);
                } else {
                    str3 = null;
                }
                if (TextUtils.isEmpty(str3)) {
                    return null;
                }
                try {
                    String str5 = new String(Base64.decode(str3, 10));
                    if (c.a.r0.w.d.x(str5)) {
                        return null;
                    }
                    stringBuffer.append(str5);
                    if (a) {
                        String str6 = "——> scheme2Path: encodePath " + str3;
                        String str7 = "——> scheme2Path:  path " + stringBuffer.toString();
                    }
                    return stringBuffer.toString();
                } catch (IllegalArgumentException e2) {
                    if (a) {
                        String str8 = "——> scheme2Path: IllegalArgumentException " + e2.getMessage();
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static String N(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        String z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            String replace = TextUtils.equals(str, c.a.r0.a.r0.a.USER_DATA_PATH) ? "" : str.replace("bdfile://usr/", "");
            if (c.a.r0.w.d.x(replace) || (z = z(str2)) == null) {
                return null;
            }
            return z + File.separator + replace;
        }
        return (String) invokeLL.objValue;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            Map<String, PMSAppInfo> v = c.a.r0.q.g.a.i().v();
            if (v.isEmpty()) {
                return 0L;
            }
            return c.a.r0.w.d.c(o(), v.keySet());
        }
        return invokeV.longValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? (int) (a() / 1024) : invokeV.intValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? c.a.r0.w.d.a(q()) : invokeV.longValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? c.a.r0.w.d.a(r()) : invokeV.longValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? c() + h() : invokeV.longValue;
    }

    public static long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? c.a.r0.w.d.b(B(), "aiapp_", "aiapp_setting_") : invokeV.longValue;
    }

    public static long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? c.a.r0.w.d.c(o(), f8052c) : invokeV.longValue;
    }

    public static long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? c.a.r0.w.d.b(B(), "aiapp_setting_", null) : invokeV.longValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return (int) ((((g() + l()) + e()) + j()) / 1024);
        }
        return invokeV.intValue;
    }

    public static long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? c.a.r0.w.d.a(A()) : invokeV.longValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? (int) ((f() + d()) / 1024) : invokeV.intValue;
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? c.a.r0.w.d.a(new File(p(), "ubcdir")) : invokeV.longValue;
    }

    public static boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        }
        return invokeL.booleanValue;
    }

    public static String n(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65564, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return "";
            }
            if (!TextUtils.isEmpty(str3)) {
                return x(str) + File.separator + str2 + ("." + str3);
            }
            return x(str) + File.separator + str2;
        }
        return (String) invokeLLL.objValue;
    }

    @NonNull
    public static File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? new File(p(), "aiapps_folder") : (File) invokeV.objValue;
    }

    public static File p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? AppRuntime.getAppContext().getFilesDir() : (File) invokeV.objValue;
    }

    @NonNull
    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? new File(o(), "cloud_config") : (File) invokeV.objValue;
    }

    @Nullable
    public static File r() {
        InterceptResult invokeV;
        File externalFilesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
                return null;
            }
            return new File(externalFilesDir, "aiapp" + File.separator + "usr");
        }
        return (File) invokeV.objValue;
    }

    public static PathType s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return PathType.ERROR;
            }
            String str2 = null;
            try {
                str2 = new URI(str).getScheme();
            } catch (URISyntaxException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return PathType.RELATIVE;
            }
            if (TextUtils.equals(str2, "bdfile")) {
                return PathType.BD_FILE;
            }
            if (!TextUtils.equals(str2, "http") && !TextUtils.equals(str2, "https")) {
                if (TextUtils.equals(str2, "cloud")) {
                    return PathType.CLOUD;
                }
                return PathType.ERROR;
            }
            return PathType.NETWORK;
        }
        return (PathType) invokeL.objValue;
    }

    public static String t(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, eVar)) == null) {
            b.a X = eVar.X();
            if (X != null && !TextUtils.isEmpty(X.I()) && X.getType() == 1) {
                return X.I() + "_dev";
            }
            return eVar.f5537f;
        }
        return (String) invokeL.objValue;
    }

    public static String u(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65571, null, str, i2)) == null) {
            String str2 = "aiapp_setting_" + str;
            if (i2 == 1) {
                return str2 + "_dev";
            }
            return str2;
        }
        return (String) invokeLI.objValue;
    }

    public static String v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
            try {
                if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str)) {
                    return null;
                }
                if (a) {
                    String str2 = "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null);
                }
                String str3 = AppRuntime.getAppContext().getExternalFilesDir(null) + f8051b + "/store" + File.separator + "aiapp_" + str;
                m(str3);
                return str3;
            } catch (Exception e2) {
                if (a) {
                    Log.getStackTraceString(e2);
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (a) {
                    r0 = "——> getSwanAppStoreDirectory: " + AppRuntime.getAppContext().getExternalFilesDir(null);
                }
                return AppRuntime.getAppContext().getExternalFilesDir(null) + f8051b;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (a) {
                String str2 = "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir();
            }
            String str3 = AppRuntime.getAppContext().getExternalCacheDir() + f8051b + "/tmp" + File.separator + "aiapp_" + str;
            m(str3);
            return str3;
        }
        return (String) invokeL.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            if (a) {
                r0 = "——> getSwanAppTmpDirectory: " + AppRuntime.getAppContext().getExternalCacheDir();
            }
            return AppRuntime.getAppContext().getExternalCacheDir() + f8051b;
        }
        return (String) invokeV.objValue;
    }

    public static String z(String str) {
        InterceptResult invokeL;
        File externalFilesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            if (!Environment.getExternalStorageState().equals("mounted") || TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null)) == null) {
                return null;
            }
            String absolutePath = externalFilesDir.getAbsolutePath();
            if (a) {
                r0 = "——> getSwanAppStoreDirectory: " + absolutePath;
            }
            String C = C(absolutePath);
            if (C == null) {
                return null;
            }
            String str2 = absolutePath + f8051b + "/usr" + File.separator + C + File.separator + "aiapp_" + str;
            m(str2);
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
