package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ TbCheckBox akX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(TbCheckBox tbCheckBox) {
        this.akX = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean wt;
        TbCheckBox tbCheckBox = this.akX;
        wt = this.akX.wt();
        tbCheckBox.setChecked(!wt);
    }
}
