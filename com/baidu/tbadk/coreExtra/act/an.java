package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends AuthorizationListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        this.a.d();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.a.showToast(com.baidu.tieba.x.data_load_error);
        } else {
            this.a.showToast(str);
        }
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public boolean onForgetPwd() {
        this.a.startActivity(new Intent(this.a, ForgetPwdActivity.class));
        return true;
    }
}
