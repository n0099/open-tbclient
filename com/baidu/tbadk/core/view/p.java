package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o ajB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.ajB = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        this.ajB.wc();
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ajB.ajs;
        if (currentTimeMillis - j > 500) {
            this.ajB.wb();
        }
        this.ajB.ajs = currentTimeMillis;
    }
}
