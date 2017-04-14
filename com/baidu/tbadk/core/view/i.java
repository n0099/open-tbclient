package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h ajG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.ajG = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.ajG.yZ;
        if (toast != null) {
            toast2 = this.ajG.yZ;
            toast2.cancel();
        }
    }
}
