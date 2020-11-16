package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes7.dex */
public class m extends a {
    public final h drL;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.drL = hVar == null ? d.aGI() : hVar;
    }

    public SwanAppProcessInfo aET() {
        return aHx().aET();
    }

    public String getAppId() {
        return aHx().getAppId();
    }

    public boolean aEV() {
        return aHx().aEV();
    }

    public boolean aEU() {
        return aHx().aEU();
    }

    public SwanAppCores aEW() {
        return aHx().aEW();
    }

    public int aeW() {
        return aHx().aeW();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aGD() {
        return aHx().aGD();
    }

    public e aGE() {
        return aHx().aGE();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String y(String... strArr) {
        return aHx().y(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aHx().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aGK() {
        return aHx().aGK();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aHx().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aHx().w(bVar);
    }

    public void rN(String str) {
        aHx().rN(str);
    }

    public void f(String str, Bundle bundle) {
        aHx().f(str, bundle);
    }

    public void i(i.a aVar) {
        aHx().i(aVar);
    }

    public void aGF() {
        aHx().aGF();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aGG() {
        return aHx().aGG();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aHx().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aHx().k(swanAppActivity);
    }

    public h aHx() {
        return this.drL;
    }
}
