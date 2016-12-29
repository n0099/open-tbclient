package com.baidu.tbadk;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.tbadk.core.sharedPref.b;
/* loaded from: classes.dex */
public abstract class TbadkSettings {
    private static TbadkSettings mSettings = new TbadkSettings() { // from class: com.baidu.tbadk.TbadkSettings.1
    };
    protected SharedPreferences sp;

    private TbadkSettings() {
    }

    /* synthetic */ TbadkSettings(TbadkSettings tbadkSettings) {
        this();
    }

    public static TbadkSettings getInst() {
        return mSettings;
    }

    protected void init(Context context) {
    }

    public void saveString(String str, String str2) {
        b.tW().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return b.tW().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.tW().getBoolean(str, z);
    }

    public boolean loadBooleanFromCommon(String str, boolean z) {
        return b.tW().h(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        b.tW().putBoolean(str, z);
    }

    public void saveBooleanFromCommon(String str, boolean z) {
        b.tW().i(str, z);
    }

    public int loadInt(String str, int i) {
        return b.tW().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        b.tW().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return b.tW().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        b.tW().putLong(str, j);
    }
}
