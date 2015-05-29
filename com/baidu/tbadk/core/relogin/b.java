package com.baidu.tbadk.core.relogin;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.d;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ ReloginManager SW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ReloginManager reloginManager) {
        this.SW = reloginManager;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void cb(String str) {
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        this.SW.SQ = false;
        if (accountData != null) {
            d.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            this.SW.sh();
            return;
        }
        this.SW.e(TbadkCoreApplication.getCurrentAccountObj());
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        this.SW.SQ = false;
        if (i == 1) {
            this.SW.e(TbadkCoreApplication.getCurrentAccountObj());
        }
    }
}
