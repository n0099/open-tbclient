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
    private com.baidu.swan.apps.media.b.a cvT;
    private JSONObject cvU;
    private b cvZ;
    private FrameLayout cwa;
    private g cwd;
    private com.baidu.swan.apps.adlanding.download.a.a cwe;
    private com.baidu.swan.apps.adlanding.download.model.a cwf;
    private RelativeLayout cwh;
    private RelativeLayout cwi;
    private SimpleDraweeView cwj;
    private SimpleDraweeView cwk;
    private TextView cwl;
    private TextView cwm;
    private int cwn;
    private String cwo;
    private String cwp;
    private String cwq;
    private String cwr;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType cvY = LandingType.NORMAL;
    private String mFrom = "";
    private final String cwb = "swan-custom-ad";
    private final int cwc = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState cwg = SwanAdDownloadState.NOT_START;
    private int cws = 0;
    private int cwt = 0;
    private boolean cwu = true;
    private View.OnClickListener cwv = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.cwn == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.cvZ.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.cb(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.cwt;
        swanAppAdLandingFragment.cwt = i + 1;
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

    private void aiX() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.cwr = jSONObject.optString("w_picurl", "");
                    this.cwq = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.cwn = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.cwn == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.cwo = string;
                    this.cwp = jSONObject.optString("appname", "");
                    this.cws = jSONObject.optInt("currentTime", 0);
                    this.cvU = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.cvY = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aiX();
        FragmentActivity bcH = bcH();
        if (bcH != null) {
            this.cwu = 1 == bcH.getRequestedOrientation();
            if (!this.cwu) {
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
        this.cwa = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        aja();
        F(this.cwa);
        r(this.cwa);
        if (aiZ()) {
            aiY();
            E(this.cwa);
        }
        e(this.cwa);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.cvZ = new b(getContext(), this.cvU, this.cvT);
        this.cvZ.ky("lpin");
        return enableSliding(initImmersion, this);
    }

    private void aiY() {
        d dVar = new d(this.cwr, this.mVideoUrl, this.cLj.aiJ(), this.mVideoWidth, this.mVideoHeight, this.cws);
        this.cvT = new com.baidu.swan.apps.media.b.a(getContext(), dVar.ajf());
        this.cvT.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.cwi.bringToFront();
                SwanAppAdLandingFragment.this.cwi.setVisibility(0);
                SwanAppAdLandingFragment.this.cws = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.cvZ.ky("vplayend");
                SwanAppAdLandingFragment.this.cvZ.ky("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.cvZ.ky("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.cwt == 0) {
                    SwanAppAdLandingFragment.this.cvZ.ky("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.cwi.setVisibility(8);
                SwanAppAdLandingFragment.this.cvZ.ky("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.cvZ.ky("vpause");
            }
        });
        this.cvT.d(dVar.ajf());
        this.cvT.fs(false);
    }

    private void E(ViewGroup viewGroup) {
        this.cwh = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.cwi = (RelativeLayout) this.cwh.findViewById(a.f.ad_tail_root);
        this.cwj = (SimpleDraweeView) this.cwh.findViewById(a.f.ad_tail_video_img);
        this.cwk = (SimpleDraweeView) this.cwh.findViewById(a.f.ad_tail_head_image);
        this.cwl = (TextView) this.cwh.findViewById(a.f.ad_tail_brand_name);
        this.cwm = (TextView) this.cwh.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.cwo)) {
            this.cwm.setText(this.cwo);
            this.cwm.setVisibility(0);
        } else {
            this.cwm.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.cwp)) {
            this.cwl.setText(this.cwp);
            this.cwl.setVisibility(0);
        } else {
            this.cwl.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.cwq)) {
            this.cwk.setImageURI(Uri.parse(this.cwq));
            this.cwk.setVisibility(0);
        } else {
            this.cwk.setVisibility(8);
        }
        this.cwj.getHierarchy().r(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.cwr)) {
            this.cwj.setImageURI(t.getUri(this.cwr));
        }
        this.cwj.setVisibility(0);
        this.cwj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.cwk.setOnClickListener(this.cwv);
        this.cwl.setOnClickListener(this.cwv);
        this.cwm.setOnClickListener(this.cwv);
        viewGroup.addView(this.cwi, layoutParams);
        this.cwi.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aKS().putString(this.cwf.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kA(String str) {
        return h.aKS().getString(str, "");
    }

    private void F(final ViewGroup viewGroup) {
        g axu = com.baidu.swan.apps.t.a.axu();
        if (axu != null) {
            this.cwe = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eq(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.cwd.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.cwd.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.cwd.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void kB(String str) {
                    SwanAppAdLandingFragment.this.kz(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cwd.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.cwg != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.cwg == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cvZ.ky("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.cvZ.ky("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.cwg == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cvZ.ky("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.cvZ.ky("appdownloadfinish");
                            SwanAppAdLandingFragment.this.cvZ.ky("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.cvZ.ky("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.cwg = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cwd.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void ajd() {
                    SwanAppAdLandingFragment.this.cvZ.ky("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String aje() {
                    SwanAppAdLandingFragment.this.cvZ.ky("appinstallopen");
                    return SwanAppAdLandingFragment.this.kA(SwanAppAdLandingFragment.this.cwf.url);
                }
            };
            this.cwf = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.cwd = axu.a(getContext(), this.cwf, this.cwe);
            this.cwd.P(this.cwf);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void r(ViewGroup viewGroup) {
        this.cLj = aiA();
        this.cLj.a(ajb());
        this.cuI = this.cLj.aiH();
        this.cLj.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.cuI.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.fv("#FFFFFF");
        this.cLj.b(frameLayout, cVar);
        this.cLj.a(frameLayout, cVar);
        this.cLj.b(frameLayout, covertToView);
        if (aiZ()) {
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
        this.cLj.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.cuI.getContentHeight()) * SwanAppAdLandingFragment.this.cuI.getScale()) - ((float) SwanAppAdLandingFragment.this.cuI.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.cuI.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.cLj.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void hV(String str) {
                super.hV(str);
                if (Math.abs((SwanAppAdLandingFragment.this.cuI.getContentHeight() * SwanAppAdLandingFragment.this.cuI.getScale()) - SwanAppAdLandingFragment.this.cuI.covertToView().getHeight()) < 10.0f) {
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
    public boolean aiB() {
        if (isLandScape() && this.cvT != null) {
            return this.cvT.onBackPressed();
        }
        this.cvZ.ky("lpout");
        return super.aiB();
    }

    private boolean aiZ() {
        return this.cvY == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return bcH().getResources().getConfiguration().orientation == 2;
    }

    private void aja() {
        DisplayMetrics displayMetrics = bcH().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(boolean z) {
        this.cKb.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f aiA() {
        e eVar = new e(getContext());
        eVar.aiH().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.cwd.ahV();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cwf.name)) {
                    String kA = SwanAppAdLandingFragment.this.kA(str);
                    SwanAppAdLandingFragment.this.cwf.name = kA;
                    SwanAppAdLandingFragment.this.cwd.ku(kA);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cwf.name)) {
                    SwanAppAdLandingFragment.this.cwa.removeView(SwanAppAdLandingFragment.this.cwd.getRealView());
                    SwanAppAdLandingFragment.this.cwa.addView(SwanAppAdLandingFragment.this.cwd.getRealView());
                    SwanAppAdLandingFragment.this.cwd.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cwf.url)) {
                    SwanAppAdLandingFragment.this.cwf.url = str;
                }
                com.baidu.swan.apps.t.a.awK().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cwf.ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.cwe);
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
    protected com.baidu.swan.apps.core.f.d ajb() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.ep(SwanAppAdLandingFragment.this.cuI.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iP(final String str) {
                SwanAppAdLandingFragment.this.ep(SwanAppAdLandingFragment.this.cuI.canGoBack());
                SwanAppAdLandingFragment.this.cKb.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cKb.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ar(View view) {
        super.ar(view);
        this.cKb.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cKb.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.apq();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (aiZ()) {
            this.cvZ.ky("vplayend");
        }
        if (this.cvT != null) {
            this.cvT.onDestroy();
        }
        if (!this.cwu) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
