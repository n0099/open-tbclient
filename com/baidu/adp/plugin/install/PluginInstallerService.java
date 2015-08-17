package com.baidu.adp.plugin.install;

import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
/* loaded from: classes.dex */
public class PluginInstallerService extends HighPriorityIntentService {
    public static final String ACTION_INSTALL = "com.baidu.adp.plugin.action.install";
    public static final String ACTION_UNINSTALL = "com.baidu.adp.plugin.action.uninstall";
    public static final String APK_LIB_SUFFIX = ".so";
    private Handler handler;
    private Messenger messenger;
    public static final String APK_LIB_DIR_PREFIX = "lib/";
    public static int APK_LIB_CPUABI_OFFSITE = APK_LIB_DIR_PREFIX.length();

    public PluginInstallerService() {
        super(PluginInstallerService.class.getSimpleName());
        this.handler = new n(this, Looper.getMainLooper());
        this.messenger = new Messenger(this.handler);
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.messenger.getBinder();
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(2147483646, new Notification());
        }
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 2;
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService
    protected void onHandleIntent(Intent intent) {
        m.onHandleIntent(intent);
    }
}
