package com.baidu.adp.lib.util;

import android.widget.Toast;
/* loaded from: classes.dex */
final class j implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Toast toast;
        Toast toast2;
        toast = i.e;
        if (toast != null) {
            toast2 = i.e;
            toast2.cancel();
        }
    }
}
