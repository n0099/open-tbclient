package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ab;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes16.dex */
public class a implements ab {
    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void afK() {
        aMx();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void afL() {
        aMx();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void afM() {
        aMx();
    }

    private void aMx() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
