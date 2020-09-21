package com.baidu.swan.apps.extcore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.apps.extcore.b.b<com.baidu.swan.apps.extcore.d.a.a, com.baidu.swan.apps.extcore.e.a.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a csY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a amM() {
        if (csY == null) {
            synchronized (a.class) {
                if (csY == null) {
                    csY = new a();
                }
            }
        }
        return csY;
    }

    private a() {
        super(new com.baidu.swan.apps.extcore.d.a.a(), new com.baidu.swan.apps.extcore.e.a.a());
    }

    @Override // com.baidu.swan.apps.extcore.b.b
    @Nullable
    public ExtensionCore akY() {
        ExtensionCore extensionCore;
        if (ProcessUtils.isMainProcess()) {
            extensionCore = amU();
        } else {
            Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0397a.class, null).mResult;
            bundle.setClassLoader(ExtensionCore.class.getClassLoader());
            extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
            if (DEBUG) {
                Log.d("ExtCore-AppsManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            }
        }
        if (extensionCore != null && com.baidu.swan.apps.ad.a.a.axv() && extensionCore.extensionCoreVersionCode < 4294967297L) {
            return com.baidu.swan.apps.ad.a.a.d(extensionCore);
        }
        return extensionCore;
    }

    /* renamed from: com.baidu.swan.apps.extcore.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0397a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_extension_core", amN());
            return bundle2;
        }

        private ExtensionCore amN() {
            ExtensionCore amU = amO().amU();
            if (!amU.isAvailable()) {
                amO().amR();
                return amO().amU();
            }
            return amU;
        }

        private com.baidu.swan.apps.extcore.b.b amO() {
            return b.hF(Yy());
        }

        protected int Yy() {
            return 0;
        }
    }
}
