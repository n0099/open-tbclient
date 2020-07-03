package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes11.dex */
public class m extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h cEW;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.cEW = hVar == null ? d.apI() : hVar;
    }

    public SwanAppProcessInfo aoi() {
        return aqz().aoi();
    }

    public String getAppId() {
        return aqz().getAppId();
    }

    public boolean aok() {
        return aqz().aok();
    }

    public boolean aoj() {
        return aqz().aoj();
    }

    public SwanAppCores aol() {
        return aqz().aol();
    }

    public int RF() {
        return aqz().RF();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a apD() {
        return aqz().apD();
    }

    public e apE() {
        return aqz().apE();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String v(String... strArr) {
        return aqz().v(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(Bundle bundle, String str) {
        aqz().d(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a apK() {
        return aqz().apK();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void n(com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        aqz().n(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void o(com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        aqz().o(bVar);
    }

    public void nA(String str) {
        aqz().nA(str);
    }

    public void g(String str, Bundle bundle) {
        aqz().g(str, bundle);
    }

    public void i(i.a aVar) {
        aqz().i(aVar);
    }

    public void apF() {
        aqz().apF();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity apG() {
        return aqz().apG();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(SwanAppActivity swanAppActivity) {
        aqz().i(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aqz().j(swanAppActivity);
    }

    public h aqz() {
        return this.cEW;
    }
}
