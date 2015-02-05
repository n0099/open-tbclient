package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.coreExtra.view.y {
    final /* synthetic */ Login2Activity QD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(Login2Activity login2Activity) {
        this.QD = login2Activity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.y
    public void f(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.QD.getBaseContext());
        this.QD.rh();
    }
}
