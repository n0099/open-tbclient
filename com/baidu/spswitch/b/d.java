package com.baidu.spswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes11.dex */
public class d {
    private static volatile SharedPreferences aVe;

    public static boolean j(Context context, int i) {
        return bd(context).edit().putInt("sp.key.softinput.height", i).commit();
    }

    public static int k(Context context, int i) {
        return bd(context).getInt("sp.key.softinput.height", i);
    }

    private static SharedPreferences bd(Context context) {
        if (aVe == null) {
            synchronized (d.class) {
                if (aVe == null) {
                    aVe = context.getSharedPreferences("baidu.softinput.common", 0);
                }
            }
        }
        return aVe;
    }
}
