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
/* loaded from: classes10.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b chA;
    private FrameLayout chB;
    private g chE;
    private com.baidu.swan.apps.adlanding.download.a.a chF;
    private com.baidu.swan.apps.adlanding.download.model.a chG;
    private RelativeLayout chI;
    private RelativeLayout chJ;
    private SimpleDraweeView chK;
    private SimpleDraweeView chL;
    private TextView chM;
    private TextView chN;
    private int chO;
    private String chP;
    private String chQ;
    private String chR;
    private String chS;
    private com.baidu.swan.apps.media.b.a chu;
    private JSONObject chv;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType chz = LandingType.NORMAL;
    private String mFrom = "";
    private final String chC = "swan-custom-ad";
    private final int chD = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState chH = SwanAdDownloadState.NOT_START;
    private int chT = 0;
    private int chU = 0;
    private boolean chV = true;
    private View.OnClickListener chW = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.chO == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.chA.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.bU(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.chU;
        swanAppAdLandingFragment.chU = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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

    private void aeD() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.chS = jSONObject.optString("w_picurl", "");
                    this.chR = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.chO = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.chO == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.chP = string;
                    this.chQ = jSONObject.optString("appname", "");
                    this.chT = jSONObject.optInt("currentTime", 0);
                    this.chv = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.chz = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aeD();
        FragmentActivity aYo = aYo();
        if (aYo != null) {
            this.chV = 1 == aYo.getRequestedOrientation();
            if (!this.chV) {
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
        al(inflate);
        this.chB = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        aeG();
        C(this.chB);
        q(this.chB);
        if (aeF()) {
            aeE();
            B(this.chB);
        }
        b(this.chB);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.chA = new b(getContext(), this.chv, this.chu);
        this.chA.jQ("lpin");
        return enableSliding(initImmersion, this);
    }

    private void aeE() {
        d dVar = new d(this.chS, this.mVideoUrl, this.cwU.aep(), this.mVideoWidth, this.mVideoHeight, this.chT);
        this.chu = new com.baidu.swan.apps.media.b.a(getContext(), dVar.aeL());
        this.chu.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.chJ.bringToFront();
                SwanAppAdLandingFragment.this.chJ.setVisibility(0);
                SwanAppAdLandingFragment.this.chT = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.chA.jQ("vplayend");
                SwanAppAdLandingFragment.this.chA.jQ("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.chA.jQ("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.chU == 0) {
                    SwanAppAdLandingFragment.this.chA.jQ("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.chJ.setVisibility(8);
                SwanAppAdLandingFragment.this.chA.jQ("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.chA.jQ("vpause");
            }
        });
        this.chu.d(dVar.aeL());
        this.chu.eW(false);
    }

    private void B(ViewGroup viewGroup) {
        this.chI = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.chJ = (RelativeLayout) this.chI.findViewById(a.f.ad_tail_root);
        this.chK = (SimpleDraweeView) this.chI.findViewById(a.f.ad_tail_video_img);
        this.chL = (SimpleDraweeView) this.chI.findViewById(a.f.ad_tail_head_image);
        this.chM = (TextView) this.chI.findViewById(a.f.ad_tail_brand_name);
        this.chN = (TextView) this.chI.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.chP)) {
            this.chN.setText(this.chP);
            this.chN.setVisibility(0);
        } else {
            this.chN.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.chQ)) {
            this.chM.setText(this.chQ);
            this.chM.setVisibility(0);
        } else {
            this.chM.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.chR)) {
            this.chL.setImageURI(Uri.parse(this.chR));
            this.chL.setVisibility(0);
        } else {
            this.chL.setVisibility(8);
        }
        this.chK.getHierarchy().m(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.chS)) {
            this.chK.setImageURI(t.getUri(this.chS));
        }
        this.chK.setVisibility(0);
        this.chK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.chL.setOnClickListener(this.chW);
        this.chM.setOnClickListener(this.chW);
        this.chN.setOnClickListener(this.chW);
        viewGroup.addView(this.chJ, layoutParams);
        this.chJ.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jR(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aGy().putString(this.chG.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jS(String str) {
        return h.aGy().getString(str, "");
    }

    private void C(final ViewGroup viewGroup) {
        g ata = com.baidu.swan.apps.t.a.ata();
        if (ata != null) {
            this.chF = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void dU(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.chE.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.chE.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.chE.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void jT(String str) {
                    SwanAppAdLandingFragment.this.jR(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.chE.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.chH != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.chH == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.chA.jQ("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.chA.jQ("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.chH == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.chA.jQ("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.chA.jQ("appdownloadfinish");
                            SwanAppAdLandingFragment.this.chA.jQ("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.chA.jQ("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.chH = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.chE.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void aeJ() {
                    SwanAppAdLandingFragment.this.chA.jQ("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String aeK() {
                    SwanAppAdLandingFragment.this.chA.jQ("appinstallopen");
                    return SwanAppAdLandingFragment.this.jS(SwanAppAdLandingFragment.this.chG.url);
                }
            };
            this.chG = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.chE = ata.a(getContext(), this.chG, this.chF);
            this.chE.P(this.chG);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void q(ViewGroup viewGroup) {
        this.cwU = aeg();
        this.cwU.a(aeH());
        this.cgj = this.cwU.aen();
        this.cwU.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.cgj.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.fv("#FFFFFF");
        this.cwU.b(frameLayout, cVar);
        this.cwU.a(frameLayout, cVar);
        this.cwU.a(frameLayout, covertToView);
        if (aeF()) {
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
    public boolean ak(View view) {
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
        this.cwU.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.cgj.getContentHeight()) * SwanAppAdLandingFragment.this.cgj.getScale()) - ((float) SwanAppAdLandingFragment.this.cgj.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.cgj.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.cwU.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void hG(String str) {
                super.hG(str);
                if (Math.abs((SwanAppAdLandingFragment.this.cgj.getContentHeight() * SwanAppAdLandingFragment.this.cgj.getScale()) - SwanAppAdLandingFragment.this.cgj.covertToView().getHeight()) < 10.0f) {
                    customerAdScrollView.setIsWebViewOnBottom(true);
                } else {
                    customerAdScrollView.setIsWebViewOnBottom(false);
                }
            }
        });
        customerAdScrollView.setScrollViewListener(new com.baidu.swan.apps.adlanding.customer.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.10
            @Override // com.baidu.swan.apps.adlanding.customer.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.ak(linearLayout));
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean aeh() {
        if (isLandScape() && this.chu != null) {
            return this.chu.onBackPressed();
        }
        this.chA.jQ("lpout");
        return super.aeh();
    }

    private boolean aeF() {
        return this.chz == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return aYo().getResources().getConfiguration().orientation == 2;
    }

    private void aeG() {
        DisplayMetrics displayMetrics = aYo().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(boolean z) {
        this.cvM.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f aeg() {
        e eVar = new e(getContext());
        eVar.aen().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.chE.adB();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.chG.name)) {
                    String jS = SwanAppAdLandingFragment.this.jS(str);
                    SwanAppAdLandingFragment.this.chG.name = jS;
                    SwanAppAdLandingFragment.this.chE.jM(jS);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.chG.name)) {
                    SwanAppAdLandingFragment.this.chB.removeView(SwanAppAdLandingFragment.this.chE.getRealView());
                    SwanAppAdLandingFragment.this.chB.addView(SwanAppAdLandingFragment.this.chE.getRealView());
                    SwanAppAdLandingFragment.this.chE.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.chG.url)) {
                    SwanAppAdLandingFragment.this.chG.url = str;
                }
                com.baidu.swan.apps.t.a.asq().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.chG.aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.chF);
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
    protected com.baidu.swan.apps.core.f.d aeH() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.dT(SwanAppAdLandingFragment.this.cgj.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void ir(final String str) {
                SwanAppAdLandingFragment.this.dT(SwanAppAdLandingFragment.this.cgj.canGoBack());
                SwanAppAdLandingFragment.this.cvM.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cvM.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void al(View view) {
        super.al(view);
        this.cvM.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cvM.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.akV();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean aeI() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (aeF()) {
            this.chA.jQ("vplayend");
        }
        if (this.chu != null) {
            this.chu.onDestroy();
        }
        if (!this.chV) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
