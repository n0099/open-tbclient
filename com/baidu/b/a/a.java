package com.baidu.b.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.b.a.b.b;
import com.baidu.b.a.b.c;
import com.baidu.b.a.b.d;
/* loaded from: classes3.dex */
public class a {
    private static boolean Lg;
    private static boolean Lh;

    public static void init(Context context) {
        Lg = h.gX().loadLibrary("criusbase", 2);
        Lh = h.gX().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.b.a.b.a.mG().b(bVar);
    }

    public static void a(c cVar) {
        d.mH().b(cVar);
    }
}
