package com.baidu.spswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes13.dex */
public class d {
    private static volatile SharedPreferences bak;

    public static boolean j(Context context, int i) {
        return bh(context).edit().putInt("sp.key.softinput.height", i).commit();
    }

    public static int k(Context context, int i) {
        return bh(context).getInt("sp.key.softinput.height", i);
    }

    private static SharedPreferences bh(Context context) {
        if (bak == null) {
            synchronized (d.class) {
                if (bak == null) {
                    bak = context.getSharedPreferences("baidu.softinput.common", 0);
                }
            }
        }
        return bak;
    }
}
