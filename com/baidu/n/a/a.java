package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.exoplayer2.Format;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {
    private static boolean lBE = false;
    private static long lBF = 10080;
    private static long lBG = 10;
    private static final AtomicBoolean lBH = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> lBI = new HashMap<>();
    public static HashMap<Integer, Long> lBJ = new HashMap<>();

    public static synchronized void gf(Context context) {
        synchronized (a.class) {
            if (!lBH.get()) {
                SharedPreferences gg = gg(context);
                Iterator<Integer> it = b.lBK.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    lBJ.put(Integer.valueOf(intValue), Long.valueOf(gg.getLong("cache_" + intValue, 10080L)));
                    lBI.put(Integer.valueOf(intValue), Boolean.valueOf(gg.getBoolean("close_" + intValue, false)));
                }
                lBJ.put(20001, Long.valueOf((long) Format.OFFSET_SAMPLE_RELATIVE));
                lBI.put(20001, true);
                lBH.set(true);
            }
        }
    }

    public static boolean dgD() {
        return false;
    }

    public static boolean GX(int i) {
        if (lBI.containsKey(Integer.valueOf(i))) {
            return lBI.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long GY(int i) {
        return lBJ.containsKey(Integer.valueOf(i)) ? lBJ.get(Integer.valueOf(i)).longValue() : Format.OFFSET_SAMPLE_RELATIVE;
    }

    private static SharedPreferences gg(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
