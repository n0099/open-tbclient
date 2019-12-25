package com.baidu.c.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.c.a.b.b;
import com.baidu.c.a.b.c;
import com.baidu.c.a.b.d;
/* loaded from: classes10.dex */
public class a {
    private static boolean Rb;
    private static boolean Rc;

    public static void init(Context context) {
        Rb = h.hu().loadLibrary("criusbase", 2);
        Rc = h.hu().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.c.a.b.a.nO().b(bVar);
    }

    public static void a(c cVar) {
        d.nP().b(cVar);
    }
}
