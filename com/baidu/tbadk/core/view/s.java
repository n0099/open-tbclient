package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ TbCheckBox acf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbCheckBox tbCheckBox) {
        this.acf = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean vn;
        TbCheckBox tbCheckBox = this.acf;
        vn = this.acf.vn();
        tbCheckBox.setChecked(!vn);
    }
}
