package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ TbCheckBox afE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TbCheckBox tbCheckBox) {
        this.afE = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean wt;
        TbCheckBox tbCheckBox = this.afE;
        wt = this.afE.wt();
        tbCheckBox.setChecked(!wt);
    }
}
