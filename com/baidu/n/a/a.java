package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean oVr = false;
    private static long oVs = 10080;
    private static long oVt = 10;
    private static final AtomicBoolean oVu = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> oVv = new HashMap<>();
    public static HashMap<Integer, Long> oVw = new HashMap<>();

    public static synchronized void hq(Context context) {
        synchronized (a.class) {
            if (!oVu.get()) {
                SharedPreferences hr = hr(context);
                Iterator<Integer> it = b.oVx.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    oVw.put(Integer.valueOf(intValue), Long.valueOf(hr.getLong("cache_" + intValue, 10080L)));
                    oVv.put(Integer.valueOf(intValue), Boolean.valueOf(hr.getBoolean("close_" + intValue, false)));
                }
                oVw.put(20001, Long.MAX_VALUE);
                oVv.put(20001, true);
                oVu.set(true);
            }
        }
    }

    public static boolean eiD() {
        return false;
    }

    public static boolean Ns(int i) {
        if (oVv.containsKey(Integer.valueOf(i))) {
            return oVv.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Nt(int i) {
        if (oVw.containsKey(Integer.valueOf(i))) {
            return oVw.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences hr(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
