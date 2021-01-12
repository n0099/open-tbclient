package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.ConfirmDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog f4129a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog.Builder f4130b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ConfirmDialog.Builder builder, ConfirmDialog confirmDialog) {
        this.f4130b = builder;
        this.f4129a = confirmDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f4130b.k;
        onClickListener.onClick(view);
        this.f4129a.dismiss();
    }
}
