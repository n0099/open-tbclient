package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes10.dex */
public class m extends a {
    public final h dnx;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.dnx = hVar == null ? d.aEQ() : hVar;
    }

    public SwanAppProcessInfo aDb() {
        return aFF().aDb();
    }

    public String getAppId() {
        return aFF().getAppId();
    }

    public boolean aDd() {
        return aFF().aDd();
    }

    public boolean aDc() {
        return aFF().aDc();
    }

    public SwanAppCores aDe() {
        return aFF().aDe();
    }

    public int ade() {
        return aFF().ade();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aEL() {
        return aFF().aEL();
    }

    public e aEM() {
        return aFF().aEM();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String y(String... strArr) {
        return aFF().y(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aFF().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aES() {
        return aFF().aES();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aFF().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aFF().w(bVar);
    }

    public void rF(String str) {
        aFF().rF(str);
    }

    public void f(String str, Bundle bundle) {
        aFF().f(str, bundle);
    }

    public void i(i.a aVar) {
        aFF().i(aVar);
    }

    public void aEN() {
        aFF().aEN();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aEO() {
        return aFF().aEO();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aFF().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aFF().k(swanAppActivity);
    }

    public h aFF() {
        return this.dnx;
    }
}
