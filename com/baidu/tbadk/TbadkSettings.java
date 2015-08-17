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
        b.ts().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return b.ts().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.ts().getBoolean(str, z);
    }

    public boolean loadBooleanFromCommon(String str, boolean z) {
        return b.ts().g(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        b.ts().putBoolean(str, z);
    }

    public void saveBooleanFromCommon(String str, boolean z) {
        b.ts().h(str, z);
    }

    public int loadInt(String str, int i) {
        return b.ts().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        b.ts().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return b.ts().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        b.ts().putLong(str, j);
    }
}
