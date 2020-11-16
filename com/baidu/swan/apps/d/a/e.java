package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes7.dex */
public class e extends com.baidu.swan.apps.core.d.i {
    @Override // com.baidu.swan.apps.core.d.i
    public com.baidu.swan.apps.adaptation.b.f ahS() {
        return com.baidu.swan.apps.core.turbo.d.ara().arb().by(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d ait() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.e.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean iK(String str) {
                return super.iK(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ar(View view) {
        super.ar(view);
        this.cIr.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void aiA() {
        FragmentActivity bca = bca();
        if (bca != null && this.cIs == null) {
            this.cIs = new com.baidu.swan.menu.h(bca, this.cIr, aiB(), com.baidu.swan.apps.t.a.avW(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cIs, this).aAV();
        }
    }

    private int aiB() {
        return anR() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ar(inflate);
        this.cJz = ahS();
        this.cJz.a(ait());
        this.csU = this.cJz.ahZ();
        this.cJz.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cJz.b(frameLayout, this.csU.covertToView());
        e(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean aiu() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean ahT() {
        if (this.csU != null && this.csU.canGoBack()) {
            this.csU.goBack();
            return true;
        }
        aiC();
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        aiC();
        super.onDestroy();
    }

    private void aiC() {
        com.baidu.swan.apps.a.a aiD;
        if (!f.cva.aiF() && (aiD = f.cva.aiD()) != null) {
            aiD.onResult(-2);
        }
    }
}
