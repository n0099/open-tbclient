package com.baidu.tbadk.c;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f amL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.amL = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Ay;
        TextView textView;
        String[] strArr;
        TextView textView2;
        Runnable runnable;
        Ay = this.amL.Ay();
        textView = this.amL.agG;
        strArr = this.amL.XP;
        textView.setText(strArr[Ay]);
        textView2 = this.amL.agG;
        runnable = this.amL.Iu;
        textView2.postDelayed(runnable, 200L);
    }
}
