package com.baidu.tbadk.coreExtra.act;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class al implements DialogInterface.OnCancelListener {
    final /* synthetic */ ak Qm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.Qm = akVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.Qm.Ql;
        loginActivity.destroyWaitingDialog();
    }
}
