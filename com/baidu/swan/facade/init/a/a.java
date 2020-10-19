package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ab;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes16.dex */
public class a implements ab {
    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void adQ() {
        aKD();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void adR() {
        aKD();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void adS() {
        aKD();
    }

    private void aKD() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
