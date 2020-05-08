package com.baidu.l.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean lPz = false;
    private static long lPA = 10080;
    private static long lPB = 10;
    private static final AtomicBoolean lPC = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> lPD = new HashMap<>();
    public static HashMap<Integer, Long> lPE = new HashMap<>();

    public static synchronized void fv(Context context) {
        synchronized (a.class) {
            if (!lPC.get()) {
                SharedPreferences fw = fw(context);
                Iterator<Integer> it = b.lPF.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    lPE.put(Integer.valueOf(intValue), Long.valueOf(fw.getLong("cache_" + intValue, 10080L)));
                    lPD.put(Integer.valueOf(intValue), Boolean.valueOf(fw.getBoolean("close_" + intValue, false)));
                }
                lPE.put(20001, Long.MAX_VALUE);
                lPD.put(20001, true);
                lPC.set(true);
            }
        }
    }

    public static boolean dlC() {
        return false;
    }

    public static boolean FP(int i) {
        if (lPD.containsKey(Integer.valueOf(i))) {
            return lPD.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long FQ(int i) {
        if (lPE.containsKey(Integer.valueOf(i))) {
            return lPE.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences fw(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
