package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
/* loaded from: classes.dex */
public abstract class PushNotificationBuilder {
    private boolean a;
    protected com.baidu.android.pushservice.apiproxy.PushNotificationBuilder mInstance;

    public abstract Notification construct(Context context);

    public PushNotificationBuilder(Context context, com.baidu.android.pushservice.apiproxy.PushNotificationBuilder pushNotificationBuilder) {
        this.a = false;
        this.mInstance = null;
        this.mInstance = pushNotificationBuilder;
    }

    public com.baidu.android.pushservice.apiproxy.PushNotificationBuilder getInner() {
        return this.mInstance;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.android.pushservice.PushNotificationBuilder$1] */
    public PushNotificationBuilder(final Context context) {
        this.a = false;
        this.mInstance = null;
        new Thread() { // from class: com.baidu.android.pushservice.PushNotificationBuilder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                PushNotificationBuilder.this.a = !LoadExecutor.loadPush(context);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.android.pushservice.PushNotificationBuilder$2] */
    public void setStatusbarIcon(final int i) {
        new Thread() { // from class: com.baidu.android.pushservice.PushNotificationBuilder.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (PushNotificationBuilder.this.mInstance == null && !PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.a(50);
                }
                if (!PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.mInstance.setStatusbarIcon(i);
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.android.pushservice.PushNotificationBuilder$3] */
    public void setNotificationTitle(final String str) {
        new Thread() { // from class: com.baidu.android.pushservice.PushNotificationBuilder.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (PushNotificationBuilder.this.mInstance == null && !PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.a(50);
                }
                if (!PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.mInstance.setNotificationTitle(str);
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.android.pushservice.PushNotificationBuilder$4] */
    public void setNotificationText(final String str) {
        new Thread() { // from class: com.baidu.android.pushservice.PushNotificationBuilder.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (PushNotificationBuilder.this.mInstance == null && !PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.a(50);
                }
                if (!PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.mInstance.setNotificationText(str);
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.android.pushservice.PushNotificationBuilder$5] */
    public void setNotificationFlags(final int i) {
        new Thread() { // from class: com.baidu.android.pushservice.PushNotificationBuilder.5
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (PushNotificationBuilder.this.mInstance == null && !PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.a(50);
                }
                if (!PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.mInstance.setNotificationFlags(i);
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.android.pushservice.PushNotificationBuilder$6] */
    public void setNotificationDefaults(final int i) {
        new Thread() { // from class: com.baidu.android.pushservice.PushNotificationBuilder.6
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (PushNotificationBuilder.this.mInstance == null && !PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.a(50);
                }
                if (!PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.mInstance.setNotificationDefaults(i);
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.android.pushservice.PushNotificationBuilder$7] */
    public void setNotificationSound(final Uri uri) {
        new Thread() { // from class: com.baidu.android.pushservice.PushNotificationBuilder.7
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (PushNotificationBuilder.this.mInstance == null && !PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.a(50);
                }
                if (!PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.mInstance.setNotificationSound(uri);
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.android.pushservice.PushNotificationBuilder$8] */
    public void setNotificationVibrate(final long[] jArr) {
        new Thread() { // from class: com.baidu.android.pushservice.PushNotificationBuilder.8
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (PushNotificationBuilder.this.mInstance == null && !PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.a(50);
                }
                if (!PushNotificationBuilder.this.a) {
                    PushNotificationBuilder.this.mInstance.setNotificationVibrate(jArr);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        try {
            Thread.sleep(i);
        } catch (Exception e) {
        }
    }
}
