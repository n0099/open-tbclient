package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h ajH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.ajH = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.ajH.zc;
        if (toast != null) {
            toast2 = this.ajH.zc;
            toast2.cancel();
        }
    }
}
