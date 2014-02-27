package com.baidu.adp.widget.BdSwitchView;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {
    final /* synthetic */ BdSwitchView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSwitchView bdSwitchView) {
        this.a = bdSwitchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.c(true);
    }
}
