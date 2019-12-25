package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.exoplayer2.Format;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {
    private static boolean lya = false;
    private static long lyb = 10080;
    private static long lyc = 10;
    private static final AtomicBoolean lyd = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> lye = new HashMap<>();
    public static HashMap<Integer, Long> lyf = new HashMap<>();

    public static synchronized void ge(Context context) {
        synchronized (a.class) {
            if (!lyd.get()) {
                SharedPreferences gf = gf(context);
                Iterator<Integer> it = b.lyg.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    lyf.put(Integer.valueOf(intValue), Long.valueOf(gf.getLong("cache_" + intValue, 10080L)));
                    lye.put(Integer.valueOf(intValue), Boolean.valueOf(gf.getBoolean("close_" + intValue, false)));
                }
                lyf.put(20001, Long.valueOf((long) Format.OFFSET_SAMPLE_RELATIVE));
                lye.put(20001, true);
                lyd.set(true);
            }
        }
    }

    public static boolean dfz() {
        return false;
    }

    public static boolean GS(int i) {
        if (lye.containsKey(Integer.valueOf(i))) {
            return lye.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long GT(int i) {
        return lyf.containsKey(Integer.valueOf(i)) ? lyf.get(Integer.valueOf(i)).longValue() : Format.OFFSET_SAMPLE_RELATIVE;
    }

    private static SharedPreferences gf(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
