package com.baidu.tbadk.coreExtra.act;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class al implements DialogInterface.OnCancelListener {
    final /* synthetic */ ak La;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.La = akVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.La.KZ;
        loginActivity.destroyWaitingDialog();
    }
}
