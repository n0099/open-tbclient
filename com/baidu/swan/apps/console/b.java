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
/* loaded from: classes9.dex */
public class b {
    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a.IF().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0223b.class, q(str, z));
        }
    }

    public static void bT(boolean z) {
        e ZS = e.ZS();
        if (ZS != null) {
            putBoolean(gg(ZS.getAppKey()), z);
        }
    }

    public static boolean gf(String str) {
        return !TextUtils.isEmpty(str) && a.IF().getBoolean(gg(str), false);
    }

    private static String gg(String str) {
        String bm = com.baidu.swan.apps.w.a.Rp().bm(com.baidu.swan.apps.w.a.Rk());
        return "consoleSwitch" + str + (TextUtils.isEmpty(bm) ? "" : aa.toHash(bm.getBytes(), false));
    }

    public static Bundle q(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        bundle.putBoolean("value", z);
        return bundle;
    }

    /* loaded from: classes9.dex */
    public static class a extends g {
        private a() {
            super("searchbox_sconsole_sp");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.apps.console.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C0222a {
            private static final a beE = new a();
        }

        public static a IF() {
            return C0222a.beE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0223b extends ProviderDelegation {
        private C0223b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            a.IF().putBoolean(bundle.getString("key"), bundle.getBoolean("value"));
            return Bundle.EMPTY;
        }
    }
}
