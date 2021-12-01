package c.a.p0.a.z2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/* loaded from: classes.dex */
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f9159b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f9160c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f9161d;

    /* renamed from: e  reason: collision with root package name */
    public static String f9162e;

    /* renamed from: f  reason: collision with root package name */
    public static String f9163f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(136589073, "Lc/a/p0/a/z2/f0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(136589073, "Lc/a/p0/a/z2/f0;");
                return;
            }
        }
        a = c.a.p0.a.k.a;
        f9159b = c.a.p0.a.z2.c1.a.f9129b;
        f9160c = c.a.p0.a.z2.c1.a.f9130c;
        f9161d = false;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String str2 = f9162e;
            if (str2 != null) {
                return str2.equals(str);
            }
            String g2 = g("ro.miui.ui.version.name");
            f9163f = g2;
            if (!TextUtils.isEmpty(g2)) {
                f9162e = "MIUI";
            } else {
                String g3 = g("ro.build.version.emui");
                f9163f = g3;
                if (!TextUtils.isEmpty(g3)) {
                    f9162e = "EMUI";
                } else {
                    String g4 = g(f9160c);
                    f9163f = g4;
                    if (!TextUtils.isEmpty(g4)) {
                        f9162e = f9159b;
                    } else {
                        String g5 = g("ro.vivo.os.version");
                        f9163f = g5;
                        if (!TextUtils.isEmpty(g5)) {
                            f9162e = "VIVO";
                        } else {
                            String g6 = g("ro.smartisan.version");
                            f9163f = g6;
                            if (!TextUtils.isEmpty(g6)) {
                                f9162e = "SMARTISAN";
                            } else {
                                String g7 = g(RomUtils.KEY_VERSION_GIONEE);
                                f9163f = g7;
                                if (!TextUtils.isEmpty(g7)) {
                                    f9162e = "SMARTISAN";
                                } else {
                                    String g8 = g(RomUtils.KEY_VERSION_NUBIA);
                                    f9163f = g8;
                                    if (!TextUtils.isEmpty(g8)) {
                                        f9162e = RomUtils.ROM_NUBIA;
                                    } else {
                                        String str3 = Build.DISPLAY;
                                        f9163f = str3;
                                        if (str3.toUpperCase().contains("FLYME")) {
                                            f9162e = "FLYME";
                                        } else {
                                            f9163f = "unknown";
                                            f9162e = Build.MANUFACTURER.toUpperCase();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return f9162e.equals(str);
        }
        return invokeL.booleanValue;
    }

    public static int b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            DisplayCutout c2 = c(activity);
            if (c2 == null || Build.VERSION.SDK_INT < 28) {
                return 0;
            }
            List<Rect> boundingRects = c2.getBoundingRects();
            return boundingRects.get(0).right - boundingRects.get(0).left;
        }
        return invokeL.intValue;
    }

    public static DisplayCutout c(Activity activity) {
        InterceptResult invokeL;
        View decorView;
        WindowInsets rootWindowInsets;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            if (activity == null || activity.getWindow() == null || Build.VERSION.SDK_INT < 28 || (decorView = activity.getWindow().getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
                return null;
            }
            return rootWindowInsets.getDisplayCutout();
        }
        return (DisplayCutout) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f9161d : invokeV.booleanValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 26) {
                return 0;
            }
            if (i2 >= 28) {
                return f();
            }
            if (h(context)) {
                if (n()) {
                    Resources resources = context.getResources();
                    try {
                        int identifier = resources.getIdentifier("notch_height", "dimen", "android");
                        if (identifier > 0) {
                            return resources.getDimensionPixelSize(identifier);
                        }
                    } catch (Exception unused) {
                        return 0;
                    }
                }
                if (m()) {
                    try {
                        Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                        return ((int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]))[1];
                    } catch (Exception unused2) {
                        return 0;
                    }
                } else if (o()) {
                    return 80;
                } else {
                    if (r()) {
                        return n0.g(32.0f);
                    }
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @RequiresApi(28)
    public static int f() {
        InterceptResult invokeV;
        DisplayCutout displayCutout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            int i2 = 0;
            if (c.a.p0.a.d2.e.L() != null && c.a.p0.a.d2.e.L().getActivity() != null) {
                try {
                    WindowInsets rootWindowInsets = c.a.p0.a.d2.e.L().getActivity().getWindow().getDecorView().getRootWindowInsets();
                    if (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                        return 0;
                    }
                    i2 = displayCutout.getSafeInsetTop();
                    if (a) {
                        String str = "刘海屏高度:" + i2;
                    }
                } catch (Exception unused) {
                    boolean z = a;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        Closeable closeable = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    c.a.p0.w.d.d(bufferedReader);
                    return readLine;
                } catch (IOException unused) {
                    if (a) {
                        String str2 = "Unable to read prop " + str;
                    }
                    c.a.p0.w.d.d(bufferedReader);
                    c.a.p0.w.d.d(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable = 65543;
                c.a.p0.w.d.d(closeable);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            c.a.p0.w.d.d(closeable);
            throw th;
        }
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (m()) {
                return i(context);
            }
            if (r()) {
                return l(context);
            }
            if (o()) {
                return k(context);
            }
            if (n()) {
                return j(context);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean i(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
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

    @SuppressLint({"PrivateApi"})
    public static boolean j(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
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

    public static boolean k(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? context.getPackageManager().hasSystemFeature(c.a.p0.a.z2.c1.a.f9131d) : invokeL.booleanValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean l(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
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

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? a("EMUI") : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a("MIUI") : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? a(f9159b) : invokeV.booleanValue;
    }

    public static boolean p(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, activity)) == null) ? c(activity) != null : invokeL.booleanValue;
    }

    public static boolean q(Activity activity, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, activity, view)) == null) {
            DisplayCutout c2 = c(activity);
            if (c2 != null && Build.VERSION.SDK_INT >= 28) {
                List<Rect> boundingRects = c2.getBoundingRects();
                int i2 = boundingRects.get(0).left;
                int i3 = boundingRects.get(0).right;
                int i4 = boundingRects.get(0).top;
                int i5 = boundingRects.get(0).bottom;
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int width = view.getWidth();
                int height = view.getHeight();
                int i6 = iArr[0];
                int i7 = iArr[0] + width;
                int i8 = iArr[1];
                int i9 = iArr[1] + height;
                if (((i9 <= i5 && i9 > i4) || (i8 < i5 && i8 >= i4)) && ((i7 > i2 && i7 <= i3) || ((i6 >= i2 && i7 <= i3) || ((i6 >= i2 && i6 < i3) || (i6 < i2 && i7 > i3))))) {
                    f9161d = true;
                    return true;
                } else if (((i6 >= i2 && i6 < i3) || (i7 > i2 && i7 <= i3)) && ((i9 > i4 && i9 <= i5) || ((i8 >= i4 && i9 <= i5) || ((i8 >= i4 && i8 < i5) || (i8 < i4 && i9 > i5))))) {
                    f9161d = true;
                    return true;
                } else if (i6 <= i2 && i7 >= i3 && i8 <= i4 && i9 >= i5) {
                    f9161d = true;
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? a("VIVO") : invokeV.booleanValue;
    }

    public static void s(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, activity) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        activity.getWindow().setAttributes(attributes);
    }
}
