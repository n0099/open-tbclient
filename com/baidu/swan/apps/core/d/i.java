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
/* loaded from: classes3.dex */
public class i extends c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.adaptation.b.d bTV;
    protected com.baidu.swan.apps.adaptation.b.f ckC;
    private String ckD;
    boolean ckE = true;
    protected String mParams;
    public String mUrl;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ahA();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ak(inflate);
        this.ckC = abu();
        this.ckC.a(abV());
        this.bTV = this.ckC.abB();
        this.ckC.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.ckC.a(frameLayout, this.bTV.covertToView());
        a(frameLayout);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(FrameLayout frameLayout) {
    }

    public com.baidu.swan.apps.adaptation.b.f abu() {
        return new SwanAppWebViewWidget(getContext()) { // from class: com.baidu.swan.apps.core.d.i.1
            @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
            protected boolean ail() {
                return i.this.ckE;
            }
        };
    }

    protected com.baidu.swan.apps.core.f.d abV() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void hQ(String str) {
                if (i.this.lJ(str) && i.this.ckD != null) {
                    i.this.cju.setTitle(i.this.ckD);
                } else {
                    i.this.cju.setTitle(str);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lJ(String str) {
        return TextUtils.equals(this.mUrl, str) || TextUtils.equals(this.mUrl.replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, ""), str);
    }

    private void ahA() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url");
            this.mParams = arguments.getString("params");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.ckD = jSONObject.optString("fallback_title", null);
                    this.ckE = jSONObject.optBoolean("should_check_domain", true);
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static i c(com.baidu.swan.apps.model.b bVar, String str) {
        i iVar = null;
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
                iVar = new com.baidu.swan.apps.aa.f();
                break;
            case 1:
                iVar = new SwanAppAdLandingFragment();
                break;
            case 2:
                iVar = new i();
                break;
            case 3:
                iVar = new com.baidu.swan.apps.d.a.e();
                break;
            case 4:
                iVar = new com.baidu.swan.apps.d.a.b.a.c();
                break;
            case 5:
                iVar = new com.baidu.swan.apps.aa.c();
                break;
            default:
                if (DEBUG) {
                    Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
                    break;
                }
                break;
        }
        if (iVar != null) {
            iVar.c(bVar);
        }
        return iVar;
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
        f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        YG.aia().al(f.ckl, f.ckn).a(str, bVar).aih();
        return true;
    }

    public static a lK(String str) {
        return new a(str);
    }

    /* loaded from: classes3.dex */
    static final class a {
        private com.baidu.swan.apps.model.b ckG;
        JSONObject ckH = new JSONObject();

        a(String str) {
            this.ckG = com.baidu.swan.apps.model.b.bP(str, str);
        }

        public a lL(String str) {
            try {
                this.ckH.put("fallback_title", str);
            } catch (JSONException e) {
                if (i.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public a dZ(boolean z) {
            try {
                this.ckH.put("should_check_domain", z);
            } catch (JSONException e) {
                if (i.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public void aim() {
            this.ckG.mParams = this.ckH.toString();
            i.b("default_webview", this.ckG);
        }
    }

    public static boolean aik() {
        f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        YG.aia().al(f.ckn, f.ckm).aid().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ckC != null) {
            this.ckC.destroy();
            this.ckC = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agK() {
        this.ckC.abw();
        acc();
        this.cjv.n(com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState(), aht());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abW() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.ckC != null) {
            return this.ckC.isSlidable(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agL() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean abv() {
        if (this.bTV == null || !this.bTV.canGoBack()) {
            return false;
        }
        this.bTV.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void acc() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ak(View view) {
        super.ak(view);
        he(-1);
        hf(ViewCompat.MEASURED_STATE_MASK);
        this.cju.setTitle(this.ckD == null ? "" : this.ckD);
        this.cju.setRightZoneVisibility(false);
        dU(true);
        this.cju.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (i.this.bTV.canGoBack()) {
                    i.this.bTV.goBack();
                } else {
                    i.this.ahi();
                }
            }
        });
    }
}
