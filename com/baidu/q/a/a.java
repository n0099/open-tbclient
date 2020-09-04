package com.baidu.q.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class a {
    private static boolean nhp = false;
    private static long nhq = 10080;
    private static long nhr = 10;
    private static final AtomicBoolean nhs = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> nht = new HashMap<>();
    public static HashMap<Integer, Long> nhu = new HashMap<>();

    public static synchronized void gb(Context context) {
        synchronized (a.class) {
            if (!nhs.get()) {
                SharedPreferences gc = gc(context);
                Iterator<Integer> it = b.nhv.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    nhu.put(Integer.valueOf(intValue), Long.valueOf(gc.getLong("cache_" + intValue, 10080L)));
                    nht.put(Integer.valueOf(intValue), Boolean.valueOf(gc.getBoolean("close_" + intValue, false)));
                }
                nhu.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), Long.MAX_VALUE);
                nht.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), true);
                nhs.set(true);
            }
        }
    }

    public static boolean dMX() {
        return false;
    }

    public static boolean KG(int i) {
        if (nht.containsKey(Integer.valueOf(i))) {
            return nht.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long KH(int i) {
        if (nhu.containsKey(Integer.valueOf(i))) {
            return nhu.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences gc(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
