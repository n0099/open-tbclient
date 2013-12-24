package com.baidu.android.pushservice.apiproxy;

import android.app.Notification;
import android.content.Context;
/* loaded from: classes.dex */
public class BasicPushNotificationBuilder {
    private com.baidu.android.pushservice.internal.BasicPushNotificationBuilder a;

    public BasicPushNotificationBuilder(com.baidu.android.pushservice.internal.BasicPushNotificationBuilder basicPushNotificationBuilder) {
        this.a = basicPushNotificationBuilder;
    }

    public com.baidu.android.pushservice.internal.BasicPushNotificationBuilder getInner() {
        return this.a;
    }

    public BasicPushNotificationBuilder() {
        this.a = new com.baidu.android.pushservice.internal.BasicPushNotificationBuilder();
    }

    public Notification construct(Context context) {
        return this.a.construct(context);
    }
}
