package com.baidu.swan.veloce.preload;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.swan.veloce.b;
/* loaded from: classes11.dex */
public class VelocePreloadService extends Service {
    private static final String ACTION_START_SWAN_APP = "com.baidu.veloce.swan.start_swan_app";
    private static final String KEY_SCHEME = "veloce_swan_scheme";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (b.aJn() != null) {
            b.aJn().aJm();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && ACTION_START_SWAN_APP.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(KEY_SCHEME);
            if (b.aJn() != null) {
                b.aJn().uf(stringExtra);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
