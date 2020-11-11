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
/* loaded from: classes10.dex */
public class i extends c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.adaptation.b.f cLj;
    private String cLk;
    boolean cLl = true;
    protected com.baidu.swan.apps.adaptation.b.d cuI;
    protected String mParams;
    public String mUrl;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aoF();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ar(inflate);
        this.cLj = aiA();
        this.cLj.a(ajb());
        this.cuI = this.cLj.aiH();
        this.cLj.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cLj.b(frameLayout, this.cuI.covertToView());
        e(frameLayout);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(FrameLayout frameLayout) {
    }

    public com.baidu.swan.apps.adaptation.b.f aiA() {
        return new SwanAppWebViewWidget(getContext()) { // from class: com.baidu.swan.apps.core.d.i.1
            @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
            protected boolean apr() {
                return i.this.cLl;
            }
        };
    }

    protected com.baidu.swan.apps.core.f.d ajb() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iP(String str) {
                if (i.this.nd(str) && i.this.cLk != null) {
                    i.this.cKb.setTitle(i.this.cLk);
                } else {
                    i.this.cKb.setTitle(str);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nd(String str) {
        return TextUtils.equals(this.mUrl, str) || TextUtils.equals(this.mUrl.replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, ""), str);
    }

    private void aoF() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url");
            this.mParams = arguments.getString("params");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.cLk = jSONObject.optString("fallback_title", null);
                    this.cLl = jSONObject.optBoolean("should_check_domain", true);
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
        f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        afM.apf().al(f.cKS, f.cKU).a(str, bVar).apn();
        return true;
    }

    public static a ne(String str) {
        return new a(str);
    }

    /* loaded from: classes10.dex */
    static final class a {
        private com.baidu.swan.apps.model.b cLn;
        JSONObject cLo = new JSONObject();

        a(String str) {
            this.cLn = com.baidu.swan.apps.model.b.cb(str, str);
        }

        public a nf(String str) {
            try {
                this.cLo.put("fallback_title", str);
            } catch (JSONException e) {
                if (i.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public a eR(boolean z) {
            try {
                this.cLo.put("should_check_domain", z);
            } catch (JSONException e) {
                if (i.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public void aps() {
            this.cLn.mParams = this.cLo.toString();
            i.b("default_webview", this.cLn);
        }
    }

    public static boolean apq() {
        f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        afM.apf().al(f.cKU, f.cKT).apj().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cLj != null) {
            this.cLj.destroy();
            this.cLj = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anP() {
        this.cLj.aiC();
        aji();
        this.cKc.o(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState(), aoy());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.cLj != null) {
            return this.cLj.isSlidable(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiB() {
        if (this.cuI == null || !this.cuI.canGoBack()) {
            return false;
        }
        this.cuI.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aji() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
        super.ar(view);
        hW(-1);
        hX(ViewCompat.MEASURED_STATE_MASK);
        this.cKb.setTitle(this.cLk == null ? "" : this.cLk);
        this.cKb.setRightZoneVisibility(false);
        eM(true);
        this.cKb.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (i.this.cuI.canGoBack()) {
                    i.this.cuI.goBack();
                } else {
                    i.this.aon();
                }
            }
        });
    }
}
