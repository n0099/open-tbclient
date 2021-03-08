package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int agx() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean agy() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean agz() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int agA() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void gc(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void eH(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.cJ(AppRuntime.getAppContext()).ft(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.cJ(AppRuntime.getAppContext()).arK();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0408a interfaceC0408a) {
        com.baidu.swan.apps.core.k.b.cJ(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void agC() {
                if (interfaceC0408a != null) {
                    interfaceC0408a.agC();
                }
                com.baidu.swan.apps.core.k.b.cJ(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory agB() {
        return null;
    }
}
