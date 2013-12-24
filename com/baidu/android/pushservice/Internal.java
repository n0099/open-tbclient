package com.baidu.android.pushservice;

import android.content.Context;
/* loaded from: classes.dex */
public class Internal {
    public static void enablePushService(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.Internal.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.Internal.enablePushService(context);
            }
        }, context);
    }

    public static void disablePushService(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.Internal.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.Internal.disablePushService(context);
            }
        }, context);
    }

    public static void disablePushConnection(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.Internal.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.Internal.disablePushConnection(context);
            }
        }, context);
    }

    public static void enablePushConnection(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.Internal.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.Internal.enablePushConnection(context);
            }
        }, context);
    }

    public static void createBdussIntent(final Context context) {
        LoadExecutor.excuteMethod(new Runnable() { // from class: com.baidu.android.pushservice.Internal.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.android.pushservice.apiproxy.Internal.createBdussIntent(context);
            }
        }, context);
    }
}
