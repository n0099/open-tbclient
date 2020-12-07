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
/* loaded from: classes25.dex */
public class i extends c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.adaptation.b.f cQs;
    private String cQt;
    boolean cQu = true;
    protected com.baidu.swan.apps.adaptation.b.d czQ;
    protected String mParams;
    public String mUrl;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        arf();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        at(inflate);
        this.cQs = ala();
        this.cQs.a(alB());
        this.czQ = this.cQs.alh();
        this.cQs.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.cQs.b(frameLayout, this.czQ.covertToView());
        e(frameLayout);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(FrameLayout frameLayout) {
    }

    public com.baidu.swan.apps.adaptation.b.f ala() {
        return new SwanAppWebViewWidget(getContext()) { // from class: com.baidu.swan.apps.core.d.i.1
            @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
            protected boolean arQ() {
                return i.this.cQu;
            }
        };
    }

    protected com.baidu.swan.apps.core.f.d alB() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.i.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void jn(String str) {
                if (i.this.nE(str) && i.this.cQt != null) {
                    i.this.cPk.setTitle(i.this.cQt);
                } else {
                    i.this.cPk.setTitle(str);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nE(String str) {
        return TextUtils.equals(this.mUrl, str) || TextUtils.equals(this.mUrl.replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, ""), str);
    }

    private void arf() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url");
            this.mParams = arguments.getString("params");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.cQt = jSONObject.optString("fallback_title", null);
                    this.cQu = jSONObject.optBoolean("should_check_domain", true);
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
        f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        aim.arF().an(f.cQb, f.cQd).a(str, bVar).arM();
        return true;
    }

    public static a nF(String str) {
        return new a(str);
    }

    /* loaded from: classes25.dex */
    static final class a {
        private com.baidu.swan.apps.model.b cQw;
        JSONObject cQx = new JSONObject();

        a(String str) {
            this.cQw = com.baidu.swan.apps.model.b.ch(str, str);
        }

        public a nG(String str) {
            try {
                this.cQx.put("fallback_title", str);
            } catch (JSONException e) {
                if (i.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public a fj(boolean z) {
            try {
                this.cQx.put("should_check_domain", z);
            } catch (JSONException e) {
                if (i.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public void arR() {
            this.cQw.mParams = this.cQx.toString();
            i.b("default_webview", this.cQw);
        }
    }

    public static boolean arP() {
        f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        aim.arF().an(f.cQd, f.cQc).arI().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.cQs != null) {
            this.cQs.destroy();
            this.cQs = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aqp() {
        this.cQs.alc();
        alI();
        this.cPl.o(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState(), aqY());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean alC() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.cQs != null) {
            return this.cQs.isSlidable(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aqq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alb() {
        if (this.czQ == null || !this.czQ.canGoBack()) {
            return false;
        }
        this.czQ.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alI() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void at(View view) {
        super.at(view);
        iq(-1);
        ir(ViewCompat.MEASURED_STATE_MASK);
        this.cPk.setTitle(this.cQt == null ? "" : this.cQt);
        this.cPk.setRightZoneVisibility(false);
        fe(true);
        this.cPk.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (i.this.czQ.canGoBack()) {
                    i.this.czQ.goBack();
                } else {
                    i.this.aqN();
                }
            }
        });
    }
}
