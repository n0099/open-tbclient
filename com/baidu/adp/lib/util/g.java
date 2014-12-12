package com.baidu.adp.lib.util;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.install.PluginInstallerService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Object, Object> {
    String mI;
    String mJ;
    StringBuilder mK;
    h mL;
    boolean mM = false;
    final /* synthetic */ f mN;

    public g(f fVar, String str, String str2, StringBuilder sb, h hVar) {
        this.mN = fVar;
        this.mI = str;
        this.mJ = str2;
        this.mK = sb;
        this.mL = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Object doInBackground(Object... objArr) {
        boolean a;
        a = this.mN.a(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.mI, this.mK);
        this.mM = a;
        if (!this.mM) {
            this.mN.a(this.mJ, "".getBytes(), this.mK);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        if (this.mK.length() > 0) {
            com.baidu.adp.lib.stats.f.es().a("so", "load_" + this.mI + PluginInstallerService.APK_LIB_SUFFIX, "", "", -9101, this.mK.toString(), new Object[0]);
        }
        if (this.mL != null) {
            this.mL.l(this.mM);
        }
    }
}
