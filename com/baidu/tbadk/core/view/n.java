package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements View.OnClickListener {
    final /* synthetic */ TbCheckBox a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbCheckBox tbCheckBox) {
        this.a = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean d;
        TbCheckBox tbCheckBox = this.a;
        d = this.a.d();
        tbCheckBox.setChecked(!d);
    }
}
