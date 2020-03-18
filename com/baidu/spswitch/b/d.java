package com.baidu.spswitch.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes13.dex */
public class d {
    private static volatile SharedPreferences bax;

    public static boolean j(Context context, int i) {
        return bg(context).edit().putInt("sp.key.softinput.height", i).commit();
    }

    public static int k(Context context, int i) {
        return bg(context).getInt("sp.key.softinput.height", i);
    }

    private static SharedPreferences bg(Context context) {
        if (bax == null) {
            synchronized (d.class) {
                if (bax == null) {
                    bax = context.getSharedPreferences("baidu.softinput.common", 0);
                }
            }
        }
        return bax;
    }
}
