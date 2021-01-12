package com.baidu.live.tbadk;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes10.dex */
public abstract class TbadkSettings {
    private static TbadkSettings mSettings = new TbadkSettings() { // from class: com.baidu.live.tbadk.TbadkSettings.1
    };
    protected SharedPreferences sp;

    private TbadkSettings() {
    }

    public static TbadkSettings getInst() {
        return mSettings;
    }

    protected void init(Context context) {
    }

    public void saveString(String str, String str2) {
        SharedPrefHelper.getInstance().putString(str, str2);
    }

    public String loadString(String str, String str2) {
        return SharedPrefHelper.getInstance().getString(str, str2);
    }

    public boolean loadBoolean(String str, boolean z) {
        return SharedPrefHelper.getInstance().getBoolean(str, z);
    }

    public void saveBoolean(String str, boolean z) {
        SharedPrefHelper.getInstance().putBoolean(str, z);
    }

    public int loadInt(String str, int i) {
        return SharedPrefHelper.getInstance().getInt(str, i);
    }

    public void saveInt(String str, int i) {
        SharedPrefHelper.getInstance().putInt(str, i);
    }

    public long loadLong(String str, long j) {
        return SharedPrefHelper.getInstance().getLong(str, j);
    }

    public void saveLong(String str, long j) {
        SharedPrefHelper.getInstance().putLong(str, j);
    }

    public boolean isContains(String str) {
        return SharedPrefHelper.getInstance().isContains(str);
    }
}
