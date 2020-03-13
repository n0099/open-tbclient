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
            a.Ls().putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0235b.class, q(str, z));
        }
    }

    public static void cg(boolean z) {
        e acF = e.acF();
        if (acF != null) {
            putBoolean(gz(acF.getAppKey()), z);
        }
    }

    public static boolean gy(String str) {
        return !TextUtils.isEmpty(str) && a.Ls().getBoolean(gz(str), false);
    }

    private static String gz(String str) {
        String bq = com.baidu.swan.apps.w.a.Ub().bq(com.baidu.swan.apps.w.a.TW());
        return "consoleSwitch" + str + (TextUtils.isEmpty(bq) ? "" : aa.toHash(bq.getBytes(), false));
    }

    public static Bundle q(String str, boolean z) {
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
        public static final class C0234a {
            private static final a bjJ = new a();
        }

        public static a Ls() {
            return C0234a.bjJ;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.console.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0235b extends ProviderDelegation {
        private C0235b() {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            a.Ls().putBoolean(bundle.getString("key"), bundle.getBoolean("value"));
            return Bundle.EMPTY;
        }
    }
}
