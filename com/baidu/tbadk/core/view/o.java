package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbCheckBox aeu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbCheckBox tbCheckBox) {
        this.aeu = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean vB;
        TbCheckBox tbCheckBox = this.aeu;
        vB = this.aeu.vB();
        tbCheckBox.setChecked(!vB);
    }
}
