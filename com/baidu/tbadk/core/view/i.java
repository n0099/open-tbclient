package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aiU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aiU = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.aiU.zd;
        if (toast != null) {
            toast2 = this.aiU.zd;
            toast2.cancel();
        }
    }
}
