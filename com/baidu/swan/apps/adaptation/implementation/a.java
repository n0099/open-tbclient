package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int adH() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean adI() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean adJ() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int adK() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void hh(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void ea(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).eL(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).aoL();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0408a interfaceC0408a) {
        com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void adM() {
                if (interfaceC0408a != null) {
                    interfaceC0408a.adM();
                }
                com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory adL() {
        return null;
    }
}
