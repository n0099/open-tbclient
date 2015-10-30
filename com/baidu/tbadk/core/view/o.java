package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbCheckBox aev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbCheckBox tbCheckBox) {
        this.aev = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean vy;
        TbCheckBox tbCheckBox = this.aev;
        vy = this.aev.vy();
        tbCheckBox.setChecked(!vy);
    }
}
