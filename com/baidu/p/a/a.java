package com.baidu.p.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {
    private static boolean oPl = false;
    private static long oPm = 10080;
    private static long oPn = 10;
    private static final AtomicBoolean oPo = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> oPp = new HashMap<>();
    public static HashMap<Integer, Long> oPq = new HashMap<>();

    public static synchronized void hp(Context context) {
        synchronized (a.class) {
            if (!oPo.get()) {
                SharedPreferences hq = hq(context);
                Iterator<Integer> it = b.oPr.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    oPq.put(Integer.valueOf(intValue), Long.valueOf(hq.getLong("cache_" + intValue, 10080L)));
                    oPp.put(Integer.valueOf(intValue), Boolean.valueOf(hq.getBoolean("close_" + intValue, false)));
                }
                oPq.put(20001, Long.MAX_VALUE);
                oPp.put(20001, true);
                oPo.set(true);
            }
        }
    }

    public static boolean ejW() {
        return false;
    }

    public static boolean OC(int i) {
        if (oPp.containsKey(Integer.valueOf(i))) {
            return oPp.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long OD(int i) {
        if (oPq.containsKey(Integer.valueOf(i))) {
            return oPq.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences hq(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
