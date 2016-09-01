package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aeQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aeQ = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.aeQ.sk;
        if (toast != null) {
            toast2 = this.aeQ.sk;
            toast2.cancel();
        }
    }
}
