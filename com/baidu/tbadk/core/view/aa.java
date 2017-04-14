package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ TbCheckBox alk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TbCheckBox tbCheckBox) {
        this.alk = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean xm;
        TbCheckBox tbCheckBox = this.alk;
        xm = this.alk.xm();
        tbCheckBox.setChecked(!xm);
    }
}
