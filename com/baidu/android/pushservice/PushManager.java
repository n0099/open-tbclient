package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.i.m;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes7.dex */
public class PushManager {
    private static final String TAG = "PushManager";

    public static void bindPush(Context context, String str) {
        if (m.j(context)) {
            return;
        }
        f.a(context, 0, str, true);
    }

    public static void createNotificationChannel(Context context, String str, String str2) {
        if (m.p(context)) {
            com.baidu.android.pushservice.i.h.a(context, str, str2);
        }
    }

    public static void delTags(Context context, List<String> list) {
        Intent c;
        Iterator<String> it;
        String str;
        if (list == null || list.size() == 0 || (c = f.c(context)) == null) {
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
        c.putExtra("method", "method_del_tags");
        c.putExtra(CommandMessage.TYPE_TAGS, str + "]");
        com.baidu.android.pushservice.f.a.a(TAG, "a delTags intent send", context.getApplicationContext());
        f.b(context, c);
    }

    public static void deleteNotificationChannel(Context context, String str) {
        if (m.p(context)) {
            com.baidu.android.pushservice.i.h.a(context, str);
        }
    }

    public static void disableAlarm(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            context.sendBroadcast(f.b(context));
        }
    }

    public static void enableHuaweiProxy(Context context, boolean z) {
        PushSettings.c = z ? 1 : 0;
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", PushSettings.c);
    }

    public static void enableMeizuProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f.e = str;
        com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPID_KEY", str);
        f.f = str2;
        com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPKEY_KEY", str2);
        PushSettings.d = z ? 1 : 0;
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", PushSettings.d);
    }

    public static void enableOppoProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f.g = str;
        com.baidu.android.pushservice.i.i.a(context, "BD_OPPO_PROXY_APPKEY_KEY", str);
        f.h = str2;
        com.baidu.android.pushservice.i.i.a(context, "BD_OPPO_PROXY_APPSECRET_KEY", str2);
        PushSettings.e = z ? 1 : 0;
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", PushSettings.e);
    }

    public static void enableVivoProxy(Context context, boolean z) {
        PushSettings.f = z ? 1 : 0;
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", PushSettings.f);
    }

    public static void enableXiaomiProxy(Context context, boolean z, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            f.c = str;
            com.baidu.android.pushservice.i.i.a(context, "BD_PROXY_APPID_KEY", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            f.d = str2;
            com.baidu.android.pushservice.i.i.a(context, "BD_PROXY_APPKEY_KEY", str2);
        }
        PushSettings.b = z ? 1 : 0;
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", PushSettings.b);
    }

    public static int getBindType(Context context) {
        if (m.j(context)) {
            if (com.baidu.android.pushservice.b.d.l(context)) {
                return 2;
            }
            if (com.baidu.android.pushservice.b.d.k(context)) {
                return 3;
            }
            if (com.baidu.android.pushservice.b.d.j(context)) {
                return 4;
            }
            if (com.baidu.android.pushservice.b.d.m(context)) {
                return 5;
            }
            return com.baidu.android.pushservice.b.d.n(context) ? 6 : 1;
        }
        return 0;
    }

    public static void insertPassThroughMessageClick(Context context, String str, String str2) {
        if (f.m(context) || str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.f.a.a(TAG, "PassThroughMessageClick  : " + packageName, context.getApplicationContext());
            intent.putExtra("app_id", str2);
            intent.putExtra("msg_id", str);
            intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
            intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
            context.startService(intent);
        } catch (Exception e) {
            com.baidu.android.pushservice.f.a.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static boolean isPushEnabled(Context context) {
        return (f.m(context) || m.b(context)) ? false : true;
    }

    public static void listTags(Context context) {
        Intent c = f.c(context);
        if (c == null) {
            return;
        }
        c.putExtra("method", "method_listtags");
        com.baidu.android.pushservice.f.a.a(TAG, "a listTags intent send", context.getApplicationContext());
        f.b(context, c);
    }

    public static void reStartWork(final Context context) {
        if (m.j(context)) {
            new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.1
                @Override // java.lang.Runnable
                public void run() {
                    l.a(context, null);
                }
            }, com.baidu.android.pushservice.b.d.h() * 1000);
        }
    }

    public static void requestOppoNotification(Context context) {
        if (m.e() && com.baidu.android.pushservice.b.d.p(context)) {
            m.a();
        }
    }

    public static void resumeWork(Context context) {
        if (f.m(context)) {
            return;
        }
        a.a(context, true);
        m.a(context, true, true);
        f.b(context, 0);
        l.b(context);
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (f.m(context)) {
            return;
        }
        d.a(context, pushNotificationBuilder);
    }

    public static void setNoDisturbMode(Context context, int i, int i2, int i3, int i4) {
        if (f.m(context)) {
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
        if (f.m(context)) {
            return;
        }
        if (i < 1 || i > 1000) {
            com.baidu.android.pushservice.f.a.b(TAG, "set notification builder error, id is illegal !", context.getApplicationContext());
        } else {
            d.a(context, i, pushNotificationBuilder);
        }
    }

    public static void setTags(Context context, List<String> list) {
        Intent c;
        Iterator<String> it;
        String str;
        if (list == null || list.size() == 0 || (c = f.c(context)) == null) {
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
        c.putExtra("method", "method_set_tags");
        c.putExtra(CommandMessage.TYPE_TAGS, str + "]");
        com.baidu.android.pushservice.f.a.a(TAG, "a setTags intent send ", context.getApplicationContext());
        f.b(context, c);
    }

    public static void startWork(Context context, int i, String str) {
        if (f.m(context)) {
            return;
        }
        f.f1080a = i;
        f.b = str;
        h.b(context);
        String f = m.f(context, str);
        com.baidu.android.pushservice.i.i.a(context, "com.baidu.android.pushservice.CHECK_SDK", f);
        com.baidu.android.pushservice.f.a.a(TAG, "startWork from " + context.getPackageName() + " checkResult: " + f, context.getApplicationContext());
        m.a("startWork from " + context.getPackageName() + " checkResult: " + f, context);
        if ((TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", f) || !PushSettings.e(context)) && i == 0) {
            f.a(context, i, f.b);
        } else {
            if (i != 0) {
                Log.e("BDPushSDK-PushManager", "Wrong LOGIN TYPE, Please use LOGIN_TYPE_API_KEY !");
            }
            f.b(context, 10101, f);
        }
        m.l(context);
    }

    public static void stopWork(Context context) {
        if (f.m(context)) {
            return;
        }
        com.baidu.android.pushservice.f.a.a(TAG, "stopWork from" + context.getPackageName(), context.getApplicationContext());
        m.a("stopWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        f.g(context);
        a.a(context, false);
        m.a(context, true, false);
        m.d(context);
        com.baidu.android.pushservice.job.a.b(context);
        f.n(context);
    }
}
