package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes25.dex */
public class c extends d {
    public final e dxQ = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aIb() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aId() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aIc() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aIe() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int aie() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aJL() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aJM() {
        return this.dxQ;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String y(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aJN() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aJO() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aJP() {
        return null;
    }
}
