package c.a.r0.a.h0.m.u;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import c.a.r0.a.a1.g.a;
import c.a.r0.a.k;
import c.a.r0.q.i.h;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-35027549, "Lc/a/r0/a/h0/m/u/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-35027549, "Lc/a/r0/a/h0/m/u/b;");
                return;
            }
        }
        a = k.a;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? e(str, "swan_sub_package_zip") : (String) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? a(d.e.i(str, str2).getPath()) : (String) invokeLL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? e(str, "swan_sub_package_zip") : (String) invokeL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            File a2 = c.a.r0.a.c1.b.g().a(str, str2);
            if (a2 != null) {
                return c(a2.getPath());
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str, str2);
                if (file.exists()) {
                    return file.getPath();
                }
                if (file.mkdirs()) {
                    return file.getPath();
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean f(List<h> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return false;
            }
            return list.get(0).r;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, hVar)) == null) {
            if (hVar == null || TextUtils.isEmpty(hVar.o)) {
                return false;
            }
            return h(new File(hVar.a), new File(d.e.i(hVar.o, String.valueOf(hVar.f11638i)).getPath(), hVar.p));
        }
        return invokeL.booleanValue;
    }

    public static boolean h(File file, File file2) {
        InterceptResult invokeLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, file, file2)) == null) {
            if (file != null && file2 != null) {
                if (!file.exists()) {
                    if (a) {
                        String str = "解压分包时，ZIP包不存在 zipFile=" + file;
                    }
                    return false;
                } else if (!file2.exists() && !file2.mkdirs()) {
                    if (a) {
                        String str2 = "创建分包解压文件夹失败 unzipFolder=" + file2;
                    }
                    return false;
                } else {
                    a.c j2 = c.a.r0.a.a1.g.a.j(file);
                    int i2 = j2.f5310b;
                    if (i2 != -1) {
                        U = c.a.r0.a.a1.g.a.d(j2.a, file2, i2).a;
                    } else {
                        U = c.a.r0.w.d.U(file.getAbsolutePath(), file2.getAbsolutePath());
                    }
                    if (U) {
                        boolean z = a;
                        return true;
                    } else if (a) {
                        String str3 = "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + file2.getAbsolutePath();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
