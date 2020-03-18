package com.baidu.c.a;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.c.a.b.b;
import com.baidu.c.a.b.c;
import com.baidu.c.a.b.d;
/* loaded from: classes13.dex */
public class a {
    private static boolean SY;
    private static boolean SZ;

    public static void init(Context context) {
        SY = h.hH().loadLibrary("criusbase", 2);
        SZ = h.hH().loadLibrary("crius", 2);
    }

    public static void a(b bVar) {
        com.baidu.c.a.b.a.oD().b(bVar);
    }

    public static void a(c cVar) {
        d.oE().b(cVar);
    }
}
