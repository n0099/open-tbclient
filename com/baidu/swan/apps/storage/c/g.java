package com.baidu.swan.apps.storage.c;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes25.dex */
public class g implements com.baidu.swan.c.b {
    @NonNull
    private final com.baidu.swan.c.b dGp;

    public g(String str, boolean z) {
        this.dGp = com.baidu.swan.apps.t.a.azZ().f(com.baidu.swan.apps.t.a.aza(), str, z);
    }

    public g(String str) {
        this(str, true);
    }

    @Override // com.baidu.swan.c.b
    public long getContentSize() {
        return this.dGp.getContentSize();
    }

    @Override // com.baidu.swan.c.b
    @NonNull
    public File getFile() {
        return this.dGp.getFile();
    }

    @Override // com.baidu.swan.c.b
    public boolean aNp() {
        return this.dGp.aNp();
    }

    @Override // com.baidu.swan.c.b
    public Set<String> aNq() {
        return this.dGp.aNq();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.dGp.getAll();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.dGp.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.dGp.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.dGp.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.dGp.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.dGp.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.dGp.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.dGp.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.dGp.edit();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.dGp.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.dGp.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.dGp.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.dGp.putStringSet(str, set);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.dGp.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.dGp.putLong(str, j);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        return this.dGp.putFloat(str, f);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.dGp.putBoolean(str, z);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.dGp.remove(str);
    }

    public SharedPreferences.Editor clear() {
        return this.dGp.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.dGp.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.dGp.apply();
    }
}
