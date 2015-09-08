package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ TbCheckBox afh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbCheckBox tbCheckBox) {
        this.afh = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean vJ;
        TbCheckBox tbCheckBox = this.afh;
        vJ = this.afh.vJ();
        tbCheckBox.setChecked(!vJ);
    }
}
