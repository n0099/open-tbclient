package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ g aeD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aeD = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.aeD.yJ;
        if (toast != null) {
            toast2 = this.aeD.yJ;
            toast2.cancel();
        }
    }
}
