package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ TbCheckBox Iu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbCheckBox tbCheckBox) {
        this.Iu = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean nA;
        TbCheckBox tbCheckBox = this.Iu;
        nA = this.Iu.nA();
        tbCheckBox.setChecked(!nA);
    }
}
