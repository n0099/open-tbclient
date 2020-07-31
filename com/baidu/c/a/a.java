package com.baidu.c.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.c.a.b.b;
import com.baidu.c.a.b.c;
import com.baidu.c.a.b.d;
/* loaded from: classes20.dex */
public class a {
    private static boolean aoh;
    private static boolean aoi;

    public static void init(Context context) {
        aoh = h.mD().loadLibrary("criusbase", 2);
        aoi = h.mD().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.c.a.b.a.ty().b(bVar);
    }

    public static void a(c cVar) {
        d.tz().b(cVar);
    }
}
