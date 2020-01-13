package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes10.dex */
public class l extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h bLq;

    public l() {
        this(null);
    }

    public l(h hVar) {
        this.bLq = hVar == null ? d.aam() : hVar;
    }

    public SwanAppProcessInfo YR() {
        return aaZ().YR();
    }

    public String getAppId() {
        return aaZ().getAppId();
    }

    public boolean YT() {
        return aaZ().YT();
    }

    public boolean YS() {
        return aaZ().YS();
    }

    public SwanAppCores YU() {
        return aaZ().YU();
    }

    public int Ed() {
        return aaZ().Ed();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aai() {
        return aaZ().aai();
    }

    public e aaj() {
        return aaZ().aaj();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String r(String... strArr) {
        return aaZ().r(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void c(Bundle bundle, String str) {
        aaZ().c(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aao() {
        return aaZ().aao();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        aaZ().e(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        aaZ().f(bVar);
    }

    public void kw(String str) {
        aaZ().kw(str);
    }

    public void d(String str, Bundle bundle) {
        aaZ().d(str, bundle);
    }

    public void d(i.a aVar) {
        aaZ().d(aVar);
    }

    public void aak() {
        aaZ().aak();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aal() {
        return aaZ().aal();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aaZ().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aaZ().k(swanAppActivity);
    }

    public h aaZ() {
        return this.bLq;
    }
}
