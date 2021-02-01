package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int agu() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean agv() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean agw() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int agx() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void gb(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void eH(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.cK(AppRuntime.getAppContext()).ft(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.cK(AppRuntime.getAppContext()).arH();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0402a interfaceC0402a) {
        com.baidu.swan.apps.core.k.b.cK(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void agz() {
                if (interfaceC0402a != null) {
                    interfaceC0402a.agz();
                }
                com.baidu.swan.apps.core.k.b.cK(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory agy() {
        return null;
    }
}
