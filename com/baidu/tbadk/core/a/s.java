package com.baidu.tbadk.core.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends BdAsyncTask<Object, Object, AccountData> {
    private final String a;
    private final String b;
    private final r c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ AccountData a(Object... objArr) {
        AccountData b;
        b = q.b(this.a, this.b);
        return b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(AccountData accountData) {
        AccountData accountData2 = accountData;
        super.a((s) accountData2);
        if (this.c != null) {
            if (accountData2 != null) {
                this.c.a(accountData2);
                return;
            }
            r rVar = this.c;
            String str = this.a;
            rVar.a();
        }
    }

    public s(String str, String str2, r rVar) {
        this.a = str;
        this.b = str2;
        this.c = rVar;
    }
}
