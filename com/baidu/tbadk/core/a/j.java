package com.baidu.tbadk.core.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends BdAsyncTask<Object, Object, Object> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final Object a(Object... objArr) {
        this.a.f = o.d();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void a(Object obj) {
        ArrayList arrayList;
        ArrayList arrayList2;
        super.a((j) obj);
        this.a.g = 0;
        arrayList = this.a.f;
        if (arrayList != null) {
            arrayList2 = this.a.f;
            if (arrayList2.size() > 0) {
                this.a.b();
                return;
            }
        }
        a.k(this.a);
    }
}
