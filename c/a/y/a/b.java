package c.a.y.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.y.a.a.a;
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
    public static Object f30799a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f30800b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f30801c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f30802d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f30803e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f30804f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-927950013, "Lc/a/y/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-927950013, "Lc/a/y/a/b;");
                return;
            }
        }
        try {
            f30799a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f30800b = a.a(cls, "doInit", Context.class, String[].class);
            f30802d = a.a(cls, "setStatisticParam", String.class);
            f30801c = a.a(cls, "setEnabled", Boolean.TYPE);
            f30803e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f30804f = true;
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
                if (f30804f) {
                    f30800b.invoke(f30799a, context, strArr);
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
                if (f30804f) {
                    f30802d.invoke(f30799a, str);
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
                if (f30804f) {
                    f30803e.invoke(f30799a, str, str2);
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
                if (f30804f) {
                    f30801c.invoke(f30799a, Boolean.valueOf(z));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f30804f : invokeV.booleanValue;
    }
}
