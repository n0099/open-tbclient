package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ TbCheckBox NQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(TbCheckBox tbCheckBox) {
        this.NQ = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean qG;
        TbCheckBox tbCheckBox = this.NQ;
        qG = this.NQ.qG();
        tbCheckBox.setChecked(!qG);
    }
}
