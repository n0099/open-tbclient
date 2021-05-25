package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class f {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public static e f10044a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10045b;

    public static e a() {
        synchronized (f.class) {
            if (f10044a != null) {
                e eVar = f10044a;
                f10044a = eVar.f10042f;
                eVar.f10042f = null;
                f10045b -= 8192;
                return eVar;
            }
            return new e();
        }
    }

    public static void a(e eVar) {
        if (eVar.f10042f == null && eVar.f10043g == null) {
            if (eVar.f10040d) {
                return;
            }
            synchronized (f.class) {
                if (f10045b + 8192 > 65536) {
                    return;
                }
                f10045b += 8192;
                eVar.f10042f = f10044a;
                eVar.f10039c = 0;
                eVar.f10038b = 0;
                f10044a = eVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
