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
    public f aml() {
        return com.baidu.swan.apps.core.turbo.d.avB().avC().cm(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d amM() {
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
    protected void amT() {
        FragmentActivity bhB = bhB();
        if (bhB != null && this.cUg == null) {
            this.cUg = new g(bhB, this.cUf, amU(), com.baidu.swan.apps.t.a.aAw(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cUg, this).aFy();
        }
    }

    private int amU() {
        return ass() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        av(inflate);
        this.cVp = aml();
        this.cVp.a(amM());
        this.cEG = this.cVp.ams();
        this.cVp.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cVp.b(frameLayout, this.cEG.covertToView());
        e(frameLayout);
        return asf() ? az(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean amN() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean amm() {
        if (this.cEG != null && this.cEG.canGoBack()) {
            this.cEG.goBack();
            return true;
        }
        d.ane().hE(1);
        return false;
    }
}
