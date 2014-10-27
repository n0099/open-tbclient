package com.baidu.adp.lib.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class n implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = m.nr;
        if (toast != null) {
            toast2 = m.nr;
            toast2.cancel();
        }
    }
}
