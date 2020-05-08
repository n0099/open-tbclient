package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.j.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.adaptation.a.j {
    @Override // com.baidu.swan.apps.adaptation.a.j
    public int OO() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean OP() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean OQ() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public int OR() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void dX(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void OS() {
        com.baidu.swan.apps.core.j.b.bz(AppRuntime.getAppContext()).OS();
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void a(final a.InterfaceC0296a interfaceC0296a) {
        com.baidu.swan.apps.core.j.b.bz(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.j.b.a
            public void OU() {
                if (interfaceC0296a != null) {
                    interfaceC0296a.OU();
                }
                com.baidu.swan.apps.core.j.b.bz(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public VideoPlayerFactory OT() {
        return null;
    }
}
