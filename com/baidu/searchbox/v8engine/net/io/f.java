package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class f {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public static e f10138a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10139b;

    public static e a() {
        synchronized (f.class) {
            if (f10138a != null) {
                e eVar = f10138a;
                f10138a = eVar.f10136f;
                eVar.f10136f = null;
                f10139b -= 8192;
                return eVar;
            }
            return new e();
        }
    }

    public static void a(e eVar) {
        if (eVar.f10136f == null && eVar.f10137g == null) {
            if (eVar.f10134d) {
                return;
            }
            synchronized (f.class) {
                if (f10139b + 8192 > 65536) {
                    return;
                }
                f10139b += 8192;
                eVar.f10136f = f10138a;
                eVar.f10133c = 0;
                eVar.f10132b = 0;
                f10138a = eVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
