package com.baidu.location.a;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6500a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static b f6501b;

    /* renamed from: c  reason: collision with root package name */
    public int f6502c = -1;

    public static b a() {
        b bVar;
        synchronized (f6500a) {
            if (f6501b == null) {
                f6501b = new b();
            }
            bVar = f6501b;
        }
        return bVar;
    }

    public void a(int i, int i2, String str) {
        if (i2 != this.f6502c) {
            this.f6502c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            a.a().a(bundle, 303);
        }
    }
}
