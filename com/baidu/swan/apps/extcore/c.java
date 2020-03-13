package com.baidu.swan.apps.extcore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.extcore.b.b<com.baidu.swan.games.g.c.a, com.baidu.swan.games.g.d.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c buB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c RM() {
        if (buB == null) {
            synchronized (c.class) {
                if (buB == null) {
                    buB = new c();
                }
            }
        }
        return buB;
    }

    private c() {
        super(new com.baidu.swan.games.g.c.a(), new com.baidu.swan.games.g.d.a());
    }

    @Override // com.baidu.swan.apps.extcore.b.b
    @Nullable
    public ExtensionCore QR() {
        if (ProcessUtils.isMainProcess()) {
            return RQ();
        }
        Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null).mResult;
        bundle.setClassLoader(ExtensionCore.class.getClassLoader());
        ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
        if (DEBUG) {
            Log.d("ExtCore-GamesManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            return extensionCore;
        }
        return extensionCore;
    }

    /* loaded from: classes11.dex */
    private static class a extends a.C0258a {
        private a() {
        }

        @Override // com.baidu.swan.apps.extcore.a.C0258a
        protected int Gu() {
            return 1;
        }
    }
}
