package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ n aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aeo = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.aeo.yC;
        if (toast != null) {
            toast2 = this.aeo.yC;
            toast2.cancel();
        }
    }
}
