package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.ConfirmDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog f4164a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog.Builder f4165b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ConfirmDialog.Builder builder, ConfirmDialog confirmDialog) {
        this.f4165b = builder;
        this.f4164a = confirmDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f4165b.m;
        onClickListener.onClick(view);
        this.f4164a.dismiss();
    }
}
