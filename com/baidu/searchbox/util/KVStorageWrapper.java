package com.baidu.searchbox.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.util.KVStorageRuntime;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.er1;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes4.dex */
public class KVStorageWrapper extends er1 {
    public static final boolean DEBUG = false;
    public static final String TAG = "KVStorageWrapper";
    public Handler mMainThreadHandler;
    public final ArrayList<String> mModified;
    public KVFileObserver mObserver;

    public KVStorageWrapper(Context context, String str) {
        super(context, str, 2, KVStorageRuntime.getKVStorageControl().getKVStoragePath());
        this.mModified = new ArrayList<>();
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        if (str == null) {
            return z;
        }
        return super.getBoolean(str, z);
    }

    @Override // com.baidu.tieba.er1, com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        return super.getFloat(str, f);
    }

    @Override // com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public int getInt(String str, int i) {
        if (str == null) {
            return i;
        }
        return super.getInt(str, i);
    }

    @Override // com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (str == null) {
            return j;
        }
        return super.getLong(str, j);
    }

    @Override // com.baidu.tieba.er1, com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        return super.getString(str, str2);
    }

    @Override // com.baidu.tieba.er1, com.baidu.storage.swankv.SwanKV, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        if (str == null) {
            return set;
        }
        return super.getStringSet(str, set);
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (str == null) {
            return this;
        }
        if (this.mObserver != null) {
            synchronized (this) {
                this.mModified.add(str);
            }
        }
        return super.putBoolean(str, z);
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        if (str == null) {
            return this;
        }
        if (this.mObserver != null) {
            synchronized (this) {
                this.mModified.add(str);
            }
        }
        return super.putFloat(str, f);
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (str == null) {
            return this;
        }
        if (this.mObserver != null) {
            synchronized (this) {
                this.mModified.add(str);
            }
        }
        return super.putInt(str, i);
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (str == null) {
            return this;
        }
        if (this.mObserver != null) {
            synchronized (this) {
                this.mModified.add(str);
            }
        }
        return super.putLong(str, j);
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (str == null) {
            return this;
        }
        if (this.mObserver != null) {
            synchronized (this) {
                this.mModified.add(str);
            }
        }
        return super.putString(str, str2);
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (str == null) {
            return this;
        }
        if (this.mObserver != null) {
            synchronized (this) {
                this.mModified.add(str);
            }
        }
        return super.putStringSet(str, set);
    }

    public KVStorageWrapper(Context context, String str, int i) {
        super(context, str, i, KVStorageRuntime.getKVStorageControl().getKVStoragePath());
        this.mModified = new ArrayList<>();
    }

    public KVStorageWrapper(Context context, String str, int i, String str2) {
        super(context, str, i, str2);
        this.mModified = new ArrayList<>();
    }

    public KVStorageWrapper(String str) {
        super(AppRuntime.getAppContext(), str, 2, KVStorageRuntime.getKVStorageControl().getKVStoragePath());
        this.mModified = new ArrayList<>();
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences
    public boolean contains(String str) {
        if (str == null) {
            return false;
        }
        return super.contains(str);
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            if (this.mObserver == null) {
                this.mObserver = new KVFileObserver();
            }
            this.mObserver.addListener(onSharedPreferenceChangeListener);
        }
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (str == null) {
            return this;
        }
        if (this.mObserver != null) {
            synchronized (this) {
                this.mModified.add(str);
            }
        }
        return super.remove(str);
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            if (this.mObserver == null) {
                return;
            }
            this.mObserver.removeListener(onSharedPreferenceChangeListener);
            if (!this.mObserver.hasListeners()) {
                this.mObserver = null;
            }
        }
    }

    public KVStorageWrapper(String str, int i) {
        super(AppRuntime.getAppContext(), str, i, KVStorageRuntime.getKVStorageControl().getKVStoragePath());
        this.mModified = new ArrayList<>();
    }

    private void notifyObserver() {
        ArrayList<String> arrayList;
        final ArrayList arrayList2;
        if (this.mObserver != null && (arrayList = this.mModified) != null && arrayList.size() > 0) {
            synchronized (this) {
                arrayList2 = new ArrayList(this.mModified);
                this.mModified.clear();
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.mObserver.notifyListeners(this, arrayList2);
                return;
            }
            if (this.mMainThreadHandler == null) {
                synchronized (this) {
                    if (this.mMainThreadHandler == null) {
                        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
                    }
                }
            }
            this.mMainThreadHandler.post(new Runnable() { // from class: com.baidu.searchbox.util.KVStorageWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    KVStorageWrapper.this.mObserver.notifyListeners(this, arrayList2);
                }
            });
        }
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences.Editor
    public void apply() {
        super.apply();
        notifyObserver();
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        return super.clear();
    }

    @Override // com.baidu.tieba.er1, android.content.SharedPreferences.Editor
    public boolean commit() {
        boolean commit = super.commit();
        notifyObserver();
        return commit;
    }
}
