package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes9.dex */
public class m extends a {
    public final h dEJ;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.dEJ = hVar == null ? d.aIG() : hVar;
    }

    public SwanAppProcessInfo aFW() {
        return aJv().aFW();
    }

    public String getAppId() {
        return aJv().getAppId();
    }

    public boolean aFY() {
        return aJv().aFY();
    }

    public boolean aFX() {
        return aJv().aFX();
    }

    public SwanAppCores aFZ() {
        return aJv().aFZ();
    }

    public int getFrameType() {
        return aJv().getFrameType();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aIB() {
        return aJv().aIB();
    }

    public e aIC() {
        return aJv().aIC();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String F(String... strArr) {
        return aJv().F(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aJv().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aII() {
        return aJv().aII();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        aJv().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        aJv().w(bVar);
    }

    public void rz(String str) {
        aJv().rz(str);
    }

    public void g(String str, Bundle bundle) {
        aJv().g(str, bundle);
    }

    public void i(i.a aVar) {
        aJv().i(aVar);
    }

    public void aID() {
        aJv().aID();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aIE() {
        return aJv().aIE();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aJv().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aJv().k(swanAppActivity);
    }

    public h aJv() {
        return this.dEJ;
    }
}
