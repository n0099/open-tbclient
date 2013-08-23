package com.baidu.adp.lib.debug.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import com.baidu.adp.lib.debug.b.j;
/* loaded from: classes.dex */
public class DebugService extends Service {

    /* renamed from: a  reason: collision with root package name */
    j f422a;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f422a = new j(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.f422a != null) {
            Log.i("Monitor", "off");
            this.f422a.c();
            this.f422a.setVisibility(8);
        }
    }

    public void onClick(View view) {
    }
}
