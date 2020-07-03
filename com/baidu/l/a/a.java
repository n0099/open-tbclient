package com.baidu.l.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    private static boolean mFW = false;
    private static long mFX = 10080;
    private static long mFY = 10;
    private static final AtomicBoolean mFZ = new AtomicBoolean(false);
    private static HashMap<Integer, Boolean> mGa = new HashMap<>();
    public static HashMap<Integer, Long> mGb = new HashMap<>();

    public static synchronized void fL(Context context) {
        synchronized (a.class) {
            if (!mFZ.get()) {
                SharedPreferences fM = fM(context);
                Iterator<Integer> it = b.mGc.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    mGb.put(Integer.valueOf(intValue), Long.valueOf(fM.getLong("cache_" + intValue, 10080L)));
                    mGa.put(Integer.valueOf(intValue), Boolean.valueOf(fM.getBoolean("close_" + intValue, false)));
                }
                mGb.put(20001, Long.MAX_VALUE);
                mGa.put(20001, true);
                mFZ.set(true);
            }
        }
    }

    public static boolean dxJ() {
        return false;
    }

    public static boolean HL(int i) {
        if (mGa.containsKey(Integer.valueOf(i))) {
            return mGa.get(Integer.valueOf(i)).booleanValue();
        }
        return true;
    }

    public static long HM(int i) {
        if (mGb.containsKey(Integer.valueOf(i))) {
            return mGb.get(Integer.valueOf(i)).longValue();
        }
        return Long.MAX_VALUE;
    }

    private static SharedPreferences fM(Context context) {
        return context.getSharedPreferences("CONFIG_RUNTIME", 0);
    }
}
