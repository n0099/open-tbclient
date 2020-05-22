package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes11.dex */
public class c extends d {
    public final e czu = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo anc() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean ane() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean and() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores anf() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int Qz() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aow() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e aox() {
        return this.czu;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String w(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aoy() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aoz() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f aoA() {
        return null;
    }
}
