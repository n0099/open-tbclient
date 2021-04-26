package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.frequency.GetFrequencyListener;
import com.baidu.android.pushservice.frequency.GetNoDisturbListener;
import com.baidu.android.pushservice.frequency.UploadDataListener;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.heytap.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes.dex */
public class PushManager {
    public static final String TAG = "PushManager";

    public static void bindPush(Context context, String str) {
        if (m.i(context)) {
            return;
        }
        f.a(context, 0, str, true);
    }

    public static void clearIconBadge(Context context) {
        com.baidu.android.pushservice.f.c.a().a(context);
    }

    public static void closeNoDisturb(Context context, UploadDataListener uploadDataListener) {
        if (f.a(context, uploadDataListener)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("do_not_disturb", com.baidu.android.pushservice.frequency.b.a().a(-1, -1));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void createNotificationChannel(Context context, String str, String str2) {
        if (m.p(context)) {
            com.baidu.android.pushservice.j.h.a(context, str, str2);
        }
    }

    public static void delTags(Context context, List<String> list) {
        Intent c2;
        Iterator<String> it;
        if (list == null || list.size() == 0 || (c2 = f.c(context)) == null) {
            return;
        }
        String str = "[";
        while (list.iterator().hasNext()) {
            str = ((str + "\"") + it.next()) + "\",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        c2.putExtra("method", "method_del_tags");
        c2.putExtra(CommandMessage.TYPE_TAGS, str + "]");
        com.baidu.android.pushservice.g.a.a("PushManager", "a delTags intent send", context.getApplicationContext());
        f.b(context, c2);
    }

    public static void deleteNotificationChannel(Context context, String str) {
        if (m.p(context)) {
            com.baidu.android.pushservice.j.h.a(context, str);
        }
    }

    public static void disableAlarm(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            context.sendBroadcast(f.b(context));
        }
    }

    public static void enableHuaweiProxy(Context context, boolean z) {
        PushSettings.f2708c = z ? 1 : 0;
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", z ? 1 : 0);
    }

    public static void enableMeizuProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f.f3064e = str;
        com.baidu.android.pushservice.j.i.a(context, "BD_MEIZU_PROXY_APPID_KEY", str);
        f.f3065f = str2;
        com.baidu.android.pushservice.j.i.a(context, "BD_MEIZU_PROXY_APPKEY_KEY", str2);
        PushSettings.f2709d = z ? 1 : 0;
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", z ? 1 : 0);
    }

    public static void enableOppoProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f.f3066g = str;
        com.baidu.android.pushservice.j.i.a(context, "BD_OPPO_PROXY_APPKEY_KEY", str);
        f.f3067h = str2;
        com.baidu.android.pushservice.j.i.a(context, "BD_OPPO_PROXY_APPSECRET_KEY", str2);
        PushSettings.f2710e = z ? 1 : 0;
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", z ? 1 : 0);
    }

    public static void enableVivoProxy(Context context, boolean z) {
        PushSettings.f2711f = z ? 1 : 0;
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", z ? 1 : 0);
    }

    public static void enableXiaomiProxy(Context context, boolean z, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            f.f3062c = str;
            com.baidu.android.pushservice.j.i.a(context, "BD_PROXY_APPID_KEY", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            f.f3063d = str2;
            com.baidu.android.pushservice.j.i.a(context, "BD_PROXY_APPKEY_KEY", str2);
        }
        PushSettings.f2707b = z ? 1 : 0;
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", z ? 1 : 0);
    }

    public static int getBindType(Context context) {
        if (m.i(context)) {
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

    public static void getNoDisturbOnline(Context context, GetNoDisturbListener getNoDisturbListener) {
        if (getNoDisturbListener == null) {
            return;
        }
        if (context == null) {
            getNoDisturbListener.onResult(30602, 0, 0);
        } else {
            com.baidu.android.pushservice.frequency.b.a().a(context, "do_not_disturb", getNoDisturbListener);
        }
    }

    public static void getPushFrequency(Context context, GetFrequencyListener getFrequencyListener) {
        if (getFrequencyListener == null || context == null) {
            return;
        }
        com.baidu.android.pushservice.frequency.b.a().a(context, PushConstants.EXTRA_PUSH_FREQ, getFrequencyListener);
    }

    public static void insertPassThroughMessageClick(Context context, String str, String str2) {
        if (f.m(context) || str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.g.a.a("PushManager", "PassThroughMessageClick  : " + packageName, context.getApplicationContext());
            intent.putExtra(Constants.APP_ID, str2);
            intent.putExtra("msg_id", str);
            intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
            intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
            context.startService(intent);
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.b("PushManager", "error " + e2.getMessage(), context.getApplicationContext());
        }
    }

    public static boolean isPushEnabled(Context context) {
        if (f.m(context)) {
            return false;
        }
        return !m.b(context);
    }

    public static void listTags(Context context) {
        Intent c2 = f.c(context);
        if (c2 == null) {
            return;
        }
        c2.putExtra("method", "method_listtags");
        com.baidu.android.pushservice.g.a.a("PushManager", "a listTags intent send", context.getApplicationContext());
        f.b(context, c2);
    }

    public static void reStartWork(final Context context) {
        if (m.i(context) && isPushEnabled(context)) {
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

    public static void sendPushMsgAck(Context context, String str, int i2) {
        m.a(context, str, i2);
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (f.m(context)) {
            return;
        }
        d.a(context, pushNotificationBuilder);
    }

    public static void setNoDisturbMode(Context context, int i2, int i3, int i4, int i5) {
        if (f.m(context)) {
            return;
        }
        if (i2 < 0 || i2 > 23 || i4 < 0 || i4 > 23) {
            com.baidu.android.pushservice.g.a.a("PushManager", "setNoDisturbMode hour parameters illegal!", context.getApplicationContext());
        } else if (i3 < 0 || i3 > 59 || i5 < 0 || i5 > 59) {
            com.baidu.android.pushservice.g.a.a("PushManager", "setNoDisturbMode minute parameters illegal!", context.getApplicationContext());
        } else {
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.g.a.a("PushManager", "PushManager setNoDisturbMode package name: " + packageName, context.getApplicationContext());
            com.baidu.android.pushservice.c.a.a(context, packageName, i2, i3, i4, i5);
        }
    }

    public static void setNoDisturbOnline(Context context, int i2, int i3, UploadDataListener uploadDataListener) {
        if (f.a(context, uploadDataListener)) {
            if (i2 > 86400 || i3 > 86400 || i2 < 0 || i3 < 0) {
                uploadDataListener.onResult(30602);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("do_not_disturb", com.baidu.android.pushservice.frequency.b.a().a(i2, i3));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void setNotificationBuilder(Context context, int i2, PushNotificationBuilder pushNotificationBuilder) {
        if (f.m(context)) {
            return;
        }
        if (i2 < 1 || i2 > 1000) {
            com.baidu.android.pushservice.g.a.b("PushManager", "set notification builder error, id is illegal !", context.getApplicationContext());
        } else {
            d.a(context, i2, pushNotificationBuilder);
        }
    }

    public static void setPushBackStatus(Context context, boolean z) {
        if (f.m(context)) {
            return;
        }
        if (!z) {
            if (com.baidu.android.pushservice.b.d.d(context)) {
                a.a(context, true);
            }
            reStartWork(context);
        } else if ((!com.baidu.android.pushservice.b.d.q(context) || com.baidu.android.pushservice.b.d.c(context)) && com.baidu.android.pushservice.b.d.d(context)) {
            a.a(context, false);
            m.d(context);
            com.baidu.android.pushservice.job.a.b(context);
            f.n(context);
        }
    }

    public static void setPushFrequency(Context context, int i2, UploadDataListener uploadDataListener) {
        if (f.a(context, uploadDataListener)) {
            if (i2 < 1 || i2 > 3) {
                uploadDataListener.onResult(30602);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_PUSH_FREQ, Integer.valueOf(i2));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void setTags(Context context, List<String> list) {
        Intent c2;
        Iterator<String> it;
        if (list == null || list.size() == 0 || (c2 = f.c(context)) == null) {
            return;
        }
        String str = "[";
        while (list.iterator().hasNext()) {
            str = ((str + "\"") + it.next()) + "\",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        c2.putExtra("method", "method_set_tags");
        c2.putExtra(CommandMessage.TYPE_TAGS, str + "]");
        com.baidu.android.pushservice.g.a.a("PushManager", "a setTags intent send ", context.getApplicationContext());
        f.b(context, c2);
    }

    public static void startWork(Context context, int i2, String str) {
        if (f.m(context)) {
            return;
        }
        f.f3060a = i2;
        f.f3061b = str;
        h.b(context);
        String f2 = m.f(context, str);
        if (TextUtils.isEmpty(f2)) {
            f2 = "unKnow error";
        }
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.android.pushservice.CHECK_SDK", f2);
        com.baidu.android.pushservice.g.a.a("PushManager", "startWork from " + context.getPackageName() + " checkResult: " + f2, context.getApplicationContext());
        m.a("startWork from " + context.getPackageName() + " checkResult: " + f2, context);
        if ((TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", f2) || !PushSettings.e(context)) && i2 == 0) {
            f.a(context, i2, f.f3061b);
        } else {
            if (i2 != 0) {
                Log.e("BDPushSDK-PushManager", "Wrong LOGIN TYPE, Please use LOGIN_TYPE_API_KEY !");
            }
            f.c(context, 10101, f2);
        }
        m.k(context);
    }

    public static void stopWork(Context context) {
        if (f.m(context)) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushManager", "stopWork from" + context.getPackageName(), context.getApplicationContext());
        m.a("stopWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        f.g(context);
        a.a(context, false);
        m.a(context, true, false);
        m.d(context);
        com.baidu.android.pushservice.job.a.b(context);
        f.n(context);
    }

    public static void tokenBind(Context context, String str) {
        if (context == null || m.i(context) || TextUtils.isEmpty(str)) {
            return;
        }
        f.b(context, 0, str);
    }

    public static void uploadBduss(Context context, int i2, String str, UploadDataListener uploadDataListener) {
        if (f.a(context, uploadDataListener)) {
            if (i2 < 0 || i2 > 2 || TextUtils.isEmpty(str)) {
                uploadDataListener.onResult(30602);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_BDUSS_ACTION, Integer.valueOf(i2));
            hashMap.put("bduss", str);
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void uploadClickData(Context context, int i2, String str, String str2) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.frequency.b.a().a(context.getApplicationContext(), true, i2, str, str2);
    }

    public static void uploadData(Context context, HashMap<String, Object> hashMap, UploadDataListener uploadDataListener) {
        if (f.a(context, uploadDataListener)) {
            if (hashMap == null || hashMap.size() == 0) {
                uploadDataListener.onResult(30602);
            } else {
                com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
            }
        }
    }

    public static void uploadLocation(Context context, String str, UploadDataListener uploadDataListener) {
        if (f.a(context, uploadDataListener)) {
            if (TextUtils.isEmpty(str)) {
                uploadDataListener.onResult(30602);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("location", str);
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void uploadNotifyStatus(Context context, int i2, UploadDataListener uploadDataListener) {
        if (f.a(context, uploadDataListener)) {
            if (i2 < 0 || i2 > 2) {
                uploadDataListener.onResult(30602);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_APP_NOTIFY_STATUS, Integer.valueOf(i2));
            com.baidu.android.pushservice.frequency.b.a().a(context, hashMap, uploadDataListener);
        }
    }
}
