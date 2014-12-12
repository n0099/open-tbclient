package com.baidu.tbadk.coreExtra.act;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ak implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ LoginActivity Ql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(LoginActivity loginActivity) {
        this.Ql = loginActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
        if (this.Ql.getLoadingDialog() == null || !this.Ql.getLoadingDialog().isShowing()) {
            this.Ql.showLoadingDialog(this.Ql.getPageContext().getString(com.baidu.tieba.z.sapi_logining), new al(this));
        }
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        this.Ql.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkCoreApplication.setCurrentAccount(accountData, this.Ql.getBaseContext());
            com.baidu.tbadk.browser.a.Q(TbadkCoreApplication.m255getInst());
            this.Ql.rc();
            return;
        }
        this.Ql.e(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        SapiWebView sapiWebView;
        this.Ql.closeLoadingDialog();
        this.Ql.showToast(str2);
        if (com.baidu.adp.lib.util.i.fg()) {
            sapiWebView = this.Ql.Pp;
            sapiWebView.loadLogin();
        }
    }
}
