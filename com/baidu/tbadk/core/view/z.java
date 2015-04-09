package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ TbCheckBox YV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TbCheckBox tbCheckBox) {
        this.YV = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean tQ;
        TbCheckBox tbCheckBox = this.YV;
        tQ = this.YV.tQ();
        tbCheckBox.setChecked(!tQ);
    }
}
