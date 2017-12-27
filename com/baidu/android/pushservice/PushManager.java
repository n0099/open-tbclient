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
import java.util.Random;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes2.dex */
public class PushManager {
    private static final String TAG = "PushManager";

    /* loaded from: classes2.dex */
    public interface SyncCallback {
        void onSyncResult(int i);
    }

    public static void delTags(Context context, List<String> list) {
        Intent a;
        Iterator<String> it;
        String str;
        if (list == null || list.size() == 0 || (a = f.a(context)) == null) {
            return;
        }
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
        a.putExtra("method", "method_del_tags");
        a.putExtra("tags", str + "]");
        com.baidu.android.pushservice.g.a.a(TAG, "a delTags intent send", context.getApplicationContext());
        f.b(context, a);
    }

    public static void disableLbs(Context context) {
        if (f.l(context)) {
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
        if (f.l(context)) {
            return;
        }
        PushSettings.a(context, true);
    }

    public static void enableMeizuProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f.f = str;
        m.a(context, "BD_MEIZU_PROXY_APPID_KEY", str);
        f.g = str2;
        m.a(context, "BD_MEIZU_PROXY_APPKEY_KEY", str2);
        if (z) {
            m.a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", 1);
        } else {
            m.a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", 0);
        }
    }

    public static void enableOppoProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f.h = str;
        m.a(context, "BD_OPPO_PROXY_APPKEY_KEY", str);
        f.i = str2;
        m.a(context, "BD_OPPO_PROXY_APPSECRET_KEY", str2);
        m.a(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", z ? 1 : 0);
    }

    public static void enableXiaomiProxy(Context context, boolean z, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            f.d = str;
            m.a(context, "BD_PROXY_APPID_KEY", str);
        }
        if (!TextUtils.isEmpty(str2)) {
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
            if (com.baidu.android.pushservice.c.d.d(context)) {
                return 2;
            }
            if (com.baidu.android.pushservice.c.d.c(context)) {
                return 3;
            }
            if (com.baidu.android.pushservice.c.d.b(context)) {
                return 4;
            }
            return com.baidu.android.pushservice.c.d.e(context) ? 5 : 1;
        }
        return 0;
    }

    public static String getHWNotifyCheckInfo(Context context, Intent intent) {
        if (intent != null) {
            try {
                return f.d(context, intent);
            } catch (Exception e) {
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
                String packageName = com.baidu.android.pushservice.c.d.g(context) ? context.getPackageName() : p.v(context);
                if (packageName != null) {
                    com.baidu.android.pushservice.g.a.a(TAG, "PassThroughMessageClick  : " + packageName, context.getApplicationContext());
                    intent.putExtra("app_id", str2);
                    intent.putExtra("msg_id", str);
                    intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
                    intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static void insertPassThroughMessageDelete(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            if (intent != null) {
                String packageName = com.baidu.android.pushservice.c.d.g(context) ? context.getPackageName() : p.v(context);
                if (packageName != null) {
                    com.baidu.android.pushservice.g.a.a(TAG, "PassThroughMessageDelete  : " + packageName, context.getApplicationContext());
                    intent.putExtra("app_id", str2);
                    intent.putExtra("msg_id", str);
                    intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.DELETE");
                    intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static void insertPassThroughMessageNotified(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            String packageName = com.baidu.android.pushservice.c.d.g(context) ? context.getPackageName() : p.v(context);
            if (packageName != null) {
                com.baidu.android.pushservice.g.a.a(TAG, "PassThroughMessageNotified  : " + packageName, context.getApplicationContext());
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
            com.baidu.android.pushservice.g.a.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static boolean isPushEnabled(Context context) {
        return (f.l(context) || p.c(context)) ? false : true;
    }

    public static void listTags(Context context) {
        Intent a = f.a(context);
        if (a == null) {
            return;
        }
        a.putExtra("method", "method_listtags");
        com.baidu.android.pushservice.g.a.a(TAG, "a listTags intent send", context.getApplicationContext());
        f.b(context, a);
    }

    public static void resumeWork(Context context) {
        if (f.l(context)) {
            return;
        }
        a.b(context, true);
        p.a(context, true, true);
        a.a(context, true);
        o.a(context);
        f.b(context, 0);
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (f.l(context)) {
            return;
        }
        d.a(context, pushNotificationBuilder);
    }

    public static void setMediaNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (f.l(context)) {
            return;
        }
        d.b(context, pushNotificationBuilder);
    }

    public static void setNoDisturbMode(Context context, int i, int i2, int i3, int i4) {
        if (f.l(context)) {
            return;
        }
        if (i < 0 || i > 23 || i3 < 0 || i3 > 23) {
            com.baidu.android.pushservice.g.a.a(TAG, "setNoDisturbMode hour parameters illegal!", context.getApplicationContext());
        } else if (i2 < 0 || i2 > 59 || i4 < 0 || i4 > 59) {
            com.baidu.android.pushservice.g.a.a(TAG, "setNoDisturbMode minute parameters illegal!", context.getApplicationContext());
        } else {
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.g.a.a(TAG, "PushManager setNoDisturbMode package name: " + packageName, context.getApplicationContext());
            com.baidu.android.pushservice.d.a.a(context, packageName, i, i2, i3, i4);
        }
    }

    public static void setNotificationBuilder(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        if (f.l(context)) {
            return;
        }
        if (i < 1 || i > 1000) {
            com.baidu.android.pushservice.g.a.b(TAG, "set notification builder error, id is illegal !", context.getApplicationContext());
        } else {
            d.a(context, i, pushNotificationBuilder);
        }
    }

    public static void setTags(Context context, List<String> list) {
        Intent a;
        Iterator<String> it;
        String str;
        if (list == null || list.size() == 0 || (a = f.a(context)) == null) {
            return;
        }
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
        a.putExtra("method", "method_set_tags");
        a.putExtra("tags", str + "]");
        com.baidu.android.pushservice.g.a.a(TAG, "a setTags intent send ", context.getApplicationContext());
        f.b(context, a);
    }

    public static void startWork(Context context, int i, String str) {
        if (f.l(context)) {
            return;
        }
        f.a = i;
        f.b = str;
        h.b(context);
        String l = p.l(context, str);
        m.a(context, "com.baidu.android.pushservice.CHECK_SDK", l);
        com.baidu.android.pushservice.g.a.a(TAG, "startWork from " + context.getPackageName() + " checkResult: " + l, context.getApplicationContext());
        p.b("startWork from " + context.getPackageName() + " checkResult: " + l, context);
        if ((TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", l) || !PushSettings.c(context)) && i == 0) {
            f.a(context, i, f.b, true);
        } else {
            if (i != 0) {
                Log.e("BDPushSDK-PushManager", "Wrong LOGIN TYPE, Please use LOGIN_TYPE_API_KEY !");
            }
            f.d(context, 10101, l);
        }
        p.A(context);
    }

    public static void stopWork(Context context) {
        if (f.l(context)) {
            return;
        }
        p.b("stopWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        if (!p.y(context) && !com.baidu.android.pushservice.c.d.g(context)) {
            f.h(context);
            return;
        }
        f.f(context);
        a.b(context, false);
        p.a(context, true, true);
        a.a(context, true);
        p.f(context, context.getPackageName());
        SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
        edit.putBoolean("bind_status", false);
        edit.commit();
    }

    public static void syncPushEnabled(Context context, String str, boolean z, int i, SyncCallback syncCallback) {
        if (f.l(context) || !context.getPackageName().startsWith("com.baidu") || TextUtils.isEmpty(str)) {
            if (syncCallback != null) {
                syncCallback.onSyncResult(-1);
                return;
            }
            return;
        }
        switch (i) {
            case 0:
                f.a(context, str, z, i, syncCallback);
                return;
            case 1:
                f.a(context, str, z, i, System.currentTimeMillis() + ((new Random().nextInt(30) + 1) * 24 * 3600 * 1000));
                return;
            case 2:
                if (com.baidu.android.pushservice.c.d.g(context)) {
                    return;
                }
                f.a(context, str, z, i, System.currentTimeMillis() + 21600000);
                return;
            default:
                return;
        }
    }
}
