package com.baidu.adp.plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Object, Boolean> {
    private com.baidu.adp.plugin.util.d CK;
    final /* synthetic */ b CL;
    private String packageName;

    public c(b bVar, String str, com.baidu.adp.plugin.util.d dVar) {
        this.CL = bVar;
        this.packageName = null;
        this.CK = null;
        this.packageName = str;
        this.CK = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        Boolean aX;
        aX = this.CL.aX(this.packageName);
        return aX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        this.CL.kl();
        this.CL.kq();
        if (this.CK != null) {
            this.CK.c(bool.booleanValue(), this.packageName);
            return;
        }
        BdLog.e("listener is null");
        if (PluginPackageManager.ls().lA()) {
            com.baidu.adp.plugin.b.a.lh().g("plugin_load", "listener_null", this.packageName);
        }
    }
}
