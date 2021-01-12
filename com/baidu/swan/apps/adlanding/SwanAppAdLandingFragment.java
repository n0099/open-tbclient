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
/* loaded from: classes8.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cBA;
    private String cBB;
    private String cBC;
    private String cBD;
    private com.baidu.swan.apps.media.b.a cBf;
    private JSONObject cBg;
    private b cBl;
    private FrameLayout cBm;
    private g cBp;
    private com.baidu.swan.apps.adlanding.download.a.a cBq;
    private com.baidu.swan.apps.adlanding.download.model.a cBr;
    private RelativeLayout cBt;
    private RelativeLayout cBu;
    private SimpleDraweeView cBv;
    private SimpleDraweeView cBw;
    private TextView cBx;
    private TextView cBy;
    private int cBz;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType cBk = LandingType.NORMAL;
    private String mFrom = "";
    private final String cBn = "swan-custom-ad";
    private final int cBo = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState cBs = SwanAdDownloadState.NOT_START;
    private int cBE = 0;
    private int cBF = 0;
    private boolean cBG = true;
    private View.OnClickListener cBH = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.cBz == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.cBl.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.cf(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.cBF;
        swanAppAdLandingFragment.cBF = i + 1;
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

    private void aiO() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.cBD = jSONObject.optString("w_picurl", "");
                    this.cBC = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.cBz = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.cBz == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.cBA = string;
                    this.cBB = jSONObject.optString("appname", "");
                    this.cBE = jSONObject.optInt("currentTime", 0);
                    this.cBg = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.cBk = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aiO();
        FragmentActivity bdH = bdH();
        if (bdH != null) {
            this.cBG = 1 == bdH.getRequestedOrientation();
            if (!this.cBG) {
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
        this.cBm = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        aiR();
        E(this.cBm);
        q(this.cBm);
        if (aiQ()) {
            aiP();
            D(this.cBm);
        }
        e(this.cBm);
        View az = aok() ? az(inflate) : inflate;
        this.cBl = new b(getContext(), this.cBg, this.cBf);
        this.cBl.jH("lpin");
        return a(az, this);
    }

    private void aiP() {
        d dVar = new d(this.cBD, this.mVideoUrl, this.cQD.aiA(), this.mVideoWidth, this.mVideoHeight, this.cBE);
        this.cBf = new com.baidu.swan.apps.media.b.a(getContext(), dVar.aiW());
        this.cBf.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.cBu.bringToFront();
                SwanAppAdLandingFragment.this.cBu.setVisibility(0);
                SwanAppAdLandingFragment.this.cBE = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.cBl.jH("vplayend");
                SwanAppAdLandingFragment.this.cBl.jH("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.cBl.jH("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.cBF == 0) {
                    SwanAppAdLandingFragment.this.cBl.jH("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.cBu.setVisibility(8);
                SwanAppAdLandingFragment.this.cBl.jH("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.cBl.jH("vpause");
            }
        });
        this.cBf.d(dVar.aiW());
        this.cBf.fP(false);
    }

    private void D(ViewGroup viewGroup) {
        this.cBt = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.cBu = (RelativeLayout) this.cBt.findViewById(a.f.ad_tail_root);
        this.cBv = (SimpleDraweeView) this.cBt.findViewById(a.f.ad_tail_video_img);
        this.cBw = (SimpleDraweeView) this.cBt.findViewById(a.f.ad_tail_head_image);
        this.cBx = (TextView) this.cBt.findViewById(a.f.ad_tail_brand_name);
        this.cBy = (TextView) this.cBt.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.cBA)) {
            this.cBy.setText(this.cBA);
            this.cBy.setVisibility(0);
        } else {
            this.cBy.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.cBB)) {
            this.cBx.setText(this.cBB);
            this.cBx.setVisibility(0);
        } else {
            this.cBx.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.cBC)) {
            this.cBw.setImageURI(Uri.parse(this.cBC));
            this.cBw.setVisibility(0);
        } else {
            this.cBw.setVisibility(8);
        }
        this.cBv.getHierarchy().A(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.cBD)) {
            this.cBv.setImageURI(t.tC(this.cBD));
        }
        this.cBv.setVisibility(0);
        this.cBv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.cBw.setOnClickListener(this.cBH);
        this.cBx.setOnClickListener(this.cBH);
        this.cBy.setOnClickListener(this.cBH);
        viewGroup.addView(this.cBu, layoutParams);
        this.cBu.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jI(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aLO().putString(this.cBr.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jJ(String str) {
        return h.aLO().getString(str, "");
    }

    private void E(final ViewGroup viewGroup) {
        g axs = com.baidu.swan.apps.t.a.axs();
        if (axs != null) {
            this.cBq = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eN(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.cBp.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.cBp.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.cBp.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void jK(String str) {
                    SwanAppAdLandingFragment.this.jI(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cBp.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.cBs != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.cBs == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cBl.jH("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.cBl.jH("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.cBs == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cBl.jH("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.cBl.jH("appdownloadfinish");
                            SwanAppAdLandingFragment.this.cBl.jH("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.cBl.jH("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.cBs = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cBp.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void aiU() {
                    SwanAppAdLandingFragment.this.cBl.jH("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String aiV() {
                    SwanAppAdLandingFragment.this.cBl.jH("appinstallopen");
                    return SwanAppAdLandingFragment.this.jJ(SwanAppAdLandingFragment.this.cBr.url);
                }
            };
            this.cBr = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.cBp = axs.a(getContext(), this.cBr, this.cBq);
            this.cBp.P(this.cBr);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void q(ViewGroup viewGroup) {
        this.cQD = air();
        this.cQD.a(aiS());
        this.czU = this.cQD.aiy();
        this.cQD.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.czU.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.rt("#FFFFFF");
        this.cQD.b(frameLayout, cVar);
        this.cQD.a(frameLayout, cVar);
        this.cQD.b(frameLayout, covertToView);
        if (aiQ()) {
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
        this.cQD.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.czU.getContentHeight()) * SwanAppAdLandingFragment.this.czU.getScale()) - ((float) SwanAppAdLandingFragment.this.czU.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.czU.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.cQD.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void gV(String str) {
                super.gV(str);
                if (Math.abs((SwanAppAdLandingFragment.this.czU.getContentHeight() * SwanAppAdLandingFragment.this.czU.getScale()) - SwanAppAdLandingFragment.this.czU.covertToView().getHeight()) < 10.0f) {
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
    public boolean ais() {
        if (isLandScape() && this.cBf != null) {
            return this.cBf.onBackPressed();
        }
        this.cBl.jH("lpout");
        return super.ais();
    }

    private boolean aiQ() {
        return this.cBk == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return bdH().getResources().getConfiguration().orientation == 2;
    }

    private void aiR() {
        DisplayMetrics displayMetrics = bdH().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(boolean z) {
        this.cPt.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f air() {
        e eVar = new e(getContext());
        eVar.aiy().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.cBp.ahM();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cBr.name)) {
                    String jJ = SwanAppAdLandingFragment.this.jJ(str);
                    SwanAppAdLandingFragment.this.cBr.name = jJ;
                    SwanAppAdLandingFragment.this.cBp.jD(jJ);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cBr.name)) {
                    SwanAppAdLandingFragment.this.cBm.removeView(SwanAppAdLandingFragment.this.cBp.getRealView());
                    SwanAppAdLandingFragment.this.cBm.addView(SwanAppAdLandingFragment.this.cBp.getRealView());
                    SwanAppAdLandingFragment.this.cBp.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cBr.url)) {
                    SwanAppAdLandingFragment.this.cBr.url = str;
                }
                com.baidu.swan.apps.t.a.awI().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cBr.aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.cBq);
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
    protected com.baidu.swan.apps.core.f.d aiS() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.eM(SwanAppAdLandingFragment.this.czU.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void hV(final String str) {
                SwanAppAdLandingFragment.this.eM(SwanAppAdLandingFragment.this.czU.canGoBack());
                SwanAppAdLandingFragment.this.cPt.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cPt.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void av(View view) {
        super.av(view);
        this.cPt.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cPt.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.apn();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (aiQ()) {
            this.cBl.jH("vplayend");
        }
        if (this.cBf != null) {
            this.cBf.onDestroy();
        }
        if (!this.cBG) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
