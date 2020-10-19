package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes10.dex */
public class c extends d {
    public final e deb = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aBh() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aBj() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aBi() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aBk() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int abk() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aCR() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aCS() {
        return this.deb;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String x(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aCT() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aCU() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aCV() {
        return null;
    }
}
