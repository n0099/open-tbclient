package com.baidu.location;

import android.os.HandlerThread;
/* loaded from: classes.dex */
class ar {
    private static HandlerThread a = null;

    ar() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HandlerThread a() {
        if (a == null) {
            a = new HandlerThread("ServiceStartArguments", 10);
            a.start();
        }
        return a;
    }
}
