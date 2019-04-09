package com.baidu.swan.apps.console;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.t;
import com.baidu.swan.apps.storage.b.e;
import com.baidu.ubc.UBC;
/* loaded from: classes2.dex */
public class b {
    public static void putBoolean(String str, boolean z) {
        if (ProcessUtils.isMainProcess()) {
            a.wI().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0123b.class, k(str, z));
        }
    }

    public static void aQ(boolean z) {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            putBoolean(dz(IV.getAppKey()), z);
        }
    }

    public static boolean dy(String str) {
        return !TextUtils.isEmpty(str) && a.wI().getBoolean(dz(str), false);
    }

    private static String dz(String str) {
        String bI = com.baidu.swan.apps.u.a.CB().bI(com.baidu.swan.apps.u.a.Cw());
        return "consoleSwitch" + str + (TextUtils.isEmpty(bI) ? "" : t.b(bI.getBytes(), false));
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
            private static final a amO = new a();
        }

        public static a wI() {
            return C0122a.amO;
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
            a.wI().putBoolean(bundle.getString("key"), bundle.getBoolean(UBC.CONTENT_KEY_VALUE));
            return Bundle.EMPTY;
        }
    }
}
