package com.baidu.location.b;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6549a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static b f6550b;

    /* renamed from: c  reason: collision with root package name */
    public int f6551c = -1;

    public static b a() {
        b bVar;
        synchronized (f6549a) {
            if (f6550b == null) {
                f6550b = new b();
            }
            bVar = f6550b;
        }
        return bVar;
    }

    public void a(int i2, int i3, String str) {
        if (i3 != this.f6551c) {
            this.f6551c = i3;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i2);
            bundle.putInt("diagtype", i3);
            bundle.putByteArray("diagmessage", str.getBytes());
            a.a().a(bundle, 303);
        }
    }
}
