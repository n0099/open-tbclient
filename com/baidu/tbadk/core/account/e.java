package com.baidu.tbadk.core.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Object, Object, AccountData> {
    private final String mAccount;
    private final String mPassword;
    private final d yU;

    public e(String str, String str2, d dVar) {
        this.mAccount = str;
        this.mPassword = str2;
        this.yU = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public AccountData doInBackground(Object... objArr) {
        AccountData A;
        A = c.A(this.mAccount, this.mPassword);
        return A;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(AccountData accountData) {
        super.onPostExecute((e) accountData);
        if (this.yU != null) {
            if (accountData != null) {
                this.yU.onSuccess(accountData);
            } else {
                this.yU.onFailure(this.mAccount);
            }
        }
    }
}
