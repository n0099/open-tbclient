package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ TbCheckBox YT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TbCheckBox tbCheckBox) {
        this.YT = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean tQ;
        TbCheckBox tbCheckBox = this.YT;
        tQ = this.YT.tQ();
        tbCheckBox.setChecked(!tQ);
    }
}
