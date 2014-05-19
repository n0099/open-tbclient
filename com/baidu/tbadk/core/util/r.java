package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class r implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        toast = q.a;
        toast.cancel();
    }
}
