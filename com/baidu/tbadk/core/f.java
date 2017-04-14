package com.baidu.tbadk.core;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ BaseFragmentActivity SE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseFragmentActivity baseFragmentActivity) {
        this.SE = baseFragmentActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.SE.mWaitingDialog = null;
    }
}
