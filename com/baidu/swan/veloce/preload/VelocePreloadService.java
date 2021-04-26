package com.baidu.swan.veloce.preload;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import d.a.h0.r.b;
/* loaded from: classes3.dex */
public class VelocePreloadService extends Service {
    public static final String ACTION_START_SWAN_APP = "com.baidu.veloce.swan.start_swan_app";
    public static final String KEY_SCHEME = "veloce_swan_scheme";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (b.a() != null) {
            b.a().b();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent != null && ACTION_START_SWAN_APP.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(KEY_SCHEME);
            if (b.a() != null) {
                b.a().c(stringExtra);
            }
        }
        return super.onStartCommand(intent, i2, i3);
    }
}
