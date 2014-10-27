package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class l implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = k.nr;
        if (toast != null) {
            toast2 = k.nr;
            toast2.cancel();
        }
    }
}
