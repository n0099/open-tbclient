package com.baidu.swan.apps.console;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.v;
import com.baidu.swan.apps.storage.b.e;
import com.baidu.ubc.UBC;
/* loaded from: classes2.dex */
public class b {
    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a.ye().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0123b.class, k(str, z));
        }
    }

    public static void aV(boolean z) {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            putBoolean(dq(Md.getAppKey()), z);
        }
    }

    public static boolean dp(String str) {
        return !TextUtils.isEmpty(str) && a.ye().getBoolean(dq(str), false);
    }

    private static String dq(String str) {
        String bc = com.baidu.swan.apps.u.a.Ep().bc(com.baidu.swan.apps.u.a.Ek());
        return "consoleSwitch" + str + (TextUtils.isEmpty(bc) ? "" : v.b(bc.getBytes(), false));
    }

    public static Bundle k(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        bundle.putBoolean(UBC.CONTENT_KEY_VALUE, z);
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
        public static final class C0122a {
            private static final a anD = new a();
        }

        public static a ye() {
            return C0122a.anD;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0123b extends ProviderDelegation {
        private C0123b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            a.ye().putBoolean(bundle.getString("key"), bundle.getBoolean(UBC.CONTENT_KEY_VALUE));
            return Bundle.EMPTY;
        }
    }
}
