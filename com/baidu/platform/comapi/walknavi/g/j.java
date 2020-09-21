package com.baidu.platform.comapi.walknavi.g;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class j implements DialogInterface.OnCancelListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.a = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.a.Q();
    }
}
