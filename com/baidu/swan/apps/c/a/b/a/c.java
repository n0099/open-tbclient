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
    public f Uh() {
        return com.baidu.swan.apps.core.turbo.d.acr().acs().bl(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d UD() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.c.a.b.a.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean ga(String str) {
                return super.ga(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bZO.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void UI() {
        FragmentActivity aIB = aIB();
        if (aIB != null && this.bZP == null) {
            this.bZP = new com.baidu.swan.menu.h(aIB, this.bZO, UJ(), com.baidu.swan.apps.u.a.agb(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.y.a(this.bZP, this).akM();
        }
    }

    private int UJ() {
        return Zw() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.caX = Uh();
        this.caX.a(UD());
        this.bLW = this.caX.Un();
        this.caX.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.caX.a(frameLayout, this.bLW.covertToView());
        a(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean UE() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        if (this.bLW != null && this.bLW.canGoBack()) {
            this.bLW.goBack();
            return true;
        }
        d.UT().ev(1);
        return false;
    }
}
