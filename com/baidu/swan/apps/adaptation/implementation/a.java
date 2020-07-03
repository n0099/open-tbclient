package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.adaptation.a.k {
    @Override // com.baidu.swan.apps.adaptation.a.k
    public int Sg() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean Sh() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public boolean Si() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public int Sj() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void eq(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void dh(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.bJ(AppRuntime.getAppContext()).dP(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.bJ(AppRuntime.getAppContext()).abT();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public void a(final a.InterfaceC0339a interfaceC0339a) {
        com.baidu.swan.apps.core.k.b.bJ(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void Sl() {
                if (interfaceC0339a != null) {
                    interfaceC0339a.Sl();
                }
                com.baidu.swan.apps.core.k.b.bJ(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.k
    public VideoPlayerFactory Sk() {
        return null;
    }
}
