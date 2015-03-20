package com.baidu.adp.lib.util;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.install.PluginInstallerService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Object, Object> {
    String yn;
    String yo;
    StringBuilder yp;
    j yq;
    boolean yr = false;
    final /* synthetic */ h ys;

    public i(h hVar, String str, String str2, StringBuilder sb, j jVar) {
        this.ys = hVar;
        this.yn = str;
        this.yo = str2;
        this.yp = sb;
        this.yq = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Object doInBackground(Object... objArr) {
        boolean a;
        a = this.ys.a(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.yn, this.yp);
        this.yr = a;
        if (!this.yr) {
            this.ys.a(this.yo, "".getBytes(), this.yp);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        if (this.yp.length() > 0) {
            com.baidu.adp.lib.stats.f.hP().a("so", "load_" + this.yn + PluginInstallerService.APK_LIB_SUFFIX, "", "", -9101, this.yp.toString(), new Object[0]);
        }
        if (this.yq != null) {
            this.yq.l(this.yr);
        }
    }
}
