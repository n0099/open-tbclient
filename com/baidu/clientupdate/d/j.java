package com.baidu.clientupdate.d;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.storage.StorageManager;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.util.LogUtil;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.File;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1147890217, "Lcom/baidu/clientupdate/d/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1147890217, "Lcom/baidu/clientupdate/d/j;");
                return;
            }
        }
        a = new char[]{TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        b = "";
    }

    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, obj, str, clsArr, objArr)) == null) {
            Object obj2 = null;
            try {
                obj2 = obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
                LogUtil.logD("Utility", "Method \"" + str + "\" invoked success!");
                return obj2;
            } catch (Exception e) {
                LogUtil.logD("Utility", "Method \"" + str + "\" invoked failed: " + e.getMessage());
                return obj2;
            }
        }
        return invokeLLLL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                return g.a(new File(b(context, str).applicationInfo.publicSourceDir));
            } catch (Exception e) {
                LogUtil.logE("Utility", "error" + e.getMessage());
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            Object a2 = a(obj, "getPath", null, null);
            return a2 != null ? (String) a2 : "";
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, file) == null) {
            com.baidu.clientupdate.a.d a2 = com.baidu.clientupdate.a.d.a(context);
            com.baidu.clientupdate.c.a a3 = com.baidu.clientupdate.c.a.a(context);
            LogUtil.logD("Utility", "startSystemInstallUI安装文件存在:" + file.exists() + ":" + file.getPath());
            com.baidu.util.a.a(context).b("lcsdk_xml", "sessionId", a3.c());
            com.baidu.util.a.a(context).b("lcsdk_xml", "sessionInfo", a3.b());
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.setFlags(268435457);
                    String str = b;
                    if (TextUtils.isEmpty(b)) {
                        str = context.getPackageName() + ".fileprovider";
                    }
                    intent.setDataAndType(FileProvider.getUriForFile(context, str, file), "application/vnd.android.package-archive");
                } else {
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                LogUtil.logD("Utility", "启动系统安装界面");
                context.startActivity(intent);
                a2.a(a3.c(), "0", a3.b(), "a9", "0", (System.currentTimeMillis() / 1000) + "", "", "startSystemInstallUI", "");
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.logE("Utility", "启动系统安装界面失败");
                a2.a(a3.c(), "0", a3.b(), "a9", "1", (System.currentTimeMillis() / 1000) + "", "", "startSystemInstallUI", e.toString());
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b = str;
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        NetworkInfo[] allNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            for (NetworkInfo networkInfo : connectivityManager.getAllNetworkInfo()) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static PackageInfo b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 64);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.h.a) == 0 : invokeL.booleanValue;
    }

    public static long c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? PreferenceManager.getDefaultSharedPreferences(context).getLong("client_update_ignore_time", 0L) : invokeL.longValue;
    }

    @TargetApi(9)
    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Object a2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) ? (Build.VERSION.SDK_INT >= 9 && (a2 = a((StorageManager) context.getSystemService("storage"), "getVolumeState", new Class[]{String.class}, new Object[]{str})) != null) ? (String) a2 : "" : (String) invokeLL.objValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            Context applicationContext = context.getApplicationContext();
            ActivityManager.RunningTaskInfo e = e(applicationContext);
            if (e == null) {
                return false;
            }
            return TextUtils.equals(applicationContext.getPackageName(), e.baseActivity.getPackageName());
        }
        return invokeL.booleanValue;
    }

    public static ActivityManager.RunningTaskInfo e(Context context) {
        InterceptResult invokeL;
        ActivityManager.RecentTaskInfo recentTaskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            List<ActivityManager.RecentTaskInfo> recentTasks = activityManager.getRecentTasks(1, 1);
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(3);
            Iterator<ActivityManager.RecentTaskInfo> it = recentTasks.iterator();
            Iterator<ActivityManager.RunningTaskInfo> it2 = runningTasks.iterator();
            if (it.hasNext()) {
                recentTaskInfo = it.next();
                LogUtil.logD("Utility", "getCurrentTask---------当前任务----localRecentTaskInfo.id = " + recentTaskInfo.id);
                LogUtil.logD("Utility", "getCurrentTask---------当前任务----localRecentTaskInfo.PackageName = " + recentTaskInfo.baseIntent.getComponent().getPackageName());
            } else {
                recentTaskInfo = null;
            }
            if (recentTaskInfo == null) {
                return null;
            }
            ActivityManager.RunningTaskInfo next = it2.hasNext() ? it2.next() : null;
            if (next == null) {
                return null;
            }
            int i = recentTaskInfo.id;
            if (i == -1 || next.id != i) {
                String packageName = recentTaskInfo.baseIntent.getComponent().getPackageName();
                if (next.baseActivity.getPackageName().equals(packageName)) {
                    while (it2.hasNext()) {
                        next = it2.next();
                        if (!next.baseActivity.getPackageName().equals(packageName)) {
                        }
                    }
                    return null;
                }
            } else {
                LogUtil.logD("Utility", "getCurrentTask---------new task");
            }
            return next;
        }
        return (ActivityManager.RunningTaskInfo) invokeL.objValue;
    }

    public static void f(Context context) {
        String[] fileList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            try {
                String a2 = com.baidu.util.a.a(context).a("lcsdk_xml", "apkName", "");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                for (String str : context.getApplicationContext().fileList()) {
                    if (str.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && str.contains(a2)) {
                        context.getApplicationContext().deleteFile(str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @TargetApi(9)
    public static Object[] g(Context context) {
        InterceptResult invokeL;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 9 && (a2 = a((StorageManager) context.getSystemService("storage"), "getVolumeList", null, null)) != null) {
                return (Object[]) a2;
            }
            return null;
        }
        return (Object[]) invokeL.objValue;
    }
}
