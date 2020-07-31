package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes7.dex */
public class c extends d {
    public final e cGR = new e(this, "");

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppProcessInfo apS() {
        return SwanAppProcessInfo.current();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String getAppId() {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean apU() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public boolean apT() {
        return false;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppCores apV() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public int RU() {
        return -1;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a arm() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public e arn() {
        return this.cGR;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String v(String... strArr) {
        return "";
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(Bundle bundle, String str) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void aro() {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity arp() {
        return null;
    }

    @Override // com.baidu.swan.apps.runtime.d
    protected com.baidu.swan.pms.c.f arq() {
        return null;
    }
}
