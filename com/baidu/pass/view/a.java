package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.ConfirmDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog f4163a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog.Builder f4164b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ConfirmDialog.Builder builder, ConfirmDialog confirmDialog) {
        this.f4164b = builder;
        this.f4163a = confirmDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f4164b.i;
        onClickListener.onClick(view);
        this.f4163a.dismiss();
    }
}
