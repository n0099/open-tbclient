package com.baidu.spswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes13.dex */
public class d {
    private static volatile SharedPreferences baj;

    public static boolean j(Context context, int i) {
        return bh(context).edit().putInt("sp.key.softinput.height", i).commit();
    }

    public static int k(Context context, int i) {
        return bh(context).getInt("sp.key.softinput.height", i);
    }

    private static SharedPreferences bh(Context context) {
        if (baj == null) {
            synchronized (d.class) {
                if (baj == null) {
                    baj = context.getSharedPreferences("baidu.softinput.common", 0);
                }
            }
        }
        return baj;
    }
}
