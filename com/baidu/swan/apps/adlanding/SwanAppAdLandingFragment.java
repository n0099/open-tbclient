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
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.t;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.t.b.j;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int bVA;
    private String bVB;
    private String bVC;
    private String bVD;
    private String bVE;
    private com.baidu.swan.apps.media.b.a bVg;
    private JSONObject bVh;
    private b bVm;
    private FrameLayout bVn;
    private g bVq;
    private com.baidu.swan.apps.adlanding.download.a.a bVr;
    private com.baidu.swan.apps.adlanding.download.model.a bVs;
    private RelativeLayout bVu;
    private RelativeLayout bVv;
    private SimpleDraweeView bVw;
    private SimpleDraweeView bVx;
    private TextView bVy;
    private TextView bVz;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bVl = LandingType.NORMAL;
    private String mFrom = "";
    private final String bVo = "swan-custom-ad";
    private final int bVp = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bVt = SwanAdDownloadState.NOT_START;
    private int bVF = 0;
    private int bVG = 0;
    private boolean bVH = true;
    private View.OnClickListener bVI = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bVA == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bVm.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.bP(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.bVG;
        swanAppAdLandingFragment.bVG = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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

    private void abR() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.bVE = jSONObject.optString("w_picurl", "");
                    this.bVD = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bVA = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bVA == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bVB = string;
                    this.bVC = jSONObject.optString("appname", "");
                    this.bVF = jSONObject.optInt("currentTime", 0);
                    this.bVh = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bVl = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        abR();
        FragmentActivity aVF = aVF();
        if (aVF != null) {
            this.bVH = 1 == aVF.getRequestedOrientation();
            if (!this.bVH) {
                setRequestedOrientation(1);
            }
        }
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        ak(inflate);
        this.bVn = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        abU();
        A(this.bVn);
        q(this.bVn);
        if (abT()) {
            abS();
            z(this.bVn);
        }
        a(this.bVn);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bVm = new b(getContext(), this.bVh, this.bVg);
        this.bVm.je("lpin");
        return enableSliding(initImmersion, this);
    }

    private void abS() {
        d dVar = new d(this.bVE, this.mVideoUrl, this.ckC.abD(), this.mVideoWidth, this.mVideoHeight, this.bVF);
        this.bVg = new com.baidu.swan.apps.media.b.a(getContext(), dVar.abZ());
        this.bVg.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.bVv.bringToFront();
                SwanAppAdLandingFragment.this.bVv.setVisibility(0);
                SwanAppAdLandingFragment.this.bVF = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bVm.je("vplayend");
                SwanAppAdLandingFragment.this.bVm.je("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.bVm.je("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.bVG == 0) {
                    SwanAppAdLandingFragment.this.bVm.je("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.bVv.setVisibility(8);
                SwanAppAdLandingFragment.this.bVm.je("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.bVm.je("vpause");
            }
        });
        this.bVg.d(dVar.abZ());
        this.bVg.eA(false);
    }

    private void z(ViewGroup viewGroup) {
        this.bVu = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bVv = (RelativeLayout) this.bVu.findViewById(a.f.ad_tail_root);
        this.bVw = (SimpleDraweeView) this.bVu.findViewById(a.f.ad_tail_video_img);
        this.bVx = (SimpleDraweeView) this.bVu.findViewById(a.f.ad_tail_head_image);
        this.bVy = (TextView) this.bVu.findViewById(a.f.ad_tail_brand_name);
        this.bVz = (TextView) this.bVu.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bVB)) {
            this.bVz.setText(this.bVB);
            this.bVz.setVisibility(0);
        } else {
            this.bVz.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bVC)) {
            this.bVy.setText(this.bVC);
            this.bVy.setVisibility(0);
        } else {
            this.bVy.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bVD)) {
            this.bVx.setImageURI(Uri.parse(this.bVD));
            this.bVx.setVisibility(0);
        } else {
            this.bVx.setVisibility(8);
        }
        this.bVw.getHierarchy().m(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bVE)) {
            this.bVw.setImageURI(t.getUri(this.bVE));
        }
        this.bVw.setVisibility(0);
        this.bVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bVx.setOnClickListener(this.bVI);
        this.bVy.setOnClickListener(this.bVI);
        this.bVz.setOnClickListener(this.bVI);
        viewGroup.addView(this.bVv, layoutParams);
        this.bVv.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aDP().putString(this.bVs.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jg(String str) {
        return h.aDP().getString(str, "");
    }

    private void A(final ViewGroup viewGroup) {
        g aqo = com.baidu.swan.apps.t.a.aqo();
        if (aqo != null) {
            this.bVr = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void dy(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.bVq.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.bVq.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.bVq.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void jh(String str) {
                    SwanAppAdLandingFragment.this.jf(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.bVq.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.bVt != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.bVt == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.bVm.je("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.bVm.je("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.bVt == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.bVm.je("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.bVm.je("appdownloadfinish");
                            SwanAppAdLandingFragment.this.bVm.je("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.bVm.je("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.bVt = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.bVq.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void abX() {
                    SwanAppAdLandingFragment.this.bVm.je("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String abY() {
                    SwanAppAdLandingFragment.this.bVm.je("appinstallopen");
                    return SwanAppAdLandingFragment.this.jg(SwanAppAdLandingFragment.this.bVs.url);
                }
            };
            this.bVs = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.bVq = aqo.a(getContext(), this.bVs, this.bVr);
            this.bVq.M(this.bVs);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void q(ViewGroup viewGroup) {
        this.ckC = abu();
        this.ckC.a(abV());
        this.bTV = this.ckC.abB();
        this.ckC.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.bTV.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.fq("#FFFFFF");
        this.ckC.b(frameLayout, cVar);
        this.ckC.a(frameLayout, cVar);
        this.ckC.a(frameLayout, covertToView);
        if (abT()) {
            layoutParams.topMargin = this.mVideoHeight;
        }
        if (TextUtils.equals("swan-custom-ad", this.mFrom)) {
            b(viewGroup, frameLayout);
        } else {
            viewGroup.addView(frameLayout);
        }
        covertToView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aj(View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return view.getGlobalVisibleRect(new Rect());
    }

    private void b(final ViewGroup viewGroup, final ViewGroup viewGroup2) {
        final LinearLayout linearLayout = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_footer_view, (ViewGroup) null)).findViewById(a.f.ad_footer);
        final CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.addView(linearLayout, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.swanapp_ad_dimens_footer_height)));
        customerAdScrollView.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.ckC.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.bTV.getContentHeight()) * SwanAppAdLandingFragment.this.bTV.getScale()) - ((float) SwanAppAdLandingFragment.this.bTV.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.bTV.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.ckC.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void hp(String str) {
                super.hp(str);
                if (Math.abs((SwanAppAdLandingFragment.this.bTV.getContentHeight() * SwanAppAdLandingFragment.this.bTV.getScale()) - SwanAppAdLandingFragment.this.bTV.covertToView().getHeight()) < 10.0f) {
                    customerAdScrollView.setIsWebViewOnBottom(true);
                } else {
                    customerAdScrollView.setIsWebViewOnBottom(false);
                }
            }
        });
        customerAdScrollView.setScrollViewListener(new com.baidu.swan.apps.adlanding.customer.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.10
            @Override // com.baidu.swan.apps.adlanding.customer.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.aj(linearLayout));
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean abv() {
        if (isLandScape() && this.bVg != null) {
            return this.bVg.onBackPressed();
        }
        this.bVm.je("lpout");
        return super.abv();
    }

    private boolean abT() {
        return this.bVl == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return aVF().getResources().getConfiguration().orientation == 2;
    }

    private void abU() {
        DisplayMetrics displayMetrics = aVF().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(boolean z) {
        this.cju.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f abu() {
        e eVar = new e(getContext());
        eVar.abB().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.bVq.aaP();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bVs.name)) {
                    String jg = SwanAppAdLandingFragment.this.jg(str);
                    SwanAppAdLandingFragment.this.bVs.name = jg;
                    SwanAppAdLandingFragment.this.bVq.ja(jg);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bVs.name)) {
                    SwanAppAdLandingFragment.this.bVn.removeView(SwanAppAdLandingFragment.this.bVq.getRealView());
                    SwanAppAdLandingFragment.this.bVn.addView(SwanAppAdLandingFragment.this.bVq.getRealView());
                    SwanAppAdLandingFragment.this.bVq.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bVs.url)) {
                    SwanAppAdLandingFragment.this.bVs.url = str;
                }
                com.baidu.swan.apps.t.a.apE().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bVs.aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bVr);
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onPlayVideo(String str) {
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadFlash(String str) {
            }
        });
        return eVar;
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d abV() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.dx(SwanAppAdLandingFragment.this.bTV.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void hQ(final String str) {
                SwanAppAdLandingFragment.this.dx(SwanAppAdLandingFragment.this.bTV.canGoBack());
                SwanAppAdLandingFragment.this.cju.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cju.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ak(View view) {
        super.ak(view);
        this.cju.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cju.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.aik();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean abW() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (abT()) {
            this.bVm.je("vplayend");
        }
        if (this.bVg != null) {
            this.bVg.onDestroy();
        }
        if (!this.bVH) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
