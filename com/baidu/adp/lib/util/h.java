package com.baidu.adp.lib.util;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<Object, Object, Object> {
    String mK;
    String mL;
    StringBuilder mM;
    i mN;
    boolean mO = false;
    final /* synthetic */ g mP;

    public h(g gVar, String str, String str2, StringBuilder sb, i iVar) {
        this.mP = gVar;
        this.mK = str;
        this.mL = str2;
        this.mM = sb;
        this.mN = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Object doInBackground(Object... objArr) {
        boolean a;
        a = this.mP.a(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.mK, this.mM);
        this.mO = a;
        if (!this.mO) {
            this.mP.a(this.mL, "".getBytes(), this.mM);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        if (this.mM.length() > 0) {
            com.baidu.adp.lib.stats.f.er().a("so", "load_" + this.mK + ".so", "", "", -9101, this.mM.toString(), new Object[0]);
        }
        if (this.mN != null) {
            this.mN.h(this.mO);
        }
    }
}
