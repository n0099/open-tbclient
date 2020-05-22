package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.adaptation.a.k {
    @Override // com.baidu.swan.apps.adaptation.a.k
    public int Ra() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean Rb() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean Rc() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int Rd() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void ed(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void dc(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.bI(AppRuntime.getAppContext()).dK(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.bI(AppRuntime.getAppContext()).aaN();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(final a.InterfaceC0333a interfaceC0333a) {
        com.baidu.swan.apps.core.k.b.bI(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void Rf() {
                if (interfaceC0333a != null) {
                    interfaceC0333a.Rf();
                }
                com.baidu.swan.apps.core.k.b.bI(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public VideoPlayerFactory Re() {
        return null;
    }
}
