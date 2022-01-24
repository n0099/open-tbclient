package c.a.r0.a.c2.b.f;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import com.baidu.android.util.devices.RomUtils;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f5624b;

    /* renamed from: c  reason: collision with root package name */
    public static String f5625c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.setAlpha(0.2f);
                    return false;
                } else if (action != 2) {
                    view.setAlpha(1.0f);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-712403916, "Lc/a/r0/a/c2/b/f/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-712403916, "Lc/a/r0/a/c2/b/f/d;");
                return;
            }
        }
        a = k.a;
        String str = c.a.r0.a.z2.c1.a.f10092c;
        f5624b = null;
        f5625c = null;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Build.FINGERPRINT.contains("Flyme") || Pattern.compile("Flyme", 2).matcher(Build.DISPLAY).find() : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f5624b == null) {
                f5624b = f("ro.miui.ui.version.name");
            }
            if (a) {
                String str = "OsName = " + f5624b;
            }
            return !TextUtils.isEmpty(f5624b);
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f5625c == null) {
                f5625c = f(RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL);
            }
            if (a) {
                String str = "sMiuiVersion = " + f5625c;
            }
            if (!TextUtils.isEmpty(f5625c) && (split = f5625c.split(".")) != null && split.length >= 1 && split[0].length() >= 2) {
                String substring = split[0].substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    try {
                        if (Integer.parseInt(substring) < 9) {
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.VERSION.SDK_INT >= 25 : invokeV.booleanValue;
    }

    public static Object e(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        InterceptResult invokeLL;
        Field declaredField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, obj, str)) == null) {
            if (obj == null || (declaredField = obj.getClass().getDeclaredField(str)) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
        return invokeLL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec("getprop " + str).getInputStream()), 1024);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException unused) {
            }
            try {
                String readLine = bufferedReader.readLine();
                c.a.r0.w.d.d(bufferedReader);
                return readLine == null ? "" : readLine;
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
                c.a.r0.w.d.d(bufferedReader2);
                c.a.r0.w.d.d(bufferedReader2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                c.a.r0.w.d.d(bufferedReader2);
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context != null && Build.VERSION.SDK_INT >= 19) {
                try {
                    Object systemService = context.getSystemService("appops");
                    if (systemService == null || (method = systemService.getClass().getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class)) == null) {
                        return false;
                    }
                    return ((Integer) method.invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && a) {
            Log.getStackTraceString(new Throwable(str));
        }
    }

    public static void i(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, view) == null) || view == null) {
            return;
        }
        view.setOnTouchListener(new a());
    }

    public static void j(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, drawable) == null) || drawable == null) {
            return;
        }
        drawable.setColorFilter(c.a.r0.a.c1.a.c().getResources().getColor(c.a.r0.a.c.aiapps_ui_cover_layer_color), PorterDuff.Mode.SRC_ATOP);
    }

    public static void k(Toast toast, @StyleRes int i2) {
        Object e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, toast, i2) == null) {
            try {
                Object e3 = e(toast, "mTN");
                if (e3 == null || (e2 = e(e3, "mParams")) == null || !(e2 instanceof WindowManager.LayoutParams)) {
                    return;
                }
                ((WindowManager.LayoutParams) e2).windowAnimations = i2;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) ? a() && !g(context) && Build.VERSION.SDK_INT >= 23 : invokeL.booleanValue;
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (b()) {
                return (c() && g(context)) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            return (m(context) || d()) || l(context);
        }
        return invokeL.booleanValue;
    }
}
