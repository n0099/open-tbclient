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
        b.bjf().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return b.bjf().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.bjf().getBoolean(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        b.bjf().putBoolean(str, z);
    }

    public int loadInt(String str, int i) {
        return b.bjf().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        b.bjf().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return b.bjf().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        b.bjf().putLong(str, j);
    }

    public boolean isContains(String str) {
        return b.bjf().isContains(str);
    }
}
