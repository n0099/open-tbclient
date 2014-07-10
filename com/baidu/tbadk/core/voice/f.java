package com.baidu.tbadk.core.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class f {
    private static h b;
    private static String c;
    private static l d;
    private static int a = 0;
    private static long e = 0;
    private static Handler f = new Handler(new g());

    public static boolean a(String str, int i, l lVar) {
        if (System.currentTimeMillis() - e < 1000) {
            return false;
        }
        e = System.currentTimeMillis();
        if (a == 0) {
            if (b == null) {
                b = new h(f);
            }
            c = str;
            d = lVar;
            if (b.a(str, i)) {
                a = 3;
                new Thread(b).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void a() {
        if (b != null) {
            b.a();
        }
        a = 0;
    }

    public static void b() {
        if (b != null) {
            b.b();
        }
        a = 0;
    }
}
