package com.baidu.l.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean miQ = false;
    private static long miR = 10080;
    private static long miS = 10;
    private static final AtomicBoolean miT = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> miU = new HashMap<>();
    public static HashMap<Integer, Long> miV = new HashMap<>();

    public static synchronized void fK(Context context) {
        synchronized (a.class) {
            if (!miT.get()) {
                SharedPreferences fL = fL(context);
                Iterator<Integer> it = b.miW.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    miV.put(Integer.valueOf(intValue), Long.valueOf(fL.getLong("cache_" + intValue, 10080L)));
                    miU.put(Integer.valueOf(intValue), Boolean.valueOf(fL.getBoolean("close_" + intValue, false)));
                }
                miV.put(20001, Long.MAX_VALUE);
                miU.put(20001, true);
                miT.set(true);
            }
        }
    }

    public static boolean dsS() {
        return false;
    }

    public static boolean GC(int i) {
        if (miU.containsKey(Integer.valueOf(i))) {
            return miU.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long GD(int i) {
        if (miV.containsKey(Integer.valueOf(i))) {
            return miV.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences fL(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
