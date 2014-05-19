package com.baidu.adp.lib.asyncTask;

import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public final class l {
    private static int a = LocationClientOption.MIN_SCAN_SPAN;
    private int b = 0;

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            lVar = new l();
            lVar.b = a;
            a++;
        }
        return lVar;
    }

    private l() {
    }
}
