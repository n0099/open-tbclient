package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes10.dex */
public class c extends d {
    public final e dsy = new e(this, "");

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
    public int afE() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aHl() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aHm() {
        return this.dsy;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String y(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aHn() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aHo() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aHp() {
        return null;
    }
}
