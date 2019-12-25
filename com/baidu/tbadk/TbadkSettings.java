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
        b.aCY().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return b.aCY().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.aCY().getBoolean(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        b.aCY().putBoolean(str, z);
    }

    public int loadInt(String str, int i) {
        return b.aCY().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        b.aCY().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return b.aCY().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        b.aCY().putLong(str, j);
    }

    public boolean isContains(String str) {
        return b.aCY().isContains(str);
    }
}
