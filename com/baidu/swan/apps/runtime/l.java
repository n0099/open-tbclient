package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes11.dex */
public class l extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h bPw;

    public l() {
        this(null);
    }

    public l(h hVar) {
        this.bPw = hVar == null ? d.acC() : hVar;
    }

    public SwanAppProcessInfo abh() {
        return adp().abh();
    }

    public String getAppId() {
        return adp().getAppId();
    }

    public boolean abj() {
        return adp().abj();
    }

    public boolean abi() {
        return adp().abi();
    }

    public SwanAppCores abk() {
        return adp().abk();
    }

    public int Gu() {
        return adp().Gu();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a acy() {
        return adp().acy();
    }

    public e acz() {
        return adp().acz();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String v(String... strArr) {
        return adp().v(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void c(Bundle bundle, String str) {
        adp().c(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a acE() {
        return adp().acE();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        adp().e(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        adp().f(bVar);
    }

    public void kL(String str) {
        adp().kL(str);
    }

    public void d(String str, Bundle bundle) {
        adp().d(str, bundle);
    }

    public void d(i.a aVar) {
        adp().d(aVar);
    }

    public void acA() {
        adp().acA();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity acB() {
        return adp().acB();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        adp().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        adp().k(swanAppActivity);
    }

    public h adp() {
        return this.bPw;
    }
}
