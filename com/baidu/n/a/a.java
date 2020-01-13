package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.exoplayer2.Format;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {
    private static boolean lBz = false;
    private static long lBA = 10080;
    private static long lBB = 10;
    private static final AtomicBoolean lBC = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> lBD = new HashMap<>();
    public static HashMap<Integer, Long> lBE = new HashMap<>();

    public static synchronized void gf(Context context) {
        synchronized (a.class) {
            if (!lBC.get()) {
                SharedPreferences gg = gg(context);
                Iterator<Integer> it = b.lBF.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    lBE.put(Integer.valueOf(intValue), Long.valueOf(gg.getLong("cache_" + intValue, 10080L)));
                    lBD.put(Integer.valueOf(intValue), Boolean.valueOf(gg.getBoolean("close_" + intValue, false)));
                }
                lBE.put(20001, Long.valueOf((long) Format.OFFSET_SAMPLE_RELATIVE));
                lBD.put(20001, true);
                lBC.set(true);
            }
        }
    }

    public static boolean dgB() {
        return false;
    }

    public static boolean GX(int i) {
        if (lBD.containsKey(Integer.valueOf(i))) {
            return lBD.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long GY(int i) {
        return lBE.containsKey(Integer.valueOf(i)) ? lBE.get(Integer.valueOf(i)).longValue() : Format.OFFSET_SAMPLE_RELATIVE;
    }

    private static SharedPreferences gg(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
