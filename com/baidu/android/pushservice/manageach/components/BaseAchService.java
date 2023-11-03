package com.baidu.android.pushservice.manageach.components;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public abstract class BaseAchService extends Service {
    public abstract int a(Intent intent, int i, int i2);

    public abstract IBinder a(Intent intent);

    public abstract void a();

    public abstract void b();

    public abstract boolean b(Intent intent);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return a(intent);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            a();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            b();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            return a(intent, i, i2);
        } catch (Throwable unused) {
            return super.onStartCommand(intent, i, i2);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        try {
            return b(intent);
        } catch (Throwable unused) {
            return super.onUnbind(intent);
        }
    }
}
