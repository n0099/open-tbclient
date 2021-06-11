package com.baidu.location.b;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6492a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static b f6493b;

    /* renamed from: c  reason: collision with root package name */
    public int f6494c = -1;

    public static b a() {
        b bVar;
        synchronized (f6492a) {
            if (f6493b == null) {
                f6493b = new b();
            }
            bVar = f6493b;
        }
        return bVar;
    }

    public void a(int i2, int i3, String str) {
        if (i3 != this.f6494c) {
            this.f6494c = i3;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i2);
            bundle.putInt("diagtype", i3);
            bundle.putByteArray("diagmessage", str.getBytes());
            a.a().a(bundle, 303);
        }
    }
}
