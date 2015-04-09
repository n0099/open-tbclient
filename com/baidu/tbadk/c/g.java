package com.baidu.tbadk.c;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f alK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.alK = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int zL;
        TextView textView;
        String[] strArr;
        TextView textView2;
        Runnable runnable;
        zL = this.alK.zL();
        textView = this.alK.afF;
        strArr = this.alK.Xe;
        textView.setText(strArr[zL]);
        textView2 = this.alK.afF;
        runnable = this.alK.IF;
        textView2.postDelayed(runnable, 200L);
    }
}
