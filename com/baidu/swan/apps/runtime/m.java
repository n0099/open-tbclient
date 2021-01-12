package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes8.dex */
public class m extends a {
    public final h dCF;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.dCF = hVar == null ? d.aIn() : hVar;
    }

    public SwanAppProcessInfo aFB() {
        return aJc().aFB();
    }

    public String getAppId() {
        return aJc().getAppId();
    }

    public boolean aFD() {
        return aJc().aFD();
    }

    public boolean aFC() {
        return aJc().aFC();
    }

    public SwanAppCores aFE() {
        return aJc().aFE();
    }

    public int afr() {
        return aJc().afr();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aIi() {
        return aJc().aIi();
    }

    public e aIj() {
        return aJc().aIj();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String F(String... strArr) {
        return aJc().F(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aJc().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aIp() {
        return aJc().aIp();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        aJc().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        aJc().w(bVar);
    }

    public void rg(String str) {
        aJc().rg(str);
    }

    public void g(String str, Bundle bundle) {
        aJc().g(str, bundle);
    }

    public void i(i.a aVar) {
        aJc().i(aVar);
    }

    public void aIk() {
        aJc().aIk();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aIl() {
        return aJc().aIl();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aJc().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aJc().k(swanAppActivity);
    }

    public h aJc() {
        return this.dCF;
    }
}
