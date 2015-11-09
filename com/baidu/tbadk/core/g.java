package com.baidu.tbadk.core;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ BaseFragmentActivity Ti;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BaseFragmentActivity baseFragmentActivity) {
        this.Ti = baseFragmentActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.Ti.mWaitingDialog = null;
    }
}
