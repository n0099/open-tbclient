package com.baidu.swan.apps.adaptation.implementation;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.a.a;
import com.baidu.swan.apps.core.j.b;
import com.baidu.webkit.sdk.VideoPlayerFactory;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.adaptation.a.j {
    @Override // com.baidu.swan.apps.adaptation.a.j
    public int Ek() {
        return 10150;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean El() {
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public boolean Em() {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public int En() {
        return 5000;
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void dB(int i) {
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void Eo() {
        com.baidu.swan.apps.core.j.b.bU(AppRuntime.getAppContext()).Eo();
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public void a(final a.InterfaceC0233a interfaceC0233a) {
        com.baidu.swan.apps.core.j.b.bU(AppRuntime.getAppContext()).a(new b.a() { // from class: com.baidu.swan.apps.adaptation.implementation.a.1
            @Override // com.baidu.swan.apps.core.j.b.a
            public void Eq() {
                if (interfaceC0233a != null) {
                    interfaceC0233a.Eq();
                }
                com.baidu.swan.apps.core.j.b.bU(AppRuntime.getAppContext()).b(this);
            }
        });
    }

    @Override // com.baidu.swan.apps.adaptation.a.j
    public VideoPlayerFactory Ep() {
        return null;
    }
}
