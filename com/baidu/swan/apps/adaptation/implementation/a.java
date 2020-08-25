package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int Ys() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean Yt() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean Yu() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int Yv() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void gq(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void ds(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.bT(AppRuntime.getAppContext()).ed(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.bT(AppRuntime.getAppContext()).ajw();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0382a interfaceC0382a) {
        com.baidu.swan.apps.core.k.b.bT(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void Yx() {
                if (interfaceC0382a != null) {
                    interfaceC0382a.Yx();
                }
                com.baidu.swan.apps.core.k.b.bT(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory Yw() {
        return null;
    }
}
