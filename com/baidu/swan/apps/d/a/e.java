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
    public com.baidu.swan.apps.adaptation.b.f aiS() {
        return com.baidu.swan.apps.core.turbo.d.ash().asi().ci(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d ajt() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.d.a.e.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean iC(String str) {
                return super.iC(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void aq(View view) {
        super.aq(view);
        this.cTh.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ajA() {
        FragmentActivity bdW = bdW();
        if (bdW != null && this.cTi == null) {
            this.cTi = new com.baidu.swan.menu.g(bdW, this.cTh, ajB(), com.baidu.swan.apps.t.a.axd(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.menu.a(this.cTi, this).aCe();
        }
    }

    private int ajB() {
        return aoX() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        aq(inflate);
        this.cUq = aiS();
        this.cUq.a(ajt());
        this.cDQ = this.cUq.aiZ();
        this.cUq.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cUq.b(frameLayout, this.cDQ.covertToView());
        e(frameLayout);
        return aoL() ? av(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean aju() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean aiT() {
        if (this.cDQ != null && this.cDQ.canGoBack()) {
            this.cDQ.goBack();
            return true;
        }
        ajC();
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        ajC();
        super.onDestroy();
    }

    private void ajC() {
        com.baidu.swan.apps.a.a ajD;
        if (!f.cFS.ajF() && (ajD = f.cFS.ajD()) != null) {
            ajD.onResult(-2);
        }
    }
}
