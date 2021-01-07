package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ab;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes6.dex */
public class a implements ab {
    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void alV() {
        aTQ();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void alW() {
        aTQ();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void alX() {
        aTQ();
    }

    private void aTQ() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
