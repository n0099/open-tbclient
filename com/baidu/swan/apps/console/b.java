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
            a.VP().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0323b.class, C(str, z));
        }
    }

    public static void dq(boolean z) {
        e aoF = e.aoF();
        if (aoF != null) {
            putBoolean(iM(aoF.getAppKey()), z);
        }
    }

    public static boolean iL(String str) {
        return !TextUtils.isEmpty(str) && a.VP().getBoolean(iM(str), false);
    }

    private static String iM(String str) {
        String bb = com.baidu.swan.apps.u.a.aeW().bb(com.baidu.swan.apps.u.a.aeR());
        return "consoleSwitch" + str + (TextUtils.isEmpty(bb) ? "" : ab.toHash(bb.getBytes(), false));
    }

    public static Bundle C(String str, boolean z) {
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
        public static final class C0322a {
            private static final a bRa = new a();
        }

        public static a VP() {
            return C0322a.bRa;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0323b extends ProviderDelegation {
        private C0323b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            a.VP().putBoolean(bundle.getString("key"), bundle.getBoolean("value"));
            return Bundle.EMPTY;
        }
    }
}
