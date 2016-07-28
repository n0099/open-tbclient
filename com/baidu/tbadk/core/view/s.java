package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ TbCheckBox adk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbCheckBox tbCheckBox) {
        this.adk = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean vn;
        TbCheckBox tbCheckBox = this.adk;
        vn = this.adk.vn();
        tbCheckBox.setChecked(!vn);
    }
}
