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
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.t;
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
/* loaded from: classes7.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.b.a bNE;
    private JSONObject bNF;
    private b bNK;
    private FrameLayout bNL;
    private g bNO;
    private com.baidu.swan.apps.adlanding.download.a.a bNP;
    private com.baidu.swan.apps.adlanding.download.model.a bNQ;
    private RelativeLayout bNS;
    private RelativeLayout bNT;
    private SimpleDraweeView bNU;
    private SimpleDraweeView bNV;
    private TextView bNW;
    private TextView bNX;
    private int bNY;
    private String bNZ;
    private String bOa;
    private String bOb;
    private String bOc;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType bNJ = LandingType.NORMAL;
    private String mFrom = "";
    private final String bNM = "swan-custom-ad";
    private final int bNN = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState bNR = SwanAdDownloadState.NOT_START;
    private int bOd = 0;
    private int bOe = 0;
    private boolean bOf = true;
    private View.OnClickListener bOg = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.bNY == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.bNK.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.bB(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.bOe;
        swanAppAdLandingFragment.bOe = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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

    private void Vd() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.bOc = jSONObject.optString("w_picurl", "");
                    this.bOb = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.bNY = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.bNY == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.bNZ = string;
                    this.bOa = jSONObject.optString("appname", "");
                    this.bOd = jSONObject.optInt("currentTime", 0);
                    this.bNF = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.bNJ = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Vd();
        FragmentActivity aMt = aMt();
        if (aMt != null) {
            this.bOf = 1 == aMt.getRequestedOrientation();
            if (!this.bOf) {
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
        ah(inflate);
        this.bNL = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        Vg();
        w(this.bNL);
        x(this.bNL);
        if (Vf()) {
            Ve();
            v(this.bNL);
        }
        a(this.bNL);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.bNK = new b(getContext(), this.bNF, this.bNE);
        this.bNK.hp("lpin");
        return enableSliding(initImmersion, this);
    }

    private void Ve() {
        d dVar = new d(this.bOc, this.mVideoUrl, this.ccA.UR(), this.mVideoWidth, this.mVideoHeight, this.bOd);
        this.bNE = new com.baidu.swan.apps.media.b.a(getContext(), dVar.Vk());
        this.bNE.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.bNT.bringToFront();
                SwanAppAdLandingFragment.this.bNT.setVisibility(0);
                SwanAppAdLandingFragment.this.bOd = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.bNK.hp("vplayend");
                SwanAppAdLandingFragment.this.bNK.hp("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.bNK.hp("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.bOe == 0) {
                    SwanAppAdLandingFragment.this.bNK.hp("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.bNT.setVisibility(8);
                SwanAppAdLandingFragment.this.bNK.hp("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.bNK.hp("vpause");
            }
        });
        this.bNE.d(dVar.Vk());
        this.bNE.ej(false);
    }

    private void v(ViewGroup viewGroup) {
        this.bNS = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.bNT = (RelativeLayout) this.bNS.findViewById(a.f.ad_tail_root);
        this.bNU = (SimpleDraweeView) this.bNS.findViewById(a.f.ad_tail_video_img);
        this.bNV = (SimpleDraweeView) this.bNS.findViewById(a.f.ad_tail_head_image);
        this.bNW = (TextView) this.bNS.findViewById(a.f.ad_tail_brand_name);
        this.bNX = (TextView) this.bNS.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.bNZ)) {
            this.bNX.setText(this.bNZ);
            this.bNX.setVisibility(0);
        } else {
            this.bNX.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.bOa)) {
            this.bNW.setText(this.bOa);
            this.bNW.setVisibility(0);
        } else {
            this.bNW.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.bOb)) {
            this.bNV.setImageURI(Uri.parse(this.bOb));
            this.bNV.setVisibility(0);
        } else {
            this.bNV.setVisibility(8);
        }
        this.bNU.getHierarchy().m(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.bOc)) {
            this.bNU.setImageURI(t.getUri(this.bOc));
        }
        this.bNU.setVisibility(0);
        this.bNU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.bNV.setOnClickListener(this.bOg);
        this.bNW.setOnClickListener(this.bOg);
        this.bNX.setOnClickListener(this.bOg);
        viewGroup.addView(this.bNT, layoutParams);
        this.bNT.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hq(String str) {
        return h.auW().getString(str, "");
    }

    private void w(final ViewGroup viewGroup) {
        g aic = com.baidu.swan.apps.t.a.aic();
        if (aic != null && this.bNO != null) {
            this.bNP = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void Vj() {
                    SwanAppAdLandingFragment.this.bNK.hp("appinstallbegin");
                }
            };
            this.bNQ = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.bNO = aic.a(getContext(), this.bNQ, this.bNP);
            this.bNO.K(this.bNQ);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void x(ViewGroup viewGroup) {
        this.ccA = UI();
        this.ccA.a(Vh());
        this.bMv = this.ccA.UP();
        this.ccA.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.bMv.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.dU("#FFFFFF");
        this.ccA.b(frameLayout, cVar);
        this.ccA.a(frameLayout, cVar);
        this.ccA.a(frameLayout, covertToView);
        if (Vf()) {
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
    public boolean ag(View view) {
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
        this.ccA.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.bMv.getContentHeight()) * SwanAppAdLandingFragment.this.bMv.getScale()) - ((float) SwanAppAdLandingFragment.this.bMv.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.bMv.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.ccA.a(new com.baidu.swan.apps.core.e() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.e
            public void fH(String str) {
                super.fH(str);
                if (Math.abs((SwanAppAdLandingFragment.this.bMv.getContentHeight() * SwanAppAdLandingFragment.this.bMv.getScale()) - SwanAppAdLandingFragment.this.bMv.covertToView().getHeight()) < 10.0f) {
                    customerAdScrollView.setIsWebViewOnBottom(true);
                } else {
                    customerAdScrollView.setIsWebViewOnBottom(false);
                }
            }
        });
        customerAdScrollView.setScrollViewListener(new com.baidu.swan.apps.adlanding.customer.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.10
            @Override // com.baidu.swan.apps.adlanding.customer.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.ag(linearLayout));
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        if (isLandScape() && this.bNE != null) {
            return this.bNE.onBackPressed();
        }
        this.bNK.hp("lpout");
        return super.UJ();
    }

    private boolean Vf() {
        return this.bNJ == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return aMt().getResources().getConfiguration().orientation == 2;
    }

    private void Vg() {
        DisplayMetrics displayMetrics = aMt().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(boolean z) {
        this.cbt.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f UI() {
        e eVar = new e(getContext());
        eVar.UP().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                if (SwanAppAdLandingFragment.this.bNO != null) {
                    SwanAppAdLandingFragment.this.bNO.Tk();
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bNQ.name)) {
                        String hq = SwanAppAdLandingFragment.this.hq(str);
                        SwanAppAdLandingFragment.this.bNQ.name = hq;
                        SwanAppAdLandingFragment.this.bNO.hl(hq);
                    }
                    if (al.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bNQ.name)) {
                        SwanAppAdLandingFragment.this.bNL.removeView(SwanAppAdLandingFragment.this.bNO.getRealView());
                        SwanAppAdLandingFragment.this.bNL.addView(SwanAppAdLandingFragment.this.bNO.getRealView());
                        SwanAppAdLandingFragment.this.bNO.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.bNQ.url)) {
                        SwanAppAdLandingFragment.this.bNQ.url = str;
                    }
                    com.baidu.swan.apps.t.a.aht().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.bNQ.Vl(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.bNP);
                }
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
    protected com.baidu.swan.apps.core.f.d Vh() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.dq(SwanAppAdLandingFragment.this.bMv.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void fY(final String str) {
                SwanAppAdLandingFragment.this.dq(SwanAppAdLandingFragment.this.bMv.canGoBack());
                SwanAppAdLandingFragment.this.cbt.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cbt.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ah(View view) {
        super.ah(view);
        this.cbt.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cbt.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.abo();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (Vf()) {
            this.bNK.hp("vplayend");
        }
        if (this.bNE != null) {
            this.bNE.onDestroy();
        }
        if (!this.bOf) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
