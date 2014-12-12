package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.coreExtra.view.y {
    final /* synthetic */ LoginActivity Ql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(LoginActivity loginActivity) {
        this.Ql = loginActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.y
    public void f(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, this.Ql.getBaseContext());
        this.Ql.rc();
    }
}
