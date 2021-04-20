package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.CommonDialog;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommonDialog f9356a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonDialog.Builder f9357b;

    public b(CommonDialog.Builder builder, CommonDialog commonDialog) {
        this.f9357b = builder;
        this.f9356a = commonDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        onClickListener = this.f9357b.f9352g;
        onClickListener.onClick(view);
        this.f9356a.dismiss();
    }
}
