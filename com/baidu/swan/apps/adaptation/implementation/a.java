package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.k.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.adaptation.a.l {
    @Override // com.baidu.swan.apps.adaptation.a.l
    public int agh() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean agi() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public boolean agj() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public int agk() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void hr(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void ej(boolean z) {
        if (z) {
            com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).eU(ProcessUtils.isMainProcess());
        } else {
            com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).arm();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public void a(final a.InterfaceC0420a interfaceC0420a) {
        com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.k.b.a
            public void agm() {
                if (interfaceC0420a != null) {
                    interfaceC0420a.agm();
                }
                com.baidu.swan.apps.core.k.b.bY(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.l
    public VideoPlayerFactory agl() {
        return null;
    }
}
