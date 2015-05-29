package com.baidu.tbadk.core;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ BaseFragmentActivity OD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BaseFragmentActivity baseFragmentActivity) {
        this.OD = baseFragmentActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.OD.mWaitingDialog = null;
    }
}
