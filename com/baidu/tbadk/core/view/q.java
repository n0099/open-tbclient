package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbCheckBox agY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbCheckBox tbCheckBox) {
        this.agY = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean xg;
        TbCheckBox tbCheckBox = this.agY;
        xg = this.agY.xg();
        tbCheckBox.setChecked(!xg);
    }
}
