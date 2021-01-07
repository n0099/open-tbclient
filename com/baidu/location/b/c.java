package com.baidu.location.b;

import android.os.Bundle;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Object f2604a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static c f2605b = null;
    private int c = -1;

    public static c a() {
        c cVar;
        synchronized (f2604a) {
            if (f2605b == null) {
                f2605b = new c();
            }
            cVar = f2605b;
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
