package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ab;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes8.dex */
public class a implements ab {
    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void ahC() {
        aOp();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void ahD() {
        aOp();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void ahE() {
        aOp();
    }

    private void aOp() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
