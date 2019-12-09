package com.baidu.swan.apps.console;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.v;
import com.baidu.swan.apps.storage.b.e;
/* loaded from: classes2.dex */
public class b {
    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a.De().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0164b.class, n(str, z));
        }
    }

    public static void bn(boolean z) {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            putBoolean(eb(Ra.getAppKey()), z);
        }
    }

    public static boolean ea(String str) {
        return !TextUtils.isEmpty(str) && a.De().getBoolean(eb(str), false);
    }

    private static String eb(String str) {
        String be = com.baidu.swan.apps.u.a.Jo().be(com.baidu.swan.apps.u.a.Jj());
        return "consoleSwitch" + str + (TextUtils.isEmpty(be) ? "" : v.c(be.getBytes(), false));
    }

    public static Bundle n(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(TiebaInitialize.Params.KEY, str);
        bundle.putBoolean("value", z);
        return bundle;
    }

    /* loaded from: classes2.dex */
    public static class a extends e {
        private a() {
            super("searchbox_sconsole_sp");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.swan.apps.console.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0163a {
            private static final a aHa = new a();
        }

        public static a De() {
            return C0163a.aHa;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0164b extends ProviderDelegation {
        private C0164b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            a.De().putBoolean(bundle.getString(TiebaInitialize.Params.KEY), bundle.getBoolean("value"));
            return Bundle.EMPTY;
        }
    }
}
