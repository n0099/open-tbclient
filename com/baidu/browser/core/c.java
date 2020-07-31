package com.baidu.browser.core;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class c implements SharedPreferences {
    private a acd;
    private e ace;
    private String mName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.mName = str;
        this.ace = e.cV(this.mName);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.ace.getAll();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.ace.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.ace.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.ace.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.ace.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.ace.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.ace.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.ace.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.acd == null) {
            this.acd = new a();
        }
        return this.acd;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.ace.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.ace.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* loaded from: classes10.dex */
    private class a implements SharedPreferences.Editor {
        private a() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            c.this.ace.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            c.this.ace.putStringSet(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            c.this.ace.putInt(str, i);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            c.this.ace.putLong(str, j);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            c.this.ace.putFloat(str, f);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            c.this.ace.putBoolean(str, z);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            c.this.ace.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            c.this.ace.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return c.this.ace.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            c.this.ace.apply();
        }
    }
}
