package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class g implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = f.yT;
        if (toast != null) {
            toast2 = f.yT;
            toast2.cancel();
        }
    }
}
