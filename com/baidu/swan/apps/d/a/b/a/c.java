package com.baidu.swan.apps.d.a.b.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.menu.g;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes9.dex */
public class c extends i {
    @Override // com.baidu.swan.apps.core.d.i
    public f aiP() {
        return com.baidu.swan.apps.core.turbo.d.ase().asf().ck(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d ajq() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.b.a.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean iw(String str) {
                return super.iw(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void aq(View view) {
        super.aq(view);
        this.cRH.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ajx() {
        FragmentActivity bdU = bdU();
        if (bdU != null && this.cRI == null) {
            this.cRI = new g(bdU, this.cRH, ajy(), com.baidu.swan.apps.t.a.axa(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cRI, this).aCb();
        }
    }

    private int ajy() {
        return aoU() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        aq(inflate);
        this.cSQ = aiP();
        this.cSQ.a(ajq());
        this.cCq = this.cSQ.aiW();
        this.cSQ.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cSQ.b(frameLayout, this.cCq.covertToView());
        e(frameLayout);
        return aoI() ? av(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean ajr() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean aiQ() {
        if (this.cCq != null && this.cCq.canGoBack()) {
            this.cCq.goBack();
            return true;
        }
        d.ajI().ga(1);
        return false;
    }
}
