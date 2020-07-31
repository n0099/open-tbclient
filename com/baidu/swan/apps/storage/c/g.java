package com.baidu.swan.apps.storage.c;

import android.annotation.Nullable;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import java.io.File;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public class g implements com.baidu.swan.d.b {
    private final /* synthetic */ com.baidu.swan.d.b cPm;

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.cPm.apply();
    }

    @Override // com.baidu.swan.d.b
    public Set<String> auU() {
        return this.cPm.auU();
    }

    @Override // com.baidu.swan.d.b
    public boolean auV() {
        return this.cPm.auV();
    }

    public SharedPreferences.Editor clear() {
        return this.cPm.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.cPm.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.cPm.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.cPm.edit();
    }

    @Override // com.baidu.swan.d.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.cPm.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.cPm.getBoolean(str, z);
    }

    @Override // com.baidu.swan.d.b
    public long getContentSize() {
        return this.cPm.getContentSize();
    }

    @Override // com.baidu.swan.d.b
    @NonNull
    public File getFile() {
        return this.cPm.getFile();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.cPm.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.cPm.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.cPm.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.cPm.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.cPm.getStringSet(str, set);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.cPm.putBoolean(str, z);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        return this.cPm.putFloat(str, f);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.cPm.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.cPm.putLong(str, j);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.cPm.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.cPm.putStringSet(str, set);
    }

    @Override // com.baidu.swan.d.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.cPm.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.cPm.remove(str);
    }

    @Override // com.baidu.swan.d.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.cPm.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public g(String str, boolean z) {
        q.m(str, "fileName");
        com.baidu.swan.d.b e = com.baidu.swan.apps.t.a.aih().e(com.baidu.swan.apps.t.a.ahj(), str, z);
        q.l((Object) e, "SwanAppRuntime.getSwanEx…Name, isMultiProcessMode)");
        this.cPm = e;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(String str) {
        this(str, true);
        q.m(str, "fileName");
    }
}
