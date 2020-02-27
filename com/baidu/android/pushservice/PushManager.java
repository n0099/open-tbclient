package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.k;
import com.baidu.android.pushservice.i.l;
import com.coloros.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes8.dex */
public class PushManager {
    private static final String TAG = "PushManager";

    /* loaded from: classes8.dex */
    public interface SyncCallback {
        void onSyncResult(int i);
    }

    public static void bindPush(Context context, String str) {
        com.baidu.android.pushservice.f.a.a(TAG, "try bind push from " + context.getPackageName(), context);
        if (context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false)) {
            return;
        }
        e.a(context, 0, str, true);
    }

    public static void delTags(Context context, List<String> list) {
        Intent a;
        Iterator<String> it;
        String str;
        if (list == null || list.size() == 0 || (a = e.a(context)) == null) {
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
        a.putExtra(CommandMessage.TYPE_TAGS, str + "]");
        com.baidu.android.pushservice.f.a.a(TAG, "a delTags intent send", context.getApplicationContext());
        e.b(context, a);
    }

    public static void enableHuaweiProxy(Context context, boolean z) {
        if (z) {
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", 1);
        } else {
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", 0);
        }
    }

    public static void enableMeizuProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e.f = str;
        com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPID_KEY", str);
        e.g = str2;
        com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPKEY_KEY", str2);
        if (z) {
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", 1);
        } else {
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", 0);
        }
    }

    public static void enableOppoProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e.h = str;
        com.baidu.android.pushservice.i.i.a(context, "BD_OPPO_PROXY_APPKEY_KEY", str);
        e.i = str2;
        com.baidu.android.pushservice.i.i.a(context, "BD_OPPO_PROXY_APPSECRET_KEY", str2);
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", z ? 1 : 0);
    }

    public static void enableVivoProxy(Context context, boolean z) {
        if (z) {
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", 1);
            return;
        }
        PushSettings.f = 0;
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", 0);
    }

    public static void enableXiaomiProxy(Context context, boolean z, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            e.d = str;
            com.baidu.android.pushservice.i.i.a(context, "BD_PROXY_APPID_KEY", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            e.e = str2;
            com.baidu.android.pushservice.i.i.a(context, "BD_PROXY_APPKEY_KEY", str2);
        }
        if (z) {
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", 1);
        } else {
            com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", 0);
        }
    }

    public static int getBindType(Context context) {
        if (context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false)) {
            if (com.baidu.android.pushservice.b.d.f(context)) {
                return 2;
            }
            if (com.baidu.android.pushservice.b.d.e(context)) {
                return 3;
            }
            if (com.baidu.android.pushservice.b.d.d(context)) {
                return 4;
            }
            if (com.baidu.android.pushservice.b.d.g(context)) {
                return 5;
            }
            return com.baidu.android.pushservice.b.d.h(context) ? 6 : 1;
        }
        return 0;
    }

    public static void insertPassThroughMessageClick(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            if (intent != null) {
                String packageName = com.baidu.android.pushservice.b.d.k(context) ? context.getPackageName() : l.v(context);
                if (packageName != null) {
                    com.baidu.android.pushservice.f.a.a(TAG, "PassThroughMessageClick  : " + packageName, context.getApplicationContext());
                    intent.putExtra(Constants.APP_ID, str2);
                    intent.putExtra("msg_id", str);
                    intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
                    intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static void insertPassThroughMessageDelete(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            if (intent != null) {
                String packageName = com.baidu.android.pushservice.b.d.k(context) ? context.getPackageName() : l.v(context);
                if (packageName != null) {
                    com.baidu.android.pushservice.f.a.a(TAG, "PassThroughMessageDelete  : " + packageName, context.getApplicationContext());
                    intent.putExtra(Constants.APP_ID, str2);
                    intent.putExtra("msg_id", str);
                    intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.DELETE");
                    intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static void insertPassThroughMessageNotified(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            String packageName = com.baidu.android.pushservice.b.d.k(context) ? context.getPackageName() : l.v(context);
            if (packageName != null) {
                com.baidu.android.pushservice.f.a.a(TAG, "PassThroughMessageNotified  : " + packageName, context.getApplicationContext());
                intent.putExtra(Constants.APP_ID, str2);
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
            com.baidu.android.pushservice.f.a.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static boolean isPushEnabled(Context context) {
        return (e.k(context) || l.c(context)) ? false : true;
    }

    public static void listTags(Context context) {
        Intent a = e.a(context);
        if (a == null) {
            return;
        }
        a.putExtra("method", "method_listtags");
        com.baidu.android.pushservice.f.a.a(TAG, "a listTags intent send", context.getApplicationContext());
        e.b(context, a);
    }

    public static void reStartWork(Context context) {
        com.baidu.android.pushservice.f.a.a(TAG, "reStartWork from " + context.getPackageName(), context);
        k.d(context);
    }

    public static void resumeWork(Context context) {
        if (e.k(context)) {
            return;
        }
        a.b(context, true);
        l.a(context, true, true);
        a.a(context, true);
        k.a(context);
        e.b(context, 0);
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (e.k(context)) {
            return;
        }
        c.a(context, pushNotificationBuilder);
    }

    public static void setMediaNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (e.k(context)) {
            return;
        }
        c.b(context, pushNotificationBuilder);
    }

    public static void setNoDisturbMode(Context context, int i, int i2, int i3, int i4) {
        if (e.k(context)) {
            return;
        }
        if (i < 0 || i > 23 || i3 < 0 || i3 > 23) {
            com.baidu.android.pushservice.f.a.a(TAG, "setNoDisturbMode hour parameters illegal!", context.getApplicationContext());
        } else if (i2 < 0 || i2 > 59 || i4 < 0 || i4 > 59) {
            com.baidu.android.pushservice.f.a.a(TAG, "setNoDisturbMode minute parameters illegal!", context.getApplicationContext());
        } else {
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.f.a.a(TAG, "PushManager setNoDisturbMode package name: " + packageName, context.getApplicationContext());
            com.baidu.android.pushservice.c.a.a(context, packageName, i, i2, i3, i4);
        }
    }

    public static void setNotificationBuilder(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        if (e.k(context)) {
            return;
        }
        if (i < 1 || i > 1000) {
            com.baidu.android.pushservice.f.a.b(TAG, "set notification builder error, id is illegal !", context.getApplicationContext());
        } else {
            c.a(context, i, pushNotificationBuilder);
        }
    }

    public static void setTags(Context context, List<String> list) {
        Intent a;
        Iterator<String> it;
        String str;
        if (list == null || list.size() == 0 || (a = e.a(context)) == null) {
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
        a.putExtra(CommandMessage.TYPE_TAGS, str + "]");
        com.baidu.android.pushservice.f.a.a(TAG, "a setTags intent send ", context.getApplicationContext());
        e.b(context, a);
    }

    public static void startWork(Context context, int i, String str) {
        if (e.k(context)) {
            return;
        }
        e.a = i;
        e.b = str;
        g.b(context);
        String l = l.l(context, str);
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.CHECK_SDK", l);
        com.baidu.android.pushservice.f.a.a(TAG, "startWork from " + context.getPackageName() + " checkResult: " + l, context.getApplicationContext());
        l.b("startWork from " + context.getPackageName() + " checkResult: " + l, context);
        if ((TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", l) || !PushSettings.d(context)) && i == 0) {
            e.a(context, i, e.b);
        } else {
            if (i != 0) {
                Log.e("BDPushSDK-PushManager", "Wrong LOGIN TYPE, Please use LOGIN_TYPE_API_KEY !");
            }
            e.b(context, 10101, l);
        }
        l.A(context);
    }

    public static void stopWork(Context context) {
        if (e.k(context)) {
            return;
        }
        com.baidu.android.pushservice.f.a.a(TAG, "stopWork from" + context.getPackageName(), context.getApplicationContext());
        l.b("stopWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        e.f(context);
        a.b(context, false);
        l.a(context, true, true);
        a.a(context, true);
        l.f(context, context.getPackageName());
        SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
        edit.putBoolean("bind_status", false);
        edit.commit();
        if (a.d(context)) {
            a.c(context, false);
        }
        com.baidu.android.pushservice.job.a.a();
    }

    public static void syncPushEnabled(Context context, String str, boolean z, int i, SyncCallback syncCallback) {
        if (e.k(context) || !context.getPackageName().startsWith("com.baidu") || TextUtils.isEmpty(str)) {
            if (syncCallback != null) {
                syncCallback.onSyncResult(-1);
                return;
            }
            return;
        }
        switch (i) {
            case 0:
                e.a(context, str, z, i, syncCallback);
                return;
            case 1:
                e.a(context, str, z, i, System.currentTimeMillis() + ((new Random().nextInt(30) + 1) * 24 * 3600 * 1000));
                return;
            case 2:
                if (com.baidu.android.pushservice.b.d.k(context)) {
                    return;
                }
                e.a(context, str, z, i, System.currentTimeMillis() + 21600000);
                return;
            default:
                return;
        }
    }
}
