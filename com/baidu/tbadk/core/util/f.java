package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class f implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = e.zc;
        if (toast != null) {
            toast2 = e.zc;
            toast2.cancel();
        }
    }
}
