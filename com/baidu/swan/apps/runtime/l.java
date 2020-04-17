package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes11.dex */
public class l extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h cou;

    public l() {
        this(null);
    }

    public l(h hVar) {
        this.cou = hVar == null ? d.akK() : hVar;
    }

    public SwanAppProcessInfo ajp() {
        return alx().ajp();
    }

    public String getAppId() {
        return alx().getAppId();
    }

    public boolean ajr() {
        return alx().ajr();
    }

    public boolean ajq() {
        return alx().ajq();
    }

    public SwanAppCores ajs() {
        return alx().ajs();
    }

    public int Om() {
        return alx().Om();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a akG() {
        return alx().akG();
    }

    public e akH() {
        return alx().akH();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String v(String... strArr) {
        return alx().v(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void c(Bundle bundle, String str) {
        alx().c(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a akM() {
        return alx().akM();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        alx().e(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        alx().f(bVar);
    }

    public void lX(String str) {
        alx().lX(str);
    }

    public void d(String str, Bundle bundle) {
        alx().d(str, bundle);
    }

    public void d(i.a aVar) {
        alx().d(aVar);
    }

    public void akI() {
        alx().akI();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity akJ() {
        return alx().akJ();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        alx().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        alx().k(swanAppActivity);
    }

    public h alx() {
        return this.cou;
    }
}
