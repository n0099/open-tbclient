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
    public com.baidu.swan.apps.adaptation.b.f aeg() {
        return com.baidu.swan.apps.core.turbo.d.ann().ano().by(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d aeH() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.e.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean is(String str) {
                return super.is(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void al(View view) {
        super.al(view);
        this.cvM.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void aeO() {
        FragmentActivity aYo = aYo();
        if (aYo != null && this.cvN == null) {
            this.cvN = new com.baidu.swan.menu.h(aYo, this.cvM, aeP(), com.baidu.swan.apps.t.a.asj(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cvN, this).axj();
        }
    }

    private int aeP() {
        return akf() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        al(inflate);
        this.cwU = aeg();
        this.cwU.a(aeH());
        this.cgj = this.cwU.aen();
        this.cwU.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cwU.a(frameLayout, this.cgj.covertToView());
        b(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean aeI() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean aeh() {
        if (this.cgj != null && this.cgj.canGoBack()) {
            this.cgj.goBack();
            return true;
        }
        aeQ();
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        aeQ();
        super.onDestroy();
    }

    private void aeQ() {
        com.baidu.swan.apps.a.a aeR;
        if (!f.cim.aeT() && (aeR = f.cim.aeR()) != null) {
            aeR.onResult(-2);
        }
    }
}
