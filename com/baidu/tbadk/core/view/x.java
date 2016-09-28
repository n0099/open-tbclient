package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ TbCheckBox agz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbCheckBox tbCheckBox) {
        this.agz = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean wI;
        TbCheckBox tbCheckBox = this.agz;
        wI = this.agz.wI();
        tbCheckBox.setChecked(!wI);
    }
}
