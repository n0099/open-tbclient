package com.baidu.r.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes14.dex */
public class a {
    private static boolean oJc = false;
    private static long oJd = 10080;
    private static long oJe = 10;
    private static final AtomicBoolean oJf = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> oJg = new HashMap<>();
    public static HashMap<Integer, Long> oJh = new HashMap<>();

    public static synchronized void ha(Context context) {
        synchronized (a.class) {
            if (!oJf.get()) {
                SharedPreferences hb = hb(context);
                Iterator<Integer> it = b.oJi.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    oJh.put(Integer.valueOf(intValue), Long.valueOf(hb.getLong("cache_" + intValue, 10080L)));
                    oJg.put(Integer.valueOf(intValue), Boolean.valueOf(hb.getBoolean("close_" + intValue, false)));
                }
                oJh.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), Long.MAX_VALUE);
                oJg.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), true);
                oJf.set(true);
            }
        }
    }

    public static boolean ejQ() {
        return false;
    }

    public static boolean ON(int i) {
        if (oJg.containsKey(Integer.valueOf(i))) {
            return oJg.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long OO(int i) {
        if (oJh.containsKey(Integer.valueOf(i))) {
            return oJh.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences hb(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
