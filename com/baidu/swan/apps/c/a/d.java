package com.baidu.swan.apps.c.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.apps.core.d.h {
    private static final String TAG = d.class.getSimpleName();

    @Override // com.baidu.swan.apps.core.d.h
    public com.baidu.swan.apps.adaptation.b.f IJ() {
        return com.baidu.swan.apps.core.k.d.Qw().Qx().by(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d Je() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.c.a.d.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean eo(String str) {
                return super.eo(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bnx.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void Ji() {
        FragmentActivity auA = auA();
        if (auA != null && this.bny == null) {
            this.bny = new com.baidu.swan.menu.h(auA, this.bnx, Jj(), com.baidu.swan.apps.w.a.Ua(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bny, this).Yk();
        }
    }

    private int Jj() {
        return NP() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.boF = IJ();
        this.boF.a(Je());
        this.baY = this.boF.IP();
        this.boF.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.boF.a(frameLayout, this.baY.covertToView());
        a(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean Jf() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean IK() {
        if (this.baY != null && this.baY.canGoBack()) {
            this.baY.goBack();
            return true;
        }
        Jk();
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Jk();
        super.onDestroy();
    }

    private void Jk() {
        com.baidu.swan.apps.a.a Jl;
        if (!e.bco.Jn() && (Jl = e.bco.Jl()) != null) {
            Jl.onResult(-2);
        }
    }
}
