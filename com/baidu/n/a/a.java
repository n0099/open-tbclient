package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.exoplayer2.Format;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean lEc = false;
    private static long lEd = 10080;
    private static long lEe = 10;
    private static final AtomicBoolean lEf = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> lEg = new HashMap<>();
    public static HashMap<Integer, Long> lEh = new HashMap<>();

    public static synchronized void gc(Context context) {
        synchronized (a.class) {
            if (!lEf.get()) {
                SharedPreferences ge = ge(context);
                Iterator<Integer> it = b.lEi.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    lEh.put(Integer.valueOf(intValue), Long.valueOf(ge.getLong("cache_" + intValue, 10080L)));
                    lEg.put(Integer.valueOf(intValue), Boolean.valueOf(ge.getBoolean("close_" + intValue, false)));
                }
                lEh.put(20001, Long.valueOf((long) Format.OFFSET_SAMPLE_RELATIVE));
                lEg.put(20001, true);
                lEf.set(true);
            }
        }
    }

    public static boolean dir() {
        return false;
    }

    public static boolean Hi(int i) {
        if (lEg.containsKey(Integer.valueOf(i))) {
            return lEg.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Hj(int i) {
        return lEh.containsKey(Integer.valueOf(i)) ? lEh.get(Integer.valueOf(i)).longValue() : Format.OFFSET_SAMPLE_RELATIVE;
    }

    private static SharedPreferences ge(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
