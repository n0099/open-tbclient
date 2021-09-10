package c.a.z.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.z.a.a.a;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f31245a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f31246b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f31247c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f31248d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f31249e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f31250f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-899320862, "Lc/a/z/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-899320862, "Lc/a/z/a/b;");
                return;
            }
        }
        try {
            f31245a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f31246b = a.a(cls, "doInit", Context.class, String[].class);
            f31248d = a.a(cls, "setStatisticParam", String.class);
            f31247c = a.a(cls, "setEnabled", Boolean.TYPE);
            f31249e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f31250f = true;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, strArr) == null) {
            try {
                if (f31250f) {
                    f31246b.invoke(f31245a, context, strArr);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            try {
                if (f31250f) {
                    f31248d.invoke(f31245a, str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            try {
                if (f31250f) {
                    f31249e.invoke(f31245a, str, str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            try {
                if (f31250f) {
                    f31247c.invoke(f31245a, Boolean.valueOf(z));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f31250f : invokeV.booleanValue;
    }
}
