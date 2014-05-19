package com.baidu.adp.lib.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class i implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = h.e;
        if (toast != null) {
            toast2 = h.e;
            toast2.cancel();
        }
    }
}
