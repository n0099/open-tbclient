package com.baidu.swan.apps.c.a.b.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes9.dex */
public class c extends h {
    @Override // com.baidu.swan.apps.core.d.h
    public f FW() {
        return com.baidu.swan.apps.core.k.d.NK().NL().bv(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d Gr() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.c.a.b.a.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean dX(String str) {
                return super.dX(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void aa(View view) {
        super.aa(view);
        this.biw.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void Gv() {
        FragmentActivity arR = arR();
        if (arR != null && this.bix == null) {
            this.bix = new com.baidu.swan.menu.h(arR, this.biw, Gw(), com.baidu.swan.apps.w.a.Ro(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bix, this).Vx();
        }
    }

    private int Gw() {
        return Ld() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        aa(inflate);
        this.bjE = FW();
        this.bjE.a(Gr());
        this.aVT = this.bjE.Gc();
        this.bjE.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.bjE.a(frameLayout, this.aVT.covertToView());
        a(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean Gs() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean FX() {
        if (this.aVT != null && this.aVT.canGoBack()) {
            this.aVT.goBack();
            return true;
        }
        d.GM().dG(1);
        return false;
    }
}
