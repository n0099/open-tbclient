package com.baidu.tbadk.core.relogin;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.g;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements g {
    final /* synthetic */ ReloginManager Gj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ReloginManager reloginManager) {
        this.Gj = reloginManager;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (accountData != null) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
            this.Gj.oc();
            return;
        }
        this.Gj.d(TbadkCoreApplication.getCurrentAccountObj());
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        if (i == 1) {
            this.Gj.d(TbadkCoreApplication.getCurrentAccountObj());
        }
    }
}
