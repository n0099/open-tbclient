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
        this.dHr = hVar == null ? d.aMg() : hVar;
    }

    public SwanAppProcessInfo aJu() {
        return aMV().aJu();
    }

    public String getAppId() {
        return aMV().getAppId();
    }

    public boolean aJw() {
        return aMV().aJw();
    }

    public boolean aJv() {
        return aMV().aJv();
    }

    public SwanAppCores aJx() {
        return aMV().aJx();
    }

    public int ajk() {
        return aMV().ajk();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a aMb() {
        return aMV().aMb();
    }

    public e aMc() {
        return aMV().aMc();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String F(String... strArr) {
        return aMV().F(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(Bundle bundle, String str) {
        aMV().e(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aMi() {
        return aMV().aMi();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        aMV().v(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        aMV().w(bVar);
    }

    public void ss(String str) {
        aMV().ss(str);
    }

    public void f(String str, Bundle bundle) {
        aMV().f(str, bundle);
    }

    public void i(i.a aVar) {
        aMV().i(aVar);
    }

    public void aMd() {
        aMV().aMd();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity aMe() {
        return aMV().aMe();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aMV().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aMV().k(swanAppActivity);
    }

    public h aMV() {
        return this.dHr;
    }
}
