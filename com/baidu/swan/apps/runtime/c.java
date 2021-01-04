package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes9.dex */
public class c extends d {
    public final e dGv = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aJu() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aJw() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aJv() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aJx() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int ajk() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aMb() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aMc() {
        return this.dGv;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String F(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aMd() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aMe() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aMf() {
        return null;
    }
}
