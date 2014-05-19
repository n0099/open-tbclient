package com.baidu.adp.lib.debug.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import com.baidu.adp.lib.debug.b.m;
/* loaded from: classes.dex */
public class DebugService extends Service {
    m a;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = new m(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            Log.i("Monitor", "off");
            try {
                this.a.c();
                this.a.setVisibility(8);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void onClick(View view) {
    }
}
