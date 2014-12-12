package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Object, Object, AccountData> {
    private final d CU;
    private final String mAccount;
    private final String mPassword;

    public e(String str, String str2, d dVar) {
        this.mAccount = str;
        this.mPassword = str2;
        this.CU = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public AccountData doInBackground(Object... objArr) {
        AccountData L;
        L = c.L(this.mAccount, this.mPassword);
        return L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(AccountData accountData) {
        super.onPostExecute((e) accountData);
        if (this.CU != null) {
            if (accountData != null) {
                this.CU.onSuccess(accountData);
            } else {
                this.CU.onFailure(this.mAccount);
            }
        }
    }
}
