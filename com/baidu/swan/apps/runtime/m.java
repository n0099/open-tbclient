package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes8.dex */
public class m extends a {
    public final h cQL;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.cQL = hVar == null ? d.azE() : hVar;
    }

    public SwanAppProcessInfo axP() {
        return aAt().axP();
    }

    public String getAppId() {
        return aAt().getAppId();
    }

    public boolean axR() {
        return aAt().axR();
    }

    public boolean axQ() {
        return aAt().axQ();
    }

    public SwanAppCores axS() {
        return aAt().axS();
    }

    public int XP() {
        return aAt().XP();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a azz() {
        return aAt().azz();
    }

    public e azA() {
        return aAt().azA();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String w(String... strArr) {
        return aAt().w(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aAt().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a azG() {
        return aAt().azG();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aAt().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aAt().w(bVar);
    }

    public void qg(String str) {
        aAt().qg(str);
    }

    public void f(String str, Bundle bundle) {
        aAt().f(str, bundle);
    }

    public void i(i.a aVar) {
        aAt().i(aVar);
    }

    public void azB() {
        aAt().azB();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity azC() {
        return aAt().azC();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aAt().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aAt().k(swanAppActivity);
    }

    public h aAt() {
        return this.cQL;
    }
}
