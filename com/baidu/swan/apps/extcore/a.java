package com.baidu.swan.apps.extcore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.b.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes2.dex */
public class a extends b<com.baidu.swan.apps.extcore.e.a.a, com.baidu.swan.apps.extcore.f.a.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a avq;

    public static a Bj() {
        if (avq == null) {
            synchronized (a.class) {
                if (avq == null) {
                    avq = new a();
                }
            }
        }
        return avq;
    }

    private a() {
        super(new com.baidu.swan.apps.extcore.e.a.a(), new com.baidu.swan.apps.extcore.f.a.a());
    }

    @Nullable
    public ExtensionCore At() {
        if (ProcessUtils.isMainProcess()) {
            return Bn();
        }
        Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0140a.class, null).mResult;
        bundle.setClassLoader(ExtensionCore.class.getClassLoader());
        ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
        if (DEBUG) {
            Log.d("ExtCore-AppsManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            return extensionCore;
        }
        return extensionCore;
    }

    /* renamed from: com.baidu.swan.apps.extcore.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0140a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_extension_core", Bk());
            return bundle2;
        }

        private ExtensionCore Bk() {
            ExtensionCore Bn = a.Bj().Bn();
            if (!Bn.isAvailable()) {
                a.Bj().Bm();
                return a.Bj().Bn();
            }
            return Bn;
        }
    }
}
