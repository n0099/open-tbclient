package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.ConfirmDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog f4132a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog.Builder f4133b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ConfirmDialog.Builder builder, ConfirmDialog confirmDialog) {
        this.f4133b = builder;
        this.f4132a = confirmDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f4133b.k;
        onClickListener.onClick(view);
        this.f4132a.dismiss();
    }
}
