package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class h implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = g.yD;
        if (toast != null) {
            toast2 = g.yD;
            toast2.cancel();
        }
    }
}
