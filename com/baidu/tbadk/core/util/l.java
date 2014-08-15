package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class l implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = k.a;
        if (toast != null) {
            toast2 = k.a;
            toast2.cancel();
        }
    }
}
