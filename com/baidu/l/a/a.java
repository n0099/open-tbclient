package com.baidu.l.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean mFZ = false;
    private static long mGa = 10080;
    private static long mGb = 10;
    private static final AtomicBoolean mGc = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> mGd = new HashMap<>();
    public static HashMap<Integer, Long> mGe = new HashMap<>();

    public static synchronized void fL(Context context) {
        synchronized (a.class) {
            if (!mGc.get()) {
                SharedPreferences fM = fM(context);
                Iterator<Integer> it = b.mGf.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    mGe.put(Integer.valueOf(intValue), Long.valueOf(fM.getLong("cache_" + intValue, 10080L)));
                    mGd.put(Integer.valueOf(intValue), Boolean.valueOf(fM.getBoolean("close_" + intValue, false)));
                }
                mGe.put(20001, Long.MAX_VALUE);
                mGd.put(20001, true);
                mGc.set(true);
            }
        }
    }

    public static boolean dxN() {
        return false;
    }

    public static boolean HL(int i) {
        if (mGd.containsKey(Integer.valueOf(i))) {
            return mGd.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long HM(int i) {
        if (mGe.containsKey(Integer.valueOf(i))) {
            return mGe.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences fM(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
