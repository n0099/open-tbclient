package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes10.dex */
public class e extends com.baidu.swan.apps.core.d.i {
    @Override // com.baidu.swan.apps.core.d.i
    public com.baidu.swan.apps.adaptation.b.f aiA() {
        return com.baidu.swan.apps.core.turbo.d.arI().arJ().by(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d ajb() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.e.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean iQ(String str) {
                return super.iQ(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ar(View view) {
        super.ar(view);
        this.cKb.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void aji() {
        FragmentActivity bcH = bcH();
        if (bcH != null && this.cKc == null) {
            this.cKc = new com.baidu.swan.menu.h(bcH, this.cKb, ajj(), com.baidu.swan.apps.t.a.awE(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cKc, this).aBD();
        }
    }

    private int ajj() {
        return aoz() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ar(inflate);
        this.cLj = aiA();
        this.cLj.a(ajb());
        this.cuI = this.cLj.aiH();
        this.cLj.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cLj.b(frameLayout, this.cuI.covertToView());
        e(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean aiB() {
        if (this.cuI != null && this.cuI.canGoBack()) {
            this.cuI.goBack();
            return true;
        }
        ajk();
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        ajk();
        super.onDestroy();
    }

    private void ajk() {
        com.baidu.swan.apps.a.a ajl;
        if (!f.cwK.ajn() && (ajl = f.cwK.ajl()) != null) {
            ajl.onResult(-2);
        }
    }
}
