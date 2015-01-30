package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.coreExtra.view.y {
    final /* synthetic */ LoginActivity QM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(LoginActivity loginActivity) {
        this.QM = loginActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.y
    public void f(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.QM.getBaseContext());
        this.QM.rn();
    }
}
