package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
final class o implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Toast toast;
        Toast toast2;
        toast = n.a;
        if (toast != null) {
            toast2 = n.a;
            toast2.cancel();
        }
    }
}
