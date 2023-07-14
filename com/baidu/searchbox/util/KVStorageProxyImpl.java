package com.baidu.searchbox.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.util.IKVStorageProxy;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tieba.cs1;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
@Singleton
@Service
/* loaded from: classes4.dex */
public class KVStorageProxyImpl implements IKVStorageProxy {
    public static final boolean DEBUG = false;
    public static final String TAG = "KVStorageImpl";
    public static long sInitDuration = -1;
    public ConcurrentHashMap<String, KVStorageWrapper> kvCache = new ConcurrentHashMap<>();
    public final Object mCacheLock = new Object();
    public CopyOnWriteArraySet<String> retriedSet = new CopyOnWriteArraySet<>();
    public ConcurrentHashMap<SharedPreferences, SharedPreferences.OnSharedPreferenceChangeListener> mListenerHashMap = new ConcurrentHashMap<>();
    public Map<String, Object> mImportLockMap = new HashMap();

    static {
        long currentTimeMillis = System.currentTimeMillis();
        initializeKVStorage();
        sInitDuration = System.currentTimeMillis() - currentTimeMillis;
    }

    public static long getInitDuration() {
        return sInitDuration;
    }

    public static void initializeKVStorage() {
        cs1 cs1Var = new cs1(AppRuntime.getAppContext());
        cs1Var.f(new SwanKV.b() { // from class: com.baidu.searchbox.util.KVStorageProxyImpl.3
            @Override // com.baidu.storage.swankv.SwanKV.b
            public void loadLibrary(String str) {
                SoLoader.load(AppRuntime.getAppContext(), str);
            }
        });
        cs1Var.e(true);
        SwanKV.initialize(cs1Var);
        try {
            SwanKV.registerEventHandler(new KVEventHandler());
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.baidu.searchbox.util.KVStorageWrapper */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean importFromSharedPrefsImpl(SharedPreferences sharedPreferences, String str, KVStorageWrapper kVStorageWrapper) {
        long customMeta = kVStorageWrapper.getCustomMeta();
        if ((customMeta & 1) == 1) {
            return true;
        }
        kVStorageWrapper.importFromMap(sharedPreferences.getAll(), false);
        kVStorageWrapper.setCustomMeta(customMeta | 1);
        return true;
    }

    private boolean canUseKVOpt(String str, KVStorageWrapper kVStorageWrapper) {
        SharedPreferences sharedPreferences;
        long customMeta = kVStorageWrapper.getCustomMeta();
        if ((customMeta & 1) == 1 || (sharedPreferences = AppRuntime.getAppContext().getSharedPreferences(str, 0)) == null) {
            return true;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null && !all.isEmpty()) {
            return false;
        }
        kVStorageWrapper.setCustomMeta(customMeta | 1);
        return true;
    }

    private void importFromSharedPreferences(Context context, final String str, final KVStorageWrapper kVStorageWrapper) {
        final SharedPreferences sharedPreferences;
        long customMeta = kVStorageWrapper.getCustomMeta();
        if ((customMeta & 1) == 1 || (customMeta & 2) == 2 || (sharedPreferences = AppRuntime.getAppContext().getSharedPreferences(str, 0)) == null) {
            return;
        }
        Object obj = this.mImportLockMap.get(str);
        if (obj == null) {
            synchronized (this.mImportLockMap) {
                obj = this.mImportLockMap.get(str);
                if (obj == null) {
                    obj = new Object();
                    this.mImportLockMap.put(str, obj);
                }
            }
        }
        synchronized (obj) {
            long customMeta2 = kVStorageWrapper.getCustomMeta();
            if ((customMeta2 & 1) != 1 && (customMeta2 & 2) != 2) {
                kVStorageWrapper.setCustomMeta(customMeta2 | 2);
                final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.baidu.searchbox.util.KVStorageProxyImpl.1
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str2) {
                        KVStorageProxyImpl.saveModifiedData(sharedPreferences2, str2, kVStorageWrapper);
                    }
                };
                sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
                ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.util.KVStorageProxyImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        KVStorageProxyImpl.this.mListenerHashMap.put(sharedPreferences, onSharedPreferenceChangeListener);
                        if (!KVStorageProxyImpl.this.importFromSharedPrefsImpl(sharedPreferences, str, kVStorageWrapper) && !KVStorageProxyImpl.this.retriedSet.contains(str)) {
                            kVStorageWrapper.clearAll();
                            KVStorageProxyImpl.this.retriedSet.add(str);
                            KVStorageProxyImpl.this.importFromSharedPrefsImpl(sharedPreferences, str, kVStorageWrapper);
                        }
                    }
                }, "asyncSharedPreferencesImport", 3, 2000L);
            }
        }
    }

    public static void saveModifiedData(SharedPreferences sharedPreferences, String str, KVStorageWrapper kVStorageWrapper) {
        Object obj = sharedPreferences.getAll().get(str);
        if (obj instanceof Boolean) {
            kVStorageWrapper.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            kVStorageWrapper.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            kVStorageWrapper.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            kVStorageWrapper.putString(str, (String) obj);
        } else if (obj instanceof Float) {
            kVStorageWrapper.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Set) {
            kVStorageWrapper.putStringSet(str, (Set) obj);
        }
    }

    @Override // com.baidu.android.util.IKVStorageProxy
    public SharedPreferences getProxy(String str) {
        KVStorageWrapper kVStorageWrapper = this.kvCache.get(str);
        if (kVStorageWrapper == null) {
            synchronized (this.mCacheLock) {
                kVStorageWrapper = this.kvCache.get(str);
                if (kVStorageWrapper == null) {
                    kVStorageWrapper = new KVStorageWrapper(str);
                    this.kvCache.put(str, kVStorageWrapper);
                }
            }
        }
        if (canUseKVOpt(str, kVStorageWrapper)) {
            return kVStorageWrapper;
        }
        importFromSharedPreferences(AppRuntime.getAppContext(), str, kVStorageWrapper);
        return null;
    }
}
