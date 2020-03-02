package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.exoplayer2.Format;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean lCn = false;
    private static long lCo = 10080;
    private static long lCp = 10;
    private static final AtomicBoolean lCq = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> lCr = new HashMap<>();
    public static HashMap<Integer, Long> lCs = new HashMap<>();

    public static synchronized void ge(Context context) {
        synchronized (a.class) {
            if (!lCq.get()) {
                SharedPreferences gf = gf(context);
                Iterator<Integer> it = b.lCt.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    lCs.put(Integer.valueOf(intValue), Long.valueOf(gf.getLong("cache_" + intValue, 10080L)));
                    lCr.put(Integer.valueOf(intValue), Boolean.valueOf(gf.getBoolean("close_" + intValue, false)));
                }
                lCs.put(20001, Long.valueOf((long) Format.OFFSET_SAMPLE_RELATIVE));
                lCr.put(20001, true);
                lCq.set(true);
            }
        }
    }

    public static boolean dhT() {
        return false;
    }

    public static boolean Hc(int i) {
        if (lCr.containsKey(Integer.valueOf(i))) {
            return lCr.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Hd(int i) {
        return lCs.containsKey(Integer.valueOf(i)) ? lCs.get(Integer.valueOf(i)).longValue() : Format.OFFSET_SAMPLE_RELATIVE;
    }

    private static SharedPreferences gf(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
