package com.baidu.swan.apps.extcore;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.extcore.b.b<com.baidu.swan.games.h.c.a, com.baidu.swan.games.h.d.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c dba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aut() {
        if (dba == null) {
            synchronized (c.class) {
                if (dba == null) {
                    dba = new c();
                }
            }
        }
        return dba;
    }

    private c() {
        super(new com.baidu.swan.games.h.c.a(), new com.baidu.swan.games.h.d.a());
    }

    @Override // com.baidu.swan.apps.extcore.b.b
    @Nullable
    public ExtensionCore asB() {
        if (ProcessUtils.isMainProcess()) {
            return auy();
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

    /* loaded from: classes9.dex */
    private static class a extends a.C0422a {
        private a() {
        }

        @Override // com.baidu.swan.apps.extcore.a.C0422a
        protected int getFrameType() {
            return 1;
        }
    }
}
