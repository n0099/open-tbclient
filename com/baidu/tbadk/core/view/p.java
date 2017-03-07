package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o ajZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.ajZ = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        this.ajZ.ww();
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ajZ.ajQ;
        if (currentTimeMillis - j > 500) {
            this.ajZ.wv();
        }
        this.ajZ.ajQ = currentTimeMillis;
    }
}
