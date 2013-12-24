package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
/* loaded from: classes.dex */
public class BasicPushNotificationBuilder {
    private com.baidu.android.pushservice.apiproxy.BasicPushNotificationBuilder a;

    public BasicPushNotificationBuilder(Context context, com.baidu.android.pushservice.apiproxy.BasicPushNotificationBuilder basicPushNotificationBuilder) {
        this.a = basicPushNotificationBuilder;
    }

    public com.baidu.android.pushservice.apiproxy.BasicPushNotificationBuilder getInner() {
        return this.a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.android.pushservice.BasicPushNotificationBuilder$1] */
    public BasicPushNotificationBuilder(final Context context) {
        new Thread() { // from class: com.baidu.android.pushservice.BasicPushNotificationBuilder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (LoadExecutor.loadPush(context)) {
                    BasicPushNotificationBuilder.this.a = new com.baidu.android.pushservice.apiproxy.BasicPushNotificationBuilder();
                }
            }
        }.start();
    }

    public Notification construct(Context context) {
        if (LoadExecutor.loadPush(context)) {
            return this.a.construct(context);
        }
        return null;
    }

    private void a(int i) {
        try {
            Thread.sleep(i);
        } catch (Exception e) {
        }
    }
}
