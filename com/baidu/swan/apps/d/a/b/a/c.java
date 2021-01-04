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
    public f amk() {
        return com.baidu.swan.apps.core.turbo.d.avA().avB().cm(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d amL() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.b.a.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean jh(String str) {
                return super.jh(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void av(View view) {
        super.av(view);
        this.cUf.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void amS() {
        FragmentActivity bhA = bhA();
        if (bhA != null && this.cUg == null) {
            this.cUg = new g(bhA, this.cUf, amT(), com.baidu.swan.apps.t.a.aAv(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cUg, this).aFx();
        }
    }

    private int amT() {
        return asr() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        av(inflate);
        this.cVp = amk();
        this.cVp.a(amL());
        this.cEG = this.cVp.amr();
        this.cVp.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cVp.b(frameLayout, this.cEG.covertToView());
        e(frameLayout);
        return ase() ? az(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean amM() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean aml() {
        if (this.cEG != null && this.cEG.canGoBack()) {
            this.cEG.goBack();
            return true;
        }
        d.and().hE(1);
        return false;
    }
}
