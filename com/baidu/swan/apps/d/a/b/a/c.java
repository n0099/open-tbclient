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
/* loaded from: classes8.dex */
public class c extends i {
    @Override // com.baidu.swan.apps.core.d.i
    public f aaL() {
        return com.baidu.swan.apps.core.turbo.d.ajS().ajT().bu(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d abm() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.b.a.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean hv(String str) {
                return super.hv(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ai(View view) {
        super.ai(view);
        this.chs.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void abt() {
        FragmentActivity aUT = aUT();
        if (aUT != null && this.cht == null) {
            this.cht = new h(aUT, this.chs, abu(), com.baidu.swan.apps.t.a.aoN(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cht, this).atP();
        }
    }

    private int abu() {
        return agK() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ai(inflate);
        this.ciB = aaL();
        this.ciB.a(abm());
        this.bRV = this.ciB.aaS();
        this.ciB.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.ciB.a(frameLayout, this.bRV.covertToView());
        a(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean abn() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        if (this.bRV != null && this.bRV.canGoBack()) {
            this.bRV.goBack();
            return true;
        }
        d.abE().gp(1);
        return false;
    }
}
