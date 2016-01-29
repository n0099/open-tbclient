package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h afX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.afX = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.afX.yT;
        if (toast != null) {
            toast2 = this.afX.yT;
            toast2.cancel();
        }
    }
}
