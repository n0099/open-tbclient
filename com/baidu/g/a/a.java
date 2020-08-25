package com.baidu.g.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.g.a.b.b;
import com.baidu.g.a.b.c;
import com.baidu.g.a.b.d;
/* loaded from: classes20.dex */
public class a {
    private static boolean atf;
    private static boolean atg;

    public static void init(Context context) {
        atf = h.oc().loadLibrary("criusbase", 2);
        atg = h.oc().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.g.a.b.a.yU().b(bVar);
    }

    public static void a(c cVar) {
        d.yV().b(cVar);
    }
}
