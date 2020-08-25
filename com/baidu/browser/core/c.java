package com.baidu.browser.core;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.Set;
/* loaded from: classes19.dex */
public class c implements SharedPreferences {
    private a adL;
    private e adM;
    private String mName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.mName = str;
        this.adM = e.df(this.mName);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.adM.getAll();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.adM.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.adM.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.adM.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.adM.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.adM.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.adM.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.adM.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.adL == null) {
            this.adL = new a();
        }
        return this.adL;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.adM.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.adM.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* loaded from: classes19.dex */
    private class a implements SharedPreferences.Editor {
        private a() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            c.this.adM.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            c.this.adM.putStringSet(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            c.this.adM.putInt(str, i);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            c.this.adM.putLong(str, j);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            c.this.adM.putFloat(str, f);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            c.this.adM.putBoolean(str, z);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            c.this.adM.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            c.this.adM.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return c.this.adM.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            c.this.adM.apply();
        }
    }
}
