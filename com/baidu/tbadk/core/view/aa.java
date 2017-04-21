package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ TbCheckBox alm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TbCheckBox tbCheckBox) {
        this.alm = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean xm;
        TbCheckBox tbCheckBox = this.alm;
        xm = this.alm.xm();
        tbCheckBox.setChecked(!xm);
    }
}
