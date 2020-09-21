package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes3.dex */
public class c extends d {
    public final e cRU = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo ayy() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean ayA() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean ayz() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores ayB() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int Yy() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aAi() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aAj() {
        return this.cRU;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String w(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aAk() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aAl() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aAm() {
        return null;
    }
}
