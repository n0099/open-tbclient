package cn.jpush.android.api;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import cn.jiguang.api.i;
import cn.jpush.android.a.g;
import cn.jpush.android.a.n;
import cn.jpush.android.d.f;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.service.ServiceInterface;
import com.baidu.baiduarsdk.ArBridge;
import com.tencent.tauth.AuthActivity;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class JPushInterface {
    public static final String ACTION_CONNECTION_CHANGE = "cn.jpush.android.intent.CONNECTION";
    public static final String ACTION_MESSAGE_RECEIVED = "cn.jpush.android.intent.MESSAGE_RECEIVED";
    public static final String ACTION_NOTIFICATION_CLICK_ACTION = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION";
    public static final String ACTION_NOTIFICATION_OPENED = "cn.jpush.android.intent.NOTIFICATION_OPENED";
    public static final String ACTION_NOTIFICATION_RECEIVED = "cn.jpush.android.intent.NOTIFICATION_RECEIVED";
    public static final String ACTION_NOTIFICATION_RECEIVED_PROXY = "cn.jpush.android.intent.NOTIFICATION_RECEIVED_PROXY";
    public static final String ACTION_REGISTRATION_ID = "cn.jpush.android.intent.REGISTRATION";
    public static final String ACTION_RICHPUSH_CALLBACK = "cn.jpush.android.intent.ACTION_RICHPUSH_CALLBACK";
    public static final String EXTRA_ACTIVITY_PARAM = "cn.jpush.android.ACTIVITY_PARAM";
    public static final String EXTRA_ALERT = "cn.jpush.android.ALERT";
    public static final String EXTRA_ALERT_TYPE = "cn.jpush.android.ALERT_TYPE";
    public static final String EXTRA_APP_KEY = "cn.jpush.android.APPKEY";
    public static final String EXTRA_BIG_PIC_PATH = "cn.jpush.android.BIG_PIC_PATH";
    public static final String EXTRA_BIG_TEXT = "cn.jpush.android.BIG_TEXT";
    public static final String EXTRA_CONNECTION_CHANGE = "cn.jpush.android.CONNECTION_CHANGE";
    public static final String EXTRA_CONTENT_TYPE = "cn.jpush.android.CONTENT_TYPE";
    public static final String EXTRA_EXTRA = "cn.jpush.android.EXTRA";
    public static final String EXTRA_INBOX = "cn.jpush.android.INBOX";
    public static final String EXTRA_MESSAGE = "cn.jpush.android.MESSAGE";
    public static final String EXTRA_MSG_ID = "cn.jpush.android.MSG_ID";
    public static final String EXTRA_NOTIFICATION_ACTION_EXTRA = "cn.jpush.android.NOTIFIACATION_ACTION_EXTRA";
    public static final String EXTRA_NOTIFICATION_DEVELOPER_ARG0 = "cn.jpush.android.NOTIFICATION_DEVELOPER_ARG0";
    public static final String EXTRA_NOTIFICATION_ID = "cn.jpush.android.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_TITLE = "cn.jpush.android.NOTIFICATION_CONTENT_TITLE";
    public static final String EXTRA_NOTI_CATEGORY = "cn.jpush.android.NOTI_CATEGORY";
    public static final String EXTRA_NOTI_PRIORITY = "cn.jpush.android.NOTI_PRIORITY";
    public static final String EXTRA_NOTI_TYPE = "cn.jpush.android.NOTIFICATION_TYPE";
    public static final String EXTRA_PUSH_ID = "cn.jpush.android.PUSH_ID";
    public static final String EXTRA_REGISTRATION_ID = "cn.jpush.android.REGISTRATION_ID";
    public static final String EXTRA_RICHPUSH_FILE_PATH = "cn.jpush.android.FILE_PATH";
    public static final String EXTRA_RICHPUSH_FILE_TYPE = "cn.jpush.android.FILE_TYPE";
    public static final String EXTRA_RICHPUSH_HTML_PATH = "cn.jpush.android.HTML_PATH";
    public static final String EXTRA_RICHPUSH_HTML_RES = "cn.jpush.android.HTML_RES";
    public static final String EXTRA_STATUS = "cn.jpush.android.STATUS";
    public static final String EXTRA_TITLE = "cn.jpush.android.TITLE";
    public static int a = 5;
    private static final Integer b = 0;

    static {
        cn.jiguang.api.e.c(cn.jpush.android.a.a, cn.jpush.android.a.d.class);
        cn.jiguang.api.e.b(cn.jpush.android.a.a, cn.jpush.android.a.c.class);
    }

    private static PushNotificationBuilder a(String str) {
        String string = i.getString(cn.jpush.android.a.e, "jpush_save_custom_builder" + str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (string.startsWith("basic") || string.startsWith("custom")) ? BasicPushNotificationBuilder.a(string) : MultiActionsNotificationBuilder.parseFromPreference(string);
    }

    private static void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
    }

    private static void a(Context context, boolean z, String str) {
        i.c(context, "notification_enabled", z);
        if (!z) {
            f.a("JPushInterface", "action:setPushTime - closed");
        } else if (!Pattern.compile("([0-6]{0,7})_((([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3]))|(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])-)+(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])))").matcher(str).matches()) {
            f.d("JPushInterface", "Invalid time format - " + str);
        } else {
            String b2 = cn.jpush.android.b.b(context);
            if (str.equals(b2)) {
                f.a("JPushInterface", "Already SetPushTime, give up - " + b2);
                return;
            }
            f.a("JPushInterface", "action:setPushTime - enabled:" + z + ", pushTime:" + str);
            cn.jpush.android.b.b(context, str, false);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 int)] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(int i) {
        if (i <= 0) {
            return false;
        }
        if (a(new StringBuilder().append(i).toString()) == null) {
            f.c("JPushInterface", "The builder with id:" + i + " has not been set in your app, use default builder!");
            return false;
        }
        return true;
    }

    public static void addLocalNotification(Context context, JPushLocalNotification jPushLocalNotification) {
        a(context);
        cn.jpush.android.service.a.a(context).a(context, jPushLocalNotification, false);
    }

    public static void addTags(Context context, int i, Set<String> set) {
        a(context);
        n.a(context, i, set, 1, 1);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v1 int)] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static PushNotificationBuilder b(int i) {
        if (i <= 0) {
            i = b.intValue();
        }
        PushNotificationBuilder pushNotificationBuilder = null;
        try {
            pushNotificationBuilder = a(new StringBuilder().append(i).toString());
        } catch (Exception e) {
        }
        return pushNotificationBuilder == null ? new DefaultPushNotificationBuilder() : pushNotificationBuilder;
    }

    public static void checkTagBindState(Context context, int i, String str) {
        a(context);
        HashSet hashSet = null;
        if (!TextUtils.isEmpty(str)) {
            hashSet = new HashSet();
            hashSet.add(str);
        }
        n.a(context, i, hashSet, 1, 6);
    }

    public static void cleanTags(Context context, int i) {
        a(context);
        n.a(context, i, new HashSet(), 1, 4);
    }

    public static void clearAllNotifications(Context context) {
        a(context);
        ServiceInterface.b(context);
    }

    public static void clearLocalNotifications(Context context) {
        a(context);
        Bundle bundle = new Bundle();
        cn.jpush.android.service.e.a(context, bundle, "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 8);
        cn.jiguang.api.e.b(context, cn.jpush.android.a.a, bundle);
    }

    public static void clearNotificationById(Context context, int i) {
        a(context);
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    public static void deleteAlias(Context context, int i) {
        a(context);
        n.a(context, i, (String) null, 2, 3);
    }

    public static void deleteTags(Context context, int i, Set<String> set) {
        a(context);
        n.a(context, i, set, 1, 3);
    }

    public static Set<String> filterValidTags(Set<String> set) {
        return n.a(set);
    }

    public static void getAlias(Context context, int i) {
        a(context);
        n.a(context, i, (String) null, 2, 5);
    }

    public static void getAllTags(Context context, int i) {
        a(context);
        n.a(context, i, new HashSet(), 1, 5);
    }

    public static boolean getConnectionState(Context context) {
        a(context);
        return cn.jiguang.api.e.getConnectionState(context);
    }

    public static String getRegistrationID(Context context) {
        a(context);
        return cn.jiguang.api.e.getRegistrationID(context);
    }

    public static String getStringTags(Set<String> set) {
        return n.b(set);
    }

    public static String getUdid(Context context) {
        a(context);
        return cn.jiguang.api.e.getDeviceId(context);
    }

    public static void init(Context context) {
        f.a("JPushInterface", "action:init - sdkVersion:" + ServiceInterface.a() + ", buildId:416");
        a(context);
        cn.jiguang.api.e.b(context, (int) InputDeviceCompat.SOURCE_TOUCHSCREEN, (Bundle) null);
        if (cn.jpush.android.a.a(context)) {
            if (cn.jiguang.api.e.be() && !cn.jpush.android.d.a.a(context)) {
                f.a("JPushInterface", "检测到当前没有网络。长连接将在有网络时自动继续建立。");
            }
            if (cn.jpush.android.b.a(context) == -1) {
                setLatestNotificationNumber(context, a);
            }
        }
    }

    public static void initCrashHandler(Context context) {
        a(context);
        cn.jiguang.api.e.initCrashHandler(context);
    }

    public static boolean isPushStopped(Context context) {
        a(context);
        return ServiceInterface.c(context);
    }

    public static void onFragmentPause(Context context, String str) {
        a(context);
        cn.jiguang.api.e.onFragmentPause(context, str);
    }

    public static void onFragmentResume(Context context, String str) {
        a(context);
        cn.jiguang.api.e.onFragmentResume(context, str);
    }

    public static void onKillProcess(Context context) {
        cn.jiguang.api.e.onKillProcess(context);
    }

    public static void onPause(Context context) {
        a(context);
        cn.jiguang.api.e.onPause(context);
    }

    public static void onResume(Context context) {
        a(context);
        cn.jiguang.api.e.onResume(context);
    }

    public static void removeLocalNotification(Context context, long j) {
        a(context);
        Bundle bundle = new Bundle();
        cn.jpush.android.service.e.a(context, bundle, "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 7);
        bundle.putLong("local_notification_id", j);
        cn.jiguang.api.e.b(context, cn.jpush.android.a.a, bundle);
    }

    public static void reportNotificationOpened(Context context, String str) {
        a(context);
        if (TextUtils.isEmpty(str)) {
            f.d("JPushInterface", "The msgId is not valid - " + str);
        }
        cn.jpush.android.a.e.a(str, ArBridge.MessageType.MSG_TYPE_VIDEO_STOP_RES, null, context);
    }

    public static void reportNotificationOpened(Context context, String str, byte b2) {
        a(context);
        if (TextUtils.isEmpty(str)) {
            f.d("JPushInterface", "The msgId is not valid - " + str);
        }
        cn.jpush.android.a.e.a(str, "", b2, 1000, context);
    }

    public static void requestPermission(Context context) {
        if (context == null) {
            f.c("JPushInterface", "[requestPermission] unexcepted - context was null");
        } else {
            cn.jiguang.api.e.requestPermission(context);
        }
    }

    public static void resumePush(Context context) {
        f.a("JPushInterface", "action:resumePush");
        a(context);
        ServiceInterface.b(context, 1);
        cn.jpush.android.c.d.a().b(context);
    }

    public static void setAlias(Context context, int i, String str) {
        a(context);
        n.a(context, i, str, 2, 2);
    }

    @Deprecated
    public static void setAlias(Context context, String str, TagAliasCallback tagAliasCallback) {
        a(context);
        setAliasAndTags(context, str, null, tagAliasCallback);
    }

    @Deprecated
    public static void setAliasAndTags(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback) {
        a(context);
        n.a(context, str, set, tagAliasCallback, 0, 0);
    }

    public static void setChannel(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        cn.jiguang.api.e.b(context, 4096, bundle);
    }

    public static void setDaemonAction(String str) {
        cn.jiguang.api.e.setDaemonAction(str);
    }

    public static void setDebugMode(boolean z) {
        cn.jiguang.api.e.setDebugMode(z);
    }

    public static void setDefaultPushNotificationBuilder(DefaultPushNotificationBuilder defaultPushNotificationBuilder) {
        if (defaultPushNotificationBuilder == null) {
            throw new IllegalArgumentException("NULL notification");
        }
        ServiceInterface.a(cn.jpush.android.a.e, b, defaultPushNotificationBuilder);
    }

    public static void setLatestNotificationNumber(Context context, int i) {
        a(context);
        f.a("JPushInterface", "action:setLatestNotificationNumber : " + i);
        if (i <= 0) {
            f.d("JPushInterface", "maxNum should > 0, Give up action..");
        } else {
            ServiceInterface.c(context, i);
        }
    }

    public static void setMobileNumber(Context context, int i, String str) {
        a(context);
        g.a();
        f.a("MobileNumberHelper", "action - setMobileNubmer, sequence:" + i + ",mobileNumber:" + str);
        if (ServiceInterface.d(context)) {
            g.a(context, i, b.m, str);
            return;
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (!cn.jpush.android.a.a(context)) {
            g.a(context, i, b.j, str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(AuthActivity.ACTION_KEY, "intent.MOBILE_NUMBER");
        bundle.putInt("sequence", i);
        bundle.putString("mobile_number", str);
        cn.jiguang.api.e.b(context, cn.jpush.android.a.a, bundle);
    }

    public static void setPowerSaveMode(Context context, boolean z) {
        cn.jiguang.api.e.setPowerSaveMode(context, z);
    }

    public static void setPushNotificationBuilder(Integer num, DefaultPushNotificationBuilder defaultPushNotificationBuilder) {
        if (defaultPushNotificationBuilder == null) {
            throw new IllegalArgumentException("NULL pushNotificationBuilder");
        }
        if (num.intValue() <= 0) {
            f.d("JPushInterface", "id should be larger than 0");
        } else {
            ServiceInterface.a(cn.jpush.android.a.e, num, defaultPushNotificationBuilder);
        }
    }

    public static void setPushTime(Context context, Set<Integer> set, int i, int i2) {
        a(context);
        if (cn.jiguang.api.e.be() && !cn.jpush.android.d.a.a(context)) {
            f.a("JPushInterface", "检测到当前没有网络。此动作将在有网络时自动继续执行。");
        }
        if (set == null) {
            a(context, true, "0123456_0^23");
        } else if (set.size() == 0 || set.isEmpty()) {
            a(context, false, "0123456_0^23");
        } else if (i > i2) {
            f.d("JPushInterface", "Invalid time format - startHour should less than endHour");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Integer num : set) {
                if (num.intValue() > 6 || num.intValue() < 0) {
                    f.d("JPushInterface", "Invalid day format - " + num);
                    return;
                }
                sb.append(num);
            }
            sb.append("_");
            sb.append(i);
            sb.append("^");
            sb.append(i2);
            a(context, true, sb.toString());
        }
    }

    public static void setSilenceTime(Context context, int i, int i2, int i3, int i4) {
        a(context);
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || i2 > 59 || i4 > 59 || i3 > 23 || i > 23) {
            f.d("JPushInterface", "Invalid parameter format, startHour and endHour should between 0 ~ 23, startMins and endMins should between 0 ~ 59. ");
        } else if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            ServiceInterface.a(context, "");
            f.a("JPushInterface", "Remove the silence time!");
        } else if (ServiceInterface.a(context, i, i2, i3, i4)) {
            f.a("JPushInterface", "Set Silence PushTime - " + i + " : " + i2 + " -- " + i3 + " : " + i4);
        } else {
            f.d("JPushInterface", "Set Silence PushTime Failed");
        }
    }

    public static void setStatisticsEnable(boolean z) {
    }

    public static void setStatisticsSessionTimeout(long j) {
        if (j < 10) {
            f.c("JPushInterface", "sesseion timeout less than 10s");
        } else if (j > 86400) {
            f.c("JPushInterface", "sesseion timeout larger than 1day");
        }
    }

    public static void setTags(Context context, int i, Set<String> set) {
        a(context);
        n.a(context, i, set, 1, 2);
    }

    @Deprecated
    public static void setTags(Context context, Set<String> set, TagAliasCallback tagAliasCallback) {
        a(context);
        setAliasAndTags(context, null, set, tagAliasCallback);
    }

    public static void stopCrashHandler(Context context) {
        a(context);
        cn.jiguang.api.e.stopCrashHandler(context);
    }

    public static void stopPush(Context context) {
        f.a("JPushInterface", "action:stopPush");
        a(context);
        ServiceInterface.a(context, 1);
        cn.jpush.android.c.d.a().c(context);
    }

    @Deprecated
    public void setAliasAndTags(Context context, String str, Set<String> set) {
        a(context);
        n.a(context, str, set, null, 0, 0);
    }
}
