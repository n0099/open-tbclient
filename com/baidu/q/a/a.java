package com.baidu.q.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class a {
    private static boolean ngX = false;
    private static long ngY = 10080;
    private static long ngZ = 10;
    private static final AtomicBoolean nha = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> nhb = new HashMap<>();
    public static HashMap<Integer, Long> nhc = new HashMap<>();

    public static synchronized void gb(Context context) {
        synchronized (a.class) {
            if (!nha.get()) {
                SharedPreferences gc = gc(context);
                Iterator<Integer> it = b.nhd.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    nhc.put(Integer.valueOf(intValue), Long.valueOf(gc.getLong("cache_" + intValue, 10080L)));
                    nhb.put(Integer.valueOf(intValue), Boolean.valueOf(gc.getBoolean("close_" + intValue, false)));
                }
                nhc.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), Long.MAX_VALUE);
                nhb.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), true);
                nha.set(true);
            }
        }
    }

    public static boolean dMO() {
        return false;
    }

    public static boolean KG(int i) {
        if (nhb.containsKey(Integer.valueOf(i))) {
            return nhb.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long KH(int i) {
        if (nhc.containsKey(Integer.valueOf(i))) {
            return nhc.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences gc(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
