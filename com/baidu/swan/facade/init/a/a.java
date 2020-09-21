package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ab;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes3.dex */
public class a implements ab {
    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void abe() {
        aHU();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void abf() {
        aHU();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void abg() {
        aHU();
    }

    private void aHU() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
