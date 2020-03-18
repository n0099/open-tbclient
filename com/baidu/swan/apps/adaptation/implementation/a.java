package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.j.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.adaptation.a.j {
    @Override // com.baidu.swan.apps.adaptation.a.j
    public int Hc() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean Hd() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean He() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public int Hf() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void dS(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void Hg() {
        com.baidu.swan.apps.core.j.b.bX(AppRuntime.getAppContext()).Hg();
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void a(final a.InterfaceC0245a interfaceC0245a) {
        com.baidu.swan.apps.core.j.b.bX(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.j.b.a
            public void Hi() {
                if (interfaceC0245a != null) {
                    interfaceC0245a.Hi();
                }
                com.baidu.swan.apps.core.j.b.bX(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public VideoPlayerFactory Hh() {
        return null;
    }
}
