package com.baidu.tbadk.c;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f alC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.alC = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int zF;
        TextView textView;
        String[] strArr;
        TextView textView2;
        Runnable runnable;
        zF = this.alC.zF();
        textView = this.alC.afx;
        strArr = this.alC.Xc;
        textView.setText(strArr[zF]);
        textView2 = this.alC.afx;
        runnable = this.alC.IC;
        textView2.postDelayed(runnable, 200L);
    }
}
