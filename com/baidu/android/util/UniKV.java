package com.baidu.android.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class UniKV implements SharedPreferences {
    public static final boolean DEBUG = false;
    public static final String DEFAULT_SP_NAME = "default";
    public static final int MAX_STRING_LENGTH = 256;
    public SharedPreferences mInstance;

    public UniKV() {
        this.mInstance = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
    }

    private void verifyAllLength(String str, Set<String> set) {
        if (set != null) {
            for (String str2 : set) {
                verifyLength(str, str2);
            }
        }
    }

    private void verifyLength(String str, String str2) {
        if (str2 != null && str2.length() > 256 && DEBUG) {
            throw new IllegalArgumentException(String.format("the value of %s is %d, over the limit of %d!", str, Integer.valueOf(str2.length()), 256));
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        SharedPreferences sharedPreferences = this.mInstance;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        SharedPreferences sharedPreferences = this.mInstance;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.edit();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.mInstance;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = this.mInstance;
        return sharedPreferences == null ? z : sharedPreferences.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        SharedPreferences sharedPreferences = this.mInstance;
        return sharedPreferences == null ? f2 : sharedPreferences.getFloat(str, f2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        SharedPreferences sharedPreferences = this.mInstance;
        return sharedPreferences == null ? i2 : sharedPreferences.getInt(str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        SharedPreferences sharedPreferences = this.mInstance;
        return sharedPreferences == null ? j : sharedPreferences.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.mInstance;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = this.mInstance;
        return sharedPreferences == null ? set : sharedPreferences.getStringSet(str, set);
    }

    public void putBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = this.mInstance;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public void putFloat(String str, float f2) {
        SharedPreferences sharedPreferences = this.mInstance;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putFloat(str, f2).apply();
    }

    public void putInt(String str, int i2) {
        SharedPreferences sharedPreferences = this.mInstance;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putInt(str, i2).apply();
    }

    public void putLong(String str, long j) {
        SharedPreferences sharedPreferences = this.mInstance;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public void putString(String str, String str2) {
        if (this.mInstance == null) {
            return;
        }
        verifyLength(str, str2);
        this.mInstance.edit().putString(str, str2).apply();
    }

    public void putStringSet(String str, Set<String> set) {
        if (this.mInstance == null) {
            return;
        }
        verifyAllLength(str, set);
        this.mInstance.edit().putStringSet(str, set).apply();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferences = this.mInstance;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences = this.mInstance;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferences = this.mInstance;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public UniKV(String str) {
        this(str, 0);
    }

    public UniKV(String str, int i2) {
        if (!TextUtils.isEmpty(str) && !"default".equals(str)) {
            this.mInstance = KVStorageFactory.getSharedPreferences(str, i2);
        } else {
            this.mInstance = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        }
    }

    public UniKV(SharedPreferences sharedPreferences) {
        this.mInstance = sharedPreferences;
    }
}
