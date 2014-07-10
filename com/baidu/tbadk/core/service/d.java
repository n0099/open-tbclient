package com.baidu.tbadk.core.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.tbadk.tbplugin.PluginsConfig;
/* loaded from: classes.dex */
class d extends Handler {
    final /* synthetic */ PluginSyncService a;

    private d(PluginSyncService pluginSyncService) {
        this.a = pluginSyncService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(PluginSyncService pluginSyncService, d dVar) {
        this(pluginSyncService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e eVar;
        e eVar2;
        PluginsConfig pluginsConfig;
        PluginsConfig pluginsConfig2;
        e eVar3;
        e eVar4;
        switch (message.what) {
            case 1:
            default:
                return;
            case 2:
                Log.d("PluginSyncService", "MSG_GET_CONFIG received");
                pluginsConfig = this.a.mPluginsConfig;
                if (pluginsConfig == null) {
                    eVar3 = this.a.mSyncWorker;
                    if (eVar3 == null) {
                        this.a.mSyncWorker = new e(this.a, message.replyTo);
                        eVar4 = this.a.mSyncWorker;
                        eVar4.execute(new Void[0]);
                        return;
                    }
                    return;
                }
                Message obtain = Message.obtain((Handler) null, 2);
                if (obtain != null && message.replyTo != null) {
                    Bundle bundle = new Bundle();
                    pluginsConfig2 = this.a.mPluginsConfig;
                    bundle.putSerializable("plugin_config", pluginsConfig2);
                    obtain.setData(bundle);
                    try {
                        message.replyTo.send(obtain);
                        Log.d("PluginSyncService", "MSG_GET_CONFIG response");
                        return;
                    } catch (RemoteException e) {
                        return;
                    }
                }
                return;
            case 3:
                eVar = this.a.mSyncWorker;
                if (eVar == null) {
                    this.a.mSyncWorker = new e(this.a, message.replyTo);
                    eVar2 = this.a.mSyncWorker;
                    eVar2.execute(new Void[0]);
                    return;
                }
                return;
        }
    }
}
