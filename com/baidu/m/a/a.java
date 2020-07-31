package com.baidu.m.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.sapi2.share.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class a {
    private static boolean mOd = false;
    private static long mOe = 10080;
    private static long mOf = 10;
    private static final AtomicBoolean mOg = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> mOh = new HashMap<>();
    public static HashMap<Integer, Long> mOi = new HashMap<>();

    public static synchronized void fO(Context context) {
        synchronized (a.class) {
            if (!mOg.get()) {
                SharedPreferences fP = fP(context);
                Iterator<Integer> it = b.mOj.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    mOi.put(Integer.valueOf(intValue), Long.valueOf(fP.getLong("cache_" + intValue, 10080L)));
                    mOh.put(Integer.valueOf(intValue), Boolean.valueOf(fP.getBoolean("close_" + intValue, false)));
                }
                mOi.put(Integer.valueOf((int) m.g), Long.MAX_VALUE);
                mOh.put(Integer.valueOf((int) m.g), true);
                mOg.set(true);
            }
        }
    }

    public static boolean dAZ() {
        return false;
    }

    public static boolean Ig(int i) {
        if (mOh.containsKey(Integer.valueOf(i))) {
            return mOh.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Ih(int i) {
        if (mOi.containsKey(Integer.valueOf(i))) {
            return mOi.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences fP(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
