package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.CommonDialog;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommonDialog f9706a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonDialog.Builder f9707b;

    public b(CommonDialog.Builder builder, CommonDialog commonDialog) {
        this.f9707b = builder;
        this.f9706a = commonDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f9707b.f9701g;
        onClickListener.onClick(view);
        this.f9706a.dismiss();
    }
}
