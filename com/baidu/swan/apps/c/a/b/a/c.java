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
/* loaded from: classes10.dex */
public class c extends h {
    @Override // com.baidu.swan.apps.core.d.h
    public f Gs() {
        return com.baidu.swan.apps.core.k.d.Og().Oh().bv(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d GN() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.c.a.b.a.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean dZ(String str) {
                return super.dZ(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bjl.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void GR() {
        FragmentActivity ask = ask();
        if (ask != null && this.bjm == null) {
            this.bjm = new com.baidu.swan.menu.h(ask, this.bjl, GS(), com.baidu.swan.apps.w.a.RK(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bjm, this).VU();
        }
    }

    private int GS() {
        return Lz() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bkt = Gs();
        this.bkt.a(GN());
        this.aWL = this.bkt.Gy();
        this.bkt.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.bkt.a(frameLayout, this.aWL.covertToView());
        a(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean GO() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean Gt() {
        if (this.aWL != null && this.aWL.canGoBack()) {
            this.aWL.goBack();
            return true;
        }
        d.Hi().dH(1);
        return false;
    }
}
