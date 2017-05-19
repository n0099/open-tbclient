package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.pushservice.config.ModeConfig;
import com.baidu.android.pushservice.h.m;
import com.baidu.android.pushservice.h.o;
import com.baidu.android.pushservice.h.t;
import com.baidu.android.pushservice.h.u;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class PushManager {
    private static final String TAG = "PushManager";

    public static void delTags(Context context, List<String> list) {
        Iterator<String> it;
        String str;
        if (list == null || list.size() == 0) {
            com.baidu.android.pushservice.e.a.d(TAG, "No tags specified, do nothing.");
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
            com.baidu.android.pushservice.e.b.a(TAG, "a delTags intent send", context.getApplicationContext());
            f.b(context, a);
        }
    }

    public static void disableLbs(Context context) {
        if (f.g(context)) {
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
        if (f.g(context)) {
            return;
        }
        PushSettings.a(context, true);
    }

    public static void enableXiaomiProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.android.pushservice.e.a.d(TAG, "appId is null!");
        } else {
            f.d = str;
            m.a(context, "BD_PROXY_APPID_KEY", str);
        }
        if (TextUtils.isEmpty(str2)) {
            com.baidu.android.pushservice.e.a.d(TAG, "appKey is null!");
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

    public static String getHWNotifyCheckInfo(Context context, Intent intent) {
        if (intent != null) {
            try {
                return f.d(context, intent);
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.a(TAG, e);
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
                com.baidu.android.pushservice.e.a.a(TAG, e);
                return null;
            }
        }
        return null;
    }

    public static int getProxyType(Context context) {
        ModeConfig.getInstance(context);
        if (ModeConfig.isHuaweiProxyMode(context)) {
            return 1;
        }
        ModeConfig.getInstance(context);
        return ModeConfig.isXiaomiProxyMode(context) ? 2 : 0;
    }

    public static boolean hwMessageVerify(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || str2 == null) {
                return false;
            }
            return f.a(context, str, str2);
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a(TAG, e);
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
                String packageName = ModeConfig.isProxyMode(context) ? context.getPackageName() : u.u(context);
                if (packageName != null) {
                    com.baidu.android.pushservice.e.b.a(TAG, "PassThroughMessageClick  : " + packageName, context.getApplicationContext());
                    intent.putExtra("app_id", str2);
                    intent.putExtra(PbActivityConfig.KEY_MSG_ID, str);
                    intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
                    intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.e.b.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static void insertPassThroughMessageDelete(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            if (intent != null) {
                String packageName = ModeConfig.isProxyMode(context) ? context.getPackageName() : u.u(context);
                if (packageName != null) {
                    com.baidu.android.pushservice.e.b.a(TAG, "PassThroughMessageDelete  : " + packageName, context.getApplicationContext());
                    intent.putExtra("app_id", str2);
                    intent.putExtra(PbActivityConfig.KEY_MSG_ID, str);
                    intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.DELETE");
                    intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.e.b.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static void insertPassThroughMessageNotified(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            if (intent != null) {
                String packageName = ModeConfig.isProxyMode(context) ? context.getPackageName() : u.u(context);
                if (packageName != null) {
                    com.baidu.android.pushservice.e.b.a(TAG, "PassThroughMessageNotified  : " + packageName, context.getApplicationContext());
                    intent.putExtra("app_id", str2);
                    intent.putExtra(PbActivityConfig.KEY_MSG_ID, str);
                    intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED");
                    intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.e.b.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static boolean isPushEnabled(Context context) {
        return (f.g(context) || u.c(context)) ? false : true;
    }

    public static void listTags(Context context) {
        Intent a = f.a(context);
        if (a == null) {
            return;
        }
        a.putExtra(PushConstants.EXTRA_METHOD, "method_listtags");
        com.baidu.android.pushservice.e.b.a(TAG, "a listTags intent send", context.getApplicationContext());
        f.b(context, a);
    }

    public static void resumeWork(Context context) {
        if (f.g(context)) {
            return;
        }
        a.b(context, true);
        u.a(context, true, true);
        a.a(context, true);
        t.a(context);
        f.b(context, 0);
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (f.g(context)) {
            return;
        }
        d.a(context, pushNotificationBuilder);
    }

    public static void setMediaNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (f.g(context)) {
            return;
        }
        d.b(context, pushNotificationBuilder);
    }

    public static void setNoDisturbMode(Context context, int i, int i2, int i3, int i4) {
        if (f.g(context)) {
            return;
        }
        if (i < 0 || i > 23 || i3 < 0 || i3 > 23) {
            com.baidu.android.pushservice.e.b.a(TAG, "setNoDisturbMode hour parameters illegal!", context.getApplicationContext());
        } else if (i2 < 0 || i2 > 59 || i4 < 0 || i4 > 59) {
            com.baidu.android.pushservice.e.b.a(TAG, "setNoDisturbMode minute parameters illegal!", context.getApplicationContext());
        } else {
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.e.b.a(TAG, "PushManager setNoDisturbMode package name: " + packageName, context.getApplicationContext());
            o.a(context, packageName, i, i2, i3, i4);
        }
    }

    public static void setNotificationBuilder(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        if (f.g(context)) {
            return;
        }
        if (i < 1 || i > 1000) {
            com.baidu.android.pushservice.e.b.b(TAG, "set notification builder error, id is illegal !", context.getApplicationContext());
        } else {
            d.a(context, i, pushNotificationBuilder);
        }
    }

    public static void setTags(Context context, List<String> list) {
        Iterator<String> it;
        String str;
        if (list == null || list.size() == 0) {
            com.baidu.android.pushservice.e.a.d(TAG, "No tags specified, do nothing.");
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
            com.baidu.android.pushservice.e.b.a(TAG, "a setTags intent send ", context.getApplicationContext());
            f.b(context, a);
        }
    }

    public static void startWork(Context context, int i, String str) {
        if (f.g(context)) {
            return;
        }
        f.a = i;
        f.b = str;
        h.b(context);
        boolean k = u.k(context, str);
        com.baidu.android.pushservice.e.b.a(TAG, "startWork from " + context.getPackageName() + " check: " + k, context.getApplicationContext());
        u.b("startWork from " + context.getPackageName() + " check: " + k, context);
        if (k && i == 0) {
            f.a(context, i, f.b, true);
            return;
        }
        if (i != 0) {
            com.baidu.android.pushservice.e.b.b(TAG, "Wrong LOGIN TYPE, Please use LOGIN_TYPE_API_KEY !", context.getApplicationContext());
        }
        f.c(context, 10101);
    }

    public static void stopWork(Context context) {
        if (f.g(context)) {
            return;
        }
        u.b("stopWork from" + context.getPackageName() + " at time of " + System.currentTimeMillis(), context);
        f.e(context);
        a.b(context, false);
        u.a(context, true, true);
        a.a(context, true);
        u.f(context, context.getPackageName());
        SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
        edit.putBoolean("bind_status", false);
        edit.commit();
    }
}
