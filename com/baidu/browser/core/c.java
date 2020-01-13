package com.baidu.browser.core;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class c implements SharedPreferences {
    private a HH;
    private e HI;
    private String mName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.mName = str;
        this.HI = e.bE(this.mName);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.HI.getAll();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.HI.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.HI.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.HI.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.HI.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.HI.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.HI.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.HI.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.HH == null) {
            this.HH = new a();
        }
        return this.HH;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.HI.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.HI.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* loaded from: classes10.dex */
    private class a implements SharedPreferences.Editor {
        private a() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            c.this.HI.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            c.this.HI.putStringSet(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            c.this.HI.putInt(str, i);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            c.this.HI.putLong(str, j);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            c.this.HI.putFloat(str, f);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            c.this.HI.putBoolean(str, z);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            c.this.HI.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            c.this.HI.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return c.this.HI.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            c.this.HI.apply();
        }
    }
}
