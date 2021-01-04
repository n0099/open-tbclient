package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ab;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes6.dex */
public class a implements ab {
    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void alU() {
        aTP();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void alV() {
        aTP();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void alW() {
        aTP();
    }

    private void aTP() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
