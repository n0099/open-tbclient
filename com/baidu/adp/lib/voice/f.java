package com.baidu.adp.lib.voice;

import android.os.Handler;
/* loaded from: classes.dex */
public class f {
    private static h og;
    private static String oh;
    private static p oi;
    private static int of = 0;
    private static long oj = 0;
    private static Handler mHandler = new Handler(new g());

    public static boolean a(String str, int i, p pVar) {
        if (System.currentTimeMillis() - oj < 1000) {
            return false;
        }
        oj = System.currentTimeMillis();
        if (of == 0) {
            if (og == null) {
                og = new h(mHandler);
            }
            oh = str;
            oi = pVar;
            if (og.i(str, i)) {
                of = 3;
                new Thread(og).start();
                return true;
            }
            return false;
        }
        return false;
    }

    public static void stop() {
        if (og != null) {
            og.stop();
        }
        of = 0;
    }

    public static void cancel() {
        if (og != null) {
            og.cancel();
        }
        of = 0;
    }
}
