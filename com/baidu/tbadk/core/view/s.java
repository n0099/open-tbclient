package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ TbCheckBox afZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbCheckBox tbCheckBox) {
        this.afZ = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean wr;
        TbCheckBox tbCheckBox = this.afZ;
        wr = this.afZ.wr();
        tbCheckBox.setChecked(!wr);
    }
}
