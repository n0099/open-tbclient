package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes8.dex */
public class c extends d {
    public final e cPQ = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo axP() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean axR() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean axQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores axS() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int XP() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a azz() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e azA() {
        return this.cPQ;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String w(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void azB() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity azC() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f azD() {
        return null;
    }
}
