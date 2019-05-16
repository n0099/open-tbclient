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
        b.agM().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return b.agM().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.agM().getBoolean(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        b.agM().putBoolean(str, z);
    }

    public int loadInt(String str, int i) {
        return b.agM().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        b.agM().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return b.agM().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        b.agM().putLong(str, j);
    }

    public boolean isContains(String str) {
        return b.agM().isContains(str);
    }
}
