package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class f implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = e.yZ;
        if (toast != null) {
            toast2 = e.yZ;
            toast2.cancel();
        }
    }
}
