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
/* loaded from: classes10.dex */
public class SwanAppAdLandingFragment extends h {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b aXB;
    private FrameLayout aXC;
    private com.baidu.swan.apps.w.b.b aXD;
    private com.baidu.swan.apps.adlanding.download.a.a aXE;
    private com.baidu.swan.apps.adlanding.download.model.a aXF;
    private RelativeLayout aXH;
    private RelativeLayout aXI;
    private SimpleDraweeView aXJ;
    private SimpleDraweeView aXK;
    private TextView aXL;
    private TextView aXM;
    private int aXN;
    private String aXO;
    private String aXP;
    private String aXQ;
    private String aXR;
    private com.baidu.swan.apps.media.c.a aXu;
    private JSONObject aXv;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType aXA = LandingType.NORMAL;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState aXG = SwanAdDownloadState.NOT_START;
    private int aXS = 0;
    private int aXT = 0;
    private View.OnClickListener aXU = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.aXN == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.aXB.d("c", hashMap);
            h.b("adLanding", com.baidu.swan.apps.model.b.aO(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.aXT;
        swanAppAdLandingFragment.aXT = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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

    private void GJ() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.aXR = jSONObject.optString("w_picurl", "");
                    this.aXQ = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.aXN = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.aXN == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.aXO = string;
                    this.aXP = jSONObject.optString("appname", "");
                    this.aXS = jSONObject.optInt("currentTime", 0);
                    this.aXv = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.aXA = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GJ();
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.aXC = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        GM();
        n(this.aXC);
        o(this.aXC);
        this.aXB = new b(getContext(), this.aXv, this.aXu);
        if (GL()) {
            m(this.aXC);
            GK();
        }
        a(this.aXC);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.aXB.eN("lpin");
        return enableSliding(initImmersion, this);
    }

    private void GK() {
        d dVar = new d(this.aXR, this.mVideoUrl, this.bkt.GA(), this.mVideoWidth, this.mVideoHeight, this.aXS);
        this.aXu = new com.baidu.swan.apps.media.c.a(getContext(), dVar.GP());
        this.aXu.a(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.c.b
            public void a(l lVar) {
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(l lVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(l lVar) {
                SwanAppAdLandingFragment.this.aXI.bringToFront();
                SwanAppAdLandingFragment.this.aXI.setVisibility(0);
                SwanAppAdLandingFragment.this.aXS = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.aXB.eN("vplayend");
                SwanAppAdLandingFragment.this.aXB.eN("scard");
            }
        });
        this.aXu.d(dVar.GP());
        this.aXu.cD(false);
    }

    private void m(ViewGroup viewGroup) {
        this.aXH = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.aXI = (RelativeLayout) this.aXH.findViewById(a.f.ad_tail_root);
        this.aXJ = (SimpleDraweeView) this.aXH.findViewById(a.f.ad_tail_video_img);
        this.aXK = (SimpleDraweeView) this.aXH.findViewById(a.f.ad_tail_head_image);
        this.aXL = (TextView) this.aXH.findViewById(a.f.ad_tail_brand_name);
        this.aXM = (TextView) this.aXH.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.aXO)) {
            this.aXM.setText(this.aXO);
            this.aXM.setVisibility(0);
        } else {
            this.aXM.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.aXP)) {
            this.aXL.setText(this.aXP);
            this.aXL.setVisibility(0);
        } else {
            this.aXL.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.aXQ)) {
            this.aXK.setImageURI(Uri.parse(this.aXQ));
            this.aXK.setVisibility(0);
        } else {
            this.aXK.setVisibility(8);
        }
        this.aXJ.getHierarchy().q(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.aXR)) {
            this.aXJ.setImageURI(q.getUri(this.aXR));
        }
        this.aXJ.setVisibility(0);
        this.aXJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.aXK.setOnClickListener(this.aXU);
        this.aXL.setOnClickListener(this.aXU);
        this.aXM.setOnClickListener(this.aXU);
        viewGroup.addView(this.aXI, layoutParams);
        this.aXI.setVisibility(4);
    }

    private void n(ViewGroup viewGroup) {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void o(ViewGroup viewGroup) {
        this.bkt = Gs();
        this.bkt.a(GN());
        this.aWL = this.bkt.Gy();
        this.bkt.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.aWL.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.cy("#FFFFFF");
        this.bkt.a(frameLayout, cVar);
        this.bkt.a(frameLayout, covertToView);
        if (GL()) {
            layoutParams.topMargin = this.mVideoHeight;
        }
        viewGroup.addView(frameLayout);
        covertToView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean Gt() {
        if (isLandScape() && this.aXu != null) {
            return this.aXu.onBackPressed();
        }
        this.aXB.eN("lpout");
        return super.Gt();
    }

    private boolean GL() {
        return this.aXA == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return ask().getResources().getConfiguration().orientation == 2;
    }

    private void GM() {
        DisplayMetrics displayMetrics = ask().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(boolean z) {
        this.bjl.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.h
    public f Gs() {
        SwanAppAdLandingWebViewWidget swanAppAdLandingWebViewWidget = new SwanAppAdLandingWebViewWidget(getContext());
        if (this.aXF != null && this.aXD != null && !TextUtils.isEmpty(this.aXF.url) && !TextUtils.isEmpty(this.aXF.name)) {
            swanAppAdLandingWebViewWidget.Gy().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (SwanAppAdLandingFragment.DEBUG) {
                        Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                    }
                    if (ai.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.aXF.name)) {
                        SwanAppAdLandingFragment.this.aXC.removeView(SwanAppAdLandingFragment.this.aXD.getRealView());
                        SwanAppAdLandingFragment.this.aXC.addView(SwanAppAdLandingFragment.this.aXD.getRealView());
                        SwanAppAdLandingFragment.this.aXD.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.aXF.url)) {
                        SwanAppAdLandingFragment.this.aXF.url = str;
                    }
                    com.baidu.swan.apps.w.a.RQ().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.aXF.GQ(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.aXE);
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
    protected com.baidu.swan.apps.core.f.d GN() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.bQ(SwanAppAdLandingFragment.this.aWL.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void dY(final String str) {
                SwanAppAdLandingFragment.this.bQ(SwanAppAdLandingFragment.this.aWL.canGoBack());
                SwanAppAdLandingFragment.this.bjl.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.bjl.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bjl.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.bjl.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.Mn();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean GO() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (GL()) {
            this.aXB.eN("vplayend");
        }
        if (this.aXu != null) {
            this.aXu.onDestroy();
        }
        super.onDestroy();
    }
}
