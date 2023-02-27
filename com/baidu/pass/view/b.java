package com.baidu.pass.view;

import android.view.View;
import com.baidu.pass.view.CommonDialog;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {
    public final /* synthetic */ CommonDialog a;
    public final /* synthetic */ CommonDialog.Builder b;

    public b(CommonDialog.Builder builder, CommonDialog commonDialog) {
        this.b = builder;
        this.a = commonDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        View.OnClickListener onClickListener;
        onClickListener = this.b.g;
        onClickListener.onClick(view2);
        this.a.dismiss();
    }
}
