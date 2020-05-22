package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.y;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes11.dex */
public class a implements y {
    @Override // com.baidu.swan.apps.adaptation.a.y
    public void SN() {
        avl();
    }

    @Override // com.baidu.swan.apps.adaptation.a.y
    public void SO() {
        avl();
    }

    @Override // com.baidu.swan.apps.adaptation.a.y
    public void SP() {
        avl();
    }

    private void avl() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
