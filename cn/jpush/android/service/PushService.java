package cn.jpush.android.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import cn.jiguang.d.b.g;
import cn.jiguang.d.d.l;
/* loaded from: classes3.dex */
public class PushService extends Service {
    private static final String TAG = "PushService";
    private static cn.jiguang.b.b mBinder = null;
    private BroadcastReceiver mPowerBroadcastReceiver = null;
    private BroadcastReceiver receiver;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        cn.jiguang.d.b.a.a(this);
        return mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        cn.jiguang.d.b.a.a(this);
        if (mBinder == null) {
            mBinder = new cn.jiguang.g.a.a();
        }
        cn.jiguang.api.e.a("SDK_MAIN", new cn.jiguang.service.a(this, 1, null), new int[0]);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        cn.jiguang.api.e.a("SDK_MAIN", new cn.jiguang.service.a(this, 3, null), new int[0]);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        cn.jiguang.e.c.a(TAG, "onStartCommand - intent:" + intent + ", pkg:" + cn.jiguang.d.a.c + ", connection:" + g.a.get());
        cn.jiguang.d.b.a.a(this);
        cn.jiguang.api.e.a("SDK_MAIN", new cn.jiguang.service.a(this, 2, intent), new int[0]);
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void runCreate() {
        Context applicationContext = getApplicationContext();
        if (!cn.jiguang.d.a.d(applicationContext)) {
            cn.jiguang.e.c.c(TAG, "onCreate:JCoreInterface init failed");
            return;
        }
        cn.jiguang.g.a.m(applicationContext);
        cn.jiguang.d.b.d.bx().a(applicationContext);
        cn.jiguang.d.b.d.bx().a((Service) this);
        try {
            cn.jiguang.d.i.f.bT().a(applicationContext, true);
        } catch (OutOfMemoryError e) {
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            if (this.receiver == null) {
                this.receiver = new PushReceiver();
            }
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.receiver, intentFilter);
        } catch (Throwable th) {
        }
        setDozePowerReceiver();
    }

    public void runDestroy() {
        cn.jiguang.d.b.d bx = cn.jiguang.d.b.d.bx();
        getApplicationContext();
        bx.c();
        try {
            if (this.receiver != null) {
                unregisterReceiver(this.receiver);
            }
            if (this.mPowerBroadcastReceiver != null) {
                unregisterReceiver(this.mPowerBroadcastReceiver);
            }
        } catch (Throwable th) {
        }
    }

    public void runStart(Intent intent) {
        String str;
        Bundle bundle = null;
        Context applicationContext = getApplicationContext();
        if (!cn.jiguang.d.a.d(applicationContext)) {
            cn.jiguang.e.c.c(TAG, "onStartCommand:JCoreInterface init failed");
            return;
        }
        if (intent != null) {
            try {
                str = intent.getAction();
                try {
                    bundle = intent.getExtras();
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                str = null;
            }
        } else {
            str = null;
        }
        if (str == null || bundle == null) {
            return;
        }
        try {
            l.bI().a(applicationContext, str, bundle);
        } catch (Throwable th3) {
            cn.jiguang.e.c.c(TAG, "PushService onStartCommand error:" + th3.getMessage());
        }
    }

    public void setDozePowerReceiver() {
        try {
            if (cn.jiguang.d.a.d.q(this)) {
                if (this.mPowerBroadcastReceiver != null) {
                    unregisterReceiver(this.mPowerBroadcastReceiver);
                    this.mPowerBroadcastReceiver = null;
                }
            } else if (this.mPowerBroadcastReceiver == null) {
                this.mPowerBroadcastReceiver = new PushReceiver();
                IntentFilter intentFilter = new IntentFilter();
                if (Build.VERSION.SDK_INT >= 21) {
                    intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
                }
                registerReceiver(this.mPowerBroadcastReceiver, intentFilter);
            }
        } catch (Throwable th) {
        }
    }
}
