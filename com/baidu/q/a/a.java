package com.baidu.q.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes25.dex */
public class a {
    private static boolean nrq = false;
    private static long nrr = 10080;
    private static long nrs = 10;
    private static final AtomicBoolean nrt = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> nru = new HashMap<>();
    public static HashMap<Integer, Long> nrv = new HashMap<>();

    public static synchronized void gi(Context context) {
        synchronized (a.class) {
            if (!nrt.get()) {
                SharedPreferences gj = gj(context);
                Iterator<Integer> it = b.nrw.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    nrv.put(Integer.valueOf(intValue), Long.valueOf(gj.getLong("cache_" + intValue, 10080L)));
                    nru.put(Integer.valueOf(intValue), Boolean.valueOf(gj.getBoolean("close_" + intValue, false)));
                }
                nrv.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), Long.MAX_VALUE);
                nru.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), true);
                nrt.set(true);
            }
        }
    }

    public static boolean dQV() {
        return false;
    }

    public static boolean Ll(int i) {
        if (nru.containsKey(Integer.valueOf(i))) {
            return nru.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Lm(int i) {
        if (nrv.containsKey(Integer.valueOf(i))) {
            return nrv.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences gj(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
