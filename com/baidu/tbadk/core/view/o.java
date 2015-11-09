package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbCheckBox aeA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbCheckBox tbCheckBox) {
        this.aeA = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean vC;
        TbCheckBox tbCheckBox = this.aeA;
        vC = this.aeA.vC();
        tbCheckBox.setChecked(!vC);
    }
}
