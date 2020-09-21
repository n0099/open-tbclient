package com.baidu.swan.apps.d.a.b.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.menu.h;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes3.dex */
public class c extends i {
    @Override // com.baidu.swan.apps.core.d.i
    public f abu() {
        return com.baidu.swan.apps.core.turbo.d.akC().akD().bt(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d abV() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.b.a.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean hR(String str) {
                return super.hR(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ak(View view) {
        super.ak(view);
        this.cju.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void acc() {
        FragmentActivity aVF = aVF();
        if (aVF != null && this.cjv == null) {
            this.cjv = new h(aVF, this.cju, acd(), com.baidu.swan.apps.t.a.apy(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cjv, this).auy();
        }
    }

    private int acd() {
        return ahu() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ak(inflate);
        this.ckC = abu();
        this.ckC.a(abV());
        this.bTV = this.ckC.abB();
        this.ckC.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.ckC.a(frameLayout, this.bTV.covertToView());
        a(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean abW() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean abv() {
        if (this.bTV != null && this.bTV.canGoBack()) {
            this.bTV.goBack();
            return true;
        }
        d.acn().gy(1);
        return false;
    }
}
