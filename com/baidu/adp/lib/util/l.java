package com.baidu.adp.lib.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class l implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = k.sl;
        if (toast != null) {
            toast2 = k.sl;
            toast2.cancel();
        }
    }
}
