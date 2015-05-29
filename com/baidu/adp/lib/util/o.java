package com.baidu.adp.lib.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class o implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = n.yE;
        if (toast != null) {
            toast2 = n.yE;
            toast2.cancel();
        }
    }
}
