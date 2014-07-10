package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Object, Object, AccountData> {
    private final String a;
    private final String b;
    private final d c;

    public e(String str, String str2, d dVar) {
        this.a = str;
        this.b = str2;
        this.c = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public AccountData doInBackground(Object... objArr) {
        AccountData b;
        b = c.b(this.a, this.b);
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(AccountData accountData) {
        super.onPostExecute(accountData);
        if (this.c != null) {
            if (accountData != null) {
                this.c.onSuccess(accountData);
            } else {
                this.c.onFailure(this.a);
            }
        }
    }
}
