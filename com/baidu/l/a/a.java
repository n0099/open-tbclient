package com.baidu.l.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean mka = false;
    private static long mkb = 10080;
    private static long mkc = 10;
    private static final AtomicBoolean mkd = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> mke = new HashMap<>();
    public static HashMap<Integer, Long> mkf = new HashMap<>();

    public static synchronized void fK(Context context) {
        synchronized (a.class) {
            if (!mkd.get()) {
                SharedPreferences fL = fL(context);
                Iterator<Integer> it = b.mkg.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    mkf.put(Integer.valueOf(intValue), Long.valueOf(fL.getLong("cache_" + intValue, 10080L)));
                    mke.put(Integer.valueOf(intValue), Boolean.valueOf(fL.getBoolean("close_" + intValue, false)));
                }
                mkf.put(20001, Long.MAX_VALUE);
                mke.put(20001, true);
                mkd.set(true);
            }
        }
    }

    public static boolean dtg() {
        return false;
    }

    public static boolean GE(int i) {
        if (mke.containsKey(Integer.valueOf(i))) {
            return mke.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long GF(int i) {
        if (mkf.containsKey(Integer.valueOf(i))) {
            return mkf.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences fL(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
