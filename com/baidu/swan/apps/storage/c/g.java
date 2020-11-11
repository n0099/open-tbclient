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
    private final com.baidu.swan.c.b dAX;

    public g(String str, boolean z) {
        this.dAX = com.baidu.swan.apps.t.a.axz().e(com.baidu.swan.apps.t.a.awA(), str, z);
    }

    public g(String str) {
        this(str, true);
    }

    @Override // com.baidu.swan.c.b
    public long getContentSize() {
        return this.dAX.getContentSize();
    }

    @Override // com.baidu.swan.c.b
    @NonNull
    public File getFile() {
        return this.dAX.getFile();
    }

    @Override // com.baidu.swan.c.b
    public boolean aKQ() {
        return this.dAX.aKQ();
    }

    @Override // com.baidu.swan.c.b
    public Set<String> aKR() {
        return this.dAX.aKR();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public Map<String, ?> getAll() {
        return this.dAX.getAll();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.dAX.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.dAX.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.dAX.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.dAX.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.dAX.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.dAX.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.dAX.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.dAX.edit();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.dAX.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.dAX.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.dAX.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.dAX.putStringSet(str, set);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.dAX.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.dAX.putLong(str, j);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        return this.dAX.putFloat(str, f);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.dAX.putBoolean(str, z);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.dAX.remove(str);
    }

    public SharedPreferences.Editor clear() {
        return this.dAX.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.dAX.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.dAX.apply();
    }
}
