package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {
    private static boolean oXw = false;
    private static long oXx = 10080;
    private static long oXy = 10;
    private static final AtomicBoolean oXz = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> oXA = new HashMap<>();
    public static HashMap<Integer, Long> oXB = new HashMap<>();

    public static synchronized void hp(Context context) {
        synchronized (a.class) {
            if (!oXz.get()) {
                SharedPreferences hq = hq(context);
                Iterator<Integer> it = b.oXC.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    oXB.put(Integer.valueOf(intValue), Long.valueOf(hq.getLong("cache_" + intValue, 10080L)));
                    oXA.put(Integer.valueOf(intValue), Boolean.valueOf(hq.getBoolean("close_" + intValue, false)));
                }
                oXB.put(20001, Long.MAX_VALUE);
                oXA.put(20001, true);
                oXz.set(true);
            }
        }
    }

    public static boolean eiN() {
        return false;
    }

    public static boolean Nw(int i) {
        if (oXA.containsKey(Integer.valueOf(i))) {
            return oXA.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Nx(int i) {
        if (oXB.containsKey(Integer.valueOf(i))) {
            return oXB.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences hq(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
