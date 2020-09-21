package com.baidu.swan.apps.storage.c;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class g implements com.baidu.swan.c.b {
    @NonNull
    private final com.baidu.swan.c.b dau;

    public g(String str, boolean z) {
        this.dau = com.baidu.swan.apps.t.a.aqt().e(com.baidu.swan.apps.t.a.apu(), str, z);
    }

    public g(String str) {
        this(str, true);
    }

    @Override // com.baidu.swan.c.b
    public long getContentSize() {
        return this.dau.getContentSize();
    }

    @Override // com.baidu.swan.c.b
    @NonNull
    public File getFile() {
        return this.dau.getFile();
    }

    @Override // com.baidu.swan.c.b
    public boolean aDN() {
        return this.dau.aDN();
    }

    @Override // com.baidu.swan.c.b
    public Set<String> aDO() {
        return this.dau.aDO();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.dau.getAll();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.dau.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.dau.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.dau.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.dau.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.dau.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.dau.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.dau.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.dau.edit();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.dau.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.dau.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.dau.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.dau.putStringSet(str, set);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.dau.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.dau.putLong(str, j);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        return this.dau.putFloat(str, f);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.dau.putBoolean(str, z);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.dau.remove(str);
    }

    public SharedPreferences.Editor clear() {
        return this.dau.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.dau.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.dau.apply();
    }
}
