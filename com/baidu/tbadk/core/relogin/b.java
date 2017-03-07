package com.baidu.tbadk.core.relogin;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0031a {
    final /* synthetic */ ReloginManager acG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ReloginManager reloginManager) {
        this.acG = reloginManager;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void bY(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void a(AccountData accountData) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_success", 0, "", new Object[0]);
        this.acG.acB = false;
        if (accountData != null) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkCoreApplication.setCurrentAccount(accountData, TbadkCoreApplication.m9getInst().getApp().getApplicationContext());
            this.acG.uk();
            return;
        }
        this.acG.f(TbadkCoreApplication.getCurrentAccountObj());
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0031a
    public void b(String str, int i, String str2) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_pass_fail", i, str2, "uname", str);
        this.acG.acB = false;
        if (i == 1) {
            this.acG.f(TbadkCoreApplication.getCurrentAccountObj());
        }
    }
}
