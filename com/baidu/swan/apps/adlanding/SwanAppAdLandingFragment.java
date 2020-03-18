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
    private com.baidu.swan.apps.media.c.a bbU;
    private JSONObject bbV;
    private b bcb;
    private FrameLayout bcc;
    private com.baidu.swan.apps.w.b.b bcd;
    private com.baidu.swan.apps.adlanding.download.a.a bce;
    private com.baidu.swan.apps.adlanding.download.model.a bcf;
    private RelativeLayout bch;
    private RelativeLayout bci;
    private SimpleDraweeView bcj;
    private SimpleDraweeView bck;
    private TextView bcl;
    private TextView bcm;
    private int bcn;
    private String bco;
    private String bcp;
    private String bcq;
    private String bcr;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bca = LandingType.NORMAL;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bcg = SwanAdDownloadState.NOT_START;
    private int bcs = 0;
    private int playCount = 0;
    private View.OnClickListener bct = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bcn == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bcb.d("c", hashMap);
            h.b("adLanding", com.baidu.swan.apps.model.b.aW(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
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

    private void Jd() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.bcr = jSONObject.optString("w_picurl", "");
                    this.bcq = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bcn = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bcn == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bco = string;
                    this.bcp = jSONObject.optString("appname", "");
                    this.bcs = jSONObject.optInt("currentTime", 0);
                    this.bbV = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bca = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Jd();
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bcc = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        Jg();
        o(this.bcc);
        p(this.bcc);
        this.bcb = new b(getContext(), this.bbV, this.bbU);
        if (Jf()) {
            n(this.bcc);
            Je();
        }
        a(this.bcc);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bcb.fb("lpin");
        return enableSliding(initImmersion, this);
    }

    private void Je() {
        d dVar = new d(this.bcr, this.mVideoUrl, this.boR.IU(), this.mVideoWidth, this.mVideoHeight, this.bcs);
        this.bbU = new com.baidu.swan.apps.media.c.a(getContext(), dVar.Jj());
        this.bbU.a(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.c.b
            public void a(l lVar) {
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(l lVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(l lVar) {
                SwanAppAdLandingFragment.this.bci.bringToFront();
                SwanAppAdLandingFragment.this.bci.setVisibility(0);
                SwanAppAdLandingFragment.this.bcs = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bcb.fb("vplayend");
                SwanAppAdLandingFragment.this.bcb.fb("scard");
            }
        });
        this.bbU.d(dVar.Jj());
        this.bbU.cL(false);
    }

    private void n(ViewGroup viewGroup) {
        this.bch = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bci = (RelativeLayout) this.bch.findViewById(a.f.ad_tail_root);
        this.bcj = (SimpleDraweeView) this.bch.findViewById(a.f.ad_tail_video_img);
        this.bck = (SimpleDraweeView) this.bch.findViewById(a.f.ad_tail_head_image);
        this.bcl = (TextView) this.bch.findViewById(a.f.ad_tail_brand_name);
        this.bcm = (TextView) this.bch.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bco)) {
            this.bcm.setText(this.bco);
            this.bcm.setVisibility(0);
        } else {
            this.bcm.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bcp)) {
            this.bcl.setText(this.bcp);
            this.bcl.setVisibility(0);
        } else {
            this.bcl.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bcq)) {
            this.bck.setImageURI(Uri.parse(this.bcq));
            this.bck.setVisibility(0);
        } else {
            this.bck.setVisibility(8);
        }
        this.bcj.getHierarchy().q(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bcr)) {
            this.bcj.setImageURI(q.getUri(this.bcr));
        }
        this.bcj.setVisibility(0);
        this.bcj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bck.setOnClickListener(this.bct);
        this.bcl.setOnClickListener(this.bct);
        this.bcm.setOnClickListener(this.bct);
        viewGroup.addView(this.bci, layoutParams);
        this.bci.setVisibility(4);
    }

    private void o(ViewGroup viewGroup) {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void p(ViewGroup viewGroup) {
        this.boR = IM();
        this.boR.a(Jh());
        this.bbl = this.boR.IS();
        this.boR.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.bbl.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.cF("#FFFFFF");
        this.boR.a(frameLayout, cVar);
        this.boR.a(frameLayout, covertToView);
        if (Jf()) {
            layoutParams.topMargin = this.mVideoHeight;
        }
        viewGroup.addView(frameLayout);
        covertToView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean IN() {
        if (isLandScape() && this.bbU != null) {
            return this.bbU.onBackPressed();
        }
        this.bcb.fb("lpout");
        return super.IN();
    }

    private boolean Jf() {
        return this.bca == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return auD().getResources().getConfiguration().orientation == 2;
    }

    private void Jg() {
        DisplayMetrics displayMetrics = auD().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(boolean z) {
        this.bnK.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.h
    public f IM() {
        SwanAppAdLandingWebViewWidget swanAppAdLandingWebViewWidget = new SwanAppAdLandingWebViewWidget(getContext());
        if (this.bcf != null && this.bcd != null && !TextUtils.isEmpty(this.bcf.url) && !TextUtils.isEmpty(this.bcf.name)) {
            swanAppAdLandingWebViewWidget.IS().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (SwanAppAdLandingFragment.DEBUG) {
                        Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                    }
                    if (ai.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bcf.name)) {
                        SwanAppAdLandingFragment.this.bcc.removeView(SwanAppAdLandingFragment.this.bcd.getRealView());
                        SwanAppAdLandingFragment.this.bcc.addView(SwanAppAdLandingFragment.this.bcd.getRealView());
                        SwanAppAdLandingFragment.this.bcd.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bcf.url)) {
                        SwanAppAdLandingFragment.this.bcf.url = str;
                    }
                    com.baidu.swan.apps.w.a.Uj().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bcf.Jk(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bce);
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
    protected com.baidu.swan.apps.core.f.d Jh() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.bZ(SwanAppAdLandingFragment.this.bbl.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void em(final String str) {
                SwanAppAdLandingFragment.this.bZ(SwanAppAdLandingFragment.this.bbl.canGoBack());
                SwanAppAdLandingFragment.this.bnK.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.bnK.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bnK.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.bnK.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.OG();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean Ji() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (Jf()) {
            this.bcb.fb("vplayend");
        }
        if (this.bbU != null) {
            this.bbU.onDestroy();
        }
        super.onDestroy();
    }
}
