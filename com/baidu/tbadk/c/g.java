package com.baidu.tbadk.c;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f VF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.VF = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int sy;
        TextView textView;
        String[] strArr;
        TextView textView2;
        Runnable runnable;
        sy = this.VF.sy();
        textView = this.VF.Pd;
        strArr = this.VF.VC;
        textView.setText(strArr[sy]);
        textView2 = this.VF.Pd;
        runnable = this.VF.wb;
        textView2.postDelayed(runnable, 200L);
    }
}
