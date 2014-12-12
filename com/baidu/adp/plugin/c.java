package com.baidu.adp.plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Object, Boolean> {
    private String packageName;
    private com.baidu.adp.plugin.util.d rQ;
    final /* synthetic */ b rR;

    public c(b bVar, String str, com.baidu.adp.plugin.util.d dVar) {
        this.rR = bVar;
        this.packageName = null;
        this.rQ = null;
        this.packageName = str;
        this.rQ = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        Boolean aO;
        aO = this.rR.aO(this.packageName);
        return aO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        this.rR.gR();
        this.rR.gW();
        if (this.rQ != null) {
            this.rQ.c(bool.booleanValue(), this.packageName);
            return;
        }
        BdLog.e("listener is null");
        if (PluginPackageManager.ic().il()) {
            com.baidu.adp.plugin.b.a.hU().g("plugin_load", "listener_null", this.packageName);
        }
    }
}
