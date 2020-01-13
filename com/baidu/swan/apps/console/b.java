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
/* loaded from: classes10.dex */
public class b {
    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a.Jb().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0225b.class, q(str, z));
        }
    }

    public static void bY(boolean z) {
        e aap = e.aap();
        if (aap != null) {
            putBoolean(gj(aap.getAppKey()), z);
        }
    }

    public static boolean gi(String str) {
        return !TextUtils.isEmpty(str) && a.Jb().getBoolean(gj(str), false);
    }

    private static String gj(String str) {
        String bm = com.baidu.swan.apps.w.a.RL().bm(com.baidu.swan.apps.w.a.RG());
        return "consoleSwitch" + str + (TextUtils.isEmpty(bm) ? "" : aa.toHash(bm.getBytes(), false));
    }

    public static Bundle q(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        bundle.putBoolean("value", z);
        return bundle;
    }

    /* loaded from: classes10.dex */
    public static class a extends g {
        private a() {
            super("searchbox_sconsole_sp");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.apps.console.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C0224a {
            private static final a bfu = new a();
        }

        public static a Jb() {
            return C0224a.bfu;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0225b extends ProviderDelegation {
        private C0225b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            a.Jb().putBoolean(bundle.getString("key"), bundle.getBoolean("value"));
            return Bundle.EMPTY;
        }
    }
}
