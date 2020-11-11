package com.baidu.swan.apps.extcore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.extcore.b.b<com.baidu.swan.apps.extcore.d.a.a, com.baidu.swan.apps.extcore.e.a.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a atT() {
        if (cTy == null) {
            synchronized (a.class) {
                if (cTy == null) {
                    cTy = new a();
                }
            }
        }
        return cTy;
    }

    private a() {
        super(new com.baidu.swan.apps.extcore.d.a.a(), new com.baidu.swan.apps.extcore.e.a.a());
    }

    @Override // com.baidu.swan.apps.extcore.b.b
    @Nullable
    public ExtensionCore ase() {
        ExtensionCore extensionCore;
        if (ProcessUtils.isMainProcess()) {
            extensionCore = aub();
        } else {
            Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0440a.class, null).mResult;
            bundle.setClassLoader(ExtensionCore.class.getClassLoader());
            extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
            if (DEBUG) {
                Log.d("ExtCore-AppsManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            }
        }
        if (extensionCore != null && com.baidu.swan.apps.ad.a.a.aEA() && extensionCore.extensionCoreVersionCode < 4294967297L) {
            return com.baidu.swan.apps.ad.a.a.d(extensionCore);
        }
        return extensionCore;
    }

    /* renamed from: com.baidu.swan.apps.extcore.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0440a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_extension_core", atU());
            return bundle2;
        }

        private ExtensionCore atU() {
            ExtensionCore aub = atV().aub();
            if (!aub.isAvailable()) {
                atV().atY();
                return atV().aub();
            }
            return aub;
        }

        private com.baidu.swan.apps.extcore.b.b atV() {
            return b.ix(afE());
        }

        protected int afE() {
            return 0;
        }
    }
}
