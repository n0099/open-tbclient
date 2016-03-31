package com.baidu.tbadk.core;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ BaseFragmentActivity QU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseFragmentActivity baseFragmentActivity) {
        this.QU = baseFragmentActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.QU.mWaitingDialog = null;
    }
}
