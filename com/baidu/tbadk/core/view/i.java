package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aed = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.aed.sd;
        if (toast != null) {
            toast2 = this.aed.sd;
            toast2.cancel();
        }
    }
}
