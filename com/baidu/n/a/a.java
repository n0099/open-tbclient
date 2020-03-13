package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.exoplayer2.Format;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean lCy = false;
    private static long lCz = 10080;
    private static long lCA = 10;
    private static final AtomicBoolean lCB = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> lCC = new HashMap<>();
    public static HashMap<Integer, Long> lCD = new HashMap<>();

    public static synchronized void ge(Context context) {
        synchronized (a.class) {
            if (!lCB.get()) {
                SharedPreferences gf = gf(context);
                Iterator<Integer> it = b.lCE.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    lCD.put(Integer.valueOf(intValue), Long.valueOf(gf.getLong("cache_" + intValue, 10080L)));
                    lCC.put(Integer.valueOf(intValue), Boolean.valueOf(gf.getBoolean("close_" + intValue, false)));
                }
                lCD.put(20001, Long.valueOf((long) Format.OFFSET_SAMPLE_RELATIVE));
                lCC.put(20001, true);
                lCB.set(true);
            }
        }
    }

    public static boolean dhU() {
        return false;
    }

    public static boolean Hc(int i) {
        if (lCC.containsKey(Integer.valueOf(i))) {
            return lCC.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Hd(int i) {
        return lCD.containsKey(Integer.valueOf(i)) ? lCD.get(Integer.valueOf(i)).longValue() : Format.OFFSET_SAMPLE_RELATIVE;
    }

    private static SharedPreferences gf(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
