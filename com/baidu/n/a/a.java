package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {
    private static boolean oKJ = false;
    private static long oKK = 10080;
    private static long oKL = 10;
    private static final AtomicBoolean oKM = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> oKN = new HashMap<>();
    public static HashMap<Integer, Long> oKO = new HashMap<>();

    public static synchronized void hn(Context context) {
        synchronized (a.class) {
            if (!oKM.get()) {
                SharedPreferences ho = ho(context);
                Iterator<Integer> it = b.oKP.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    oKO.put(Integer.valueOf(intValue), Long.valueOf(ho.getLong("cache_" + intValue, 10080L)));
                    oKN.put(Integer.valueOf(intValue), Boolean.valueOf(ho.getBoolean("close_" + intValue, false)));
                }
                oKO.put(20001, Long.MAX_VALUE);
                oKN.put(20001, true);
                oKM.set(true);
            }
        }
    }

    public static boolean egd() {
        return false;
    }

    public static boolean MV(int i) {
        if (oKN.containsKey(Integer.valueOf(i))) {
            return oKN.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long MW(int i) {
        if (oKO.containsKey(Integer.valueOf(i))) {
            return oKO.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences ho(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
