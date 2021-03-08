package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes8.dex */
public class c extends d {
    public final e dFo = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aFZ() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aGb() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aGa() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aGc() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int getFrameType() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aIE() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aIF() {
        return this.dFo;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String F(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aIG() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aIH() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aII() {
        return null;
    }
}
