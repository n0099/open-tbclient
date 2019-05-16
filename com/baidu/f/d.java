package com.baidu.f;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class d implements SharedPreferences {
    private SharedPreferences mSp;

    public d(String str) {
        if (TextUtils.isEmpty(str) || NotifyAdapterUtil.PRIMARY_CHANNEL.equals(str)) {
            this.mSp = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        } else {
            this.mSp = AppRuntime.getAppContext().getSharedPreferences(str, 0);
        }
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
        aI(str, str2);
        this.mSp.edit().putString(str, str2).apply();
    }

    public void putInt(String str, int i) {
        this.mSp.edit().putInt(str, i).apply();
    }

    public void putLong(String str, long j) {
        this.mSp.edit().putLong(str, j).apply();
    }

    private void aI(String str, String str2) {
        if (str2 == null || str2.length() <= 256) {
        }
    }
}
