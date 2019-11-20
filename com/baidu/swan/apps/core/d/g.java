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
    protected com.baidu.swan.apps.b.c.f aLk;
    protected com.baidu.swan.apps.b.c.d aLl;
    protected String mParams;
    private String mUrl;

    protected abstract com.baidu.swan.apps.core.f.c CB();

    protected abstract com.baidu.swan.apps.b.c.f Cn();

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EX();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.b.c.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        U(inflate);
        this.aLk = Cn();
        this.aLk.a(CB());
        this.aLl = this.aLk.Cs();
        this.aLk.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.aLk.a(frameLayout, this.aLl.Cr());
        a(frameLayout);
        return a(EJ() ? Y(inflate) : inflate, this);
    }

    protected void a(FrameLayout frameLayout) {
    }

    private void EX() {
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
        e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        AI.Fv().F(e.aKT, e.aKV).a(str, bVar).FD();
        return true;
    }

    public static boolean FI() {
        e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        AI.Fv().F(e.aKV, e.aKU).Fz().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.aLk != null) {
            this.aLk.destroy();
            this.aLk = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ev() {
        this.aLk.Cp();
        Eu();
        this.aKh.a(com.baidu.swan.apps.u.a.JE().Kd(), ES(), ET());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ew() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Co() {
        if (this.aLl == null || !this.aLl.canGoBack()) {
            return false;
        }
        this.aLl.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void U(View view) {
        super.U(view);
        cY(-1);
        cZ(ViewCompat.MEASURED_STATE_MASK);
        this.aKg.setTitle("");
        this.aKg.setRightZoneVisibility(true);
        bv(true);
    }
}
