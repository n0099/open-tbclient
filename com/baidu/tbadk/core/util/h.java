package com.baidu.tbadk.core.util;

import android.widget.Toast;
/* loaded from: classes.dex */
class h implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        toast = g.sd;
        toast.cancel();
    }
}
