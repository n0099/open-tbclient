package com.baidu.android.util;

import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes.dex */
public class KVStorageFactory {
    public static final String PREFERENCE_SUFFIX = "preferences";
    public static final String TAG = "KVStorageFactory";
    public static boolean sIsKVInitSuccessfully = true;

    public static SharedPreferences getDefaultSharedPreferences() {
        return getSharedPreferences(AppRuntime.getAppContext().getPackageName() + "_" + PREFERENCE_SUFFIX, 0);
    }

    public static SharedPreferences getSharedPreferences(String str) {
        return getSharedPreferences(str, 0);
    }

    public static boolean isKVStorageInitSuccess() {
        return sIsKVInitSuccessfully;
    }

    public static SharedPreferences getSharedPreferences(String str, int i2) {
        SharedPreferences proxy;
        try {
            if (KVStorageRuntime.getKVStorageControl().getKVStorageType() != 0 && (proxy = KVStorageRuntime.getKVStorageProxy().getProxy(str)) != null) {
                Log.d(TAG, "use SwanKV " + str);
                return proxy;
            }
        } catch (UnsatisfiedLinkError unused) {
            sIsKVInitSuccessfully = false;
        }
        Log.d(TAG, "use default SharedPreferences " + str);
        return AppRuntime.getAppContext().getSharedPreferences(str, i2);
    }
}
