package com.baidu.swan.apps.c.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes7.dex */
public class e extends com.baidu.swan.apps.core.d.i {
    private static final String TAG = e.class.getSimpleName();

    @Override // com.baidu.swan.apps.core.d.i
    public com.baidu.swan.apps.adaptation.b.f UI() {
        return com.baidu.swan.apps.core.turbo.d.adw().adx().bm(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d Vh() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.c.a.e.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean fZ(String str) {
                return super.fZ(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ah(View view) {
        super.ah(view);
        this.cbt.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void Vn() {
        FragmentActivity aMt = aMt();
        if (aMt != null && this.cbu == null) {
            this.cbu = new com.baidu.swan.menu.h(aMt, this.cbt, Vo(), com.baidu.swan.apps.t.a.ahn(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.x.a(this.cbu, this).amc();
        }
    }

    private int Vo() {
        return aaA() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ah(inflate);
        this.ccA = UI();
        this.ccA.a(Vh());
        this.bMv = this.ccA.UP();
        this.ccA.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.ccA.a(frameLayout, this.bMv.covertToView());
        a(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        if (this.bMv != null && this.bMv.canGoBack()) {
            this.bMv.goBack();
            return true;
        }
        Vp();
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Vp();
        super.onDestroy();
    }

    private void Vp() {
        com.baidu.swan.apps.a.a Vq;
        if (!f.bOu.Vs() && (Vq = f.bOu.Vq()) != null) {
            Vq.onResult(-2);
        }
    }
}
