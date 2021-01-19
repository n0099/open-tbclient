package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {
    private static boolean oKK = false;
    private static long oKL = 10080;
    private static long oKM = 10;
    private static final AtomicBoolean oKN = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> oKO = new HashMap<>();
    public static HashMap<Integer, Long> oKP = new HashMap<>();

    public static synchronized void hn(Context context) {
        synchronized (a.class) {
            if (!oKN.get()) {
                SharedPreferences ho = ho(context);
                Iterator<Integer> it = b.oKQ.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    oKP.put(Integer.valueOf(intValue), Long.valueOf(ho.getLong("cache_" + intValue, 10080L)));
                    oKO.put(Integer.valueOf(intValue), Boolean.valueOf(ho.getBoolean("close_" + intValue, false)));
                }
                oKP.put(20001, Long.MAX_VALUE);
                oKO.put(20001, true);
                oKN.set(true);
            }
        }
    }

    public static boolean egd() {
        return false;
    }

    public static boolean MV(int i) {
        if (oKO.containsKey(Integer.valueOf(i))) {
            return oKO.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long MW(int i) {
        if (oKP.containsKey(Integer.valueOf(i))) {
            return oKP.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences ho(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
