package com.baidu.tbadk.c;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f aux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aux = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Ct;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Ct = this.aux.Ct();
        textView = this.aux.alM;
        strArr = this.aux.acM;
        textView.setText(strArr[Ct]);
        Handler handler = TbadkCoreApplication.m411getInst().handler;
        runnable = this.aux.Ix;
        handler.postDelayed(runnable, 200L);
    }
}
