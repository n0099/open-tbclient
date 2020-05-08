package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes11.dex */
public final class c extends d {
    public final e cnQ = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo ajo() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean ajq() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean ajp() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores ajr() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int Ol() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a akF() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e akG() {
        return this.cnQ;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String v(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void c(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void akH() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity akI() {
        return null;
    }
}
