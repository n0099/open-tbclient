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
/* loaded from: classes8.dex */
public class i extends c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.adaptation.b.d bRR;
    protected com.baidu.swan.apps.adaptation.b.f cix;
    private String ciy;
    boolean ciz = true;
    protected String mParams;
    public String mUrl;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        agQ();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ai(inflate);
        this.cix = aaL();
        this.cix.a(abm());
        this.bRR = this.cix.aaS();
        this.cix.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cix.a(frameLayout, this.bRR.covertToView());
        a(frameLayout);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(FrameLayout frameLayout) {
    }

    public com.baidu.swan.apps.adaptation.b.f aaL() {
        return new SwanAppWebViewWidget(getContext()) { // from class: com.baidu.swan.apps.core.d.i.1
            @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
            protected boolean ahB() {
                return i.this.ciz;
            }
        };
    }

    protected com.baidu.swan.apps.core.f.d abm() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void ht(String str) {
                if (i.this.lp(str) && i.this.ciy != null) {
                    i.this.cho.setTitle(i.this.ciy);
                } else {
                    i.this.cho.setTitle(str);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lp(String str) {
        return TextUtils.equals(this.mUrl, str) || TextUtils.equals(this.mUrl.replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, ""), str);
    }

    private void agQ() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url");
            this.mParams = arguments.getString("params");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.ciy = jSONObject.optString("fallback_title", null);
                    this.ciz = jSONObject.optBoolean("should_check_domain", true);
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
        f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        XX.ahq().al(f.cig, f.cii).a(str, bVar).ahx();
        return true;
    }

    public static a lq(String str) {
        return new a(str);
    }

    /* loaded from: classes8.dex */
    static final class a {
        private com.baidu.swan.apps.model.b ciB;
        JSONObject ciC = new JSONObject();

        a(String str) {
            this.ciB = com.baidu.swan.apps.model.b.bP(str, str);
        }

        public a lr(String str) {
            try {
                this.ciC.put("fallback_title", str);
            } catch (JSONException e) {
                if (i.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public a ea(boolean z) {
            try {
                this.ciC.put("should_check_domain", z);
            } catch (JSONException e) {
                if (i.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public void ahC() {
            this.ciB.mParams = this.ciC.toString();
            i.b("default_webview", this.ciB);
        }
    }

    public static boolean ahA() {
        f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        XX.ahq().al(f.cii, f.cih).aht().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cix != null) {
            this.cix.destroy();
            this.cix = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aga() {
        this.cix.aaN();
        abt();
        this.chp.n(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState(), agJ());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abn() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.cix != null) {
            return this.cix.isSlidable(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        if (this.bRR == null || !this.bRR.canGoBack()) {
            return false;
        }
        this.bRR.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void abt() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ai(View view) {
        super.ai(view);
        gV(-1);
        gW(ViewCompat.MEASURED_STATE_MASK);
        this.cho.setTitle(this.ciy == null ? "" : this.ciy);
        this.cho.setRightZoneVisibility(false);
        dV(true);
        this.cho.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (i.this.bRR.canGoBack()) {
                    i.this.bRR.goBack();
                } else {
                    i.this.agy();
                }
            }
        });
    }
}
