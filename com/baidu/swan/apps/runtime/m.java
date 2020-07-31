package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes7.dex */
public class m extends a {
    public final h cHM;

    public m() {
        this(null);
    }

    public m(h hVar) {
        this.cHM = hVar == null ? d.arr() : hVar;
    }

    public SwanAppProcessInfo apS() {
        return asg().apS();
    }

    public String getAppId() {
        return asg().getAppId();
    }

    public boolean apU() {
        return asg().apU();
    }

    public boolean apT() {
        return asg().apT();
    }

    public SwanAppCores apV() {
        return asg().apV();
    }

    public int RU() {
        return asg().RU();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.process.messaging.client.a arm() {
        return asg().arm();
    }

    public e arn() {
        return asg().arn();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public String v(String... strArr) {
        return asg().v(strArr);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(Bundle bundle, String str) {
        asg().d(bundle, str);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a art() {
        return asg().art();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void o(com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        asg().o(bVar);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void p(com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        asg().p(bVar);
    }

    public void oi(String str) {
        asg().oi(str);
    }

    public void g(String str, Bundle bundle) {
        asg().g(str, bundle);
    }

    public void i(i.a aVar) {
        asg().i(aVar);
    }

    public void aro() {
        asg().aro();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public SwanAppActivity arp() {
        return asg().arp();
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void j(SwanAppActivity swanAppActivity) {
        asg().j(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void k(SwanAppActivity swanAppActivity) {
        asg().k(swanAppActivity);
    }

    public h asg() {
        return this.cHM;
    }
}
