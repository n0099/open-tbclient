package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.CommonDialog;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommonDialog f9354a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonDialog.Builder f9355b;

    public a(CommonDialog.Builder builder, CommonDialog commonDialog) {
        this.f9355b = builder;
        this.f9354a = commonDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f9355b.i;
        onClickListener.onClick(view);
        this.f9354a.dismiss();
    }
}
