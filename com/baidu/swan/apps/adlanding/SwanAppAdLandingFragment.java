package com.baidu.swan.apps.adlanding;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.browser.sailor.ISailorDownloadListener;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.q;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.w.b.l;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SwanAppAdLandingFragment extends h {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.c.a aWC;
    private JSONObject aWD;
    private b aWJ;
    private FrameLayout aWK;
    private com.baidu.swan.apps.w.b.b aWL;
    private com.baidu.swan.apps.adlanding.download.a.a aWM;
    private com.baidu.swan.apps.adlanding.download.model.a aWN;
    private RelativeLayout aWP;
    private RelativeLayout aWQ;
    private SimpleDraweeView aWR;
    private SimpleDraweeView aWS;
    private TextView aWT;
    private TextView aWU;
    private int aWV;
    private String aWW;
    private String aWX;
    private String aWY;
    private String aWZ;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType aWI = LandingType.NORMAL;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState aWO = SwanAdDownloadState.NOT_START;
    private int aXa = 0;
    private int aXb = 0;
    private View.OnClickListener aXc = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.aWV == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.aWJ.d("c", hashMap);
            h.b("adLanding", com.baidu.swan.apps.model.b.aN(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.aXb;
        swanAppAdLandingFragment.aXb = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum ActionType {
        LP(1),
        DL(2);
        
        private int type;

        ActionType(int i) {
            this.type = i;
        }

        int value() {
            return this.type;
        }
    }

    private void Gn() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.aWZ = jSONObject.optString("w_picurl", "");
                    this.aWY = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.aWV = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.aWV == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.aWW = string;
                    this.aWX = jSONObject.optString("appname", "");
                    this.aXa = jSONObject.optInt("currentTime", 0);
                    this.aWD = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.aWI = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Gn();
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        aa(inflate);
        this.aWK = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        Gq();
        k(this.aWK);
        l(this.aWK);
        this.aWJ = new b(getContext(), this.aWD, this.aWC);
        if (Gp()) {
            j(this.aWK);
            Go();
        }
        a(this.aWK);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.aWJ.eK("lpin");
        return enableSliding(initImmersion, this);
    }

    private void Go() {
        d dVar = new d(this.aWZ, this.mVideoUrl, this.bjE.Ge(), this.mVideoWidth, this.mVideoHeight, this.aXa);
        this.aWC = new com.baidu.swan.apps.media.c.a(getContext(), dVar.Gt());
        this.aWC.a(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.c.b
            public void a(l lVar) {
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(l lVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(l lVar) {
                SwanAppAdLandingFragment.this.aWQ.bringToFront();
                SwanAppAdLandingFragment.this.aWQ.setVisibility(0);
                SwanAppAdLandingFragment.this.aXa = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.aWJ.eK("vplayend");
                SwanAppAdLandingFragment.this.aWJ.eK("scard");
            }
        });
        this.aWC.d(dVar.Gt());
        this.aWC.cy(false);
    }

    private void j(ViewGroup viewGroup) {
        this.aWP = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.aWQ = (RelativeLayout) this.aWP.findViewById(a.f.ad_tail_root);
        this.aWR = (SimpleDraweeView) this.aWP.findViewById(a.f.ad_tail_video_img);
        this.aWS = (SimpleDraweeView) this.aWP.findViewById(a.f.ad_tail_head_image);
        this.aWT = (TextView) this.aWP.findViewById(a.f.ad_tail_brand_name);
        this.aWU = (TextView) this.aWP.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.aWW)) {
            this.aWU.setText(this.aWW);
            this.aWU.setVisibility(0);
        } else {
            this.aWU.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.aWX)) {
            this.aWT.setText(this.aWX);
            this.aWT.setVisibility(0);
        } else {
            this.aWT.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.aWY)) {
            this.aWS.setImageURI(Uri.parse(this.aWY));
            this.aWS.setVisibility(0);
        } else {
            this.aWS.setVisibility(8);
        }
        this.aWR.getHierarchy().q(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.aWZ)) {
            this.aWR.setImageURI(q.getUri(this.aWZ));
        }
        this.aWR.setVisibility(0);
        this.aWR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.aWS.setOnClickListener(this.aXc);
        this.aWT.setOnClickListener(this.aXc);
        this.aWU.setOnClickListener(this.aXc);
        viewGroup.addView(this.aWQ, layoutParams);
        this.aWQ.setVisibility(4);
    }

    private void k(ViewGroup viewGroup) {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void l(ViewGroup viewGroup) {
        this.bjE = FW();
        this.bjE.a(Gr());
        this.aVT = this.bjE.Gc();
        this.bjE.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.aVT.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.cy("#FFFFFF");
        this.bjE.a(frameLayout, cVar);
        this.bjE.a(frameLayout, covertToView);
        if (Gp()) {
            layoutParams.topMargin = this.mVideoHeight;
        }
        viewGroup.addView(frameLayout);
        covertToView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean FX() {
        if (isLandScape() && this.aWC != null) {
            return this.aWC.onBackPressed();
        }
        this.aWJ.eK("lpout");
        return super.FX();
    }

    private boolean Gp() {
        return this.aWI == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return arR().getResources().getConfiguration().orientation == 2;
    }

    private void Gq() {
        DisplayMetrics displayMetrics = arR().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        this.biw.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.h
    public f FW() {
        SwanAppAdLandingWebViewWidget swanAppAdLandingWebViewWidget = new SwanAppAdLandingWebViewWidget(getContext());
        if (this.aWN != null && this.aWL != null && !TextUtils.isEmpty(this.aWN.url) && !TextUtils.isEmpty(this.aWN.name)) {
            swanAppAdLandingWebViewWidget.Gc().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (SwanAppAdLandingFragment.DEBUG) {
                        Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                    }
                    if (ai.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.aWN.name)) {
                        SwanAppAdLandingFragment.this.aWK.removeView(SwanAppAdLandingFragment.this.aWL.getRealView());
                        SwanAppAdLandingFragment.this.aWK.addView(SwanAppAdLandingFragment.this.aWL.getRealView());
                        SwanAppAdLandingFragment.this.aWL.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.aWN.url)) {
                        SwanAppAdLandingFragment.this.aWN.url = str;
                    }
                    com.baidu.swan.apps.w.a.Ru().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.aWN.Gu(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.aWM);
                }

                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onPlayVideo(String str) {
                }

                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadFlash(String str) {
                }
            });
        }
        return swanAppAdLandingWebViewWidget;
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d Gr() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.bL(SwanAppAdLandingFragment.this.aVT.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void dW(final String str) {
                SwanAppAdLandingFragment.this.bL(SwanAppAdLandingFragment.this.aVT.canGoBack());
                SwanAppAdLandingFragment.this.biw.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.biw.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void aa(View view) {
        super.aa(view);
        this.biw.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.biw.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.LR();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean Gs() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (Gp()) {
            this.aWJ.eK("vplayend");
        }
        if (this.aWC != null) {
            this.aWC.onDestroy();
        }
        super.onDestroy();
    }
}
