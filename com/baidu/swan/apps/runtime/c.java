package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes8.dex */
public class c extends d {
    public final e dBJ = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aFB() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aFD() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aFC() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aFE() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int afr() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aIi() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aIj() {
        return this.dBJ;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String F(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aIk() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aIl() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aIm() {
        return null;
    }
}
