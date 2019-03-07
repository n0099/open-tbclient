package com.baidu.swan.apps.storage.b;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes2.dex */
public final class f extends e {
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static volatile f aSZ;

    public f() {
        super("searchbox_webapps_sp");
    }

    public static f KL() {
        if (aSZ == null) {
            synchronized (f.class) {
                if (aSZ == null) {
                    aSZ = new f();
                }
            }
        }
        return aSZ;
    }

    @Override // com.baidu.swan.apps.storage.b.e, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return super.getString(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a.d(4, str, str2));
        if (DEBUG) {
            Log.d("SwanAppSpHelper", "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getString("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getString("result_value");
    }

    @Override // com.baidu.swan.apps.storage.b.e, android.content.SharedPreferences
    public int getInt(String str, int i) {
        if (ProcessUtils.isMainProcess()) {
            return super.getInt(str, i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a.d(1, str, String.valueOf(i)));
        if (DEBUG) {
            Log.d("SwanAppSpHelper", "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getInt("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getInt("result_value");
    }

    @Override // com.baidu.swan.apps.storage.b.e, android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (ProcessUtils.isMainProcess()) {
            return super.getLong(str, j);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a.d(2, str, String.valueOf(j)));
        if (DEBUG) {
            Log.d("SwanAppSpHelper", "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getLong("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getLong("result_value");
    }

    @Override // com.baidu.swan.apps.storage.b.e, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        if (ProcessUtils.isMainProcess()) {
            return super.getFloat(str, f);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a.d(5, str, String.valueOf(f)));
        if (DEBUG) {
            Log.d("SwanAppSpHelper", "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getFloat("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getFloat("result_value");
    }

    @Override // com.baidu.swan.apps.storage.b.e, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            return super.getBoolean(str, z);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a.d(3, str, String.valueOf(z)));
        if (DEBUG) {
            Log.d("SwanAppSpHelper", "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getBoolean("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getBoolean("result_value");
    }

    @Override // com.baidu.swan.apps.storage.b.e
    public void putString(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            super.putString(str, str2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d.class, a.d(4, str, str2));
        }
    }

    @Override // com.baidu.swan.apps.storage.b.e
    public void putInt(String str, int i) {
        if (ProcessUtils.isMainProcess()) {
            super.putInt(str, i);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d.class, a.d(1, str, String.valueOf(i)));
        }
    }

    @Override // com.baidu.swan.apps.storage.b.e
    public void putLong(String str, long j) {
        if (ProcessUtils.isMainProcess()) {
            super.edit().putLong(str, j).commit();
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d.class, a.d(2, str, String.valueOf(j)));
        }
    }

    @Override // com.baidu.swan.apps.storage.b.e
    public void putFloat(String str, float f) {
        if (ProcessUtils.isMainProcess()) {
            super.putFloat(str, f);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d.class, a.d(5, str, String.valueOf(f)));
        }
    }

    @Override // com.baidu.swan.apps.storage.b.e
    public void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            super.putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), d.class, a.d(3, str, String.valueOf(z)));
        }
    }
}
