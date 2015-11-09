package com.baidu.tbadk.core.relogin;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0040a {
    final /* synthetic */ ReloginManager XX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ReloginManager reloginManager) {
        this.XX = reloginManager;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cb(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_success", 0, "", new Object[0]);
        this.XX.XS = false;
        if (accountData != null) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            this.XX.tq();
            return;
        }
        this.XX.e(TbadkCoreApplication.getCurrentAccountObj());
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_fail", i, str2, "uname", str);
        this.XX.XS = false;
        if (i == 1) {
            this.XX.e(TbadkCoreApplication.getCurrentAccountObj());
        }
    }
}
