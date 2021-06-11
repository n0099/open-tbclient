package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class f {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public static e f10106a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10107b;

    public static e a() {
        synchronized (f.class) {
            if (f10106a != null) {
                e eVar = f10106a;
                f10106a = eVar.f10104f;
                eVar.f10104f = null;
                f10107b -= 8192;
                return eVar;
            }
            return new e();
        }
    }

    public static void a(e eVar) {
        if (eVar.f10104f == null && eVar.f10105g == null) {
            if (eVar.f10102d) {
                return;
            }
            synchronized (f.class) {
                if (f10107b + 8192 > 65536) {
                    return;
                }
                f10107b += 8192;
                eVar.f10104f = f10106a;
                eVar.f10101c = 0;
                eVar.f10100b = 0;
                f10106a = eVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
