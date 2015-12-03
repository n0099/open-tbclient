package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ TbCheckBox afx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbCheckBox tbCheckBox) {
        this.afx = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean wi;
        TbCheckBox tbCheckBox = this.afx;
        wi = this.afx.wi();
        tbCheckBox.setChecked(!wi);
    }
}
