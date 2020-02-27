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
    private com.baidu.swan.apps.media.c.a bbF;
    private JSONObject bbG;
    private b bbM;
    private FrameLayout bbN;
    private com.baidu.swan.apps.w.b.b bbO;
    private com.baidu.swan.apps.adlanding.download.a.a bbP;
    private com.baidu.swan.apps.adlanding.download.model.a bbQ;
    private RelativeLayout bbS;
    private RelativeLayout bbT;
    private SimpleDraweeView bbU;
    private SimpleDraweeView bbV;
    private TextView bbW;
    private TextView bbX;
    private int bbY;
    private String bbZ;
    private String bca;
    private String bcb;
    private String bcc;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bbL = LandingType.NORMAL;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bbR = SwanAdDownloadState.NOT_START;
    private int bcd = 0;
    private int playCount = 0;
    private View.OnClickListener bce = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bbY == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bbM.d("c", hashMap);
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

    private void IY() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.bcc = jSONObject.optString("w_picurl", "");
                    this.bcb = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bbY = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bbY == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bbZ = string;
                    this.bca = jSONObject.optString("appname", "");
                    this.bcd = jSONObject.optInt("currentTime", 0);
                    this.bbG = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bbL = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IY();
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bbN = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        Jb();
        o(this.bbN);
        p(this.bbN);
        this.bbM = new b(getContext(), this.bbG, this.bbF);
        if (Ja()) {
            n(this.bbN);
            IZ();
        }
        a(this.bbN);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bbM.fc("lpin");
        return enableSliding(initImmersion, this);
    }

    private void IZ() {
        d dVar = new d(this.bcc, this.mVideoUrl, this.boD.IP(), this.mVideoWidth, this.mVideoHeight, this.bcd);
        this.bbF = new com.baidu.swan.apps.media.c.a(getContext(), dVar.Je());
        this.bbF.a(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.c.b
            public void a(l lVar) {
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(l lVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(l lVar) {
                SwanAppAdLandingFragment.this.bbT.bringToFront();
                SwanAppAdLandingFragment.this.bbT.setVisibility(0);
                SwanAppAdLandingFragment.this.bcd = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bbM.fc("vplayend");
                SwanAppAdLandingFragment.this.bbM.fc("scard");
            }
        });
        this.bbF.d(dVar.Je());
        this.bbF.cK(false);
    }

    private void n(ViewGroup viewGroup) {
        this.bbS = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bbT = (RelativeLayout) this.bbS.findViewById(a.f.ad_tail_root);
        this.bbU = (SimpleDraweeView) this.bbS.findViewById(a.f.ad_tail_video_img);
        this.bbV = (SimpleDraweeView) this.bbS.findViewById(a.f.ad_tail_head_image);
        this.bbW = (TextView) this.bbS.findViewById(a.f.ad_tail_brand_name);
        this.bbX = (TextView) this.bbS.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bbZ)) {
            this.bbX.setText(this.bbZ);
            this.bbX.setVisibility(0);
        } else {
            this.bbX.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bca)) {
            this.bbW.setText(this.bca);
            this.bbW.setVisibility(0);
        } else {
            this.bbW.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bcb)) {
            this.bbV.setImageURI(Uri.parse(this.bcb));
            this.bbV.setVisibility(0);
        } else {
            this.bbV.setVisibility(8);
        }
        this.bbU.getHierarchy().q(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bcc)) {
            this.bbU.setImageURI(q.getUri(this.bcc));
        }
        this.bbU.setVisibility(0);
        this.bbU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bbV.setOnClickListener(this.bce);
        this.bbW.setOnClickListener(this.bce);
        this.bbX.setOnClickListener(this.bce);
        viewGroup.addView(this.bbT, layoutParams);
        this.bbT.setVisibility(4);
    }

    private void o(ViewGroup viewGroup) {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void p(ViewGroup viewGroup) {
        this.boD = IH();
        this.boD.a(Jc());
        this.baW = this.boD.IN();
        this.boD.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.baW.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.cG("#FFFFFF");
        this.boD.a(frameLayout, cVar);
        this.boD.a(frameLayout, covertToView);
        if (Ja()) {
            layoutParams.topMargin = this.mVideoHeight;
        }
        viewGroup.addView(frameLayout);
        covertToView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean II() {
        if (isLandScape() && this.bbF != null) {
            return this.bbF.onBackPressed();
        }
        this.bbM.fc("lpout");
        return super.II();
    }

    private boolean Ja() {
        return this.bbL == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return auy().getResources().getConfiguration().orientation == 2;
    }

    private void Jb() {
        DisplayMetrics displayMetrics = auy().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(boolean z) {
        this.bnv.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.h
    public f IH() {
        SwanAppAdLandingWebViewWidget swanAppAdLandingWebViewWidget = new SwanAppAdLandingWebViewWidget(getContext());
        if (this.bbQ != null && this.bbO != null && !TextUtils.isEmpty(this.bbQ.url) && !TextUtils.isEmpty(this.bbQ.name)) {
            swanAppAdLandingWebViewWidget.IN().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (SwanAppAdLandingFragment.DEBUG) {
                        Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                    }
                    if (ai.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bbQ.name)) {
                        SwanAppAdLandingFragment.this.bbN.removeView(SwanAppAdLandingFragment.this.bbO.getRealView());
                        SwanAppAdLandingFragment.this.bbN.addView(SwanAppAdLandingFragment.this.bbO.getRealView());
                        SwanAppAdLandingFragment.this.bbO.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bbQ.url)) {
                        SwanAppAdLandingFragment.this.bbQ.url = str;
                    }
                    com.baidu.swan.apps.w.a.Ue().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bbQ.Jf(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bbP);
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
    protected com.baidu.swan.apps.core.f.d Jc() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.bY(SwanAppAdLandingFragment.this.baW.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void en(final String str) {
                SwanAppAdLandingFragment.this.bY(SwanAppAdLandingFragment.this.baW.canGoBack());
                SwanAppAdLandingFragment.this.bnv.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.bnv.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bnv.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.bnv.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.OB();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean Jd() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (Ja()) {
            this.bbM.fc("vplayend");
        }
        if (this.bbF != null) {
            this.bbF.onDestroy();
        }
        super.onDestroy();
    }
}
