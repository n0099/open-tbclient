package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.ConfirmDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog f4162a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog.Builder f4163b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ConfirmDialog.Builder builder, ConfirmDialog confirmDialog) {
        this.f4163b = builder;
        this.f4162a = confirmDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f4163b.i;
        onClickListener.onClick(view);
        this.f4162a.dismiss();
    }
}
