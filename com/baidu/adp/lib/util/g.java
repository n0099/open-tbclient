package com.baidu.adp.lib.util;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Object, Object> {
    String a;
    String b;
    StringBuilder c;
    h d;
    boolean e = false;
    final /* synthetic */ f f;

    public g(f fVar, String str, String str2, StringBuilder sb, h hVar) {
        this.f = fVar;
        this.a = str;
        this.b = str2;
        this.c = sb;
        this.d = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Object doInBackground(Object... objArr) {
        boolean a;
        a = this.f.a(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.a, this.c);
        this.e = a;
        if (!this.e) {
            this.f.a(this.b, "".getBytes(), this.c);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        if (this.c.length() > 0) {
            com.baidu.adp.lib.stats.h.a().a("so", "load_" + this.a + ".so", "", "", -9101, this.c.toString(), new Object[0]);
        }
        if (this.d != null) {
            this.d.a(this.e);
        }
    }
}
