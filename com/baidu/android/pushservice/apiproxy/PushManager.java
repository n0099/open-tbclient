package com.baidu.android.pushservice.apiproxy;

import android.app.Activity;
import android.content.Context;
import java.util.List;
/* loaded from: classes.dex */
public class PushManager {
    public static void init(Context context, String str, String str2) {
        com.baidu.android.pushservice.internal.PushManager.init(context, str, str2);
    }

    public static void init(Context context, String str) {
        com.baidu.android.pushservice.internal.PushManager.init(context, str);
    }

    public static void initFromAKSK(Context context, String str) {
        com.baidu.android.pushservice.internal.PushManager.initFromAKSK(context, str);
    }

    public static void startWork(Context context, String str, String str2) {
        com.baidu.android.pushservice.internal.PushManager.startWork(context, str, str2);
    }

    public static void startWork(Context context, int i, String str) {
        com.baidu.android.pushservice.internal.PushManager.startWork(context, i, str);
    }

    public static void sdkStartWork(Context context, String str, int i) {
        com.baidu.android.pushservice.internal.PushManager.sdkStartWork(context, str, i);
    }

    public static void stopWork(Context context) {
        com.baidu.android.pushservice.internal.PushManager.stopWork(context);
    }

    public static void resumeWork(Context context) {
        com.baidu.android.pushservice.internal.PushManager.resumeWork(context);
    }

    public static boolean isPushEnabled(Context context) {
        return com.baidu.android.pushservice.internal.PushManager.isPushEnabled(context);
    }

    public static void activityStarted(Activity activity) {
        com.baidu.android.pushservice.internal.PushManager.activityStarted(activity);
    }

    public static void activityStoped(Activity activity) {
        com.baidu.android.pushservice.internal.PushManager.activityStoped(activity);
    }

    public static void setAccessToken(Context context, String str) {
        com.baidu.android.pushservice.internal.PushManager.setAccessToken(context, str);
    }

    public static void setApiKey(Context context, String str) {
        com.baidu.android.pushservice.internal.PushManager.setApiKey(context, str);
    }

    public static void setBduss(Context context, String str) {
        com.baidu.android.pushservice.internal.PushManager.setBduss(context, str);
    }

    public static void bind(Context context, int i) {
        com.baidu.android.pushservice.internal.PushManager.bind(context, i);
    }

    public static void sdkBind(Context context, int i, String str, int i2) {
        com.baidu.android.pushservice.internal.PushManager.sdkBind(context, i, str, i2);
    }

    public static void unbind(Context context) {
        com.baidu.android.pushservice.internal.PushManager.unbind(context);
    }

    public static void fetchMessages(Context context, int i, int i2) {
        com.baidu.android.pushservice.internal.PushManager.fetchMessages(context, i, i2);
    }

    public static void getMessageCounts(Context context) {
        com.baidu.android.pushservice.internal.PushManager.getMessageCounts(context);
    }

    public static void deleteMessages(Context context, String[] strArr) {
        com.baidu.android.pushservice.internal.PushManager.deleteMessages(context, strArr);
    }

    public static void sendMsgToUser(Context context, String str, String str2, String str3, String str4) {
        com.baidu.android.pushservice.internal.PushManager.sendMsgToUser(context, str, str2, str3, str4);
    }

    public static void bindGroup(Context context, String str) {
        com.baidu.android.pushservice.internal.PushManager.bindGroup(context, str);
    }

    public static void setTags(Context context, List<String> list) {
        com.baidu.android.pushservice.internal.PushManager.setTags(context, list);
    }

    public static void listTags(Context context) {
        com.baidu.android.pushservice.internal.PushManager.listTags(context);
    }

    public static void delTags(Context context, List<String> list) {
        com.baidu.android.pushservice.internal.PushManager.delTags(context, list);
    }

    public static void unbindGroup(Context context, String str) {
        com.baidu.android.pushservice.internal.PushManager.unbindGroup(context, str);
    }

    public static void getGroupInfo(Context context, String str) {
        com.baidu.android.pushservice.internal.PushManager.getGroupInfo(context, str);
    }

    public static void getGroupList(Context context) {
        com.baidu.android.pushservice.internal.PushManager.getGroupList(context);
    }

    public static void fetchGroupMessages(Context context, String str, int i, int i2) {
        com.baidu.android.pushservice.internal.PushManager.fetchGroupMessages(context, str, i, i2);
    }

    public static void getGroupMessageCounts(Context context, String str) {
        com.baidu.android.pushservice.internal.PushManager.getGroupMessageCounts(context, str);
    }

    public static void setDefaultNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        com.baidu.android.pushservice.internal.PushManager.setDefaultNotificationBuilder(context, pushNotificationBuilder.getInner());
    }

    public static void setNotificationBuilder(Context context, int i, PushNotificationBuilder pushNotificationBuilder) {
        try {
            com.baidu.android.pushservice.internal.PushManager.setNotificationBuilder(context, i, pushNotificationBuilder.getInner());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setMediaNotificationBuilder(Context context, PushNotificationBuilder pushNotificationBuilder) {
        com.baidu.android.pushservice.internal.PushManager.setMediaNotificationBuilder(context, pushNotificationBuilder.getInner());
    }

    public static boolean isConnected(Context context) {
        return com.baidu.android.pushservice.internal.PushManager.isConnected(context);
    }

    public static void tryConnect(Context context) {
        com.baidu.android.pushservice.internal.PushManager.tryConnect(context);
    }

    public static void enableLbs(Context context) {
        com.baidu.android.pushservice.internal.PushManager.enableLbs(context);
    }

    public static void disableLbs(Context context) {
        com.baidu.android.pushservice.internal.PushManager.disableLbs(context);
    }
}
