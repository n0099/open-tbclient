package com.baidu.tbadk.core.view;

import android.widget.Toast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h abp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.abp = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = this.abp.pv;
        if (toast != null) {
            toast2 = this.abp.pv;
            toast2.cancel();
        }
    }
}
