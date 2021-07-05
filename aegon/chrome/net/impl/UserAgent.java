package aegon.chrome.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Locale;
/* loaded from: classes.dex */
public final class UserAgent {
    public static /* synthetic */ Interceptable $ic;
    public static final Object sLock;
    public static int sVersionCode;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2008054270, "Laegon/chrome/net/impl/UserAgent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2008054270, "Laegon/chrome/net/impl/UserAgent;");
                return;
            }
        }
        sLock = new Object();
    }

    public static String from(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append('/');
            sb.append(versionFromContext(context));
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
            sb.append(";");
            sb.append(" Cronet/");
            sb.append("77.0.3865.0");
            sb.append(')');
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getQuicUserAgentIdFrom(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return context.getPackageName() + " Cronet/77.0.3865.0";
        }
        return (String) invokeL.objValue;
    }

    public static int versionFromContext(Context context) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (sLock) {
                if (sVersionCode == 0) {
                    try {
                        sVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                    } catch (PackageManager.NameNotFoundException unused) {
                        throw new IllegalStateException("Cannot determine package version");
                    }
                }
                i2 = sVersionCode;
            }
            return i2;
        }
        return invokeL.intValue;
    }
}
