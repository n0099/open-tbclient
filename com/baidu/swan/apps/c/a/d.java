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
    public com.baidu.swan.apps.adaptation.b.f Qx() {
        return com.baidu.swan.apps.core.k.d.Yn().Yo().aZ(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d QS() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.c.a.d.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean fg(String str) {
                return super.fg(str);
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bLW.setRightZoneVisibility(true);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void QW() {
        FragmentActivity aCO = aCO();
        if (aCO != null && this.bLX == null) {
            this.bLX = new com.baidu.swan.menu.h(aCO, this.bLW, QX(), com.baidu.swan.apps.w.a.abR(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bLX, this).ags();
        }
    }

    private int QX() {
        return VF() ? 18 : 12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bNd = Qx();
        this.bNd.a(QS());
        this.bzE = this.bNd.QD();
        this.bNd.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.bNd.a(frameLayout, this.bzE.covertToView());
        a(frameLayout);
        return immersionEnabled() ? initImmersion(inflate) : inflate;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean QT() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean Qy() {
        if (this.bzE != null && this.bzE.canGoBack()) {
            this.bzE.goBack();
            return true;
        }
        QY();
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        QY();
        super.onDestroy();
    }

    private void QY() {
        com.baidu.swan.apps.a.a QZ;
        if (!e.bAU.Rb() && (QZ = e.bAU.QZ()) != null) {
            QZ.onResult(-2);
        }
    }
}
