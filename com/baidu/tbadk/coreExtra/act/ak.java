package com.baidu.tbadk.coreExtra.act;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ak implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ LoginActivity QM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(LoginActivity loginActivity) {
        this.QM = loginActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
        if (this.QM.getLoadingDialog() == null || !this.QM.getLoadingDialog().isShowing()) {
            this.QM.showLoadingDialog(this.QM.getPageContext().getString(com.baidu.tieba.z.sapi_logining), new al(this));
        }
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        this.QM.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.QM.getBaseContext());
            com.baidu.tbadk.browser.a.Q(TbadkCoreApplication.m255getInst());
            this.QM.rn();
            return;
        }
        this.QM.e(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        SapiWebView sapiWebView;
        this.QM.closeLoadingDialog();
        this.QM.showToast(str2);
        if (com.baidu.adp.lib.util.i.ff()) {
            sapiWebView = this.QM.PR;
            sapiWebView.loadLogin();
        }
    }
}
