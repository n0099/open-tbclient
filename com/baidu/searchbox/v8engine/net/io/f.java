package com.baidu.searchbox.v8engine.net.io;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public final class f {
    @Nullable
    public static e a;
    public static long b;

    public static e a() {
        synchronized (f.class) {
            if (a != null) {
                e eVar = a;
                a = eVar.f;
                eVar.f = null;
                b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return eVar;
            }
            return new e();
        }
    }

    public static void a(e eVar) {
        if (eVar.f == null && eVar.g == null) {
            if (eVar.d) {
                return;
            }
            synchronized (f.class) {
                if (b + PlaybackStateCompat.ACTION_PLAY_FROM_URI > 65536) {
                    return;
                }
                b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                eVar.f = a;
                eVar.c = 0;
                eVar.b = 0;
                a = eVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
