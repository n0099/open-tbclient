package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes8.dex */
public class m extends a {
    public final h dGk;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.dGk = hVar == null ? d.aIJ() : hVar;
    }

    public SwanAppProcessInfo aFZ() {
        return aJy().aFZ();
    }

    public String getAppId() {
        return aJy().getAppId();
    }

    public boolean aGb() {
        return aJy().aGb();
    }

    public boolean aGa() {
        return aJy().aGa();
    }

    public SwanAppCores aGc() {
        return aJy().aGc();
    }

    public int getFrameType() {
        return aJy().getFrameType();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aIE() {
        return aJy().aIE();
    }

    public e aIF() {
        return aJy().aIF();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String F(String... strArr) {
        return aJy().F(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aJy().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aIL() {
        return aJy().aIL();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        aJy().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        aJy().w(bVar);
    }

    public void rG(String str) {
        aJy().rG(str);
    }

    public void g(String str, Bundle bundle) {
        aJy().g(str, bundle);
    }

    public void i(i.a aVar) {
        aJy().i(aVar);
    }

    public void aIG() {
        aJy().aIG();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aIH() {
        return aJy().aIH();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aJy().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aJy().k(swanAppActivity);
    }

    public h aJy() {
        return this.dGk;
    }
}
