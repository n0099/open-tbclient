package com.baidu.prologue.a.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class c {
    private static String _ANDROID_ID = "";

    public static String aI(Context context) {
        if (TextUtils.isEmpty(_ANDROID_ID)) {
            try {
                _ANDROID_ID = Settings.System.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
            }
        }
        return _ANDROID_ID;
    }
}
