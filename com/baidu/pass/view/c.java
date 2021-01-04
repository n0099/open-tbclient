package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.ConfirmDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog f4166a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog.Builder f4167b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ConfirmDialog.Builder builder, ConfirmDialog confirmDialog) {
        this.f4167b = builder;
        this.f4166a = confirmDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f4167b.k;
        onClickListener.onClick(view);
        this.f4166a.dismiss();
    }
}
