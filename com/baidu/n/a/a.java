package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.exoplayer2.Format;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean lCl = false;
    private static long lCm = 10080;
    private static long lCn = 10;
    private static final AtomicBoolean lCo = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> lCp = new HashMap<>();
    public static HashMap<Integer, Long> lCq = new HashMap<>();

    public static synchronized void ge(Context context) {
        synchronized (a.class) {
            if (!lCo.get()) {
                SharedPreferences gf = gf(context);
                Iterator<Integer> it = b.lCr.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    lCq.put(Integer.valueOf(intValue), Long.valueOf(gf.getLong("cache_" + intValue, 10080L)));
                    lCp.put(Integer.valueOf(intValue), Boolean.valueOf(gf.getBoolean("close_" + intValue, false)));
                }
                lCq.put(20001, Long.valueOf((long) Format.OFFSET_SAMPLE_RELATIVE));
                lCp.put(20001, true);
                lCo.set(true);
            }
        }
    }

    public static boolean dhR() {
        return false;
    }

    public static boolean Hc(int i) {
        if (lCp.containsKey(Integer.valueOf(i))) {
            return lCp.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Hd(int i) {
        return lCq.containsKey(Integer.valueOf(i)) ? lCq.get(Integer.valueOf(i)).longValue() : Format.OFFSET_SAMPLE_RELATIVE;
    }

    private static SharedPreferences gf(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
