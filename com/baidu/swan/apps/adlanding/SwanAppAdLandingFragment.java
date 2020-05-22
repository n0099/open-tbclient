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
    private com.baidu.swan.apps.media.b.a bIb;
    private JSONObject bIc;
    private b bIh;
    private FrameLayout bIi;
    private g bIl;
    private com.baidu.swan.apps.adlanding.download.a.a bIm;
    private com.baidu.swan.apps.adlanding.download.model.a bIn;
    private RelativeLayout bIp;
    private RelativeLayout bIq;
    private SimpleDraweeView bIr;
    private SimpleDraweeView bIs;
    private TextView bIt;
    private TextView bIu;
    private int bIv;
    private String bIw;
    private String bIx;
    private String bIy;
    private String bIz;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bIg = LandingType.NORMAL;
    private String mFrom = "";
    private final String bIj = "swan-custom-ad";
    private final int bIk = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bIo = SwanAdDownloadState.NOT_START;
    private int bIA = 0;
    private int playCount = 0;
    private View.OnClickListener bIB = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bIv == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bIh.d("c", hashMap);
            h.b("adLanding", com.baidu.swan.apps.model.b.bx(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
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

    private void Tt() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.bIz = jSONObject.optString("w_picurl", "");
                    this.bIy = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bIv = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bIv == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bIw = string;
                    this.bIx = jSONObject.optString("appname", "");
                    this.bIA = jSONObject.optInt("currentTime", 0);
                    this.bIc = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bIg = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Tt();
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ae(inflate);
        this.bIi = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        Tw();
        t(this.bIi);
        u(this.bIi);
        if (Tv()) {
            Tu();
            s(this.bIi);
        }
        a(this.bIi);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bIh = new b(getContext(), this.bIc, this.bIb);
        this.bIh.ha("lpin");
        return enableSliding(initImmersion, this);
    }

    private void Tu() {
        d dVar = new d(this.bIz, this.mVideoUrl, this.bWj.Tj(), this.mVideoWidth, this.mVideoHeight, this.bIA);
        this.bIb = new com.baidu.swan.apps.media.b.a(getContext(), dVar.Tz());
        this.bIb.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.bIq.bringToFront();
                SwanAppAdLandingFragment.this.bIq.setVisibility(0);
                SwanAppAdLandingFragment.this.bIA = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bIh.ha("vplayend");
                SwanAppAdLandingFragment.this.bIh.ha("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.bIh.ha("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.playCount == 0) {
                    SwanAppAdLandingFragment.this.bIh.ha("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.bIq.setVisibility(8);
                SwanAppAdLandingFragment.this.bIh.ha("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.bIh.ha("vpause");
            }
        });
        this.bIb.d(dVar.Tz());
        this.bIb.dX(false);
    }

    private void s(ViewGroup viewGroup) {
        this.bIp = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bIq = (RelativeLayout) this.bIp.findViewById(a.f.ad_tail_root);
        this.bIr = (SimpleDraweeView) this.bIp.findViewById(a.f.ad_tail_video_img);
        this.bIs = (SimpleDraweeView) this.bIp.findViewById(a.f.ad_tail_head_image);
        this.bIt = (TextView) this.bIp.findViewById(a.f.ad_tail_brand_name);
        this.bIu = (TextView) this.bIp.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bIw)) {
            this.bIu.setText(this.bIw);
            this.bIu.setVisibility(0);
        } else {
            this.bIu.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bIx)) {
            this.bIt.setText(this.bIx);
            this.bIt.setVisibility(0);
        } else {
            this.bIt.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bIy)) {
            this.bIs.setImageURI(Uri.parse(this.bIy));
            this.bIs.setVisibility(0);
        } else {
            this.bIs.setVisibility(8);
        }
        this.bIr.getHierarchy().m(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bIz)) {
            this.bIr.setImageURI(r.getUri(this.bIz));
        }
        this.bIr.setVisibility(0);
        this.bIr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bIs.setOnClickListener(this.bIB);
        this.bIt.setOnClickListener(this.bIB);
        this.bIu.setOnClickListener(this.bIB);
        viewGroup.addView(this.bIq, layoutParams);
        this.bIq.setVisibility(4);
    }

    private void t(final ViewGroup viewGroup) {
        g afJ = com.baidu.swan.apps.u.a.afJ();
        if (afJ != null && this.bIl != null) {
            this.bIm = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
            };
            this.bIn = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.bIl = afJ.a(getContext(), this.bIn, this.bIm);
            this.bIl.J(this.bIn);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void u(ViewGroup viewGroup) {
        this.bWj = Tb();
        this.bWj.a(Tx());
        this.bHi = this.bWj.Th();
        this.bWj.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.bHi.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.dT("#FFFFFF");
        this.bWj.b(frameLayout, cVar);
        this.bWj.a(frameLayout, cVar);
        this.bWj.a(frameLayout, covertToView);
        if (Tv()) {
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
        this.bWj.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.bHi.getContentHeight()) * SwanAppAdLandingFragment.this.bHi.getScale()) - ((float) SwanAppAdLandingFragment.this.bHi.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.bHi.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.bWj.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.b
            public void fQ(String str) {
                super.fQ(str);
                if (Math.abs((SwanAppAdLandingFragment.this.bHi.getContentHeight() * SwanAppAdLandingFragment.this.bHi.getScale()) - SwanAppAdLandingFragment.this.bHi.covertToView().getHeight()) < 10.0f) {
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
    public boolean Tc() {
        if (isLandScape() && this.bIb != null) {
            return this.bIb.onBackPressed();
        }
        this.bIh.ha("lpout");
        return super.Tc();
    }

    private boolean Tv() {
        return this.bIg == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return aHv().getResources().getConfiguration().orientation == 2;
    }

    private void Tw() {
        DisplayMetrics displayMetrics = aHv().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(boolean z) {
        this.bVa.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.h
    public f Tb() {
        SwanAppAdLandingWebViewWidget swanAppAdLandingWebViewWidget = new SwanAppAdLandingWebViewWidget(getContext());
        if (this.bIn != null && !TextUtils.isEmpty(this.bIn.url) && !TextUtils.isEmpty(this.bIn.name)) {
            swanAppAdLandingWebViewWidget.Th().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
                @Override // com.baidu.browser.sailor.ISailorDownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (SwanAppAdLandingFragment.DEBUG) {
                        Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                    }
                    if (aj.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bIn.name)) {
                        SwanAppAdLandingFragment.this.bIi.removeView(SwanAppAdLandingFragment.this.bIl.getRealView());
                        SwanAppAdLandingFragment.this.bIi.addView(SwanAppAdLandingFragment.this.bIl.getRealView());
                        SwanAppAdLandingFragment.this.bIl.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bIn.url)) {
                        SwanAppAdLandingFragment.this.bIn.url = str;
                    }
                    com.baidu.swan.apps.u.a.afb().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bIn.TA(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bIm);
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
    protected com.baidu.swan.apps.core.f.d Tx() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.di(SwanAppAdLandingFragment.this.bHi.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void fR(final String str) {
                SwanAppAdLandingFragment.this.di(SwanAppAdLandingFragment.this.bHi.canGoBack());
                SwanAppAdLandingFragment.this.bVa.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.bVa.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bVa.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.bVa.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.Zg();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected boolean Ty() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (Tv()) {
            this.bIh.ha("vplayend");
        }
        if (this.bIb != null) {
            this.bIb.onDestroy();
        }
        super.onDestroy();
    }
}
