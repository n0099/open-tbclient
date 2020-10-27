package com.baidu.swan.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes15.dex */
public class i implements b {
    private String drf;
    private final Context mContext = AppRuntime.getAppContext();
    @NonNull
    private final SharedPreferences mSp;

    public i(String str) {
        this.drf = (TextUtils.isEmpty(str) || str.indexOf(File.separatorChar) >= 0) ? "default" : str;
        if ("default".equals(this.drf)) {
            this.mSp = PreferenceManager.getDefaultSharedPreferences(this.mContext);
            this.drf = this.mContext.getPackageName() + "_preferences";
            return;
        }
        this.mSp = this.mContext.getSharedPreferences(str, 0);
    }

    @Override // com.baidu.swan.c.b
    public long getContentSize() {
        return getFile().length();
    }

    @Override // com.baidu.swan.c.b
    @NonNull
    public File getFile() {
        return ar(this.mContext, this.drf);
    }

    @Override // com.baidu.swan.c.b
    public boolean aIq() {
        return false;
    }

    @Override // com.baidu.swan.c.b
    public Set<String> aIr() {
        return this.mSp.getAll().keySet();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.mSp.getAll();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, @Nullable String str2) {
        return this.mSp.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.mSp.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.mSp.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.mSp.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.mSp.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.mSp.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.mSp.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.mSp.edit();
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSp.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.baidu.swan.c.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSp.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        this.mSp.edit().putString(str, str2).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        this.mSp.edit().putStringSet(str, set).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        this.mSp.edit().putInt(str, i).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        this.mSp.edit().putLong(str, j).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        this.mSp.edit().putFloat(str, f).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        this.mSp.edit().putBoolean(str, z).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        this.mSp.edit().remove(str).apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        this.mSp.edit().clear().apply();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return edit().commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        edit().apply();
    }

    public static File ar(@NonNull Context context, @NonNull String str) {
        return new File(context.getApplicationInfo().dataDir, "shared_prefs/" + str + ".xml");
    }
}
