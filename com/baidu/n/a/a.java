package com.baidu.n.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean oUR = false;
    private static long oUS = 10080;
    private static long oUT = 10;
    private static final AtomicBoolean oUU = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> oUV = new HashMap<>();
    public static HashMap<Integer, Long> oUW = new HashMap<>();

    public static synchronized void hq(Context context) {
        synchronized (a.class) {
            if (!oUU.get()) {
                SharedPreferences hr = hr(context);
                Iterator<Integer> it = b.oUX.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    oUW.put(Integer.valueOf(intValue), Long.valueOf(hr.getLong("cache_" + intValue, 10080L)));
                    oUV.put(Integer.valueOf(intValue), Boolean.valueOf(hr.getBoolean("close_" + intValue, false)));
                }
                oUW.put(20001, Long.MAX_VALUE);
                oUV.put(20001, true);
                oUU.set(true);
            }
        }
    }

    public static boolean eiv() {
        return false;
    }

    public static boolean Nr(int i) {
        if (oUV.containsKey(Integer.valueOf(i))) {
            return oUV.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Ns(int i) {
        if (oUW.containsKey(Integer.valueOf(i))) {
            return oUW.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences hr(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
