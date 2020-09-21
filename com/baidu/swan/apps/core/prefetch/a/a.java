package com.baidu.swan.apps.core.prefetch.a;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ap.ag;
import com.baidu.swan.apps.b;
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static final boolean cnT;

    static {
        cnT = ProcessUtils.isMainProcess() ? mf("swan_prefetch_app_data") : ajM();
        if (DEBUG) {
            Log.i("PrefetchABSwitcher", "prefetch switch - " + cnT);
        }
    }

    public static boolean isOn() {
        return cnT;
    }

    private static boolean mf(String str) {
        int ajL;
        if (DEBUG) {
            if (com.baidu.swan.apps.ad.a.a.axv() || (ajL = ajL()) == 1) {
                return true;
            }
            if (ajL == 0) {
                return false;
            }
        }
        int i = com.baidu.swan.apps.t.a.apx().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("PrefetchABSwitcher", str + " value from AB : " + i);
        }
        return i == 1;
    }

    private static int ajL() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_app_data", -1);
    }

    private static boolean ajM() {
        boolean z = false;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0388a.class, null);
        if (callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false)) {
            z = true;
        }
        if (DEBUG) {
            Log.i("PrefetchABSwitcher", "get prefetch switch cross precess cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return z;
    }

    public static boolean ajN() {
        return !ag.sZ("3.210.0");
    }

    /* renamed from: com.baidu.swan.apps.core.prefetch.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0388a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("result", a.isOn());
            return bundle2;
        }
    }
}
