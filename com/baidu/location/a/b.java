package com.baidu.location.a;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6464a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static b f6465b;

    /* renamed from: c  reason: collision with root package name */
    public int f6466c = -1;

    public static b a() {
        b bVar;
        synchronized (f6464a) {
            if (f6465b == null) {
                f6465b = new b();
            }
            bVar = f6465b;
        }
        return bVar;
    }

    public void a(int i, int i2, String str) {
        if (i2 != this.f6466c) {
            this.f6466c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            a.a().a(bundle, 303);
        }
    }
}
