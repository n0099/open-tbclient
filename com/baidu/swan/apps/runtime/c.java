package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes10.dex */
public final class c extends d {
    public final e bKG = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo YR() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean YT() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean YS() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores YU() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int Ed() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aai() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aaj() {
        return this.bKG;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String r(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void c(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aak() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aal() {
        return null;
    }
}
