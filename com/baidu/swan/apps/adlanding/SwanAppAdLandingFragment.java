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
/* loaded from: classes11.dex */
public class SwanAppAdLandingFragment extends h {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private TextView bAA;
    private int bAB;
    private String bAC;
    private String bAD;
    private String bAE;
    private String bAF;
    private com.baidu.swan.apps.media.c.a bAi;
    private JSONObject bAj;
    private b bAp;
    private FrameLayout bAq;
    private com.baidu.swan.apps.w.b.b bAr;
    private com.baidu.swan.apps.adlanding.download.a.a bAs;
    private com.baidu.swan.apps.adlanding.download.model.a bAt;
    private RelativeLayout bAv;
    private RelativeLayout bAw;
    private SimpleDraweeView bAx;
    private SimpleDraweeView bAy;
    private TextView bAz;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bAo = LandingType.NORMAL;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bAu = SwanAdDownloadState.NOT_START;
    private int bAG = 0;
    private int playCount = 0;
    private View.OnClickListener bAH = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bAB == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bAp.c("c", hashMap);
            h.b("adLanding", com.baidu.swan.apps.model.b.bg(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.playCount;
        swanAppAdLandingFragment.playCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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

    private void QP() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.bAF = jSONObject.optString("w_picurl", "");
                    this.bAE = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bAB = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bAB == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bAC = string;
                    this.bAD = jSONObject.optString("appname", "");
                    this.bAG = jSONObject.optInt("currentTime", 0);
                    this.bAj = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bAo = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QP();
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bAq = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        QS();
        p(this.bAq);
        q(this.bAq);
        this.bAp = new b(getContext(), this.bAj, this.bAi);
        if (QR()) {
            o(this.bAq);
            QQ();
        }
        a(this.bAq);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bAp.gn("lpin");
        return enableSliding(initImmersion, this);
    }

    private void QQ() {
        d dVar = new d(this.bAF, this.mVideoUrl, this.bMY.QG(), this.mVideoWidth, this.mVideoHeight, this.bAG);
        this.bAi = new com.baidu.swan.apps.media.c.a(getContext(), dVar.QV());
        this.bAi.a(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.c.b
            public void a(l lVar) {
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(l lVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(l lVar) {
                SwanAppAdLandingFragment.this.bAw.bringToFront();
                SwanAppAdLandingFragment.this.bAw.setVisibility(0);
                SwanAppAdLandingFragment.this.bAG = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bAp.gn("vplayend");
                SwanAppAdLandingFragment.this.bAp.gn("scard");
            }
        });
        this.bAi.d(dVar.QV());
        this.bAi.dH(false);
    }

    private void o(ViewGroup viewGroup) {
        this.bAv = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bAw = (RelativeLayout) this.bAv.findViewById(a.f.ad_tail_root);
        this.bAx = (SimpleDraweeView) this.bAv.findViewById(a.f.ad_tail_video_img);
        this.bAy = (SimpleDraweeView) this.bAv.findViewById(a.f.ad_tail_head_image);
        this.bAz = (TextView) this.bAv.findViewById(a.f.ad_tail_brand_name);
        this.bAA = (TextView) this.bAv.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bAC)) {
            this.bAA.setText(this.bAC);
            this.bAA.setVisibility(0);
        } else {
            this.bAA.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bAD)) {
            this.bAz.setText(this.bAD);
            this.bAz.setVisibility(0);
        } else {
            this.bAz.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bAE)) {
            this.bAy.setImageURI(Uri.parse(this.bAE));
            this.bAy.setVisibility(0);
        } else {
            this.bAy.setVisibility(8);
        }
        this.bAx.getHierarchy().m(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bAF)) {
            this.bAx.setImageURI(q.getUri(this.bAF));
        }
        this.bAx.setVisibility(0);
        this.bAx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bAy.setOnClickListener(this.bAH);
        this.bAz.setOnClickListener(this.bAH);
        this.bAA.setOnClickListener(this.bAH);
        viewGroup.addView(this.bAw, layoutParams);
        this.bAw.setVisibility(4);
    }

    private void p(ViewGroup viewGroup) {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void q(ViewGroup viewGroup) {
        this.bMY = Qy();
        this.bMY.a(QT());
        this.bzz = this.bMY.QE();
        this.bMY.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.bzz.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.dA("#FFFFFF");
        this.bMY.a(frameLayout, cVar);
        this.bMY.a(frameLayout, covertToView);
        if (QR()) {
            layoutParams.topMargin = this.mVideoHeight;
        }
        viewGroup.addView(frameLayout);
        covertToView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean Qz() {
        if (isLandScape() && this.bAi != null) {
            return this.bAi.onBackPressed();
        }
        this.bAp.gn("lpout");
        return super.Qz();
    }

    private boolean QR() {
        return this.bAo == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return aCO().getResources().getConfiguration().orientation == 2;
    }

    private void QS() {
        DisplayMetrics displayMetrics = aCO().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(boolean z) {
        this.bLR.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.h
    public f Qy() {
        SwanAppAdLandingWebViewWidget swanAppAdLandingWebViewWidget = new SwanAppAdLandingWebViewWidget(getContext());
        if (this.bAt != null && this.bAr != null && !TextUtils.isEmpty(this.bAt.url) && !TextUtils.isEmpty(this.bAt.name)) {
            swanAppAdLandingWebViewWidget.QE().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (SwanAppAdLandingFragment.DEBUG) {
                        Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                    }
                    if (ai.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bAt.name)) {
                        SwanAppAdLandingFragment.this.bAq.removeView(SwanAppAdLandingFragment.this.bAr.getRealView());
                        SwanAppAdLandingFragment.this.bAq.addView(SwanAppAdLandingFragment.this.bAr.getRealView());
                        SwanAppAdLandingFragment.this.bAr.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bAt.url)) {
                        SwanAppAdLandingFragment.this.bAt.url = str;
                    }
                    com.baidu.swan.apps.w.a.abY().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bAt.QW(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bAs);
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
    protected com.baidu.swan.apps.core.f.d QT() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.cV(SwanAppAdLandingFragment.this.bzz.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void ff(final String str) {
                SwanAppAdLandingFragment.this.cV(SwanAppAdLandingFragment.this.bzz.canGoBack());
                SwanAppAdLandingFragment.this.bLR.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.bLR.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bLR.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.bLR.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.Wv();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean QU() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (QR()) {
            this.bAp.gn("vplayend");
        }
        if (this.bAi != null) {
            this.bAi.onDestroy();
        }
        super.onDestroy();
    }
}
