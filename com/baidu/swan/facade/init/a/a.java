package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.w;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes10.dex */
public class a implements w {
    @Override // com.baidu.swan.apps.adaptation.a.w
    public void Ge() {
        ahc();
    }

    @Override // com.baidu.swan.apps.adaptation.a.w
    public void Gf() {
        ahc();
    }

    @Override // com.baidu.swan.apps.adaptation.a.w
    public void Gg() {
        ahc();
    }

    private void ahc() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
