package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.j.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.adaptation.a.j {
    @Override // com.baidu.swan.apps.adaptation.a.j
    public int OP() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean OQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean OR() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public int OS() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void dX(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void OT() {
        com.baidu.swan.apps.core.j.b.bL(AppRuntime.getAppContext()).OT();
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void a(final a.InterfaceC0275a interfaceC0275a) {
        com.baidu.swan.apps.core.j.b.bL(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.j.b.a
            public void OV() {
                if (interfaceC0275a != null) {
                    interfaceC0275a.OV();
                }
                com.baidu.swan.apps.core.j.b.bL(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public VideoPlayerFactory OU() {
        return null;
    }
}
