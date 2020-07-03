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
    private final /* synthetic */ com.baidu.swan.e.b cLR;

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.cLR.apply();
    }

    @Override // com.baidu.swan.e.b
    public Set<String> asT() {
        return this.cLR.asT();
    }

    @Override // com.baidu.swan.e.b
    public boolean asU() {
        return this.cLR.asU();
    }

    public SharedPreferences.Editor clear() {
        return this.cLR.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.cLR.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.cLR.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.cLR.edit();
    }

    @Override // com.baidu.swan.e.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.cLR.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.cLR.getBoolean(str, z);
    }

    @Override // com.baidu.swan.e.b
    public long getContentSize() {
        return this.cLR.getContentSize();
    }

    @Override // com.baidu.swan.e.b
    @NonNull
    public File getFile() {
        return this.cLR.getFile();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.cLR.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.cLR.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.cLR.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.cLR.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.cLR.getStringSet(str, set);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        return this.cLR.putBoolean(str, z);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        return this.cLR.putFloat(str, f);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        return this.cLR.putInt(str, i);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        return this.cLR.putLong(str, j);
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        return this.cLR.putString(str, str2);
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        return this.cLR.putStringSet(str, set);
    }

    @Override // com.baidu.swan.e.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.cLR.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor remove(String str) {
        return this.cLR.remove(str);
    }

    @Override // com.baidu.swan.e.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.cLR.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public g(String str, boolean z) {
        q.m(str, "fileName");
        com.baidu.swan.e.b e = com.baidu.swan.apps.u.a.agU().e(com.baidu.swan.apps.u.a.afX(), str, z);
        q.l((Object) e, "SwanAppRuntime.getSwanEx…Name, isMultiProcessMode)");
        this.cLR = e;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(String str) {
        this(str, true);
        q.m(str, "fileName");
    }
}
