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
/* loaded from: classes7.dex */
public class i extends c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.adaptation.b.d bMv;
    protected com.baidu.swan.apps.adaptation.b.f ccA;
    private String ccB;
    boolean ccC = true;
    protected String mParams;
    public String mUrl;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aaG();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ah(inflate);
        this.ccA = UI();
        this.ccA.a(Vh());
        this.bMv = this.ccA.UP();
        this.ccA.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.ccA.a(frameLayout, this.bMv.covertToView());
        a(frameLayout);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(FrameLayout frameLayout) {
    }

    public com.baidu.swan.apps.adaptation.b.f UI() {
        return new SwanAppWebViewWidget(getContext()) { // from class: com.baidu.swan.apps.core.d.i.1
            @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
            protected boolean abp() {
                return i.this.ccC;
            }
        };
    }

    protected com.baidu.swan.apps.core.f.d Vh() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void fY(String str) {
                if (i.this.jQ(str) && i.this.ccB != null) {
                    i.this.cbt.setTitle(i.this.ccB);
                } else {
                    i.this.cbt.setTitle(str);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jQ(String str) {
        return TextUtils.equals(this.mUrl, str) || TextUtils.equals(this.mUrl.replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, ""), str);
    }

    private void aaG() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url");
            this.mParams = arguments.getString("params");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.ccB = jSONObject.optString("fallback_title", null);
                    this.ccC = jSONObject.optBoolean("should_check_domain", true);
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
                iVar = new com.baidu.swan.apps.ab.f();
                break;
            case 1:
                iVar = new SwanAppAdLandingFragment();
                break;
            case 2:
                iVar = new i();
                break;
            case 3:
                iVar = new com.baidu.swan.apps.c.a.e();
                break;
            case 4:
                iVar = new com.baidu.swan.apps.c.a.b.a.c();
                break;
            case 5:
                iVar = new com.baidu.swan.apps.ab.c();
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
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        Sc.abd().ag(f.cci, f.cck).a(str, bVar).abl();
        return true;
    }

    public static a jR(String str) {
        return new a(str);
    }

    /* loaded from: classes7.dex */
    static final class a {
        private com.baidu.swan.apps.model.b ccE;
        JSONObject ccF = new JSONObject();

        a(String str) {
            this.ccE = com.baidu.swan.apps.model.b.bB(str, str);
        }

        public a jS(String str) {
            try {
                this.ccF.put("fallback_title", str);
            } catch (JSONException e) {
                if (i.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public a dQ(boolean z) {
            try {
                this.ccF.put("should_check_domain", z);
            } catch (JSONException e) {
                if (i.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public void abq() {
            this.ccE.mParams = this.ccF.toString();
            i.b("default_webview", this.ccE);
        }
    }

    public static boolean abo() {
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        Sc.abd().ag(f.cck, f.ccj).abh().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ccA != null) {
            this.ccA.destroy();
            this.ccA = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ZQ() {
        this.ccA.UK();
        Vn();
        this.cbu.n(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState(), aaz());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.ccA != null) {
            return this.ccA.isSlidable(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ZR() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        if (this.bMv == null || !this.bMv.canGoBack()) {
            return false;
        }
        this.bMv.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void Vn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ah(View view) {
        super.ah(view);
        eZ(-1);
        fa(ViewCompat.MEASURED_STATE_MASK);
        this.cbt.setTitle(this.ccB == null ? "" : this.ccB);
        this.cbt.setRightZoneVisibility(false);
        dL(true);
        this.cbt.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (i.this.bMv.canGoBack()) {
                    i.this.bMv.goBack();
                } else {
                    i.this.aao();
                }
            }
        });
    }
}
