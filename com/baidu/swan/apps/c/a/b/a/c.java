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
/* loaded from: classes11.dex */
public class c extends h {
    @Override // com.baidu.swan.apps.core.d.h
    public f Tb() {
        return com.baidu.swan.apps.core.turbo.d.abl().abm().bk(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d Tx() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.c.a.b.a.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean fS(String str) {
                return super.fS(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bVa.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void TC() {
        FragmentActivity aHv = aHv();
        if (aHv != null && this.bVb == null) {
            this.bVb = new com.baidu.swan.menu.h(aHv, this.bVa, TD(), com.baidu.swan.apps.u.a.aeV(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.y.a(this.bVb, this).ajG();
        }
    }

    private int TD() {
        return Yq() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bWj = Tb();
        this.bWj.a(Tx());
        this.bHi = this.bWj.Th();
        this.bWj.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.bWj.a(frameLayout, this.bHi.covertToView());
        a(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean Ty() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean Tc() {
        if (this.bHi != null && this.bHi.canGoBack()) {
            this.bHi.goBack();
            return true;
        }
        d.TN().ei(1);
        return false;
    }
}
