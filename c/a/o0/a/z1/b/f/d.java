package c.a.o0.a.z1.b.f;

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
import c.a.o0.a.k;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10030a;

    /* renamed from: b  reason: collision with root package name */
    public static String f10031b;

    /* renamed from: c  reason: collision with root package name */
    public static String f10032c;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(439681935, "Lc/a/o0/a/z1/b/f/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(439681935, "Lc/a/o0/a/z1/b/f/d;");
                return;
            }
        }
        f10030a = k.f7049a;
        f10031b = null;
        f10032c = null;
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
            if (f10031b == null) {
                f10031b = f("ro.miui.ui.version.name");
            }
            if (f10030a) {
                String str = "OsName = " + f10031b;
            }
            return !TextUtils.isEmpty(f10031b);
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f10032c == null) {
                f10032c = f(RomUtils.PROP_RO_BUILD_VERSION_INCREMENTAL);
            }
            if (f10030a) {
                String str = "sMiuiVersion = " + f10032c;
            }
            if (!TextUtils.isEmpty(f10032c) && (split = f10032c.split(".")) != null && split.length >= 1 && split[0].length() >= 2) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, obj, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
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
                c.a.o0.t.d.d(bufferedReader);
                return readLine == null ? "" : readLine;
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
                c.a.o0.t.d.d(bufferedReader2);
                c.a.o0.t.d.d(bufferedReader2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                c.a.o0.t.d.d(bufferedReader2);
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
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && f10030a) {
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
        drawable.setColorFilter(c.a.o0.a.c1.a.b().getResources().getColor(c.a.o0.a.c.aiapps_ui_cover_layer_color), PorterDuff.Mode.SRC_ATOP);
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
