package com.baidu.q.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a {
    private static boolean otV = false;
    private static long otW = 10080;
    private static long otX = 10;
    private static final AtomicBoolean otY = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> otZ = new HashMap<>();
    public static HashMap<Integer, Long> oua = new HashMap<>();

    public static synchronized void gq(Context context) {
        synchronized (a.class) {
            if (!otY.get()) {
                SharedPreferences gr = gr(context);
                Iterator<Integer> it = b.oub.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    oua.put(Integer.valueOf(intValue), Long.valueOf(gr.getLong("cache_" + intValue, 10080L)));
                    otZ.put(Integer.valueOf(intValue), Boolean.valueOf(gr.getBoolean("close_" + intValue, false)));
                }
                oua.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), Long.MAX_VALUE);
                otZ.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), true);
                otY.set(true);
            }
        }
    }

    public static boolean eed() {
        return false;
    }

    public static boolean NP(int i) {
        if (otZ.containsKey(Integer.valueOf(i))) {
            return otZ.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long NQ(int i) {
        if (oua.containsKey(Integer.valueOf(i))) {
            return oua.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences gr(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
