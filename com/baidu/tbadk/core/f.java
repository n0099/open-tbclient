package com.baidu.tbadk.core;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ BaseFragmentActivity LK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseFragmentActivity baseFragmentActivity) {
        this.LK = baseFragmentActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.LK.mWaitingDialog = null;
    }
}
