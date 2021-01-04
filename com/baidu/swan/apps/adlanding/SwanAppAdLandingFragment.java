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
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.t;
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
/* loaded from: classes9.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.b.a cFR;
    private JSONObject cFS;
    private b cFX;
    private FrameLayout cFY;
    private g cGb;
    private com.baidu.swan.apps.adlanding.download.a.a cGc;
    private com.baidu.swan.apps.adlanding.download.model.a cGd;
    private RelativeLayout cGf;
    private RelativeLayout cGg;
    private SimpleDraweeView cGh;
    private SimpleDraweeView cGi;
    private TextView cGj;
    private TextView cGk;
    private int cGl;
    private String cGm;
    private String cGn;
    private String cGo;
    private String cGp;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType cFW = LandingType.NORMAL;
    private String mFrom = "";
    private final String cFZ = "swan-custom-ad";
    private final int cGa = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState cGe = SwanAdDownloadState.NOT_START;
    private int cGq = 0;
    private int cGr = 0;
    private boolean cGs = true;
    private View.OnClickListener cGt = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.cGl == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.cFX.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.cg(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.cGr;
        swanAppAdLandingFragment.cGr = i + 1;
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

    private void amH() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.cGp = jSONObject.optString("w_picurl", "");
                    this.cGo = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.cGl = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.cGl == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.cGm = string;
                    this.cGn = jSONObject.optString("appname", "");
                    this.cGq = jSONObject.optInt("currentTime", 0);
                    this.cFS = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.cFW = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        amH();
        FragmentActivity bhA = bhA();
        if (bhA != null) {
            this.cGs = 1 == bhA.getRequestedOrientation();
            if (!this.cGs) {
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
        av(inflate);
        this.cFY = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        amK();
        E(this.cFY);
        q(this.cFY);
        if (amJ()) {
            amI();
            D(this.cFY);
        }
        e(this.cFY);
        View az = ase() ? az(inflate) : inflate;
        this.cFX = new b(getContext(), this.cFS, this.cFR);
        this.cFX.kS("lpin");
        return a(az, this);
    }

    private void amI() {
        d dVar = new d(this.cGp, this.mVideoUrl, this.cVp.amt(), this.mVideoWidth, this.mVideoHeight, this.cGq);
        this.cFR = new com.baidu.swan.apps.media.b.a(getContext(), dVar.amP());
        this.cFR.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.cGg.bringToFront();
                SwanAppAdLandingFragment.this.cGg.setVisibility(0);
                SwanAppAdLandingFragment.this.cGq = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.cFX.kS("vplayend");
                SwanAppAdLandingFragment.this.cFX.kS("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.cFX.kS("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.cGr == 0) {
                    SwanAppAdLandingFragment.this.cFX.kS("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.cGg.setVisibility(8);
                SwanAppAdLandingFragment.this.cFX.kS("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.cFX.kS("vpause");
            }
        });
        this.cFR.d(dVar.amP());
        this.cFR.fT(false);
    }

    private void D(ViewGroup viewGroup) {
        this.cGf = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.cGg = (RelativeLayout) this.cGf.findViewById(a.f.ad_tail_root);
        this.cGh = (SimpleDraweeView) this.cGf.findViewById(a.f.ad_tail_video_img);
        this.cGi = (SimpleDraweeView) this.cGf.findViewById(a.f.ad_tail_head_image);
        this.cGj = (TextView) this.cGf.findViewById(a.f.ad_tail_brand_name);
        this.cGk = (TextView) this.cGf.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.cGm)) {
            this.cGk.setText(this.cGm);
            this.cGk.setVisibility(0);
        } else {
            this.cGk.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.cGn)) {
            this.cGj.setText(this.cGn);
            this.cGj.setVisibility(0);
        } else {
            this.cGj.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.cGo)) {
            this.cGi.setImageURI(Uri.parse(this.cGo));
            this.cGi.setVisibility(0);
        } else {
            this.cGi.setVisibility(8);
        }
        this.cGh.getHierarchy().A(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.cGp)) {
            this.cGh.setImageURI(t.uN(this.cGp));
        }
        this.cGh.setVisibility(0);
        this.cGh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.cGi.setOnClickListener(this.cGt);
        this.cGj.setOnClickListener(this.cGt);
        this.cGk.setOnClickListener(this.cGt);
        viewGroup.addView(this.cGg, layoutParams);
        this.cGg.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kT(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aPH().putString(this.cGd.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kU(String str) {
        return h.aPH().getString(str, "");
    }

    private void E(final ViewGroup viewGroup) {
        g aBl = com.baidu.swan.apps.t.a.aBl();
        if (aBl != null) {
            this.cGc = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eR(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.cGb.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.cGb.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.cGb.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void kV(String str) {
                    SwanAppAdLandingFragment.this.kT(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cGb.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.cGe != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.cGe == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cFX.kS("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.cFX.kS("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.cGe == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cFX.kS("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.cFX.kS("appdownloadfinish");
                            SwanAppAdLandingFragment.this.cFX.kS("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.cFX.kS("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.cGe = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cGb.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void amN() {
                    SwanAppAdLandingFragment.this.cFX.kS("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String amO() {
                    SwanAppAdLandingFragment.this.cFX.kS("appinstallopen");
                    return SwanAppAdLandingFragment.this.kU(SwanAppAdLandingFragment.this.cGd.url);
                }
            };
            this.cGd = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.cGb = aBl.a(getContext(), this.cGd, this.cGc);
            this.cGb.P(this.cGd);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void q(ViewGroup viewGroup) {
        this.cVp = amk();
        this.cVp.a(amL());
        this.cEG = this.cVp.amr();
        this.cVp.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.cEG.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.sF("#FFFFFF");
        this.cVp.b(frameLayout, cVar);
        this.cVp.a(frameLayout, cVar);
        this.cVp.b(frameLayout, covertToView);
        if (amJ()) {
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
    public boolean au(View view) {
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
        this.cVp.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.cEG.getContentHeight()) * SwanAppAdLandingFragment.this.cEG.getScale()) - ((float) SwanAppAdLandingFragment.this.cEG.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.cEG.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.cVp.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void ig(String str) {
                super.ig(str);
                if (Math.abs((SwanAppAdLandingFragment.this.cEG.getContentHeight() * SwanAppAdLandingFragment.this.cEG.getScale()) - SwanAppAdLandingFragment.this.cEG.covertToView().getHeight()) < 10.0f) {
                    customerAdScrollView.setIsWebViewOnBottom(true);
                } else {
                    customerAdScrollView.setIsWebViewOnBottom(false);
                }
            }
        });
        customerAdScrollView.setScrollViewListener(new com.baidu.swan.apps.adlanding.customer.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.10
            @Override // com.baidu.swan.apps.adlanding.customer.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.au(linearLayout));
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean aml() {
        if (isLandScape() && this.cFR != null) {
            return this.cFR.onBackPressed();
        }
        this.cFX.kS("lpout");
        return super.aml();
    }

    private boolean amJ() {
        return this.cFW == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return bhA().getResources().getConfiguration().orientation == 2;
    }

    private void amK() {
        DisplayMetrics displayMetrics = bhA().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(boolean z) {
        this.cUf.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f amk() {
        e eVar = new e(getContext());
        eVar.amr().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.cGb.alF();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cGd.name)) {
                    String kU = SwanAppAdLandingFragment.this.kU(str);
                    SwanAppAdLandingFragment.this.cGd.name = kU;
                    SwanAppAdLandingFragment.this.cGb.kO(kU);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cGd.name)) {
                    SwanAppAdLandingFragment.this.cFY.removeView(SwanAppAdLandingFragment.this.cGb.getRealView());
                    SwanAppAdLandingFragment.this.cFY.addView(SwanAppAdLandingFragment.this.cGb.getRealView());
                    SwanAppAdLandingFragment.this.cGb.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cGd.url)) {
                    SwanAppAdLandingFragment.this.cGd.url = str;
                }
                com.baidu.swan.apps.t.a.aAB().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cGd.amQ(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.cGc);
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
    protected com.baidu.swan.apps.core.f.d amL() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.eQ(SwanAppAdLandingFragment.this.cEG.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void jg(final String str) {
                SwanAppAdLandingFragment.this.eQ(SwanAppAdLandingFragment.this.cEG.canGoBack());
                SwanAppAdLandingFragment.this.cUf.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cUf.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void av(View view) {
        super.av(view);
        this.cUf.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cUf.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.ath();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean amM() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (amJ()) {
            this.cFX.kS("vplayend");
        }
        if (this.cFR != null) {
            this.cFR.onDestroy();
        }
        if (!this.cGs) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
