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
            a.yi().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0137b.class, k(str, z));
        }
    }

    public static void aV(boolean z) {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            putBoolean(ds(Mh.getAppKey()), z);
        }
    }

    public static boolean dr(String str) {
        return !TextUtils.isEmpty(str) && a.yi().getBoolean(ds(str), false);
    }

    private static String ds(String str) {
        String bc = com.baidu.swan.apps.u.a.Et().bc(com.baidu.swan.apps.u.a.Eo());
        return "consoleSwitch" + str + (TextUtils.isEmpty(bc) ? "" : v.c(bc.getBytes(), false));
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
        public static final class C0136a {
            private static final a aob = new a();
        }

        public static a yi() {
            return C0136a.aob;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0137b extends ProviderDelegation {
        private C0137b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            a.yi().putBoolean(bundle.getString("key"), bundle.getBoolean(UBC.CONTENT_KEY_VALUE));
            return Bundle.EMPTY;
        }
    }
}
