package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ TbCheckBox agz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TbCheckBox tbCheckBox) {
        this.agz = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean xz;
        TbCheckBox tbCheckBox = this.agz;
        xz = this.agz.xz();
        tbCheckBox.setChecked(!xz);
    }
}
