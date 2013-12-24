package com.baidu.android.pushservice;

import android.app.Activity;
import android.content.Context;
import java.util.List;
/* loaded from: classes.dex */
public class PushManager {
    public static void init(final Context context, final String str, final String str2) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.init(context, str, str2);
            }
        }, context);
    }

    public static void init(final Context context, final String str) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.12
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.init(context, str);
            }
        }, context);
    }

    public static void initFromAKSK(final Context context, final String str) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.23
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.initFromAKSK(context, str);
            }
        }, context);
    }

    public static void startWork(final Context context, final String str, final String str2) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.32
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.startWork(context, str, str2);
            }
        }, context);
    }

    public static void startWork(final Context context, final int i, final String str) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.33
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.startWork(context, i, str);
            }
        }, context);
    }

    public static void sdkStartWork(final Context context, final String str, final int i) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.34
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.sdkStartWork(context, str, i);
            }
        }, context);
    }

    public static void stopWork(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.35
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.stopWork(context);
            }
        }, context);
    }

    public static void resumeWork(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.36
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.resumeWork(context);
            }
        }, context);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.PushManager$37] */
    public static boolean isPushEnabled(final Context context) {
        try {
            context.getClassLoader().loadClass("com.baidu.android.pushservice.internal.PushManager");
            return com.baidu.android.pushservice.apiproxy.PushManager.isPushEnabled(context);
        } catch (ClassNotFoundException e) {
            new Thread() { // from class: com.baidu.android.pushservice.PushManager.37
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    LoadExecutor.loadPush(context);
                }
            }.start();
            return false;
        }
    }

    public static void activityStarted(final Activity activity) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.activityStarted(activity);
            }
        }, activity);
    }

    public static void activityStoped(final Activity activity) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.activityStoped(activity);
            }
        }, activity);
    }

    public static void setAccessToken(final Context context, final String str) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.setAccessToken(context, str);
            }
        }, context);
    }

    public static void setApiKey(final Context context, final String str) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.setApiKey(context, str);
            }
        }, context);
    }

    public static void setBduss(final Context context, final String str) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.6
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.setBduss(context, str);
            }
        }, context);
    }

    public static void bind(final Context context, final int i) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.7
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.bind(context, i);
            }
        }, context);
    }

    public static void sdkBind(final Context context, final int i, final String str, final int i2) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.sdkBind(context, i, str, i2);
            }
        }, context);
    }

    public static void unbind(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.9
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.unbind(context);
            }
        }, context);
    }

    public static void fetchMessages(final Context context, final int i, final int i2) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.10
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.fetchMessages(context, i, i2);
            }
        }, context);
    }

    public static void getMessageCounts(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.11
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.getMessageCounts(context);
            }
        }, context);
    }

    public static void deleteMessages(final Context context, final String[] strArr) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.13
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.deleteMessages(context, strArr);
            }
        }, context);
    }

    public static void sendMsgToUser(final Context context, final String str, final String str2, final String str3, final String str4) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.14
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.sendMsgToUser(context, str, str2, str3, str4);
            }
        }, context);
    }

    public static void bindGroup(final Context context, final String str) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.15
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.bindGroup(context, str);
            }
        }, context);
    }

    public static void setTags(final Context context, final List<String> list) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.16
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.setTags(context, list);
            }
        }, context);
    }

    public static void listTags(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.17
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.listTags(context);
            }
        }, context);
    }

    public static void delTags(final Context context, final List<String> list) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.18
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.delTags(context, list);
            }
        }, context);
    }

    public static void unbindGroup(final Context context, final String str) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.19
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.unbindGroup(context, str);
            }
        }, context);
    }

    public static void getGroupInfo(final Context context, final String str) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.20
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.getGroupInfo(context, str);
            }
        }, context);
    }

    public static void getGroupList(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.21
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.getGroupList(context);
            }
        }, context);
    }

    public static void fetchGroupMessages(final Context context, final String str, final int i, final int i2) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.22
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.fetchGroupMessages(context, str, i, i2);
            }
        }, context);
    }

    public static void getGroupMessageCounts(final Context context, final String str) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.24
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.getGroupMessageCounts(context, str);
            }
        }, context);
    }

    public static void setDefaultNotificationBuilder(final Context context, final PushNotificationBuilder pushNotificationBuilder) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.setDefaultNotificationBuilder(context, pushNotificationBuilder.getInner());
            }
        }, context);
    }

    public static void setNotificationBuilder(final Context context, final int i, final PushNotificationBuilder pushNotificationBuilder) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.26
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.setNotificationBuilder(context, i, pushNotificationBuilder.getInner());
            }
        }, context);
    }

    public static void setMediaNotificationBuilder(final Context context, final PushNotificationBuilder pushNotificationBuilder) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.27
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.setMediaNotificationBuilder(context, pushNotificationBuilder.getInner());
            }
        }, context);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.PushManager$28] */
    public static boolean isConnected(final Context context) {
        try {
            context.getClassLoader().loadClass("com.baidu.android.pushservice.internal.PushManager");
            return com.baidu.android.pushservice.apiproxy.PushManager.isConnected(context);
        } catch (ClassNotFoundException e) {
            new Thread() { // from class: com.baidu.android.pushservice.PushManager.28
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    LoadExecutor.loadPush(context);
                }
            }.start();
            return false;
        }
    }

    public static void tryConnect(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.29
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.tryConnect(context);
            }
        }, context);
    }

    public static void enableLbs(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.30
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.enableLbs(context);
            }
        }, context);
    }

    public static void disableLbs(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.PushManager.31
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.PushManager.disableLbs(context);
            }
        }, context);
    }
}
