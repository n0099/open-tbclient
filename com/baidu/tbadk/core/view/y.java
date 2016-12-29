package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ TbCheckBox ags;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TbCheckBox tbCheckBox) {
        this.ags = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean wy;
        TbCheckBox tbCheckBox = this.ags;
        wy = this.ags.wy();
        tbCheckBox.setChecked(!wy);
    }
}
