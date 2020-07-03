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
    protected com.baidu.swan.apps.adaptation.b.d bLW;
    protected com.baidu.swan.apps.adaptation.b.f caX;
    private String caY;
    boolean caZ = true;
    protected String mParams;
    public String mUrl;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ZC();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.caX = Uh();
        this.caX.a(UD());
        this.bLW = this.caX.Un();
        this.caX.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.caX.a(frameLayout, this.bLW.covertToView());
        a(frameLayout);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(FrameLayout frameLayout) {
    }

    public com.baidu.swan.apps.adaptation.b.f Uh() {
        return new SwanAppWebViewWidget(getContext()) { // from class: com.baidu.swan.apps.core.d.h.1
            @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
            protected boolean aan() {
                return h.this.caZ;
            }
        };
    }

    protected com.baidu.swan.apps.core.f.d UD() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.h.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void fZ(String str) {
                if (h.this.jz(str) && h.this.caY != null) {
                    h.this.bZO.setTitle(h.this.caY);
                } else {
                    h.this.bZO.setTitle(str);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jz(String str) {
        return TextUtils.equals(this.mUrl, str) || TextUtils.equals(this.mUrl.replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, ""), str);
    }

    private void ZC() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url");
            this.mParams = arguments.getString("params");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.caY = jSONObject.optString("fallback_title", null);
                    this.caZ = jSONObject.optBoolean("should_check_domain", true);
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
            case 1339472410:
                if (str.equals("qrCodePay")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                hVar = new com.baidu.swan.apps.ac.f();
                break;
            case 1:
                hVar = new SwanAppAdLandingFragment();
                break;
            case 2:
                hVar = new h();
                break;
            case 3:
                hVar = new com.baidu.swan.apps.c.a.e();
                break;
            case 4:
                hVar = new com.baidu.swan.apps.c.a.b.a.c();
                break;
            case 5:
                hVar = new com.baidu.swan.apps.ac.c();
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
        e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        RN.ZZ().ag(e.caB, e.caD).a(str, bVar).aah();
        return true;
    }

    public static a jA(String str) {
        return new a(str);
    }

    /* loaded from: classes11.dex */
    static final class a {
        private com.baidu.swan.apps.model.b cbb;
        JSONObject cbc = new JSONObject();

        a(String str) {
            this.cbb = com.baidu.swan.apps.model.b.bz(str, str);
        }

        public a jB(String str) {
            try {
                this.cbc.put("fallback_title", str);
            } catch (JSONException e) {
                if (h.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public a dM(boolean z) {
            try {
                this.cbc.put("should_check_domain", z);
            } catch (JSONException e) {
                if (h.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public void aao() {
            this.cbb.mParams = this.cbc.toString();
            h.b("default_webview", this.cbb);
        }
    }

    public static boolean aam() {
        e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        RN.ZZ().ag(e.caD, e.caC).aad().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.caX != null) {
            this.caX.destroy();
            this.caX = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void YV() {
        this.caX.Uj();
        UI();
        this.bZP.n(com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState(), Zv());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean UE() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.caX != null) {
            return this.caX.isSlidable(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean YW() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        if (this.bLW == null || !this.bLW.canGoBack()) {
            return false;
        }
        this.bLW.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void UI() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        eU(-1);
        eV(ViewCompat.MEASURED_STATE_MASK);
        this.bZO.setTitle(this.caY == null ? "" : this.caY);
        this.bZO.setRightZoneVisibility(false);
        dH(true);
        this.bZO.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (h.this.bLW.canGoBack()) {
                    h.this.bLW.goBack();
                } else {
                    h.this.Zk();
                }
            }
        });
    }
}
