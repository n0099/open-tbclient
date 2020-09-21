package com.baidu.live.tbadk.core.sharedpref;

import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.Set;
/* loaded from: classes4.dex */
public class SharedPrefHelper {
    private static SharedPrefHelper spHelper = null;
    private SharedPreferences mSP = null;
    private String mFile = null;

    public static synchronized SharedPrefHelper getInstance() {
        SharedPrefHelper sharedPrefHelper;
        synchronized (SharedPrefHelper.class) {
            if (spHelper == null) {
                spHelper = new SharedPrefHelper();
            }
            sharedPrefHelper = spHelper;
        }
        return sharedPrefHelper;
    }

    public boolean isContains(String str) {
        this.mSP = getSharedPreferences();
        return this.mSP.contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        this.mSP = getSharedPreferences();
        return this.mSP.getBoolean(str, z);
    }

    public float getFloat(String str, float f) {
        this.mSP = getSharedPreferences();
        return this.mSP.getFloat(str, f);
    }

    public int getInt(String str, int i) {
        this.mSP = getSharedPreferences();
        return this.mSP.getInt(str, i);
    }

    public long getLong(String str, long j) {
        this.mSP = getSharedPreferences();
        return this.mSP.getLong(str, j);
    }

    public String getString(String str, String str2) {
        this.mSP = getSharedPreferences();
        return this.mSP.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        this.mSP = getSharedPreferences();
        return this.mSP.getStringSet(str, set);
    }

    public void putBoolean(String str, boolean z) {
        this.mSP = getSharedPreferences();
        EditorHelper.putBoolean(this.mSP, str, z);
    }

    public void putString(String str, String str2) {
        this.mSP = getSharedPreferences();
        EditorHelper.putString(this.mSP, str, str2);
    }

    public void putFloat(String str, float f) {
        this.mSP = getSharedPreferences();
        EditorHelper.putFloat(this.mSP, str, f);
    }

    public void putInt(String str, int i) {
        this.mSP = getSharedPreferences();
        EditorHelper.putInt(this.mSP, str, i);
    }

    public void putLong(String str, long j) {
        this.mSP = getSharedPreferences();
        EditorHelper.putLong(this.mSP, str, j);
    }

    public void putStringSet(String str, Set<String> set) {
        this.mSP = getSharedPreferences();
        SharedPreferences.Editor edit = this.mSP.edit();
        edit.putStringSet(str, set);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public void remove(String str) {
        this.mSP = getSharedPreferences();
        EditorHelper.remove(this.mSP, str);
    }

    protected synchronized SharedPreferences getSharedPreferences() {
        if (this.mFile == null || this.mFile.length() == 0) {
            this.mFile = SharedPrefConfig.MAIN_SETTINGS_NAME;
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.mFile, 0);
    }

    public static String getSharedPrefKeyWithAccount(String str) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbadkCoreApplication.getCurrentAccount();
    }
}
