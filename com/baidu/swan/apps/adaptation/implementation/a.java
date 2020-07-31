package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes7.dex */
public class a implements com.baidu.swan.apps.adaptation.a.k {
    @Override // com.baidu.swan.apps.adaptation.a.k
    public int Sx() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean Sy() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean Sz() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int SA() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void es(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void dk(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.bM(AppRuntime.getAppContext()).dT(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.bM(AppRuntime.getAppContext()).acX();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(final a.InterfaceC0341a interfaceC0341a) {
        com.baidu.swan.apps.core.k.b.bM(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void SC() {
                if (interfaceC0341a != null) {
                    interfaceC0341a.SC();
                }
                com.baidu.swan.apps.core.k.b.bM(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public VideoPlayerFactory SB() {
        return null;
    }
}
