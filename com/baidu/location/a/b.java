package com.baidu.location.a;

import android.os.Bundle;
/* loaded from: classes6.dex */
public class b {
    private static Object a = new Object();
    private static b acG = null;
    private int c = -1;

    public static b td() {
        b bVar;
        synchronized (a) {
            if (acG == null) {
                acG = new b();
            }
            bVar = acG;
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
            a.tc().a(bundle, 303);
        }
    }

    public void b() {
        this.c = -1;
    }
}
