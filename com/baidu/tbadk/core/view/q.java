package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ TbCheckBox agk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbCheckBox tbCheckBox) {
        this.agk = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean vS;
        TbCheckBox tbCheckBox = this.agk;
        vS = this.agk.vS();
        tbCheckBox.setChecked(!vS);
    }
}
