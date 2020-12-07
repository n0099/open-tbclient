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
        b.bsO().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return b.bsO().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.bsO().getBoolean(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        b.bsO().putBoolean(str, z);
    }

    public int loadInt(String str, int i) {
        return b.bsO().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        b.bsO().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return b.bsO().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        b.bsO().putLong(str, j);
    }

    public boolean isContains(String str) {
        return b.bsO().isContains(str);
    }
}
