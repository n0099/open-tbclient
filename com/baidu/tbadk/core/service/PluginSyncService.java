package com.baidu.tbadk.core.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.tbplugin.PluginsConfig;
/* loaded from: classes.dex */
public class PluginSyncService extends Service {
    private static final String ADDRESS = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PLUGIN_SYNC;
    private static final String TAG = "PluginSyncService";
    private Messenger mMessenger = new Messenger(new d(this, null));
    private PluginsConfig mPluginsConfig;
    private e mSyncWorker;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mSyncWorker != null) {
            this.mSyncWorker.cancel();
        }
        this.mSyncWorker = null;
    }
}
