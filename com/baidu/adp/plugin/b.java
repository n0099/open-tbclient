package com.baidu.adp.plugin;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.util.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Object, Boolean> {
    final /* synthetic */ a CA;
    private f Cz;
    private String packageName;

    public b(a aVar, String str, f fVar) {
        this.CA = aVar;
        this.packageName = null;
        this.Cz = null;
        this.packageName = str;
        this.Cz = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        Boolean bh;
        bh = this.CA.bh(this.packageName);
        return bh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (this.Cz != null) {
            this.Cz.c(bool.booleanValue(), this.packageName);
        } else {
            BdLog.e("listener is null");
            if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a.lB().g("plugin_load", "listener_null", this.packageName);
            }
        }
        if (bool.booleanValue()) {
            this.CA.kE();
            this.CA.kK();
            this.CA.b(this.packageName, 0, (String) null);
        }
    }
}
