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
public class h extends b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.adaptation.b.d aWL;
    protected com.baidu.swan.apps.adaptation.b.f bkt;
    private String bku;
    boolean bkv = true;
    protected String mParams;
    public String mUrl;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LE();
        if (DEBUG) {
            Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bkt = Gs();
        this.bkt.a(GN());
        this.aWL = this.bkt.Gy();
        this.bkt.loadUrl(this.mUrl);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        this.bkt.a(frameLayout, this.aWL.covertToView());
        a(frameLayout);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(FrameLayout frameLayout) {
    }

    public com.baidu.swan.apps.adaptation.b.f Gs() {
        return new SwanAppWebViewWidget(getContext()) { // from class: com.baidu.swan.apps.core.d.h.1
            @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
            protected boolean Mo() {
                return h.this.bkv;
            }
        };
    }

    protected com.baidu.swan.apps.core.f.d GN() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.core.d.h.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void dY(String str) {
                if (h.this.gO(str) && h.this.bku != null) {
                    h.this.bjl.setTitle(h.this.bku);
                } else {
                    h.this.bjl.setTitle(str);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gO(String str) {
        return TextUtils.equals(this.mUrl, str) || TextUtils.equals(this.mUrl.replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, ""), str);
    }

    private void LE() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url");
            this.mParams = arguments.getString("params");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.bku = jSONObject.optString("fallback_title", null);
                    this.bkv = jSONObject.optBoolean("should_check_domain", true);
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
        e El = com.baidu.swan.apps.y.f.UC().El();
        if (El == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "open page url=" + bVar.mBaseUrl);
        El.Mb().Y(e.bjU, e.bjW).a(str, bVar).Mj();
        return true;
    }

    public static a gP(String str) {
        return new a(str);
    }

    /* loaded from: classes10.dex */
    static final class a {
        private com.baidu.swan.apps.model.b bkx;
        JSONObject bky = new JSONObject();

        a(String str) {
            this.bkx = com.baidu.swan.apps.model.b.aO(str, str);
        }

        public a gQ(String str) {
            try {
                this.bky.put("fallback_title", str);
            } catch (JSONException e) {
                if (h.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public a co(boolean z) {
            try {
                this.bky.put("should_check_domain", z);
            } catch (JSONException e) {
                if (h.DEBUG) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        public void Mp() {
            this.bkx.mParams = this.bky.toString();
            h.b("default_webview", this.bkx);
        }
    }

    public static boolean Mn() {
        e El = com.baidu.swan.apps.y.f.UC().El();
        if (El == null) {
            com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "close page failed");
            return false;
        }
        com.baidu.swan.apps.console.c.i("SwanAppWebViewFragment", "page closed! ");
        El.Mb().Y(e.bjW, e.bjV).Mf().commit();
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bkt != null) {
            this.bkt.destroy();
            this.bkt = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Le() {
        this.bkt.Gu();
        GR();
        this.bjm.h(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState(), Ly());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean GO() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.bkt != null) {
            return this.bkt.isSlidable(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Lf() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Gt() {
        if (this.aWL == null || !this.aWL.canGoBack()) {
            return false;
        }
        this.aWL.goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void GR() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        super.ae(view);
        ed(-1);
        ee(ViewCompat.MEASURED_STATE_MASK);
        this.bjl.setTitle(this.bku == null ? "" : this.bku);
        this.bjl.setRightZoneVisibility(false);
        cj(true);
        this.bjl.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (h.this.aWL.canGoBack()) {
                    h.this.aWL.goBack();
                } else {
                    h.this.onActionBarBackPressed();
                }
            }
        });
    }
}
