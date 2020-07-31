package com.baidu.ala;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
/* loaded from: classes4.dex */
public class AlaSharedPrefHelper {
    private static AlaSharedPrefHelper mInstance;
    private SharedPreferences mSP;

    private synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(AlaSharedPrefConfig.ALA_SHARED_PRE_FILE_NAME, 0);
    }

    public static AlaSharedPrefHelper getInstance() {
        if (mInstance == null) {
            synchronized (AlaSharedPrefHelper.class) {
                if (mInstance == null) {
                    mInstance = new AlaSharedPrefHelper();
                }
            }
        }
        return mInstance;
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
        try {
            this.mSP = getSharedPreferences();
            return this.mSP.getLong(str, j);
        } catch (ClassCastException e) {
            BdLog.e(e);
            return j;
        }
    }

    public String getString(String str, String str2) {
        this.mSP = getSharedPreferences();
        return this.mSP.getString(str, str2);
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

    public void remove(String str) {
        this.mSP = getSharedPreferences();
        EditorHelper.remove(this.mSP, str);
    }
}
