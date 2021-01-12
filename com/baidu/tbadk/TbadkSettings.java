package com.baidu.tbadk;

import android.content.SharedPreferences;
import com.baidu.tbadk.core.sharedPref.b;
/* loaded from: classes.dex */
public class TbadkSettings {
    private static TbadkSettings mSettings = new TbadkSettings();
    protected SharedPreferences sp;

    private TbadkSettings() {
    }

    public static TbadkSettings getInst() {
        return mSettings;
    }

    public void saveString(String str, String str2) {
        b.brx().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return b.brx().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.brx().getBoolean(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        b.brx().putBoolean(str, z);
    }

    public int loadInt(String str, int i) {
        return b.brx().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        b.brx().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return b.brx().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        b.brx().putLong(str, j);
    }

    public boolean isContains(String str) {
        return b.brx().isContains(str);
    }
}
