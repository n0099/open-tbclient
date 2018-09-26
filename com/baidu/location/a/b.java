package com.baidu.location.a;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b {
    private int c = -1;
    private static Object a = new Object();
    private static b Yp = null;

    public static b rq() {
        b bVar;
        synchronized (a) {
            if (Yp == null) {
                Yp = new b();
            }
            bVar = Yp;
        }
        return bVar;
    }

    public void a(int i, int i2, String str) {
        if (i2 != this.c) {
            this.c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            a.rp().a(bundle, 303);
        }
    }
}
