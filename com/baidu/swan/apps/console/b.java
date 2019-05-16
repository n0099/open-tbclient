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
            a.xA().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0126b.class, k(str, z));
        }
    }

    public static void aS(boolean z) {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            putBoolean(dm(Lq.getAppKey()), z);
        }
    }

    public static boolean dl(String str) {
        return !TextUtils.isEmpty(str) && a.xA().getBoolean(dm(str), false);
    }

    private static String dm(String str) {
        String bc = com.baidu.swan.apps.u.a.DG().bc(com.baidu.swan.apps.u.a.DB());
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
        public static final class C0125a {
            private static final a ana = new a();
        }

        public static a xA() {
            return C0125a.ana;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0126b extends ProviderDelegation {
        private C0126b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            a.xA().putBoolean(bundle.getString("key"), bundle.getBoolean(UBC.CONTENT_KEY_VALUE));
            return Bundle.EMPTY;
        }
    }
}
