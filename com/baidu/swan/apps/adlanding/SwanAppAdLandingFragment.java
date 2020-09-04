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
    private int bTA;
    private String bTB;
    private String bTC;
    private String bTD;
    private String bTE;
    private com.baidu.swan.apps.media.b.a bTg;
    private JSONObject bTh;
    private b bTm;
    private FrameLayout bTn;
    private g bTq;
    private com.baidu.swan.apps.adlanding.download.a.a bTr;
    private com.baidu.swan.apps.adlanding.download.model.a bTs;
    private RelativeLayout bTu;
    private RelativeLayout bTv;
    private SimpleDraweeView bTw;
    private SimpleDraweeView bTx;
    private TextView bTy;
    private TextView bTz;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bTl = LandingType.NORMAL;
    private String mFrom = "";
    private final String bTo = "swan-custom-ad";
    private final int bTp = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bTt = SwanAdDownloadState.NOT_START;
    private int bTF = 0;
    private int bTG = 0;
    private boolean bTH = true;
    private View.OnClickListener bTI = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bTA == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bTm.d("c", hashMap);
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
        int i = swanAppAdLandingFragment.bTG;
        swanAppAdLandingFragment.bTG = i + 1;
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
                    this.bTE = jSONObject.optString("w_picurl", "");
                    this.bTD = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bTA = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bTA == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bTB = string;
                    this.bTC = jSONObject.optString("appname", "");
                    this.bTF = jSONObject.optInt("currentTime", 0);
                    this.bTh = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bTl = LandingType.VIDEO;
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
            this.bTH = 1 == aUT.getRequestedOrientation();
            if (!this.bTH) {
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
        this.bTn = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        abl();
        x(this.bTn);
        y(this.bTn);
        if (abk()) {
            abj();
            w(this.bTn);
        }
        a(this.bTn);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bTm = new b(getContext(), this.bTh, this.bTg);
        this.bTm.iL("lpin");
        return enableSliding(initImmersion, this);
    }

    private void abj() {
        d dVar = new d(this.bTE, this.mVideoUrl, this.ciB.aaU(), this.mVideoWidth, this.mVideoHeight, this.bTF);
        this.bTg = new com.baidu.swan.apps.media.b.a(getContext(), dVar.abq());
        this.bTg.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.bTv.bringToFront();
                SwanAppAdLandingFragment.this.bTv.setVisibility(0);
                SwanAppAdLandingFragment.this.bTF = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bTm.iL("vplayend");
                SwanAppAdLandingFragment.this.bTm.iL("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.bTm.iL("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.bTG == 0) {
                    SwanAppAdLandingFragment.this.bTm.iL("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.bTv.setVisibility(8);
                SwanAppAdLandingFragment.this.bTm.iL("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.bTm.iL("vpause");
            }
        });
        this.bTg.d(dVar.abq());
        this.bTg.eC(false);
    }

    private void w(ViewGroup viewGroup) {
        this.bTu = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bTv = (RelativeLayout) this.bTu.findViewById(a.f.ad_tail_root);
        this.bTw = (SimpleDraweeView) this.bTu.findViewById(a.f.ad_tail_video_img);
        this.bTx = (SimpleDraweeView) this.bTu.findViewById(a.f.ad_tail_head_image);
        this.bTy = (TextView) this.bTu.findViewById(a.f.ad_tail_brand_name);
        this.bTz = (TextView) this.bTu.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bTB)) {
            this.bTz.setText(this.bTB);
            this.bTz.setVisibility(0);
        } else {
            this.bTz.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bTC)) {
            this.bTy.setText(this.bTC);
            this.bTy.setVisibility(0);
        } else {
            this.bTy.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bTD)) {
            this.bTx.setImageURI(Uri.parse(this.bTD));
            this.bTx.setVisibility(0);
        } else {
            this.bTx.setVisibility(8);
        }
        this.bTw.getHierarchy().m(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bTE)) {
            this.bTw.setImageURI(t.getUri(this.bTE));
        }
        this.bTw.setVisibility(0);
        this.bTw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bTx.setOnClickListener(this.bTI);
        this.bTy.setOnClickListener(this.bTI);
        this.bTz.setOnClickListener(this.bTI);
        viewGroup.addView(this.bTv, layoutParams);
        this.bTv.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aDf().putString(this.bTs.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iN(String str) {
        return h.aDf().getString(str, "");
    }

    private void x(final ViewGroup viewGroup) {
        g apE = com.baidu.swan.apps.t.a.apE();
        if (apE != null) {
            this.bTr = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void dA(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.bTq.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.bTq.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.bTq.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void iO(String str) {
                    SwanAppAdLandingFragment.this.iM(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.bTq.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.bTt != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.bTt == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.bTm.iL("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.bTm.iL("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.bTt == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.bTm.iL("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.bTm.iL("appdownloadfinish");
                            SwanAppAdLandingFragment.this.bTm.iL("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.bTm.iL("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.bTt = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.bTq.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void abo() {
                    SwanAppAdLandingFragment.this.bTm.iL("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String abp() {
                    SwanAppAdLandingFragment.this.bTm.iL("appinstallopen");
                    return SwanAppAdLandingFragment.this.iN(SwanAppAdLandingFragment.this.bTs.url);
                }
            };
            this.bTs = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.bTq = apE.a(getContext(), this.bTs, this.bTr);
            this.bTq.L(this.bTs);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void y(ViewGroup viewGroup) {
        this.ciB = aaL();
        this.ciB.a(abm());
        this.bRV = this.ciB.aaS();
        this.ciB.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.bRV.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.fo("#FFFFFF");
        this.ciB.b(frameLayout, cVar);
        this.ciB.a(frameLayout, cVar);
        this.ciB.a(frameLayout, covertToView);
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
        this.ciB.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.bRV.getContentHeight()) * SwanAppAdLandingFragment.this.bRV.getScale()) - ((float) SwanAppAdLandingFragment.this.bRV.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.bRV.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.ciB.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void ht(String str) {
                super.ht(str);
                if (Math.abs((SwanAppAdLandingFragment.this.bRV.getContentHeight() * SwanAppAdLandingFragment.this.bRV.getScale()) - SwanAppAdLandingFragment.this.bRV.covertToView().getHeight()) < 10.0f) {
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
        if (isLandScape() && this.bTg != null) {
            return this.bTg.onBackPressed();
        }
        this.bTm.iL("lpout");
        return super.aaM();
    }

    private boolean abk() {
        return this.bTl == LandingType.VIDEO;
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
    public void dz(boolean z) {
        this.chs.setLeftHomeViewVisibility(z ? 0 : 8);
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
                SwanAppAdLandingFragment.this.bTq.aag();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bTs.name)) {
                    String iN = SwanAppAdLandingFragment.this.iN(str);
                    SwanAppAdLandingFragment.this.bTs.name = iN;
                    SwanAppAdLandingFragment.this.bTq.iH(iN);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bTs.name)) {
                    SwanAppAdLandingFragment.this.bTn.removeView(SwanAppAdLandingFragment.this.bTq.getRealView());
                    SwanAppAdLandingFragment.this.bTn.addView(SwanAppAdLandingFragment.this.bTq.getRealView());
                    SwanAppAdLandingFragment.this.bTq.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bTs.url)) {
                    SwanAppAdLandingFragment.this.bTs.url = str;
                }
                com.baidu.swan.apps.t.a.aoT().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bTs.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bTr);
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
                SwanAppAdLandingFragment.this.dz(SwanAppAdLandingFragment.this.bRV.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void hu(final String str) {
                SwanAppAdLandingFragment.this.dz(SwanAppAdLandingFragment.this.bRV.canGoBack());
                SwanAppAdLandingFragment.this.chs.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.chs.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ai(View view) {
        super.ai(view);
        this.chs.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.chs.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
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
            this.bTm.iL("vplayend");
        }
        if (this.bTg != null) {
            this.bTg.onDestroy();
        }
        if (!this.bTH) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
