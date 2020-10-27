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
/* loaded from: classes10.dex */
public class c extends i {
    @Override // com.baidu.swan.apps.core.d.i
    public f aga() {
        return com.baidu.swan.apps.core.turbo.d.aph().apj().bz(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d agB() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.b.a.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean iD(String str) {
                return super.iD(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void an(View view) {
        super.an(view);
        this.cEi.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void agI() {
        FragmentActivity bah = bah();
        if (bah != null && this.cEj == null) {
            this.cEj = new h(bah, this.cEi, agJ(), com.baidu.swan.apps.t.a.aue(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cEj, this).azd();
        }
    }

    private int agJ() {
        return alZ() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        an(inflate);
        this.cFq = aga();
        this.cFq.a(agB());
        this.coJ = this.cFq.agh();
        this.cFq.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cFq.a(frameLayout, this.coJ.covertToView());
        b(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean agC() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean agb() {
        if (this.coJ != null && this.coJ.canGoBack()) {
            this.coJ.goBack();
            return true;
        }
        d.agT().hg(1);
        return false;
    }
}
