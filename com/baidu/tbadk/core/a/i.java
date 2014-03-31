package com.baidu.tbadk.core.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
final class i extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ h a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, AccountData accountData) {
        this.a = hVar;
        this.b = accountData;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Void a(Void... voidArr) {
        return a();
    }

    private Void a() {
        o.a();
        o.b(this.b);
        return null;
    }
}
