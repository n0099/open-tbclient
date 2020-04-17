package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.w;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes11.dex */
public class a implements w {
    @Override // com.baidu.swan.apps.adaptation.a.w
    public void Qk() {
        arD();
    }

    @Override // com.baidu.swan.apps.adaptation.a.w
    public void Ql() {
        arD();
    }

    @Override // com.baidu.swan.apps.adaptation.a.w
    public void Qm() {
        arD();
    }

    private void arD() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
