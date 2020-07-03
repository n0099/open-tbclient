package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.y;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes11.dex */
public class a implements y {
    @Override // com.baidu.swan.apps.adaptation.a.y
    public void TT() {
        awr();
    }

    @Override // com.baidu.swan.apps.adaptation.a.y
    public void TU() {
        awr();
    }

    @Override // com.baidu.swan.apps.adaptation.a.y
    public void TV() {
        awr();
    }

    private void awr() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
