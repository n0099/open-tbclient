package com.baidu.location.a;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b {
    private int c = -1;
    private static Object a = new Object();
    private static b VO = null;

    public static b ql() {
        b bVar;
        synchronized (a) {
            if (VO == null) {
                VO = new b();
            }
            bVar = VO;
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
            a.qk().a(bundle, 303);
        }
    }
}
