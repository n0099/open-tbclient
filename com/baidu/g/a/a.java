package com.baidu.g.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.g.a.b.b;
import com.baidu.g.a.b.c;
import com.baidu.g.a.b.d;
/* loaded from: classes25.dex */
public class a {
    private static boolean atJ;
    private static boolean atK;

    public static void init(Context context) {
        atJ = h.oi().loadLibrary("criusbase", 2);
        atK = h.oi().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.g.a.b.a.zi().b(bVar);
    }

    public static void a(c cVar) {
        d.zj().b(cVar);
    }
}
