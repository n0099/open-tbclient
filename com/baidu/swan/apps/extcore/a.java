package com.baidu.swan.apps.extcore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.extcore.b.b<com.baidu.swan.apps.extcore.e.a.a, com.baidu.swan.apps.extcore.f.a.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a buA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a RJ() {
        if (buA == null) {
            synchronized (a.class) {
                if (buA == null) {
                    buA = new a();
                }
            }
        }
        return buA;
    }

    private a() {
        super(new com.baidu.swan.apps.extcore.e.a.a(), new com.baidu.swan.apps.extcore.f.a.a());
    }

    @Override // com.baidu.swan.apps.extcore.b.b
    @Nullable
    public ExtensionCore QR() {
        ExtensionCore extensionCore;
        if (ProcessUtils.isMainProcess()) {
            extensionCore = RQ();
        } else {
            Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0258a.class, null).mResult;
            bundle.setClassLoader(ExtensionCore.class.getClassLoader());
            extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
            if (DEBUG) {
                Log.d("ExtCore-AppsManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            }
        }
        if (extensionCore != null && com.baidu.swan.apps.ah.a.a.aam() && extensionCore.extensionCoreVersionCode < 4294967297L) {
            return com.baidu.swan.apps.ah.a.a.d(extensionCore);
        }
        return extensionCore;
    }

    /* renamed from: com.baidu.swan.apps.extcore.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0258a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_extension_core", RK());
            return bundle2;
        }

        private ExtensionCore RK() {
            ExtensionCore RQ = RL().RQ();
            if (!RQ.isAvailable()) {
                RL().RO();
                return RL().RQ();
            }
            return RQ;
        }

        private com.baidu.swan.apps.extcore.b.b RL() {
            return b.eN(Gu());
        }

        protected int Gu() {
            return 0;
        }
    }
}
