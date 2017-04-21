package com.baidu.adp.lib.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class l implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = k.zc;
        if (toast != null) {
            toast2 = k.zc;
            toast2.cancel();
        }
    }
}
