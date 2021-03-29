package com.baidu.spswitch.utils;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class SoftInputSharedPreferences {
    public static final String FILE_NAME = "baidu.softinput.common";
    public static final String KEY_SOFITNPUT_HEIGHT = "sp.key.softinput.height";
    public static volatile SharedPreferences sSp;

    public static int get(Context context, int i) {
        return with(context).getInt(KEY_SOFITNPUT_HEIGHT, i);
    }

    public static boolean save(Context context, int i) {
        return with(context).edit().putInt(KEY_SOFITNPUT_HEIGHT, i).commit();
    }

    public static SharedPreferences with(Context context) {
        if (sSp == null) {
            synchronized (SoftInputSharedPreferences.class) {
                if (sSp == null) {
                    sSp = context.getSharedPreferences(FILE_NAME, 0);
                }
            }
        }
        return sSp;
    }
}
