package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class g implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = f.pv;
        if (toast != null) {
            toast2 = f.pv;
            toast2.cancel();
        }
    }
}
