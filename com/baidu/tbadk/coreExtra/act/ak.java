package com.baidu.tbadk.coreExtra.act;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ak implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ LoginActivity KZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(LoginActivity loginActivity) {
        this.KZ = loginActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
        if (this.KZ.getLoadingDialog() == null || !this.KZ.getLoadingDialog().isShowing()) {
            this.KZ.showLoadingDialog(this.KZ.getString(com.baidu.tieba.y.sapi_logining), new al(this));
        }
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        this.KZ.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setCurrentAccount(accountData, this.KZ.getBaseContext());
            com.baidu.tbadk.browser.a.s(TbadkApplication.m251getInst());
            this.KZ.ob();
            return;
        }
        this.KZ.e(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        SapiWebView sapiWebView;
        this.KZ.closeLoadingDialog();
        this.KZ.showToast(str2);
        if (com.baidu.adp.lib.util.j.fh()) {
            sapiWebView = this.KZ.Kg;
            sapiWebView.loadLogin();
        }
    }
}
