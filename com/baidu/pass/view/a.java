package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.ConfirmDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog f4125a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog.Builder f4126b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ConfirmDialog.Builder builder, ConfirmDialog confirmDialog) {
        this.f4126b = builder;
        this.f4125a = confirmDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f4126b.i;
        onClickListener.onClick(view);
        this.f4125a.dismiss();
    }
}
