package com.baidu.q.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {
    private static boolean oss = false;
    private static long ost = 10080;
    private static long osu = 10;
    private static final AtomicBoolean osv = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> osw = new HashMap<>();
    public static HashMap<Integer, Long> osx = new HashMap<>();

    public static synchronized void gr(Context context) {
        synchronized (a.class) {
            if (!osv.get()) {
                SharedPreferences gs = gs(context);
                Iterator<Integer> it = b.osy.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    osx.put(Integer.valueOf(intValue), Long.valueOf(gs.getLong("cache_" + intValue, 10080L)));
                    osw.put(Integer.valueOf(intValue), Boolean.valueOf(gs.getBoolean("close_" + intValue, false)));
                }
                osx.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), Long.MAX_VALUE);
                osw.put(Integer.valueOf((int) com.baidu.sapi2.share.b.h), true);
                osv.set(true);
            }
        }
    }

    public static boolean eeg() {
        return false;
    }

    public static boolean Nm(int i) {
        if (osw.containsKey(Integer.valueOf(i))) {
            return osw.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Nn(int i) {
        if (osx.containsKey(Integer.valueOf(i))) {
            return osx.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences gs(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
