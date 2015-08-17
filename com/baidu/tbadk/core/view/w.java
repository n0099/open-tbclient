package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ TbCheckBox aeX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbCheckBox tbCheckBox) {
        this.aeX = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean vE;
        TbCheckBox tbCheckBox = this.aeX;
        vE = this.aeX.vE();
        tbCheckBox.setChecked(!vE);
    }
}
