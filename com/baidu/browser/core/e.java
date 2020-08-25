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
/* loaded from: classes19.dex */
public final class e implements SharedPreferences, SharedPreferences.Editor {
    private static final Map<String, e> adO = new HashMap();
    private Context adP = b.ta().getBaseContext();
    private ConcurrentHashMap<String, Object> adQ;
    private ConcurrentHashMap<String, Object> adR;
    private String mName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized e df(String str) {
        e eVar;
        synchronized (e.class) {
            if (TextUtils.isEmpty(str)) {
                str = b.ta().getPackageName() + "_preferences";
            }
            if (adO.containsKey(str)) {
                eVar = adO.get(str);
            } else {
                eVar = new e(str);
                adO.put(str, eVar);
            }
        }
        return eVar;
    }

    private e(String str) {
        this.mName = str;
        if (TextUtils.isEmpty(this.mName)) {
            this.mName = this.adP.getPackageName() + "_preferences";
        }
        this.adR = new ConcurrentHashMap<>();
        tc();
    }

    private void tc() {
        this.adQ = new ConcurrentHashMap<>();
        Map<String, ?> all = this.adP.getSharedPreferences(this.mName, 0).getAll();
        if (all != null) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    this.adQ.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.adP.getSharedPreferences(this.mName, 0).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.adP.getSharedPreferences(this.mName, 0).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (this.adQ.containsKey(str)) {
            return true;
        }
        return this.adP.getSharedPreferences(this.mName, 0).contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        if (this.adQ.containsKey(str)) {
            return ((Integer) this.adQ.get(str)).intValue();
        }
        return this.adP.getSharedPreferences(this.mName, 0).getInt(str, i);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (str != null) {
            this.adR.put(str, Integer.valueOf(i));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.adQ.containsKey(str)) {
            return ((Long) this.adQ.get(str)).longValue();
        }
        return this.adP.getSharedPreferences(this.mName, 0).getLong(str, j);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (str != null) {
            this.adR.put(str, Long.valueOf(j));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        if (this.adQ.containsKey(str)) {
            return ((Float) this.adQ.get(str)).floatValue();
        }
        return this.adP.getSharedPreferences(this.mName, 0).getFloat(str, f);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        if (str != null) {
            this.adR.put(str, Float.valueOf(f));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        if (this.adQ.containsKey(str)) {
            return ((Boolean) this.adQ.get(str)).booleanValue();
        }
        return this.adP.getSharedPreferences(this.mName, 0).getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (str != null) {
            this.adR.put(str, Boolean.valueOf(z));
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.adQ.containsKey(str)) {
            return (String) this.adQ.get(str);
        }
        return this.adP.getSharedPreferences(this.mName, 0).getString(str, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                remove(str);
            } else {
                this.adR.put(str, str2);
            }
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        this.adQ.clear();
        f.clear(this.mName);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        td();
        f.te();
        return true;
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        td();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.adQ;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        if (this.adQ.containsKey(str)) {
            return (Set) this.adQ.get(str);
        }
        return this.adP.getSharedPreferences(this.mName, 0).getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (str != null) {
            if (set == null) {
                remove(str);
            } else {
                this.adR.put(str, set);
            }
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (str != null) {
            this.adQ.remove(str);
            f.b(this.mName, str, null);
        }
        return this;
    }

    private void td() {
        synchronized (this) {
            Log.d("BdPreferenceImpl", "modified size: " + this.adR.size());
            for (Map.Entry<String, Object> entry : this.adR.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Log.d("BdPreferenceImpl", "modified. key: " + key + " value: " + value);
                if (key != null) {
                    if (value == null || value == this) {
                        this.adQ.remove(key);
                        f.b(this.mName, key, null);
                    } else {
                        if (this.adQ.containsKey(key)) {
                            Object obj = this.adQ.get(key);
                            Log.d("BdPreferenceImpl", "cache. key: " + key + " value: " + obj);
                            if (obj != null && obj.equals(value)) {
                            }
                        }
                        this.adQ.put(key, value);
                        Log.d("BdPreferenceImpl", "write to file. key: " + key + " value: " + value);
                        f.b(this.mName, key, value);
                    }
                }
            }
            this.adR.clear();
        }
    }
}
