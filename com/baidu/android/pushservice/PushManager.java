package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes2.dex */
public class PushManager {
    private static final String TAG = "PushManager";

    public static void delTags(Context context, List<String> list) {
        Iterator<String> it;
        String str;
        if (list == null || list.size() == 0) {
            com.baidu.android.pushservice.g.a.d(TAG, "No tags specified, do nothing.");
            return;
        }
        Intent a = f.a(context);
        if (a != null) {
            String str2 = "[";
            while (true) {
                str = str2;
                if (!list.iterator().hasNext()) {
                    break;
                }
                str2 = ((str + "\"") + it.next()) + "\",";
            }
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
            }
            a.putExtra(PushConstants.EXTRA_METHOD, "method_del_tags");
            a.putExtra("tags", str + "]");
            com.baidu.android.pushservice.g.b.a(TAG, "a delTags intent send", context.getApplicationContext());
            f.b(context, a);
        }
    }

    public static void disableLbs(Context context) {
        if (f.j(context)) {
            return;
        }
        PushSettings.a(context, false);
    }

    public static void enableHuaweiProxy(Context context, boolean z) {
        if (z) {
            m.a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", 1);
        } else {
            m.a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", 0);
        }
    }

    public static void enableLbs(Context context) {
        if (f.j(context)) {
            return;
        }
        PushSettings.a(context, true);
    }

    public static void enableXiaomiProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.android.pushservice.g.a.d(TAG, "appId is null!");
        } else {
            f.d = str;
            m.a(context, "BD_PROXY_APPID_KEY", str);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.android.pushservice.g.a.d(TAG, "appKey is null!");
        } else {
            f.e = str2;
            m.a(context, "BD_PROXY_APPKEY_KEY", str2);
        }
        if (z) {
            m.a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", 1);
        } else {
            m.a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", 0);
        }
    }

    public static int getBindType(Context context) {
        if (context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false)) {
            com.baidu.android.pushservice.c.d.a(context);
            if (com.baidu.android.pushservice.c.d.c(context)) {
                return 2;
            }
            com.baidu.android.pushservice.c.d.a(context);
            return com.baidu.android.pushservice.c.d.b(context) ? 3 : 1;
        }
        return 0;
    }

    public static String getHWNotifyCheckInfo(Context context, Intent intent) {
        if (intent != null) {
            try {
                return f.d(context, intent);
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a(TAG, e);
                return null;
            }
        }
        return null;
    }

    public static String getHWNotifySignInfo(Context context, Intent intent) {
        if (intent != null) {
            try {
                return f.c(context, intent);
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a(TAG, e);
                return null;
            }
        }
        return null;
    }

    public static boolean hwMessageVerify(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || str2 == null) {
                return false;
            }
            return f.a(context, str, str2);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a(TAG, e);
            return false;
        }
    }

    public static void insertPassThroughMessageClick(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            if (intent != null) {
                String packageName = com.baidu.android.pushservice.c.d.d(context) ? context.getPackageName() : p.u(context);
                if (packageName != null) {
                    com.baidu.android.pushservice.g.b.a(TAG, "PassThroughMessageClick  : " + packageName, context.getApplicationContext());
                    intent.putExtra("app_id", str2);
                    intent.putExtra("msg_id", str);
                    intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
                    intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.b.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static void insertPassThroughMessageDelete(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            if (intent != null) {
                String packageName = com.baidu.android.pushservice.c.d.d(context) ? context.getPackageName() : p.u(context);
                if (packageName != null) {
                    com.baidu.android.pushservice.g.b.a(TAG, "PassThroughMessageDelete  : " + packageName, context.getApplicationContext());
                    intent.putExtra("app_id", str2);
                    intent.putExtra("msg_id", str);
                    intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.DELETE");
                    intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.b.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static void insertPassThroughMessageNotified(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            String packageName = com.baidu.android.pushservice.c.d.d(context) ? context.getPackageName() : p.u(context);
            if (packageName != null) {
                com.baidu.android.pushservice.g.b.a(TAG, "PassThroughMessageNotified  : " + packageName, context.getApplicationContext());
                intent.putExtra("app_id", str2);
                intent.putExtra("msg_id", str);
                intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED");
                intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                context.startService(intent);
                if (packageName.equals(context.getPackageName())) {
                    return;
                }
                intent.putExtra("self_insert", true);
                intent.setClassName(context.getPackageName(), "com.baidu.android.pushservice.CommandService");
                context.startService(intent);
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.b.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static boolean isPushEnabled(Context context) {
        return (f.j(context) || p.c(context)) ? false : true;
    }

    public static void listTags(Context context) {
        Intent a = f.a(context);
        if (a == null) {
            return;
        }
        a.putExtra(PushConstants.EXTRA_METHOD, "method_listtags");
        com.baidu.android.pushservice.g.b.a(TAG, "a listTags intent send", context.getApplicationContext());
        f.b(context, a);
    }

    public static void resumeWork(Context context) {
        if (f.j(context)) {
            return;
        }
        a.b(context, true);
        p.a(context, true, true);
        a.a(context, true);
        o.a(context);
        f.b(context, 0);
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (f.j(context)) {
            return;
        }
        d.a(context, pushNotificationBuilder);
    }

    public static void setMediaNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (f.j(context)) {
            return;
        }
        d.b(context, pushNotificationBuilder);
    }

    public static void setNoDisturbMode(Context context, int i, int i2, int i3, int i4) {
        if (f.j(context)) {
            return;
        }
        if (i < 0 || i > 23 || i3 < 0 || i3 > 23) {
            com.baidu.android.pushservice.g.b.a(TAG, "setNoDisturbMode hour parameters illegal!", context.getApplicationContext());
        } else if (i2 < 0 || i2 > 59 || i4 < 0 || i4 > 59) {
            com.baidu.android.pushservice.g.b.a(TAG, "setNoDisturbMode minute parameters illegal!", context.getApplicationContext());
        } else {
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.g.b.a(TAG, "PushManager setNoDisturbMode package name: " + packageName, context.getApplicationContext());
            com.baidu.android.pushservice.d.a.a(context, packageName, i, i2, i3, i4);
        }
    }

    public static void setNotificationBuilder(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        if (f.j(context)) {
            return;
        }
        if (i < 1 || i > 1000) {
            com.baidu.android.pushservice.g.b.b(TAG, "set notification builder error, id is illegal !", context.getApplicationContext());
        } else {
            d.a(context, i, pushNotificationBuilder);
        }
    }

    public static void setTags(Context context, List<String> list) {
        Iterator<String> it;
        String str;
        if (list == null || list.size() == 0) {
            com.baidu.android.pushservice.g.a.d(TAG, "No tags specified, do nothing.");
            return;
        }
        Intent a = f.a(context);
        if (a != null) {
            String str2 = "[";
            while (true) {
                str = str2;
                if (!list.iterator().hasNext()) {
                    break;
                }
                str2 = ((str + "\"") + it.next()) + "\",";
            }
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
            }
            a.putExtra(PushConstants.EXTRA_METHOD, "method_set_tags");
            a.putExtra("tags", str + "]");
            com.baidu.android.pushservice.g.b.a(TAG, "a setTags intent send ", context.getApplicationContext());
            f.b(context, a);
        }
    }

    public static void startWork(Context context, int i, String str) {
        if (f.j(context)) {
            return;
        }
        f.a = i;
        f.b = str;
        h.b(context);
        String k = p.k(context, str);
        com.baidu.android.pushservice.g.b.a(TAG, "startWork from " + context.getPackageName() + " checkResult: " + k, context.getApplicationContext());
        p.b("startWork from " + context.getPackageName() + " checkResult: " + k, context);
        if (TextUtils.isEmpty(k) && i == 0) {
            f.a(context, i, f.b, true);
        } else {
            if (i != 0) {
                Log.e("BDPushSDK-PushManager", "Wrong LOGIN TYPE, Please use LOGIN_TYPE_API_KEY !");
            }
            f.d(context, 10101, k);
        }
        p.z(context);
    }

    public static void stopWork(Context context) {
        if (f.j(context)) {
            return;
        }
        p.b("stopWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        if (!p.x(context) && !com.baidu.android.pushservice.c.d.d(context)) {
            f.g(context);
            return;
        }
        f.e(context);
        a.b(context, false);
        p.a(context, true, true);
        a.a(context, true);
        p.f(context, context.getPackageName());
        SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
        edit.putBoolean("bind_status", false);
        edit.commit();
        com.baidu.android.pushservice.g.a.c(TAG, "set bind_status = false");
    }
}
