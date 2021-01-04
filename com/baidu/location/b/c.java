package com.baidu.location.b;

import android.os.Bundle;
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Object f2603a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static c f2604b = null;
    private int c = -1;

    public static c a() {
        c cVar;
        synchronized (f2603a) {
            if (f2604b == null) {
                f2604b = new c();
            }
            cVar = f2604b;
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
