package com.baidu.tbadk.core.a;

import android.app.Activity;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
final class c extends BdAsyncTask<Void, Void, AccountData> {
    final /* synthetic */ b a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.a = bVar;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ AccountData a(Void... voidArr) {
        return o.a(this.b);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(AccountData accountData) {
        boolean z;
        Activity activity;
        int i;
        r rVar;
        AccountData accountData2 = accountData;
        super.a((c) accountData2);
        if (accountData2 == null || bc.c(accountData2.getPassword())) {
            z = this.a.a.h;
            if (z) {
                return;
            }
            a aVar = this.a.a;
            activity = this.a.a.b;
            i = this.a.a.c;
            aVar.a(activity, i);
            return;
        }
        String account = accountData2.getAccount();
        String password = accountData2.getPassword();
        rVar = this.a.a.k;
        q.a(account, password, rVar);
    }
}
