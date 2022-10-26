package com.baidu.nps.interfa;

import java.util.Set;
/* loaded from: classes2.dex */
public interface ISharePrefsWrapper {
    public static final String NPS_FRAME_PATCH_FAIL_COUNT = "nps_frame_patch_fail_count";

    boolean getBoolean(String str, boolean z);

    float getFloat(String str, float f);

    int getInt(String str, int i);

    long getLong(String str, long j);

    String getString(String str, String str2);

    Set getStringSet(String str, Set set);

    void putBoolean(String str, boolean z);

    void putFloat(String str, float f);

    void putInt(String str, int i);

    void putLong(String str, long j);

    void putString(String str, String str2);

    void putStringSet(String str, Set set);

    void remove(String str);
}
