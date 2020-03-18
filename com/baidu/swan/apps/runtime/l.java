package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes11.dex */
public class l extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h bPI;

    public l() {
        this(null);
    }

    public l(h hVar) {
        this.bPI = hVar == null ? d.acF() : hVar;
    }

    public SwanAppProcessInfo abk() {
        return ads().abk();
    }

    public String getAppId() {
        return ads().getAppId();
    }

    public boolean abm() {
        return ads().abm();
    }

    public boolean abl() {
        return ads().abl();
    }

    public SwanAppCores abn() {
        return ads().abn();
    }

    public int Gz() {
        return ads().Gz();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a acB() {
        return ads().acB();
    }

    public e acC() {
        return ads().acC();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String v(String... strArr) {
        return ads().v(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void c(Bundle bundle, String str) {
        ads().c(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a acH() {
        return ads().acH();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        ads().e(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        ads().f(bVar);
    }

    public void kK(String str) {
        ads().kK(str);
    }

    public void d(String str, Bundle bundle) {
        ads().d(str, bundle);
    }

    public void d(i.a aVar) {
        ads().d(aVar);
    }

    public void acD() {
        ads().acD();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity acE() {
        return ads().acE();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        ads().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        ads().k(swanAppActivity);
    }

    public h ads() {
        return this.bPI;
    }
}
