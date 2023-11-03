package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.pushservice.a0.m;
import com.baidu.android.pushservice.database.PushConfigData;
import com.baidu.android.pushservice.frequency.GetFrequencyListener;
import com.baidu.android.pushservice.frequency.GetNoDisturbListener;
import com.baidu.android.pushservice.frequency.UploadDataListener;
import com.baidu.android.pushservice.httpapi.TokenBindListener;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes.dex */
public class PushManager {
    public static final String TAG = "PushManager";

    public static void bindPush(Context context, String str) {
        if (Utility.b(context)) {
            return;
        }
        e.a(context, 0, str, true);
    }

    public static void changeBackGroundAlarm(Context context, boolean z) {
        if ((!com.baidu.android.pushservice.l.d.r(context) || com.baidu.android.pushservice.l.d.q(context)) && Build.VERSION.SDK_INT >= 28 && !TextUtils.isEmpty(e.b)) {
            context.sendBroadcast(e.a(context, z));
        }
    }

    public static void clearIconBadge(Context context) {
        com.baidu.android.pushservice.r.c.a().a(context);
    }

    public static void closeNoDisturb(Context context, UploadDataListener uploadDataListener) {
        if (e.a(context, uploadDataListener)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("do_not_disturb", com.baidu.android.pushservice.n.c.a().a(-1, -1));
            com.baidu.android.pushservice.n.c.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void createNotificationChannel(Context context, String str, String str2) {
        if (Utility.E(context)) {
            com.baidu.android.pushservice.a0.h.a(context, str, str2);
        }
    }

    public static void delTags(Context context, List<String> list) {
        Intent i;
        if (list == null || list.size() == 0 || (i = e.i(context)) == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        String str = PreferencesUtil.LEFT_MOUNT;
        while (it.hasNext()) {
            str = ((str + "\"") + it.next()) + "\",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        i.putExtra("method", "method_del_tags");
        i.putExtra("tags", str + PreferencesUtil.RIGHT_MOUNT);
        com.baidu.android.pushservice.u.a.a(TAG, "a delTags intent send", context.getApplicationContext());
        e.a(context, i);
    }

    public static void deleteNotificationChannel(Context context, String str) {
        if (Utility.E(context)) {
            com.baidu.android.pushservice.a0.h.a(context, str);
        }
    }

    public static void disableAlarm(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            context.sendBroadcast(e.m(context));
        }
    }

    public static void enableHonorProxy(Context context, boolean z) {
        PushSettings.d = z ? 1 : 0;
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushSettings.hn_proxy_mode", z ? 1 : 0);
    }

    public static void enableHuaweiProxy(Context context, boolean z) {
        PushSettings.c = z ? 1 : 0;
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", z ? 1 : 0);
    }

    public static void enableMeizuProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e.e = str;
        com.baidu.android.pushservice.a0.i.b(context, "BD_MEIZU_PROXY_APPID_KEY", str);
        e.f = str2;
        com.baidu.android.pushservice.a0.i.b(context, "BD_MEIZU_PROXY_APPKEY_KEY", str2);
        PushSettings.e = z ? 1 : 0;
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", z ? 1 : 0);
    }

    public static void enableOppoProxy(Context context, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e.g = str;
        com.baidu.android.pushservice.a0.i.b(context, "BD_OPPO_PROXY_APPKEY_KEY", str);
        e.h = str2;
        com.baidu.android.pushservice.a0.i.b(context, "BD_OPPO_PROXY_APPSECRET_KEY", str2);
        PushSettings.f = z ? 1 : 0;
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", z ? 1 : 0);
    }

    public static void enableVivoProxy(Context context, boolean z) {
        PushSettings.g = z ? 1 : 0;
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", z ? 1 : 0);
    }

    public static void enableXiaomiProxy(Context context, boolean z, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            e.c = str;
            com.baidu.android.pushservice.a0.i.b(context, "BD_PROXY_APPID_KEY", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            e.d = str2;
            com.baidu.android.pushservice.a0.i.b(context, "BD_PROXY_APPKEY_KEY", str2);
        }
        PushSettings.b = z ? 1 : 0;
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", z ? 1 : 0);
    }

    public static int getBindType(Context context) {
        if (Utility.b(context)) {
            if (com.baidu.android.pushservice.l.d.m(context)) {
                return 2;
            }
            if (com.baidu.android.pushservice.l.d.B(context)) {
                return 3;
            }
            if (com.baidu.android.pushservice.l.d.n(context)) {
                return 4;
            }
            if (com.baidu.android.pushservice.l.d.p(context)) {
                return 5;
            }
            if (com.baidu.android.pushservice.l.d.A(context)) {
                return 6;
            }
            return com.baidu.android.pushservice.l.d.l(context) ? 7 : 1;
        }
        return 0;
    }

    public static PushConfigData getLocalData(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.android.pushservice.n.c.a().a(context, str);
    }

    public static void getNoDisturbOnline(Context context, GetNoDisturbListener getNoDisturbListener) {
        if (getNoDisturbListener == null) {
            return;
        }
        if (context == null) {
            getNoDisturbListener.onResult(IMConstants.ERROR_GROUP_DISBAND, 0, 0);
        } else {
            com.baidu.android.pushservice.n.c.a().b(context, "do_not_disturb", getNoDisturbListener);
        }
    }

    public static void getPushFrequency(Context context, GetFrequencyListener getFrequencyListener) {
        if (getFrequencyListener == null || context == null) {
            return;
        }
        com.baidu.android.pushservice.n.c.a().b(context, PushConstants.EXTRA_PUSH_FREQ, getFrequencyListener);
    }

    public static void insertPassThroughMessageClick(Context context, String str, String str2) {
        if (e.s(context) || str == null || str2 == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.u.a.a(TAG, "PassThroughMessageClick  : " + packageName, context.getApplicationContext());
            intent.putExtra("app_id", str2);
            intent.putExtra("msg_id", str);
            intent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
            intent.setClassName(packageName, "com.baidu.android.pushservice.CommandService");
            context.startService(intent);
        } catch (Exception e) {
            com.baidu.android.pushservice.u.a.b(TAG, "error " + e.getMessage(), context.getApplicationContext());
        }
    }

    public static boolean isPushEnabled(Context context) {
        if (e.s(context)) {
            return false;
        }
        return !Utility.C(context.getApplicationContext());
    }

    public static void listTags(Context context) {
        Intent i = e.i(context);
        if (i == null) {
            return;
        }
        i.putExtra("method", "method_listtags");
        com.baidu.android.pushservice.u.a.a(TAG, "a listTags intent send", context.getApplicationContext());
        e.a(context, i);
    }

    public static void reStartWork(Context context) {
        if (Utility.b(context) && isPushEnabled(context)) {
            m.a(context, (Intent) null);
        }
    }

    public static void requestOppoNotification(Context context) {
        if (Utility.N(context) && com.baidu.android.pushservice.l.d.w(context)) {
            Utility.c();
        }
    }

    public static void resumeWork(Context context) {
        if (e.s(context)) {
            return;
        }
        a.a(context, true);
        Utility.a(context, true, true);
        e.a(context, 0);
        m.a(context);
    }

    public static void saveAccessToken(Context context, String str) {
        if (str != null) {
            com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.USER_ACCESS_TOKEN", str);
        }
    }

    public static void sendPushMsgAck(Context context, String str, int i) {
        Utility.c(context, str, i);
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        if (e.s(context)) {
            return;
        }
        NotificationBuilderManager.a(context, pushNotificationBuilder);
    }

    public static void setNoDisturbMode(Context context, int i, int i2, int i3, int i4) {
        if (e.s(context)) {
            return;
        }
        if (i < 0 || i > 23 || i3 < 0 || i3 > 23) {
            com.baidu.android.pushservice.u.a.a(TAG, "setNoDisturbMode hour parameters illegal!", context.getApplicationContext());
        } else if (i2 < 0 || i2 > 59 || i4 < 0 || i4 > 59) {
            com.baidu.android.pushservice.u.a.a(TAG, "setNoDisturbMode minute parameters illegal!", context.getApplicationContext());
        } else {
            String packageName = context.getPackageName();
            com.baidu.android.pushservice.u.a.a(TAG, "PushManager setNoDisturbMode package name: " + packageName, context.getApplicationContext());
            com.baidu.android.pushservice.m.b.a(context, packageName, i, i2, i3, i4);
        }
    }

    public static void setNoDisturbOnline(Context context, int i, int i2, UploadDataListener uploadDataListener) {
        if (e.a(context, uploadDataListener)) {
            if (i > 86400 || i2 > 86400 || i < 0 || i2 < 0) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("do_not_disturb", com.baidu.android.pushservice.n.c.a().a(i, i2));
            com.baidu.android.pushservice.n.c.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void setNotificationBuilder(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        if (e.s(context)) {
            return;
        }
        if (i < 1 || i > 1000) {
            com.baidu.android.pushservice.u.a.b(TAG, "set notification builder error, id is illegal !", context.getApplicationContext());
        } else {
            NotificationBuilderManager.a(context, i, pushNotificationBuilder);
        }
    }

    public static void setProcessSource(Context context, int i) {
        com.baidu.android.pushservice.t.a.a(context).a(i);
    }

    public static void setPushBackStatus(Context context, boolean z) {
        com.baidu.android.pushservice.l.d.u = 1;
        if (e.s(context)) {
            return;
        }
        if (!z) {
            if (com.baidu.android.pushservice.l.d.b(context)) {
                a.a(context, true);
            }
            reStartWork(context);
        } else if ((!com.baidu.android.pushservice.l.d.r(context) || com.baidu.android.pushservice.l.d.q(context)) && com.baidu.android.pushservice.l.d.b(context)) {
            a.a(context, false);
            Utility.V(context);
            com.baidu.android.pushservice.s.a.a(context);
            e.B(context);
        }
    }

    public static void setPushFrequency(Context context, int i, UploadDataListener uploadDataListener) {
        if (e.a(context, uploadDataListener)) {
            if (i < 1 || i > 7) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_PUSH_FREQ, Integer.valueOf(i));
            com.baidu.android.pushservice.n.c.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void setPushLaunchTaskLevel(int i, Context context) {
        if (context == null || com.baidu.android.pushservice.a0.i.a(context, "key_push_launch_task_level", 0) == i) {
            return;
        }
        com.baidu.android.pushservice.a0.i.b(context, "key_push_launch_task_level", i);
        if (i != 1) {
            e.d(context, 1);
            resumeWork(context);
            return;
        }
        e.d(context, 2);
        com.baidu.android.pushservice.s.a.a(context);
        context.sendBroadcast(e.m(context));
    }

    public static void setTags(Context context, List<String> list) {
        Intent i;
        if (list == null || list.size() == 0 || (i = e.i(context)) == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        String str = PreferencesUtil.LEFT_MOUNT;
        while (it.hasNext()) {
            str = ((str + "\"") + it.next()) + "\",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        i.putExtra("method", "method_set_tags");
        i.putExtra("tags", str + PreferencesUtil.RIGHT_MOUNT);
        com.baidu.android.pushservice.u.a.a(TAG, "a setTags intent send ", context.getApplicationContext());
        e.a(context, i);
    }

    public static void showAsyncNotification(Context context, long j, int i) {
        com.baidu.android.pushservice.x.a.a(context, j, i);
    }

    public static void startWork(Context context, int i, String str) {
        if (e.s(context)) {
            return;
        }
        e.u(context);
        e.a = i;
        e.b = str;
        g.d(context);
        String c = Utility.c(context, str);
        if (TextUtils.isEmpty(c)) {
            c = "unKnow error";
        }
        com.baidu.android.pushservice.a0.i.b(context, "com.baidu.android.pushservice.CHECK_SDK", c);
        com.baidu.android.pushservice.u.a.a(TAG, "startWork from " + context.getPackageName() + " checkResult: " + c, context.getApplicationContext());
        if ((TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", c) || !PushSettings.f(context)) && i == 0) {
            e.b(context, i, e.b);
        } else {
            if (i != 0) {
                Log.e("BDPushSDK-PushManager", "Wrong LOGIN TYPE, Please use LOGIN_TYPE_API_KEY !");
            }
            e.a(context, 10101, c);
        }
        Utility.Y(context);
    }

    public static void startWorkWithSource(Context context, int i, String str, ClientEventInfo clientEventInfo) {
        if (clientEventInfo == null) {
            clientEventInfo = new ClientEventInfo();
        }
        e.c(context, clientEventInfo.getSource());
        com.baidu.android.pushservice.y.f.a.a(context, clientEventInfo);
        if (Utility.I(context) || e.r(context)) {
            if (j.a(context.getApplicationContext()).e() && e.f(context)) {
                m.b(context.getApplicationContext(), null, clientEventInfo);
            } else {
                e.a(context, i, str, clientEventInfo);
            }
        }
    }

    public static void stopWork(Context context) {
        if (e.s(context)) {
            return;
        }
        com.baidu.android.pushservice.u.a.a(TAG, "stopWork from" + context.getPackageName(), context.getApplicationContext());
        e.C(context);
        a.a(context, false);
        Utility.a(context, true, false);
        Utility.V(context);
        com.baidu.android.pushservice.s.a.a(context);
        e.B(context);
    }

    public static void tokenBind(Context context, String str, int i, String str2, TokenBindListener tokenBindListener) {
        e.a(context, str, i, str2, new ClientEventInfo(), tokenBindListener);
    }

    public static void tokenBindPullMsg(Context context, String str, ClientEventInfo clientEventInfo, TokenBindListener tokenBindListener) {
        if (clientEventInfo == null) {
            clientEventInfo = new ClientEventInfo();
        }
        ClientEventInfo clientEventInfo2 = clientEventInfo;
        if (clientEventInfo2.getHasConfirmDialog() == -1) {
            if (TextUtils.isEmpty(Utility.getIIdBindChannelId(context))) {
                e.a(context, str, 1, clientEventInfo2.getIId(), clientEventInfo2, tokenBindListener);
            } else if (com.baidu.android.pushservice.y.c.g(context) != 0) {
                com.baidu.android.pushservice.y.d.d(context, clientEventInfo2);
            }
        }
    }

    public static void uploadBduss(Context context, int i, String str, UploadDataListener uploadDataListener) {
        if (e.a(context, uploadDataListener)) {
            if (i < 0 || i > 2 || TextUtils.isEmpty(str)) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_BDUSS_ACTION, Integer.valueOf(i));
            hashMap.put("bduss", str);
            com.baidu.android.pushservice.n.c.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void uploadClickData(Context context, int i, String str, String str2) {
        if (context == null) {
            return;
        }
        com.baidu.android.pushservice.n.c.a().a(context.getApplicationContext(), true, i, str, str2, "");
    }

    public static void uploadData(Context context, HashMap<String, Object> hashMap, UploadDataListener uploadDataListener) {
        if (e.a(context, uploadDataListener)) {
            if (hashMap == null || hashMap.size() == 0) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
            } else {
                com.baidu.android.pushservice.n.c.a().a(context, hashMap, uploadDataListener);
            }
        }
    }

    public static void uploadLocation(Context context, String str, UploadDataListener uploadDataListener) {
        if (e.a(context, uploadDataListener)) {
            if (TextUtils.isEmpty(str)) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("location", str);
            com.baidu.android.pushservice.n.c.a().a(context, hashMap, uploadDataListener);
        }
    }

    public static void uploadNotifyStatus(Context context, int i, UploadDataListener uploadDataListener) {
        if (e.a(context, uploadDataListener)) {
            if (i < 0 || i > 2) {
                uploadDataListener.onResult(IMConstants.ERROR_GROUP_DISBAND);
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PushConstants.EXTRA_APP_NOTIFY_STATUS, Integer.valueOf(i));
            com.baidu.android.pushservice.n.c.a().a(context, hashMap, uploadDataListener);
        }
    }
}
