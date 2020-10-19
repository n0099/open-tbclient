package com.baidu.g.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.g.a.b.b;
import com.baidu.g.a.b.c;
import com.baidu.g.a.b.d;
/* loaded from: classes26.dex */
public class a {
    private static boolean aus;
    private static boolean aut;

    public static void init(Context context) {
        aus = h.oj().loadLibrary("criusbase", 2);
        aut = h.oj().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.g.a.b.a.zq().b(bVar);
    }

    public static void a(c cVar) {
        d.zr().b(cVar);
    }
}
