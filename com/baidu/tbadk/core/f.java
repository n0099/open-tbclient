package com.baidu.tbadk.core;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ BaseFragmentActivity CA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseFragmentActivity baseFragmentActivity) {
        this.CA = baseFragmentActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.CA.mWaitingDialog = null;
    }
}
