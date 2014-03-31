package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
final class q implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Toast toast;
        toast = p.a;
        toast.cancel();
    }
}
