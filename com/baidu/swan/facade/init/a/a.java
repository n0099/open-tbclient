package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.w;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes9.dex */
public class a implements w {
    @Override // com.baidu.swan.apps.adaptation.a.w
    public void FI() {
        agJ();
    }

    @Override // com.baidu.swan.apps.adaptation.a.w
    public void FJ() {
        agJ();
    }

    @Override // com.baidu.swan.apps.adaptation.a.w
    public void FK() {
        agJ();
    }

    private void agJ() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
