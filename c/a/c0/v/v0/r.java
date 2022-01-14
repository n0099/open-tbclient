package c.a.c0.v.v0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.g0.f;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static int f2535b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2536c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(549353193, "Lc/a/c0/v/v0/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(549353193, "Lc/a/c0/v/v0/r;");
                return;
            }
        }
        a = c.a.c0.v.d.f();
        f2535b = -1;
        f2536c = c.a.c0.h0.a.d.b.a(15.0f);
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String c2 = c.a.c0.g0.m.c();
            if (TextUtils.equals(c2, "EMUI") && b(context)) {
                return 1;
            }
            if (TextUtils.equals(c2, "MIUI") && e(context)) {
                return 1;
            }
            if (TextUtils.equals(c2, "OPPO") && c(context)) {
                return 1;
            }
            return ((TextUtils.equals(c2, "VIVO") && d(context)) || "ONEPLUS A6000".equals(Build.MODEL)) ? 1 : 0;
        }
        return invokeL.intValue;
    }

    public static boolean b(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism") : invokeL.booleanValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() == 1;
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String[] strArr = {"RLI-AN00", "RLI-N29", "TAH-AN00", "TAH-N29", "TAH-AN00m", "RHA-AN00m"};
            if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
                for (int i2 = 0; i2 < 6; i2++) {
                    if (strArr[i2].equalsIgnoreCase(Build.MODEL)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (a) {
                c.a.c0.i.a.e("VideoNotchUtils", "isNotch start");
            }
            if (f2535b == -1) {
                if (Build.VERSION.SDK_INT < 24) {
                    f2535b = 0;
                } else if (f2535b == -1) {
                    f2535b = a(context);
                    c.a.c0.i.a.e("VideoNotchUtils", "isNotch from getNotchState");
                }
            }
            if (a) {
                c.a.c0.i.a.e("VideoNotchUtils", "isNotch end");
            }
            return f2535b == 1;
        }
        return invokeL.booleanValue;
    }

    public static void h(@NonNull c.a.c0.v.j0.o oVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, oVar) == null) && oVar.getContentView() != null && (oVar.getContentView() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) oVar.getContentView();
            viewGroup.setPadding(0, 0, 0, 0);
            viewGroup.setLayoutParams(viewGroup.getLayoutParams());
        }
    }

    public static void i(@NonNull c.a.c0.v.j0.o oVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, oVar) == null) && g(c.a.c0.h.a.b())) {
            h(oVar);
        }
    }

    public static void j(@NonNull c.a.c0.v.j0.o oVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65546, null, oVar, i2, i3) == null) {
            int max = Math.max(i2, f2536c);
            int max2 = Math.max(i3, f2536c);
            if (oVar.getContentView() == null || !(oVar.getContentView() instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) oVar.getContentView();
            viewGroup.setPadding(max, 0, max2, 0);
            viewGroup.setLayoutParams(viewGroup.getLayoutParams());
        }
    }

    public static void k(@NonNull c.a.c0.v.j0.o oVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, oVar) == null) && g(c.a.c0.h.a.b())) {
            j(oVar, f.c.g(), f.c.g());
        }
    }
}
