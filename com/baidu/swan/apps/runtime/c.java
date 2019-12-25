package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes9.dex */
public final class c extends d {
    public final e bJW = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo Yu() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean Yw() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean Yv() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores Yx() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int DH() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a ZL() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e ZM() {
        return this.bJW;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String r(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void c(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void ZN() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity ZO() {
        return null;
    }
}
