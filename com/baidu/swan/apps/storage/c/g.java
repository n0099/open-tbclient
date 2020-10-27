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
    private final com.baidu.swan.c.b dvf;

    public g(String str, boolean z) {
        this.dvf = com.baidu.swan.apps.t.a.auZ().e(com.baidu.swan.apps.t.a.aua(), str, z);
    }

    public g(String str) {
        this(str, true);
    }

    @Override // com.baidu.swan.c.b
    public long getContentSize() {
        return this.dvf.getContentSize();
    }

    @Override // com.baidu.swan.c.b
    @NonNull
    public File getFile() {
        return this.dvf.getFile();
    }

    @Override // com.baidu.swan.c.b
    public boolean aIq() {
        return this.dvf.aIq();
    }

    @Override // com.baidu.swan.c.b
    public Set<String> aIr() {
        return this.dvf.aIr();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.dvf.getAll();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.dvf.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.dvf.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.dvf.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.dvf.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.dvf.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.dvf.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.dvf.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.dvf.edit();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.dvf.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.dvf.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.dvf.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.dvf.putStringSet(str, set);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.dvf.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.dvf.putLong(str, j);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        return this.dvf.putFloat(str, f);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.dvf.putBoolean(str, z);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.dvf.remove(str);
    }

    public SharedPreferences.Editor clear() {
        return this.dvf.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.dvf.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.dvf.apply();
    }
}
