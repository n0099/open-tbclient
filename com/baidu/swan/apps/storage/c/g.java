package com.baidu.swan.apps.storage.c;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class g implements com.baidu.swan.c.b {
    @NonNull
    private final com.baidu.swan.c.b cYt;

    public g(String str, boolean z) {
        this.cYt = com.baidu.swan.apps.t.a.apJ().e(com.baidu.swan.apps.t.a.aoJ(), str, z);
    }

    public g(String str) {
        this(str, true);
    }

    @Override // com.baidu.swan.c.b
    public long getContentSize() {
        return this.cYt.getContentSize();
    }

    @Override // com.baidu.swan.c.b
    @NonNull
    public File getFile() {
        return this.cYt.getFile();
    }

    @Override // com.baidu.swan.c.b
    public boolean aDd() {
        return this.cYt.aDd();
    }

    @Override // com.baidu.swan.c.b
    public Set<String> aDe() {
        return this.cYt.aDe();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.cYt.getAll();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.cYt.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.cYt.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.cYt.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.cYt.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.cYt.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.cYt.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.cYt.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.cYt.edit();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.cYt.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.cYt.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.cYt.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.cYt.putStringSet(str, set);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.cYt.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.cYt.putLong(str, j);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        return this.cYt.putFloat(str, f);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.cYt.putBoolean(str, z);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.cYt.remove(str);
    }

    public SharedPreferences.Editor clear() {
        return this.cYt.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.cYt.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.cYt.apply();
    }
}
