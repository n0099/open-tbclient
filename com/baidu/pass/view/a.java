package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.ConfirmDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog f2806a;
    final /* synthetic */ ConfirmDialog.Builder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ConfirmDialog.Builder builder, ConfirmDialog confirmDialog) {
        this.b = builder;
        this.f2806a = confirmDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.b.i;
        onClickListener.onClick(view);
        this.f2806a.dismiss();
    }
}
