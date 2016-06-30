package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ TbCheckBox acz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbCheckBox tbCheckBox) {
        this.acz = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean vn;
        TbCheckBox tbCheckBox = this.acz;
        vn = this.acz.vn();
        tbCheckBox.setChecked(!vn);
    }
}
