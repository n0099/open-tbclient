package com.baidu.swan.apps.storage.c;

import android.annotation.Nullable;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import java.io.File;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public class g implements com.baidu.swan.e.b {
    private final /* synthetic */ com.baidu.swan.e.b cHh;

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.cHh.apply();
    }

    @Override // com.baidu.swan.e.b
    public Set<String> arM() {
        return this.cHh.arM();
    }

    @Override // com.baidu.swan.e.b
    public boolean arN() {
        return this.cHh.arN();
    }

    public SharedPreferences.Editor clear() {
        return this.cHh.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.cHh.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.cHh.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.cHh.edit();
    }

    @Override // com.baidu.swan.e.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.cHh.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.cHh.getBoolean(str, z);
    }

    @Override // com.baidu.swan.e.b
    public long getContentSize() {
        return this.cHh.getContentSize();
    }

    @Override // com.baidu.swan.e.b
    @NonNull
    public File getFile() {
        return this.cHh.getFile();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.cHh.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.cHh.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.cHh.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.cHh.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.cHh.getStringSet(str, set);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.cHh.putBoolean(str, z);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        return this.cHh.putFloat(str, f);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.cHh.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.cHh.putLong(str, j);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.cHh.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.cHh.putStringSet(str, set);
    }

    @Override // com.baidu.swan.e.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.cHh.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.cHh.remove(str);
    }

    @Override // com.baidu.swan.e.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.cHh.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public g(String str, boolean z) {
        q.m(str, "fileName");
        com.baidu.swan.e.b e = com.baidu.swan.apps.u.a.afO().e(com.baidu.swan.apps.u.a.aeR(), str, z);
        q.l((Object) e, "SwanAppRuntime.getSwanEx…Name, isMultiProcessMode)");
        this.cHh = e;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(String str) {
        this(str, true);
        q.m(str, "fileName");
    }
}
