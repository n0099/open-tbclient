package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ TbCheckBox akW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TbCheckBox tbCheckBox) {
        this.akW = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean wQ;
        TbCheckBox tbCheckBox = this.akW;
        wQ = this.akW.wQ();
        tbCheckBox.setChecked(!wQ);
    }
}
