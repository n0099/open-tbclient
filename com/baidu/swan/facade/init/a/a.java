package com.baidu.swan.facade.init.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.y;
import com.baidu.swan.facade.init.SwanAppInitHelper;
/* loaded from: classes4.dex */
public class a implements y {
    @Override // com.baidu.swan.apps.adaptation.a.y
    public void Ut() {
        azf();
    }

    @Override // com.baidu.swan.apps.adaptation.a.y
    public void Uu() {
        azf();
    }

    @Override // com.baidu.swan.apps.adaptation.a.y
    public void Uv() {
        azf();
    }

    private void azf() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
