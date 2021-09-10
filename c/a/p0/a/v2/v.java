package c.a.p0.a.v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9427a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(831996513, "Lc/a/p0/a/v2/v;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(831996513, "Lc/a/p0/a/v2/v;");
                return;
            }
        }
        f9427a = c.a.p0.a.k.f7077a;
    }

    public static boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            if (activity == null || !b(activity.getIntent())) {
                return false;
            }
            try {
                f.j(activity);
            } catch (Exception unused) {
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            if (intent != null) {
                try {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        extras.isEmpty();
                        return false;
                    }
                    return false;
                } catch (Throwable unused) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Bundle bundle, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, bundle, str, z)) == null) {
            try {
                return bundle.getBoolean(str);
            } catch (Throwable unused) {
                if (f9427a) {
                    String str2 = "getBoolean failed on bundle " + bundle;
                }
                return z;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static Bundle d(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle, str)) == null) {
            try {
                return bundle.getBundle(str);
            } catch (Throwable unused) {
                if (f9427a) {
                    String str2 = "getBundle failed on bundle " + bundle;
                    return null;
                }
                return null;
            }
        }
        return (Bundle) invokeLL.objValue;
    }

    public static Bundle e(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, intent, str)) == null) {
            try {
                return intent.getBundleExtra(str);
            } catch (Throwable unused) {
                if (f9427a) {
                    String str2 = "getBundleExtra failed on intent " + intent;
                    return null;
                }
                return null;
            }
        }
        return (Bundle) invokeLL.objValue;
    }

    public static int f(Bundle bundle, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, bundle, str, i2)) == null) {
            try {
                return bundle.getInt(str);
            } catch (Throwable unused) {
                if (f9427a) {
                    String str2 = "getInt failed on bundle " + bundle;
                }
                return i2;
            }
        }
        return invokeLLI.intValue;
    }

    public static String g(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bundle, str)) == null) {
            try {
                return bundle.getString(str);
            } catch (Throwable unused) {
                if (f9427a) {
                    String str2 = "getString failed on bundle " + bundle;
                    return null;
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String h(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, intent, str)) == null) {
            try {
                return intent.getStringExtra(str);
            } catch (Throwable unused) {
                if (f9427a) {
                    String str2 = "getStringExtra failed on intent " + intent;
                    return null;
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String i(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bundle, str)) == null) {
            try {
                return bundle.getString(str);
            } catch (Throwable unused) {
                if (f9427a) {
                    String str2 = "getStringExtra failed on bundle " + bundle;
                    return null;
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
