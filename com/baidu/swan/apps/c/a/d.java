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
    public com.baidu.swan.apps.adaptation.b.f IM() {
        return com.baidu.swan.apps.core.k.d.Qz().QA().bx(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d Jh() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.c.a.d.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean en(String str) {
                return super.en(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bnK.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void Jl() {
        FragmentActivity auD = auD();
        if (auD != null && this.bnL == null) {
            this.bnL = new com.baidu.swan.menu.h(auD, this.bnK, Jm(), com.baidu.swan.apps.w.a.Ud(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bnL, this).Yn();
        }
    }

    private int Jm() {
        return NS() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.boR = IM();
        this.boR.a(Jh());
        this.bbl = this.boR.IS();
        this.boR.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.boR.a(frameLayout, this.bbl.covertToView());
        a(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean Ji() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean IN() {
        if (this.bbl != null && this.bbl.canGoBack()) {
            this.bbl.goBack();
            return true;
        }
        Jn();
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Jn();
        super.onDestroy();
    }

    private void Jn() {
        com.baidu.swan.apps.a.a Jo;
        if (!e.bcB.Jq() && (Jo = e.bcB.Jo()) != null) {
            Jo.onResult(-2);
        }
    }
}
