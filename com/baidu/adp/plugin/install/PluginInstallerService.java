package com.baidu.adp.plugin.install;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
/* loaded from: classes.dex */
public class PluginInstallerService extends IntentService {
    public static final String ACTION_INSTALL = "com.baidu.adp.plugin.action.install";
    public static final String ACTION_UNINSTALL = "com.baidu.adp.plugin.action.uninstall";
    public static final String APK_LIB_SUFFIX = ".so";
    public static final String APK_LIB_DIR_PREFIX = "lib/";
    public static int APK_LIB_CPUABI_OFFSITE = APK_LIB_DIR_PREFIX.length();

    public PluginInstallerService() {
        super(PluginInstallerService.class.getSimpleName());
    }

    public PluginInstallerService(String str) {
        super(str);
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(2147483646, new Notification());
        }
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
