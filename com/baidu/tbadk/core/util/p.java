package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class p implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = o.a;
        if (toast != null) {
            toast2 = o.a;
            toast2.cancel();
        }
    }
}
