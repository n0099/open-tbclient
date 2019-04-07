package com.baidu.swan.apps.core.c;

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
    protected com.baidu.swan.apps.b.c.f are;
    protected com.baidu.swan.apps.b.c.d arf;
    protected String mParams;
    private String mUrl;

    protected abstract com.baidu.swan.apps.b.c.f vW();

    protected abstract com.baidu.swan.apps.core.e.c wk();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        yv();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.b.c.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        M(inflate);
        this.are = vW();
        this.are.a(wk());
        this.arf = this.are.wb();
        this.are.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.are.a(frameLayout, this.arf.wa());
        a(frameLayout);
        return a(yi() ? Q(inflate) : inflate, this);
    }

    protected void a(FrameLayout frameLayout) {
    }

    private void yv() {
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
                gVar = new com.baidu.swan.apps.aa.b();
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
        e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        uy.yR().A(e.aqN, e.aqP).a(str, bVar).yZ();
        return true;
    }

    public static boolean ze() {
        e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        uy.yR().A(e.aqP, e.aqO).yV().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.are != null) {
            this.are.destroy();
            this.are = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
        this.are.vY();
        xV();
        this.aqb.a(com.baidu.swan.apps.u.a.CR().Dq(), yr(), ys());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vX() {
        if (this.arf == null || !this.arf.canGoBack()) {
            return false;
        }
        this.arf.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
        super.M(view);
        cb(-1);
        cc(ViewCompat.MEASURED_STATE_MASK);
        this.aqa.setTitle("");
        this.aqa.setRightImgZone2Visibility(8);
        this.aqa.setRightMenuVisibility(true);
        aW(true);
    }
}
