package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ab;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes8.dex */
public class a implements ab {
    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void akK() {
        aRu();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void akL() {
        aRu();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void akM() {
        aRu();
    }

    private void aRu() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
