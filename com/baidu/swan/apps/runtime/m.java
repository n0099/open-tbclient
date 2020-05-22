package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes11.dex */
public class m extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h cAm;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.cAm = hVar == null ? d.aoB() : hVar;
    }

    public SwanAppProcessInfo anc() {
        return apt().anc();
    }

    public String getAppId() {
        return apt().getAppId();
    }

    public boolean ane() {
        return apt().ane();
    }

    public boolean and() {
        return apt().and();
    }

    public SwanAppCores anf() {
        return apt().anf();
    }

    public int Qz() {
        return apt().Qz();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aow() {
        return apt().aow();
    }

    public e aox() {
        return apt().aox();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String w(String... strArr) {
        return apt().w(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(Bundle bundle, String str) {
        apt().d(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aoD() {
        return apt().aoD();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void n(com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        apt().n(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void o(com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        apt().o(bVar);
    }

    public void ns(String str) {
        apt().ns(str);
    }

    public void g(String str, Bundle bundle) {
        apt().g(str, bundle);
    }

    public void i(i.a aVar) {
        apt().i(aVar);
    }

    public void aoy() {
        apt().aoy();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aoz() {
        return apt().aoz();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(SwanAppActivity swanAppActivity) {
        apt().i(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        apt().j(swanAppActivity);
    }

    public h apt() {
        return this.cAm;
    }
}
