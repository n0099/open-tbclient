package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o ajL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.ajL = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        this.ajL.wf();
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ajL.ajC;
        if (currentTimeMillis - j > 500) {
            this.ajL.we();
        }
        this.ajL.ajC = currentTimeMillis;
    }
}
