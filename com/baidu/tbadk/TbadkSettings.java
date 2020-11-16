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
        b.bpu().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return b.bpu().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.bpu().getBoolean(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        b.bpu().putBoolean(str, z);
    }

    public int loadInt(String str, int i) {
        return b.bpu().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        b.bpu().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return b.bpu().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        b.bpu().putLong(str, j);
    }

    public boolean isContains(String str) {
        return b.bpu().isContains(str);
    }
}
