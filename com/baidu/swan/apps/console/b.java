package com.baidu.swan.apps.console;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.as.aa;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes11.dex */
public class b {
    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a.Ti().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0286b.class, v(str, z));
        }
    }

    public static void dd(boolean z) {
        e akM = e.akM();
        if (akM != null) {
            putBoolean(hL(akM.getAppKey()), z);
        }
    }

    public static boolean hK(String str) {
        return !TextUtils.isEmpty(str) && a.Ti().getBoolean(hL(str), false);
    }

    private static String hL(String str) {
        String aR = com.baidu.swan.apps.w.a.abS().aR(com.baidu.swan.apps.w.a.abN());
        return "consoleSwitch" + str + (TextUtils.isEmpty(aR) ? "" : aa.toHash(aR.getBytes(), false));
    }

    public static Bundle v(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        bundle.putBoolean("value", z);
        return bundle;
    }

    /* loaded from: classes11.dex */
    public static class a extends g {
        private a() {
            super("searchbox_sconsole_sp");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.apps.console.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static final class C0285a {
            private static final a bIj = new a();
        }

        public static a Ti() {
            return C0285a.bIj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0286b extends ProviderDelegation {
        private C0286b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            a.Ti().putBoolean(bundle.getString("key"), bundle.getBoolean("value"));
            return Bundle.EMPTY;
        }
    }
}
