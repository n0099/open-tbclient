package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.j.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.adaptation.a.j {
    @Override // com.baidu.swan.apps.adaptation.a.j
    public int GV() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean GW() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean GX() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public int GY() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void dS(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void GZ() {
        com.baidu.swan.apps.core.j.b.bY(AppRuntime.getAppContext()).GZ();
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void a(final a.InterfaceC0245a interfaceC0245a) {
        com.baidu.swan.apps.core.j.b.bY(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.j.b.a
            public void Hb() {
                if (interfaceC0245a != null) {
                    interfaceC0245a.Hb();
                }
                com.baidu.swan.apps.core.j.b.bY(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public VideoPlayerFactory Ha() {
        return null;
    }
}
