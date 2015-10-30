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
        b.tr().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return b.tr().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return b.tr().getBoolean(str, z);
    }

    public boolean loadBooleanFromCommon(String str, boolean z) {
        return b.tr().g(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        b.tr().putBoolean(str, z);
    }

    public void saveBooleanFromCommon(String str, boolean z) {
        b.tr().h(str, z);
    }

    public int loadInt(String str, int i) {
        return b.tr().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        b.tr().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return b.tr().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        b.tr().putLong(str, j);
    }
}
