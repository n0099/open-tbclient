package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.j.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.adaptation.a.j {
    @Override // com.baidu.swan.apps.adaptation.a.j
    public int GX() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean GY() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean GZ() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public int Ha() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void dS(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void Hb() {
        com.baidu.swan.apps.core.j.b.bY(AppRuntime.getAppContext()).Hb();
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void a(final a.InterfaceC0245a interfaceC0245a) {
        com.baidu.swan.apps.core.j.b.bY(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.j.b.a
            public void Hd() {
                if (interfaceC0245a != null) {
                    interfaceC0245a.Hd();
                }
                com.baidu.swan.apps.core.j.b.bY(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public VideoPlayerFactory Hc() {
        return null;
    }
}
