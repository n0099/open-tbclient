package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.j.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.adaptation.a.j {
    @Override // com.baidu.swan.apps.adaptation.a.j
    public int EG() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean EH() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean EI() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public int EJ() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void dC(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void EK() {
        com.baidu.swan.apps.core.j.b.bU(AppRuntime.getAppContext()).EK();
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void a(final a.InterfaceC0235a interfaceC0235a) {
        com.baidu.swan.apps.core.j.b.bU(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.j.b.a
            public void EM() {
                if (interfaceC0235a != null) {
                    interfaceC0235a.EM();
                }
                com.baidu.swan.apps.core.j.b.bU(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public VideoPlayerFactory EL() {
        return null;
    }
}
