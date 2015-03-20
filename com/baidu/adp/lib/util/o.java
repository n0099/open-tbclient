package com.baidu.adp.lib.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class o implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = n.yQ;
        if (toast != null) {
            toast2 = n.yQ;
            toast2.cancel();
        }
    }
}
