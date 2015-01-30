package com.baidu.adp.plugin.install;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class PluginInstallerRetryService extends IntentService {
    public PluginInstallerRetryService() {
        super(PluginInstallerRetryService.class.getSimpleName());
    }

    public PluginInstallerRetryService(String str) {
        super(str);
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.IntentService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        g.onHandleIntent(intent);
    }
}
