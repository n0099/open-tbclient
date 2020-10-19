package com.baidu.swan.apps.storage.c;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class g implements com.baidu.swan.c.b {
    @NonNull
    private final com.baidu.swan.c.b dmD;

    public g(String str, boolean z) {
        this.dmD = com.baidu.swan.apps.t.a.atf().e(com.baidu.swan.apps.t.a.asf(), str, z);
    }

    public g(String str) {
        this(str, true);
    }

    @Override // com.baidu.swan.c.b
    public long getContentSize() {
        return this.dmD.getContentSize();
    }

    @Override // com.baidu.swan.c.b
    @NonNull
    public File getFile() {
        return this.dmD.getFile();
    }

    @Override // com.baidu.swan.c.b
    public boolean aGw() {
        return this.dmD.aGw();
    }

    @Override // com.baidu.swan.c.b
    public Set<String> aGx() {
        return this.dmD.aGx();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.dmD.getAll();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.dmD.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.dmD.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.dmD.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.dmD.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.dmD.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.dmD.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.dmD.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.dmD.edit();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.dmD.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.dmD.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.dmD.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.dmD.putStringSet(str, set);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.dmD.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.dmD.putLong(str, j);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        return this.dmD.putFloat(str, f);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.dmD.putBoolean(str, z);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.dmD.remove(str);
    }

    public SharedPreferences.Editor clear() {
        return this.dmD.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.dmD.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.dmD.apply();
    }
}
