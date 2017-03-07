package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ y Rp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.Rp = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Rp.ok();
    }
}
