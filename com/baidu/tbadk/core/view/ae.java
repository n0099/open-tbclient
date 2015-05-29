package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ TbCheckBox ZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(TbCheckBox tbCheckBox) {
        this.ZW = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean uz;
        TbCheckBox tbCheckBox = this.ZW;
        uz = this.ZW.uz();
        tbCheckBox.setChecked(!uz);
    }
}
