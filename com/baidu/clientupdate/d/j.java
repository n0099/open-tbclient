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
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.util.LogUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes14.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f1334a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String b = "";

    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Object obj2;
        Exception e;
        try {
            obj2 = obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e2) {
            obj2 = null;
            e = e2;
        }
        try {
            LogUtil.logD("Utility", "Method \"" + str + "\" invoked success!");
        } catch (Exception e3) {
            e = e3;
            LogUtil.logD("Utility", "Method \"" + str + "\" invoked failed: " + e.getMessage());
            return obj2;
        }
        return obj2;
    }

    public static String a(Context context, String str) {
        try {
            return g.a(new File(b(context, str).applicationInfo.publicSourceDir));
        } catch (Exception e) {
            LogUtil.logE("Utility", BdStatsConstant.StatsType.ERROR + e.getMessage());
            return "";
        }
    }

    public static String a(Object obj) {
        Object a2 = a(obj, "getPath", null, null);
        return a2 != null ? (String) a2 : "";
    }

    public static void a(Context context, File file) {
        com.baidu.clientupdate.a.d a2 = com.baidu.clientupdate.a.d.a(context);
        com.baidu.clientupdate.c.a a3 = com.baidu.clientupdate.c.a.a(context);
        LogUtil.logD("Utility", "startSystemInstallUI安装文件存在:" + file.exists() + ":" + file.getPath());
        com.baidu.util.a.a(context).b("lcsdk_xml", "sessionId", a3.c());
        com.baidu.util.a.a(context).b("lcsdk_xml", "sessionInfo", a3.b());
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setFlags(RouterCallback.CODE_ERROR);
                String str = b;
                if (TextUtils.isEmpty(b)) {
                    str = context.getPackageName() + ".fileprovider";
                }
                intent.setDataAndType(FileProvider.getUriForFile(context, str, file), "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(268435456);
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

    public static void a(String str) {
        b = str;
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static PackageInfo b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static boolean b(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public static long c(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("client_update_ignore_time", 0L);
    }

    @TargetApi(9)
    public static String c(Context context, String str) {
        Object a2;
        if (Build.VERSION.SDK_INT >= 9 && (a2 = a((StorageManager) context.getSystemService("storage"), "getVolumeState", new Class[]{String.class}, new Object[]{str})) != null) {
            return (String) a2;
        }
        return "";
    }

    public static boolean d(Context context) {
        Context applicationContext = context.getApplicationContext();
        ActivityManager.RunningTaskInfo e = e(applicationContext);
        if (e == null) {
            return false;
        }
        return TextUtils.equals(applicationContext.getPackageName(), e.baseActivity.getPackageName());
    }

    public static ActivityManager.RunningTaskInfo e(Context context) {
        ActivityManager.RecentTaskInfo recentTaskInfo;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        List<ActivityManager.RecentTaskInfo> recentTasks = activityManager.getRecentTasks(1, 1);
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(3);
        Iterator<ActivityManager.RecentTaskInfo> it = recentTasks.iterator();
        Iterator<ActivityManager.RunningTaskInfo> it2 = runningTasks.iterator();
        if (it.hasNext()) {
            ActivityManager.RecentTaskInfo next = it.next();
            LogUtil.logD("Utility", "getCurrentTask---------当前任务----localRecentTaskInfo.id = " + next.id);
            LogUtil.logD("Utility", "getCurrentTask---------当前任务----localRecentTaskInfo.PackageName = " + next.baseIntent.getComponent().getPackageName());
            recentTaskInfo = next;
        } else {
            recentTaskInfo = null;
        }
        if (recentTaskInfo == null) {
            return null;
        }
        ActivityManager.RunningTaskInfo next2 = it2.hasNext() ? it2.next() : null;
        if (next2 != null) {
            if (recentTaskInfo.id == -1 || next2.id != recentTaskInfo.id) {
                String packageName = recentTaskInfo.baseIntent.getComponent().getPackageName();
                if (next2.baseActivity.getPackageName().equals(packageName)) {
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        if (!next2.baseActivity.getPackageName().equals(packageName)) {
                            break;
                        }
                    }
                }
            } else {
                LogUtil.logD("Utility", "getCurrentTask---------new task");
            }
            return next2;
        }
        return null;
    }

    @TargetApi(9)
    public static Object[] f(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        Object a2 = a((StorageManager) context.getSystemService("storage"), "getVolumeList", null, null);
        return a2 != null ? (Object[]) a2 : null;
    }
}
