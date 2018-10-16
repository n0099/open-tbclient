package cn.jpush.android.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class DaemonService extends Service implements Runnable {
    private static final String TAG = "DaemonService";

    /* loaded from: classes3.dex */
    public class MyBinder extends Binder {
        public MyBinder() {
        }

        public DaemonService getService() {
            return DaemonService.this;
        }
    }

    private void init() {
        cn.jiguang.api.e.a("SDK_MAIN", this, new int[0]);
    }

    private void report(int i, boolean z, Bundle bundle) {
        if (cn.jiguang.d.i.c.a(this)) {
            if (bundle != null) {
                try {
                    Iterator<String> it = bundle.keySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } catch (Throwable th) {
                    return;
                }
            }
            String str = "";
            String str2 = "";
            String str3 = "";
            if (bundle != null) {
                str = bundle.getString(EmotionDetailActivityConfig.EMOTION_FROM_PACKAGE);
                str2 = bundle.getString("from_uid");
                str3 = bundle.getString("awake_sequence");
            }
            cn.jiguang.d.i.f.ck().cl().a(this, i, z, str, str2, str3);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        report(2, cn.jiguang.d.a.i, intent != null ? intent.getExtras() : null);
        init();
        return new MyBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        report(1, cn.jiguang.d.a.i, intent != null ? intent.getExtras() : null);
        init();
        return super.onStartCommand(intent, i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Context applicationContext = getApplicationContext();
            if (cn.jiguang.d.a.d(applicationContext)) {
                cn.jiguang.api.e.register(applicationContext);
            } else {
                stopSelf();
            }
        } catch (Throwable th) {
            cn.jiguang.e.c.c(TAG, "DaemonService onCreate failed:" + th.getMessage());
        }
    }
}
