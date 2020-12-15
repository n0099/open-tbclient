package com.baidu.r.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes14.dex */
public class a {
    private static boolean oJe = false;
    private static long oJf = 10080;
    private static long oJg = 10;
    private static final AtomicBoolean oJh = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> oJi = new HashMap<>();
    public static HashMap<Integer, Long> oJj = new HashMap<>();

    public static synchronized void ha(Context context) {
        synchronized (a.class) {
            if (!oJh.get()) {
                SharedPreferences hb = hb(context);
                Iterator<Integer> it = b.oJk.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    oJj.put(Integer.valueOf(intValue), Long.valueOf(hb.getLong("cache_" + intValue, 10080L)));
                    oJi.put(Integer.valueOf(intValue), Boolean.valueOf(hb.getBoolean("close_" + intValue, false)));
                }
                oJj.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), Long.MAX_VALUE);
                oJi.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), true);
                oJh.set(true);
            }
        }
    }

    public static boolean ejR() {
        return false;
    }

    public static boolean ON(int i) {
        if (oJi.containsKey(Integer.valueOf(i))) {
            return oJi.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long OO(int i) {
        if (oJj.containsKey(Integer.valueOf(i))) {
            return oJj.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences hb(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
