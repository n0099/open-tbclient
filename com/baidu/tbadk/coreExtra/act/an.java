package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends AuthorizationListener {
    final /* synthetic */ LoginActivity La;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(LoginActivity loginActivity) {
        this.La = loginActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        this.La.oc();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.La.showToast(com.baidu.tieba.y.data_load_error);
        } else {
            this.La.showToast(str);
        }
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public boolean onForgetPwd() {
        this.La.startActivity(new Intent(this.La, ForgetPwdActivity.class));
        return true;
    }
}
