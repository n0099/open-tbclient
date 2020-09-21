package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes3.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int Zb() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean Zc() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean Zd() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int Ze() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void gz(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void dr(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.bS(AppRuntime.getAppContext()).ec(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.bS(AppRuntime.getAppContext()).akg();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0377a interfaceC0377a) {
        com.baidu.swan.apps.core.k.b.bS(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void Zg() {
                if (interfaceC0377a != null) {
                    interfaceC0377a.Zg();
                }
                com.baidu.swan.apps.core.k.b.bS(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory Zf() {
        return null;
    }
}
