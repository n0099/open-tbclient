package com.baidu.l.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean lPv = false;
    private static long lPw = 10080;
    private static long lPx = 10;
    private static final AtomicBoolean lPy = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> lPz = new HashMap<>();
    public static HashMap<Integer, Long> lPA = new HashMap<>();

    public static synchronized void fH(Context context) {
        synchronized (a.class) {
            if (!lPy.get()) {
                SharedPreferences fI = fI(context);
                Iterator<Integer> it = b.lPB.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    lPA.put(Integer.valueOf(intValue), Long.valueOf(fI.getLong("cache_" + intValue, 10080L)));
                    lPz.put(Integer.valueOf(intValue), Boolean.valueOf(fI.getBoolean("close_" + intValue, false)));
                }
                lPA.put(20001, Long.MAX_VALUE);
                lPz.put(20001, true);
                lPy.set(true);
            }
        }
    }

    public static boolean dlF() {
        return false;
    }

    public static boolean FP(int i) {
        if (lPz.containsKey(Integer.valueOf(i))) {
            return lPz.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long FQ(int i) {
        if (lPA.containsKey(Integer.valueOf(i))) {
            return lPA.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences fI(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
