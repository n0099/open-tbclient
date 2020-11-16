package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes7.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int afz() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean afA() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean afB() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int afC() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void hn(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void em(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).eX(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).aqE();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0418a interfaceC0418a) {
        com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void afE() {
                if (interfaceC0418a != null) {
                    interfaceC0418a.afE();
                }
                com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory afD() {
        return null;
    }
}
