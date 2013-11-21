package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.util.Util;
/* loaded from: classes.dex */
public class PushService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private boolean f685a = false;
    private Handler b = new Handler();
    private Runnable c = new n(this);

    private void a(boolean z, boolean z2) {
        this.f685a = z;
        if (b.a()) {
            Log.d("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2);
        }
        if (z2) {
            this.c.run();
            return;
        }
        this.b.removeCallbacks(this.c);
        this.b.postDelayed(this.c, 1000L);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        PushSettings.a(getApplicationContext());
        if (b.a()) {
            Log.d("PushService", "onCreate from : " + getPackageName());
        }
        if (PushSDK.getInstantce(this).initPushSDK()) {
            return;
        }
        a(true, true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (b.a()) {
            Log.i("PushService", "onDestroy");
        }
        PushSDK.destory();
        if (!this.f685a || Util.hasOtherServiceRuninMyPid(this, getClass().getName())) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (b.a()) {
            Log.d("PushService", "-- onStartCommand -- " + intent);
        }
        if (intent == null) {
            intent = new Intent();
            if (b.a()) {
                Log.i("PushService", "--- onStart by null intent!");
            }
        }
        this.b.removeCallbacks(this.c);
        if (!PushSDK.getInstantce(this).handleOnStart(intent)) {
            a(true, true);
        }
        return 1;
    }
}
