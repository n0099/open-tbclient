package com.baidu.sofire.k;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PermissionInfo;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.ac.DeviceInfoCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q {
    public static /* synthetic */ Interceptable $ic = null;
    public static DeviceInfoCallback a = null;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = true;
    public static boolean g;
    public static boolean h;
    public static long i;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(JSONObject jSONObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, jSONObject) == null) {
            if (jSONObject.optInt("0", 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            f = z;
            JSONArray optJSONArray = jSONObject.optJSONArray("1");
            if (optJSONArray == null) {
                return;
            }
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                hashSet.add(Integer.valueOf(optJSONArray.optInt(i2)));
            }
            hashSet.contains(27);
            hashSet.contains(34);
            hashSet.contains(40);
            hashSet.contains(41);
            if (hashSet.contains(42)) {
                b = false;
            } else {
                b = true;
            }
            if (hashSet.contains(43)) {
                d = false;
            } else {
                d = true;
            }
            if (hashSet.contains(44)) {
                c = false;
            } else {
                c = true;
            }
            if (hashSet.contains(45)) {
                e = false;
            } else {
                e = true;
            }
            hashSet.contains(46);
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (!f && !c(context)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (r.a(context) && c(context)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (System.currentTimeMillis() - i < 1000) {
                return h;
            }
            boolean z2 = false;
            try {
                z = ((PowerManager) context.getSystemService("power")).isScreenOn();
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                z = false;
            }
            if (z && d(context)) {
                z2 = true;
            }
            h = z2;
            i = System.currentTimeMillis();
            return h;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo("com.android.permission.GET_INSTALLED_APPS", 0);
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(permissionInfo.packageName, 0);
                if ((permissionInfo.protectionLevel & 15) != 1 || (applicationInfo.flags & 1) == 0) {
                    return true;
                }
                String[] strArr = {"com.android.permission.GET_INSTALLED_APPS"};
                int i2 = 0;
                while (true) {
                    if (i2 < 1) {
                        if (context.checkPermission(strArr[i2], Process.myPid(), Process.myUid()) != -1) {
                            i2++;
                        } else {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.b.a;
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        String[] strArr;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            if (Build.VERSION.SDK_INT < 21) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager.getRunningTasks(1) != null && (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) != null) {
                    return context.getPackageName().equals(runningTaskInfo.topActivity.getPackageName());
                }
                return false;
            }
            if (context != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0 && (strArr = runningAppProcessInfo.pkgList) != null && strArr.length != 0 && Arrays.asList(strArr).contains(context.getPackageName())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (q.class) {
                if (context == null) {
                    return;
                }
                try {
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
                if (g) {
                    return;
                }
                g = true;
                a(new JSONObject(com.baidu.sofire.j.a.a(context).a.getString("p_s_p_c", "")));
            }
        }
    }
}
