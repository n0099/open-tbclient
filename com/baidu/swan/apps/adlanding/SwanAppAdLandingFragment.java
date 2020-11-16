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
/* loaded from: classes7.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SimpleDraweeView cuA;
    private TextView cuB;
    private TextView cuC;
    private int cuD;
    private String cuE;
    private String cuF;
    private String cuG;
    private String cuH;
    private com.baidu.swan.apps.media.b.a cuh;
    private JSONObject cui;
    private b cun;
    private FrameLayout cuo;
    private g cus;
    private com.baidu.swan.apps.adlanding.download.a.a cuu;
    private com.baidu.swan.apps.adlanding.download.model.a cuv;
    private RelativeLayout cux;
    private RelativeLayout cuy;
    private SimpleDraweeView cuz;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType cum = LandingType.NORMAL;
    private String mFrom = "";
    private final String cup = "swan-custom-ad";
    private final int cuq = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState cuw = SwanAdDownloadState.NOT_START;
    private int cuI = 0;
    private int cuJ = 0;
    private boolean cuK = true;
    private View.OnClickListener cuL = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.cuD == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.cun.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.ca(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.cuJ;
        swanAppAdLandingFragment.cuJ = i + 1;
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

    private void aip() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.cuH = jSONObject.optString("w_picurl", "");
                    this.cuG = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.cuD = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.cuD == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.cuE = string;
                    this.cuF = jSONObject.optString("appname", "");
                    this.cuI = jSONObject.optInt("currentTime", 0);
                    this.cui = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.cum = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aip();
        FragmentActivity bca = bca();
        if (bca != null) {
            this.cuK = 1 == bca.getRequestedOrientation();
            if (!this.cuK) {
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
        ar(inflate);
        this.cuo = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        ais();
        B(this.cuo);
        n(this.cuo);
        if (air()) {
            aiq();
            A(this.cuo);
        }
        e(this.cuo);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.cun = new b(getContext(), this.cui, this.cuh);
        this.cun.ks("lpin");
        return enableSliding(initImmersion, this);
    }

    private void aiq() {
        d dVar = new d(this.cuH, this.mVideoUrl, this.cJz.aib(), this.mVideoWidth, this.mVideoHeight, this.cuI);
        this.cuh = new com.baidu.swan.apps.media.b.a(getContext(), dVar.aix());
        this.cuh.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.cuy.bringToFront();
                SwanAppAdLandingFragment.this.cuy.setVisibility(0);
                SwanAppAdLandingFragment.this.cuI = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.cun.ks("vplayend");
                SwanAppAdLandingFragment.this.cun.ks("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.cun.ks("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.cuJ == 0) {
                    SwanAppAdLandingFragment.this.cun.ks("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.cuy.setVisibility(8);
                SwanAppAdLandingFragment.this.cun.ks("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.cun.ks("vpause");
            }
        });
        this.cuh.d(dVar.aix());
        this.cuh.fv(false);
    }

    private void A(ViewGroup viewGroup) {
        this.cux = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.cuy = (RelativeLayout) this.cux.findViewById(a.f.ad_tail_root);
        this.cuz = (SimpleDraweeView) this.cux.findViewById(a.f.ad_tail_video_img);
        this.cuA = (SimpleDraweeView) this.cux.findViewById(a.f.ad_tail_head_image);
        this.cuB = (TextView) this.cux.findViewById(a.f.ad_tail_brand_name);
        this.cuC = (TextView) this.cux.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.cuE)) {
            this.cuC.setText(this.cuE);
            this.cuC.setVisibility(0);
        } else {
            this.cuC.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.cuF)) {
            this.cuB.setText(this.cuF);
            this.cuB.setVisibility(0);
        } else {
            this.cuB.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.cuG)) {
            this.cuA.setImageURI(Uri.parse(this.cuG));
            this.cuA.setVisibility(0);
        } else {
            this.cuA.setVisibility(8);
        }
        this.cuz.getHierarchy().s(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.cuH)) {
            this.cuz.setImageURI(t.getUri(this.cuH));
        }
        this.cuz.setVisibility(0);
        this.cuz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.cuA.setOnClickListener(this.cuL);
        this.cuB.setOnClickListener(this.cuL);
        this.cuC.setOnClickListener(this.cuL);
        viewGroup.addView(this.cuy, layoutParams);
        this.cuy.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aKk().putString(this.cuv.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ku(String str) {
        return h.aKk().getString(str, "");
    }

    private void B(final ViewGroup viewGroup) {
        g awM = com.baidu.swan.apps.t.a.awM();
        if (awM != null) {
            this.cuu = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void et(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.cus.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.cus.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.cus.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void kv(String str) {
                    SwanAppAdLandingFragment.this.kt(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cus.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.cuw != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.cuw == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cun.ks("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.cun.ks("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.cuw == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cun.ks("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.cun.ks("appdownloadfinish");
                            SwanAppAdLandingFragment.this.cun.ks("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.cun.ks("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.cuw = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cus.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void aiv() {
                    SwanAppAdLandingFragment.this.cun.ks("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String aiw() {
                    SwanAppAdLandingFragment.this.cun.ks("appinstallopen");
                    return SwanAppAdLandingFragment.this.ku(SwanAppAdLandingFragment.this.cuv.url);
                }
            };
            this.cuv = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.cus = awM.a(getContext(), this.cuv, this.cuu);
            this.cus.P(this.cuv);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void n(ViewGroup viewGroup) {
        this.cJz = ahS();
        this.cJz.a(ait());
        this.csU = this.cJz.ahZ();
        this.cJz.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.csU.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.sa("#FFFFFF");
        this.cJz.b(frameLayout, cVar);
        this.cJz.a(frameLayout, cVar);
        this.cJz.b(frameLayout, covertToView);
        if (air()) {
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
    public boolean aq(View view) {
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
        this.cJz.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.csU.getContentHeight()) * SwanAppAdLandingFragment.this.csU.getScale()) - ((float) SwanAppAdLandingFragment.this.csU.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.csU.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.cJz.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void hP(String str) {
                super.hP(str);
                if (Math.abs((SwanAppAdLandingFragment.this.csU.getContentHeight() * SwanAppAdLandingFragment.this.csU.getScale()) - SwanAppAdLandingFragment.this.csU.covertToView().getHeight()) < 10.0f) {
                    customerAdScrollView.setIsWebViewOnBottom(true);
                } else {
                    customerAdScrollView.setIsWebViewOnBottom(false);
                }
            }
        });
        customerAdScrollView.setScrollViewListener(new com.baidu.swan.apps.adlanding.customer.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.10
            @Override // com.baidu.swan.apps.adlanding.customer.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.aq(linearLayout));
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean ahT() {
        if (isLandScape() && this.cuh != null) {
            return this.cuh.onBackPressed();
        }
        this.cun.ks("lpout");
        return super.ahT();
    }

    private boolean air() {
        return this.cum == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return bca().getResources().getConfiguration().orientation == 2;
    }

    private void ais() {
        DisplayMetrics displayMetrics = bca().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        this.cIr.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f ahS() {
        e eVar = new e(getContext());
        eVar.ahZ().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.cus.ahn();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cuv.name)) {
                    String ku = SwanAppAdLandingFragment.this.ku(str);
                    SwanAppAdLandingFragment.this.cuv.name = ku;
                    SwanAppAdLandingFragment.this.cus.ko(ku);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cuv.name)) {
                    SwanAppAdLandingFragment.this.cuo.removeView(SwanAppAdLandingFragment.this.cus.getRealView());
                    SwanAppAdLandingFragment.this.cuo.addView(SwanAppAdLandingFragment.this.cus.getRealView());
                    SwanAppAdLandingFragment.this.cus.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cuv.url)) {
                    SwanAppAdLandingFragment.this.cuv.url = str;
                }
                com.baidu.swan.apps.t.a.awc().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cuv.aiy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.cuu);
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
    protected com.baidu.swan.apps.core.f.d ait() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.es(SwanAppAdLandingFragment.this.csU.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iJ(final String str) {
                SwanAppAdLandingFragment.this.es(SwanAppAdLandingFragment.this.csU.canGoBack());
                SwanAppAdLandingFragment.this.cIr.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cIr.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ar(View view) {
        super.ar(view);
        this.cIr.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cIr.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.aoH();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean aiu() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (air()) {
            this.cun.ks("vplayend");
        }
        if (this.cuh != null) {
            this.cuh.onDestroy();
        }
        if (!this.cuK) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
