package c.a.w.e.g;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import c.a.w.e.g.i;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30594a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1777728440, "Lc/a/w/e/g/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1777728440, "Lc/a/w/e/g/c;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f30594a : invokeV.booleanValue;
    }

    public static void b(boolean z, Activity activity) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65538, null, z, activity) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            i.b a2 = i.a(activity);
            a2.d(true);
            a2.c(!z);
            a2.b();
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        if (decorView != null) {
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                i2 = systemUiVisibility & (-8193);
            } else {
                if (f.a()) {
                    Window window = activity.getWindow();
                    window.addFlags(Integer.MIN_VALUE);
                    window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                }
                i2 = systemUiVisibility | 8192;
            }
            decorView.setSystemUiVisibility(i2);
        }
    }

    public static void c(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, null, activity, z) == null) || activity == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.layoutInDisplayCutoutMode = 1;
        } else {
            attributes.layoutInDisplayCutoutMode = 0;
        }
        window.setAttributes(attributes);
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? h.b(context) : invokeL.intValue;
    }

    public static void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, activity) == null) {
            f(activity, false);
            b(true, activity);
        }
    }

    public static void f(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, activity, z) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 19 || activity == null) {
                f30594a = false;
            } else if (i2 >= 23) {
                k(activity, z);
                i.b a2 = i.a(activity);
                a2.d(true);
                a2.c(true);
                a2.b();
                f30594a = true;
            } else {
                i.b a3 = i.a(activity);
                a3.d(true);
                a3.c(true);
                if (!a3.b()) {
                    f30594a = false;
                } else if (Build.VERSION.SDK_INT < 21) {
                    g(activity);
                    f30594a = true;
                } else {
                    h(activity);
                    c(activity, true);
                    f30594a = true;
                }
            }
        }
    }

    public static void g(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, activity) == null) || activity == null) {
            return;
        }
        boolean z = false;
        int i2 = -1;
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            if (field != null) {
                i2 = field.getInt(null);
                z = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (z) {
            activity.getWindow().setFlags(i2, i2);
        }
    }

    public static void h(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, activity) == null) {
            i(activity, false, false);
        }
    }

    public static void i(Activity activity, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || activity == null) {
            return;
        }
        j(activity.getWindow(), z, z2);
    }

    public static void j(Window window, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{window, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || window == null) {
            return;
        }
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS");
            Field field2 = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            Field field3 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN");
            Field field4 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_STABLE");
            Method method = window.getClass().getMethod("setStatusBarColor", Integer.TYPE);
            Method method2 = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
            if (field != null && field2 != null && field3 != null && field4 != null && method != null && method2 != null) {
                int i2 = field.getInt(null);
                int i3 = field2.getInt(null);
                int i4 = field3.getInt(null);
                int i5 = field4.getInt(null);
                window.clearFlags(i3);
                if (z2) {
                    Field field5 = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR");
                    if (field5 != null) {
                        window.getDecorView().setSystemUiVisibility(field5.getInt(null) | i4);
                    }
                } else {
                    method2.invoke(window.getDecorView(), Integer.valueOf(i4 | i5));
                }
                window.addFlags(i2);
                method.invoke(window, 0);
                if (z) {
                    Field field6 = WindowManager.LayoutParams.class.getField("FLAG_FULLSCREEN");
                    Method method3 = window.getClass().getMethod("setFlags", Integer.TYPE, Integer.TYPE);
                    int i6 = field6.getInt(null);
                    method3.invoke(window, Integer.valueOf(i6), Integer.valueOf(i6));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void k(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, activity, z) == null) {
            i(activity, z, true);
        }
    }
}
