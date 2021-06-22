package com.baidu.pass.face.platform.common;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public final class SharedPrefHelper {
    public static final String SHARED_PREFERENCES_NAME_FACE_VALUE = "face_sdk_value";

    public static SharedPreferences getPref(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME_FACE_VALUE, 0);
    }
}
