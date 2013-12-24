package com.baidu.android.pushservice.apiproxy;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
/* loaded from: classes.dex */
public abstract class PushNotificationBuilder {
    protected com.baidu.android.pushservice.internal.PushNotificationBuilder mInstance;

    public abstract Notification construct(Context context);

    public PushNotificationBuilder(com.baidu.android.pushservice.internal.PushNotificationBuilder pushNotificationBuilder) {
        this.mInstance = pushNotificationBuilder;
    }

    public com.baidu.android.pushservice.internal.PushNotificationBuilder getInner() {
        return this.mInstance;
    }

    public PushNotificationBuilder() {
        this.mInstance = new com.baidu.android.pushservice.internal.PushNotificationBuilder() { // from class: com.baidu.android.pushservice.apiproxy.PushNotificationBuilder.1
            public Notification construct(Context context) {
                return PushNotificationBuilder.this.construct(context);
            }
        };
    }

    public void setStatusbarIcon(int i) {
        this.mInstance.setStatusbarIcon(i);
    }

    public void setNotificationTitle(String str) {
        this.mInstance.setNotificationTitle(str);
    }

    public void setNotificationText(String str) {
        this.mInstance.setNotificationText(str);
    }

    public void setNotificationFlags(int i) {
        this.mInstance.setNotificationFlags(i);
    }

    public void setNotificationDefaults(int i) {
        this.mInstance.setNotificationDefaults(i);
    }

    public void setNotificationSound(Uri uri) {
        this.mInstance.setNotificationSound(uri);
    }

    public void setNotificationVibrate(long[] jArr) {
        this.mInstance.setNotificationVibrate(jArr);
    }
}
