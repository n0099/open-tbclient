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
/* loaded from: classes8.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bTA;
    private com.baidu.swan.apps.media.b.a bTc;
    private JSONObject bTd;
    private b bTi;
    private FrameLayout bTj;
    private g bTm;
    private com.baidu.swan.apps.adlanding.download.a.a bTn;
    private com.baidu.swan.apps.adlanding.download.model.a bTo;
    private RelativeLayout bTq;
    private RelativeLayout bTr;
    private SimpleDraweeView bTs;
    private SimpleDraweeView bTt;
    private TextView bTu;
    private TextView bTv;
    private int bTw;
    private String bTx;
    private String bTy;
    private String bTz;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bTh = LandingType.NORMAL;
    private String mFrom = "";
    private final String bTk = "swan-custom-ad";
    private final int bTl = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bTp = SwanAdDownloadState.NOT_START;
    private int bTB = 0;
    private int bTC = 0;
    private boolean bTD = true;
    private View.OnClickListener bTE = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bTw == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bTi.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.bP(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.bTC;
        swanAppAdLandingFragment.bTC = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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

    private void abi() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.bTA = jSONObject.optString("w_picurl", "");
                    this.bTz = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bTw = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bTw == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bTx = string;
                    this.bTy = jSONObject.optString("appname", "");
                    this.bTB = jSONObject.optInt("currentTime", 0);
                    this.bTd = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bTh = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        abi();
        FragmentActivity aUT = aUT();
        if (aUT != null) {
            this.bTD = 1 == aUT.getRequestedOrientation();
            if (!this.bTD) {
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
        ai(inflate);
        this.bTj = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        abl();
        x(this.bTj);
        y(this.bTj);
        if (abk()) {
            abj();
            w(this.bTj);
        }
        a(this.bTj);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bTi = new b(getContext(), this.bTd, this.bTc);
        this.bTi.iK("lpin");
        return enableSliding(initImmersion, this);
    }

    private void abj() {
        d dVar = new d(this.bTA, this.mVideoUrl, this.cix.aaU(), this.mVideoWidth, this.mVideoHeight, this.bTB);
        this.bTc = new com.baidu.swan.apps.media.b.a(getContext(), dVar.abq());
        this.bTc.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.bTr.bringToFront();
                SwanAppAdLandingFragment.this.bTr.setVisibility(0);
                SwanAppAdLandingFragment.this.bTB = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bTi.iK("vplayend");
                SwanAppAdLandingFragment.this.bTi.iK("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.bTi.iK("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.bTC == 0) {
                    SwanAppAdLandingFragment.this.bTi.iK("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.bTr.setVisibility(8);
                SwanAppAdLandingFragment.this.bTi.iK("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.bTi.iK("vpause");
            }
        });
        this.bTc.d(dVar.abq());
        this.bTc.eB(false);
    }

    private void w(ViewGroup viewGroup) {
        this.bTq = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bTr = (RelativeLayout) this.bTq.findViewById(a.f.ad_tail_root);
        this.bTs = (SimpleDraweeView) this.bTq.findViewById(a.f.ad_tail_video_img);
        this.bTt = (SimpleDraweeView) this.bTq.findViewById(a.f.ad_tail_head_image);
        this.bTu = (TextView) this.bTq.findViewById(a.f.ad_tail_brand_name);
        this.bTv = (TextView) this.bTq.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bTx)) {
            this.bTv.setText(this.bTx);
            this.bTv.setVisibility(0);
        } else {
            this.bTv.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bTy)) {
            this.bTu.setText(this.bTy);
            this.bTu.setVisibility(0);
        } else {
            this.bTu.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bTz)) {
            this.bTt.setImageURI(Uri.parse(this.bTz));
            this.bTt.setVisibility(0);
        } else {
            this.bTt.setVisibility(8);
        }
        this.bTs.getHierarchy().m(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bTA)) {
            this.bTs.setImageURI(t.getUri(this.bTA));
        }
        this.bTs.setVisibility(0);
        this.bTs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bTt.setOnClickListener(this.bTE);
        this.bTu.setOnClickListener(this.bTE);
        this.bTv.setOnClickListener(this.bTE);
        viewGroup.addView(this.bTr, layoutParams);
        this.bTr.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iL(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aDf().putString(this.bTo.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iM(String str) {
        return h.aDf().getString(str, "");
    }

    private void x(final ViewGroup viewGroup) {
        g apE = com.baidu.swan.apps.t.a.apE();
        if (apE != null) {
            this.bTn = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void dz(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.bTm.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.bTm.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.bTm.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void iN(String str) {
                    SwanAppAdLandingFragment.this.iL(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.bTm.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.bTp != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.bTp == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.bTi.iK("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.bTi.iK("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.bTp == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.bTi.iK("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.bTi.iK("appdownloadfinish");
                            SwanAppAdLandingFragment.this.bTi.iK("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.bTi.iK("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.bTp = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.bTm.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void abo() {
                    SwanAppAdLandingFragment.this.bTi.iK("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String abp() {
                    SwanAppAdLandingFragment.this.bTi.iK("appinstallopen");
                    return SwanAppAdLandingFragment.this.iM(SwanAppAdLandingFragment.this.bTo.url);
                }
            };
            this.bTo = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.bTm = apE.a(getContext(), this.bTo, this.bTn);
            this.bTm.L(this.bTo);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void y(ViewGroup viewGroup) {
        this.cix = aaL();
        this.cix.a(abm());
        this.bRR = this.cix.aaS();
        this.cix.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.bRR.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.fn("#FFFFFF");
        this.cix.b(frameLayout, cVar);
        this.cix.a(frameLayout, cVar);
        this.cix.a(frameLayout, covertToView);
        if (abk()) {
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
    public boolean ah(View view) {
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
        this.cix.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.bRR.getContentHeight()) * SwanAppAdLandingFragment.this.bRR.getScale()) - ((float) SwanAppAdLandingFragment.this.bRR.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.bRR.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.cix.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void hs(String str) {
                super.hs(str);
                if (Math.abs((SwanAppAdLandingFragment.this.bRR.getContentHeight() * SwanAppAdLandingFragment.this.bRR.getScale()) - SwanAppAdLandingFragment.this.bRR.covertToView().getHeight()) < 10.0f) {
                    customerAdScrollView.setIsWebViewOnBottom(true);
                } else {
                    customerAdScrollView.setIsWebViewOnBottom(false);
                }
            }
        });
        customerAdScrollView.setScrollViewListener(new com.baidu.swan.apps.adlanding.customer.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.10
            @Override // com.baidu.swan.apps.adlanding.customer.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.ah(linearLayout));
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        if (isLandScape() && this.bTc != null) {
            return this.bTc.onBackPressed();
        }
        this.bTi.iK("lpout");
        return super.aaM();
    }

    private boolean abk() {
        return this.bTh == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return aUT().getResources().getConfiguration().orientation == 2;
    }

    private void abl() {
        DisplayMetrics displayMetrics = aUT().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(boolean z) {
        this.cho.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f aaL() {
        e eVar = new e(getContext());
        eVar.aaS().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.bTm.aag();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bTo.name)) {
                    String iM = SwanAppAdLandingFragment.this.iM(str);
                    SwanAppAdLandingFragment.this.bTo.name = iM;
                    SwanAppAdLandingFragment.this.bTm.iG(iM);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bTo.name)) {
                    SwanAppAdLandingFragment.this.bTj.removeView(SwanAppAdLandingFragment.this.bTm.getRealView());
                    SwanAppAdLandingFragment.this.bTj.addView(SwanAppAdLandingFragment.this.bTm.getRealView());
                    SwanAppAdLandingFragment.this.bTm.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bTo.url)) {
                    SwanAppAdLandingFragment.this.bTo.url = str;
                }
                com.baidu.swan.apps.t.a.aoT().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bTo.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bTn);
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
    protected com.baidu.swan.apps.core.f.d abm() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.dy(SwanAppAdLandingFragment.this.bRR.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void ht(final String str) {
                SwanAppAdLandingFragment.this.dy(SwanAppAdLandingFragment.this.bRR.canGoBack());
                SwanAppAdLandingFragment.this.cho.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cho.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ai(View view) {
        super.ai(view);
        this.cho.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cho.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.ahA();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean abn() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (abk()) {
            this.bTi.iK("vplayend");
        }
        if (this.bTc != null) {
            this.bTc.onDestroy();
        }
        if (!this.bTD) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
