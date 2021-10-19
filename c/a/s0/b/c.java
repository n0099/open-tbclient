package c.a.s0.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Locale;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f29926a;

    /* renamed from: b  reason: collision with root package name */
    public static int f29927b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(252190609, "Lc/a/s0/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(252190609, "Lc/a/s0/b/c;");
                return;
            }
        }
        f29926a = new Object();
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append('/');
            sb.append(b(context));
            sb.append(" (Linux; U; Android ");
            sb.append(Build.VERSION.RELEASE);
            sb.append("; ");
            sb.append(Locale.getDefault().toString());
            String str = Build.MODEL;
            if (str.length() > 0) {
                sb.append("; ");
                sb.append(str);
            }
            String str2 = Build.ID;
            if (str2.length() > 0) {
                sb.append("; Build/");
                sb.append(str2);
            }
            sb.append("; TurboNet/");
            sb.append("53.0.2785.116");
            sb.append(')');
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (f29926a) {
                if (f29927b == 0) {
                    try {
                        f29927b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                    } catch (PackageManager.NameNotFoundException unused) {
                        throw new IllegalStateException("Cannot determine package version");
                    }
                }
                i2 = f29927b;
            }
            return i2;
        }
        return invokeL.intValue;
    }
}
