package com.baidu.tbadk.core.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.tbadk.tbplugin.PluginsConfig;
/* loaded from: classes.dex */
class e extends Handler {
    final /* synthetic */ PluginSyncService a;

    private e(PluginSyncService pluginSyncService) {
        this.a = pluginSyncService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(PluginSyncService pluginSyncService, e eVar) {
        this(pluginSyncService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        f fVar;
        f fVar2;
        PluginsConfig pluginsConfig;
        PluginsConfig pluginsConfig2;
        f fVar3;
        f fVar4;
        switch (message.what) {
            case 1:
            default:
                return;
            case 2:
                Log.d("PluginSyncService", "MSG_GET_CONFIG received");
                pluginsConfig = this.a.c;
                if (pluginsConfig == null) {
                    fVar3 = this.a.d;
                    if (fVar3 == null) {
                        this.a.d = new f(this.a, message.replyTo);
                        fVar4 = this.a.d;
                        fVar4.execute(new Void[0]);
                        return;
                    }
                    return;
                }
                Message obtain = Message.obtain((Handler) null, 2);
                if (obtain != null && message.replyTo != null) {
                    Bundle bundle = new Bundle();
                    pluginsConfig2 = this.a.c;
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
                fVar = this.a.d;
                if (fVar == null) {
                    this.a.d = new f(this.a, message.replyTo);
                    fVar2 = this.a.d;
                    fVar2.execute(new Void[0]);
                    return;
                }
                return;
        }
    }
}
