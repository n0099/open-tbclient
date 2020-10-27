package com.baidu.q.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {
    private static boolean ojm = false;
    private static long ojn = 10080;
    private static long ojo = 10;
    private static final AtomicBoolean ojp = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> ojq = new HashMap<>();
    public static HashMap<Integer, Long> ojr = new HashMap<>();

    public static synchronized void gr(Context context) {
        synchronized (a.class) {
            if (!ojp.get()) {
                SharedPreferences gs = gs(context);
                Iterator<Integer> it = b.ojs.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    ojr.put(Integer.valueOf(intValue), Long.valueOf(gs.getLong("cache_" + intValue, 10080L)));
                    ojq.put(Integer.valueOf(intValue), Boolean.valueOf(gs.getBoolean("close_" + intValue, false)));
                }
                ojr.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), Long.MAX_VALUE);
                ojq.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), true);
                ojp.set(true);
            }
        }
    }

    public static boolean eay() {
        return false;
    }

    public static boolean MT(int i) {
        if (ojq.containsKey(Integer.valueOf(i))) {
            return ojq.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long MU(int i) {
        if (ojr.containsKey(Integer.valueOf(i))) {
            return ojr.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences gs(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
