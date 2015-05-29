package com.baidu.adp.lib.util;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.install.PluginInstallerService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Object, Object> {
    String yc;
    String yd;
    StringBuilder ye;
    j yf;
    boolean yg = false;
    final /* synthetic */ h yh;

    public i(h hVar, String str, String str2, StringBuilder sb, j jVar) {
        this.yh = hVar;
        this.yc = str;
        this.yd = str2;
        this.ye = sb;
        this.yf = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Object doInBackground(Object... objArr) {
        boolean a;
        a = this.yh.a(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.yc, this.ye);
        this.yg = a;
        if (!this.yg) {
            this.yh.a(this.yd, "".getBytes(), this.ye);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        if (this.ye.length() > 0) {
            com.baidu.adp.lib.stats.f.hz().a("so", "load_" + this.yc + PluginInstallerService.APK_LIB_SUFFIX, "", "", -9101, this.ye.toString(), new Object[0]);
        }
        if (this.yf != null) {
            this.yf.l(this.yg);
        }
    }
}
