package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes25.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int aiH() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean aiI() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean aiJ() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int aiK() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void hL(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void eB(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.cE(AppRuntime.getAppContext()).fm(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.cE(AppRuntime.getAppContext()).atM();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0430a interfaceC0430a) {
        com.baidu.swan.apps.core.k.b.cE(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void aiM() {
                if (interfaceC0430a != null) {
                    interfaceC0430a.aiM();
                }
                com.baidu.swan.apps.core.k.b.cE(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory aiL() {
        return null;
    }
}
