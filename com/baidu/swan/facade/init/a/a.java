package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ab;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes6.dex */
public class a implements ab {
    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void aib() {
        aPW();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void aic() {
        aPW();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void aid() {
        aPW();
    }

    private void aPW() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
