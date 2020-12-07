package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes25.dex */
public class e extends com.baidu.swan.apps.core.d.i {
    @Override // com.baidu.swan.apps.core.d.i
    public com.baidu.swan.apps.adaptation.b.f ala() {
        return com.baidu.swan.apps.core.turbo.d.aui().auj().ce(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d alB() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.e.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean jo(String str) {
                return super.jo(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void at(View view) {
        super.at(view);
        this.cPk.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void alI() {
        FragmentActivity bff = bff();
        if (bff != null && this.cPl == null) {
            this.cPl = new com.baidu.swan.menu.h(bff, this.cPk, alJ(), com.baidu.swan.apps.t.a.aze(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cPl, this).aEe();
        }
    }

    private int alJ() {
        return aqZ() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        at(inflate);
        this.cQs = ala();
        this.cQs.a(alB());
        this.czQ = this.cQs.alh();
        this.cQs.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cQs.b(frameLayout, this.czQ.covertToView());
        e(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean alC() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean alb() {
        if (this.czQ != null && this.czQ.canGoBack()) {
            this.czQ.goBack();
            return true;
        }
        alK();
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        alK();
        super.onDestroy();
    }

    private void alK() {
        com.baidu.swan.apps.a.a alL;
        if (!f.cBS.alN() && (alL = f.cBS.alL()) != null) {
            alL.onResult(-2);
        }
    }
}
