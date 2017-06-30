package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ TbCheckBox alL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(TbCheckBox tbCheckBox) {
        this.alL = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean wL;
        TbCheckBox tbCheckBox = this.alL;
        wL = this.alL.wL();
        tbCheckBox.setChecked(!wL);
    }
}
