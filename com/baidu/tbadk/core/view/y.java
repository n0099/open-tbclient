package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ TbCheckBox agZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TbCheckBox tbCheckBox) {
        this.agZ = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean wN;
        TbCheckBox tbCheckBox = this.agZ;
        wN = this.agZ.wN();
        tbCheckBox.setChecked(!wN);
    }
}
