package com.baidu.g.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.g.a.b.b;
import com.baidu.g.a.b.c;
import com.baidu.g.a.b.d;
/* loaded from: classes20.dex */
public class a {
    private static boolean ath;
    private static boolean ati;

    public static void init(Context context) {
        ath = h.oc().loadLibrary("criusbase", 2);
        ati = h.oc().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.g.a.b.a.yU().b(bVar);
    }

    public static void a(c cVar) {
        d.yV().b(cVar);
    }
}
