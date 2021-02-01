package com.baidu.location.a;

import android.os.Bundle;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Object f2532a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static b f2533b = null;
    private int c = -1;

    public static b a() {
        b bVar;
        synchronized (f2532a) {
            if (f2533b == null) {
                f2533b = new b();
            }
            bVar = f2533b;
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
            a.a().a(bundle, 303);
        }
    }
}
