package com.baidu.prologue.a.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public class c {
    private static String _ANDROID_ID = "";

    public static String aO(Context context) {
        if (TextUtils.isEmpty(_ANDROID_ID)) {
            try {
                _ANDROID_ID = Settings.System.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
                return "";
            }
        }
        return _ANDROID_ID;
    }
}
