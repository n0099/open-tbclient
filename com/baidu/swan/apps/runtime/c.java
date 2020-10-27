package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes10.dex */
public class c extends d {
    public final e dmB = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo aDb() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aDd() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean aDc() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores aDe() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int ade() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aEL() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aEM() {
        return this.dmB;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String y(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aEN() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aEO() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aEP() {
        return null;
    }
}
