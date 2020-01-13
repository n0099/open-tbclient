package com.baidu.c.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.c.a.b.b;
import com.baidu.c.a.b.c;
import com.baidu.c.a.b.d;
/* loaded from: classes11.dex */
public class a {
    private static boolean Rg;
    private static boolean Rh;

    public static void init(Context context) {
        Rg = h.ht().loadLibrary("criusbase", 2);
        Rh = h.ht().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.c.a.b.a.nP().b(bVar);
    }

    public static void a(c cVar) {
        d.nQ().b(cVar);
    }
}
