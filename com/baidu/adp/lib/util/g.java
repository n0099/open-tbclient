package com.baidu.adp.lib.util;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.install.PluginInstallerService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Object, Object> {
    String mL;
    String mM;
    StringBuilder mN;
    h mO;
    boolean mP = false;
    final /* synthetic */ f mQ;

    public g(f fVar, String str, String str2, StringBuilder sb, h hVar) {
        this.mQ = fVar;
        this.mL = str;
        this.mM = str2;
        this.mN = sb;
        this.mO = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Object doInBackground(Object... objArr) {
        boolean a;
        a = this.mQ.a(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.mL, this.mN);
        this.mP = a;
        if (!this.mP) {
            this.mQ.a(this.mM, "".getBytes(), this.mN);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        if (this.mN.length() > 0) {
            com.baidu.adp.lib.stats.f.eq().a("so", "load_" + this.mL + PluginInstallerService.APK_LIB_SUFFIX, "", "", -9101, this.mN.toString(), new Object[0]);
        }
        if (this.mO != null) {
            this.mO.l(this.mP);
        }
    }
}
