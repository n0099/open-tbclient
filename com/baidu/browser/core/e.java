package com.baidu.browser.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class e implements SharedPreferences, SharedPreferences.Editor {
    private static final Map<String, e> HK = new HashMap();
    private Context HL = b.lY().getBaseContext();
    private ConcurrentHashMap<String, Object> HM;
    private ConcurrentHashMap<String, Object> HN;
    private String mName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized e bE(String str) {
        e eVar;
        synchronized (e.class) {
            if (TextUtils.isEmpty(str)) {
                str = b.lY().getPackageName() + "_preferences";
            }
            if (HK.containsKey(str)) {
                eVar = HK.get(str);
            } else {
                eVar = new e(str);
                HK.put(str, eVar);
            }
        }
        return eVar;
    }

    private e(String str) {
        this.mName = str;
        if (TextUtils.isEmpty(this.mName)) {
            this.mName = this.HL.getPackageName() + "_preferences";
        }
        this.HN = new ConcurrentHashMap<>();
        ma();
    }

    private void ma() {
        this.HM = new ConcurrentHashMap<>();
        Map<String, ?> all = this.HL.getSharedPreferences(this.mName, 0).getAll();
        if (all != null) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    this.HM.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.HL.getSharedPreferences(this.mName, 0).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.HL.getSharedPreferences(this.mName, 0).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (this.HM.containsKey(str)) {
            return true;
        }
        return this.HL.getSharedPreferences(this.mName, 0).contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        if (this.HM.containsKey(str)) {
            return ((Integer) this.HM.get(str)).intValue();
        }
        return this.HL.getSharedPreferences(this.mName, 0).getInt(str, i);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (str != null) {
            this.HN.put(str, Integer.valueOf(i));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.HM.containsKey(str)) {
            return ((Long) this.HM.get(str)).longValue();
        }
        return this.HL.getSharedPreferences(this.mName, 0).getLong(str, j);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (str != null) {
            this.HN.put(str, Long.valueOf(j));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        if (this.HM.containsKey(str)) {
            return ((Float) this.HM.get(str)).floatValue();
        }
        return this.HL.getSharedPreferences(this.mName, 0).getFloat(str, f);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        if (str != null) {
            this.HN.put(str, Float.valueOf(f));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        if (this.HM.containsKey(str)) {
            return ((Boolean) this.HM.get(str)).booleanValue();
        }
        return this.HL.getSharedPreferences(this.mName, 0).getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (str != null) {
            this.HN.put(str, Boolean.valueOf(z));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.HM.containsKey(str)) {
            return (String) this.HM.get(str);
        }
        return this.HL.getSharedPreferences(this.mName, 0).getString(str, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                remove(str);
            } else {
                this.HN.put(str, str2);
            }
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        this.HM.clear();
        f.clear(this.mName);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        mb();
        f.mc();
        return true;
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        mb();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.HM;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        if (this.HM.containsKey(str)) {
            return (Set) this.HM.get(str);
        }
        return this.HL.getSharedPreferences(this.mName, 0).getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (str != null) {
            if (set == null) {
                remove(str);
            } else {
                this.HN.put(str, set);
            }
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (str != null) {
            this.HM.remove(str);
            f.b(this.mName, str, null);
        }
        return this;
    }

    private void mb() {
        synchronized (this) {
            Log.d("BdPreferenceImpl", "modified size: " + this.HN.size());
            for (Map.Entry<String, Object> entry : this.HN.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Log.d("BdPreferenceImpl", "modified. key: " + key + " value: " + value);
                if (key != null) {
                    if (value == null || value == this) {
                        this.HM.remove(key);
                        f.b(this.mName, key, null);
                    } else {
                        if (this.HM.containsKey(key)) {
                            Object obj = this.HM.get(key);
                            Log.d("BdPreferenceImpl", "cache. key: " + key + " value: " + obj);
                            if (obj != null && obj.equals(value)) {
                            }
                        }
                        this.HM.put(key, value);
                        Log.d("BdPreferenceImpl", "write to file. key: " + key + " value: " + value);
                        f.b(this.mName, key, value);
                    }
                }
            }
            this.HN.clear();
        }
    }
}
