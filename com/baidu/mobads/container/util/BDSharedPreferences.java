package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes2.dex */
public class BDSharedPreferences {
    public static final String KEY_PREFIX_LOCAL_PATH = "localPath_";
    public static final String KEY_PREFIX_TIME = "time_";
    public SharedPreferences mSharedPreferences;

    public BDSharedPreferences(Context context, String str, int i2) {
        this.mSharedPreferences = context.getApplicationContext().getSharedPreferences(str, i2);
    }

    public boolean contains(String str) {
        return this.mSharedPreferences.contains(str);
    }

    public String getLocalPath(String str) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences.getString(KEY_PREFIX_LOCAL_PATH + str, null);
    }

    public long getLong(String str, long j) {
        return this.mSharedPreferences.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return this.mSharedPreferences.getString(str, str2);
    }

    public void putLong(String str, long j) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putLong(str, j);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public void putString(String str, String str2) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(str, str2);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public void saveFileInfo(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(KEY_PREFIX_LOCAL_PATH + str, str2);
        edit.putLong(KEY_PREFIX_TIME + str, j);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }
}
