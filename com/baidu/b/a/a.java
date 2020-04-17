package com.baidu.b.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.b.a.b.b;
import com.baidu.b.a.b.c;
import com.baidu.b.a.b.d;
/* loaded from: classes13.dex */
public class a {
    private static boolean alk;
    private static boolean alm;

    public static void init(Context context) {
        alk = h.ml().loadLibrary("criusbase", 2);
        alm = h.ml().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.b.a.b.a.sX().b(bVar);
    }

    public static void a(c cVar) {
        d.sY().b(cVar);
    }
}
