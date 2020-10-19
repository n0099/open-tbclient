package com.baidu.q.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {
    private static boolean nGK = false;
    private static long nGL = 10080;
    private static long nGM = 10;
    private static final AtomicBoolean nGN = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> nGO = new HashMap<>();
    public static HashMap<Integer, Long> nGP = new HashMap<>();

    public static synchronized void gp(Context context) {
        synchronized (a.class) {
            if (!nGN.get()) {
                SharedPreferences gq = gq(context);
                Iterator<Integer> it = b.nGQ.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    nGP.put(Integer.valueOf(intValue), Long.valueOf(gq.getLong("cache_" + intValue, 10080L)));
                    nGO.put(Integer.valueOf(intValue), Boolean.valueOf(gq.getBoolean("close_" + intValue, false)));
                }
                nGP.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), Long.MAX_VALUE);
                nGO.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), true);
                nGN.set(true);
            }
        }
    }

    public static boolean dUG() {
        return false;
    }

    public static boolean LR(int i) {
        if (nGO.containsKey(Integer.valueOf(i))) {
            return nGO.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long LS(int i) {
        if (nGP.containsKey(Integer.valueOf(i))) {
            return nGP.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences gq(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
