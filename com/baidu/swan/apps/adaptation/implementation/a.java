package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int ajP() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean ajQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean ajR() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int ajS() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void hF(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void eJ(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.cM(AppRuntime.getAppContext()).fv(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.cM(AppRuntime.getAppContext()).avd();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0422a interfaceC0422a) {
        com.baidu.swan.apps.core.k.b.cM(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void ajU() {
                if (interfaceC0422a != null) {
                    interfaceC0422a.ajU();
                }
                com.baidu.swan.apps.core.k.b.cM(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory ajT() {
        return null;
    }
}
