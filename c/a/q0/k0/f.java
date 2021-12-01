package c.a.q0.k0;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static final ArrayList<String> a;

    /* renamed from: b  reason: collision with root package name */
    public static String f12361b;

    /* renamed from: c  reason: collision with root package name */
    public static String f12362c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f12363d;

    /* renamed from: e  reason: collision with root package name */
    public static String f12364e;

    /* renamed from: f  reason: collision with root package name */
    public static String f12365f;

    /* renamed from: g  reason: collision with root package name */
    public static String f12366g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(45613813, "Lc/a/q0/k0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(45613813, "Lc/a/q0/k0/f;");
                return;
            }
        }
        a = new ArrayList<>();
        f12363d = false;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!f12363d) {
                r(context);
            }
            return f12363d;
        }
        return invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f12364e : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f12361b == null) {
                f12361b = d(TbadkCoreApplication.getInst().getApp());
            }
            return f12361b;
        }
        return (String) invokeV.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return null;
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f12365f : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f12366g : (String) invokeV.objValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            String packageName = TbadkCoreApplication.getInst().getPackageName();
            String str = packageName + ":swan";
            f12362c = str;
            a.clear();
            a.add(packageName);
            a.add(packageName + ":remote");
            a.add(packageName + ":cdnTachometer");
            a.add(packageName + ":daemon");
            a.add(packageName + ":third");
            a.add(packageName + ":pluginInstaller");
            a.add(packageName + ":xiaoying");
            a.add(packageName + ":media");
            a.add(packageName + ":kmyas__");
            a.add(packageName + ":guardService");
            a.add(packageName + ":warkup");
            a.add(str);
            a.add(packageName + ":bdservice_v1");
            a.add(packageName + ":live");
            m("initProcess-->CurrentProcessName=" + c());
        }
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return str != null && str.equalsIgnoreCase(c());
        }
        return invokeL.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? j(c()) : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Iterator<String> it = a.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next()) || str.toLowerCase().startsWith(f12362c)) {
                    return true;
                }
                while (it.hasNext()) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f12363d : invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? h(TbadkCoreApplication.getInst().getPackageName()) : invokeV.booleanValue;
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65549, null, str) != null) || !TbadkCoreApplication.getInst().isDebugMode()) {
        }
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            f12364e = str;
        }
    }

    public static void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            f12363d = z;
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            f12365f = str;
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            f12366g = str;
        }
    }

    public static void r(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, context) == null) || context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
    }
}
