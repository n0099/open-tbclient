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
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
/* loaded from: classes2.dex */
public abstract class g extends b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.b.c.f ara;
    protected com.baidu.swan.apps.b.c.d arb;
    protected String mParams;
    private String mUrl;

    protected abstract com.baidu.swan.apps.b.c.f vX();

    protected abstract com.baidu.swan.apps.core.e.c wl();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        yw();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.b.c.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        M(inflate);
        this.ara = vX();
        this.ara.a(wl());
        this.arb = this.ara.wc();
        this.ara.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.ara.a(frameLayout, this.arb.wb());
        a(frameLayout);
        return a(yj() ? Q(inflate) : inflate, this);
    }

    protected void a(FrameLayout frameLayout) {
    }

    private void yw() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url");
            this.mParams = arguments.getString(LegoListActivityConfig.PARAMS);
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
            bundle.putString(LegoListActivityConfig.PARAMS, bVar.mParams);
            setArguments(bundle);
        }
    }

    public static boolean b(@NonNull String str, com.baidu.swan.apps.model.b bVar) {
        e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        uz.yS().A(e.aqJ, e.aqL).a(str, bVar).za();
        return true;
    }

    public static boolean zf() {
        e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        uz.yS().A(e.aqL, e.aqK).yW().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ara != null) {
            this.ara.destroy();
            this.ara = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xX() {
        this.ara.vZ();
        xW();
        this.apX.a(com.baidu.swan.apps.u.a.CT().Ds(), ys(), yt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vY() {
        if (this.arb == null || !this.arb.canGoBack()) {
            return false;
        }
        this.arb.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
        super.M(view);
        cc(-1);
        cd(ViewCompat.MEASURED_STATE_MASK);
        this.apW.setTitle("");
        this.apW.setRightImgZone2Visibility(8);
        this.apW.setRightMenuVisibility(true);
        aW(true);
    }
}
