package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.ConfirmDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ConfirmDialog a;
    final /* synthetic */ ConfirmDialog.Builder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ConfirmDialog.Builder builder, ConfirmDialog confirmDialog) {
        this.b = builder;
        this.a = confirmDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.b.m;
        onClickListener.onClick(view);
        this.a.dismiss();
    }
}
