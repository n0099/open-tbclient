package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes11.dex */
public class l extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h coA;

    public l() {
        this(null);
    }

    public l(h hVar) {
        this.coA = hVar == null ? d.akJ() : hVar;
    }

    public SwanAppProcessInfo ajo() {
        return alw().ajo();
    }

    public String getAppId() {
        return alw().getAppId();
    }

    public boolean ajq() {
        return alw().ajq();
    }

    public boolean ajp() {
        return alw().ajp();
    }

    public SwanAppCores ajr() {
        return alw().ajr();
    }

    public int Ol() {
        return alw().Ol();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a akF() {
        return alw().akF();
    }

    public e akG() {
        return alw().akG();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String v(String... strArr) {
        return alw().v(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void c(Bundle bundle, String str) {
        alw().c(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a akL() {
        return alw().akL();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        alw().e(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        alw().f(bVar);
    }

    public void lX(String str) {
        alw().lX(str);
    }

    public void d(String str, Bundle bundle) {
        alw().d(str, bundle);
    }

    public void d(i.a aVar) {
        alw().d(aVar);
    }

    public void akH() {
        alw().akH();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity akI() {
        return alw().akI();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        alw().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        alw().k(swanAppActivity);
    }

    public h alw() {
        return this.coA;
    }
}
