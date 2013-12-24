package com.baidu.android.pushservice.apiproxy;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
/* loaded from: classes.dex */
public class CustomPushNotificationBuilder extends PushNotificationBuilder {
    public CustomPushNotificationBuilder(com.baidu.android.pushservice.internal.CustomPushNotificationBuilder customPushNotificationBuilder) {
        this.mInstance = customPushNotificationBuilder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.android.pushservice.apiproxy.PushNotificationBuilder
    public com.baidu.android.pushservice.internal.CustomPushNotificationBuilder getInner() {
        return this.mInstance;
    }

    public CustomPushNotificationBuilder(int i, int i2, int i3, int i4) {
        this.mInstance = new com.baidu.android.pushservice.internal.CustomPushNotificationBuilder(i, i2, i3, i4);
    }

    public void setLayoutDrawable(int i) {
        this.mInstance.setLayoutDrawable(i);
    }

    @Override // com.baidu.android.pushservice.apiproxy.PushNotificationBuilder
    public Notification construct(Context context) {
        return this.mInstance.construct(context);
    }

    @Override // com.baidu.android.pushservice.apiproxy.PushNotificationBuilder
    public void setStatusbarIcon(int i) {
        this.mInstance.setStatusbarIcon(i);
    }

    @Override // com.baidu.android.pushservice.apiproxy.PushNotificationBuilder
    public void setNotificationTitle(String str) {
        this.mInstance.setNotificationTitle(str);
    }

    @Override // com.baidu.android.pushservice.apiproxy.PushNotificationBuilder
    public void setNotificationText(String str) {
        this.mInstance.setNotificationText(str);
    }

    @Override // com.baidu.android.pushservice.apiproxy.PushNotificationBuilder
    public void setNotificationFlags(int i) {
        this.mInstance.setNotificationFlags(i);
    }

    @Override // com.baidu.android.pushservice.apiproxy.PushNotificationBuilder
    public void setNotificationDefaults(int i) {
        this.mInstance.setNotificationDefaults(i);
    }

    @Override // com.baidu.android.pushservice.apiproxy.PushNotificationBuilder
    public void setNotificationSound(Uri uri) {
        this.mInstance.setNotificationSound(uri);
    }

    @Override // com.baidu.android.pushservice.apiproxy.PushNotificationBuilder
    public void setNotificationVibrate(long[] jArr) {
        this.mInstance.setNotificationVibrate(jArr);
    }
}
