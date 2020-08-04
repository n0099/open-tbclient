package com.baidu.m.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.sapi2.share.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class a {
    private static boolean mOf = false;
    private static long mOg = 10080;
    private static long mOh = 10;
    private static final AtomicBoolean mOi = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> mOj = new HashMap<>();
    public static HashMap<Integer, Long> mOk = new HashMap<>();

    public static synchronized void fO(Context context) {
        synchronized (a.class) {
            if (!mOi.get()) {
                SharedPreferences fP = fP(context);
                Iterator<Integer> it = b.mOl.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    mOk.put(Integer.valueOf(intValue), Long.valueOf(fP.getLong("cache_" + intValue, 10080L)));
                    mOj.put(Integer.valueOf(intValue), Boolean.valueOf(fP.getBoolean("close_" + intValue, false)));
                }
                mOk.put(Integer.valueOf((int) m.g), Long.MAX_VALUE);
                mOj.put(Integer.valueOf((int) m.g), true);
                mOi.set(true);
            }
        }
    }

    public static boolean dBa() {
        return false;
    }

    public static boolean Ig(int i) {
        if (mOj.containsKey(Integer.valueOf(i))) {
            return mOj.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long Ih(int i) {
        if (mOk.containsKey(Integer.valueOf(i))) {
            return mOk.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences fP(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
