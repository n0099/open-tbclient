package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes9.dex */
public class c extends d {
    public final e dDN = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aFW() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aFY() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aFX() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aFZ() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int getFrameType() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aIB() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aIC() {
        return this.dDN;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String F(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aID() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aIE() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aIF() {
        return null;
    }
}
