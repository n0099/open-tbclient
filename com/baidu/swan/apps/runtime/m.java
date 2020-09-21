package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes3.dex */
public class m extends a {
    public final h cSP;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.cSP = hVar == null ? d.aAn() : hVar;
    }

    public SwanAppProcessInfo ayy() {
        return aBc().ayy();
    }

    public String getAppId() {
        return aBc().getAppId();
    }

    public boolean ayA() {
        return aBc().ayA();
    }

    public boolean ayz() {
        return aBc().ayz();
    }

    public SwanAppCores ayB() {
        return aBc().ayB();
    }

    public int Yy() {
        return aBc().Yy();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aAi() {
        return aBc().aAi();
    }

    public e aAj() {
        return aBc().aAj();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String w(String... strArr) {
        return aBc().w(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aBc().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aAp() {
        return aBc().aAp();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aBc().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        aBc().w(bVar);
    }

    public void qA(String str) {
        aBc().qA(str);
    }

    public void f(String str, Bundle bundle) {
        aBc().f(str, bundle);
    }

    public void i(i.a aVar) {
        aBc().i(aVar);
    }

    public void aAk() {
        aBc().aAk();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aAl() {
        return aBc().aAl();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aBc().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aBc().k(swanAppActivity);
    }

    public h aBc() {
        return this.cSP;
    }
}
