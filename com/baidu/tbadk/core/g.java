package com.baidu.tbadk.core;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ BaseFragmentActivity RL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BaseFragmentActivity baseFragmentActivity) {
        this.RL = baseFragmentActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.RL.mWaitingDialog = null;
    }
}
