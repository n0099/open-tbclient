package com.baidu.swan.facade.requred.webview;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes6.dex */
public final class b {

    /* loaded from: classes6.dex */
    public interface a {
        com.baidu.swan.pms.e.b aim();

        void b(boolean z, com.baidu.swan.apps.core.k.c cVar);

        boolean isNeedDownload();
    }

    public static a aQE() {
        return com.baidu.tieba.aiapps.apps.j.b.bNh();
    }

    public static void aQF() {
        if (ProcessUtils.isMainProcess() && !com.baidu.swan.apps.t.a.axl().aik()) {
            synchronized (SwanAppInitHelper.class) {
                if (SwanAppInitHelper.isDelayInit()) {
                    SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
                }
            }
            com.baidu.swan.apps.t.a.axl().a(true, new com.baidu.swan.apps.core.k.c() { // from class: com.baidu.swan.facade.requred.webview.b.1
                @Override // com.baidu.swan.apps.core.k.c
                public void onSuccess() {
                }

                @Override // com.baidu.swan.apps.core.k.c
                public void onFail() {
                }
            });
        }
    }
}
