package com.baidu.adp.lib.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class k implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = j.e;
        if (toast != null) {
            toast2 = j.e;
            toast2.cancel();
        }
    }
}
