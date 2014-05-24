package com.baidu.tbadk.core.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.tbplugin.PluginsConfig;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, PluginsConfig> {
    final /* synthetic */ PluginSyncService a;
    private Messenger b;
    private al c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginSyncService pluginSyncService, Messenger messenger) {
        this.a = pluginSyncService;
        this.b = messenger;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public PluginsConfig doInBackground(Void... voidArr) {
        String str;
        str = PluginSyncService.ADDRESS;
        this.c = new al(str);
        this.c.a("client_version", TbConfig.getVersion());
        String i = this.c.i();
        Log.d("PluginSyncService", i);
        return PluginsConfig.parse(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(PluginsConfig pluginsConfig) {
        PluginsConfig pluginsConfig2;
        PluginsConfig pluginsConfig3;
        PluginsConfig pluginsConfig4;
        PluginsConfig pluginsConfig5;
        this.a.mPluginsConfig = pluginsConfig;
        pluginsConfig2 = this.a.mPluginsConfig;
        if (pluginsConfig2 != null) {
            pluginsConfig5 = this.a.mPluginsConfig;
            Log.d("PluginSyncService", pluginsConfig5.toString());
        }
        Message obtain = Message.obtain((Handler) null, 2);
        if (obtain != null && this.b != null) {
            Bundle bundle = new Bundle();
            pluginsConfig4 = this.a.mPluginsConfig;
            bundle.putSerializable("plugin_config", pluginsConfig4);
            obtain.setData(bundle);
            try {
                this.b.send(obtain);
                Log.d("PluginSyncService", "MSG_GET_CONFIG response");
            } catch (RemoteException e) {
            }
        }
        pluginsConfig3 = this.a.mPluginsConfig;
        if (pluginsConfig3 != null) {
            this.a.sendBroadcast(new Intent(TbConfig.getBroadcastActionNewVersion()));
        }
        this.a.mSyncWorker = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.c.g();
        this.c = null;
    }
}
