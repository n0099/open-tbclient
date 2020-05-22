package com.baidu.b.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.b.a.b.b;
import com.baidu.b.a.b.c;
import com.baidu.b.a.b.d;
/* loaded from: classes13.dex */
public class a {
    private static boolean amT;
    private static boolean amU;

    public static void init(Context context) {
        amT = h.mn().loadLibrary("criusbase", 2);
        amU = h.mn().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.b.a.b.a.tf().b(bVar);
    }

    public static void a(c cVar) {
        d.tg().b(cVar);
    }
}
