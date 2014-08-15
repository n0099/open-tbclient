package com.baidu.tbadk.core.relogin;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.g;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements g {
    final /* synthetic */ ReloginManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ReloginManager reloginManager) {
        this.a = reloginManager;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (accountData != null) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkApplication.setCurrentAccount(accountData, TbadkApplication.m252getInst().getApp().getApplicationContext());
            this.a.e();
            return;
        }
        this.a.a(TbadkApplication.getCurrentAccountObj());
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        if (i == 1) {
            this.a.a(TbadkApplication.getCurrentAccountObj());
        }
    }
}
