package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes9.dex */
public class l extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h bKG;

    public l() {
        this(null);
    }

    public l(h hVar) {
        this.bKG = hVar == null ? d.ZP() : hVar;
    }

    public SwanAppProcessInfo Yu() {
        return aaC().Yu();
    }

    public String getAppId() {
        return aaC().getAppId();
    }

    public boolean Yw() {
        return aaC().Yw();
    }

    public boolean Yv() {
        return aaC().Yv();
    }

    public SwanAppCores Yx() {
        return aaC().Yx();
    }

    public int DH() {
        return aaC().DH();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a ZL() {
        return aaC().ZL();
    }

    public e ZM() {
        return aaC().ZM();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String r(String... strArr) {
        return aaC().r(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void c(Bundle bundle, String str) {
        aaC().c(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a ZR() {
        return aaC().ZR();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        aaC().e(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        aaC().f(bVar);
    }

    public void kt(String str) {
        aaC().kt(str);
    }

    public void d(String str, Bundle bundle) {
        aaC().d(str, bundle);
    }

    public void d(i.a aVar) {
        aaC().d(aVar);
    }

    public void ZN() {
        aaC().ZN();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity ZO() {
        return aaC().ZO();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        aaC().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        aaC().k(swanAppActivity);
    }

    public h aaC() {
        return this.bKG;
    }
}
