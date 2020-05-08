package com.baidu.swan.apps.core.d;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h extends b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.adaptation.b.f bNd;
    private String bNe;
    boolean bNf = true;
    protected com.baidu.swan.apps.adaptation.b.d bzE;
    protected String mParams;
    public String mUrl;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        VK();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
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
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(FrameLayout frameLayout) {
    }

    public com.baidu.swan.apps.adaptation.b.f Qx() {
        return new SwanAppWebViewWidget(getContext()) { // from class: com.baidu.swan.apps.core.d.h.1
            @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
            protected boolean Wv() {
                return h.this.bNf;
            }
        };
    }

    protected com.baidu.swan.apps.core.f.d QS() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.h.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void ff(String str) {
                if (h.this.iq(str) && h.this.bNe != null) {
                    h.this.bLW.setTitle(h.this.bNe);
                } else {
                    h.this.bLW.setTitle(str);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iq(String str) {
        return TextUtils.equals(this.mUrl, str) || TextUtils.equals(this.mUrl.replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, ""), str);
    }

    private void VK() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url");
            this.mParams = arguments.getString("params");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.bNe = jSONObject.optString("fallback_title", null);
                    this.bNf = jSONObject.optBoolean("should_check_domain", true);
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static h c(com.baidu.swan.apps.model.b bVar, String str) {
        h hVar = null;
        char c = 65535;
        switch (str.hashCode()) {
            case -1750679182:
                if (str.equals("allianceLogin")) {
                    c = 3;
                    break;
                }
                break;
            case -130826522:
                if (str.equals("allianceChooseAddress")) {
                    c = 4;
                    break;
                }
                break;
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
            case 1221126139:
                if (str.equals("default_webview")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                hVar = new com.baidu.swan.apps.ae.c();
                break;
            case 1:
                hVar = new SwanAppAdLandingFragment();
                break;
            case 2:
                hVar = new h();
                break;
            case 3:
                hVar = new com.baidu.swan.apps.c.a.d();
                break;
            case 4:
                hVar = new com.baidu.swan.apps.c.a.b.a.c();
                break;
            default:
                if (DEBUG) {
                    Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
                    break;
                }
                break;
        }
        if (hVar != null) {
            hVar.c(bVar);
        }
        return hVar;
    }

    protected void c(com.baidu.swan.apps.model.b bVar) {
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", bVar.mBaseUrl);
            bundle.putString("params", bVar.mParams);
            setArguments(bundle);
        }
    }

    public static boolean b(String str, com.baidu.swan.apps.model.b bVar) {
        e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        Ot.Wh().ab(e.bME, e.bMG).a(str, bVar).Wp();
        return true;
    }

    public static a ir(String str) {
        return new a(str);
    }

    /* loaded from: classes11.dex */
    static final class a {
        private com.baidu.swan.apps.model.b bNh;
        JSONObject bNi = new JSONObject();

        a(String str) {
            this.bNh = com.baidu.swan.apps.model.b.bg(str, str);
        }

        public a is(String str) {
            try {
                this.bNi.put("fallback_title", str);
            } catch (JSONException e) {
                if (h.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public a ds(boolean z) {
            try {
                this.bNi.put("should_check_domain", z);
            } catch (JSONException e) {
                if (h.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public void Ww() {
            this.bNh.mParams = this.bNi.toString();
            h.b("default_webview", this.bNh);
        }
    }

    public static boolean Wu() {
        e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        Ot.Wh().ab(e.bMG, e.bMF).Wl().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bNd != null) {
            this.bNd.destroy();
            this.bNd = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vk() {
        this.bNd.Qz();
        QW();
        this.bLX.j(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState(), VE());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QT() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.bNd != null) {
            return this.bNd.isSlidable(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Vl() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qy() {
        if (this.bzE == null || !this.bzE.canGoBack()) {
            return false;
        }
        this.bzE.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        ey(-1);
        ez(ViewCompat.MEASURED_STATE_MASK);
        this.bLW.setTitle(this.bNe == null ? "" : this.bNe);
        this.bLW.setRightZoneVisibility(false);
        dn(true);
        this.bLW.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (h.this.bzE.canGoBack()) {
                    h.this.bzE.goBack();
                } else {
                    h.this.Vw();
                }
            }
        });
    }
}
