package com.baidu.adp.lib.g;

import android.widget.Toast;
/* loaded from: classes.dex */
final class h implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = g.e;
        if (toast != null) {
            toast2 = g.e;
            toast2.cancel();
        }
    }
}
