package com.baidu.location.a;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6465a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static b f6466b;

    /* renamed from: c  reason: collision with root package name */
    public int f6467c = -1;

    public static b a() {
        b bVar;
        synchronized (f6465a) {
            if (f6466b == null) {
                f6466b = new b();
            }
            bVar = f6466b;
        }
        return bVar;
    }

    public void a(int i, int i2, String str) {
        if (i2 != this.f6467c) {
            this.f6467c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            a.a().a(bundle, 303);
        }
    }
}
