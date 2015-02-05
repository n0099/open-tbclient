package com.baidu.adp.widget.BdSwitchView;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ BdSwitchView um;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSwitchView bdSwitchView) {
        this.um = bdSwitchView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.um.L(true);
    }
}
