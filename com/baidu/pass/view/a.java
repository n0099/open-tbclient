package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.ConfirmDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog f4128a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConfirmDialog.Builder f4129b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ConfirmDialog.Builder builder, ConfirmDialog confirmDialog) {
        this.f4129b = builder;
        this.f4128a = confirmDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f4129b.i;
        onClickListener.onClick(view);
        this.f4128a.dismiss();
    }
}
