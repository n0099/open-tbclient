package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f adG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.adG = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.adG.yD;
        if (toast != null) {
            toast2 = this.adG.yD;
            toast2.cancel();
        }
    }
}
