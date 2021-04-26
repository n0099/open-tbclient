package com.baidu.location.a;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6718a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static b f6719b;

    /* renamed from: c  reason: collision with root package name */
    public int f6720c = -1;

    public static b a() {
        b bVar;
        synchronized (f6718a) {
            if (f6719b == null) {
                f6719b = new b();
            }
            bVar = f6719b;
        }
        return bVar;
    }

    public void a(int i2, int i3, String str) {
        if (i3 != this.f6720c) {
            this.f6720c = i3;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i2);
            bundle.putInt("diagtype", i3);
            bundle.putByteArray("diagmessage", str.getBytes());
            a.a().a(bundle, 303);
        }
    }
}
