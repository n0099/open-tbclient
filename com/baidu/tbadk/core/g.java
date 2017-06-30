package com.baidu.tbadk.core;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ BaseFragmentActivity RG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BaseFragmentActivity baseFragmentActivity) {
        this.RG = baseFragmentActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.RG.mWaitingDialog = null;
    }
}
