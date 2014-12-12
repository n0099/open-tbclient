package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ TbCheckBox Nx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(TbCheckBox tbCheckBox) {
        this.Nx = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean qB;
        TbCheckBox tbCheckBox = this.Nx;
        qB = this.Nx.qB();
        tbCheckBox.setChecked(!qB);
    }
}
