package com.baidu.tbadk.coreExtra.act;

import android.text.TextUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class ak implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
        if (this.a.getLoadingDialog() == null || !this.a.getLoadingDialog().isShowing()) {
            this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.u.sapi_logining), new al(this));
        }
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        this.a.closeLoadingDialog();
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setCurrentAccount(accountData, this.a.getBaseContext());
            this.a.b();
            return;
        }
        this.a.a(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, String str2) {
        SapiWebView sapiWebView;
        this.a.closeLoadingDialog();
        this.a.showToast(str2);
        if (UtilHelper.isNetOk()) {
            sapiWebView = this.a.a;
            sapiWebView.loadLogin();
        }
    }
}
