package com.baidu.swan.apps.d.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes8.dex */
public class e extends com.baidu.swan.apps.core.d.i {
    @Override // com.baidu.swan.apps.core.d.i
    public com.baidu.swan.apps.adaptation.b.f air() {
        return com.baidu.swan.apps.core.turbo.d.arG().arH().ck(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d aiS() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.e.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean hW(String str) {
                return super.hW(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void av(View view) {
        super.av(view);
        this.cPt.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void aiZ() {
        FragmentActivity bdH = bdH();
        if (bdH != null && this.cPu == null) {
            this.cPu = new com.baidu.swan.menu.g(bdH, this.cPt, aja(), com.baidu.swan.apps.t.a.awC(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cPu, this).aBE();
        }
    }

    private int aja() {
        return aow() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        av(inflate);
        this.cQD = air();
        this.cQD.a(aiS());
        this.czU = this.cQD.aiy();
        this.cQD.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cQD.b(frameLayout, this.czU.covertToView());
        e(frameLayout);
        return aok() ? az(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean ais() {
        if (this.czU != null && this.czU.canGoBack()) {
            this.czU.goBack();
            return true;
        }
        ajb();
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        ajb();
        super.onDestroy();
    }

    private void ajb() {
        com.baidu.swan.apps.a.a ajc;
        if (!f.cBW.aje() && (ajc = f.cBW.ajc()) != null) {
            ajc.onResult(-2);
        }
    }
}
