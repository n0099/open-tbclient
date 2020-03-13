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
    private com.baidu.swan.apps.media.c.a bbH;
    private JSONObject bbI;
    private b bbO;
    private FrameLayout bbP;
    private com.baidu.swan.apps.w.b.b bbQ;
    private com.baidu.swan.apps.adlanding.download.a.a bbR;
    private com.baidu.swan.apps.adlanding.download.model.a bbS;
    private RelativeLayout bbU;
    private RelativeLayout bbV;
    private SimpleDraweeView bbW;
    private SimpleDraweeView bbX;
    private TextView bbY;
    private TextView bbZ;
    private int bca;
    private String bcb;
    private String bcc;
    private String bcd;
    private String bce;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bbN = LandingType.NORMAL;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bbT = SwanAdDownloadState.NOT_START;
    private int bcf = 0;
    private int playCount = 0;
    private View.OnClickListener bcg = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bca == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bbO.d("c", hashMap);
            h.b("adLanding", com.baidu.swan.apps.model.b.aX(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
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

    private void Ja() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.bce = jSONObject.optString("w_picurl", "");
                    this.bcd = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bca = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bca == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bcb = string;
                    this.bcc = jSONObject.optString("appname", "");
                    this.bcf = jSONObject.optInt("currentTime", 0);
                    this.bbI = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bbN = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Ja();
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bbP = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        Jd();
        o(this.bbP);
        p(this.bbP);
        this.bbO = new b(getContext(), this.bbI, this.bbH);
        if (Jc()) {
            n(this.bbP);
            Jb();
        }
        a(this.bbP);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bbO.fc("lpin");
        return enableSliding(initImmersion, this);
    }

    private void Jb() {
        d dVar = new d(this.bce, this.mVideoUrl, this.boF.IR(), this.mVideoWidth, this.mVideoHeight, this.bcf);
        this.bbH = new com.baidu.swan.apps.media.c.a(getContext(), dVar.Jg());
        this.bbH.a(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.c.b
            public void a(l lVar) {
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(l lVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(l lVar) {
                SwanAppAdLandingFragment.this.bbV.bringToFront();
                SwanAppAdLandingFragment.this.bbV.setVisibility(0);
                SwanAppAdLandingFragment.this.bcf = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bbO.fc("vplayend");
                SwanAppAdLandingFragment.this.bbO.fc("scard");
            }
        });
        this.bbH.d(dVar.Jg());
        this.bbH.cK(false);
    }

    private void n(ViewGroup viewGroup) {
        this.bbU = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bbV = (RelativeLayout) this.bbU.findViewById(a.f.ad_tail_root);
        this.bbW = (SimpleDraweeView) this.bbU.findViewById(a.f.ad_tail_video_img);
        this.bbX = (SimpleDraweeView) this.bbU.findViewById(a.f.ad_tail_head_image);
        this.bbY = (TextView) this.bbU.findViewById(a.f.ad_tail_brand_name);
        this.bbZ = (TextView) this.bbU.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bcb)) {
            this.bbZ.setText(this.bcb);
            this.bbZ.setVisibility(0);
        } else {
            this.bbZ.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bcc)) {
            this.bbY.setText(this.bcc);
            this.bbY.setVisibility(0);
        } else {
            this.bbY.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bcd)) {
            this.bbX.setImageURI(Uri.parse(this.bcd));
            this.bbX.setVisibility(0);
        } else {
            this.bbX.setVisibility(8);
        }
        this.bbW.getHierarchy().q(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bce)) {
            this.bbW.setImageURI(q.getUri(this.bce));
        }
        this.bbW.setVisibility(0);
        this.bbW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bbX.setOnClickListener(this.bcg);
        this.bbY.setOnClickListener(this.bcg);
        this.bbZ.setOnClickListener(this.bcg);
        viewGroup.addView(this.bbV, layoutParams);
        this.bbV.setVisibility(4);
    }

    private void o(ViewGroup viewGroup) {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void p(ViewGroup viewGroup) {
        this.boF = IJ();
        this.boF.a(Je());
        this.baY = this.boF.IP();
        this.boF.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.baY.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.cG("#FFFFFF");
        this.boF.a(frameLayout, cVar);
        this.boF.a(frameLayout, covertToView);
        if (Jc()) {
            layoutParams.topMargin = this.mVideoHeight;
        }
        viewGroup.addView(frameLayout);
        covertToView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean IK() {
        if (isLandScape() && this.bbH != null) {
            return this.bbH.onBackPressed();
        }
        this.bbO.fc("lpout");
        return super.IK();
    }

    private boolean Jc() {
        return this.bbN == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return auA().getResources().getConfiguration().orientation == 2;
    }

    private void Jd() {
        DisplayMetrics displayMetrics = auA().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(boolean z) {
        this.bnx.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.h
    public f IJ() {
        SwanAppAdLandingWebViewWidget swanAppAdLandingWebViewWidget = new SwanAppAdLandingWebViewWidget(getContext());
        if (this.bbS != null && this.bbQ != null && !TextUtils.isEmpty(this.bbS.url) && !TextUtils.isEmpty(this.bbS.name)) {
            swanAppAdLandingWebViewWidget.IP().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (SwanAppAdLandingFragment.DEBUG) {
                        Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                    }
                    if (ai.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bbS.name)) {
                        SwanAppAdLandingFragment.this.bbP.removeView(SwanAppAdLandingFragment.this.bbQ.getRealView());
                        SwanAppAdLandingFragment.this.bbP.addView(SwanAppAdLandingFragment.this.bbQ.getRealView());
                        SwanAppAdLandingFragment.this.bbQ.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bbS.url)) {
                        SwanAppAdLandingFragment.this.bbS.url = str;
                    }
                    com.baidu.swan.apps.w.a.Ug().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bbS.Jh(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bbR);
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
    protected com.baidu.swan.apps.core.f.d Je() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.bY(SwanAppAdLandingFragment.this.baY.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void en(final String str) {
                SwanAppAdLandingFragment.this.bY(SwanAppAdLandingFragment.this.baY.canGoBack());
                SwanAppAdLandingFragment.this.bnx.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.bnx.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bnx.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.bnx.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.OD();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean Jf() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (Jc()) {
            this.bbO.fc("vplayend");
        }
        if (this.bbH != null) {
            this.bbH.onDestroy();
        }
        super.onDestroy();
    }
}
