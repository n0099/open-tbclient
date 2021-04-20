package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Set;
/* loaded from: classes2.dex */
public class SPUtils {
    public static final String DEFAULT_SP_NAME = "bd_sp_file";
    public SharedPreferences.Editor editor;
    public SharedPreferences mSharedPreferences;

    public SPUtils(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(DEFAULT_SP_NAME, 0);
        this.mSharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    private void submit() {
        if (Build.VERSION.SDK_INT >= 9) {
            this.editor.apply();
        } else {
            this.editor.commit();
        }
    }

    public void clear() {
        this.editor.clear();
        if (Build.VERSION.SDK_INT >= 9) {
            this.editor.apply();
        } else {
            this.editor.commit();
        }
    }

    public boolean contains(String str) {
        return this.mSharedPreferences.contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.mSharedPreferences.getBoolean(str, z);
    }

    public float getFloat(String str, float f2) {
        return this.mSharedPreferences.getFloat(str, f2);
    }

    public int getInt(String str, int i) {
        return this.mSharedPreferences.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return this.mSharedPreferences.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return this.mSharedPreferences.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return this.mSharedPreferences.getStringSet(str, set);
    }

    public void putBoolean(String str, boolean z) {
        this.editor.putBoolean(str, z);
        submit();
    }

    public void putFloat(String str, float f2) {
        this.editor.putFloat(str, Float.valueOf(f2).floatValue());
        submit();
    }

    public void putInt(String str, int i) {
        this.editor.putInt(str, i);
        submit();
    }

    public void putLong(String str, long j) {
        this.editor.putLong(str, Long.valueOf(j).longValue());
        submit();
    }

    public void putString(String str, String str2) {
        this.editor.putString(str, str2);
        submit();
    }

    public void putStringSet(String str, Set<String> set) {
        this.editor.putStringSet(str, set);
        submit();
    }

    public void remove(String str) {
        SharedPreferences.Editor editor = this.editor;
        if (editor != null) {
            editor.remove(str);
        }
    }

    public SPUtils(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0);
        this.mSharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }
}
