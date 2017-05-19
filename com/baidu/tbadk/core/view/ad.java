package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ TbCheckBox alh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(TbCheckBox tbCheckBox) {
        this.alh = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean wx;
        TbCheckBox tbCheckBox = this.alh;
        wx = this.alh.wx();
        tbCheckBox.setChecked(!wx);
    }
}
