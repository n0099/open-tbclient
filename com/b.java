package com;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class b implements DialogInterface.OnDismissListener {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ab abVar) {
        this.a = abVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.a.mShareDialog != null) {
            this.a.mShareDialog = null;
        }
    }
}
