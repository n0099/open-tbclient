package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class f {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public static e f10144a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10145b;

    public static e a() {
        synchronized (f.class) {
            if (f10144a != null) {
                e eVar = f10144a;
                f10144a = eVar.f10142f;
                eVar.f10142f = null;
                f10145b -= 8192;
                return eVar;
            }
            return new e();
        }
    }

    public static void a(e eVar) {
        if (eVar.f10142f == null && eVar.f10143g == null) {
            if (eVar.f10140d) {
                return;
            }
            synchronized (f.class) {
                if (f10145b + 8192 > 65536) {
                    return;
                }
                f10145b += 8192;
                eVar.f10142f = f10144a;
                eVar.f10139c = 0;
                eVar.f10138b = 0;
                f10144a = eVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
