package com.baidu.b.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.b.a.b.b;
import com.baidu.b.a.b.c;
import com.baidu.b.a.b.d;
/* loaded from: classes13.dex */
public class a {
    private static boolean aol;
    private static boolean aom;

    public static void init(Context context) {
        aol = h.mD().loadLibrary("criusbase", 2);
        aom = h.mD().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.b.a.b.a.ty().b(bVar);
    }

    public static void a(c cVar) {
        d.tz().b(cVar);
    }
}
