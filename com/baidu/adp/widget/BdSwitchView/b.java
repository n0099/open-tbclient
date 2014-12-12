package com.baidu.adp.widget.BdSwitchView;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ BdSwitchView ui;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSwitchView bdSwitchView) {
        this.ui = bdSwitchView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ui.L(true);
    }
}
