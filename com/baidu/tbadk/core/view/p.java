package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o ako;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.ako = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        this.ako.wS();
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ako.akf;
        if (currentTimeMillis - j > 500) {
            this.ako.wR();
        }
        this.ako.akf = currentTimeMillis;
    }
}
