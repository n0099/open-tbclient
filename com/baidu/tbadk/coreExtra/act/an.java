package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends AuthorizationListener {
    final /* synthetic */ LoginActivity Ql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(LoginActivity loginActivity) {
        this.Ql = loginActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        this.Ql.rd();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.Ql.showToast(com.baidu.tieba.z.data_load_error);
        } else {
            this.Ql.showToast(str);
        }
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public boolean onForgetPwd() {
        this.Ql.startActivity(new Intent(this.Ql.getPageContext().getPageActivity(), ForgetPwdActivity.class));
        return true;
    }
}
