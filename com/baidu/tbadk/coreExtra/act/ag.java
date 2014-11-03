package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.coreExtra.view.w {
    final /* synthetic */ Login2Activity KU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(Login2Activity login2Activity) {
        this.KU = login2Activity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.w
    public void f(AccountData accountData) {
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkApplication.setCurrentAccount(accountData, this.KU.getBaseContext());
        this.KU.ob();
    }
}
