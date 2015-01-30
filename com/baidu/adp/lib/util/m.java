package com.baidu.adp.lib.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class m implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = l.nt;
        if (toast != null) {
            toast2 = l.nt;
            toast2.cancel();
        }
    }
}
