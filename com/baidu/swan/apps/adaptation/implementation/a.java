package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int abN() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean abO() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean abP() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int abQ() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void gW(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void dN(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).ey(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).amR();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0394a interfaceC0394a) {
        com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void abS() {
                if (interfaceC0394a != null) {
                    interfaceC0394a.abS();
                }
                com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory abR() {
        return null;
    }
}
