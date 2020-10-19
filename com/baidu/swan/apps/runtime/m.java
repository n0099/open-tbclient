package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes10.dex */
public class m extends a {
    public final h deX;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.deX = hVar == null ? d.aCW() : hVar;
    }

    public SwanAppProcessInfo aBh() {
        return aDL().aBh();
    }

    public String getAppId() {
        return aDL().getAppId();
    }

    public boolean aBj() {
        return aDL().aBj();
    }

    public boolean aBi() {
        return aDL().aBi();
    }

    public SwanAppCores aBk() {
        return aDL().aBk();
    }

    public int abk() {
        return aDL().abk();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aCR() {
        return aDL().aCR();
    }

    public e aCS() {
        return aDL().aCS();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String x(String... strArr) {
        return aDL().x(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aDL().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aCY() {
        return aDL().aCY();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aDL().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aDL().w(bVar);
    }

    public void rm(String str) {
        aDL().rm(str);
    }

    public void f(String str, Bundle bundle) {
        aDL().f(str, bundle);
    }

    public void i(i.a aVar) {
        aDL().i(aVar);
    }

    public void aCT() {
        aDL().aCT();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aCU() {
        return aDL().aCU();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aDL().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aDL().k(swanAppActivity);
    }

    public h aDL() {
        return this.deX;
    }
}
