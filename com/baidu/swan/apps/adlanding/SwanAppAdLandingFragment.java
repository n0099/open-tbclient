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
    private RelativeLayout bAA;
    private RelativeLayout bAB;
    private SimpleDraweeView bAC;
    private SimpleDraweeView bAD;
    private TextView bAE;
    private TextView bAF;
    private int bAG;
    private String bAH;
    private String bAI;
    private String bAJ;
    private String bAK;
    private com.baidu.swan.apps.media.c.a bAn;
    private JSONObject bAo;
    private b bAu;
    private FrameLayout bAv;
    private com.baidu.swan.apps.w.b.b bAw;
    private com.baidu.swan.apps.adlanding.download.a.a bAx;
    private com.baidu.swan.apps.adlanding.download.model.a bAy;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bAt = LandingType.NORMAL;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bAz = SwanAdDownloadState.NOT_START;
    private int bAL = 0;
    private int playCount = 0;
    private View.OnClickListener bAM = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bAG == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bAu.c("c", hashMap);
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

    private void QO() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.bAK = jSONObject.optString("w_picurl", "");
                    this.bAJ = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bAG = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bAG == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bAH = string;
                    this.bAI = jSONObject.optString("appname", "");
                    this.bAL = jSONObject.optInt("currentTime", 0);
                    this.bAo = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bAt = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QO();
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bAv = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        QR();
        p(this.bAv);
        q(this.bAv);
        this.bAu = new b(getContext(), this.bAo, this.bAn);
        if (QQ()) {
            o(this.bAv);
            QP();
        }
        a(this.bAv);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bAu.gn("lpin");
        return enableSliding(initImmersion, this);
    }

    private void QP() {
        d dVar = new d(this.bAK, this.mVideoUrl, this.bNd.QF(), this.mVideoWidth, this.mVideoHeight, this.bAL);
        this.bAn = new com.baidu.swan.apps.media.c.a(getContext(), dVar.QU());
        this.bAn.a(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.c.b
            public void a(l lVar) {
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(l lVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(l lVar) {
                SwanAppAdLandingFragment.this.bAB.bringToFront();
                SwanAppAdLandingFragment.this.bAB.setVisibility(0);
                SwanAppAdLandingFragment.this.bAL = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bAu.gn("vplayend");
                SwanAppAdLandingFragment.this.bAu.gn("scard");
            }
        });
        this.bAn.d(dVar.QU());
        this.bAn.dH(false);
    }

    private void o(ViewGroup viewGroup) {
        this.bAA = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bAB = (RelativeLayout) this.bAA.findViewById(a.f.ad_tail_root);
        this.bAC = (SimpleDraweeView) this.bAA.findViewById(a.f.ad_tail_video_img);
        this.bAD = (SimpleDraweeView) this.bAA.findViewById(a.f.ad_tail_head_image);
        this.bAE = (TextView) this.bAA.findViewById(a.f.ad_tail_brand_name);
        this.bAF = (TextView) this.bAA.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bAH)) {
            this.bAF.setText(this.bAH);
            this.bAF.setVisibility(0);
        } else {
            this.bAF.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bAI)) {
            this.bAE.setText(this.bAI);
            this.bAE.setVisibility(0);
        } else {
            this.bAE.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bAJ)) {
            this.bAD.setImageURI(Uri.parse(this.bAJ));
            this.bAD.setVisibility(0);
        } else {
            this.bAD.setVisibility(8);
        }
        this.bAC.getHierarchy().m(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bAK)) {
            this.bAC.setImageURI(q.getUri(this.bAK));
        }
        this.bAC.setVisibility(0);
        this.bAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bAD.setOnClickListener(this.bAM);
        this.bAE.setOnClickListener(this.bAM);
        this.bAF.setOnClickListener(this.bAM);
        viewGroup.addView(this.bAB, layoutParams);
        this.bAB.setVisibility(4);
    }

    private void p(ViewGroup viewGroup) {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void q(ViewGroup viewGroup) {
        this.bNd = Qx();
        this.bNd.a(QS());
        this.bzE = this.bNd.QD();
        this.bNd.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.bzE.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.dA("#FFFFFF");
        this.bNd.a(frameLayout, cVar);
        this.bNd.a(frameLayout, covertToView);
        if (QQ()) {
            layoutParams.topMargin = this.mVideoHeight;
        }
        viewGroup.addView(frameLayout);
        covertToView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean Qy() {
        if (isLandScape() && this.bAn != null) {
            return this.bAn.onBackPressed();
        }
        this.bAu.gn("lpout");
        return super.Qy();
    }

    private boolean QQ() {
        return this.bAt == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return aCO().getResources().getConfiguration().orientation == 2;
    }

    private void QR() {
        DisplayMetrics displayMetrics = aCO().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(boolean z) {
        this.bLW.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.h
    public f Qx() {
        SwanAppAdLandingWebViewWidget swanAppAdLandingWebViewWidget = new SwanAppAdLandingWebViewWidget(getContext());
        if (this.bAy != null && this.bAw != null && !TextUtils.isEmpty(this.bAy.url) && !TextUtils.isEmpty(this.bAy.name)) {
            swanAppAdLandingWebViewWidget.QD().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (SwanAppAdLandingFragment.DEBUG) {
                        Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                    }
                    if (ai.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bAy.name)) {
                        SwanAppAdLandingFragment.this.bAv.removeView(SwanAppAdLandingFragment.this.bAw.getRealView());
                        SwanAppAdLandingFragment.this.bAv.addView(SwanAppAdLandingFragment.this.bAw.getRealView());
                        SwanAppAdLandingFragment.this.bAw.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bAy.url)) {
                        SwanAppAdLandingFragment.this.bAy.url = str;
                    }
                    com.baidu.swan.apps.w.a.abX().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bAy.QV(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bAx);
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
    protected com.baidu.swan.apps.core.f.d QS() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.cV(SwanAppAdLandingFragment.this.bzE.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void ff(final String str) {
                SwanAppAdLandingFragment.this.cV(SwanAppAdLandingFragment.this.bzE.canGoBack());
                SwanAppAdLandingFragment.this.bLW.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.bLW.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bLW.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.bLW.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.Wu();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean QT() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (QQ()) {
            this.bAu.gn("vplayend");
        }
        if (this.bAn != null) {
            this.bAn.onDestroy();
        }
        super.onDestroy();
    }
}
