package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes10.dex */
public class m extends a {
    public final h dtu;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.dtu = hVar == null ? d.aHq() : hVar;
    }

    public SwanAppProcessInfo aFB() {
        return aIf().aFB();
    }

    public String getAppId() {
        return aIf().getAppId();
    }

    public boolean aFD() {
        return aIf().aFD();
    }

    public boolean aFC() {
        return aIf().aFC();
    }

    public SwanAppCores aFE() {
        return aIf().aFE();
    }

    public int afE() {
        return aIf().afE();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aHl() {
        return aIf().aHl();
    }

    public e aHm() {
        return aIf().aHm();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String y(String... strArr) {
        return aIf().y(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aIf().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aHs() {
        return aIf().aHs();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aIf().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aIf().w(bVar);
    }

    public void rT(String str) {
        aIf().rT(str);
    }

    public void f(String str, Bundle bundle) {
        aIf().f(str, bundle);
    }

    public void i(i.a aVar) {
        aIf().i(aVar);
    }

    public void aHn() {
        aIf().aHn();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aHo() {
        return aIf().aHo();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aIf().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aIf().k(swanAppActivity);
    }

    public h aIf() {
        return this.dtu;
    }
}
