package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes9.dex */
public class m extends a {
    public final h dHr;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.dHr = hVar == null ? d.aMh() : hVar;
    }

    public SwanAppProcessInfo aJv() {
        return aMW().aJv();
    }

    public String getAppId() {
        return aMW().getAppId();
    }

    public boolean aJx() {
        return aMW().aJx();
    }

    public boolean aJw() {
        return aMW().aJw();
    }

    public SwanAppCores aJy() {
        return aMW().aJy();
    }

    public int ajl() {
        return aMW().ajl();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aMc() {
        return aMW().aMc();
    }

    public e aMd() {
        return aMW().aMd();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String F(String... strArr) {
        return aMW().F(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aMW().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aMj() {
        return aMW().aMj();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        aMW().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        aMW().w(bVar);
    }

    public void ss(String str) {
        aMW().ss(str);
    }

    public void f(String str, Bundle bundle) {
        aMW().f(str, bundle);
    }

    public void i(i.a aVar) {
        aMW().i(aVar);
    }

    public void aMe() {
        aMW().aMe();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aMf() {
        return aMW().aMf();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aMW().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aMW().k(swanAppActivity);
    }

    public h aMW() {
        return this.dHr;
    }
}
