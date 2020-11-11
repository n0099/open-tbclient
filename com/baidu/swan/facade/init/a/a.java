package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.ab;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes16.dex */
public class a implements ab {
    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void aik() {
        aOX();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void ail() {
        aOX();
    }

    @Override // com.baidu.swan.apps.adaptation.a.ab
    public void aim() {
        aOX();
    }

    private void aOX() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
