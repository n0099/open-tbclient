package com.baidu.ala;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
/* loaded from: classes.dex */
public class AlaSharedPrefHelper {
    public static AlaSharedPrefHelper mInstance;
    public SharedPreferences mSP;

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

    private synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(AlaSharedPrefConfig.ALA_SHARED_PRE_FILE_NAME, 0);
    }

    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        return sharedPreferences.getBoolean(str, z);
    }

    public float getFloat(String str, float f2) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        return sharedPreferences.getFloat(str, f2);
    }

    public int getInt(String str, int i) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        return sharedPreferences.getInt(str, i);
    }

    public long getLong(String str, long j) {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            return sharedPreferences.getLong(str, j);
        } catch (ClassCastException e2) {
            BdLog.e(e2);
            return j;
        }
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        return sharedPreferences.getString(str, str2);
    }

    public boolean isContains(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        return sharedPreferences.contains(str);
    }

    public void putBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        EditorHelper.putBoolean(sharedPreferences, str, z);
    }

    public void putFloat(String str, float f2) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        EditorHelper.putFloat(sharedPreferences, str, f2);
    }

    public void putInt(String str, int i) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        EditorHelper.putInt(sharedPreferences, str, i);
    }

    public void putLong(String str, long j) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        EditorHelper.putLong(sharedPreferences, str, j);
    }

    public void putString(String str, String str2) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        EditorHelper.putString(sharedPreferences, str, str2);
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        this.mSP = sharedPreferences;
        EditorHelper.remove(sharedPreferences, str);
    }
}
