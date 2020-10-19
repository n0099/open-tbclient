package com.baidu.swan.facade.requred.webview;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes20.dex */
public final class b {

    /* loaded from: classes16.dex */
    public interface a {
        com.baidu.swan.pms.e.b aeb();

        void b(boolean z, com.baidu.swan.apps.core.k.c cVar);

        boolean isNeedDownload();
    }

    public static a aLm() {
        return com.baidu.tieba.aiapps.apps.j.b.bHm();
    }

    public static void aLn() {
        if (ProcessUtils.isMainProcess() && !com.baidu.swan.apps.t.a.asT().adZ()) {
            synchronized (SwanAppInitHelper.class) {
                if (SwanAppInitHelper.isDelayInit()) {
                    SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
                }
            }
            com.baidu.swan.apps.t.a.asT().a(true, new com.baidu.swan.apps.core.k.c() { // from class: com.baidu.swan.facade.requred.webview.b.1
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
