package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h afz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.afz = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.afz.sl;
        if (toast != null) {
            toast2 = this.afz.sl;
            toast2.cancel();
        }
    }
}
