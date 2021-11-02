package b.a.q0.j0;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ArrayList<String> f12662a;

    /* renamed from: b  reason: collision with root package name */
    public static String f12663b;

    /* renamed from: c  reason: collision with root package name */
    public static String f12664c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f12665d;

    /* renamed from: e  reason: collision with root package name */
    public static String f12666e;

    /* renamed from: f  reason: collision with root package name */
    public static String f12667f;

    /* renamed from: g  reason: collision with root package name */
    public static String f12668g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-84392427, "Lb/a/q0/j0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-84392427, "Lb/a/q0/j0/f;");
                return;
            }
        }
        f12662a = new ArrayList<>();
        f12665d = false;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!f12665d) {
                r(context);
            }
            return f12665d;
        }
        return invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f12666e : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f12663b == null) {
                f12663b = d(TbadkCoreApplication.getInst().getApp());
            }
            return f12663b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f12667f : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f12668g : (String) invokeV.objValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            String packageName = TbadkCoreApplication.getInst().getPackageName();
            String str = packageName + ":swan";
            f12664c = str;
            f12662a.clear();
            f12662a.add(packageName);
            f12662a.add(packageName + ":remote");
            f12662a.add(packageName + ":cdnTachometer");
            f12662a.add(packageName + ":daemon");
            f12662a.add(packageName + ":third");
            f12662a.add(packageName + ":pluginInstaller");
            f12662a.add(packageName + ":xiaoying");
            f12662a.add(packageName + ":media");
            f12662a.add(packageName + ":kmyas__");
            f12662a.add(packageName + ":guardService");
            f12662a.add(packageName + ":warkup");
            f12662a.add(str);
            f12662a.add(packageName + ":bdservice_v1");
            f12662a.add(packageName + ":live");
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
            Iterator<String> it = f12662a.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next()) || str.toLowerCase().startsWith(f12664c)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f12665d : invokeV.booleanValue;
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
            f12666e = str;
        }
    }

    public static void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            f12665d = z;
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            f12667f = str;
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            f12668g = str;
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
