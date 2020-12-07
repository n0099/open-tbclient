package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes25.dex */
public class m extends a {
    public final h dyM;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.dyM = hVar == null ? d.aJQ() : hVar;
    }

    public SwanAppProcessInfo aIb() {
        return aKF().aIb();
    }

    public String getAppId() {
        return aKF().getAppId();
    }

    public boolean aId() {
        return aKF().aId();
    }

    public boolean aIc() {
        return aKF().aIc();
    }

    public SwanAppCores aIe() {
        return aKF().aIe();
    }

    public int aie() {
        return aKF().aie();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aJL() {
        return aKF().aJL();
    }

    public e aJM() {
        return aKF().aJM();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String y(String... strArr) {
        return aKF().y(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aKF().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aJS() {
        return aKF().aJS();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aKF().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aKF().w(bVar);
    }

    public void sv(String str) {
        aKF().sv(str);
    }

    public void f(String str, Bundle bundle) {
        aKF().f(str, bundle);
    }

    public void i(i.a aVar) {
        aKF().i(aVar);
    }

    public void aJN() {
        aKF().aJN();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aJO() {
        return aKF().aJO();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aKF().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aKF().k(swanAppActivity);
    }

    public h aKF() {
        return this.dyM;
    }
}
