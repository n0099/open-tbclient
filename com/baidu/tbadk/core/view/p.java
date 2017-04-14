package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o akn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.akn = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        this.akn.wS();
        long currentTimeMillis = System.currentTimeMillis();
        j = this.akn.ake;
        if (currentTimeMillis - j > 500) {
            this.akn.wR();
        }
        this.akn.ake = currentTimeMillis;
    }
}
