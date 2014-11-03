package com.baidu.tbadk.c;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f VJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.VJ = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int sA;
        TextView textView;
        String[] strArr;
        TextView textView2;
        Runnable runnable;
        sA = this.VJ.sA();
        textView = this.VJ.Ph;
        strArr = this.VJ.VG;
        textView.setText(strArr[sA]);
        textView2 = this.VJ.Ph;
        runnable = this.VJ.wb;
        textView2.postDelayed(runnable, 200L);
    }
}
