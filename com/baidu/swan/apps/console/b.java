package com.baidu.swan.apps.console;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.ab;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.g;
/* loaded from: classes11.dex */
public class b {
    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a.WV().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0329b.class, E(str, z));
        }
    }

    public static void dv(boolean z) {
        e apM = e.apM();
        if (apM != null) {
            putBoolean(iU(apM.getAppKey()), z);
        }
    }

    public static boolean iT(String str) {
        return !TextUtils.isEmpty(str) && a.WV().getBoolean(iU(str), false);
    }

    private static String iU(String str) {
        String bc = com.baidu.swan.apps.u.a.agc().bc(com.baidu.swan.apps.u.a.afX());
        return "consoleSwitch" + str + (TextUtils.isEmpty(bc) ? "" : ab.toHash(bc.getBytes(), false));
    }

    public static Bundle E(String str, boolean z) {
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
        public static final class C0328a {
            private static final a bVO = new a();
        }

        public static a WV() {
            return C0328a.bVO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0329b extends ProviderDelegation {
        private C0329b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            a.WV().putBoolean(bundle.getString("key"), bundle.getBoolean("value"));
            return Bundle.EMPTY;
        }
    }
}
