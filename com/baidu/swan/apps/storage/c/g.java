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
    private final com.baidu.swan.c.b cYp;

    public g(String str, boolean z) {
        this.cYp = com.baidu.swan.apps.t.a.apJ().e(com.baidu.swan.apps.t.a.aoJ(), str, z);
    }

    public g(String str) {
        this(str, true);
    }

    @Override // com.baidu.swan.c.b
    public long getContentSize() {
        return this.cYp.getContentSize();
    }

    @Override // com.baidu.swan.c.b
    @NonNull
    public File getFile() {
        return this.cYp.getFile();
    }

    @Override // com.baidu.swan.c.b
    public boolean aDd() {
        return this.cYp.aDd();
    }

    @Override // com.baidu.swan.c.b
    public Set<String> aDe() {
        return this.cYp.aDe();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.cYp.getAll();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.cYp.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.cYp.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.cYp.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.cYp.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.cYp.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.cYp.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.cYp.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.cYp.edit();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.cYp.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.cYp.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.cYp.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.cYp.putStringSet(str, set);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.cYp.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.cYp.putLong(str, j);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        return this.cYp.putFloat(str, f);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.cYp.putBoolean(str, z);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.cYp.remove(str);
    }

    public SharedPreferences.Editor clear() {
        return this.cYp.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.cYp.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.cYp.apply();
    }
}
