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
        b.uo().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return b.uo().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.uo().getBoolean(str, z);
    }

    public boolean loadBooleanFromCommon(String str, boolean z) {
        return b.uo().h(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        b.uo().putBoolean(str, z);
    }

    public void saveBooleanFromCommon(String str, boolean z) {
        b.uo().i(str, z);
    }

    public int loadInt(String str, int i) {
        return b.uo().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        b.uo().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return b.uo().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        b.uo().putLong(str, j);
    }
}
