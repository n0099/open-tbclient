package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.coreExtra.view.w {
    final /* synthetic */ LoginActivity KZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(LoginActivity loginActivity) {
        this.KZ = loginActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.w
    public void f(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkApplication.setCurrentAccount(accountData, this.KZ.getBaseContext());
        this.KZ.ob();
    }
}
