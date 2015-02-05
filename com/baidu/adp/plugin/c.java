package com.baidu.adp.plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Object, Boolean> {
    private String packageName;
    private com.baidu.adp.plugin.util.d rV;
    final /* synthetic */ b rW;

    public c(b bVar, String str, com.baidu.adp.plugin.util.d dVar) {
        this.rW = bVar;
        this.packageName = null;
        this.rV = null;
        this.packageName = str;
        this.rV = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        Boolean aP;
        aP = this.rW.aP(this.packageName);
        return aP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        this.rW.gR();
        this.rW.gW();
        if (this.rV != null) {
            this.rV.c(bool.booleanValue(), this.packageName);
            return;
        }
        BdLog.e("listener is null");
        if (PluginPackageManager.hV().id()) {
            com.baidu.adp.plugin.b.a.hN().g("plugin_load", "listener_null", this.packageName);
        }
    }
}
