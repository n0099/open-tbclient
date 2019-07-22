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
    protected com.baidu.swan.apps.b.c.f arN;
    protected com.baidu.swan.apps.b.c.d arO;
    protected String mParams;
    private String mUrl;

    protected abstract com.baidu.swan.apps.core.f.c xC();

    protected abstract com.baidu.swan.apps.b.c.f xo();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zX();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.b.c.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        O(inflate);
        this.arN = xo();
        this.arN.a(xC());
        this.arO = this.arN.xt();
        this.arN.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.arN.a(frameLayout, this.arO.xs());
        a(frameLayout);
        return a(zJ() ? S(inflate) : inflate, this);
    }

    protected void a(FrameLayout frameLayout) {
    }

    private void zX() {
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
                gVar = new com.baidu.swan.apps.d.c();
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
        e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        vJ.Av().B(e.arw, e.ary).a(str, bVar).AD();
        return true;
    }

    public static boolean AI() {
        e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        vJ.Av().B(e.ary, e.arx).Az().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.arN != null) {
            this.arN.destroy();
            this.arN = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zv() {
        this.arN.xq();
        zu();
        this.aqL.a(com.baidu.swan.apps.u.a.EF().Fe(), zS(), zT());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean zw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xp() {
        if (this.arO == null || !this.arO.canGoBack()) {
            return false;
        }
        this.arO.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zu() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void O(View view) {
        super.O(view);
        cb(-1);
        cc(ViewCompat.MEASURED_STATE_MASK);
        this.aqK.setTitle("");
        this.aqK.setRightZoneVisibility(true);
        bd(true);
    }
}
