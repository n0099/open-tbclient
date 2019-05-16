package com.baidu.swan.apps.core.d;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public abstract class g extends b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.b.c.f ark;
    protected com.baidu.swan.apps.b.c.d arl;
    protected String mParams;
    private String mUrl;

    protected abstract com.baidu.swan.apps.b.c.f wN();

    protected abstract com.baidu.swan.apps.core.f.c xb();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zq();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.b.c.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        M(inflate);
        this.ark = wN();
        this.ark.a(xb());
        this.arl = this.ark.wS();
        this.ark.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.ark.a(frameLayout, this.arl.wR());
        a(frameLayout);
        return a(zc() ? Q(inflate) : inflate, this);
    }

    protected void a(FrameLayout frameLayout) {
    }

    private void zq() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url");
            this.mParams = arguments.getString("params");
        }
    }

    public static g a(com.baidu.swan.apps.model.b bVar, @NonNull String str) {
        g gVar = null;
        char c = 65535;
        switch (str.hashCode()) {
            case 113553927:
                if (str.equals("wxPay")) {
                    c = 0;
                    break;
                }
                break;
            case 570452084:
                if (str.equals("adLanding")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                gVar = new com.baidu.swan.apps.aa.c();
                break;
            case 1:
                gVar = new com.baidu.swan.apps.d.b();
                break;
            default:
                if (DEBUG) {
                    Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
                    break;
                }
                break;
        }
        if (gVar != null) {
            gVar.e(bVar);
        }
        return gVar;
    }

    protected void e(com.baidu.swan.apps.model.b bVar) {
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", bVar.mBaseUrl);
            bundle.putString("params", bVar.mParams);
            setArguments(bundle);
        }
    }

    public static boolean b(@NonNull String str, com.baidu.swan.apps.model.b bVar) {
        e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        vi.zO().y(e.aqT, e.aqV).a(str, bVar).zW();
        return true;
    }

    public static boolean Ab() {
        e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        vi.zO().y(e.aqV, e.aqU).zS().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ark != null) {
            this.ark.destroy();
            this.ark = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yO() {
        this.ark.wP();
        yN();
        this.aqi.a(com.baidu.swan.apps.u.a.DW().Ev(), zl(), zm());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean yP() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean wO() {
        if (this.arl == null || !this.arl.canGoBack()) {
            return false;
        }
        this.arl.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yN() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void M(View view) {
        super.M(view);
        cb(-1);
        cc(ViewCompat.MEASURED_STATE_MASK);
        this.aqh.setTitle("");
        this.aqh.setRightZoneVisibility(true);
        ba(true);
    }
}
