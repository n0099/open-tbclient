package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int afW() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean afX() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean afY() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int afZ() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void fY(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void eF(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.cL(AppRuntime.getAppContext()).fr(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.cL(AppRuntime.getAppContext()).arj();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0405a interfaceC0405a) {
        com.baidu.swan.apps.core.k.b.cL(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void agb() {
                if (interfaceC0405a != null) {
                    interfaceC0405a.agb();
                }
                com.baidu.swan.apps.core.k.b.cL(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory aga() {
        return null;
    }
}
