package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes11.dex */
public class c extends d {
    public final e cEe = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aoi() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aok() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aoj() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aol() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int RF() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a apD() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e apE() {
        return this.cEe;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String v(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void apF() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity apG() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f apH() {
        return null;
    }
}
