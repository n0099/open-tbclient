package com.baidu.tbadk.core.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class f {
    private static h b;
    private static String c;
    private static l d;
    private static int a = 0;
    private static long e = 0;
    private static Handler f = new Handler(new g());

    public static boolean a(String str, int i, l lVar) {
        long currentTimeMillis = System.currentTimeMillis() - e;
        if (currentTimeMillis < 1000) {
            BdLog.i("----start duration......" + currentTimeMillis);
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
                BdLog.i("----start record......");
                new Thread(b).start();
                return true;
            }
            return false;
        }
        BdLog.i("----start record state......" + a);
        return false;
    }

    public static void a() {
        BdLog.i("----stop record......");
        if (b != null) {
            b.a();
        }
        a = 0;
    }

    public static void b() {
        BdLog.i("----cancel record......");
        if (b != null) {
            b.b();
        }
        a = 0;
    }
}
