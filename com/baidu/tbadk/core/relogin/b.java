package com.baidu.tbadk.core.relogin;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0040a {
    final /* synthetic */ ReloginManager XT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ReloginManager reloginManager) {
        this.XT = reloginManager;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cd(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_success", 0, "", new Object[0]);
        this.XT.XO = false;
        if (accountData != null) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
            this.XT.tq();
            return;
        }
        this.XT.e(TbadkCoreApplication.getCurrentAccountObj());
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_fail", i, str2, "uname", str);
        this.XT.XO = false;
        if (i == 1) {
            this.XT.e(TbadkCoreApplication.getCurrentAccountObj());
        }
    }
}
