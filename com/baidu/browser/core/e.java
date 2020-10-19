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
    private static final Map<String, e> aez = new HashMap();
    private Context aeA = b.tf().getBaseContext();
    private ConcurrentHashMap<String, Object> aeB;
    private ConcurrentHashMap<String, Object> aeC;
    private String mName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized e di(String str) {
        e eVar;
        synchronized (e.class) {
            if (TextUtils.isEmpty(str)) {
                str = b.tf().getPackageName() + "_preferences";
            }
            if (aez.containsKey(str)) {
                eVar = aez.get(str);
            } else {
                eVar = new e(str);
                aez.put(str, eVar);
            }
        }
        return eVar;
    }

    private e(String str) {
        this.mName = str;
        if (TextUtils.isEmpty(this.mName)) {
            this.mName = this.aeA.getPackageName() + "_preferences";
        }
        this.aeC = new ConcurrentHashMap<>();
        th();
    }

    private void th() {
        this.aeB = new ConcurrentHashMap<>();
        Map<String, ?> all = this.aeA.getSharedPreferences(this.mName, 0).getAll();
        if (all != null) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    this.aeB.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.aeA.getSharedPreferences(this.mName, 0).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.aeA.getSharedPreferences(this.mName, 0).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (this.aeB.containsKey(str)) {
            return true;
        }
        return this.aeA.getSharedPreferences(this.mName, 0).contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        if (this.aeB.containsKey(str)) {
            return ((Integer) this.aeB.get(str)).intValue();
        }
        return this.aeA.getSharedPreferences(this.mName, 0).getInt(str, i);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (str != null) {
            this.aeC.put(str, Integer.valueOf(i));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.aeB.containsKey(str)) {
            return ((Long) this.aeB.get(str)).longValue();
        }
        return this.aeA.getSharedPreferences(this.mName, 0).getLong(str, j);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (str != null) {
            this.aeC.put(str, Long.valueOf(j));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        if (this.aeB.containsKey(str)) {
            return ((Float) this.aeB.get(str)).floatValue();
        }
        return this.aeA.getSharedPreferences(this.mName, 0).getFloat(str, f);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        if (str != null) {
            this.aeC.put(str, Float.valueOf(f));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        if (this.aeB.containsKey(str)) {
            return ((Boolean) this.aeB.get(str)).booleanValue();
        }
        return this.aeA.getSharedPreferences(this.mName, 0).getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (str != null) {
            this.aeC.put(str, Boolean.valueOf(z));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.aeB.containsKey(str)) {
            return (String) this.aeB.get(str);
        }
        return this.aeA.getSharedPreferences(this.mName, 0).getString(str, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                remove(str);
            } else {
                this.aeC.put(str, str2);
            }
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        this.aeB.clear();
        f.clear(this.mName);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        ti();
        f.tj();
        return true;
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        ti();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.aeB;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        if (this.aeB.containsKey(str)) {
            return (Set) this.aeB.get(str);
        }
        return this.aeA.getSharedPreferences(this.mName, 0).getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (str != null) {
            if (set == null) {
                remove(str);
            } else {
                this.aeC.put(str, set);
            }
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (str != null) {
            this.aeB.remove(str);
            f.b(this.mName, str, null);
        }
        return this;
    }

    private void ti() {
        synchronized (this) {
            Log.d("BdPreferenceImpl", "modified size: " + this.aeC.size());
            for (Map.Entry<String, Object> entry : this.aeC.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Log.d("BdPreferenceImpl", "modified. key: " + key + " value: " + value);
                if (key != null) {
                    if (value == null || value == this) {
                        this.aeB.remove(key);
                        f.b(this.mName, key, null);
                    } else {
                        if (this.aeB.containsKey(key)) {
                            Object obj = this.aeB.get(key);
                            Log.d("BdPreferenceImpl", "cache. key: " + key + " value: " + obj);
                            if (obj != null && obj.equals(value)) {
                            }
                        }
                        this.aeB.put(key, value);
                        Log.d("BdPreferenceImpl", "write to file. key: " + key + " value: " + value);
                        f.b(this.mName, key, value);
                    }
                }
            }
            this.aeC.clear();
        }
    }
}
