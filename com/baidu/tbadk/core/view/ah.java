package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ TbCheckBox NT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(TbCheckBox tbCheckBox) {
        this.NT = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean qM;
        TbCheckBox tbCheckBox = this.NT;
        qM = this.NT.qM();
        tbCheckBox.setChecked(!qM);
    }
}
