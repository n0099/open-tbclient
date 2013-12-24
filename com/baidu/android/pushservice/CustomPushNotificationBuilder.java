package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
/* loaded from: classes.dex */
public class CustomPushNotificationBuilder extends PushNotificationBuilder {
    private boolean a;

    public CustomPushNotificationBuilder(Context context, com.baidu.android.pushservice.apiproxy.CustomPushNotificationBuilder customPushNotificationBuilder) {
        super(context);
        this.a = false;
        this.mInstance = customPushNotificationBuilder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    public com.baidu.android.pushservice.apiproxy.CustomPushNotificationBuilder getInner() {
        while (this.mInstance == null && !this.a) {
            a(50);
        }
        if (this.a) {
            return null;
        }
        return (com.baidu.android.pushservice.apiproxy.CustomPushNotificationBuilder) this.mInstance;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.android.pushservice.CustomPushNotificationBuilder$1] */
    public CustomPushNotificationBuilder(final Context context, final int i, final int i2, final int i3, final int i4) {
        super(context);
        this.a = false;
        if (LoadExecutor.isPushLibLoaded(context)) {
            this.mInstance = new com.baidu.android.pushservice.apiproxy.CustomPushNotificationBuilder(i, i2, i3, i4);
        } else {
            new Thread() { // from class: com.baidu.android.pushservice.CustomPushNotificationBuilder.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (!LoadExecutor.loadPush(context)) {
                        CustomPushNotificationBuilder.this.a = true;
                        return;
                    }
                    CustomPushNotificationBuilder.this.mInstance = new com.baidu.android.pushservice.apiproxy.CustomPushNotificationBuilder(i, i2, i3, i4);
                }
            }.start();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.CustomPushNotificationBuilder$2] */
    public void setLayoutDrawable(final int i) {
        if (this.mInstance != null) {
            ((com.baidu.android.pushservice.apiproxy.CustomPushNotificationBuilder) this.mInstance).setLayoutDrawable(i);
        } else {
            new Thread() { // from class: com.baidu.android.pushservice.CustomPushNotificationBuilder.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (CustomPushNotificationBuilder.this.mInstance == null && !CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.a(50);
                    }
                    if (!CustomPushNotificationBuilder.this.a) {
                        ((com.baidu.android.pushservice.apiproxy.CustomPushNotificationBuilder) CustomPushNotificationBuilder.this.mInstance).setLayoutDrawable(i);
                    }
                }
            }.start();
        }
    }

    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    public Notification construct(Context context) {
        if (LoadExecutor.loadPush(context)) {
            return this.mInstance.construct(context);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.CustomPushNotificationBuilder$3] */
    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    public void setStatusbarIcon(final int i) {
        if (this.mInstance != null) {
            this.mInstance.setStatusbarIcon(i);
        } else {
            new Thread() { // from class: com.baidu.android.pushservice.CustomPushNotificationBuilder.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (CustomPushNotificationBuilder.this.mInstance == null && !CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.a(50);
                    }
                    if (!CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.mInstance.setStatusbarIcon(i);
                    }
                }
            }.start();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.CustomPushNotificationBuilder$4] */
    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    public void setNotificationTitle(final String str) {
        if (this.mInstance != null) {
            this.mInstance.setNotificationTitle(str);
        } else {
            new Thread() { // from class: com.baidu.android.pushservice.CustomPushNotificationBuilder.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (CustomPushNotificationBuilder.this.mInstance == null && !CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.a(50);
                    }
                    if (!CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.mInstance.setNotificationTitle(str);
                    }
                }
            }.start();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.CustomPushNotificationBuilder$5] */
    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    public void setNotificationText(final String str) {
        if (this.mInstance != null) {
            this.mInstance.setNotificationText(str);
        } else {
            new Thread() { // from class: com.baidu.android.pushservice.CustomPushNotificationBuilder.5
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (CustomPushNotificationBuilder.this.mInstance == null && !CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.a(50);
                    }
                    if (!CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.mInstance.setNotificationText(str);
                    }
                }
            }.start();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.CustomPushNotificationBuilder$6] */
    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    public void setNotificationFlags(final int i) {
        if (this.mInstance != null) {
            this.mInstance.setNotificationFlags(i);
        } else {
            new Thread() { // from class: com.baidu.android.pushservice.CustomPushNotificationBuilder.6
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (CustomPushNotificationBuilder.this.mInstance == null && !CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.a(50);
                    }
                    if (!CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.mInstance.setNotificationFlags(i);
                    }
                }
            }.start();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.CustomPushNotificationBuilder$7] */
    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    public void setNotificationDefaults(final int i) {
        if (this.mInstance != null) {
            this.mInstance.setNotificationDefaults(i);
        } else {
            new Thread() { // from class: com.baidu.android.pushservice.CustomPushNotificationBuilder.7
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (CustomPushNotificationBuilder.this.mInstance == null && !CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.a(50);
                    }
                    if (!CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.mInstance.setNotificationDefaults(i);
                    }
                }
            }.start();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.CustomPushNotificationBuilder$8] */
    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    public void setNotificationSound(final Uri uri) {
        if (this.mInstance != null) {
            this.mInstance.setNotificationSound(uri);
        } else {
            new Thread() { // from class: com.baidu.android.pushservice.CustomPushNotificationBuilder.8
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (CustomPushNotificationBuilder.this.mInstance == null && !CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.a(50);
                    }
                    if (!CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.mInstance.setNotificationSound(uri);
                    }
                }
            }.start();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.android.pushservice.CustomPushNotificationBuilder$9] */
    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    public void setNotificationVibrate(final long[] jArr) {
        if (this.mInstance != null) {
            this.mInstance.setNotificationVibrate(jArr);
        } else {
            new Thread() { // from class: com.baidu.android.pushservice.CustomPushNotificationBuilder.9
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (CustomPushNotificationBuilder.this.mInstance == null && !CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.a(50);
                    }
                    if (!CustomPushNotificationBuilder.this.a) {
                        CustomPushNotificationBuilder.this.mInstance.setNotificationVibrate(jArr);
                    }
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        try {
            Thread.sleep(i);
        } catch (Exception e) {
        }
    }
}
