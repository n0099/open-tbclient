package com.baidu.searchbox.ugc.draft;

import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.util.Map;
import java.util.Set;
/* loaded from: classes11.dex */
public class DraftSPWrapper implements SharedPreferences {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String SP_FILE_UGC_DRAFT = "draft_sp";
    private static final String TAG = "DraftSPWrapper";
    private SharedPreferences mSp;

    private DraftSPWrapper() {
        this.mSp = AppRuntime.getAppContext().getSharedPreferences(SP_FILE_UGC_DRAFT, 0);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.mSp.getAll();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.mSp.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
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

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSp.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSp.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void putString(String str, String str2) {
        this.mSp.edit().putString(str, str2).apply();
    }

    public void putStringSet(String str, Set<String> set) {
        this.mSp.edit().putStringSet(str, set).apply();
    }

    public void putInt(String str, int i) {
        this.mSp.edit().putInt(str, i).apply();
    }

    public void putLong(String str, long j) {
        this.mSp.edit().putLong(str, j).apply();
    }

    public void putFloat(String str, float f) {
        this.mSp.edit().putFloat(str, f).apply();
    }

    public void putBoolean(String str, boolean z) {
        this.mSp.edit().putBoolean(str, z).apply();
    }

    public void remove(String str) {
        this.mSp.edit().remove(str).apply();
    }

    /* loaded from: classes11.dex */
    private static class Holder {
        private static final DraftSPWrapper INSTANCE = new DraftSPWrapper();

        private Holder() {
        }
    }

    public static DraftSPWrapper getInstance() {
        return Holder.INSTANCE;
    }
}
