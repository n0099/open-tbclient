package com.baidu.swan.apps.adlanding;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.browser.sailor.ISailorDownloadListener;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.adlanding.customer.CustomerAdScrollView;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.r;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.u.b.j;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SwanAppAdLandingFragment extends h {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.b.a bMP;
    private JSONObject bMQ;
    private b bMV;
    private FrameLayout bMW;
    private g bMZ;
    private com.baidu.swan.apps.adlanding.download.a.a bNa;
    private com.baidu.swan.apps.adlanding.download.model.a bNb;
    private RelativeLayout bNd;
    private RelativeLayout bNe;
    private SimpleDraweeView bNf;
    private SimpleDraweeView bNg;
    private TextView bNh;
    private TextView bNi;
    private int bNj;
    private String bNk;
    private String bNl;
    private String bNm;
    private String bNn;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bMU = LandingType.NORMAL;
    private String mFrom = "";
    private final String bMX = "swan-custom-ad";
    private final int bMY = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bNc = SwanAdDownloadState.NOT_START;
    private int bNo = 0;
    private int playCount = 0;
    private View.OnClickListener bNp = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bNj == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bMV.d("c", hashMap);
            h.b("adLanding", com.baidu.swan.apps.model.b.bz(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
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

    private void Uz() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.bNn = jSONObject.optString("w_picurl", "");
                    this.bNm = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bNj = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bNj == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bNk = string;
                    this.bNl = jSONObject.optString("appname", "");
                    this.bNo = jSONObject.optInt("currentTime", 0);
                    this.bMQ = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bMU = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Uz();
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bMW = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        UC();
        v(this.bMW);
        w(this.bMW);
        if (UB()) {
            UA();
            u(this.bMW);
        }
        a(this.bMW);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bMV = new b(getContext(), this.bMQ, this.bMP);
        this.bMV.hi("lpin");
        return enableSliding(initImmersion, this);
    }

    private void UA() {
        d dVar = new d(this.bNn, this.mVideoUrl, this.caX.Up(), this.mVideoWidth, this.mVideoHeight, this.bNo);
        this.bMP = new com.baidu.swan.apps.media.b.a(getContext(), dVar.UF());
        this.bMP.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.bNe.bringToFront();
                SwanAppAdLandingFragment.this.bNe.setVisibility(0);
                SwanAppAdLandingFragment.this.bNo = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bMV.hi("vplayend");
                SwanAppAdLandingFragment.this.bMV.hi("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.bMV.hi("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.playCount == 0) {
                    SwanAppAdLandingFragment.this.bMV.hi("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.bNe.setVisibility(8);
                SwanAppAdLandingFragment.this.bMV.hi("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.bMV.hi("vpause");
            }
        });
        this.bMP.d(dVar.UF());
        this.bMP.ec(false);
    }

    private void u(ViewGroup viewGroup) {
        this.bNd = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bNe = (RelativeLayout) this.bNd.findViewById(a.f.ad_tail_root);
        this.bNf = (SimpleDraweeView) this.bNd.findViewById(a.f.ad_tail_video_img);
        this.bNg = (SimpleDraweeView) this.bNd.findViewById(a.f.ad_tail_head_image);
        this.bNh = (TextView) this.bNd.findViewById(a.f.ad_tail_brand_name);
        this.bNi = (TextView) this.bNd.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bNk)) {
            this.bNi.setText(this.bNk);
            this.bNi.setVisibility(0);
        } else {
            this.bNi.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bNl)) {
            this.bNh.setText(this.bNl);
            this.bNh.setVisibility(0);
        } else {
            this.bNh.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bNm)) {
            this.bNg.setImageURI(Uri.parse(this.bNm));
            this.bNg.setVisibility(0);
        } else {
            this.bNg.setVisibility(8);
        }
        this.bNf.getHierarchy().m(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bNn)) {
            this.bNf.setImageURI(r.getUri(this.bNn));
        }
        this.bNf.setVisibility(0);
        this.bNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bNg.setOnClickListener(this.bNp);
        this.bNh.setOnClickListener(this.bNp);
        this.bNi.setOnClickListener(this.bNp);
        viewGroup.addView(this.bNe, layoutParams);
        this.bNe.setVisibility(4);
    }

    private void v(final ViewGroup viewGroup) {
        g agP = com.baidu.swan.apps.u.a.agP();
        if (agP != null && this.bMZ != null) {
            this.bNa = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
            };
            this.bNb = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.bMZ = agP.a(getContext(), this.bNb, this.bNa);
            this.bMZ.J(this.bNb);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void w(ViewGroup viewGroup) {
        this.caX = Uh();
        this.caX.a(UD());
        this.bLW = this.caX.Un();
        this.caX.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.bLW.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.dV("#FFFFFF");
        this.caX.b(frameLayout, cVar);
        this.caX.a(frameLayout, cVar);
        this.caX.a(frameLayout, covertToView);
        if (UB()) {
            layoutParams.topMargin = this.mVideoHeight;
        }
        if (TextUtils.equals("swan-custom-ad", this.mFrom)) {
            a(viewGroup, frameLayout);
        } else {
            viewGroup.addView(frameLayout);
        }
        covertToView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ad(View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return view.getGlobalVisibleRect(new Rect());
    }

    private void a(final ViewGroup viewGroup, final ViewGroup viewGroup2) {
        final LinearLayout linearLayout = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_footer_view, (ViewGroup) null)).findViewById(a.f.ad_footer);
        final CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.addView(linearLayout, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.swanapp_ad_dimens_footer_height)));
        customerAdScrollView.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.caX.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.bLW.getContentHeight()) * SwanAppAdLandingFragment.this.bLW.getScale()) - ((float) SwanAppAdLandingFragment.this.bLW.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.bLW.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.caX.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.b
            public void fJ(String str) {
                super.fJ(str);
                if (Math.abs((SwanAppAdLandingFragment.this.bLW.getContentHeight() * SwanAppAdLandingFragment.this.bLW.getScale()) - SwanAppAdLandingFragment.this.bLW.covertToView().getHeight()) < 10.0f) {
                    customerAdScrollView.setIsWebViewOnBottom(true);
                } else {
                    customerAdScrollView.setIsWebViewOnBottom(false);
                }
            }
        });
        customerAdScrollView.setScrollViewListener(new com.baidu.swan.apps.adlanding.customer.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.10
            @Override // com.baidu.swan.apps.adlanding.customer.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.ad(linearLayout));
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        if (isLandScape() && this.bMP != null) {
            return this.bMP.onBackPressed();
        }
        this.bMV.hi("lpout");
        return super.Ui();
    }

    private boolean UB() {
        return this.bMU == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return aIB().getResources().getConfiguration().orientation == 2;
    }

    private void UC() {
        DisplayMetrics displayMetrics = aIB().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(boolean z) {
        this.bZO.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.h
    public f Uh() {
        SwanAppAdLandingWebViewWidget swanAppAdLandingWebViewWidget = new SwanAppAdLandingWebViewWidget(getContext());
        if (this.bNb != null && !TextUtils.isEmpty(this.bNb.url) && !TextUtils.isEmpty(this.bNb.name)) {
            swanAppAdLandingWebViewWidget.Un().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (SwanAppAdLandingFragment.DEBUG) {
                        Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                    }
                    if (aj.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bNb.name)) {
                        SwanAppAdLandingFragment.this.bMW.removeView(SwanAppAdLandingFragment.this.bMZ.getRealView());
                        SwanAppAdLandingFragment.this.bMW.addView(SwanAppAdLandingFragment.this.bMZ.getRealView());
                        SwanAppAdLandingFragment.this.bMZ.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bNb.url)) {
                        SwanAppAdLandingFragment.this.bNb.url = str;
                    }
                    com.baidu.swan.apps.u.a.agh().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bNb.UG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bNa);
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
    protected com.baidu.swan.apps.core.f.d UD() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.dn(SwanAppAdLandingFragment.this.bLW.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void fZ(final String str) {
                SwanAppAdLandingFragment.this.dn(SwanAppAdLandingFragment.this.bLW.canGoBack());
                SwanAppAdLandingFragment.this.bZO.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.bZO.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bZO.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.bZO.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.aam();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean UE() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (UB()) {
            this.bMV.hi("vplayend");
        }
        if (this.bMP != null) {
            this.bMP.onDestroy();
        }
        super.onDestroy();
    }
}
