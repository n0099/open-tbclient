package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.agb = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.agb.wu();
    }
}
