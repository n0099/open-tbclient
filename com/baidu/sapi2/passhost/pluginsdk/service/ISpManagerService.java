package com.baidu.sapi2.passhost.pluginsdk.service;

import android.content.SharedPreferences;
/* loaded from: classes.dex */
public interface ISpManagerService {

    /* loaded from: classes.dex */
    public interface ISPer {
        boolean commit();

        boolean getBoolean(String str);

        boolean getBoolean(String str, boolean z);

        float getFloat(String str);

        float getFloat(String str, float f);

        int getInt(String str);

        int getInt(String str, int i);

        long getLong(String str);

        long getLong(String str, long j);

        SharedPreferences getPreferences();

        String getString(String str);

        String getString(String str, String str2);

        boolean putBoolean(String str, boolean z, boolean z2);

        boolean putFloat(String str, float f, boolean z);

        boolean putInt(String str, int i, boolean z);

        boolean putLong(String str, long j, boolean z);

        boolean putString(String str, String str2, boolean z);
    }

    ISPer getSPer(String str, int i);
}
