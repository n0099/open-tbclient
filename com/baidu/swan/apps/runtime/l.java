package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes11.dex */
public class l extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h bPv;

    public l() {
        this(null);
    }

    public l(h hVar) {
        this.bPv = hVar == null ? d.acA() : hVar;
    }

    public SwanAppProcessInfo abf() {
        return adn().abf();
    }

    public String getAppId() {
        return adn().getAppId();
    }

    public boolean abh() {
        return adn().abh();
    }

    public boolean abg() {
        return adn().abg();
    }

    public SwanAppCores abi() {
        return adn().abi();
    }

    public int Gs() {
        return adn().Gs();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a acw() {
        return adn().acw();
    }

    public e acx() {
        return adn().acx();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String v(String... strArr) {
        return adn().v(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void c(Bundle bundle, String str) {
        adn().c(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a acC() {
        return adn().acC();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        adn().e(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        adn().f(bVar);
    }

    public void kL(String str) {
        adn().kL(str);
    }

    public void d(String str, Bundle bundle) {
        adn().d(str, bundle);
    }

    public void d(i.a aVar) {
        adn().d(aVar);
    }

    public void acy() {
        adn().acy();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity acz() {
        return adn().acz();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        adn().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        adn().k(swanAppActivity);
    }

    public h adn() {
        return this.bPv;
    }
}
