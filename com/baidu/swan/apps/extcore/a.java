package com.baidu.swan.apps.extcore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes7.dex */
public class a extends com.baidu.swan.apps.extcore.b.b<com.baidu.swan.apps.extcore.d.a.a, com.baidu.swan.apps.extcore.e.a.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cjE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a aeW() {
        if (cjE == null) {
            synchronized (a.class) {
                if (cjE == null) {
                    cjE = new a();
                }
            }
        }
        return cjE;
    }

    private a() {
        super(new com.baidu.swan.apps.extcore.d.a.a(), new com.baidu.swan.apps.extcore.e.a.a());
    }

    @Override // com.baidu.swan.apps.extcore.b.b
    @Nullable
    public ExtensionCore adR() {
        ExtensionCore extensionCore;
        if (ProcessUtils.isMainProcess()) {
            extensionCore = afd();
        } else {
            Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0357a.class, null).mResult;
            bundle.setClassLoader(ExtensionCore.class.getClassLoader());
            extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
            if (DEBUG) {
                Log.d("ExtCore-AppsManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            }
        }
        if (extensionCore != null && com.baidu.swan.apps.ae.a.a.aoP() && extensionCore.extensionCoreVersionCode < 4294967297L) {
            return com.baidu.swan.apps.ae.a.a.d(extensionCore);
        }
        return extensionCore;
    }

    /* renamed from: com.baidu.swan.apps.extcore.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0357a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_extension_core", aeX());
            return bundle2;
        }

        private ExtensionCore aeX() {
            ExtensionCore afd = aeY().afd();
            if (!afd.isAvailable()) {
                aeY().afb();
                return aeY().afd();
            }
            return afd;
        }

        private com.baidu.swan.apps.extcore.b.b aeY() {
            return b.fz(RU());
        }

        protected int RU() {
            return 0;
        }
    }
}
