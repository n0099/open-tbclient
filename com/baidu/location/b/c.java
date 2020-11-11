package com.baidu.location.b;

import android.os.Bundle;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Object f1876a = new Object();
    private static c b = null;
    private int c = -1;

    public static c a() {
        c cVar;
        synchronized (f1876a) {
            if (b == null) {
                b = new c();
            }
            cVar = b;
        }
        return cVar;
    }

    public void a(int i, int i2, String str) {
        if (i2 != this.c) {
            this.c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            b.a().a(bundle, 303);
        }
    }
}
